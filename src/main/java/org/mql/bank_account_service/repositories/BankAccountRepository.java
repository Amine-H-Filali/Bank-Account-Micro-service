package org.mql.bank_account_service.repositories;

import org.mql.bank_account_service.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface BankAccountRepository extends JpaRepository<BankAccount,String> {

    List<BankAccount> findByCurrency(String currency);

    @Query("SELECT b FROM BankAccount b where b.currency > :currency")
    List<BankAccount> findCurrenciesGreatThen(@Param("currency") String currency);
}
