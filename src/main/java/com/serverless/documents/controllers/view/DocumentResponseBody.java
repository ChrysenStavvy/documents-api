package com.serverless.documents.controllers.view;

import java.io.IOException;

public record DocumentResponseBody(int id, String name, byte[] bytes) {

}
