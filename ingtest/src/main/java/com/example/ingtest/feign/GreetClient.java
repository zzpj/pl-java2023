package com.example.ingtest.feign;

import com.example.ingtest.IngTestApplication;
import com.example.ingtest.config.GreetConfig;
import com.ing.developer.greetings.api.ShowcaseApiApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(
        name = "Greet",
        configuration = GreetConfig.class,
        url = IngTestApplication.ING_SANDBOX_API
)
public interface GreetClient extends ShowcaseApiApi {
}
