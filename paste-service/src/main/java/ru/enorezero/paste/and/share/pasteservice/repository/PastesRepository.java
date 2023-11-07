package ru.enorezero.paste.and.share.pasteservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.enorezero.paste.and.share.pasteservice.model.PasteEntity;

import java.util.Optional;

public interface PastesRepository extends JpaRepository<PasteEntity,Long> {
    Optional<PasteEntity> findOptionalByPastesId(Long pastesId);
}
