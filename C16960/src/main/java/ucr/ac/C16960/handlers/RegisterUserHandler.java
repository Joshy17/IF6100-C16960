package ucr.ac.C16960.handlers;

public interface RegisterUserHandler {
    record Command (String name, String email, String password) {}
    sealed interface Result{
        final record Success(String message) implements Result{}
        final record InvalidDate(String...fields) implements Result{}
    }
    Result RegisterUser(Command command);

}
