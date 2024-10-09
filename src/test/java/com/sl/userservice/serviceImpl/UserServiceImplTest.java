package com.sl.userservice.serviceImpl;

import com.sl.userservice.dto.UserDto;
import com.sl.userservice.model.User;
import com.sl.userservice.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.lang.NonNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class UserServiceImplTest {
//
//    private final User user1= User.builder()
//
//            .firstName("prasanna")
//            .lastName("kumar")
//            .email("pk@gmail.com")
//            .password("pk123")
//            .phone("123456")
//            .build();
//
//    private final User user2= User.builder()
//            .id(2L)
//            .firstName("john")
//            .lastName("cena")
//            .email("john@gmail.com")
//            .password("john123")
//            .phone("123456")
//            .build();

//    private final List<User> userList= Arrays.asList(user1, user2);

    private User user1;
    private User user2;

    private UserDto userDto;

    private List<User> userList;



    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userServiceImpl;

    @BeforeAll
    static void setUp() {
    		MockitoAnnotations.openMocks(UserServiceImplTest.class);
    }

    @BeforeEach
    void beforeEach(){

        user1= User.builder()
                .id(1L)
                .firstName("prasanna")
                .lastName("kumar")
                .email("pk@gmail.com")
                .password("pk123")
                .phone("123456")
                .build();
        user2= User.builder()
                .firstName("john")
                .lastName("cena")
                .email("john@gmail.com")
                .password("john123")
                .phone("123456")
                .build();
        userDto = new UserDto("prasanna", "kumar", "pk@gmailcom", "pk123" , "12345");
        userList = Arrays.asList(user1,user2);
    }


    @AfterEach
    void tearDown() {
    }

    @Test
    void saveUser() {

        User user = User.builder()
                .id(1L)
                .firstName("prasanna")
                .lastName("kumar")
                .email("pk@gmail.com")
                .password("pk123")
                .phone("123456")
                .build();

        UserDto userDto1= UserDto.builder()
                .firstName("prasanna")
                .lastName("kumar")
                .email("pk@gmail.com")
                .password("pk123")
                .phone("123456")
                .build();
        when(userRepository.save(Mockito.any(User.class))).thenReturn(user);
        UserDto savedUserDto = userServiceImpl.saveUser(userDto1);
        assertNotNull(savedUserDto);
        Mockito.verify(userRepository, Mockito.times(1)).save(Mockito.any(User.class));

    }

    @Test
    void deleteUserById() {
        Long userId=1L;
        Mockito.doNothing().when(userRepository).delete(user1);
        userServiceImpl.deleteUserById(userId);
        Mockito.verify(userRepository, Mockito.times(1)).delete(Mockito.any(User.class));

    }

    @Test
    void getAllUsers() {
        when(userRepository.findAll()).thenReturn(userList);
        List<User> users=userRepository.findAll();

        assertEquals(userList, users);

    }

    @Test
    void getUserById() {
        User savedUser=userRepository.save(user1);
        when(userRepository.findById(Mockito.anyLong())).thenReturn(Optional.ofNullable(user1));

        User user= userServiceImpl.getUserById(user1.getId());
        assertEquals(user1, user);
    }
}