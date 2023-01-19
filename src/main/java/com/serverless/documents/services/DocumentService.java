package com.serverless.documents.services;

import com.serverless.documents.repositories.DocumentRepository;
import com.serverless.documents.repositories.orm.DocumentEntity;
import com.serverless.documents.services.domain.Document;
import org.springframework.beans.factory.annotation.Autowired;

public class DocumentService {
    @Autowired
    private DocumentRepository documentRepository;
    private S3Service s3Service;

    public Document getById(int id) {
        DocumentEntity ormDocument = documentRepository.findOne(id);
        return ormDocument.documentOrmToDomain();
    }

    public int add(Document domainDocument) {
        s3Service.uploadToS3(domainDocument);
        return documentRepository.add(domainDocument);
    }

}
