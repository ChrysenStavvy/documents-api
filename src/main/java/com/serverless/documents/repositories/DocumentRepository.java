package com.serverless.documents.repositories;
import com.serverless.documents.repositories.orm.DocumentEntity;
import com.serverless.documents.repositories.customized.DocumentCustomizedRepository;
import com.serverless.documents.services.domain.Document;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DocumentRepository extends CrudRepository<DocumentEntity, Integer>, DocumentCustomizedRepository {
    Document findDocumentByGuid(UUID guid);
    // gets document with guid
}
