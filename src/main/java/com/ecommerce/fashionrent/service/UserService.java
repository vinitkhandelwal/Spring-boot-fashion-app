package com.ecommerce.fashionrent.service;

import com.ecommerce.fashionrent.entity.UserDetail;
import com.ecommerce.fashionrent.repository.UserDetailRepository;
import com.ecommerce.fashionrent.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

@Service
public class UserService {

    @Autowired
    private UserDetailRepository userDetailRepository;

    @Autowired
    private FileStore fileStore;

    public UserDetail saveUserImage(Integer userId, MultipartFile file) {

        List<String> filePaths = new ArrayList<>();

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
        String filePath =  "https://fashionapp-bucket.s3.eu-north-1.amazonaws.com/" + folder + "/" + fileName;
        UserDetail userDetail = userDetailRepository.findByUserId(Long.valueOf(userId)).get();
        userDetail.setImageUrl(filePath);
        userDetailRepository.save(userDetail);
        return userDetail;

    }

}
