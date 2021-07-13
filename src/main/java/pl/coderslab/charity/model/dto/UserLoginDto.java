package pl.coderslab.charity.model.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data @RequiredArgsConstructor
public class UserLoginDto {

    private String email;

    private String password;
}
