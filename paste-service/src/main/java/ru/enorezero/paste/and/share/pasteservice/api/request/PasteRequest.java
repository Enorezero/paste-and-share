package ru.enorezero.paste.and.share.pasteservice.api.request;

import lombok.Data;
import ru.enorezero.paste.and.share.pasteservice.api.ExpirationTime;
import ru.enorezero.paste.and.share.pasteservice.api.Visibility;

@Data
public class PasteRequest {
    private String data;
    private ExpirationTime lifetime;
    private Visibility status;
}
