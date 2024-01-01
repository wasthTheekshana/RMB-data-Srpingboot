package com.example.RMB.data.service;

import com.example.RMB.data.entity.User;
import com.example.RMB.data.exception.DataNotFoundException;
import com.example.RMB.data.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Value("${spring.kafka.topic.name}")
    private String topicName;

    private UserRepository userRepository;
    private KafkaTemplate<String,Object> kafkaTemplate;


    public UserServiceImpl(UserRepository userRepository, KafkaTemplate<String, Object> kafkaTemplate) {
        this.userRepository = userRepository;
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public ResponseEntity<User> findByLicenseNumber(String lNumber) {
        User licesenNumberUser = userRepository.findByLicenseNumber(lNumber).orElseThrow(() -> new DataNotFoundException("License Number Not found", String.valueOf(lNumber)));
       // kafkaTemplate.send(topicName,licesenNumberUser);
        return ResponseEntity.status(HttpStatus.OK).body(licesenNumberUser);
    }
}
