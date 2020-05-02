package br.com.valandro.controller;

import br.com.valandro.client.ServerSafeClient;
import br.com.valandro.client.ServerUnsafeClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

    @Autowired
    private ServerSafeClient serverSafeClient;
    @Autowired
    private ServerUnsafeClient serverUnsafeClient;

    @GetMapping(value = "/safe",
    produces = MediaType.TEXT_PLAIN_VALUE)
    public String doSafeRequest() {
        return serverSafeClient.getCurrentTime();
    }

    @GetMapping(value = "/unsafe",
            produces = MediaType.TEXT_PLAIN_VALUE)
    public String getCurrentTime() {
        return serverUnsafeClient.getCurrentTime();
    }
}
