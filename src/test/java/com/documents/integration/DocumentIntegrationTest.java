package com.documents.integration;

import com.documents.controllers.view.DocumentResponseBody;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class DocumentIntegrationTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Value("${documents.url}")
    private String documentsUrl;

    @Test
    public void testNoDocumentWithIdException() {
        int id = 1;
        ResponseEntity<DocumentResponseBody> response = testRestTemplate.getForEntity(
            documentsUrl + id,
            DocumentResponseBody.class
        );
        assert response.getStatusCode() == HttpStatus.NOT_FOUND;
    }
}
