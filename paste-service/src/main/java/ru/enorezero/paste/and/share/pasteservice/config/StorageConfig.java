package ru.enorezero.paste.and.share.pasteservice.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.URI;

@Configuration
public class StorageConfig {

    @Bean
    public AmazonS3 s3Client(){
        //AWSCredentials credentials = new ProfileCredentialsProvider().getCredentials();
        BasicAWSCredentials credentials = new BasicAWSCredentials("YCAJEoURMuIkBBIe-a0injnTG", "YCPqALqgQMB3fpM80bWPYIuGe6ZTHBmo1LrVY_2d");
        return AmazonS3ClientBuilder
                .standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withEndpointConfiguration(
                        new AmazonS3ClientBuilder.EndpointConfiguration(
                                "https://storage.yandexcloud.net", "ru-central1"
                        )
                )
                .build();
    }

}
