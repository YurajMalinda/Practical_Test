package lk.ijse.gdse66.springboot.practicaltest.api;

import com.google.gson.Gson;
import lk.ijse.gdse66.springboot.practicaltest.entity.User;
import lombok.RequiredArgsConstructor;
import okhttp3.OkHttpClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class UserAPI {
    private final OkHttpClient client = new OkHttpClient();
    private final Gson gson;

    @PostMapping("/createUser")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> createUser(@RequestBody User user) {
        String json = gson.toJson(user);
    }
}
