package com.sl.userservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserDto{
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;

}
