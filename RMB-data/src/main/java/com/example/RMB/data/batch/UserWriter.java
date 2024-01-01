package com.example.RMB.data.batch;

import com.example.RMB.data.entity.User;
import com.example.RMB.data.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class UserWriter implements ItemWriter<User> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void write(Chunk<? extends User> chunk) throws Exception {
        log.info("Writting: {}", chunk.getItems().size());
        userRepository.saveAll(chunk.getItems());
    }
}
