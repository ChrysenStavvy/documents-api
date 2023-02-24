package com.documents.controllers;

import com.documents.controllers.view.DocumentResponseBody;
import com.documents.services.DocumentService;
import com.documents.services.domain.Document;
import java.util.Optional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/documents")
public class DocumentController {
    private final DocumentService documentService;
    private static final Logger LOG = LogManager.getLogger(DocumentController.class);

    @Autowired
    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<DocumentResponseBody>> getDocumentById(@PathVariable(value = "id") int id) {
        Optional<Document> document = documentService.getById(id);
        if (document.isEmpty()) {
            LOG.info("Document with id does not exist.");
            return new ResponseEntity<>(Optional.empty(), HttpStatus.NOT_FOUND);
        }
        Optional<DocumentResponseBody> documentResponseBody = document.map(Document::documentDomainToView);
        return new ResponseEntity<>(documentResponseBody, HttpStatus.OK);
    }
}
