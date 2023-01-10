package com.task.account.service;

import com.task.account.dto.AccountDto;
import com.task.account.dto.AccountDtoConverter;
import com.task.account.dto.CreateAccountRequest;
import com.task.account.model.Account;
import com.task.account.model.Customer;
import com.task.account.model.Transaction;
import com.task.account.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class AccountService {

    //    @Autowired bunun yerine final kullanmak daha yararlı
//    immutable olmuyor, test etmek için ona göre bir mock yazmak gerekiyor ve test edilebilirliği azalıyor
    private final AccountRepository accountRepository;
    private final CustomerService customerService;
    private final AccountDtoConverter converter;

    public AccountService(AccountRepository accountRepository,
                          CustomerService customerService,
                          AccountDtoConverter converter) {
        this.accountRepository = accountRepository;
        this.customerService = customerService;
        this.converter = converter;
    }

    public AccountDto createAccount(CreateAccountRequest createAccountRequest) {
        Customer customer = customerService.findCustomerById(createAccountRequest.getCustomerId());
        Account account = new Account(customer,
                createAccountRequest.getInitialCredit(),
                LocalDateTime.now());

        if (createAccountRequest.getInitialCredit().compareTo(BigDecimal.ZERO) > 0) {
            Transaction transaction = new Transaction(createAccountRequest.getInitialCredit(), account);
            account.getTransaction().add(transaction);
        }
        return converter.convert(
                accountRepository.save(account));
    }
}
