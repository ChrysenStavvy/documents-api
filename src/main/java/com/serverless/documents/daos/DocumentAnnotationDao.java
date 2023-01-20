package com.serverless.documents.daos;

import com.serverless.documents.repositories.orm.DocumentAnnotationEntity;

import java.util.List;

public class DocumentAnnotationDao {
    public List<DocumentAnnotationEntity> getAnnotationsForDocument(int documentId) {
        DocumentAnnotationEntity documentAnnotationEntity =
                new DocumentAnnotationEntity(1, documentId, "content");
        return List.of(documentAnnotationEntity);
    }
}
