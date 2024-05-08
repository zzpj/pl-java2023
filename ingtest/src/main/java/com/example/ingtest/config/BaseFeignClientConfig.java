package com.example.ingtest.config;

import feign.*;
import lombok.SneakyThrows;
import org.apache.http.ssl.SSLContexts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.Resource;

import javax.net.ssl.*;
import java.io.InputStream;
import java.security.KeyStore;

@Configuration
public class BaseFeignClientConfig {

    @Value("${client.ssl.key-store:}")
    private Resource keyStoreFile;

    @Value("${client.ssl.key-store-password:}")
    private String keyStorePassword;

    @Bean
    @Scope("prototype")
    @SneakyThrows
    public Feign.Builder feignBuilder() {
        return Feign
                .builder()
                .retryer(Retryer.NEVER_RETRY)
                .client(new Client.Default(getSSLSocketFactory(),
                        HttpsURLConnection.getDefaultHostnameVerifier()))
                ;
    }

    private SSLSocketFactory getSSLSocketFactory() throws Exception {

        KeyStore ks = KeyStore.getInstance("JKS"); // or "PKCS12"
        ks.load(keyStoreFile.getInputStream(), keyStorePassword.toCharArray());

        return SSLContexts.custom()
                .loadKeyMaterial(ks, keyStorePassword.toCharArray())
                .build()
                .getSocketFactory();
    }

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }


    //important!
    @Bean
    public Contract useFeignAnnotations() {
        return new Contract.Default();
    }
}
