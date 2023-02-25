package com.abdulrahman.final_Project.Advisor;

import com.abdulrahman.final_Project.AdvisorDetails.AdvisorDetails;
import com.abdulrahman.final_Project.Appointments.Appointments;
import com.abdulrahman.final_Project.Appointments.AppointmentsRepo;
import com.abdulrahman.final_Project.Feedback.Feedback;
import com.abdulrahman.final_Project.Feedback.FeedbackRepo;
import com.abdulrahman.final_Project.Feedback.FeedbackService;
import com.abdulrahman.final_Project.Start_up.StartUp;
import com.abdulrahman.final_Project.Start_up.StartUpRepo;
import com.abdulrahman.final_Project.exception.ApiException;
import com.abdulrahman.final_Project.helper.MyTimeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AdvisorService {
    final private AdvisorRepo advisorRepo;
    final private AppointmentsRepo appointmentsRepo;
    final private MyTimeService myTimeService;

    final private StartUpRepo startUpRepo;
    final private FeedbackService feedbackService;
    final private FeedbackRepo feedbackRepo;



    public List<Advisor> getAdvisors(){
        return advisorRepo.findAll();
    }
    public void addAdvisor(Advisor store){
        advisorRepo.save(store);

    }
    public void editAdvisor(Integer id,Advisor store){
        Advisor temp = advisorRepo.findAdvisorById(id);
        if (temp == null) {
            throw new ApiException("Not found");
        }
        temp.setName(store.getName());
        temp.setSpeciality(store.getSpeciality());
        advisorRepo.save(temp);

    }
    public void deleteAdvisor(Integer id){
        Advisor temp = advisorRepo.findAdvisorById(id);
        if (temp == null) {
            throw new ApiException("Not found");
        }
        advisorRepo.delete(temp);

    }

    public void rescheduleAppointment(Integer appointment_id, Integer startUp_id, Integer advisor_id,String newTime){
        Appointments appointments = appointmentsRepo.findAppointmentsByIdAndAdvisor_IdAndStartUp_Id(appointment_id,advisor_id,startUp_id);
        if (appointments == null) {
            throw new ApiException("Appointment Not found");
        }

        // Parse the string into a valid date format then store the date in a variable
        LocalDateTime appointmentStartTime = LocalDateTime.parse(newTime);
        // Create a string containing the time format 00:00
        int hours = appointmentStartTime.getHour();
        int minutes = appointmentStartTime.getMinute();
        String hours_minutes = hours+":"+minutes;


        Appointments appointment;
        // check if the appointment is available
        Appointments check_advisor_availability = appointmentsRepo.findAppointmentByDateTimeAndAdvisor_Id(appointmentStartTime,advisor_id);
        Appointments check_startUp_availability = appointmentsRepo.findAppointmentByDateTimeAndStartUp_Id(appointmentStartTime,startUp_id);
        if (check_advisor_availability == null && check_startUp_availability == null) {
            appointment = new Appointments(null,appointmentStartTime,"Pending",0,null,null,null);
        } else if (check_advisor_availability != null) {
            throw new ApiException("This advisor is not available at this time, please try another date");
        } else if (check_startUp_availability != null){
            throw new ApiException("You already has a date at this specific time, please try another date");
        }else {
            throw new ApiException("This time is not valid, please try another date");
        }
        // Before booking make sure the time is a full hour
        if (!myTimeService.validTime(hours_minutes)){
            throw new ApiException("This is not a valid time, please choose a correct time (9:00,10:00,11:00,12:00,13:00,14:00,15:00,16:00)");
        }


        appointment.setDateTime(appointmentStartTime);
        appointmentsRepo.save(appointment);
    }
    public void cancelAppointment(Integer appointment_id, Integer startUp_id, Integer advisor_id){
        Appointments appointment = appointmentsRepo.findAppointmentsByIdAndAdvisor_IdAndStartUp_Id(appointment_id,advisor_id,startUp_id);
        if (appointment == null) {
            throw new ApiException("Appointment Not found");
        }

        Advisor advisor = advisorRepo.findAdvisorById(advisor_id);
        if (advisor == null) {
            throw new ApiException("Advisor Not found");
        }
        StartUp startUp = startUpRepo.findStartUpById(startUp_id);
        if (advisor == null) {
            throw new ApiException("Start up Not found");
        }


        if (appointment.getStatus().equals("Paid")) {
            advisor.refund(appointment.getFee());
            startUp.addMoneyToWallet(appointment.getFee());
            advisorRepo.save(advisor);
            startUpRepo.save(startUp);

        }

        appointmentsRepo.delete(appointment);
    }
    public List<Appointments> pendingAppointments( Integer advisor_id){
        Advisor advisor = advisorRepo.findAdvisorById(advisor_id);
        if (advisor == null) {
            throw new ApiException("Start up Not found");
        }
        List<Appointments> appointments = appointmentsRepo.findAllByAdvisorAndStatus(advisor,"Pending");
        if (appointments.isEmpty()) {
            throw new ApiException("You have no upcoming appointments");
        }
        return appointments;

    }
    public List<Appointments> upComingAppointments( Integer advisor_id){
        Advisor advisor = advisorRepo.findAdvisorById(advisor_id);
        if (advisor == null) {
            throw new ApiException("Start up Not found");
        }
        List<Appointments> appointments = appointmentsRepo.findAllByAdvisorAndStatus(advisor,"Accepted");
        if (appointments.isEmpty()) {
            throw new ApiException("You have no upcoming appointments");
        }
        return appointments;

    }
    public void CompleteAppointmentAndWriteFeedback(Integer appointment_id, Integer startUp_id, Integer advisor_id, Feedback feedback){
        Appointments appointment = appointmentsRepo.findAppointmentsByIdAndAdvisor_IdAndStartUp_Id(appointment_id,advisor_id,startUp_id);
        if (appointment == null) {
            throw new ApiException("Appointment Not found");
        }
        feedback.setAppointment(appointment);
        feedbackService.addFeedback(feedback);

        appointment.setStatus("Completed");
//        appointment.setFeedback(feedback);
        appointmentsRepo.save(appointment);

    }

    public void AcceptAppointment(Integer appointment_id, Integer startUp_id, Integer advisor_id){
        Appointments appointment = appointmentsRepo.findAppointmentsByIdAndAdvisor_IdAndStartUp_Id(appointment_id,advisor_id,startUp_id);
        if (appointment == null) {
            throw new ApiException("Appointment Not found");
        }
        Advisor advisor = advisorRepo.findAdvisorById(advisor_id);
        if (advisor == null) {
            throw new ApiException("Start up Not found");
        }


        appointment.setFee(advisor.getFeePerHour());
        appointment.setStatus("Accepted");
        appointmentsRepo.save(appointment);

    }

//    public void RejectAppointment(Integer appointment_id, Integer startUp_id, Integer advisor_id){
//        Appointments appointment = appointmentsRepo.findAppointmentsByIdAndAdvisor_IdAndStartUp_Id(appointment_id,advisor_id,startUp_id);
//        if (appointment == null) {
//            throw new ApiException("Appointment Not found");
//        }
//        Advisor advisor = advisorRepo.findAdvisorById(advisor_id);
//        if (advisor == null) {
//            throw new ApiException("Start up Not found");
//        }
//
//        appointment.setStatus("Rejected");
//        appointmentsRepo.save(appointment);
//
//    }
}
