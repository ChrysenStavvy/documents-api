package com.documents.controllers.view;

import com.documents.services.domain.DocumentSigningType;
import com.documents.services.domain.DocumentStatus;
import com.documents.services.domain.DocumentType;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

public record DocumentResponseBody(
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
}
