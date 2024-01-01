//package com.example.RMB.data.batch;
//
//import com.example.RMB.data.config.BatchConfig;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.JobParameters;
//import org.springframework.batch.core.JobParametersBuilder;
//import org.springframework.batch.core.configuration.JobRegistry;
//import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.core.job.builder.JobBuilder;
//import org.springframework.batch.core.launch.JobLauncher;
//import org.springframework.batch.core.repository.JobRepository;
//import org.springframework.batch.core.step.builder.StepBuilder;
//import org.springframework.batch.repeat.RepeatStatus;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.transaction.PlatformTransactionManager;
//
//import static org.mockito.Mockito.*;
//
//@ExtendWith(MockitoExtension.class)
//@ExtendWith(SpringExtension.class)
//@SpringBootTest
//@ContextConfiguration(classes = {BatchConfig.class, BatchConfigTest.TestConfiguration.class})
//public class BatchConfigTest {
//
//    @Mock
//    private JobLauncher jobLauncher;
//
//    @Mock
//    private JobRegistry jobRegistry;
//
//    @Mock
//    private JobRepository jobRepository;
//
//    @Mock
//    private PlatformTransactionManager transactionManager;
//
//    @Mock
//    private JobBuilderFactory jobBuilderFactory;
//
//    @Mock
//    private StepBuilderFactory stepBuilderFactory;
//
//    @Test
//    public void testBatchJob_Success() throws Exception {
//        // Arrange
//        JobParameters jobParameters = new JobParametersBuilder().addString("jobId", "userReadJob").toJobParameters();
//        JobBuilder jobBuilder = Mockito.spy(new JobBuilder("userReadJob", jobRepository));
//
//        BatchConfig batchConfig = new BatchConfig();
//
//        when(jobLauncher.run(any(Job.class), any(JobParameters.class))).thenReturn(null);
//        when(jobBuilderFactory.get(anyString())).thenReturn(jobBuilder);
//        when(stepBuilderFactory.get(anyString())).thenReturn(Mockito.spy(new StepBuilder("step1")));
//
//        // Act
//        batchConfig.bookReaderJob(jobRepository, transactionManager).execute(jobExecution -> RepeatStatus.FINISHED);
//
//        // Assert
//        verify(jobBuilderFactory).get("userReadJob");
//        verify(jobLauncher).run(any(Job.class), eq(jobParameters));
//    }
//
//    @EnableBatchProcessing
//    static class TestConfiguration {
//
//        // Mock additional beans if needed
//    }
//}