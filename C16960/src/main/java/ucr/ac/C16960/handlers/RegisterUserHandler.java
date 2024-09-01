package ucr.ac.C16960.handlers;

public interface RegisterUserHandler {
    //Entrada
    record Command(String name, String email, String password) {
    }

    //Salida
    sealed interface Result {
        record Success(String message) implements Result {
        }

        record InvalidData(String... fields) implements Result {
        }
        record EmailAlreadyExists(String email) implements Result {
        }
    }

    //Proceso
    Result RegisterUser(Command command);

}
