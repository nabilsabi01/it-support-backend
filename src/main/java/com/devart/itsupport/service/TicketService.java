package com.devart.itsupport.service;

import com.devart.itsupport.dto.TicketDTO;
import com.devart.itsupport.enums.TicketStatus;
import com.devart.itsupport.exeption.ResourceNotFoundException;
import com.devart.itsupport.mapper.TicketMapper;
import com.devart.itsupport.model.Ticket;
import com.devart.itsupport.model.Technician;
import com.devart.itsupport.model.User;
import com.devart.itsupport.repository.TicketRepository;
import com.devart.itsupport.repository.TechnicianRepository;
import com.devart.itsupport.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TicketService {
    private final TicketRepository ticketRepository;
    private final UserRepository userRepository;
    private final TechnicianRepository technicianRepository;
    private final TicketMapper ticketMapper;

    public TicketService(TicketRepository ticketRepository, UserRepository userRepository,
                         TechnicianRepository technicianRepository, TicketMapper ticketMapper) {
        this.ticketRepository = ticketRepository;
        this.userRepository = userRepository;
        this.technicianRepository = technicianRepository;
        this.ticketMapper = ticketMapper;
    }

    public TicketDTO createTicket(TicketDTO ticketDTO) {
        Ticket ticket = ticketMapper.toEntity(ticketDTO);
        ticket.setStatus(TicketStatus.OPEN);
        User user = userRepository.findById(ticketDTO.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + ticketDTO.getUserId()));
        ticket.setUser(user);
        Ticket savedTicket = ticketRepository.save(ticket);
        return ticketMapper.toDTO(savedTicket);
    }

    public TicketDTO getTicket(Long id) {
        Ticket ticket = ticketRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ticket not found with id: " + id));
        return ticketMapper.toDTO(ticket);
    }

    public List<TicketDTO> getAllTickets() {
        List<Ticket> tickets = ticketRepository.findAll();
        List<TicketDTO> ticketDTOs = new ArrayList<>();
        for (Ticket ticket : tickets) {
            ticketDTOs.add(ticketMapper.toDTO(ticket));
        }
        return ticketDTOs;
    }

    public List<TicketDTO> getTicketsByUserId(Long userId) {
        List<Ticket> tickets = ticketRepository.findByUserId(userId);
        List<TicketDTO> ticketDTOs = new ArrayList<>();
        for (Ticket ticket : tickets) {
            ticketDTOs.add(ticketMapper.toDTO(ticket));
        }
        return ticketDTOs;
    }

    public List<TicketDTO> getTicketsByTechnicianId(Long technicianId) {
        List<Ticket> tickets = ticketRepository.findByTechnicianId(technicianId);
        List<TicketDTO> ticketDTOs = new ArrayList<>();
        for (Ticket ticket : tickets) {
            ticketDTOs.add(ticketMapper.toDTO(ticket));
        }
        return ticketDTOs;
    }

    public TicketDTO assignTicketToTechnician(Long ticketId, Long technicianId) {
        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new ResourceNotFoundException("Ticket not found with id: " + ticketId));
        Technician technician = technicianRepository.findById(technicianId)
                .orElseThrow(() -> new ResourceNotFoundException("Technician not found with id: " + technicianId));

        ticket.setTechnician(technician);
        ticket.setStatus(TicketStatus.IN_PROGRESS);
        Ticket updatedTicket = ticketRepository.save(ticket);
        return ticketMapper.toDTO(updatedTicket);
    }

    public TicketDTO updateTicketStatus(Long id, TicketStatus status) {
        Ticket ticket = ticketRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ticket not found with id: " + id));
        ticket.setStatus(status);
        Ticket updatedTicket = ticketRepository.save(ticket);
        return ticketMapper.toDTO(updatedTicket);
    }

    public TicketDTO updateTicket(Long id, TicketDTO ticketDTO) {
        Ticket ticket = ticketRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ticket not found with id: " + id));
        ticket.setDescription(ticketDTO.getDescription());
        Ticket updatedTicket = ticketRepository.save(ticket);
        return ticketMapper.toDTO(updatedTicket);
    }

    public void deleteTicket(Long id) {
        if (!ticketRepository.existsById(id)) {
            throw new ResourceNotFoundException("Ticket not found with id: " + id);
        }
        ticketRepository.deleteById(id);
    }
}