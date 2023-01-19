package com.serverless.documents.repositories.customized;

import com.serverless.documents.services.domain.Document;


public interface DocumentCustomizedRepository {
    int add(Document domainDocument);
}
