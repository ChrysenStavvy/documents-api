package com.serverless.documents.services.domain;

import com.serverless.documents.controllers.view.DocumentResponseBody;
import com.serverless.documents.repositories.orm.DocumentEntity;

public record Document (int id, String name, byte[] bytes) {
    public DocumentEntity documentDomainToOrm() {
        DocumentEntity ormDocument = new DocumentEntity();
        ormDocument.setId(this.id);
        ormDocument.setName(this.name);
        ormDocument.setBytes(this.bytes);
        return ormDocument;
    }

    public DocumentResponseBody documentDomainToView() {
        return new DocumentResponseBody(this.id, this.name, this.bytes);
    }
}
