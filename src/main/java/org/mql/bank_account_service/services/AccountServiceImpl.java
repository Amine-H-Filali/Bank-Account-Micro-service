package org.mql.bank_account_service.services;

import org.mql.bank_account_service.dto.BankAccountRequestDTO;
import org.mql.bank_account_service.dto.BankAccountResponseDTO;
import org.mql.bank_account_service.entities.BankAccount;
import org.mql.bank_account_service.mappers.AccountMapper;
import org.mql.bank_account_service.repositories.BankAccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    private BankAccountRepository bankAccountRepository;

    private AccountMapper accountMapper;

    public AccountServiceImpl(BankAccountRepository bankAccountRepository, AccountMapper accountMapper) {
        this.bankAccountRepository = bankAccountRepository;
        this.accountMapper = accountMapper;
    }

    @Override
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO AccountRequestDTO) {
        BankAccount bankAccount = accountMapper.fromBankAccountRequestDTO(AccountRequestDTO);


        BankAccount saveBankAccount = bankAccountRepository.save(bankAccount);

        BankAccountResponseDTO bankAccountResponseDTO = AccountMapper.fromBankAccount(saveBankAccount);

        return bankAccountResponseDTO;
    }

    @Override
    public List<BankAccountResponseDTO> getAllAccount() {
        List<BankAccount> bankAccountList = bankAccountRepository.findAll();
        return bankAccountList.stream()
                .map(AccountMapper::fromBankAccount)
                .toList();


    }

    @Override
    public BankAccountResponseDTO getAccountById(String id) {
        BankAccount bankAccount = bankAccountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found"));
        return AccountMapper.fromBankAccount(bankAccount);
    }


    @Override
    public BankAccountResponseDTO updateAccount(String id, BankAccountRequestDTO bankAccountRequestDTO) {
        BankAccount bankAccount = bankAccountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found"));

        if (bankAccountRequestDTO.getBalance() != null) {
            bankAccount.setBalance(bankAccountRequestDTO.getBalance());
        }
        if (bankAccountRequestDTO.getType() != null) {
            bankAccount.setType(bankAccountRequestDTO.getType());
        }
        if (bankAccountRequestDTO.getCurrency() != null) {
            bankAccount.setCurrency(bankAccountRequestDTO.getCurrency());
        }
        bankAccountRepository.save(bankAccount);
        return AccountMapper.fromBankAccount(bankAccount);
    }

    @Override
    public void deleteAccount(String id) {
        BankAccount bankAccount = bankAccountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found"));
        bankAccountRepository.delete(bankAccount);
    }

    @Override
    public List<BankAccountResponseDTO> getAccountsByCurrency(String currency) {
        List<BankAccount> bankAccounts = bankAccountRepository.findCurrenciesGreatThen(currency);
        return bankAccounts.stream()
                .map(AccountMapper::fromBankAccount)
                .toList();
    }
}
