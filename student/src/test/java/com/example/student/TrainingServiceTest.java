package com.example.student;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.student.entity.TrainingSchedule;
import com.example.student.repository.TrainingScheduleRepository;
import com.example.student.service.TrainingScheduleServiceImpl;

public class TrainingServiceTest {
    @Mock
    private TrainingScheduleRepository trainingRepository;

    @InjectMocks
    private TrainingScheduleServiceImpl trainingService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetScheduleById() throws Exception {
        TrainingSchedule mockTraining = new TrainingSchedule();
        mockTraining.setId(1L);
        mockTraining.setLocation("conference d");

        when(trainingRepository.findById(1L)).thenReturn(Optional.of(mockTraining));

        Optional<TrainingSchedule> result = trainingService.getScheduleById(1L);

        assertNotNull(result);
        assertEquals("conference d", result.get().getLocation());
    }
}
