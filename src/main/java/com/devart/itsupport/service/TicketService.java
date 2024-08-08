package com.devart.itsupport.service;

import com.devart.itsupport.dto.TechnicianDTO;
import com.devart.itsupport.dto.TicketDTO;
import com.devart.itsupport.dto.UserDTO;
import com.devart.itsupport.enums.TicketStatus;
import com.devart.itsupport.exeption.ResourceNotFoundException;
import com.devart.itsupport.mapper.TicketMapper;
import com.devart.itsupport.model.Technician;
import com.devart.itsupport.model.Ticket;
import com.devart.itsupport.model.User;
import com.devart.itsupport.repository.TicketRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class TicketService {
    private final TicketRepository ticketRepository;
    private final TicketMapper ticketMapper;

    public TicketService(TicketRepository ticketRepository, TicketMapper ticketMapper) {
        this.ticketRepository = ticketRepository;
        this.ticketMapper = ticketMapper;
    }

    public TicketDTO createTicket(TicketDTO ticketDTO) {
        Ticket ticket = ticketMapper.toEntity(ticketDTO.getTechnician());
        ticket.setStatus(String.valueOf(TicketStatus.OPEN));
        Ticket savedTicket = ticketRepository.save(ticket);
        return ticketMapper.toDTO(savedTicket);
    }

    public TicketDTO assignTicketToTechnician(Long id, TechnicianDTO technicianDTO) {
        Ticket ticket = ticketRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ticket not found with id: " + id));
        Technician technician = ticketMapper.toEntity(technicianDTO).getTechnician();
        ticket.setTechnician(technician);
        ticket.setStatus(String.valueOf(TicketStatus.IN_PROGRESS));
        Ticket updatedTicket = ticketRepository.save(ticket);
        return ticketMapper.toDTO(updatedTicket);
    }

    public TicketDTO updateTicketStatus(Long id, TicketStatus status) {
        Ticket ticket = ticketRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ticket not found with id: " + id));
        ticket.setStatus(String.valueOf(status));
        Ticket updatedTicket = ticketRepository.save(ticket);
        return ticketMapper.toDTO(updatedTicket);
    }

    public List<TicketDTO> getAllTickets() {
        List<Ticket> tickets = ticketRepository.findAll();
        return tickets.stream()
                .map(ticketMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<TicketDTO> getTicketsByUser(UserDTO userDTO) {
        User user = ticketMapper.toEntity((TechnicianDTO) userDTO).getUser();
        List<Ticket> tickets = ticketRepository.findAllByUser(user);
        return tickets.stream()
                .map(ticketMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<TicketDTO> getTicketsByTechnician(TechnicianDTO technicianDTO) {
        Technician technician = ticketMapper.toEntity(technicianDTO).getTechnician();
        List<Ticket> tickets = ticketRepository.findAllByTechnician(technician);
        return tickets.stream()
                .map(ticketMapper::toDTO)
                .collect(Collectors.toList());
    }
}