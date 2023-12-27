package com.ecommerce.fashionrent.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AmazonConfig {
    @Bean
    public AmazonS3 s3() {
        AWSCredentials awsCredentials =
                new BasicAWSCredentials("AKIAYXLGJS4XZ3FCARMS", "HHYZ0tn1YGfM/mWNomM5tJNQy+6hTykukBNk4vSh");
        return AmazonS3ClientBuilder
                .standard()
                .withRegion("eu-north-1")
                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
                .build();

    }
}