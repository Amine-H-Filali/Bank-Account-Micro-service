package org.mql.bank_account_service.web;

import org.mql.bank_account_service.dto.BankAccountRequestDTO;
import org.mql.bank_account_service.dto.BankAccountResponseDTO;
import org.mql.bank_account_service.entities.BankAccount;
import org.mql.bank_account_service.repositories.BankAccountRepository;
import org.mql.bank_account_service.services.AccountService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/bankAccounts")
public class AccountRestController {

    private final AccountService accountService;

    public AccountRestController(AccountService accountService) {
        this.accountService = accountService;
    }


    @GetMapping
    public List<BankAccountResponseDTO> getAllBankAccounts() {
        return accountService.getAllAccount();
    }


    @GetMapping("/{id}")
    public BankAccountResponseDTO getBankAccount(@PathVariable String id) {
        return accountService.getAccountById(id);
    }


    @PostMapping
    public BankAccountResponseDTO createBankAccount(@RequestBody BankAccountRequestDTO bankAccountRequestDTO) {
        return accountService.addAccount(bankAccountRequestDTO);
    }


    @PutMapping("/{id}")
    public ResponseEntity<BankAccountResponseDTO> updateBankAccount(@PathVariable String id, @RequestBody BankAccountRequestDTO bankAccountRequestDTO) {
        BankAccountResponseDTO updatedAccount = accountService.updateAccount(id, bankAccountRequestDTO);
        return ResponseEntity.ok(updatedAccount);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBankAccount(@PathVariable String id) {
        accountService.deleteAccount(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/currency")
    public List<BankAccountResponseDTO> getAccountsByCurrency(@RequestParam(name = "currency", required = true) String currency) {
        return accountService.getAccountsByCurrency(currency);
    }
}
