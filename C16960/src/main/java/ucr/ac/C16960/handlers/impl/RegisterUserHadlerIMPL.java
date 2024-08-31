package ucr.ac.C16960.handlers.impl;

import org.springframework.beans.factory.annotation.Autowired;
import ucr.ac.C16960.handlers.RegisterUserHandler;
import org.springframework.stereotype.Component;
import ucr.ac.C16960.jpa.entities.UserEntity;
import ucr.ac.C16960.jpa.entities.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class RegisterUserHadlerIMPL implements RegisterUserHandler {

    @Autowired
    private UserRepository repository;

    @Override
    public Result RegisterUser(Command command) {
        var result = validateRules(command);
        if (result != null) {
            return result;
        }
        var user = mapToUserEntity(command);
        repository.save(user);
        return new Result.Success("OK");
    }

    private UserEntity mapToUserEntity(Command command) {
        var user = new UserEntity();
        user.setId(UUID.randomUUID());
        user.setName(command.name());
        user.setEmail(command.email());
        user.setPassword(command.password());
        return user;
    }

    private Result validateRules(Command command) {
        var result = validateInvaldFields(command);

        if (result != null) {
            return result;
        }
        result = validateUserExists(command);
        if (result != null) {
            return result;
        }

        result = validateEmail(command);
        if (result != null) {
            return result;
        }

        return null;
    }

    private Result validateEmail(Command command) {

        if (!command.email().matches(".*@.*")) {
            return new Result.InvalidData("email");
        }
        return null;
    }

    private Result validateUserExists(Command command) {
        if (repository.findByEmail(command.email()).isPresent()) {
            return new Result.EmailAlreadyExists(command.email());
        }
        return null;
    }

    private Result validateInvaldFields(Command command) {
        List<String> invalidFields = new ArrayList<>();
        if (command.name() == null || command.name().isEmpty()) {
            invalidFields.add("name");
        }
        if (command.email() == null || command.email().isEmpty()) {
            invalidFields.add("email");
        }
        if (command.password() == null || command.password().isEmpty()) {
            invalidFields.add("password");
        }
        if (invalidFields.size() > 0) {
            return new Result.InvalidData(invalidFields.toArray(new String[0]));
        }
        return null;
    }

}
