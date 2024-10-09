package com.sl.userservice.serviceImpl;

import com.sl.userservice.dto.UserDto;
import com.sl.userservice.model.User;
import com.sl.userservice.repository.UserRepository;
import com.sl.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public UserDto saveUser(UserDto userDto) {
//        User user = User.builder()
//                .firstName(userDto.firstName())
//                .lastName(userDto.lastName())
//                .email(userDto.email())
//                .phone(userDto.phone())
//                .password(userDto.password())
//                .build();
//     User savedUser=   userRepository.save(user);
//
//        UserDto userDto1= UserDto.builder()
//                .firstName(user.getFirstName())
//                .lastName(user.getLastName())
//                .email(user.getEmail())
//                .password(user.getPassword())
//                .phone(user.getPhone())
//                .build();
//
//       return userDto1;

      User user= User.builder().
              firstName(userDto.getFirstName())
               .lastName(userDto.getLastName())
              .email(userDto.getEmail())
              .password(userDto.getPassword())
              .phone(userDto.getPhone())
              .build();

        User savedUser = userRepository.save(user);

        // Convert savedUser back to UserDto and return
      UserDto userDto1 = UserDto.builder()
              .firstName(user.getFirstName())
              .lastName(user.getLastName())
              .email(user.getEmail())
              .phone(user.getPhone())
              .password(user.getPassword())
              .build();
      return userDto1;

    }

    @Override
    public void deleteUserById(Long id) {
       Optional<User> optionalUser= userRepository.findById(id);
       if(optionalUser.isPresent()){
           userRepository.delete(optionalUser.get());
       }
       else{
           throw new RuntimeException("User not found");
       }

    }


//    @Override
//    public String updateUser(UserDto userDto) {
//        Optional<User>  optionalUser = userRepository.findById(userDto.id());
//        if(optionalUser!=null){
//            User user = User.builder()
//                    .firstName(userDto.firstName())
//                    .lastName(userDto.lastName())
//                    .email(userDto.email())
//                    .phone(userDto.phone())
//                    .password(userDto.password())
//                    .build();
//            userRepository.save(user);
//            return "user updated successfully";
//        }
//        else{
//            throw new RuntimeException("user not found");
//
//        }
//    }

    @Override
    public List<User> getAllUsers() {

        List<User> userList = userRepository.findAll();
      return userList;
    }

    @Override
    public User getUserById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isPresent()) {
           User user= optionalUser.get();
//           UserDto userDto= UserDto.builder()
//                   .firstName(user.getFirstName())
//                   .lastName(user.getLastName())
//                   .email(user.getEmail())
//                   .password(user.getPassword())
//                   .phone(user.getPhone())
//                   .build();
           return user;
        }
        else{
            return null;
        }
    }
}
