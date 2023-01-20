package com.serverless.documents.repositories.orm;

import com.serverless.documents.services.domain.DocumentAnnotation;
import jakarta.persistence.Entity;
import org.springframework.data.annotation.Id;
@Entity
public record DocumentAnnotationEntity(@Id int id, int documentId, String content) {
    public DocumentAnnotation annotationOrmToDomain() {
        return new DocumentAnnotation(this.id, this.documentId, this.content);
    }
}
