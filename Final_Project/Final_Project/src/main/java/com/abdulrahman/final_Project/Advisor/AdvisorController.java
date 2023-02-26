package com.abdulrahman.final_Project.Advisor;

import com.abdulrahman.final_Project.Appointments.Appointments;
import com.abdulrahman.final_Project.Feedback.Feedback;
import com.abdulrahman.final_Project.MyUser.MyUser;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v3/advisor")
@RequiredArgsConstructor
public class AdvisorController {

    // ServiceInjection
    private final AdvisorService advisorService;

    // getter
    @GetMapping("/admin/get_advisor")
    public List<Advisor> getAdvisors(){
        return advisorService.getAdvisors();
    }
    @PostMapping("/admin/add_advisor")

    public ResponseEntity addAdvisor(@Valid @RequestBody Advisor _advisor){
                advisorService.addAdvisor(_advisor);
                return ResponseEntity.status(200).body("Success");

    }
    @PutMapping("/admin/edit_advisor/{id}")
    public ResponseEntity updateAdvisors(@PathVariable Integer id,@Valid  @RequestBody Advisor _advisor){
        advisorService.editAdvisor(id,_advisor);
        return ResponseEntity.status(200).body("Updated");

    }
    @DeleteMapping("/admin/delete_advisor/{id}")
    public ResponseEntity updateAdvisors(@PathVariable Integer id){
        advisorService.deleteAdvisor(id);
        return ResponseEntity.status(200).body("Updated");

    }

    @PutMapping("/reschedule_appointment/{appointmentID}/{startUp_ID}/{dateTime}")
    public ResponseEntity rescheduleAppointment(@PathVariable Integer appointmentID, @PathVariable Integer startUp_ID, @AuthenticationPrincipal MyUser myUser, @PathVariable String dateTime){
        advisorService.rescheduleAppointment(appointmentID,startUp_ID,myUser.getId(),dateTime);
        return ResponseEntity.status(200).body("Your appointment has been Updated");

    }
    @DeleteMapping("/cancel_appointment/{appointmentID}/{startUp_ID}")
    public ResponseEntity rescheduleAppointment(@PathVariable Integer appointmentID,@PathVariable Integer startUp_ID, @AuthenticationPrincipal MyUser myUser){
        advisorService.cancelAppointment(appointmentID,startUp_ID,myUser.getId());
        return ResponseEntity.status(200).body("Your appointment has been canceled");

    }
    @GetMapping("/pending_appointment")
    public ResponseEntity getPendingAppointment(@AuthenticationPrincipal MyUser myUser){
        List<Appointments> appointments = advisorService.pendingAppointments(myUser.getId());
        return ResponseEntity.status(200).body(appointments);

    }
    @GetMapping("/upcoming_appointment")
    public ResponseEntity getUpcomingAppointment(@AuthenticationPrincipal MyUser myUser){
        List<Appointments> appointments = advisorService.upComingAppointments(myUser.getId());
        return ResponseEntity.status(200).body(appointments);

    }
    @PutMapping("/accept_appointment/{appointmentID}/{startUp_ID}")
    public ResponseEntity AcceptAppointment(@PathVariable Integer appointmentID,@PathVariable Integer startUp_ID,@AuthenticationPrincipal MyUser myUser){
        advisorService.AcceptAppointment(appointmentID,startUp_ID,myUser.getId());;
        return ResponseEntity.status(200).body("This appointment has been Accepted and the bill has been sent to the start-up");

    }
    @PutMapping("/reject_appointment/{appointmentID}/{startUp_ID}")
    public ResponseEntity CancelAppointment(@PathVariable Integer appointmentID,@PathVariable Integer startUp_ID,@AuthenticationPrincipal MyUser myUser){
        advisorService.cancelAppointment(appointmentID,startUp_ID,myUser.getId());;
        return ResponseEntity.status(200).body("This appointment has been Accepted and the bill has been sent to the start-up");

    }
    @PutMapping("/complete_appointment_feedback/{appointmentID}/{startUp_ID}")
    public ResponseEntity getUpcomingAppointment(@PathVariable Integer appointmentID,@PathVariable Integer startUp_ID,@AuthenticationPrincipal MyUser myUser, @RequestBody Feedback feedback){
         advisorService.CompleteAppointmentAndWriteFeedback(appointmentID,startUp_ID,myUser.getId(),feedback);;
        return ResponseEntity.status(200).body("This appointment has been marked complete and feed back has been sent");


    }

}
