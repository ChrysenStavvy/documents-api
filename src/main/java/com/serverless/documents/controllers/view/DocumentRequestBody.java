package com.serverless.documents.controllers.view;

import com.serverless.documents.services.domain.Document;

public record DocumentRequestBody(int id, String name, byte[] bytes) {
    public Document documentRequestToDomain() {
        return new Document(this.id, this.name, this.bytes);
    }
}
