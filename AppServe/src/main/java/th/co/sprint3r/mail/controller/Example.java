package th.co.sprint3r.mail.controller;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;

@SpringBootApplication(scanBasePackages={"th.co.sprint3r.mail.controller","th.co.sprint3r.mail.dao","th.co.sprint3r.mail.model"})
public class Example {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Example.class, args);
    }

}
