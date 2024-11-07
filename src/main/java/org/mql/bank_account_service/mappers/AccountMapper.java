package org.mql.bank_account_service.mappers;

import org.mql.bank_account_service.dto.BankAccountRequestDTO;
import org.mql.bank_account_service.dto.BankAccountResponseDTO;
import org.mql.bank_account_service.entities.BankAccount;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
public class AccountMapper {

     public static BankAccountResponseDTO fromBankAccount(BankAccount bankAccount){
         BankAccountResponseDTO bankAccountResponseDTO=new BankAccountResponseDTO();
         BeanUtils.copyProperties(bankAccount,bankAccountResponseDTO);


    return bankAccountResponseDTO;
    }

    public BankAccount fromBankAccountRequestDTO(BankAccountRequestDTO bankAccountRequestDTO){
         BankAccount bankAccount=new BankAccount();
         BeanUtils.copyProperties(bankAccountRequestDTO,bankAccount);
        bankAccount.setId(UUID.randomUUID().toString());
        bankAccount.setCreateAt(new Date());

        return bankAccount;
    }


}
