package pl.coderslab.charity;

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
import pl.coderslab.charity.service.CategoryService;
import pl.coderslab.charity.service.DonationService;
import pl.coderslab.charity.service.InstitutionService;

import java.util.List;

@Controller
public class DonationController {
    @Autowired
    InstitutionService institutionService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    DonationService donationService;

    @GetMapping("/donate")
    public String showForm(Model model){
        model
                .addAttribute("allInstitutions", institutionService.getAllInstitutions())
                .addAttribute("allCategories",categoryService.showAllCategories())
                .addAttribute("donationDto", new DonationDto());


        return "form";
    }

    @PostMapping("/donate")
    public String processForm(@ModelAttribute("donationDto")DonationDto donationDto){
        String[] categories = donationDto.getCategory();
        List<Category> categories1 = null;
        if (categories != null){
            categories1 = categoryService.getCategories(categories);
        }
        Institution institution = institutionService.findInstitution(donationDto.getInstitution());

        donationService.saveDonation(donationDto,categories1,institution);

        return "form-confirmation";
    }
}
