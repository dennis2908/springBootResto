package io.hamza.recipemanagement.userLogin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Controller;

import java.util.List;

@RestController
@RequestMapping("/api/userLogins")
public class UserLoginController {

    private final UserLoginService userLoginService;

    public UserLoginController(UserLoginService userLoginService) {
        this.userLoginService = userLoginService;
    }

    @GetMapping
    public List<UserLogin> getAllUserLogins(){
        return userLoginService.getUserLogins();
    }

}
