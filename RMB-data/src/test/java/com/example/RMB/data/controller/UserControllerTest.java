//package com.example.RMB.data.controller;
//
//import com.example.RMB.data.entity.User;
//import com.example.RMB.data.service.UserService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//public class UserControllerTest {
//
//    @Mock
//    private UserService userService;
//
//    private UserController userController;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this);
//        userController = new UserController(userService);
//    }
//
//    @Test
//    void testFindByLicenseNumber() {
//        // Arrange
//        String licenseNumber = "1234567890";
//        User expectedUser = new User();
//        expectedUser.setName("john");
//        expectedUser.setLicenseNumber("12341231");
//        expectedUser.setAddress("sfsdffsd");
//        expectedUser.setNICNumber("111111");
//
//        when(userService.findByLicenseNumber(licenseNumber)).thenReturn(new ResponseEntity<>(expectedUser, HttpStatus.OK));
//
//        // Act
//        ResponseEntity<User> actualResponse = userController.findByLicenseNumber(licenseNumber);
//
//        // Assert
//        verify(userService).findByLicenseNumber(licenseNumber);
//        assertEquals(HttpStatus.OK, actualResponse.getStatusCode());
//        assertEquals(expectedUser, actualResponse.getBody());
//    }
//}
