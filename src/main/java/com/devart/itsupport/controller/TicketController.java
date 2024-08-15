package com.devart.itsupport.controller;

import com.devart.itsupport.dto.TicketDTO;
import com.devart.itsupport.enums.TicketStatus;
import com.devart.itsupport.service.TicketService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {
    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PreAuthorize("hasRole('USER')")
    @PostMapping
    public ResponseEntity<TicketDTO> createTicket(@RequestBody TicketDTO ticketDTO) {
        TicketDTO createdTicket = ticketService.createTicket(ticketDTO);
        return new ResponseEntity<>(createdTicket, HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('ROLE_TECHNICIAN')")
    @GetMapping("/{id}")
    public ResponseEntity<TicketDTO> getTicket(@PathVariable Long id) {
        TicketDTO ticket = ticketService.getTicket(id);
        return ResponseEntity.ok(ticket);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_TECHNICIAN', 'ROLE_USER')")
    @GetMapping
    public ResponseEntity<List<TicketDTO>> getAllTickets() {
        List<TicketDTO> tickets = ticketService.getAllTickets();
        return ResponseEntity.ok(tickets);
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<TicketDTO>> getTicketsByUserId(@PathVariable Long userId) {
        List<TicketDTO> tickets = ticketService.getTicketsByUserId(userId);
        return ResponseEntity.ok(tickets);
    }

    @PreAuthorize("hasRole('ROLE_TECHNICIAN')")
    @GetMapping("/technician/{technicianId}")
    public ResponseEntity<List<TicketDTO>> getTicketsByTechnicianId(@PathVariable Long technicianId) {
        List<TicketDTO> tickets = ticketService.getTicketsByTechnicianId(technicianId);
        return ResponseEntity.ok(tickets);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/{ticketId}/assign/{technicianId}")
    public ResponseEntity<TicketDTO> assignTicketToTechnician(@PathVariable Long ticketId, @PathVariable Long technicianId) {
        TicketDTO updatedTicket = ticketService.assignTicketToTechnician(ticketId, technicianId);
        return ResponseEntity.ok(updatedTicket);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_TECHNICIAN')")
    @PutMapping("/{id}/status")
    public ResponseEntity<TicketDTO> updateTicketStatus(@PathVariable Long id, @RequestParam TicketStatus status) {
        TicketDTO updatedTicket = ticketService.updateTicketStatus(id, status);
        return ResponseEntity.ok(updatedTicket);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<TicketDTO> updateTicket(@PathVariable Long id, @RequestBody TicketDTO ticketDTO) {
        TicketDTO updatedTicket = ticketService.updateTicket(id, ticketDTO);
        return ResponseEntity.ok(updatedTicket);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTicket(@PathVariable Long id) {
        ticketService.deleteTicket(id);
        return ResponseEntity.noContent().build();
    }
}