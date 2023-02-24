package com.documents.controllers;

import com.documents.controllers.view.DocumentResponseBody;
import com.documents.services.DocumentService;
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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class DocumentControllerTest {
    @Test
    public void getDocumentByIdTest() throws Exception {
        Optional<Document> document = Optional.of(new Document(
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
        DocumentService documentService = Mockito.mock(DocumentService.class);
        DocumentController documentController = new DocumentController(documentService);
        given(documentService.getById(1)).willReturn(document);
        ResponseEntity<Optional<DocumentResponseBody>> responseBody = documentController.getDocumentById(1);

        Mockito.verify(documentService, Mockito.times(1)).getById(1);
        ResponseEntity<Optional<DocumentResponseBody>> expectedResponseBody = ResponseEntity.ok(document.map(Document::documentDomainToView));
        Assert.assertEquals(expectedResponseBody, responseBody);
    }

    @Test
    public void getNotFoundForId() throws Exception {
        DocumentService documentService = Mockito.mock(DocumentService.class);
        DocumentController documentController = new DocumentController(documentService);
        ResponseEntity<Optional<DocumentResponseBody>> responseBody = documentController.getDocumentById(1);
        assert responseBody.getStatusCode() == HttpStatus.NOT_FOUND;
        assert responseBody.getBody().isEmpty();
    }

}
