package ru.enorezero.paste.and.share.pasteservice.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Data
@Entity
@Table(name = "pastes")
public class PasteEntity {
    @Id
    @SequenceGenerator(name="hibernate_sequence", sequenceName="hibernate_sequence", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hibernate_sequence")
    @Column(name = "pastes_id", nullable = false)
    private Long pastesId;
    @Column(name = "metadata_url", nullable = false)
    private String metadataURL;
    @Column(name = "expiration_time", nullable = false)
    private LocalDateTime expirationTime;
    @Column(name = "creation_time", nullable = false)
    private LocalDateTime creationTime;
    @Column(name = "status", nullable = false)
    private String status;
}
