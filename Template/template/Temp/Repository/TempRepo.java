package com.abdulrahman.exercise21.Temp.Repository;

import com.abdulrahman.exercise21.Temp.Model.Temp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//import org.springframework.stereotype.Repository;

@Repository
public interface TempRepo extends JpaRepository<Temp,Integer> {
    Temp findTempById(Integer id);
}
