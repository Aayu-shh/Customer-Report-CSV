package com.cgtrac.report_generation_service.Service;

import com.cgtrac.report_generation_service.Model.Customer;
import com.cgtrac.report_generation_service.Repository.CustomerRepository;
import com.cgtrac.report_generation_service.Util.CSVReportUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ReportService {

    @Autowired
    CustomerRepository customerRepository;


    public ResponseEntity<String> generateReport(String region) {
      log.info("Generating report for region {} | {}",region,Thread.currentThread());
        List<Customer> customersByRegion =customerRepository.findByRegion(region);
        try{
            CSVReportUtil.writeCustomersToCsv("simple.."+region,customersByRegion);
            return new ResponseEntity<>("SUCCESS", HttpStatus.CREATED);
        }
        catch (Exception e){
            System.out.println("Error writing the report for region: "+region);
            return new ResponseEntity<>("SUCCESS", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
