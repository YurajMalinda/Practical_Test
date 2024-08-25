package lk.ijse.gdse66.springboot.practicaltest.api;

import lk.ijse.gdse66.springboot.practicaltest.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.IOException;

@RestController
@RequestMapping("api/v1/user")
@CrossOrigin(origins = "*")
public class UserAPI {
    private final UserService userService;

    public UserAPI(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/createUser")
    @ResponseStatus(HttpStatus.CREATED)
    public String createUser(@RequestBody String data) throws IOException {
        return userService.create(data);
    }
}
