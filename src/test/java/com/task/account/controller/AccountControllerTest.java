package com.task.account.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.task.account.dto.AccountDtoConverter;
import com.task.account.repository.AccountRepository;
import com.task.account.service.AccountService;
import com.task.account.service.CustomerService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.Clock;
import java.util.UUID;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.*;

// integration test controller seviyesinde test etmemize yarıyor. yani bir controller içerisindeki endpointe istek atılır
// ve o isteğin gerçekten doğru bir veri döndüğü kontrol edilir.
@ActiveProfiles("test")
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, properties = {
        "server-port = 0",
        "command.line.runner.enable = false"
})
@DirtiesContext
@RunWith(SpringRunner.class)
class AccountControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private Clock clock;

    @MockBean
    private Supplier<UUID> uuidSupplier;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private AccountDtoConverter accountDtoConverter;

    private AccountService service = new AccountService(accountRepository, customerService, accountDtoConverter);
    private ObjectMapper mapper = new ObjectMapper();
    private static final UUID uuid = UUID.randomUUID();


}