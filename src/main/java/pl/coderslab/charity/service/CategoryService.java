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

    public List<Category> showAllCategories() {
        return categoryRepository.findAll();
    }

    public List<Category> getCategories(String[] categoriesId) {
        List<Category> result = new ArrayList<>();
        List<Category> all = categoryRepository.findAll();
        for (String s : categoriesId) {
            for (Category c : all) {
                if (c.getId().equals(Long.valueOf(s))) {
                    result.add(c);
                }
            }
        }


        return result;
    }


}
