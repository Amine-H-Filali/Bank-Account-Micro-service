package org.mql.bank_account_service.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.mql.bank_account_service.enums.AccountType;

import java.time.LocalDate;
import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BankAccountResponseDTO {

    private String id;
    private LocalDate createAt;
    private Double balance;
    private String currency;
    private AccountType type;
    private Long customerId;
}
