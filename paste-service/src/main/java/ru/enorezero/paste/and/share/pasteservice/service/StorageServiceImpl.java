package ru.enorezero.paste.and.share.pasteservice.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.S3Object;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class StorageServiceImpl implements StorageService {

    @Autowired
    private AmazonS3 s3Client;

    @Override
    public String uploadText(final String bucketName, final String text){
        String textName = UUID.randomUUID().toString() + text.length();
        s3Client.putObject(bucketName, textName, text);
        return textName;
    }

    @Override
    public String downloadFile(final String bucketName, final String keyName) {
        S3Object s3Object = s3Client.getObject(bucketName, keyName);
        InputStream inputStream = s3Object.getObjectContent();
        return new BufferedReader(new InputStreamReader(inputStream))
                .lines().collect(Collectors.joining("\n"));
    }

    @Override
    public void deleteText(final String bucketName, final String keyName) {
        s3Client.deleteObject(bucketName, keyName);
    }
}
