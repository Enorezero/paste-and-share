package ru.enorezero.paste.and.share.pasteservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.enorezero.paste.and.share.pasteservice.model.PasteEntity;

public interface PastesRepository extends JpaRepository<PasteEntity,Long> {
    PasteEntity findByPastesId(Long pastesId);
}
