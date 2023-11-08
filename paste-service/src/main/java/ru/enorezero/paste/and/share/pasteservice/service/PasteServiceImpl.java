package ru.enorezero.paste.and.share.pasteservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.enorezero.paste.and.share.pasteservice.exception.NotFoundException;
import ru.enorezero.paste.and.share.pasteservice.exception.UnhashableLinkException;
import ru.enorezero.paste.and.share.pasteservice.payload.request.PasteRequest;
import ru.enorezero.paste.and.share.pasteservice.payload.response.PasteResponse;
import ru.enorezero.paste.and.share.pasteservice.model.PasteEntity;
import ru.enorezero.paste.and.share.pasteservice.repository.PastesRepository;
import ru.enorezero.paste.and.share.pasteservice.repository.StorageRepository;

import java.time.LocalDateTime;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
public class PasteServiceImpl implements PasteService{

    @Autowired
    StorageRepository storage;

    @Autowired
    PastesRepository pastesRepo;

    @Value("${cloud.aws.s3.bucket}")
    private String bucketName;

    @Override
    public PasteResponse getByHash(String hash) {
        Optional<PasteEntity> foundEntity = Optional.of(pastesRepo.findOptionalByPastesId(unhashURLByBase64(hash))
                .orElseThrow(() -> new NotFoundException("Паста не найдена")));

        //подумать нужно ли creationTime
        if(LocalDateTime.now().isAfter(foundEntity.get().getExpirationTime())){
            pastesRepo.delete(foundEntity.get());
            throw new NotFoundException("Время жизни пасты истекло");
        }

        String data = storage.downloadFile(bucketName, foundEntity.get().getKeyName());

        return new PasteResponse(data, foundEntity.get().getStatus());
    }

    @Override
    public List<PasteResponse> getPublicPastes(int amount) {
        return null;
    }

    @Override
    public String createPaste(PasteRequest request) {
        String keyName = storage.uploadText("rubin",request.getData());

        PasteEntity paste = new PasteEntity().builder()
                .keyName(keyName)
                .creationTime(LocalDateTime.now())
                .expirationTime(LocalDateTime.now().plusSeconds(request.getLifetime().getSeconds()))
                .status(request.getStatus())
                .build();

        pastesRepo.save(paste);

        return hashURLByBase64(paste.getPastesId());
    }

    private String hashURLByBase64(Long id) {
        return Base64.getEncoder().encodeToString(Long.toString(id).getBytes()) ;
    }

    private Long unhashURLByBase64(String hash) {
        try {
            return Long.parseLong(new String(Base64.getDecoder().decode(hash.getBytes())));
        }catch (NumberFormatException e){
            throw new UnhashableLinkException("Невозможно расхешировать строку");
        }
    }

}
