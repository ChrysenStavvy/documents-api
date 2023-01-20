package com.serverless.documents.services.domain;

import com.serverless.documents.controllers.view.DocumentResponseBody;
import com.serverless.documents.repositories.orm.DocumentEntity;

public record Document (int id, String name, byte[] bytes) {
    public DocumentEntity documentDomainToOrm() {
        return new DocumentEntity(this.id, this.name, this.bytes);
    }

    public DocumentResponseBody documentDomainToView() {
        return new DocumentResponseBody(this.id, this.name, this.bytes);
    }
}
