package com.ing.developer.oauth2.api;

import com.ing.developer.oauth2.ApiClient;
import com.ing.developer.oauth2.EncodingUtils;
import com.ing.developer.oauth2.model.ApiResponse;

import com.ing.developer.oauth2.model.AuthorizationURLResponse;
import com.ing.developer.oauth2.model.Error;
import com.ing.developer.oauth2.model.TokenResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import feign.*;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.5.0")
public interface DefaultApi extends ApiClient.Api {


  /**
   * Retrieve the ING Authorization server URL with a specific request identifier
   * This endpoint stores the received data and returns a object/body with a location property containing the authorize URI with a specific reference ID for request identification.  In case of error the API returns the error description.
   * @param authorization Application access token (bearer) received in the Client Credentials grant flow (required)
   * @param signature Signature header as defined in https://tools.ietf.org/html/draft-cavage-http-signatures-10. ING requires the headers &#39;(request-target) date digest&#39;, and the algorithm is &#39;rsa-sha256&#39; or &#39;ecdsa-sha256&#39;, &#39;ecdsa-sha384&#39;, &#39;ecdsa-sha512&#39;. (required)
   * @param date The current date in the HTTPs standard Date header format (see RFC7231: https://tools.ietf.org/html/rfc7231#section-7.1.1.2) (required)
   * @param digest The SHA-256 hash value of the requests body encoded in Base64. If the body is empty, it should be the SHA-256 value of the empty string. (required)
   * @param scope List of scopes for which an authorization request is asked, separated by space. Must not be empty and it is validated based on the subscriptions of your API. (required)
   * @param redirectUri URI where user is redirected to after authorization. Only required when your application is not registered in the ING Developer portal, and your are using PSD2 compliant eIDAS/OBIE certificates (optional)
   * @param countryCode Country Code 2 letter value(ISO 3166-1). The country code is optional, and allows you to redirect you user to a specific ING country login page. (optional)
   * @return AuthorizationURLResponse
   */
  @RequestLine("GET /oauth2/authorization-server-url?redirect_uri={redirectUri}&scope={scope}&country_code={countryCode}")
  @Headers({
    "Accept: application/json",
    "Authorization: {authorization}",
    
    "Signature: {signature}",
    
    "Date: {date}",
    
    "Digest: {digest}"
  })
  AuthorizationURLResponse authorizationServerUrlUsingGET(@Param("authorization") String authorization, @Param("signature") String signature, @Param("date") String date, @Param("digest") String digest, @Param("scope") String scope, @Param("redirectUri") String redirectUri, @Param("countryCode") String countryCode);

  /**
   * Retrieve the ING Authorization server URL with a specific request identifier
   * Similar to <code>authorizationServerUrlUsingGET</code> but it also returns the http response headers .
   * This endpoint stores the received data and returns a object/body with a location property containing the authorize URI with a specific reference ID for request identification.  In case of error the API returns the error description.
   * @param authorization Application access token (bearer) received in the Client Credentials grant flow (required)
   * @param signature Signature header as defined in https://tools.ietf.org/html/draft-cavage-http-signatures-10. ING requires the headers &#39;(request-target) date digest&#39;, and the algorithm is &#39;rsa-sha256&#39; or &#39;ecdsa-sha256&#39;, &#39;ecdsa-sha384&#39;, &#39;ecdsa-sha512&#39;. (required)
   * @param date The current date in the HTTPs standard Date header format (see RFC7231: https://tools.ietf.org/html/rfc7231#section-7.1.1.2) (required)
   * @param digest The SHA-256 hash value of the requests body encoded in Base64. If the body is empty, it should be the SHA-256 value of the empty string. (required)
   * @param scope List of scopes for which an authorization request is asked, separated by space. Must not be empty and it is validated based on the subscriptions of your API. (required)
   * @param redirectUri URI where user is redirected to after authorization. Only required when your application is not registered in the ING Developer portal, and your are using PSD2 compliant eIDAS/OBIE certificates (optional)
   * @param countryCode Country Code 2 letter value(ISO 3166-1). The country code is optional, and allows you to redirect you user to a specific ING country login page. (optional)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /oauth2/authorization-server-url?redirect_uri={redirectUri}&scope={scope}&country_code={countryCode}")
  @Headers({
    "Accept: application/json",
    "Authorization: {authorization}",
    
    "Signature: {signature}",
    
    "Date: {date}",
    
    "Digest: {digest}"
  })
  ApiResponse<AuthorizationURLResponse> authorizationServerUrlUsingGETWithHttpInfo(@Param("authorization") String authorization, @Param("signature") String signature, @Param("date") String date, @Param("digest") String digest, @Param("scope") String scope, @Param("redirectUri") String redirectUri, @Param("countryCode") String countryCode);


  /**
   * Retrieve the ING Authorization server URL with a specific request identifier
   * This endpoint stores the received data and returns a object/body with a location property containing the authorize URI with a specific reference ID for request identification.  In case of error the API returns the error description.
   * Note, this is equivalent to the other <code>authorizationServerUrlUsingGET</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link AuthorizationServerUrlUsingGETQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param authorization Application access token (bearer) received in the Client Credentials grant flow (required)
   * @param signature Signature header as defined in https://tools.ietf.org/html/draft-cavage-http-signatures-10. ING requires the headers &#39;(request-target) date digest&#39;, and the algorithm is &#39;rsa-sha256&#39; or &#39;ecdsa-sha256&#39;, &#39;ecdsa-sha384&#39;, &#39;ecdsa-sha512&#39;. (required)
   * @param date The current date in the HTTPs standard Date header format (see RFC7231: https://tools.ietf.org/html/rfc7231#section-7.1.1.2) (required)
   * @param digest The SHA-256 hash value of the requests body encoded in Base64. If the body is empty, it should be the SHA-256 value of the empty string. (required)
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>redirectUri - URI where user is redirected to after authorization. Only required when your application is not registered in the ING Developer portal, and your are using PSD2 compliant eIDAS/OBIE certificates (optional)</li>
   *   <li>scope - List of scopes for which an authorization request is asked, separated by space. Must not be empty and it is validated based on the subscriptions of your API. (required)</li>
   *   <li>countryCode - Country Code 2 letter value(ISO 3166-1). The country code is optional, and allows you to redirect you user to a specific ING country login page. (optional)</li>
   *   </ul>
   * @return AuthorizationURLResponse
   */
  @RequestLine("GET /oauth2/authorization-server-url?redirect_uri={redirectUri}&scope={scope}&country_code={countryCode}")
  @Headers({
  "Accept: application/json",
      "Authorization: {authorization}",
      
      "Signature: {signature}",
      
      "Date: {date}",
      
      "Digest: {digest}"
  })
  AuthorizationURLResponse authorizationServerUrlUsingGET(@Param("authorization") String authorization, @Param("signature") String signature, @Param("date") String date, @Param("digest") String digest, @QueryMap(encoded=true) AuthorizationServerUrlUsingGETQueryParams queryParams);

  /**
  * Retrieve the ING Authorization server URL with a specific request identifier
  * This endpoint stores the received data and returns a object/body with a location property containing the authorize URI with a specific reference ID for request identification.  In case of error the API returns the error description.
  * Note, this is equivalent to the other <code>authorizationServerUrlUsingGET</code> that receives the query parameters as a map,
  * but this one also exposes the Http response headers
              * @param authorization Application access token (bearer) received in the Client Credentials grant flow (required)
              * @param signature Signature header as defined in https://tools.ietf.org/html/draft-cavage-http-signatures-10. ING requires the headers &#39;(request-target) date digest&#39;, and the algorithm is &#39;rsa-sha256&#39; or &#39;ecdsa-sha256&#39;, &#39;ecdsa-sha384&#39;, &#39;ecdsa-sha512&#39;. (required)
              * @param date The current date in the HTTPs standard Date header format (see RFC7231: https://tools.ietf.org/html/rfc7231#section-7.1.1.2) (required)
              * @param digest The SHA-256 hash value of the requests body encoded in Base64. If the body is empty, it should be the SHA-256 value of the empty string. (required)
      * @param queryParams Map of query parameters as name-value pairs
      *   <p>The following elements may be specified in the query map:</p>
      *   <ul>
          *   <li>redirectUri - URI where user is redirected to after authorization. Only required when your application is not registered in the ING Developer portal, and your are using PSD2 compliant eIDAS/OBIE certificates (optional)</li>
          *   <li>scope - List of scopes for which an authorization request is asked, separated by space. Must not be empty and it is validated based on the subscriptions of your API. (required)</li>
          *   <li>countryCode - Country Code 2 letter value(ISO 3166-1). The country code is optional, and allows you to redirect you user to a specific ING country login page. (optional)</li>
      *   </ul>
          * @return AuthorizationURLResponse
      */
      @RequestLine("GET /oauth2/authorization-server-url?redirect_uri={redirectUri}&scope={scope}&country_code={countryCode}")
      @Headers({
    "Accept: application/json",
          "Authorization: {authorization}",
      
          "Signature: {signature}",
      
          "Date: {date}",
      
          "Digest: {digest}"
      })
   ApiResponse<AuthorizationURLResponse> authorizationServerUrlUsingGETWithHttpInfo(@Param("authorization") String authorization, @Param("signature") String signature, @Param("date") String date, @Param("digest") String digest, @QueryMap(encoded=true) AuthorizationServerUrlUsingGETQueryParams queryParams);


   /**
   * A convenience class for generating query parameters for the
   * <code>authorizationServerUrlUsingGET</code> method in a fluent style.
   */
  public static class AuthorizationServerUrlUsingGETQueryParams extends HashMap<String, Object> {
    public AuthorizationServerUrlUsingGETQueryParams redirectUri(final String value) {
      put("redirect_uri", EncodingUtils.encode(value));
      return this;
    }
    public AuthorizationServerUrlUsingGETQueryParams scope(final String value) {
      put("scope", EncodingUtils.encode(value));
      return this;
    }
    public AuthorizationServerUrlUsingGETQueryParams countryCode(final String value) {
      put("country_code", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * Retrieve an application or customer access token, or refresh an access token
   *  This endpoint allows requesting an access token for one of the flows below:  ## Client Credentials (registered in the ING Developer portal) For authenticating your application and retrieving an application access token. Required request parameters: - grant_type&#x3D;client_credentials - scope (optional): If not provided, all the subscribed scopes will be returned  ## Client Credentials (without pre-registration using eIDAS/OBIE certificates supporting PSD2) For authenticating your application and retrieving an application access token without pre-registration in the ING Developer portal using eIDAS/OBIE certificates supporting PSD2. This flow will automatically subscribe your application to the allowed ING APIs based on the PSD2 roles in the certificate. The scopes in the application access token are based on the PSD2 roles. Required request parameters: - grant_type&#x3D;client_credentials - TPP-Signature-Certificate: PSD2 compliant Qualified Electronic Seal Certificate (QSealC)  ## Authorization Code For exchanging the authorization code for a customer access token.  Required request parameters: - grant_type&#x3D;authorization_code - code (required) - redirect_uri (optional)  ## Refresh Token For exchanging a refresh token for a new customer access token. Required request parameters: - grant_type&#x3D;refresh_token - refresh_token (required)    ## Access tokens and message signing   Most of our APIs require a combination of TLS and and request signing to verify the identity of the sender of the message and to verify that the message was not tampered with during transit.  While some APIs are currently using HTTP Signatures, ING is standardizing on the use of JWS for message signing as per the Open Banking Europe specification.    [Want to learn more about the JSON Web Signature specification for Open Banking?](https://www.openbankingeurope.eu/media/2096/obe-json-web-signature-profile-for-open-banking.pdf)    [Want to learn more about the HTTP Signature specification?](https://tools.ietf.org/html/draft-cavage-http-signatures-10)    ## Why is this important when requesting an access token?   An access token requested using the HTTP Signature approach can only be used for consuming APIs that use HTTP Signatures for message signing. An access token requested using   the Mutual TLS approach can only be used for consuming APIs that rely on JWS and / or Mutual TLS.   ## JSON Web Signature (JWS) and Mutual TLS (mTLS)   In addition to the required parameters mentioned above for the different authentication flows (Client Credentials, Authorization code and Refresh token), the following additional request parameters are required for use with JWS and mTLS :   - client_id (required)    ## HTTP Signature &#x60;DEPRECATED&#x60;   In addition to the required parameters mentioned above for the different authentication flows (Client Credentials, Authorization code and Refresh token), the following additional request parameters are required for use with HTTP Signature:   - Authorization (required)  - Digest (required) 
   * @param grantType OAuth 2.0 grant type (required)
   * @param authorization Optional field when requesting an access token for the &#39;client_credentials&#39; grant type that will be used for APIs that are using mTLS and/or JWS Signature.    Required field when requesting an access token for the &#39;client_credentials&#39; grant type that will be   used for APIs that are using HTTP Signature. In that case it is used for the the signature   authentication scheme as defined in https://tools.ietf.org/html/draft-cavage-http-signatures-10.   ING requires the headers &#39;(request-target) date digest&#39;, the client ID is used as keyID, and the algorithm   is &#39;rsa-sha256&#39; or &#39;ecdsa-sha256&#39;, &#39;ecdsa-sha384&#39;, &#39;ecdsa-sha512&#39;.    Required field for the &#39;authorization_code&#39; and &#39;refresh_token&#39;   grant type. In that case it is used for the bearer authentication scheme with the application access token. (optional)
   * @param signature Optional field when using the &#39;client_credentials&#39; grant type, or when requesting an access token that will be used for APIs that are using mTLS and/or JWS Signature.    Required field when using the &#39;authorization_code&#39; or &#39;refresh_token&#39; grant type when using HTTP Signature. In this case the Signature header is used for HTTP Signature as defined in https://tools.ietf.org/html/draft-cavage-http-signatures-10. ING requires the headers &#39;(request-target) date digest&#39;, and the algorithm is &#39;rsa-sha256&#39; or &#39;ecdsa-sha256&#39;, &#39;ecdsa-sha384&#39;, &#39;ecdsa-sha512&#39;. (optional)
   * @param date The current date in the HTTPs standard Date header format (see RFC7231: https://tools.ietf.org/html/rfc7231#section-7.1.1.2).    Optional field when using mTLS and/or JWS Signature.    Required field when using HTTP Signature. (optional)
   * @param digest The SHA-256 hash value of the request body encoded in Base64. If the body is empty, it should be the SHA-256 value of the empty string.    Optional field when using mTLS and/or JWS Signature.    Required field when using HTTP Signature. (optional)
   * @param tpPSignatureCertificate If your application is not registered in the ING Developer portal, you can add the PSD2 compliant Qualified Electronic Seal Certificate (QSealC) which you used for the signature in the client credentials grant type. The certificate (PEM format) needs to be the Base64 encoded (optional)
   * @param clientId The client_id for your registered application in the ING Developer portal.    Required field when requesting an access token for the &#39;client_credentials&#39; grant type that will be used for APIs that are using mTLS and/or JWS Signature.    Optional field in all other cases, eg when requesting an access token that will be used for APIs that are using HTTP Signature, or when using the &#39;authorization_code&#39; or &#39;refresh_token&#39; grant type. (optional)
   * @param scope Requested scopes in the &#39;client_credentials&#39; grant type. Optional field, if not provided the registered scopes will be used. Scopes are delimited by a space and the complete field should be application/x-www-form-urlencoded (optional)
   * @param code Required in the &#39;authorization_code&#39; grant type, value is the recieved authorization code from the authorization request (optional)
   * @param redirectUri Required in the &#39;authorization_code&#39; grant type, the &#39;redirect_uri&#39; parameter as included in the authorization request. (optional)
   * @param refreshToken Required in the &#39;refresh_token&#39; grant type, the refresh token issued. (optional)
   * @return TokenResponse
   */
  @RequestLine("POST /oauth2/token")
  @Headers({
    "Content-Type: application/x-www-form-urlencoded",
    "Accept: application/json",
    "Authorization: {authorization}",
    
    "Signature: {signature}",
    
    "Date: {date}",
    
    "Digest: {digest}",
    
    "TPP-Signature-Certificate: {tpPSignatureCertificate}"
  })
  TokenResponse getAccessTokenUsingPOST(@Param("grant_type") String grantType, @Param("authorization") String authorization, @Param("signature") String signature, @Param("date") String date, @Param("digest") String digest, @Param("tpPSignatureCertificate") String tpPSignatureCertificate, @Param("client_id") String clientId, @Param("scope") String scope, @Param("code") String code, @Param("redirect_uri") String redirectUri, @Param("refresh_token") String refreshToken);

  /**
   * Retrieve an application or customer access token, or refresh an access token
   * Similar to <code>getAccessTokenUsingPOST</code> but it also returns the http response headers .
   *  This endpoint allows requesting an access token for one of the flows below:  ## Client Credentials (registered in the ING Developer portal) For authenticating your application and retrieving an application access token. Required request parameters: - grant_type&#x3D;client_credentials - scope (optional): If not provided, all the subscribed scopes will be returned  ## Client Credentials (without pre-registration using eIDAS/OBIE certificates supporting PSD2) For authenticating your application and retrieving an application access token without pre-registration in the ING Developer portal using eIDAS/OBIE certificates supporting PSD2. This flow will automatically subscribe your application to the allowed ING APIs based on the PSD2 roles in the certificate. The scopes in the application access token are based on the PSD2 roles. Required request parameters: - grant_type&#x3D;client_credentials - TPP-Signature-Certificate: PSD2 compliant Qualified Electronic Seal Certificate (QSealC)  ## Authorization Code For exchanging the authorization code for a customer access token.  Required request parameters: - grant_type&#x3D;authorization_code - code (required) - redirect_uri (optional)  ## Refresh Token For exchanging a refresh token for a new customer access token. Required request parameters: - grant_type&#x3D;refresh_token - refresh_token (required)    ## Access tokens and message signing   Most of our APIs require a combination of TLS and and request signing to verify the identity of the sender of the message and to verify that the message was not tampered with during transit.  While some APIs are currently using HTTP Signatures, ING is standardizing on the use of JWS for message signing as per the Open Banking Europe specification.    [Want to learn more about the JSON Web Signature specification for Open Banking?](https://www.openbankingeurope.eu/media/2096/obe-json-web-signature-profile-for-open-banking.pdf)    [Want to learn more about the HTTP Signature specification?](https://tools.ietf.org/html/draft-cavage-http-signatures-10)    ## Why is this important when requesting an access token?   An access token requested using the HTTP Signature approach can only be used for consuming APIs that use HTTP Signatures for message signing. An access token requested using   the Mutual TLS approach can only be used for consuming APIs that rely on JWS and / or Mutual TLS.   ## JSON Web Signature (JWS) and Mutual TLS (mTLS)   In addition to the required parameters mentioned above for the different authentication flows (Client Credentials, Authorization code and Refresh token), the following additional request parameters are required for use with JWS and mTLS :   - client_id (required)    ## HTTP Signature &#x60;DEPRECATED&#x60;   In addition to the required parameters mentioned above for the different authentication flows (Client Credentials, Authorization code and Refresh token), the following additional request parameters are required for use with HTTP Signature:   - Authorization (required)  - Digest (required) 
   * @param grantType OAuth 2.0 grant type (required)
   * @param authorization Optional field when requesting an access token for the &#39;client_credentials&#39; grant type that will be used for APIs that are using mTLS and/or JWS Signature.    Required field when requesting an access token for the &#39;client_credentials&#39; grant type that will be   used for APIs that are using HTTP Signature. In that case it is used for the the signature   authentication scheme as defined in https://tools.ietf.org/html/draft-cavage-http-signatures-10.   ING requires the headers &#39;(request-target) date digest&#39;, the client ID is used as keyID, and the algorithm   is &#39;rsa-sha256&#39; or &#39;ecdsa-sha256&#39;, &#39;ecdsa-sha384&#39;, &#39;ecdsa-sha512&#39;.    Required field for the &#39;authorization_code&#39; and &#39;refresh_token&#39;   grant type. In that case it is used for the bearer authentication scheme with the application access token. (optional)
   * @param signature Optional field when using the &#39;client_credentials&#39; grant type, or when requesting an access token that will be used for APIs that are using mTLS and/or JWS Signature.    Required field when using the &#39;authorization_code&#39; or &#39;refresh_token&#39; grant type when using HTTP Signature. In this case the Signature header is used for HTTP Signature as defined in https://tools.ietf.org/html/draft-cavage-http-signatures-10. ING requires the headers &#39;(request-target) date digest&#39;, and the algorithm is &#39;rsa-sha256&#39; or &#39;ecdsa-sha256&#39;, &#39;ecdsa-sha384&#39;, &#39;ecdsa-sha512&#39;. (optional)
   * @param date The current date in the HTTPs standard Date header format (see RFC7231: https://tools.ietf.org/html/rfc7231#section-7.1.1.2).    Optional field when using mTLS and/or JWS Signature.    Required field when using HTTP Signature. (optional)
   * @param digest The SHA-256 hash value of the request body encoded in Base64. If the body is empty, it should be the SHA-256 value of the empty string.    Optional field when using mTLS and/or JWS Signature.    Required field when using HTTP Signature. (optional)
   * @param tpPSignatureCertificate If your application is not registered in the ING Developer portal, you can add the PSD2 compliant Qualified Electronic Seal Certificate (QSealC) which you used for the signature in the client credentials grant type. The certificate (PEM format) needs to be the Base64 encoded (optional)
   * @param clientId The client_id for your registered application in the ING Developer portal.    Required field when requesting an access token for the &#39;client_credentials&#39; grant type that will be used for APIs that are using mTLS and/or JWS Signature.    Optional field in all other cases, eg when requesting an access token that will be used for APIs that are using HTTP Signature, or when using the &#39;authorization_code&#39; or &#39;refresh_token&#39; grant type. (optional)
   * @param scope Requested scopes in the &#39;client_credentials&#39; grant type. Optional field, if not provided the registered scopes will be used. Scopes are delimited by a space and the complete field should be application/x-www-form-urlencoded (optional)
   * @param code Required in the &#39;authorization_code&#39; grant type, value is the recieved authorization code from the authorization request (optional)
   * @param redirectUri Required in the &#39;authorization_code&#39; grant type, the &#39;redirect_uri&#39; parameter as included in the authorization request. (optional)
   * @param refreshToken Required in the &#39;refresh_token&#39; grant type, the refresh token issued. (optional)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("POST /oauth2/token")
  @Headers({
    "Content-Type: application/x-www-form-urlencoded",
    "Accept: application/json",
    "Authorization: {authorization}",
    
    "Signature: {signature}",
    
    "Date: {date}",
    
    "Digest: {digest}",
    
    "TPP-Signature-Certificate: {tpPSignatureCertificate}"
  })
  ApiResponse<TokenResponse> getAccessTokenUsingPOSTWithHttpInfo(@Param("grant_type") String grantType, @Param("authorization") String authorization, @Param("signature") String signature, @Param("date") String date, @Param("digest") String digest, @Param("tpPSignatureCertificate") String tpPSignatureCertificate, @Param("client_id") String clientId, @Param("scope") String scope, @Param("code") String code, @Param("redirect_uri") String redirectUri, @Param("refresh_token") String refreshToken);



  /**
   * Revoke a customer refresh token.
   * This endpoint is used to revoke an existing token from a client.
   * @param authorization Application access token as bearer token (required)
   * @param token The customer refresh token that needs to be revoked. (required)
   * @param signature Optional field when when using an access token that was acquired through using mTLS and/or JWS Signature.    Required field when using HTTP Signature for message integrity. In this case the Signature header is used for HTTP Signature as defined in https://tools.ietf.org/html/draft-cavage-http-signatures-10. ING requires the headers &#39;(request-target) date digest&#39;, and the algorithm is &#39;rsa-sha256&#39; or &#39;ecdsa-sha256&#39;, &#39;ecdsa-sha384&#39;, &#39;ecdsa-sha512&#39;. (optional)
   * @param date The current date in the HTTPs standard Date header format (see RFC7231: https://tools.ietf.org/html/rfc7231#section-7.1.1.2).    Optional field when using mTLS and/or JWS Signature.    Required field when using HTTP Signature. (optional)
   * @param digest The SHA-256 hash value of the request body encoded in Base64. If the body is empty, it should be the SHA-256 value of the empty string.    Optional field when using mTLS and/or JWS Signature.    Required field when using HTTP Signature. (optional)
   * @param tokenTypeHint Token type (optional)
   */
  @RequestLine("POST /oauth2/token/revoke")
  @Headers({
    "Content-Type: application/x-www-form-urlencoded",
    "Accept: application/json",
    "Authorization: {authorization}",
    
    "Signature: {signature}",
    
    "Date: {date}",
    
    "Digest: {digest}"
  })
  void revokeRefreshTokenUsingPOST(@Param("authorization") String authorization, @Param("token") String token, @Param("signature") String signature, @Param("date") String date, @Param("digest") String digest, @Param("token_type_hint") String tokenTypeHint);

  /**
   * Revoke a customer refresh token.
   * Similar to <code>revokeRefreshTokenUsingPOST</code> but it also returns the http response headers .
   * This endpoint is used to revoke an existing token from a client.
   * @param authorization Application access token as bearer token (required)
   * @param token The customer refresh token that needs to be revoked. (required)
   * @param signature Optional field when when using an access token that was acquired through using mTLS and/or JWS Signature.    Required field when using HTTP Signature for message integrity. In this case the Signature header is used for HTTP Signature as defined in https://tools.ietf.org/html/draft-cavage-http-signatures-10. ING requires the headers &#39;(request-target) date digest&#39;, and the algorithm is &#39;rsa-sha256&#39; or &#39;ecdsa-sha256&#39;, &#39;ecdsa-sha384&#39;, &#39;ecdsa-sha512&#39;. (optional)
   * @param date The current date in the HTTPs standard Date header format (see RFC7231: https://tools.ietf.org/html/rfc7231#section-7.1.1.2).    Optional field when using mTLS and/or JWS Signature.    Required field when using HTTP Signature. (optional)
   * @param digest The SHA-256 hash value of the request body encoded in Base64. If the body is empty, it should be the SHA-256 value of the empty string.    Optional field when using mTLS and/or JWS Signature.    Required field when using HTTP Signature. (optional)
   * @param tokenTypeHint Token type (optional)
   */
  @RequestLine("POST /oauth2/token/revoke")
  @Headers({
    "Content-Type: application/x-www-form-urlencoded",
    "Accept: application/json",
    "Authorization: {authorization}",
    
    "Signature: {signature}",
    
    "Date: {date}",
    
    "Digest: {digest}"
  })
  ApiResponse<Void> revokeRefreshTokenUsingPOSTWithHttpInfo(@Param("authorization") String authorization, @Param("token") String token, @Param("signature") String signature, @Param("date") String date, @Param("digest") String digest, @Param("token_type_hint") String tokenTypeHint);


}
