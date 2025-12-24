package com.learning.funding.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.learning.funding.entity.Staff;
import com.learning.funding.repository.StaffRepository;

/* This class is added to use User details service so that we can authorise using db Credentials. 
Spring Security needs 3 things:

UserDetails → Represents one user

UserDetailsService → Loads user from DB

PasswordEncoder → Verifies passwords */

@Service
public class StaffUserDetailsService implements UserDetailsService{
    private StaffRepository staffRepository;

    public StaffUserDetailsService(StaffRepository staffRepository){
        this.staffRepository=staffRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Staff staff = staffRepository.findByUsername(username)
                        .orElseThrow(()-> new UsernameNotFoundException("User not found"));

        return User.builder()
                    .username(staff.getUsername())
                    .password(staff.getPassword())
                    .roles(staff.getRole())
                    .build();
    }
    

}
