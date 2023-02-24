package com.documents.services;

import com.documents.repositories.DocumentRepository;
import com.documents.repositories.orm.DocumentEntity;
import com.documents.services.domain.Document;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocumentService {
    private final DocumentRepository documentRepository;

    @Autowired
    public DocumentService(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    public Optional<Document> getById(int id) {
        Optional<DocumentEntity> documentEntity = documentRepository.getById(id);
        return documentEntity.map(DocumentEntity::documentOrmToDomain);
    }
}
