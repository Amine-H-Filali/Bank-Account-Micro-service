package org.mql.bank_account_service.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.mql.bank_account_service.enums.AccountType;

import java.time.LocalDate;
import java.util.Date;
@Entity
@Data@NoArgsConstructor@AllArgsConstructor
@Builder

public class BankAccount {

    @Id
    private String id;
    private LocalDate createAt;
    private Double balance;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountType type;


}
