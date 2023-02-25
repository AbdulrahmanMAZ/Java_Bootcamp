package com.abdulrahman.final_Project.Appointments;

import com.abdulrahman.final_Project.Advisor.Advisor;
import com.abdulrahman.final_Project.Start_up.StartUp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AppointmentsRepo extends JpaRepository<Appointments,Integer> {
    Appointments findAppointmentById(Integer id);
    Appointments findAppointmentByDateTimeAndAdvisor_Id(LocalDateTime name,Integer advisor_id);
    Appointments findAppointmentByDateTimeAndStartUp_Id(LocalDateTime name,Integer advisor_id);
    Appointments findAppointmentsByIdAndAdvisor_IdAndStartUp_Id(Integer id,Integer advisorID, Integer startUpID);
//    Appointments findAppointmentByDateTime(String name);
    List<Appointments> findAllByStartUpAndStatus(StartUp startUp,String status);
    List<Appointments> findAllByAdvisorAndStatus(Advisor advisor,String status);

    List<Appointments> findAllByDateTime(String genre);


}
