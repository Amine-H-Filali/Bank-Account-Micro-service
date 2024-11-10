package org.mql.bank_account_service;

import org.mql.bank_account_service.entities.BankAccount;
import org.mql.bank_account_service.entities.Customer;
import org.mql.bank_account_service.enums.AccountType;
import org.mql.bank_account_service.repositories.BankAccountRepository;
import org.mql.bank_account_service.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

import java.util.UUID;
import java.util.stream.Stream;


@SpringBootApplication
public class BankAccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankAccountServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner start(BankAccountRepository bankAccountRepository, CustomerRepository customerRepository){
		return e->{

			Stream.of("Amine","Yassine","Hanane","Souad")
					.forEach((v)->{
						Customer customer=Customer.builder()
								.name(v)
								.build();
						customerRepository.save(customer);

					});

			customerRepository.findAll().forEach(
					(customer)->{

						for(int i=0;i<10;i++){

							BankAccount bankAccount=BankAccount.builder()
									.id(UUID.randomUUID().toString())
									.createAt(LocalDate.now())
									.type(Math.random()>0.5? AccountType.CURRENT_ACCOUNT:AccountType.SAVING_ACCOUNT)
									.balance(10000+Math.random()*90000)
									.currency("MAD")
									.customer(customer)
									.build();

							bankAccountRepository.save(bankAccount);
						}

					}
			);




		};
	}



}
