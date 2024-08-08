package com.devart.itsupport.controller;

import com.devart.itsupport.dto.FailureDTO;
import com.devart.itsupport.service.FailureService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/failures")
public class FailureController {
    private final FailureService failureService;

    public FailureController(FailureService failureService) {
        this.failureService = failureService;
    }

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<FailureDTO> createFailure(@RequestBody FailureDTO failureDTO) {
        FailureDTO createdFailure = failureService.createFailure(failureDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdFailure);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<FailureDTO> updateFailure(@PathVariable Long id, @RequestBody FailureDTO failureDTO) {
        FailureDTO updatedFailure = failureService.updateFailure(id, failureDTO);
        return ResponseEntity.ok(updatedFailure);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Void> deleteFailure(@PathVariable Long id) {
        failureService.deleteFailure(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<FailureDTO>> getAllFailures() {
        List<FailureDTO> failures = failureService.getAllFailures();
        return ResponseEntity.ok(failures);
    }
}