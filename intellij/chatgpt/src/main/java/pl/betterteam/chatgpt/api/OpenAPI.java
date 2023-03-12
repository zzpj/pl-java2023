package pl.betterteam.chatgpt.api;

import pl.betterteam.chatgpt.model.RequestObject;
import pl.betterteam.chatgpt.model.ResponseObject;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface OpenAPI {
    @POST("/v1/chat/completions")
    Call<ResponseObject> askChatGPT(@Body RequestObject requestObject);
}
