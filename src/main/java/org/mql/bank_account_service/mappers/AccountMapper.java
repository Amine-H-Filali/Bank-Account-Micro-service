package org.mql.bank_account_service.mappers;

import org.mql.bank_account_service.dto.BankAccountRequestDTO;
import org.mql.bank_account_service.dto.BankAccountResponseDTO;
import org.mql.bank_account_service.dto.CustomerDTO;
import org.mql.bank_account_service.entities.BankAccount;
import org.mql.bank_account_service.entities.Customer;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class AccountMapper {

    public static BankAccountResponseDTO fromBankAccount(BankAccount bankAccount) {
        BankAccountResponseDTO bankAccountResponseDTO = new BankAccountResponseDTO();
        BeanUtils.copyProperties(bankAccount, bankAccountResponseDTO);
        bankAccountResponseDTO.setCustomerId(bankAccount.getCustomer().getId());


        return bankAccountResponseDTO;
    }

    public BankAccount fromBankAccountRequestDTO(BankAccountRequestDTO bankAccountRequestDTO) {
        BankAccount bankAccount = new BankAccount();
        BeanUtils.copyProperties(bankAccountRequestDTO, bankAccount);
        bankAccount.setId(UUID.randomUUID().toString());
        bankAccount.setCreateAt(LocalDate.now());

        return bankAccount;
    }

    public static CustomerDTO toCustomerDTO(Customer customer) {
        CustomerDTO customerDTO = new CustomerDTO();
        BeanUtils.copyProperties(customer,customerDTO,"bankAccounts");
        List<BankAccountResponseDTO> bankAccounts = customer.getBankAccounts()
                .stream()
                .map(AccountMapper::fromBankAccount)
                .collect(Collectors.toList());

        customerDTO.setBankAccounts(bankAccounts);



        return customerDTO;
    }




}
