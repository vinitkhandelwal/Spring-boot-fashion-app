package com.ecommerce.fashionrent.repository;

import com.ecommerce.fashionrent.dto.specification.ProductDtoSpecification;
import com.ecommerce.fashionrent.entity.ProductLenders;
import org.hibernate.annotations.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductLenders, Integer> {


    @Query(value = """
            with productimage as (
               select array_agg(imageurl) AS result_array,productid from productimageurl p2 group by productid)
               select p.id as productId, p.productname as productName, p.rrp, p.rentprice as rentPrice,
               p.brand, p.ocassion as occasion, p.category,p.type as type,p.fit as fit,p.size,
               pi.result_array as imageUrl from productlenders p
               join productimage pi ON pi.productid = p.id  
             """, nativeQuery = true
    )
    public List<ProductDtoSpecification> getAllProducts(
    );

}
