package ru.enorezero.paste.and.share.pasteservice.api.request;

import lombok.Data;
import ru.enorezero.paste.and.share.pasteservice.api.PublicStatus;

@Data
public class PasteRequest {
    private String data;
    private int lifetime;
    private PublicStatus status;
}
