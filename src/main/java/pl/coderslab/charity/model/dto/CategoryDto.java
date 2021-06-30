package pl.coderslab.charity.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import pl.coderslab.charity.model.entity.Donation;

import javax.persistence.Column;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import java.util.List;
@Data @AllArgsConstructor
public class CategoryDto {
    @NotNull
    private Long id;
    @NotNull
    private String name;


}
