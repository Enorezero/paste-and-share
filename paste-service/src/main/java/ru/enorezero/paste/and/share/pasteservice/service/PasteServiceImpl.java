package ru.enorezero.paste.and.share.pasteservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.enorezero.paste.and.share.pasteservice.api.request.PasteRequest;
import ru.enorezero.paste.and.share.pasteservice.api.responce.PasteResponce;
import ru.enorezero.paste.and.share.pasteservice.model.PasteEntity;
import ru.enorezero.paste.and.share.pasteservice.repository.PastesRepository;

import java.time.LocalDateTime;
import java.util.Base64;
import java.util.List;

@Service
public class PasteServiceImpl implements PasteService{

    @Autowired
    PastesRepository pastesRepo;
    //@Autowired

    @Override
    public PasteEntity getByHash(String hash) {

        return pastesRepo.findByPastesId(deHashURLByBase64(hash));
    }

    @Override
    public List<PasteResponce> getPublicPastes(int amount) {
        return null;
    }

    @Override
    public String createPaste(PasteRequest request) {
        //String metadataURL = yandexS3Repo.save(request.getData());
        PasteEntity paste = new PasteEntity();
        paste.setExpirationTime(LocalDateTime.now().plusHours(3));
        paste.setCreationTime(LocalDateTime.now());
        paste.setStatus(request.getStatus().name());
        paste.setMetadataURL("3301");
        pastesRepo.save(paste);
        return hashURLByBase64(paste.getPastesId());
    }

    private String hashURLByBase64(Long id) {
        return Base64.getEncoder().encodeToString(Long.toString(id).getBytes()) ;
    }

    private Long deHashURLByBase64(String hash) {
        return Long.parseLong(new String(Base64.getDecoder().decode(hash.getBytes())));
    }
}
