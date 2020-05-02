package br.com.valandro.client;

import br.com.valandro.config.SslConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "server-safe-client", url = "https://localhost:8443/server", configuration = SslConfig.class)
public interface ServerSafeClient {

    @GetMapping("/info")
    public String getCurrentTime();
}
