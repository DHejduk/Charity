package pl.coderslab.charity.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.entity.InstitutionDto;
import pl.coderslab.charity.repository.InstitutionRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class InstitutionService {
    @Autowired
    InstitutionRepository institutionRepository;

    public List<InstitutionDto> getAllInstitutions() {
        List<Institution> allInstitutions = institutionRepository.findAllInstitutions();
        if (allInstitutions.isEmpty()){
            return null;
        }

        List<InstitutionDto> x = new ArrayList<>();
        for (Institution i : allInstitutions){
            x.add(new InstitutionDto(i.getName(), i.getDescription()));
        }
        return x;
    }
}
