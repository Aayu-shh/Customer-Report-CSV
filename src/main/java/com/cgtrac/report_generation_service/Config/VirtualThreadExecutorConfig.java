package com.cgtrac.report_generation_service.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Configuration
public class VirtualThreadExecutorConfig {

    @Bean(name="virtualThreadExecutor")
    public Executor virtualThreadExecutor(){
        return Executors.newVirtualThreadPerTaskExecutor();
    }
}
