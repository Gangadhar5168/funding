package com.learning.funding.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.learning.funding.entity.Staff;
import com.learning.funding.repository.StaffRepository;

@Service
public class StaffService {
    private StaffRepository staffRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public StaffService(StaffRepository staffRepository, PasswordEncoder passwordEncoder){
        this.staffRepository=staffRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<Staff> getAllStaff(){
        return staffRepository.findAll();
    }

    public Staff saveStaffDetails(Staff staffDetails){
        staffDetails.setPassword(passwordEncoder.encode(staffDetails.getPassword())); //encoded the password with Bcrypt
        return staffRepository.save(staffDetails);
    }
}
