package ru.enorezero.paste.and.share.authservice.model;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@RequiredArgsConstructor
public enum Role implements GrantedAuthority {
    ADMIN("USER"),
    USER("USER");

    private final String role;

    @Override
    public String getAuthority() {
        return role;
    }
}
