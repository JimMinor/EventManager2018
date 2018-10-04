package DB;

public class LoginCommand implements Command {

    private String username;
    private String password;

    public LoginCommand(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public void execute() {

    }
}
