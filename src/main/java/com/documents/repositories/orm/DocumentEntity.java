package com.documents.repositories.orm;

import com.documents.services.domain.Document;
import com.documents.services.domain.DocumentSigningType;
import com.documents.services.domain.DocumentStatus;
import com.documents.services.domain.DocumentType;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

public record DocumentEntity(
    int id,
    String name,
    Optional<String> description,
    LocalDateTime createdAt,
    String uploadingParty,
    DocumentStatus status,
    DocumentSigningType signingType,
    DocumentType type,
    String s3Key,
    String s3Bucket,
    Optional<Integer> fileDocumentId,
    Optional<Integer> packetId,
    Optional<Integer> meetingId,
    Optional<UUID> meetingDocumentGuid,
    Optional<Integer> parentDocumentId,
    Optional<Integer> sourceDocumentId,
    Optional<String> mimeType

) {
    public Document documentOrmToDomain() {
        return new Document(
            this.id,
            this.name,
            this.description,
            this.createdAt,
            this.uploadingParty,
            this.status,
            this.signingType,
            this.type,
            this.s3Key,
            this.s3Bucket,
            this.fileDocumentId,
            this.packetId,
            this.meetingId,
            this.meetingDocumentGuid,
            this.parentDocumentId,
            this.sourceDocumentId,
            this.mimeType
        );
    }
}
