package ru.enorezero.paste.and.share.pasteservice.api.responce;

import lombok.Data;
import ru.enorezero.paste.and.share.pasteservice.model.PasteEntity;

import java.time.LocalDateTime;

@Data
public class PasteResponce {
    String data;
    LocalDateTime lifetime;
}
