package ucr.ac.C16960;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import ucr.ac.C16960.handlers.RegisterUserHandler;
@RestController
public class HelloController {

    @Autowired //Se usa para inyectar dependencias
    private RegisterUserHandler handler;
    @GetMapping("/hello")
    public String hello() {



      var result = handler.RegisterUser(new RegisterUserHandler.Command("Joshua", "joshua@gmail.com", "123ASD"));


      return switch (result){
          case RegisterUserHandler.Result.Success success-> success.message();
          case RegisterUserHandler.Result.InvalidDate invalidDate->
            "Invalid date: " + String.join(" , ", invalidDate.fields());
      };
    }
}