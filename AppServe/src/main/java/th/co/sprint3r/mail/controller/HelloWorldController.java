package th.co.sprint3r.mail.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/HelloWorld")
public class HelloWorldController {


    @RequestMapping("/Greeting")
    public String index() {
        return "Greetings from Spring Boot!";
    }

}
