package br.com.valandro.config;

import br.com.valandro.client.FeignClientPackagerMarker;
import feign.Retryer;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackageClasses = FeignClientPackagerMarker.class)
public class FeignConfiguration {

    @Bean
    Retryer retryer() {
        return new Retryer.Default(0, 0, 1);
    }
}