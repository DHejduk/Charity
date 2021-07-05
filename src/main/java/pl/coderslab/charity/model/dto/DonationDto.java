package pl.coderslab.charity.model.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data @RequiredArgsConstructor
public class DonationDto {
     private List<CategoryDto> category;
//   private String[] category;
    private Integer quantity;
//    private String institution;
    private InstitutionDto institution;
    private String street;
    private String city;
    private String zipCode;
    private String phoneNumber;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate pickUpDate;

    private LocalTime pickUpTime;
    private String pickUpComment;
}
