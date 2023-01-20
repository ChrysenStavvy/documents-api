package com.serverless.documents.repositories.orm;

import com.serverless.documents.services.domain.Document;
import jakarta.persistence.Entity;
import org.springframework.data.annotation.Id;

@Entity
public record DocumentEntity(@Id int id, String name, byte[] bytes) {
    public Document documentOrmToDomain() {
        return new Document(this.id, this.name, this.bytes);
    }
}
