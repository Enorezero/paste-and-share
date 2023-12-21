package ru.enorezero.paste.and.share.authservice.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.enorezero.paste.and.share.authservice.model.UserCredentials;
import ru.enorezero.paste.and.share.authservice.repository.UserCredentialsRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    UserCredentialsRepository userCredentialsRepository;

    Optional<UserCredentials> getByEmail(@NonNull String email){
        return Optional.of(userCredentialsRepository.findOptionalByEmail(email)
                .orElseThrow(() -> new RuntimeException("Данные пользователя не найдены")));
    }
}
