package com.example.RMB.data.batch;

import com.example.RMB.data.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;

@Slf4j
public class UserLicenseNumberProcessor implements ItemProcessor<User,User> {
    @Override
    public User process(User item) throws Exception {
        log.info("Process licences number: {}", item);
        item.setLicenseNumber(item.getLicenseNumber());
        return item;
    }
}
