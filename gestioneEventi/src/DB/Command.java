package DB;
@FunctionalInterface
public interface Command {
    void execute() throws Exception;
}
