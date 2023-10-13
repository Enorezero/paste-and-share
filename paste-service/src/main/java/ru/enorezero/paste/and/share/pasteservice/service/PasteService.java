package ru.enorezero.paste.and.share.pasteservice.service;

import ru.enorezero.paste.and.share.pasteservice.api.responce.PasteResponce;

import java.util.List;

public interface PasteService {
    PasteResponce getByHash(String hash);
    List<PasteResponce> getLastTenPublic();

}
