package com.serverless.documents.repositories.orm;

import com.serverless.documents.services.domain.DocumentAnnotation;
import jakarta.persistence.Entity;
import org.springframework.data.annotation.Id;
@Entity
public class DocumentAnnotationEntity {
    @Id
    private int id;
    private int documentId;
    private String content;

    public DocumentAnnotationEntity() {}

    public DocumentAnnotationEntity(int documentId) {}

    public DocumentAnnotationEntity(int id, int documentId, String content) {
        this.id = id;
        this.documentId = documentId;
        this.content = content;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDocumentId() {
        return documentId;
    }

    public void setDocumentId(int documentId) {
        this.documentId = documentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public DocumentAnnotation annotationOrmToDomain() {
        return new DocumentAnnotation(this.id, this.documentId, this.content);
    }
}
