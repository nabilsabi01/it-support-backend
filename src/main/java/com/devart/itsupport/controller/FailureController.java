package com.devart.itsupport.controller;

import com.devart.itsupport.dto.FailureDTO;
import com.devart.itsupport.enums.FailureType;
import com.devart.itsupport.service.FailureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@PreAuthorize("hasRole('ADMIN')")
@RestController
@RequestMapping("/api/failures")
public class FailureController {

    @Autowired
    private FailureService failureService;


    @PostMapping
    public ResponseEntity<FailureDTO> createFailure(@RequestBody FailureDTO failureDTO) {
        FailureDTO createdFailure = failureService.createFailure(failureDTO);
        return new ResponseEntity<>(createdFailure, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FailureDTO> getFailure(@PathVariable Long id) {
        FailureDTO failure = failureService.getFailure(id);
        return ResponseEntity.ok(failure);
    }

    @GetMapping
    public ResponseEntity<List<FailureDTO>> getAllFailures() {
        List<FailureDTO> failures = failureService.getAllFailures();
        return ResponseEntity.ok(failures);
    }

    @GetMapping("/type/{type}")
    public ResponseEntity<List<FailureDTO>> getFailuresByType(@PathVariable FailureType type) {
        List<FailureDTO> failures = failureService.getFailuresByType(type);
        return ResponseEntity.ok(failures);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FailureDTO> updateFailure(@PathVariable Long id, @RequestBody FailureDTO failureDTO) {
        FailureDTO updatedFailure = failureService.updateFailure(id, failureDTO);
        return ResponseEntity.ok(updatedFailure);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFailure(@PathVariable Long id) {
        failureService.deleteFailure(id);
        return ResponseEntity.noContent().build();
    }
}