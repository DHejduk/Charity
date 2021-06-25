package pl.coderslab.charity;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.service.DonationService;
import pl.coderslab.charity.service.InstitutionService;


@Controller
@RequiredArgsConstructor
public class HomeController {

    @Autowired
    DonationService donationService;

    @Autowired
    InstitutionService institutionService;

    @RequestMapping("/")
    public String homeAction(Model model){
        model
                .addAttribute("allInstitutions", institutionService.getAllInstitutions())
                .addAttribute("bags", donationService.getQuantity())
                .addAttribute("donations", donationService.getNumberOfDonations());
        return "index";
    }
}
