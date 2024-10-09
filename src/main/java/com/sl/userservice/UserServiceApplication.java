package com.sl.userservice;

import com.sl.userservice.dto.UserDto;
import com.sl.userservice.model.User;
import com.sl.userservice.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }

    @Autowired
    public UserRepository userRepository;
//    @PostConstruct
//    public String insertUsers(){
//        for(int i=0; i<5; i++){
//            User user = new User((long) i,"user"+i, "last"+i, "user@gmail.com"+i, "password"+i,"phone"+i);
//            userRepository.save(user);
//        }
//        return "users added";
//    }

}
