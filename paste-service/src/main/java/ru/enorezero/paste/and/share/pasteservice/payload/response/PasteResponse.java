package ru.enorezero.paste.and.share.pasteservice.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.enorezero.paste.and.share.pasteservice.payload.Visibility;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PasteResponse {
    String data;
    Visibility status;
}
