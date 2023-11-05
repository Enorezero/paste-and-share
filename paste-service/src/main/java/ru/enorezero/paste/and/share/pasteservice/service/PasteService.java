package ru.enorezero.paste.and.share.pasteservice.service;

import ru.enorezero.paste.and.share.pasteservice.payload.request.PasteRequest;
import ru.enorezero.paste.and.share.pasteservice.payload.responce.PasteResponce;

import java.util.List;

public interface PasteService {
    public PasteResponce getByHash(String hash);
    public List<PasteResponce> getPublicPastes(int amount);
    public String createPaste(PasteRequest request);

}
