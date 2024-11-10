package org.mql.bank_account_service.web;

import org.mql.bank_account_service.dto.BankAccountRequestDTO;
import org.mql.bank_account_service.dto.BankAccountResponseDTO;
import org.mql.bank_account_service.dto.CustomerDTO;
import org.mql.bank_account_service.entities.BankAccount;
import org.mql.bank_account_service.repositories.BankAccountRepository;
import org.mql.bank_account_service.services.AccountService;
import org.mql.bank_account_service.services.CustomerService;
import org.springframework.data.repository.query.Param;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BankAccountGraphQLController {
     AccountService accountService;
     CustomerService customerService;


    public BankAccountGraphQLController(AccountService accountService,CustomerService customerService ) {
        this.accountService = accountService;
        this.customerService=customerService;

    }

    @QueryMapping
   public  List<BankAccountResponseDTO> accountsList(){

        return accountService.getAllAccount();

    }
    @QueryMapping
    public List<CustomerDTO> customerList(){

        return customerService.getAllCustomers();
    }

    @QueryMapping
    public BankAccountResponseDTO accountById(@Argument String id){

        return accountService.getAccountById(id);
    }

    @MutationMapping
    public BankAccountResponseDTO createBankAccount(@Argument BankAccountRequestDTO bankAccountRequestDTO){
        return accountService.addAccount(bankAccountRequestDTO);
    }

    @MutationMapping
    public BankAccountResponseDTO updateBankAccount(@Argument String id,@Argument BankAccountRequestDTO bankAccountRequestDTO){
        return accountService.updateAccount(id,bankAccountRequestDTO);
    }

    @MutationMapping
    public Boolean deleteBankAccount(@Argument String id){

        accountService.deleteAccount(id);
        return true;
    }


}
