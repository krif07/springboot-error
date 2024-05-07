package co.com.cfd.springboot.error.springbooterror.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class AppController {

    @GetMapping("/app")
    public String index() {
        int val = 100 / 0;
        System.out.println(val);
        return "OK!";
    }
}
