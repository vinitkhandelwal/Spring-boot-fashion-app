package com.ecommerce.fashionrent.service;


import com.ecommerce.fashionrent.dto.ProductDto;
import com.ecommerce.fashionrent.dto.mapper.ProductMapper;
import com.ecommerce.fashionrent.dto.specification.ProductDtoSpecification;
import com.ecommerce.fashionrent.entity.ProductImageUrl;
import com.ecommerce.fashionrent.entity.ProductLenders;
import com.ecommerce.fashionrent.repository.LenderRepository;
import com.ecommerce.fashionrent.repository.ProductImageUrlRepository;
//import com.vividsolutions.jts.geom.Coordinate;
//import com.vividsolutions.jts.geom.GeometryFactory;
//import com.vividsolutions.jts.geom.PrecisionModel;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
//import org.locationtech.jts.geom.Coordinate;
//import org.locationtech.jts.geom.GeometryFactory;
//import org.locationtech.jts.geom.PrecisionModel;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.PrecisionModel;
import org.postgis.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

@Service
@AllArgsConstructor
public class LenderService {

    @Autowired
    private FileStore fileStore;
    @Autowired
    private LenderRepository lenderRepository;
    @Autowired
    private ProductImageUrlRepository imageUrlRepository;

//    private ProductMapper productMapper;

    public ProductDto saveProduct(ProductDto productDto, List<MultipartFile> fileList, Integer userId) {
        System.out.println(productDto + "" + fileList);

        if (fileList.isEmpty()) {
            throw new IllegalStateException("Cannot upload empty file");
        }

        List<String> filePaths = new ArrayList<>();
        for (MultipartFile file : fileList) {
            String folder = String.valueOf(UUID.randomUUID());
            String path = String.format("%s/%s", "fashionapp-bucket", folder);
            Map<String, String> metadata = new HashMap<>();
            metadata.put("Content-Type", file.getContentType());
            metadata.put("Content-Length", String.valueOf(file.getSize()));
            String fileName = String.format("%s", file.getOriginalFilename());
            try {
                fileStore.upload(path, fileName, Optional.of(metadata), file.getInputStream());
            } catch (IOException e) {
                throw new IllegalStateException("Failed to upload file", e);
            }
            filePaths.add("https://fashionapp-bucket.s3.eu-north-1.amazonaws.com/" + folder + "/" + fileName);
        }


        ProductLenders productLenders = ProductMapper.MAPPER.productDtoToProductLender(productDto);
        productLenders.setLenderId(userId);

        productLenders.setLatitude(productDto.getLatitude());
        productLenders.setLongitude(productDto.getLongitude());
        ProductLenders savedProduct = lenderRepository.save(productLenders);
        List<ProductImageUrl> arrayList = new ArrayList<>();
        for (String filePath : filePaths) {
            ProductImageUrl productImageUrl = new ProductImageUrl();
            productImageUrl.setImageUrl(filePath);
            productImageUrl.setProductId(savedProduct.getId());
            arrayList.add(productImageUrl);
        }
        imageUrlRepository.saveAll(arrayList);

        ProductDto productDto1 = ProductMapper.MAPPER.productLendersToProductDto(savedProduct);
        String[] filePathsArray = new String[filePaths.size()];
        filePathsArray = filePaths.toArray(filePathsArray);
        productDto1.setImageUrls(filePathsArray);
        productDto1.setProductId(savedProduct.getId());
        return productDto1;
    }

    public List<ProductDtoSpecification> getProduct(Integer userId) {

        return lenderRepository.getUserLenders(userId);


    }
}
