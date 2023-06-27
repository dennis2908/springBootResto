package io.hamza.recipemanagement.userLogin;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserLoginService {
    private UserLoginRepository userLoginRepository;

    public UserLoginService(UserLoginRepository userLoginRepository) {
        this.userLoginRepository = userLoginRepository;
    }

    @Transactional
    public UserLogin createUserLogin(UserLogin userLogin){

        this.userLoginRepository.save(userLogin);

        return userLogin;
    }

    public List<UserLogin> getUserLogins(){
        System.out.println(this.userLoginRepository.findAll());
        return this.userLoginRepository.findAll();
    }

    public Long getNumberOfUserLogins(){
        return this.userLoginRepository.count();
    }
}