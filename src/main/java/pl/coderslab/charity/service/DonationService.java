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
        return donationRepository.findAll().stream()
                .map(Donation::getQuantity)
                .reduce(0, Integer::sum);

    }

    public Integer getNumberOfDonations(){
        return donationRepository.findAll().size();
    }

    public void saveDonation(Donation donationDto){
        donationRepository.save(donationDto);
    }

}
