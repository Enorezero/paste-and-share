package ru.enorezero.paste.and.share.pasteservice.service;

public interface StorageService {

    String uploadText(final String bucketName, final String text);

    String downloadFile(final String bucketName, final String keyName);

    void deleteText(final String bucketName, final String keyName);

}
