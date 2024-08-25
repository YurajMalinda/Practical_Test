package lk.ijse.gdse66.springboot.practicaltest.service;

import okhttp3.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class UserService {
    @Value("${weavy.api.url}")
    private String apiUrl;

    @Value("${weavy.api.key}")
    private String apiKey;

    private final OkHttpClient client = new OkHttpClient();

    public String create(String jsonBody) throws IOException {
        RequestBody body = RequestBody.create(jsonBody, MediaType.get("application/json"));

        Request request = new Request.Builder()
                .url(apiUrl + "/api/users")
                .post(body)
                .header("Authorization", "Bearer " + apiKey)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }
            return response.body().string();
        }
    }

}
