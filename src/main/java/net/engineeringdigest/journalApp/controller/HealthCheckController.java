package net.engineeringdigest.journalApp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/journal-health")
public class HealthCheckController {

    @GetMapping("/check-status")
    public String status(){
        return "The Server is up and running!!!";
    }
}
