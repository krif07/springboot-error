package co.com.cfd.springboot.error.springbooterror.controllers;

import org.springframework.web.bind.annotation.RestController;

import co.com.cfd.springboot.error.springbooterror.exceptions.UserNotFoundException;
import co.com.cfd.springboot.error.springbooterror.models.domain.User;
import co.com.cfd.springboot.error.springbooterror.services.IUserService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/app")
public class AppController {

    @Autowired
    private IUserService userService;

    @GetMapping("/index")
    public String app() {
        int val = 100 / 0;
        System.out.println(val);
        return "OK!";
    }
    
    @GetMapping("/index2")
    public String app2() {
        int val = Integer.parseInt("x");
        System.out.println(val);
        return "OK!";
    }
    
    @GetMapping("/show/{id}")
    public User show(@PathVariable(name = "id") Long id) {
        User user = userService.findById(id)
            .orElseThrow(() -> new UserNotFoundException("Error, el usuario no existe!"));
        System.out.println(user.getName());
        return user;
    }
    @GetMapping("/show2/{id}")
    public ResponseEntity<?> show2(@PathVariable(name = "id") Long id) {
        Optional<User> optionalUser = userService.findById(id);
        if (optionalUser.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(optionalUser.orElseThrow());
    }
    
}
