package pl.coderslab.charity.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.charity.model.entity.Institution;
import pl.coderslab.charity.model.dto.InstitutionDto;
import pl.coderslab.charity.repository.InstitutionRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class InstitutionService {
    @Autowired
    InstitutionRepository institutionRepository;

    public List<Institution> getAllInstitutions() {
        List<Institution> allInstitutions = institutionRepository.findAllInstitutions();
        if (allInstitutions.isEmpty()){
            return null;
        }

        List<InstitutionDto> x = new ArrayList<>();
        for (Institution i : allInstitutions){
            x.add(new InstitutionDto(i.getId(), i.getName(), i.getDescription()));
        }

//
//        institutionRepository.findAllInstitutions().stream()
//                .map((e,s)->{e.getName()})

        return allInstitutions;
    }

    public Institution findInstitution(String id){
        Optional<Institution> byId = institutionRepository.findById(Long.valueOf(id));
        return byId.get();
    }

}
