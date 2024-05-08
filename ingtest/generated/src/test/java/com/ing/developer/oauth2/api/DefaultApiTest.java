package com.ing.developer.oauth2.api;

import com.ing.developer.oauth2.ApiClient;
import com.ing.developer.oauth2.model.AuthorizationURLResponse;
import com.ing.developer.oauth2.model.Error;
import com.ing.developer.oauth2.model.TokenResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for DefaultApi
 */
class DefaultApiTest {

    private DefaultApi api;

    @BeforeEach
    public void setup() {
        api = new ApiClient().buildClient(DefaultApi.class);
    }

    
    /**
     * Retrieve the ING Authorization server URL with a specific request identifier
     *
     * This endpoint stores the received data and returns a object/body with a location property containing the authorize URI with a specific reference ID for request identification.  In case of error the API returns the error description.
     */
    @Test
    void authorizationServerUrlUsingGETTest() {
        String authorization = null;
        String signature = null;
        String date = null;
        String digest = null;
        String scope = null;
        String redirectUri = null;
        String countryCode = null;
        // AuthorizationURLResponse response = api.authorizationServerUrlUsingGET(authorization, signature, date, digest, scope, redirectUri, countryCode);

        // TODO: test validations
    }

    /**
     * Retrieve the ING Authorization server URL with a specific request identifier
     *
     * This endpoint stores the received data and returns a object/body with a location property containing the authorize URI with a specific reference ID for request identification.  In case of error the API returns the error description.
     *
     * This tests the overload of the method that uses a Map for query parameters instead of
     * listing them out individually.
     */
    @Test
    void authorizationServerUrlUsingGETTestQueryMap() {
        String authorization = null;
        String signature = null;
        String date = null;
        String digest = null;
        DefaultApi.AuthorizationServerUrlUsingGETQueryParams queryParams = new DefaultApi.AuthorizationServerUrlUsingGETQueryParams()
            .redirectUri(null)
            .scope(null)
            .countryCode(null);
        // AuthorizationURLResponse response = api.authorizationServerUrlUsingGET(authorization, signature, date, digest, queryParams);

    // TODO: test validations
    }
    
    /**
     * Retrieve an application or customer access token, or refresh an access token
     *
     *  This endpoint allows requesting an access token for one of the flows below:  ## Client Credentials (registered in the ING Developer portal) For authenticating your application and retrieving an application access token. Required request parameters: - grant_type&#x3D;client_credentials - scope (optional): If not provided, all the subscribed scopes will be returned  ## Client Credentials (without pre-registration using eIDAS/OBIE certificates supporting PSD2) For authenticating your application and retrieving an application access token without pre-registration in the ING Developer portal using eIDAS/OBIE certificates supporting PSD2. This flow will automatically subscribe your application to the allowed ING APIs based on the PSD2 roles in the certificate. The scopes in the application access token are based on the PSD2 roles. Required request parameters: - grant_type&#x3D;client_credentials - TPP-Signature-Certificate: PSD2 compliant Qualified Electronic Seal Certificate (QSealC)  ## Authorization Code For exchanging the authorization code for a customer access token.  Required request parameters: - grant_type&#x3D;authorization_code - code (required) - redirect_uri (optional)  ## Refresh Token For exchanging a refresh token for a new customer access token. Required request parameters: - grant_type&#x3D;refresh_token - refresh_token (required)    ## Access tokens and message signing   Most of our APIs require a combination of TLS and and request signing to verify the identity of the sender of the message and to verify that the message was not tampered with during transit.  While some APIs are currently using HTTP Signatures, ING is standardizing on the use of JWS for message signing as per the Open Banking Europe specification.    [Want to learn more about the JSON Web Signature specification for Open Banking?](https://www.openbankingeurope.eu/media/2096/obe-json-web-signature-profile-for-open-banking.pdf)    [Want to learn more about the HTTP Signature specification?](https://tools.ietf.org/html/draft-cavage-http-signatures-10)    ## Why is this important when requesting an access token?   An access token requested using the HTTP Signature approach can only be used for consuming APIs that use HTTP Signatures for message signing. An access token requested using   the Mutual TLS approach can only be used for consuming APIs that rely on JWS and / or Mutual TLS.   ## JSON Web Signature (JWS) and Mutual TLS (mTLS)   In addition to the required parameters mentioned above for the different authentication flows (Client Credentials, Authorization code and Refresh token), the following additional request parameters are required for use with JWS and mTLS :   - client_id (required)    ## HTTP Signature &#x60;DEPRECATED&#x60;   In addition to the required parameters mentioned above for the different authentication flows (Client Credentials, Authorization code and Refresh token), the following additional request parameters are required for use with HTTP Signature:   - Authorization (required)  - Digest (required) 
     */
    @Test
    void getAccessTokenUsingPOSTTest() {
        String grantType = null;
        String authorization = null;
        String signature = null;
        String date = null;
        String digest = null;
        String tpPSignatureCertificate = null;
        String clientId = null;
        String scope = null;
        String code = null;
        String redirectUri = null;
        String refreshToken = null;
        // TokenResponse response = api.getAccessTokenUsingPOST(grantType, authorization, signature, date, digest, tpPSignatureCertificate, clientId, scope, code, redirectUri, refreshToken);

        // TODO: test validations
    }

    
    /**
     * Revoke a customer refresh token.
     *
     * This endpoint is used to revoke an existing token from a client.
     */
    @Test
    void revokeRefreshTokenUsingPOSTTest() {
        String authorization = null;
        String token = null;
        String signature = null;
        String date = null;
        String digest = null;
        String tokenTypeHint = null;
        // api.revokeRefreshTokenUsingPOST(authorization, token, signature, date, digest, tokenTypeHint);

        // TODO: test validations
    }

    
}
