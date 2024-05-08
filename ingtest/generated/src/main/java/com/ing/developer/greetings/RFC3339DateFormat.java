/*
 * Showcase API
 * Our Showcase API allows you to test the connectivity to ING in the sandbox and production environment from your application. By connecting to this API, you will learn the flow and can apply it to connect to other APIs and create your application.  This API has a GET endpoint for each connection pattern:      - `/signed/greetings` - using JWS message signature - `/mtls-only/greetings` - using only mTLS and no message signature - `/greetings/single` - using HTTP message signature  The response to a successful request is a message similar to the example below:  ``` {\\\"message\\\":\\\"Welcome to ING!\\\",\\\"id\\\":\\\"0d69d706-1e4a-4e2e-ac8d-f49bc8a31d1c\\\",\\\"messageTimestamp\\\":\\\"2018-07-30 13:23:53 GMT\\\"} ```  To consume the Showcase API in the production environment you need to create an account, subscribe to the API and request an application token as explained in the production section of the [Get started guide for Premium APIs](https://developer.ing.com/openbanking/resources/get-started/premium). The subscription to the API will need to be approved by ING before you can call the Showcase API.  To consume the Showcase API in the sandbox environment you can use the example certificates and client id provided in the [Get started guide for Premium APIs.](https://developer.ing.com/openbanking/resources/get-started/premium)
 *
 * The version of the OpenAPI document: 5.0.0
 * Contact: apis@ing.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.ing.developer.greetings;

import com.fasterxml.jackson.databind.util.StdDateFormat;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.util.Date;
import java.text.DecimalFormat;
import java.util.GregorianCalendar;
import java.util.TimeZone;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.5.0")
public class RFC3339DateFormat extends DateFormat {
  private static final long serialVersionUID = 1L;
  private static final TimeZone TIMEZONE_Z = TimeZone.getTimeZone("UTC");

  private final StdDateFormat fmt = new StdDateFormat()
          .withTimeZone(TIMEZONE_Z)
          .withColonInTimeZone(true);

  public RFC3339DateFormat() {
    this.calendar = new GregorianCalendar();
    this.numberFormat = new DecimalFormat();
  }

  @Override
  public Date parse(String source) {
    return parse(source, new ParsePosition(0));
  }

  @Override
  public Date parse(String source, ParsePosition pos) {
    return fmt.parse(source, pos);
  }

  @Override
  public StringBuffer format(Date date, StringBuffer toAppendTo, FieldPosition fieldPosition) {
    return fmt.format(date, toAppendTo, fieldPosition);
  }

  @Override
  public Object clone() {
    return super.clone();
  }
}
