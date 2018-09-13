package DB;
@FunctionalInterface
public interface Command {
    public void execute() throws Exception;
}
