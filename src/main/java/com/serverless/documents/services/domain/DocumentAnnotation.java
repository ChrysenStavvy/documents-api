package com.serverless.documents.services.domain;

import com.serverless.documents.controllers.view.DocumentAnnotationResponseBody;

public record DocumentAnnotation(int id, int documentId, String content) {
    public DocumentAnnotationResponseBody annotationDomainToView() {
        return new DocumentAnnotationResponseBody(this.id, this.documentId, this.content);
    }
}
