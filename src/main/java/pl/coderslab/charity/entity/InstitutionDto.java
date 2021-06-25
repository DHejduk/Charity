package pl.coderslab.charity.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class InstitutionDto {
    @NotNull
    private String name;

    @NotNull
    private String description;
}
