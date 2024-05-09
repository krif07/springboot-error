package co.com.cfd.springboot.error.springbooterror;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.com.cfd.springboot.error.springbooterror.models.domain.User;

@Configuration
public class AppConfig {

    @Bean
    List<User> users() {
        List<User> users = new ArrayList<>();
        users.add(new User(1L, "Carlos", "Pantoja"));
        users.add(new User(2L, "Felipe", "Marin"));
        users.add(new User(3L, "Marcela", "Arroyabe"));
        users.add(new User(4L, "Marlen", "Rojas"));
        users.add(new User(5L, "Milena", "Lopez"));

        return users;
    }

}
