package pl.betterteam.chatgpt.api;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class ApiBuilder {

    private ApiBuilder() {
    }

    private static final String API_BASE_URL = "https://api.openai.com/";

    public static OpenAPI build() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .client(new OkHttpClient.Builder()
                        .addInterceptor(chain -> {
                            Request requestBuilder = chain.request().newBuilder()
                                    .addHeader("Accept", "application/json")
                                    .addHeader("Authorization", "Bearer " + System.getenv("OPENAIKEY"))
                                    .build();
                            return chain.proceed(requestBuilder);
                        })
                        .build())
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
        return retrofit.create(OpenAPI.class);
    }
}
