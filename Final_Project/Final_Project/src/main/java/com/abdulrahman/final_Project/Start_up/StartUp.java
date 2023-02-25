package com.abdulrahman.final_Project.Start_up;

import com.abdulrahman.final_Project.Appointments.Appointments;
import com.abdulrahman.final_Project.Feedback.Feedback;
import com.abdulrahman.final_Project.Review.Review;
import com.abdulrahman.final_Project.StartUpDetails.StartUpDetails;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class StartUp
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    @NotNull
    private String name;


    @NotEmpty
    @NotNull
    private String industry;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "startUp")
    @PrimaryKeyJoinColumn
    @JsonIgnore
    private List<Appointments> appointments;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "startUp")
    @PrimaryKeyJoinColumn
    private List<Review> review;
    @OneToOne(cascade = CascadeType.ALL,mappedBy = "startUp")
    @PrimaryKeyJoinColumn
    private StartUpDetails details;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "startUp")
    @PrimaryKeyJoinColumn
    private List<Feedback> feedbacks;
//    @ManyToMany(mappedBy = "customers")
//    @JsonIgnore
//    private List<Store> stores;


    public void addAppointmentToMyAppointments(Appointments appointment){
        appointments.add(appointment);
    }


}
