package ru.enorezero.paste.and.share.authservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.enorezero.paste.and.share.authservice.model.UserCredentials;
import ru.enorezero.paste.and.share.authservice.repository.UserCredentialsRepository;

@Service
public class AuthServiceImpl {

    @Autowired
    private UserCredentialsRepository repository;

    public String saveUser(UserCredentials credentials){
        return "user register";
    }

}
