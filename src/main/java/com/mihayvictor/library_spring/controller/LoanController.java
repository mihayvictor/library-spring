package com.mihayvictor.library_spring.controller;

import com.mihayvictor.library_spring.model.dto.request.LoanRequest;
import com.mihayvictor.library_spring.model.dto.response.LoanResponse;
import com.mihayvictor.library_spring.model.entities.Loan;
import com.mihayvictor.library_spring.service.LibraryService;
import com.mihayvictor.library_spring.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loan")
public class LoanController {

    private LoanService loanService;
    private LibraryService libraryService;


    @Autowired
    public LoanController(LoanService loanService, LibraryService libraryService) {
        this.loanService = loanService;
        this.libraryService = libraryService;
    }

    @GetMapping
    public ResponseEntity<List<Loan>> findAll(){
        List<Loan> list = loanService.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping
    @RequestMapping("/{id}")
    public ResponseEntity<Loan>findById(@PathVariable Long id){
        Loan loan = loanService.findById(id);
        return ResponseEntity.ok(loan);
    }

    @PostMapping
    public ResponseEntity<LoanResponse>createLoan(@RequestBody LoanRequest request, LoanResponse response){
        Loan createdLoan = libraryService.processLoan(request);
        LoanResponse loanResponse = response.toResponse(createdLoan);
        //Falta calcular o valor de atraso com base no serviço
        return ResponseEntity.status(201).body(loanResponse);
    }

}
