package ru.enorezero.paste.and.share.authservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.enorezero.paste.and.share.authservice.model.UserCredentials;

public interface UserCredentialsRepository extends JpaRepository<UserCredentials, Integer> {
}
