package com.cgtrac.report_generation_service.Service;

import com.cgtrac.report_generation_service.Model.Customer;
import com.cgtrac.report_generation_service.Repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;


    public ResponseEntity<String> addCustomer(Customer customer) {
        try{
            customerRepository.save(customer);
            return new ResponseEntity<>("Customer Added Successfully", HttpStatus.CREATED);
        }
        catch (Exception e){
            log.info(Arrays.toString(e.getStackTrace()));
            return new ResponseEntity<>("Something went wrong : "+ e.getLocalizedMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<List<Customer>> getAllCustomers() {
        try{
            List<Customer> customerList = customerRepository.findAll();
            return new ResponseEntity<>(customerList, HttpStatus.OK);
        }
        catch (Exception e){
            log.info(Arrays.toString(e.getStackTrace()));
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
