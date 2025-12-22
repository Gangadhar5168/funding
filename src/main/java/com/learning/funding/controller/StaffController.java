package com.learning.funding.controller;

import java.util.List;
import com.learning.funding.service.StaffService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.funding.entity.Staff;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api")
public class StaffController {

    private final StaffService staffService;


    StaffController(StaffService staffService) {
        this.staffService = staffService;
    }


    
    @GetMapping("/staff")
    public List<Staff> getAllStaff() {
        return staffService.getAllStaff();
    }

    @PostMapping("/staff")
    public Staff saveStaffDetails(@RequestBody Staff staffDetails) {
        
        return staffService.saveStaffDetails(staffDetails);
        
    }
    
    
}
