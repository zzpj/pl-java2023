package com.ing.developer.greetings.api;

import com.ing.developer.greetings.ApiClient;
import com.ing.developer.greetings.model.Error;
import com.ing.developer.greetings.model.Greeting;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for ShowcaseApiApi
 */
class ShowcaseApiApiTest {

    private ShowcaseApiApi api;

    @BeforeEach
    public void setup() {
        api = new ApiClient().buildClient(ShowcaseApiApi.class);
    }

    
    /**
     * Gives a greeting message using the HTTP message signature
     *
     * Returns a message generated with a unique id and a timestamp indicating when it was produced.  ## Deprecation note: We are moving from HTTP signature. You still can use this endpoint in cases where you plan to consume endpoints that  require HTTP signature. But over time, all endpoints will require either JWS-signature or no signature  at all (MTLS-only). If you plan to consume such endpoints,  please use &#x60;/signed/greetings&#x60; or &#x60;/mtls-only/greetings&#x60; respectively
     */
    @Test
    void greetingsSingleGetTest() {
        String authorization = null;
        String signature = null;
        String digest = null;
        OffsetDateTime date = null;
        // Greeting response = api.greetingsSingleGet(authorization, signature, digest, date);

        // TODO: test validations
    }

    
    /**
     * Gives a greeting message using only mTLS and no message signature
     *
     * Returns a message generated with a unique id and a timestamp indicating when it was produced.
     */
    @Test
    void mtlsOnlyGreetingsGetTest() {
        String authorization = null;
        // Greeting response = api.mtlsOnlyGreetingsGet(authorization);

        // TODO: test validations
    }

    
    /**
     * Gives a greeting message using the JWS message signature
     *
     * Returns a message generated with a unique id and a timestamp indicating when it was produced.
     */
    @Test
    void signedGreetingsGetTest() {
        String authorization = null;
        String xJWSSignature = null;
        String digest = null;
        String contentType = null;
        // Greeting response = api.signedGreetingsGet(authorization, xJWSSignature, digest, contentType);

        // TODO: test validations
    }

    
}
