package pl.coderslab.charity.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data @RequiredArgsConstructor
public class UserDto {
    private String email;

    private String password;

    private String matchingPassword;
}
