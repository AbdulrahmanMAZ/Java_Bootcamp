package com.abdulrahman.final_Project.Start_up;

import com.abdulrahman.final_Project.Appointments.Appointments;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
    @PutMapping("/book_appointment/{startUp_ID}/{advisor_ID}/{dateTime}")
    public ResponseEntity bookAppointment(@PathVariable Integer startUp_ID, @PathVariable Integer advisor_ID,@PathVariable String dateTime){
        startUpService.bookAppointment(startUp_ID,advisor_ID,dateTime);
        return ResponseEntity.status(200).body("Your appointment has been Booked");

    }
    @PutMapping("/reschedule_appointment/{appointmentID}/{startUp_ID}/{advisor_ID}/{dateTime}")
    public ResponseEntity rescheduleAppointment(@PathVariable Integer appointmentID,@PathVariable Integer startUp_ID, @PathVariable Integer advisor_ID,@PathVariable String dateTime){
        startUpService.rescheduleAppointment(appointmentID,startUp_ID,advisor_ID,dateTime);
        return ResponseEntity.status(200).body("Your appointment has been Updated");

    }
    @DeleteMapping("/cancel_appointment/{appointmentID}/{startUp_ID}/{advisor_ID}")
    public ResponseEntity rescheduleAppointment(@PathVariable Integer appointmentID,@PathVariable Integer startUp_ID, @PathVariable Integer advisor_ID){
        startUpService.cancelAppointment(appointmentID,startUp_ID,advisor_ID);
        return ResponseEntity.status(200).body("Your appointment has been canceled");

    }
    @GetMapping("/upcoming_appointment/{startUp_ID}")
    public ResponseEntity getUpcomingAppointment(@PathVariable Integer startUp_ID){
        List<Appointments> appointments = startUpService.upComingAppointments(startUp_ID);
        return ResponseEntity.status(200).body(appointments);

    }
}
