package com.micro.plot.dto;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlotDto {
    @NotBlank(message = "Area can not be blank")
    @Size(min = 2,max = 30,message = "Name must be between 2 and 30 characters")
    private  String area;
    @NotBlank(message = "Colony can not be blank")
    @Size(min = 2,max = 100,message = "Name must be between 2 and 30 characters")
    private  String colonyName;
    @NotBlank(message = "City can not be blank")
    @Size(min = 2,max = 100,message = "City must be between 2 and 100 characters")
    private  String cityName;
    @Min(value = 6,message = "Pincode must be 6 digits")
    private  int pincode;
    @NotBlank(message = "Name can not be blank")
    private  String employeeId;
}
