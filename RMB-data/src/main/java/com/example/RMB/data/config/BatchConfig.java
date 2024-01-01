package com.example.RMB.data.config;

import com.example.RMB.data.batch.UserLicenseNumberProcessor;
import com.example.RMB.data.batch.UserNameProcessor;
import com.example.RMB.data.batch.UserWriter;
import com.example.RMB.data.entity.User;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.support.CompositeItemProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;

import java.util.List;

@Configuration
public class BatchConfig {

    @Bean
    public Job bookReaderJob(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        return new JobBuilder("userReadJob", jobRepository)
                .incrementer(new RunIdIncrementer())
                .start(chunkStep(jobRepository, transactionManager))
                .build();
    }

    @Bean
    public Step chunkStep(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        return new StepBuilder("userReaderStep", jobRepository).<User, User>
                        chunk(10, transactionManager)
                .reader(reader())
//                .reader(restBookReader())
                .processor(processor())
                .writer(writer())
                .build();

    }

    @Bean
    public FlatFileItemReader<User> reader() {
        return new FlatFileItemReaderBuilder<User>()
                .name("userReader")
                .resource(new ClassPathResource("random_data.csv"))
                .delimited()
                .names(new String[]{"name","licenseNumber","address","NICNumber"})
                .fieldSetMapper(new BeanWrapperFieldSetMapper<>() {{
                    setTargetType(User.class);
                }})
                .build();
    }

    @Bean
    public ItemProcessor<User, User> processor() {
        CompositeItemProcessor<User, User> processor = new CompositeItemProcessor<>();
        processor.setDelegates(List.of(new UserNameProcessor(), new UserLicenseNumberProcessor()));
        return processor;
    }

    @Bean
    public ItemWriter<User> writer() {
        return new UserWriter();
    }

}
