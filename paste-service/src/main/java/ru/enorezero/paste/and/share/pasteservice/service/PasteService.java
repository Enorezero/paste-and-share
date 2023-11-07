package ru.enorezero.paste.and.share.pasteservice.service;

import ru.enorezero.paste.and.share.pasteservice.payload.request.PasteRequest;
import ru.enorezero.paste.and.share.pasteservice.payload.response.PasteResponse;

import java.util.List;

public interface PasteService {
    public PasteResponse getByHash(String hash);
    public List<PasteResponse> getPublicPastes(int amount);
    public String createPaste(PasteRequest request);

}
