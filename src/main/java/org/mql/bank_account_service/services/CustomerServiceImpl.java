package org.mql.bank_account_service.services;

import org.mql.bank_account_service.dto.CustomerDTO;
import org.mql.bank_account_service.entities.BankAccount;
import org.mql.bank_account_service.entities.Customer;
import org.mql.bank_account_service.mappers.AccountMapper;
import org.mql.bank_account_service.repositories.CustomerRepository;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class CustomerServiceImpl implements CustomerService{

    private CustomerRepository customerRepository;

    private AccountMapper accountMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, AccountMapper accountMapper) {
        this.customerRepository = customerRepository;
        this.accountMapper = accountMapper;
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> customerList = customerRepository.findAll();
        return customerList.stream()
                .map(AccountMapper::toCustomerDTO)
                .toList();


    }
}
