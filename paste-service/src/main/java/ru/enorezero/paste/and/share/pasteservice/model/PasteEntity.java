package ru.enorezero.paste.and.share.pasteservice.model;

import lombok.Data;

import java.beans.Visibility;
import java.time.LocalDateTime;

@Data
public class PasteEntity {
    private String data;
    private LocalDateTime localDateTime;
    private String hash;
    private Visibility status;
}
