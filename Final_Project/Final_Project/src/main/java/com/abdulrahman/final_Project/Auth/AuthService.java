package com.abdulrahman.final_Project.Auth;

import com.abdulrahman.final_Project.Advisor.Advisor;
import com.abdulrahman.final_Project.Advisor.AdvisorRepo;
import com.abdulrahman.final_Project.Advisor.AdvisorService;
import com.abdulrahman.final_Project.AdvisorDetails.AdvisorDetails;
import com.abdulrahman.final_Project.AdvisorDetails.AdvisorDetailsRepo;
import com.abdulrahman.final_Project.MyUser.MyUser;
import com.abdulrahman.final_Project.StartUpDetails.StartUpDetails;
import com.abdulrahman.final_Project.StartUpDetails.StartUpDetailsRepo;
import com.abdulrahman.final_Project.Start_up.StartUp;
import com.abdulrahman.final_Project.Start_up.StartUpRepo;
import com.abdulrahman.final_Project.Start_up.StartUpService;
import com.abdulrahman.final_Project.helper.AdvisorRegisterFormDAO;
import com.abdulrahman.final_Project.helper.StartUpRegisterFormDAO;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthRepo authRepo;
    private final AdvisorService advisorService;
    private final AdvisorRepo advisorRepo;
    private final AdvisorDetailsRepo advisorDetailsRepo;
    private final StartUpRepo startUpRepo;
    private final StartUpDetailsRepo startUpDetailsRepo;
    private Logger logger = LoggerFactory.getLogger(AuthService.class);


    public void registerAdvisor(AdvisorRegisterFormDAO myUserData){
        MyUser myUser = new MyUser();
        // Creating a user of type MyUser
        myUser.setRole("ADVISOR");
        myUser.setUsername(myUserData.username());
        String hashedPassword = new BCryptPasswordEncoder().encode(myUserData.password());
        myUser.setPassword(hashedPassword);

        MyUser savedUser = authRepo.save(myUser);

        // Creating the advisor entity
        Advisor advisor = new Advisor();
        advisor.setSpeciality(myUserData.speciality());
        advisor.setName(myUserData.firstName());
        advisor.setFeePerHour(myUserData.feePerHour());
        advisor.setUser(savedUser);
        Advisor savedAdvisor = advisorRepo.save(advisor);
        // Creating the advisor details entity
        AdvisorDetails advisorDetails = new AdvisorDetails();
        advisorDetails.setEmail(myUserData.email());
        advisorDetails.setGender(myUserData.gender());
        advisorDetails.setPhoneNumber(myUserData.phoneNumber());
        advisorDetails.setFirstName(myUserData.firstName());
        advisorDetails.setLastName(myUserData.lastName());
        advisorDetails.setAdvisor(savedAdvisor);
        advisorDetailsRepo.save(advisorDetails);


    }
    public void registerStartUp(StartUpRegisterFormDAO myUserData){
        MyUser myUser = new MyUser();
        // Creating a user of type MyUser
        myUser.setRole("STARTUP");
        myUser.setUsername(myUserData.username());
        String hashedPassword = new BCryptPasswordEncoder().encode(myUserData.password());
        myUser.setPassword(hashedPassword);

        MyUser savedUser = authRepo.save(myUser);

        StartUp startUp = new StartUp();
        startUp.setIndustry(myUserData.industry());
        startUp.setName(myUserData.name());
        startUp.setUser(savedUser);
        StartUp savedStartUp = startUpRepo.save(startUp);
        logger.info(savedStartUp.getName());
        // Creating the start-up details entity
        StartUpDetails startUpDetails = new StartUpDetails();
        startUpDetails.setEmail(myUserData.email());
        startUpDetails.setOwnerName(myUserData.ownerName());
        startUpDetails.setBasedIn(myUserData.basedIn());
        startUpDetails.setPhoneNumber(myUserData.phoneNumber());
        startUpDetails.setName(myUserData.name());
        startUpDetails.setStartUp(savedStartUp);
        logger.info(startUpDetails.getOwnerName());
        startUpDetailsRepo.save(startUpDetails);




    }

}
