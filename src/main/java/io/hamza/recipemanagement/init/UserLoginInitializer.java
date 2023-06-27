package io.hamza.recipemanagement.init;

import io.hamza.recipemanagement.userLogin.UserLogin;
import io.hamza.recipemanagement.userLogin.UserLoginService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.text.SimpleDateFormat;  
import java.util.Date;


@Component
public class UserLoginInitializer implements CommandLineRunner {

    private final UserLoginService userLoginService;

    public UserLoginInitializer(UserLoginService userLoginService) {
        this.userLoginService = userLoginService;
    }

    @Override
    public void run(String... args) throws Exception {

        if(userLoginService.getNumberOfUserLogins() > 1) {
            System.out.println("UserLogins already initialized!");
            return;
        }

        UserLogin userLogin1 = new UserLogin("Dennis Dennis","Dennis","jakarta jakarta jakarta jakarta jakarta jakarta jakarta jakarta jakarta jakarta","01/08/1998","password");
        UserLogin userLogin2 = new UserLogin("Juan Juan","Juan","jakarta jakarta jakarta jakarta jakarta jakarta jakarta jakarta jakarta jakarta","02/08/1998","password2");
        UserLogin userLogin3 = new UserLogin("Anton Anton","Anton","jakarta jakarta jakarta jakarta jakarta jakarta jakarta jakarta jakarta jakarta","03/08/1998","password3");

        userLoginService.createUserLogin(userLogin1);
        // userService.createUser(user2);
        // userService.createUser(user3);

    }
}
