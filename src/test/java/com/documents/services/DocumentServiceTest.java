package com.documents.services;

import com.documents.repositories.DocumentRepository;
import com.documents.repositories.orm.DocumentEntity;
import com.documents.services.domain.Document;
import com.documents.services.domain.DocumentSigningType;
import com.documents.services.domain.DocumentStatus;
import com.documents.services.domain.DocumentType;
import java.time.LocalDateTime;
import java.util.Optional;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class DocumentServiceTest {
    @Test
    public void getDocumentById() throws Exception {
        Optional<DocumentEntity> documentEntity = Optional.of(new DocumentEntity(
            1,
            "test",
            null,
            LocalDateTime.now(),
            "uploading party",
            DocumentStatus.NONE,
            DocumentSigningType.NONE,
            DocumentType.NONE,
            "s3Key",
            "s3Bucket",
            null,
            null,
            null,
            null,
            null,
            null,
            null
        ));
        DocumentRepository documentRepository = Mockito.mock(DocumentRepository.class);
        DocumentService documentService = new DocumentService(documentRepository);
        given(documentRepository.getById(1)).willReturn(documentEntity);
        Optional<Document> document = documentService.getById(1);

        Mockito.verify(documentRepository, Mockito.times(1)).getById(1);
        Assert.assertEquals(document, documentEntity.map(DocumentEntity::documentOrmToDomain));
    }
}
