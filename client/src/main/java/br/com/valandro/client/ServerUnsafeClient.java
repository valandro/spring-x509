package br.com.valandro.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "server-unsafe-client", url = "http://localhost:8443/server")
public interface ServerUnsafeClient {

    @GetMapping("/info")
    public String getCurrentTime();
}
