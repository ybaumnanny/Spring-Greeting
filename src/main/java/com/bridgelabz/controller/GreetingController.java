package com.bridgelabz.controller;

import com.bridgelabz.model.Greeting;
import com.bridgelabz.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greet") // Base mapping to avoid repetition
public class GreetingController {

    private final GreetingService greetingService;

    // Constructor-based dependency injection (Best Practice)
    @Autowired
    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    // UC1: Basic Greeting Operations
    @GetMapping
    public Greeting getGreeting() {
        return new Greeting("Hello from BridgeLabz");
    }

    @PostMapping
    public Greeting postGreeting(@RequestBody Greeting greeting) {
        return greeting;
    }

    @PutMapping
    public Greeting putGreeting(@RequestBody Greeting greeting) {
        return new Greeting("Updated: " + greeting.getMessage());
    }

    @DeleteMapping
    public Greeting deleteGreeting() {
        return new Greeting("Greeting deleted");
    }

    // UC3: Get Greeting with Optional Name Inputs
    @GetMapping("/input")
    public Greeting getGreetingWithName(@RequestParam(required = false) String firstName,
                                        @RequestParam(required = false) String lastName) {
        return new Greeting(greetingService.getGreetingMessage(firstName, lastName));
    }

    // UC4: Save Greeting with Name Inputs
    @PostMapping("/save")
    public Greeting saveGreeting(@RequestParam(required = false) String firstName,
                                 @RequestParam(required = false) String lastName) {
        return new Greeting(greetingService.getGreetingMessage(firstName, lastName));
    }
}
