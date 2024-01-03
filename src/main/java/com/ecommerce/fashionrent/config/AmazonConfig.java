package com.ecommerce.fashionrent.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.ecommerce.fashionrent.util.CU;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AmazonConfig {

    String code = "rO0ABXQAakFLSUFZWExHSlM0WFZWNlJVTjZHOnNnZGdoc2RnaHN2aGdhY3MxMjM0OmFoc2hjdmpoZHNjdmpoamgxMjM0ODk3OlNNVCtSdE9QL3RFVHdKUkJMb3VEWG5VTEE4d0Zzc1FoQ3FsOVliQ3k=";

    @Bean
    public AmazonS3 s3() {
        String decode = CU.deserialize(code);
        AWSCredentials awsCredentials =
                new BasicAWSCredentials(decode.split(":")[0], decode.split(":")[3]);
        return AmazonS3ClientBuilder
                .standard()
                .withRegion("eu-north-1")
                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
                .build();

    }
}
