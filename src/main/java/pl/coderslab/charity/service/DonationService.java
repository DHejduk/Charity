package pl.coderslab.charity.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.charity.model.dto.DonationDto;
import pl.coderslab.charity.model.entity.Category;
import pl.coderslab.charity.model.entity.Donation;
import pl.coderslab.charity.model.entity.Institution;
import pl.coderslab.charity.repository.DonationRepository;

import java.util.List;

@Service @Transactional
@RequiredArgsConstructor
public class DonationService {

    @Autowired
    DonationRepository donationRepository;


    public Integer getQuantity(){
        List<Donation> all = donationRepository.findAll();

        return all.stream()
                .map(Donation::getQuantity)
                .reduce(0, Integer::sum);

    }

    public Integer getNumberOfDonations(){
        List<Donation> all = donationRepository.findAll();
        return all.size();
    }

    public void saveDonation(DonationDto donationDto, List<Category> categories1, Institution institution){




        Donation donation = new Donation();

        donation.setQuantity(donationDto.getQuantity());
        donation.setCategories(categories1);
        donation.setInstitution(institution);
        donation.setStreet(donationDto.getStreet());
        donation.setCity(donationDto.getCity());
        donation.setPickUpDate(donationDto.getPickUpDate());
        donation.setPickUpTime(donationDto.getPickUpTime());
        donation.setPickUpComment(donationDto.getPickUpComment());

        donationRepository.save(donation);
    }


}
