package com.example.ingtest;

import com.example.ingtest.feign.AuthClient;
import com.example.ingtest.feign.GreetClient;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ing.developer.oauth2.model.TokenResponse;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.apache.http.ssl.SSLContexts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.net.ssl.SSLContext;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.security.KeyStore;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static com.example.ingtest.IngTestApplication.FORMATTER;

@SpringBootApplication
@EnableFeignClients
public class IngTestApplication {

    static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("E, dd MMM yyyy HH:mm:ss O", Locale.US);
    public static final String ING_SANDBOX_API = "https://api.sandbox.ing.com/";
    //public static final String ING_PROD_API = "https://api.ing.com/";

    public static void main(String[] args) {
        SpringApplication.run(IngTestApplication.class, args);
    }
}

@Service
@RequiredArgsConstructor
class IngApiWithoutFeignService {

    @Value("${client.ssl.key-store:}")
    private Resource keyStoreFile;

    @Value("${client.ssl.key-store-password:}")
    private String keyStorePassword;

    private SSLContext getSSLContext() throws Exception {

        KeyStore ks = KeyStore.getInstance("JKS"); // or "PKCS12"
        ks.load(keyStoreFile.getInputStream(), keyStorePassword.toCharArray());

        return SSLContexts.custom()
                .loadKeyMaterial(ks, keyStorePassword.toCharArray())
                .build();
    }

    @SneakyThrows
    public String getToken() {

        HttpClient httpClient = HttpClient.newBuilder()
                .sslContext(getSSLContext())
                .build();
        HttpRequest postToken = HttpRequest.newBuilder()
                .setHeader("Accept", "application/json")
                .setHeader("Content-Type", "application/x-www-form-urlencoded")
                .setHeader("Date", ZonedDateTime.now(ZoneId.of("GMT")).format(FORMATTER))
                // .setHeader("User-Agent", "openbanking-sdk/0.0.3-SNAPSHOT java")
                .uri(URI.create("https://api.sandbox.ing.com/oauth2/token"))
                .POST(HttpRequest.BodyPublishers.ofString("grant_type=client_credentials&client_id=e77d776b-90af-4684-bebc-521e5b2614dd"))
                .build();
        final HttpResponse<?> response = httpClient.send(postToken, HttpResponse.BodyHandlers.ofString());
        final TokenResponse tokenResponse = new ObjectMapper().readValue(response.body().toString(), TokenResponse.class);

        System.out.println("token: " + tokenResponse.getAccessToken());

        return tokenResponse.getAccessToken();
    }
}

@Service
@RequiredArgsConstructor
class IngApiWithFeignClientService {

    private final GreetClient greetClient;
    private final AuthClient authClient;

    public String getGreetings() {

        TokenResponse accessTokenUsingPOST = authClient.getAccessTokenUsingPOST(
                "client_credentials",
                null,
                null,
                ZonedDateTime.now(ZoneId.of("GMT")).format(FORMATTER),
                null,
                null,
                "e77d776b-90af-4684-bebc-521e5b2614dd",
                null,
                null,
                null,
                null
        );

        String token = "Bearer " + accessTokenUsingPOST.getAccessToken();
        String message = greetClient.mtlsOnlyGreetingsGet(token).getMessage();
        return "the message is: " + message;
    }
}


@RestController
@RequiredArgsConstructor
class IngApiController {

    private final IngApiWithoutFeignService ingApiWithoutFeignService;

    private final IngApiWithFeignClientService ingApiWithFeignClientService;

    @GetMapping("/token")
    public ResponseEntity<String> noFeign() {
        return ResponseEntity.ok(ingApiWithoutFeignService.getToken());
    }

    @GetMapping("/feign")
    public ResponseEntity<String> feign() {
        return ResponseEntity.ok(ingApiWithFeignClientService.getGreetings());
    }
}
