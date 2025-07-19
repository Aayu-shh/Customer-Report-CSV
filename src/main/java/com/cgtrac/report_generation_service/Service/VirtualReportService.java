package com.cgtrac.report_generation_service.Service;

import com.cgtrac.report_generation_service.Model.Customer;
import com.cgtrac.report_generation_service.Repository.CustomerRepository;
import com.cgtrac.report_generation_service.Util.CSVReportUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Slf4j
@Service
public class VirtualReportService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    private Executor virtualThreadExecutor;

    public void generateReportVirtual(String region) {
        log.info("Generating Virtual thread report for region {} | {}",region,Thread.currentThread());

        //Using Virtual Thread
        virtualThreadExecutor.execute(()->{
            List<Customer> customersByRegion =customerRepository.findByRegion(region);
            try{
                CSVReportUtil.writeCustomersToCsv("Virtual.."+region,customersByRegion);
            }
            catch (Exception e){
                System.out.println("Error writing the virtual report for region: "+region);
            }
        });
    }
}
