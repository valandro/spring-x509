package br.com.valandro.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
public class ServerController {

    @GetMapping(value = "/info",
                produces = MediaType.TEXT_PLAIN_VALUE)
    public String currentTime() {
        return LocalDateTime.now().format(DateTimeFormatter.ISO_DATE);
    }
}
