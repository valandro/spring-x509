package br.com.valandro.config;

import feign.Client;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.ssl.SSLContextBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import java.io.File;

@Configuration
public class SslConfig {
    @Value("${pass.key-store}")
    private String keyStorePass;
    @Value("${pass.trust-store}")
    private String trustStorePass;

    @Bean
    public Client feignSafeClient() {
        return new Client.Default(createSslSocketFactory(), new NoopHostnameVerifier());
    }

    private SSLSocketFactory createSslSocketFactory() {
        try {
            final File keyStore = new File("target/clientKeyStore.p12");
            final File trustStore = new File("target/clientTrustStore.p12");

            final SSLContext sslContext = SSLContextBuilder.create()
                    .loadKeyMaterial(keyStore, keyStorePass.toCharArray(), keyStorePass.toCharArray())
                    .loadTrustMaterial(trustStore, trustStorePass.toCharArray(), new TrustSelfSignedStrategy())
                    .build();
            return sslContext.getSocketFactory();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
