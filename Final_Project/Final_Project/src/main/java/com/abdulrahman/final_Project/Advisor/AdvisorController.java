package com.abdulrahman.final_Project.Advisor;

import com.abdulrahman.final_Project.Appointments.Appointments;
import com.abdulrahman.final_Project.Feedback.Feedback;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v3/advisor")
@RequiredArgsConstructor
public class AdvisorController {

    // ServiceInjection
    private final AdvisorService advisorService;

    // getter
    @GetMapping("/get_advisor")
    public List<Advisor> getAdvisors(){
        return advisorService.getAdvisors();
    }
    @PostMapping("/add_advisor")

    public ResponseEntity addAdvisor(@Valid @RequestBody Advisor _advisor){
                advisorService.addAdvisor(_advisor);
                return ResponseEntity.status(200).body("Success");

    }
    @PutMapping("/edit_advisor/{id}")
    public ResponseEntity updateAdvisors(@PathVariable Integer id,@Valid  @RequestBody Advisor _advisor){
        advisorService.editAdvisor(id,_advisor);
        return ResponseEntity.status(200).body("Updated");

    }
    @DeleteMapping("/delete_advisor/{id}")
    public ResponseEntity updateAdvisors(@PathVariable Integer id){
        advisorService.deleteAdvisor(id);
        return ResponseEntity.status(200).body("Updated");

    }

    @PutMapping("/reschedule_appointment/{appointmentID}/{startUp_ID}/{advisor_ID}/{dateTime}")
    public ResponseEntity rescheduleAppointment(@PathVariable Integer appointmentID,@PathVariable Integer startUp_ID, @PathVariable Integer advisor_ID,@PathVariable String dateTime){
        advisorService.rescheduleAppointment(appointmentID,startUp_ID,advisor_ID,dateTime);
        return ResponseEntity.status(200).body("Your appointment has been Updated");

    }
    @DeleteMapping("/cancel_appointment/{appointmentID}/{startUp_ID}/{advisor_ID}")
    public ResponseEntity rescheduleAppointment(@PathVariable Integer appointmentID,@PathVariable Integer startUp_ID, @PathVariable Integer advisor_ID){
        advisorService.cancelAppointment(appointmentID,startUp_ID,advisor_ID);
        return ResponseEntity.status(200).body("Your appointment has been canceled");

    }
    @GetMapping("/pending_appointment/{advisor_ID}")
    public ResponseEntity getPendingAppointment(@PathVariable Integer advisor_ID){
        List<Appointments> appointments = advisorService.pendingAppointments(advisor_ID);
        return ResponseEntity.status(200).body(appointments);

    }
    @GetMapping("/upcoming_appointment/{advisor_ID}")
    public ResponseEntity getUpcomingAppointment(@PathVariable Integer advisor_ID){
        List<Appointments> appointments = advisorService.upComingAppointments(advisor_ID);
        return ResponseEntity.status(200).body(appointments);

    }
    @PutMapping("/accept_appointment/{appointmentID}/{startUp_ID}/{advisor_ID}")
    public ResponseEntity AcceptAppointment(@PathVariable Integer appointmentID,@PathVariable Integer startUp_ID, @PathVariable Integer advisor_ID){
        advisorService.AcceptAppointment(appointmentID,startUp_ID,advisor_ID);;
        return ResponseEntity.status(200).body("This appointment has been Accepted and the bill has been sent to the start-up");

    }
    @PutMapping("/reject_appointment/{appointmentID}/{startUp_ID}/{advisor_ID}")
    public ResponseEntity CancelAppointment(@PathVariable Integer appointmentID,@PathVariable Integer startUp_ID, @PathVariable Integer advisor_ID){
        advisorService.cancelAppointment(appointmentID,startUp_ID,advisor_ID);;
        return ResponseEntity.status(200).body("This appointment has been Accepted and the bill has been sent to the start-up");

    }
    @PutMapping("/complete_appointment_feedback/{appointmentID}/{startUp_ID}/{advisor_ID}")
    public ResponseEntity getUpcomingAppointment(@PathVariable Integer appointmentID,@PathVariable Integer startUp_ID, @PathVariable Integer advisor_ID, @RequestBody Feedback feedback){
         advisorService.CompleteAppointmentAndWriteFeedback(appointmentID,startUp_ID,advisor_ID,feedback);;
        return ResponseEntity.status(200).body("This appointment has been marked complete and feed back has been sent");


    }

}
