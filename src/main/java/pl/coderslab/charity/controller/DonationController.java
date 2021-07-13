package pl.coderslab.charity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jms.JmsProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.model.dto.DonationDto;
import pl.coderslab.charity.model.entity.Category;
import pl.coderslab.charity.model.entity.Donation;
import pl.coderslab.charity.model.entity.Institution;
import pl.coderslab.charity.model.entity.User;
import pl.coderslab.charity.service.CategoryService;
import pl.coderslab.charity.service.DonationService;
import pl.coderslab.charity.service.InstitutionService;
import pl.coderslab.charity.service.UserService;

import java.util.List;

@Controller
public class DonationController {
    @Autowired
    InstitutionService institutionService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    DonationService donationService;
    @Autowired
    UserService userService;


    @GetMapping("/donate")
    public String showForm(Model model){
        User user = userService.getUser();

        if (user != null){
            model.addAttribute("user", user.getEmail());
        }else {
            model.addAttribute("user", "Anonim");
        }

        model
                .addAttribute("allInstitutions", institutionService.getAllInstitutions())
                .addAttribute("allCategories",categoryService.showAllCategories())
                .addAttribute("donationDto", new Donation());


        return "form";
    }

    @PostMapping("/donate")
    public String processForm(@ModelAttribute("donationDto")Donation donationDto){
        donationService.saveDonation(donationDto);
        return "redirect:/confirmation";
    }

    @GetMapping("/confirmation")
    public String showConfirm(){
        return "form-confirmation";
    }
}
