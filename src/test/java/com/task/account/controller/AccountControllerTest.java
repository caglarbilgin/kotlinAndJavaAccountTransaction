package com.task.account.controller;

import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

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

}