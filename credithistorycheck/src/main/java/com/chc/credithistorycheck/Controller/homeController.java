package com.chc.credithistorycheck.Controller;

import java.util.Random;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/eligible")
@CrossOrigin("*")
public class homeController {
    
    @GetMapping
    public int eligible(){
        Random rand = new Random();
        int randInt = rand.nextInt(2);
        return randInt;
    }
}
