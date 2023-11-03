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
    StorageService storage;

    @Autowired
    PastesRepository pastesRepo;

    @Override
    public PasteResponce getByHash(String hash) {
        PasteResponce responce = new PasteResponce();
        PasteEntity foundEntity =  pastesRepo.findByPastesId(unHashURLByBase64(hash));

        if(foundEntity.getCreationTime().isAfter(foundEntity.getExpirationTime())){
            responce.setData("Срок пасты истёк");
            return responce;
        }

        String data = storage.downloadFile("paste-and-share", foundEntity.getKeyName());

        responce.setData(data);
        responce.setLifetime(foundEntity.getExpirationTime());

        return responce;
    }

    @Override
    public List<PasteResponce> getPublicPastes(int amount) {
        return null;
    }

    @Override
    public String createPaste(PasteRequest request) {
        String keyName = storage.uploadText("paste-and-share",request.getData());

        PasteEntity paste = new PasteEntity();
        paste.setKeyName(keyName);
        paste.setCreationTime(LocalDateTime.now());
        //реализовать подсчёт истечения даты
        paste.setExpirationTime(LocalDateTime.now().plusHours(3));
        paste.setStatus(request.getStatus().name());

        pastesRepo.save(paste);

        return hashURLByBase64(paste.getPastesId());
    }

    private String hashURLByBase64(Long id) {
        return Base64.getEncoder().encodeToString(Long.toString(id).getBytes()) ;
    }

    private Long unHashURLByBase64(String hash) {
        return Long.parseLong(new String(Base64.getDecoder().decode(hash.getBytes())));
    }
}
