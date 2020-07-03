package guru.springframework.sfgdi.controllers;

import guru.services.GreetingService;
import org.springframework.stereotype.Component;

@Component
public class MyController {

    //Ajouts pour tester le primary
    private final GreetingService greetingService;

    public MyController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String sayHello(){
        System.out.println("Hello World");
        // return "Hi folks";
        //Changement de return pour tester primary
        return greetingService.sayGreeting();


    }
}
