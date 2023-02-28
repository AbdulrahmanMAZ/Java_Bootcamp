package com.abdulrahman.final_Project.Advisor;

import com.abdulrahman.final_Project.AdvisorDetails.AdvisorDetails;
import com.abdulrahman.final_Project.Appointments.Appointments;
import com.abdulrahman.final_Project.Feedback.Feedback;
import com.abdulrahman.final_Project.MyUser.MyUser;
import com.abdulrahman.final_Project.Review.Review;
import com.abdulrahman.final_Project.StartUpDetails.StartUpDetails;
import com.abdulrahman.final_Project.Start_up.StartUp;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Advisor {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Integer id;

//        @NotEmpty
//        @NotNull
//        private String name;

        @NotEmpty
        @NotNull
        private String speciality;
        @NotNull
        @PositiveOrZero
        private Integer feePerHour;
        @PositiveOrZero
        private Integer Wallet=0;


        @Min(1)
        @Max(5)
        @Digits(integer = 1,fraction = 1)
        private BigDecimal rating=new BigDecimal(1);


        @OneToOne
        @MapsId
        @JsonIgnore
        @JoinColumn(name = "id")
        private MyUser user;




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

        public void addMoneyToWallet(Integer fee){
                this.Wallet += fee;
        }
        public void refund(Integer fee){
                this.Wallet -= fee;
        }

    }


