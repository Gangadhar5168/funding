package com.learning.funding.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.funding.entity.Staff;
import com.learning.funding.repository.StaffRepository;

@Service
public class StaffService {
    private StaffRepository staffRepository;

    @Autowired
    public StaffService(StaffRepository staffRepository){
        this.staffRepository=staffRepository;
    }

    public List<Staff> getAllStaff(){
        return staffRepository.findAll();
    }

    public Staff saveStaffDetails(Staff staffDetails){
        return staffRepository.save(staffDetails);
    }
}
