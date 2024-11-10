package org.mql.bank_account_service;

import org.mql.bank_account_service.entities.BankAccount;
import org.mql.bank_account_service.enums.AccountType;
import org.mql.bank_account_service.repositories.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;


@SpringBootApplication
public class BankAccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankAccountServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner start(BankAccountRepository bankAccountRepository){
		return e->{

			for(int i=0;i<10;i++){

				BankAccount bankAccount=BankAccount.builder()
						.id(UUID.randomUUID().toString())
						.createAt(LocalDate.now())
						.type(Math.random()>0.5? AccountType.CURRENT_ACCOUNT:AccountType.SAVING_ACCOUNT)
						.balance(10000+Math.random()*90000)
						.currency("MAD")
						.build();

				bankAccountRepository.save(bankAccount);
			}


		};
	}



}
