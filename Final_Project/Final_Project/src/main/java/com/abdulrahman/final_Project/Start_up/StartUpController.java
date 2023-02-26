package com.abdulrahman.final_Project.Start_up;

import com.abdulrahman.final_Project.Appointments.Appointments;
import com.abdulrahman.final_Project.Feedback.Feedback;
import com.abdulrahman.final_Project.MyUser.MyUser;
import com.abdulrahman.final_Project.Review.Review;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v3/start-up")
@RequiredArgsConstructor
public class StartUpController {

    // ServiceInjection
    private final StartUpService startUpService;

    // getter
    @GetMapping("/get_start_up")
    public List<StartUp> getBooks(){
        return startUpService.getStartUps();
    }
    @PostMapping("/add_start_up")

    public ResponseEntity addBooks( @RequestBody StartUp startUp){
                startUpService.addStartUp(startUp);
                return ResponseEntity.status(200).body("Success");

    }
    @PutMapping("/edit_start_up")
    public ResponseEntity updateBooks(@PathVariable Integer id, @RequestBody StartUp startUp){
        startUpService.editStartUp(id, startUp);
        return ResponseEntity.status(200).body("Updated");

    }
    @DeleteMapping("/delete_start_up")
    public ResponseEntity updateBooks(@PathVariable Integer id){
        startUpService.deleteStartUp(id);
        return ResponseEntity.status(200).body("Updated");

    }
    @PutMapping("/book_appointment/{advisor_ID}/{dateTime}")
    public ResponseEntity bookAppointment(@AuthenticationPrincipal MyUser myUser, @PathVariable Integer advisor_ID, @PathVariable String dateTime){
        startUpService.bookAppointment(myUser.getId(), advisor_ID,dateTime);
        return ResponseEntity.status(200).body("Your appointment has been Booked");

    }
    @PutMapping("/reschedule_appointment/{appointmentID}/{advisor_ID}/{dateTime}")
    public ResponseEntity rescheduleAppointment(@PathVariable Integer appointmentID,@AuthenticationPrincipal MyUser myUser, @PathVariable Integer advisor_ID,@PathVariable String dateTime){
        startUpService.rescheduleAppointment(appointmentID,myUser.getId(),advisor_ID,dateTime);
        return ResponseEntity.status(200).body("Your appointment has been Updated");

    }
    @GetMapping("/pending_appointment")
    public ResponseEntity getPendingAppointment(@AuthenticationPrincipal MyUser myUser){
        List<Appointments> appointments = startUpService.pendingAppointments(myUser.getId());
        return ResponseEntity.status(200).body(appointments);

    }
    @DeleteMapping("/cancel_appointment/{appointmentID}/{startUp_ID}/{advisor_ID}")
    public ResponseEntity rescheduleAppointment(@PathVariable Integer appointmentID,@AuthenticationPrincipal MyUser myUser, @PathVariable Integer advisor_ID){
        startUpService.cancelAppointment(appointmentID,myUser.getId(),advisor_ID);
        return ResponseEntity.status(200).body("Your appointment has been canceled");

    }
    @GetMapping("/upcoming_appointment")
    public ResponseEntity getUpcomingAppointment(@AuthenticationPrincipal MyUser myUser){
        List<Appointments> appointments = startUpService.upComingAppointments(myUser.getId());
        return ResponseEntity.status(200).body(appointments);

    }
    @PutMapping("/pay_appointment_fee/{appointmentID}/{advisor_ID}")
    public ResponseEntity PayAppointmentFee(@PathVariable Integer appointmentID,@AuthenticationPrincipal MyUser myUser, @PathVariable Integer advisor_ID){
        startUpService.payAppointmentFee(appointmentID,myUser.getId(),advisor_ID);
        return ResponseEntity.status(200).body("Your payment was successful, and the appointment has been Confirmed");

    }
    @PutMapping("/credit_money/{amount}")
    public ResponseEntity CreditMoney(@AuthenticationPrincipal MyUser myUser, @PathVariable Integer amount){
        startUpService.CreditMoneyToWallet(myUser.getId(),amount);
        return ResponseEntity.status(200).body("Your Wallet has ben charged with:" + amount+"$");

    }
    @PutMapping("/post_review/{appointmentID}/{advisor_ID}")
    public ResponseEntity PostReview(@PathVariable Integer appointmentID,@AuthenticationPrincipal MyUser myUser, @PathVariable Integer advisor_ID, @RequestBody Review review){
        startUpService.postReview(appointmentID,myUser.getId(),advisor_ID,review);
        return ResponseEntity.status(200).body("This appointment has been reviewed");

    }

}
