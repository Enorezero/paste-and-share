package ru.enorezero.paste.and.share.pasteservice.api.responce;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PasteResponce {
    String data;
    LocalDateTime lifetime;
}
