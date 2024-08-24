package ucr.ac.C16960.handlers.impl;

import org.springframework.beans.factory.annotation.Autowired;
import ucr.ac.C16960.handlers.RegisterUserHandler;
import org.springframework.stereotype.Component;
import ucr.ac.C16960.jpa.entities.UserEntity;
import ucr.ac.C16960.jpa.entities.repositories.UserRepository;

import java.util.UUID;

@Component
public class RegisterUserHadlerIMPL implements RegisterUserHandler {

    @Autowired
    private UserRepository repository;

    @Override
    public Result RegisterUser(Command command) {
        System.out.println("User registered: ");

        var user = new UserEntity();

        user.setId(UUID.randomUUID());
        user.setName(command.name());
        user.setEmail(command.email());

        repository.save(user);
        return new Result.Success("OK");
    }
}
