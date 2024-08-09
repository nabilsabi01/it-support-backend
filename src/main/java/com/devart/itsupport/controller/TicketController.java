//package com.devart.itsupport.controller;
//
//import com.devart.itsupport.dto.TechnicianDTO;
//import com.devart.itsupport.dto.TicketDTO;
//import com.devart.itsupport.dto.UserDTO;
//import com.devart.itsupport.service.TicketService;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/tickets")
//public class TicketController {
//    private final TicketService ticketService;
//
//    public TicketController(TicketService ticketService) {
//        this.ticketService = ticketService;
//    }
//
//    @PostMapping
//    @PreAuthorize("hasRole('ROLE_USER')")
//    public ResponseEntity<TicketDTO> createTicket(@RequestBody TicketDTO ticketDTO) {
//        TicketDTO createdTicket = ticketService.createTicket(ticketDTO);
//        return ResponseEntity.status(HttpStatus.CREATED).body(createdTicket);
//    }
//
////    @PutMapping("/{id}/assign")
////    @PreAuthorize("hasRole('ROLE_ADMIN')")
////    public ResponseEntity<TicketDTO> assignTicketToTechnician(@PathVariable Long id, @RequestBody TechnicianDTO technicianDTO) {
////        TicketDTO assignedTicket = ticketService.assignTicketToTechnician(id, technicianDTO);
////        return ResponseEntity.ok(assignedTicket);
////    }
////
////    @PutMapping("/{id}/status")
////    @PreAuthorize("hasRole('ROLE_TECHNICIAN')")
////    public ResponseEntity<TicketDTO> updateTicketStatus(@PathVariable Long id, @RequestBody TicketStatusUpdateDTO ticketStatusUpdateDTO) {
////        TicketDTO updatedTicket = ticketService.updateTicketStatus(id, ticketStatusUpdateDTO.getStatus());
////        return ResponseEntity.ok(updatedTicket);
////    }
////
////    @GetMapping
////    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_TECHNICIAN', 'ROLE_USER')")
////    public ResponseEntity<List<TicketDTO>> getAllTickets() {
////        List<TicketDTO> tickets = ticketService.getAllTickets();
////        return ResponseEntity.ok(tickets);
////    }
////
////    @GetMapping("/user/{userId}")
////    @PreAuthorize("hasRole('ROLE_USER')")
////    public ResponseEntity<List<TicketDTO>> getTicketsByUser(@PathVariable Long userId) {
////        UserDTO userDTO = new UserDTO();
////        userDTO.setId(userId);
////        List<TicketDTO> tickets = ticketService.getTicketsByUser(userDTO);
////        return ResponseEntity.ok(tickets);
////    }
////
////    @GetMapping("/technician/{technicianId}")
////    @PreAuthorize("hasRole('ROLE_TECHNICIAN')")
////    public ResponseEntity<List<TicketDTO>> getTicketsByTechnician(@PathVariable Long technicianId) {
////        TechnicianDTO technicianDTO = new TechnicianDTO();
////        technicianDTO.setId(technicianId);
////        List<TicketDTO> tickets = ticketService.getTicketsByTechnician(technicianDTO);
////        return ResponseEntity.ok(tickets);
////    }
//}