package com.abdulrahman.final_Project.AdvisorDetails;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdvisorDetailsRepo extends JpaRepository<AdvisorDetails,Integer> {
    AdvisorDetails findAdvisorDetailsById(Integer id);

}
