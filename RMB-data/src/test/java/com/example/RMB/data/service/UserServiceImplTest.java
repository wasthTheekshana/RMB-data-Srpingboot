//package com.example.RMB.data.service;
//
//import com.example.RMB.data.entity.User;
//import com.example.RMB.data.exception.DataNotFoundException;
//import com.example.RMB.data.repository.UserRepository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.kafka.core.KafkaTemplate;
//
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//public class UserServiceImplTest {
//
//    @Mock
//    private UserRepository userRepository;
//
//    @Mock
//    private KafkaTemplate<String, User> kafkaTemplate;
//
//    private UserServiceImpl userService;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this);
//        //userService = new UserServiceImpl(userRepository, kafkaTemplate, "test-topic");
//    }
//
//    @Test
//    void testFindByLicenseNumber_ExistingLicenseNumber_ReturnsUser() {
//        // Arrange
//        String licenseNumber = "1234567890";
//        User expectedUser = new User();
//        expectedUser.setName("john");
//        expectedUser.setLicenseNumber("12341231");
//        expectedUser.setAddress("sfsdffsd");
//        expectedUser.setNICNumber("111111");
//
//        when(userRepository.findByLicenseNumber(licenseNumber)).thenReturn(Optional.of(expectedUser));
//
//        // Act
//        ResponseEntity<User> response = userService.findByLicenseNumber(licenseNumber);
//
//        // Assert
//        verify(userRepository).findByLicenseNumber(licenseNumber);
//        verify(kafkaTemplate).send("test-topic", expectedUser);
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        assertSame(expectedUser, response.getBody());
//    }
//
//    @Test
//    void testFindByLicenseNumber_NonExistingLicenseNumber_ThrowsException() {
//        // Arrange
//        String licenseNumber = "9876543210";
//        when(userRepository.findByLicenseNumber(licenseNumber)).thenReturn(Optional.empty());
//
//        // Act and Assert
//        assertThrows(DataNotFoundException.class, () -> userService.findByLicenseNumber(licenseNumber));
//        verify(userRepository).findByLicenseNumber(licenseNumber);
//        verifyNoInteractions(kafkaTemplate);
//    }
//}
