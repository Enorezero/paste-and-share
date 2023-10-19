package ru.enorezero.paste.and.share.pasteservice.service;

import ru.enorezero.paste.and.share.pasteservice.api.request.PasteRequest;
import ru.enorezero.paste.and.share.pasteservice.api.responce.PasteResponce;
import ru.enorezero.paste.and.share.pasteservice.model.PasteEntity;

import java.util.List;

public interface PasteService {
    public PasteEntity getByHash(String hash);
    public List<PasteResponce> getPublicPastes(int amount);
    public String createPaste(PasteRequest request);

}
