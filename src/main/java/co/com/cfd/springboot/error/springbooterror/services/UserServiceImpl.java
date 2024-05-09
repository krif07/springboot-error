package co.com.cfd.springboot.error.springbooterror.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.cfd.springboot.error.springbooterror.models.domain.User;

@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    private List<User> users;

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public Optional<User> findById(Long id) {
        Optional<User> user = users.stream()
            .filter(usr -> usr.getId().equals(id))
            .findFirst();

        return user;
    }

}
