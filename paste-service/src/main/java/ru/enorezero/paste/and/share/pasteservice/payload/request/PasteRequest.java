package ru.enorezero.paste.and.share.pasteservice.payload.request;

import lombok.Data;
import ru.enorezero.paste.and.share.pasteservice.payload.ExpirationTime;
import ru.enorezero.paste.and.share.pasteservice.payload.Visibility;

@Data
public class PasteRequest {
    private String data;
    private ExpirationTime lifetime;
    private Visibility status;
}
