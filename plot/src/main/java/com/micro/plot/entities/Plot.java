package com.micro.plot.entities;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Plot")
public class Plot {
    @Id
    private  String id;
    @Column(length = 30)
    private  String area;
    @Column(length =100)
    private  String colonyName;
    @Column(length =100)
    private  String cityName;
    private  int pincode;
    private  String dateTime;
    private  String employeeId;
}
