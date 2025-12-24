package com.learning.funding.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.funding.dto.AdvanceRequestDto;
import com.learning.funding.dto.ReturnRequestDto;
import com.learning.funding.dto.UpdateCrewRequestDto;
import com.learning.funding.entity.Crew;
import com.learning.funding.service.CrewService;

import java.util.List;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/api/crew")
public class CrewController {
    private CrewService crewService;

    public CrewController(CrewService crewService){
        this.crewService = crewService;
    }

    @PostMapping()
    public Crew saveCrew(@RequestBody Crew crewDetails) {
        return crewService.saveCrew(crewDetails);
    }
    
    @GetMapping()
    public List<Crew> getAllCrew() {
        return crewService.getAllCrew();
    }
    

@PostMapping("/{crewId}/advance-cash")
public ResponseEntity<Void> cashAdvance(@PathVariable Long crewId,@RequestBody AdvanceRequestDto request) {
   crewService.cashAdvance(crewId, request.getPin(),request.getAmount());

   return ResponseEntity.ok().build();
}

@PostMapping("/{crewId}/return-cash")
public ResponseEntity<Void> returnCash(@PathVariable Long crewId,@RequestBody ReturnRequestDto request) {
    crewService.returnCash(crewId, request.getPin(), request.getAmount());
    
    return ResponseEntity.ok().build();
}
@PatchMapping("{crewId}")
public Crew updateCrew(@PathVariable Long crewId, @RequestBody UpdateCrewRequestDto request){
  
    return crewService.updateCrew(crewId, request);
}

    
}
