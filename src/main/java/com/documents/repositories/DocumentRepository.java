package com.documents.repositories;

import com.documents.repositories.orm.DocumentEntity;
import com.documents.services.domain.DocumentSigningType;
import com.documents.services.domain.DocumentStatus;
import com.documents.services.domain.DocumentType;
import java.util.Optional;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import static com.documents.db.public_.Tables.DOCUMENTS;

@Repository
public class DocumentRepository {
    private final DSLContext dsl;

    @Autowired
    public DocumentRepository(DSLContext dsl) {
        this.dsl = dsl;
    }

    public Optional<DocumentEntity> getById(int id) {
        Record documentRecord = dsl.fetchOne(DOCUMENTS, DOCUMENTS.ID.eq(id));
        if (documentRecord == null) {return Optional.empty();}
        return Optional.of(new DocumentEntity(
                documentRecord.get(DOCUMENTS.ID),
                documentRecord.get(DOCUMENTS.DOCUMENT_NAME),
                Optional.ofNullable(documentRecord.get(DOCUMENTS.DESCRIPTION)),
                documentRecord.get(DOCUMENTS.CREATED_AT),
                documentRecord.get(DOCUMENTS.UPLOADING_PARTY),
                DocumentStatus.valueOf(documentRecord.get(DOCUMENTS.STATUS).toUpperCase()),
                DocumentSigningType.valueOf(documentRecord.get(DOCUMENTS.SIGNING_TYPE).toUpperCase()),
                DocumentType.valueOf(documentRecord.get(DOCUMENTS.DOCUMENT_TYPE).toUpperCase()),
                documentRecord.get(DOCUMENTS.S3_KEY),
                documentRecord.get(DOCUMENTS.S3_BUCKET),
                Optional.ofNullable(documentRecord.get(DOCUMENTS.FILE_DOCUMENT_ID)),
                Optional.ofNullable(documentRecord.get(DOCUMENTS.PACKET_ID)),
                Optional.ofNullable(documentRecord.get(DOCUMENTS.MEETING_ID)),
                Optional.ofNullable(documentRecord.get(DOCUMENTS.MEETING_DOCUMENT_GUID)),
                Optional.ofNullable(documentRecord.get(DOCUMENTS.PARENT_DOCUMENT_ID)),
                Optional.ofNullable(documentRecord.get(DOCUMENTS.SOURCE_DOCUMENT_ID)),
                Optional.ofNullable(documentRecord.get(DOCUMENTS.MIME_TYPE))
            )
        );
    }
}
