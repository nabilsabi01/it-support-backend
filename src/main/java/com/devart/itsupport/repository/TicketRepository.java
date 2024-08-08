package com.devart.itsupport.repository;

import com.devart.itsupport.model.Technician;
import com.devart.itsupport.model.Ticket;
import com.devart.itsupport.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findAllByUser(User user);
    List<Ticket> findAllByTechnician(Technician technician);
}