package shop.metacoding.mallprojectpractice1.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.qlrm.mapper.JpaResultMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import shop.metacoding.mallprojectpractice1.model.ProductDTO;

@Repository
public class ProductRepository {

    @Autowired
    private EntityManager em;

    public ProductDTO findByIProductDTO(int id){
        Query query = em.createNativeQuery("select id, name, price, qty, '설명' des from product_tb where id =:id");
        query.setParameter("id", id);
        JpaResultMapper mapper = new JpaResultMapper();
        ProductDTO productDTO = mapper.uniqueResult(query, ProductDTO.class);
        return productDTO;

    }

    
}
