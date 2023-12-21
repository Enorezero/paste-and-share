package ru.enorezero.paste.and.share.authservice.model;

import lombok.Data;

@Data
public class JwtRequest {
    String email;
    String password;
}
