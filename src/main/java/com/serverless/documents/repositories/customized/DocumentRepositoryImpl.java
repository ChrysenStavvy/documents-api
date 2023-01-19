package com.serverless.documents.repositories.customized;

import com.serverless.documents.daos.DocumentDao;
import com.serverless.documents.daos.DocumentMetadataDao;
import com.serverless.documents.repositories.orm.DocumentEntity;
import com.serverless.documents.services.domain.Document;


public class DocumentRepositoryImpl implements DocumentCustomizedRepository {
    private DocumentDao documentDao;
    private DocumentMetadataDao documentMetadataDao;

    @Override
    public int add(Document domainDocument) {
        // Unit of work
        DocumentEntity ormDocument = domainDocument.documentDomainToOrm();
        documentDao.insert(ormDocument);
        documentMetadataDao.upsertMetadata(ormDocument);
        return domainDocument.id();
    }
}
