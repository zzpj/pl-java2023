package com.ing.developer.greetings.api;

import com.ing.developer.greetings.ApiClient;
import com.ing.developer.greetings.EncodingUtils;
import com.ing.developer.greetings.model.ApiResponse;

import com.ing.developer.greetings.model.Error;
import com.ing.developer.greetings.model.Greeting;
import java.time.OffsetDateTime;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import feign.*;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.5.0")
public interface ShowcaseApiApi extends ApiClient.Api {


  /**
   * Gives a greeting message using the HTTP message signature
   * Returns a message generated with a unique id and a timestamp indicating when it was produced.  ## Deprecation note: We are moving from HTTP signature. You still can use this endpoint in cases where you plan to consume endpoints that  require HTTP signature. But over time, all endpoints will require either JWS-signature or no signature  at all (MTLS-only). If you plan to consume such endpoints,  please use &#x60;/signed/greetings&#x60; or &#x60;/mtls-only/greetings&#x60; respectively
   * @param authorization OAuth2 Token (required)
   * @param signature An HTTP signature of the request by the third party on application level. See \&quot;Get Started\&quot; for more information on how to generate. (required)
   * @param digest SHA256 of the body. (required)
   * @param date Standard http header element for date and time. (required)
   * @return Greeting
   * @deprecated
   */
  @Deprecated
  @RequestLine("GET /greetings/single")
  @Headers({
    "Accept: application/json",
    "Authorization: {authorization}",
    
    "Signature: {signature}",
    
    "Digest: {digest}",
    
    "Date: {date}"
  })
  Greeting greetingsSingleGet(@Param("authorization") String authorization, @Param("signature") String signature, @Param("digest") String digest, @Param("date") OffsetDateTime date);

  /**
   * Gives a greeting message using the HTTP message signature
   * Similar to <code>greetingsSingleGet</code> but it also returns the http response headers .
   * Returns a message generated with a unique id and a timestamp indicating when it was produced.  ## Deprecation note: We are moving from HTTP signature. You still can use this endpoint in cases where you plan to consume endpoints that  require HTTP signature. But over time, all endpoints will require either JWS-signature or no signature  at all (MTLS-only). If you plan to consume such endpoints,  please use &#x60;/signed/greetings&#x60; or &#x60;/mtls-only/greetings&#x60; respectively
   * @param authorization OAuth2 Token (required)
   * @param signature An HTTP signature of the request by the third party on application level. See \&quot;Get Started\&quot; for more information on how to generate. (required)
   * @param digest SHA256 of the body. (required)
   * @param date Standard http header element for date and time. (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   * @deprecated
   */
  @Deprecated
  @RequestLine("GET /greetings/single")
  @Headers({
    "Accept: application/json",
    "Authorization: {authorization}",
    
    "Signature: {signature}",
    
    "Digest: {digest}",
    
    "Date: {date}"
  })
  ApiResponse<Greeting> greetingsSingleGetWithHttpInfo(@Param("authorization") String authorization, @Param("signature") String signature, @Param("digest") String digest, @Param("date") OffsetDateTime date);



  /**
   * Gives a greeting message using only mTLS and no message signature
   * Returns a message generated with a unique id and a timestamp indicating when it was produced.
   * @param authorization OAuth2 Token (required)
   * @return Greeting
   */
  @RequestLine("GET /mtls-only/greetings")
  @Headers({
    "Accept: application/json",
    "Authorization: {authorization}"
  })
  Greeting mtlsOnlyGreetingsGet(@Param("authorization") String authorization);

  /**
   * Gives a greeting message using only mTLS and no message signature
   * Similar to <code>mtlsOnlyGreetingsGet</code> but it also returns the http response headers .
   * Returns a message generated with a unique id and a timestamp indicating when it was produced.
   * @param authorization OAuth2 Token (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /mtls-only/greetings")
  @Headers({
    "Accept: application/json",
    "Authorization: {authorization}"
  })
  ApiResponse<Greeting> mtlsOnlyGreetingsGetWithHttpInfo(@Param("authorization") String authorization);



  /**
   * Gives a greeting message using the JWS message signature
   * Returns a message generated with a unique id and a timestamp indicating when it was produced.
   * @param authorization OAuth2 Token. (required)
   * @param xJWSSignature A JWS signature of the request message on application level. Supported signing algorithms are: - PS256 - RSASSA-PSS using SHA-256 and MGF1 with SHA-256 (this translates to RSASSA-PSS with hashAlgorithm:SHA-256, maskGenAlgorithm: MGF1 with SHA-256, saltLength:32) - PS384 - RSASSA-PSS using SHA-384 and MGF1 with SHA-384 (this translates to RSASSA-PSS with hashAlgorithm:SHA-384, maskGenAlgorithm: MGF1 with SHA-384, saltLength:48) - PS512 - RSASSA-PSS using SHA-512 and MGF1 with SHA-512 (this translates to RSASSA-PSS with hashAlgorithm:SHA-512, maskGenAlgorithm: MGF1 with SHA-512, saltLength:64) - ES256 - ECDSA using P-256 and SHA-256 - ES384 - ECDSA using P-384 and SHA-384 - ES512 - ECDSA using P-521 and SHA-512  ECDSA elliptic curves supported: BrainpoolP256r1, BrainpoolP384r1, BrainpoolP512r1, NIST Curve P-256, NIST Curve P-384, NIST Curve P-521  See \&quot;Get Started\&quot; for more information on how to generate the signature. (required)
   * @param digest SHA256 of the body. (required)
   * @param contentType The \&quot;content-type\&quot; header is used to indicate what type of media or resource is being used for the payload in the request. The value of the header should be application/x-www-form-urlencoded. (required)
   * @return Greeting
   */
  @RequestLine("GET /signed/greetings")
  @Headers({
    "Accept: application/json",
    "Authorization: {authorization}",
    
    "X-JWS-Signature: {xJWSSignature}",
    
    "Digest: {digest}",
    
    "Content-type: {contentType}"
  })
  Greeting signedGreetingsGet(@Param("authorization") String authorization, @Param("xJWSSignature") String xJWSSignature, @Param("digest") String digest, @Param("contentType") String contentType);

  /**
   * Gives a greeting message using the JWS message signature
   * Similar to <code>signedGreetingsGet</code> but it also returns the http response headers .
   * Returns a message generated with a unique id and a timestamp indicating when it was produced.
   * @param authorization OAuth2 Token. (required)
   * @param xJWSSignature A JWS signature of the request message on application level. Supported signing algorithms are: - PS256 - RSASSA-PSS using SHA-256 and MGF1 with SHA-256 (this translates to RSASSA-PSS with hashAlgorithm:SHA-256, maskGenAlgorithm: MGF1 with SHA-256, saltLength:32) - PS384 - RSASSA-PSS using SHA-384 and MGF1 with SHA-384 (this translates to RSASSA-PSS with hashAlgorithm:SHA-384, maskGenAlgorithm: MGF1 with SHA-384, saltLength:48) - PS512 - RSASSA-PSS using SHA-512 and MGF1 with SHA-512 (this translates to RSASSA-PSS with hashAlgorithm:SHA-512, maskGenAlgorithm: MGF1 with SHA-512, saltLength:64) - ES256 - ECDSA using P-256 and SHA-256 - ES384 - ECDSA using P-384 and SHA-384 - ES512 - ECDSA using P-521 and SHA-512  ECDSA elliptic curves supported: BrainpoolP256r1, BrainpoolP384r1, BrainpoolP512r1, NIST Curve P-256, NIST Curve P-384, NIST Curve P-521  See \&quot;Get Started\&quot; for more information on how to generate the signature. (required)
   * @param digest SHA256 of the body. (required)
   * @param contentType The \&quot;content-type\&quot; header is used to indicate what type of media or resource is being used for the payload in the request. The value of the header should be application/x-www-form-urlencoded. (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /signed/greetings")
  @Headers({
    "Accept: application/json",
    "Authorization: {authorization}",
    
    "X-JWS-Signature: {xJWSSignature}",
    
    "Digest: {digest}",
    
    "Content-type: {contentType}"
  })
  ApiResponse<Greeting> signedGreetingsGetWithHttpInfo(@Param("authorization") String authorization, @Param("xJWSSignature") String xJWSSignature, @Param("digest") String digest, @Param("contentType") String contentType);


}
