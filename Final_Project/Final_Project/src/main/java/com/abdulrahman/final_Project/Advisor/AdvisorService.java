package com.abdulrahman.final_Project.Advisor;

import com.abdulrahman.final_Project.Appointments.Appointments;
import com.abdulrahman.final_Project.Appointments.AppointmentsRepo;
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
            appointment = new Appointments(null,appointmentStartTime,"Pending",null,null,null);
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

        appointmentsRepo.delete(appointment);
    }
    public List<Appointments> upComingAppointments( Integer advisor_id){
        Advisor advisor = advisorRepo.findAdvisorById(advisor_id);
        if (advisor == null) {
            throw new ApiException("Start up Not found");
        }
        List<Appointments> appointments = appointmentsRepo.findAllByAdvisor(advisor);
        if (appointments.isEmpty()) {
            throw new ApiException("You have no upcoming appointments");
        }
        return appointments;

    }
    public void CompleteAppointments( Integer appointment_id, Integer startUp_id, Integer advisor_id){
        Appointments appointment = appointmentsRepo.findAppointmentsByIdAndAdvisor_IdAndStartUp_Id(appointment_id,advisor_id,startUp_id);
        if (appointment == null) {
            throw new ApiException("Appointment Not found");
        }

        appointmentsRepo.delete(appointment);

    }
}
