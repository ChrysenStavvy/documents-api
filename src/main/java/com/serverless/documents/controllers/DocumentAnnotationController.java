package com.serverless.documents.controllers;

import com.serverless.documents.controllers.view.DocumentAnnotationResponseBody;
import com.serverless.documents.services.DocumentAnnotationService;
import com.serverless.documents.services.domain.DocumentAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
@RestController
@RequestMapping("/api/documents/annotations")
public class DocumentAnnotationController {
    @Autowired
    private DocumentAnnotationService documentAnnotationService;

    @GetMapping("/{documentId}")
    public ResponseEntity<List<DocumentAnnotationResponseBody>> getAnnotations(
            @PathVariable(value="documentId") int documentId
    ) throws IOException {
        List<DocumentAnnotation> documentAnnotations = documentAnnotationService.getAnnotations(documentId);
        List<DocumentAnnotationResponseBody> annotationsResponse = documentAnnotations.stream()
                .map(DocumentAnnotation::annotationDomainToView)
                .toList();
        return ResponseEntity.ok(annotationsResponse);
    }
}
