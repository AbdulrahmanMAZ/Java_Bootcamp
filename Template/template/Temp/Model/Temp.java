package com.abdulrahman.exercise21.Temp.Model;


import com.abdulrahman.exercise21.TempDetails.Model.TempDetails;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Temp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "Temp")
    @PrimaryKeyJoinColumn
    private TempDetails TempDetails;




}
