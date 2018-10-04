package Control;

public class NoValidEventDataException extends Exception {
  private String messagge;
  public NoValidEventDataException(){super();}
  public NoValidEventDataException(String messagge){ super(messagge);
  this.messagge=messagge;}
  public String getMessagge(){return messagge;}

}
