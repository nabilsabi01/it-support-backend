package com.devart.itsupport.service;

import com.devart.itsupport.dto.FailureDTO;
import com.devart.itsupport.exeption.ResourceNotFoundException;
import com.devart.itsupport.mapper.FailureMapper;
import com.devart.itsupport.model.Failure;
import com.devart.itsupport.repository.FailureRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FailureService {
    private final FailureRepository failureRepository;
    private final FailureMapper failureMapper;

    public FailureService(FailureRepository failureRepository, FailureMapper failureMapper) {
        this.failureRepository = failureRepository;
        this.failureMapper = failureMapper;
    }

    public FailureDTO createFailure(FailureDTO failureDTO) {
        Failure failure = failureMapper.toEntity(failureDTO);
        Failure savedFailure = failureRepository.save(failure);
        return failureMapper.toDTO(savedFailure);
    }

    public FailureDTO updateFailure(Long id, FailureDTO failureDTO) {
        Failure failure = failureRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Failure not found with id: " + id));
        failure.setDescription(failureDTO.getDescription());
        Failure updatedFailure = failureRepository.save(failure);
        return failureMapper.toDTO(updatedFailure);
    }

    public void deleteFailure(Long id) {
        failureRepository.deleteById(id);
    }

    public List<FailureDTO> getAllFailures() {
        List<Failure> failures = failureRepository.findAll();
        return failures.stream()
                .map(failureMapper::toDTO)
                .collect(Collectors.toList());
    }
}