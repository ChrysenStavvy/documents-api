package com.serverless.documents.repositories.orm;

import com.serverless.documents.services.domain.Document;
import jakarta.persistence.Entity;
import org.springframework.data.annotation.Id;

@Entity
public class DocumentEntity {
    @Id
    private int id;
    private String name;
    private byte[] bytes;

    public DocumentEntity(int id, String name, byte[] bytes) {
        this.id = id;
        this.name = name;
        this.bytes = bytes;
    }

    public DocumentEntity() {}

    public DocumentEntity(int id) {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Document documentOrmToDomain() {
        return new Document(this.id, this.name, this.bytes);
    }
}
