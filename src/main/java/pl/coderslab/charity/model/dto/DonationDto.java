package pl.coderslab.charity.model.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data @RequiredArgsConstructor
public class DonationDto {
   private List<CategoryDto> category;
    private Integer quantity;
    private InstitutionDto institution;
    private String street;
    private String city;
    private String zipCode;
    private String phoneNumber;
    private LocalDate pickUpDate;
    private LocalTime pickUpTime;
    private String pickUpComment;
}
