package com.ecommerce.fashionrent.repository;

import com.ecommerce.fashionrent.dto.ProductDto;
import com.ecommerce.fashionrent.dto.specification.RentedProductDtoSpecification;
import com.ecommerce.fashionrent.entity.ProductLenders;
import org.hibernate.annotations.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RenterRepository extends JpaRepository<ProductLenders,Integer> {


    @Query(value = """
            with productdetail as(
            select p.id,pl.id as productid, p.datefrom , p.dateto, pl.productname, pl.rrp , pl.brand,  pl.rentprice, p.renteruserid from productrented p
            left join productlenders pl on pl.id = p.productlenderid
            ),
            productimageurl as
            (select array_agg(imageurl) AS result_array,productid from productimageurl p2 group by productid)
            select pd.id as productId, pd.brand, pd.productname as productName, piurl.result_array as imageUrl,pd.rrp, pd.rentprice, pd.datefrom as dateFrom, pd.dateto as dateTo from productdetail pd left join productimageurl piurl on piurl.productid = pd.id
            where pd.renteruserid  = :userId                        
            """, nativeQuery = true)
    public List<RentedProductDtoSpecification> getRentedProducts(@Param("userId") Integer userId);

}
