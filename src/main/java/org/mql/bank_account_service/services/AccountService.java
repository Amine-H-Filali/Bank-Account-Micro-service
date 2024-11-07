package org.mql.bank_account_service.services;

import org.mql.bank_account_service.dto.BankAccountRequestDTO;
import org.mql.bank_account_service.dto.BankAccountResponseDTO;
import org.mql.bank_account_service.entities.BankAccount;

import java.util.List;

public interface AccountService {

    BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountRequestDTO);

    List<BankAccountResponseDTO> getAllAccount();



    BankAccountResponseDTO getAccountById(String id);

    BankAccountResponseDTO updateAccount(String id, BankAccountRequestDTO bankAccountRequestDTO);

    void deleteAccount(String id);

    List<BankAccountResponseDTO> getAccountsByCurrency(String currency);
}
