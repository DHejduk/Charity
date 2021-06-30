package pl.coderslab.charity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.charity.model.dto.DonationDto;
import pl.coderslab.charity.service.CategoryService;
import pl.coderslab.charity.service.InstitutionService;

@Controller
public class DonationController {
    @Autowired
    InstitutionService institutionService;
    @Autowired
    CategoryService categoryService;

    @GetMapping("/donate")
    public String showForm(Model model){
        model
                .addAttribute("allInstitutions", institutionService.getAllInstitutions())
                .addAttribute("allCategories",categoryService.showAllCategories())
                .addAttribute("donationDto", new DonationDto());
        return "form";
    }
}
