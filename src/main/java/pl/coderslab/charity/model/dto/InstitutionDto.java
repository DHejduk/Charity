package pl.coderslab.charity.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class InstitutionDto {
    @NotNull
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String description;
}
