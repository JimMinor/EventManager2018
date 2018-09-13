package Controller;

public class NoValidEventDateException extends Exception {
  private String messagge;
  public NoValidEventDateException(){super();}
  public NoValidEventDateException(String messagge){ super(messagge);
  this.messagge=messagge;}
  public String getMessagge(){return messagge;}

}
