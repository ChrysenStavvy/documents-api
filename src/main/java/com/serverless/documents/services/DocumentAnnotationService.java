package com.serverless.documents.services;

import com.serverless.documents.repositories.DocumentAnnotationRepository;
import com.serverless.documents.repositories.orm.DocumentAnnotationEntity;
import com.serverless.documents.services.domain.DocumentAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

public class DocumentAnnotationService {
    @Autowired
    private DocumentAnnotationRepository AnnotationRepository;
    public List<DocumentAnnotation> getAnnotations(int documentId) {
        List<DocumentAnnotationEntity> ormAnnotation = AnnotationRepository.getDocumentAnnotationsByDocumentId(documentId);
        return ormAnnotation.stream()
                .map(DocumentAnnotationEntity::annotationOrmToDomain)
                .toList();
    }
}
