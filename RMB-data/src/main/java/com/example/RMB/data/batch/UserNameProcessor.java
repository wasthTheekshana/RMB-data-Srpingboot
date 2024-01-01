package com.example.RMB.data.batch;

import com.example.RMB.data.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;

@Slf4j
public class UserNameProcessor implements ItemProcessor<User,User> {
    @Override
    public User process(User item) throws Exception {
        log.info("Process user name: {}", item);
        item.setName("By" + item.getName());
        return item;
    }
}
