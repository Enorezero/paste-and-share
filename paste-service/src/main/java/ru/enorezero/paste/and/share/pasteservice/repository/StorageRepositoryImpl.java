package ru.enorezero.paste.and.share.pasteservice.repository;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.S3Object;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.enorezero.paste.and.share.pasteservice.exception.StorageUnavaibleException;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class StorageRepositoryImpl implements StorageRepository{
    @Autowired
    private AmazonS3 s3Client;

    @Override
    public String uploadText(final String bucketName, final String text){
        //придумать как лучше называть объекты
        try {
            String textName = UUID.randomUUID().toString() + text.length();

            s3Client.putObject(bucketName, textName, text);

            return textName;
        }catch (SdkClientException exception){
            throw new StorageUnavaibleException("Хранилище недоступно");
        }
    }

    @Override
    public String downloadFile(final String bucketName, final String keyName) {
        try {
            S3Object s3Object = s3Client.getObject(bucketName, keyName);

            InputStream inputStream = s3Object.getObjectContent();

            return new BufferedReader(new InputStreamReader(inputStream))
                    .lines().collect(Collectors.joining("\n"));
        }catch (SdkClientException exception){
            throw new StorageUnavaibleException("Хранилище недоступно");
        }
    }

    @Override
    public void deleteText(final String bucketName, final String keyName) {
        try {
            s3Client.deleteObject(bucketName, keyName);
        }catch (SdkClientException exception){
            throw new StorageUnavaibleException("Хранилище недоступно");
        }
    }
}
