package ru.enorezero.paste.and.share.pasteservice.payload.responce;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.enorezero.paste.and.share.pasteservice.payload.Visibility;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PasteResponce {
    String data;
    Visibility status;
}
