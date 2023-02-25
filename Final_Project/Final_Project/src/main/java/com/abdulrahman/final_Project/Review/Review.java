package com.abdulrahman.final_Project.Review;
import com.abdulrahman.final_Project.Advisor.Advisor;
import com.abdulrahman.final_Project.Start_up.StartUp;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Review {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    @NotEmpty
    private String title;
    @NotNull
    @NotEmpty
    private String content;
    @NotNull
    @Min(1)
    @Max(5)
    private Integer rating;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "startUp_id")
    private StartUp startUp;

     @ManyToOne
     @JsonIgnore
     @JoinColumn(name = "advisor_id")
     private Advisor advisor;



}
