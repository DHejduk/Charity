package pl.coderslab.charity.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.charity.model.dto.CategoryDto;
import pl.coderslab.charity.model.entity.Category;
import pl.coderslab.charity.repository.CategoryRepository;
import pl.coderslab.charity.repository.DonationRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public List<CategoryDto> showAllCategories(){
        List<Category> all = categoryRepository.findAll();
        List<CategoryDto> x = new ArrayList<>();
        for (Category c : all){
            x.add(new CategoryDto(c.getId(), c.getName()));
        }

        return x;
    }
}
