package com.serverless.documents.repositories;

import com.serverless.documents.repositories.orm.DocumentAnnotationEntity;
import com.serverless.documents.services.domain.DocumentAnnotation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DocumentAnnotationRepository extends CrudRepository<DocumentAnnotationEntity, Integer> {
    List<DocumentAnnotationEntity> getDocumentAnnotationsByDocumentId(int documentId);

}
