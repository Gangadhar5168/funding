package com.learning.funding.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.print.DocFlavor.STRING;

import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import com.learning.funding.dto.UpdateCrewRequestDto;
import com.learning.funding.entity.Crew;
import com.learning.funding.entity.CrewTransaction;
import com.learning.funding.entity.TransactionType;
import com.learning.funding.repository.CrewRepository;
import com.learning.funding.repository.CrewTransactionRepository;

import jakarta.transaction.Transactional;

@Service
public class CrewService {
    private CrewRepository crewRepository;
    private CrewTransactionRepository crewTransactionRepository;

    public CrewService(CrewRepository crewRepository, CrewTransactionRepository crewTransactionRepository){
        this.crewRepository=crewRepository;
        this.crewTransactionRepository=crewTransactionRepository;
    }

    private Crew validateCrew(Long crewId, String pin){
        Crew crew = crewRepository.findById(crewId)
                    .orElseThrow(()->new RuntimeException("Crew not found with id: "+crewId));
        if(!crew.isActive()){
            throw new RuntimeException("Crew is not Active");
        }

        if(!crew.getPin().equals(pin)){
            throw new RuntimeException("Invalid Pin");
        }

        return crew;
    }
    @Transactional
    public void cashAdvance(Long crewId, String pin, BigDecimal amount){
        Crew crew  = validateCrew(crewId, pin);

        if (crew.getBalance().add(amount).compareTo(crew.getLimitAmount())>0){
            throw new RuntimeException("Limit exceeded");
        }
        crew.setBalance(crew.getBalance().add(amount));

        CrewTransaction tx = new CrewTransaction();
        tx.setCrewId(crew.getCrewId());
        tx.setCrewName(crew.getCrewName());
        tx.setTransactionTime(LocalDateTime.now());
        tx.setAmount(amount);
        tx.setType(TransactionType.ADVANCE);

        crewTransactionRepository.save(tx);
        crewRepository.save(crew);

    }

    public void returnCash(Long crewId, String pin, BigDecimal amount){
        Crew crew = validateCrew(crewId, pin);

        if(amount.compareTo(crew.getBalance())>0){
            throw new RuntimeException("Returning amount exceeds balance");
        }

        crew.setBalance(crew.getBalance().subtract(amount));

        CrewTransaction tx = new CrewTransaction();
        tx.setCrewId(crew.getCrewId());
        tx.setCrewName(crew.getCrewName());
        tx.setAmount(amount);
        tx.setTransactionTime(LocalDateTime.now());
        tx.setType(TransactionType.RETURN);

        crewTransactionRepository.save(tx);
        crewRepository.save(crew);
    }

    public Crew saveCrew(Crew crewDetails) {
       return crewRepository.save(crewDetails);
    }

    public List<Crew> getAllCrew() {
       return crewRepository.findAll();
    }

    public Crew updateCrew(Long crewId, UpdateCrewRequestDto request) {
       Crew crew = crewRepository.findById(crewId)
                    .orElseThrow(()-> new RuntimeException("crew not found"));

       if(request.getCrewName()!=null){
        crew.setCrewName(request.getCrewName());
       }
       if(request.getLimitAmount()!=null){
        crew.setLimitAmount(request.getLimitAmount());
       }
       if(request.getBalance()!=null){
        crew.setBalance(request.getBalance());
       }
       if(request.isActive()!=null){
        crew.setActive(request.isActive());
       }
       return crewRepository.save(crew);

       


    }



}
