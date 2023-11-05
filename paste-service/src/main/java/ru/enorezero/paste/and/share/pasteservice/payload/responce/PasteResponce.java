package ru.enorezero.paste.and.share.pasteservice.payload.responce;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PasteResponce {
    String data;
    LocalDateTime lifetime;
}
