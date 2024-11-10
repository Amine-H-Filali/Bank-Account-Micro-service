package org.mql.bank_account_service.services;

import org.mql.bank_account_service.dto.BankAccountResponseDTO;
import org.mql.bank_account_service.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {


    List<CustomerDTO> getAllCustomers();
}
