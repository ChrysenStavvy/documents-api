package com.serverless.documents.controllers;

import com.serverless.documents.controllers.view.DocumentAnnotationResponseBody;
import com.serverless.documents.controllers.view.DocumentRequestBody;
import com.serverless.documents.controllers.view.DocumentResponseBody;
import com.serverless.documents.services.DocumentService;
import com.serverless.documents.services.domain.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/documents")
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    @GetMapping("/{id}")
    public ResponseEntity<DocumentResponseBody> getDocumentById(@PathVariable(value="id") int id) throws IOException {
        Document document = documentService.getById(id);
        return ResponseEntity.ok(document.documentDomainToView());
    }

    @PostMapping(value="/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public int addDocument(@RequestBody DocumentRequestBody document) {
        Document domainDocument = document.documentRequestToDomain();
        return documentService.add(domainDocument);
    }
}

