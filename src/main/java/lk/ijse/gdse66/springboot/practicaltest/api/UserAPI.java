package lk.ijse.gdse66.springboot.practicaltest.api;

import com.google.gson.Gson;
import lk.ijse.gdse66.springboot.practicaltest.dto.UserDTO;
import lk.ijse.gdse66.springboot.practicaltest.entity.User;
import lombok.RequiredArgsConstructor;
import okhttp3.*;
import okhttp3.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class UserAPI {
    private final OkHttpClient client = new OkHttpClient();
    private final Gson gson = new Gson();

    @PostMapping("/createUser")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> createUser(@org.springframework.web.bind.annotation.RequestBody UserDTO userDTO) {
        String json = gson.toJson(userDTO);
        RequestBody body = RequestBody.create(json, MediaType.get("application/json; charset=utf-8"));

        Request request = new Request.Builder().url("https://5b380a1693a245608c1ff6f37433aa61.weavy.io").post(body).build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                return ResponseEntity.status(response.code()).body("Failed to create user");
            }
            return ResponseEntity.ok(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
        }
    }
}
