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

@RestController
@RequestMapping("/api/documents")
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    @GetMapping("/{id}")
    public ResponseEntity<DocumentResponseBody> getDocumentById(@PathVariable(value="id") int id) {
        Document document = documentService.getById(id);
        return ResponseEntity.ok(document.documentDomainToView());
    }

    @PostMapping(value="/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> addDocument(@RequestBody DocumentRequestBody document) {
        Document domainDocument = document.documentRequestToDomain();
        Integer document_id = documentService.add(domainDocument);
        return ResponseEntity.ok(document_id);
    }
}

