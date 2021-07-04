package pl.coderslab.charity.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.model.dto.UserDto;
import pl.coderslab.charity.service.UserService;

@Controller @RequiredArgsConstructor
public class UserRegistrationController {

    @Autowired
    private final UserService userService;

    @GetMapping("/signup")
    public String signup(Model model){
        model.addAttribute("userDto", new UserDto());
        return "register";
    }

    @PostMapping("/signup")
    public String processSignupForm(@ModelAttribute("userDto")UserDto userDto){
        boolean b = userService.userExists(userDto.getEmail());
        if (!b || !userDto.getMatchingPassword().equals(userDto.getPassword())){
            return "redirect:/signup";
        }
        userService.createUser(userDto);
        return "redirect:/login";
    }

}
