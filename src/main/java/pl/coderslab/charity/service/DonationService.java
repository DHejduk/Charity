package pl.coderslab.charity.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.repository.DonationRepository;

import java.util.List;

@Service @Transactional
@RequiredArgsConstructor
public class DonationService {

    @Autowired
    DonationRepository donationRepository;

    public Integer getQuantity(){
        List<Donation> all = donationRepository.findAll();
        if (all.isEmpty()){
            return 0;
        }
        return all.stream()
                .map(Donation::getQuantity)
                .reduce(0, Integer::sum);

    }

    public Integer getNumberOfDonations(){
        List<Donation> all = donationRepository.findAll();
        if (all.isEmpty()){
            return 0;
        }
        return all.size();
    }
}
