package org.mql.bank_account_service.web;

import org.mql.bank_account_service.dto.CustomerDTO;
import org.mql.bank_account_service.services.CustomerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerRestController {

    CustomerService customerService;

    public CustomerRestController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<CustomerDTO> customers(){

       return customerService.getAllCustomers();
    }
}
