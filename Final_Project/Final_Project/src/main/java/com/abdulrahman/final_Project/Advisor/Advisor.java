package com.abdulrahman.final_Project.Advisor;

import com.abdulrahman.final_Project.AdvisorDetails.AdvisorDetails;
import com.abdulrahman.final_Project.Appointments.Appointments;
import com.abdulrahman.final_Project.Feedback.Feedback;
import com.abdulrahman.final_Project.Review.Review;
import com.abdulrahman.final_Project.StartUpDetails.StartUpDetails;
import com.abdulrahman.final_Project.Start_up.StartUp;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Advisor {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        @NotEmpty
        @NotNull
        private String name;

        @NotEmpty
        @NotNull
        private String speciality;
        @OneToMany(cascade = CascadeType.ALL,mappedBy = "advisor")
        @PrimaryKeyJoinColumn
        @JsonIgnore
        private List<Appointments> appointments;
        @OneToOne(cascade = CascadeType.ALL,mappedBy = "advisor")
        @PrimaryKeyJoinColumn
        private AdvisorDetails details;

        @OneToMany(cascade = CascadeType.ALL,mappedBy = "advisor")
        @PrimaryKeyJoinColumn
        private List<Review> reviews;

        @OneToMany(cascade = CascadeType.ALL,mappedBy = "advisor")
        @PrimaryKeyJoinColumn
        private List<Feedback> feedbacks;


//    @ManyToMany(mappedBy = "customers")
//    @JsonIgnore
//    private List<Store> stores;


        public void addAppointmentToMyAppointments(Appointments appointment){
            appointments.add(appointment);
        }


    }


