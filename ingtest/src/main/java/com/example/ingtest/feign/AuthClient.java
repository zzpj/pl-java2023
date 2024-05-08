package com.example.ingtest.feign;

import com.example.ingtest.IngTestApplication;
import com.example.ingtest.config.AuthConfig;
import com.ing.developer.oauth2.api.DefaultApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(
        name = "Auth",
        configuration = AuthConfig.class,
        url = IngTestApplication.ING_SANDBOX_API
)
public interface AuthClient extends DefaultApi {
}
