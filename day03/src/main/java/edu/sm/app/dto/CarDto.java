package edu.sm.app.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CarDto {
    private int carId;
    private String carName;
    private String carColor;
    private Date carDate;
    private String carPrice;
    private String carFuel;

}