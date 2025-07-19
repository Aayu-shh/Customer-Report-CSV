package com.cgtrac.report_generation_service.Controller;

import com.cgtrac.report_generation_service.Model.Customer;
import com.cgtrac.report_generation_service.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping("add")
    public ResponseEntity<String> addCustomer(@RequestBody Customer customer){
        return customerService.addCustomer(customer);
    }

    @GetMapping("get")
    public ResponseEntity<List<Customer>> getCustomers(){
        return customerService.getAllCustomers();
    }


}
