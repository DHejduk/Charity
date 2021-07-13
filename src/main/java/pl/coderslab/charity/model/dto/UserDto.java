package pl.coderslab.charity.model.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import pl.coderslab.charity.security.validator.ValidPassword;

@Data @RequiredArgsConstructor
public class UserDto {
    private String email;

    @ValidPassword
    private String password;

    private String matchingPassword;
}
