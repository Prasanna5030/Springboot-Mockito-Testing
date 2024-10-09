package com.sl.userservice.repository;

import com.sl.userservice.model.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class UserRepositoryTest {

    public final User user1 = User.builder()
            .id(1L)
                .firstName("prasanna")
                .lastName("kumar")
                .email("pk@gmail.com")
                .phone("123456")
                .password("pk123")
                .build();


    private final User user2= User.builder()
            .id(2L)
            .firstName("john")
            .lastName("cena")
            .email("john@gmail.com")
            .password("john123")
            .phone("123456")
            .build();

    private final List<User> userList= Arrays.asList(user1, user2);


    @Autowired
    private UserRepository userRepository;

    @Test
    public void shouldTestSaveUser(){

        User savedUser = userRepository.save(user1);
        Assertions.assertThat(savedUser).isNotNull();
        Assertions.assertThat(savedUser.getId()).isEqualTo(1);

    }


    @Test
    public void shouldTestGetAllUsers(){

        User usr1 = User.builder()

                .firstName("prasanna")
                .lastName("kumar")
                .email("pk@gmail.com")
                .phone("123456")
                .password("pk123")
                .build();


        User usr2= User.builder()
                .id(2L)
                .firstName("john")
                .lastName("cena")
                .email("john@gmail.com")
                .password("john123")
                .phone("123456")
                .build();

        userRepository.save(usr1);
        userRepository.save(usr2);
        List<User> users = userRepository.findAll();
        for(User user: users){
            System.out.println(user);
        }
        Assertions.assertThat(users).isNotNull();
        org.junit.jupiter.api.Assertions.assertEquals(userList, users);


    }


    @Test
    public void shouldTestGetUserById(){
        Optional<User> user=userRepository.findById(user1.getId());

        user.ifPresent(value -> org.junit.jupiter.api.Assertions.assertEquals(user1, value));
        user.ifPresent(val->Assertions.assertThat(val).isNotNull());

    }

    @Test
    public void shouldTestDeleteUserById(){
        Optional<User> optionalUser = userRepository.findById(user1.getId());

        List<User> userList1=userRepository.findAll();
        for(User u : userList1){
            System.out.println(u);
        }
        optionalUser.ifPresent(user -> userRepository.delete(user));

       optionalUser.ifPresent(userObj->Assertions.assertThat(userObj).isNotNull());
        optionalUser.ifPresent(user-> org.junit.jupiter.api.Assertions.assertEquals(user1, user));


    }


}
