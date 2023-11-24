package com.ecommerce.fashionrent.repository;

import com.ecommerce.fashionrent.dto.specification.ProductDtoSpecification;
import com.ecommerce.fashionrent.entity.ProductLenders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductLenders, Integer> {


    @Query(value = """
            select p.id as productId, p.productname as productName, p.rrp, p.rentprice as rentPrice,
            p.brand, p.ocassion as occasion, p.category,
            p2.imageurl as imageUrl, p2.isthumbnail as thumbnail from productlenders p  
            join productimageurl p2 ON p2.productid = p.id """,nativeQuery = true
            )
    public List<ProductDtoSpecification> getAllProducts();

}
