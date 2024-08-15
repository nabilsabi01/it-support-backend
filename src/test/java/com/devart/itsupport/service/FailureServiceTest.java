package com.devart.itsupport.service;

import com.devart.itsupport.dto.FailureDTO;
import com.devart.itsupport.enums.FailureType;
import com.devart.itsupport.exeption.ResourceNotFoundException;
import com.devart.itsupport.mapper.FailureMapper;
import com.devart.itsupport.model.Failure;
import com.devart.itsupport.repository.FailureRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class FailureServiceTest {

    @Mock
    private FailureRepository failureRepository;

    @Mock
    private FailureMapper failureMapper;

    @InjectMocks
    private FailureService failureService;

    private Failure failure;
    private FailureDTO failureDTO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        failure = new Failure();
        failure.setId(1L);
        failure.setDescription("Test Failure");
        failure.setType(FailureType.HARDWARE);

        failureDTO = new FailureDTO();
        failureDTO.setId(1L);
        failureDTO.setDescription("Test Failure");
        failureDTO.setType(FailureType.HARDWARE);
    }

    @Test
    void createFailure_ShouldReturnCreatedFailureDTO() {
        when(failureMapper.toEntity(failureDTO)).thenReturn(failure);
        when(failureRepository.save(failure)).thenReturn(failure);
        when(failureMapper.toDTO(failure)).thenReturn(failureDTO);

        FailureDTO result = failureService.createFailure(failureDTO);

        assertNotNull(result);
        assertEquals(failureDTO.getId(), result.getId());
        assertEquals(failureDTO.getDescription(), result.getDescription());
        assertEquals(failureDTO.getType(), result.getType());
    }

    @Test
    void getFailure_WithValidId_ShouldReturnFailureDTO() {
        when(failureRepository.findById(1L)).thenReturn(Optional.of(failure));
        when(failureMapper.toDTO(failure)).thenReturn(failureDTO);

        FailureDTO result = failureService.getFailure(1L);

        assertNotNull(result);
        assertEquals(failureDTO.getId(), result.getId());
    }

    @Test
    void getFailure_WithInvalidId_ShouldThrowResourceNotFoundException() {
        when(failureRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> failureService.getFailure(1L));
    }

    @Test
    void getAllFailures_ShouldReturnListOfFailureDTOs() {
        List<Failure> failures = Arrays.asList(failure, failure);
        when(failureRepository.findAll()).thenReturn(failures);
        when(failureMapper.toDTO(any(Failure.class))).thenReturn(failureDTO);

        List<FailureDTO> result = failureService.getAllFailures();

        assertNotNull(result);
        assertEquals(2, result.size());
    }

    @Test
    void updateFailure_WithValidId_ShouldReturnUpdatedFailureDTO() {
        when(failureRepository.findById(1L)).thenReturn(Optional.of(failure));
        when(failureRepository.save(any(Failure.class))).thenReturn(failure);
        when(failureMapper.toDTO(failure)).thenReturn(failureDTO);

        FailureDTO result = failureService.updateFailure(1L, failureDTO);

        assertNotNull(result);
        assertEquals(failureDTO.getId(), result.getId());
    }

    @Test
    void deleteFailure_WithValidId_ShouldNotThrowException() {
        when(failureRepository.existsById(1L)).thenReturn(true);

        assertDoesNotThrow(() -> failureService.deleteFailure(1L));

        verify(failureRepository).deleteById(1L);
    }
}