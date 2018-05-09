package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
    String hello=null;

     public WelcomeController(@Value("${WELCOME_MESSAGE}")String message) {
       hello=message;
    }
    @GetMapping("/")
    public String sayHello() {
        return hello;
    }

}
/*
package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    private String welcomeMessage;

    public WelcomeController(
        @Value("${welcome_message}") String welcomeMessage
    ) {
        this.welcomeMessage = welcomeMessage;
    }

    @GetMapping("/")
    public String sayHello() {
        return welcomeMessage;
    }
}
 */