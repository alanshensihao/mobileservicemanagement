import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMessageHandler
{
  private final int port = 1234;
  private ServerSocket server;
  private Socket socket;
  private ObjectOutputStream oos;
  private ObjectInputStream ois;

  public ServerMessageHandler()
  {
    try
    {
      server = new ServerSocket(port);

      System.out.println("Waiting for client to connect...");
      socket = server.accept();
      oos = new ObjectOutputStream(socket.getOutputStream());
      ois = new ObjectInputStream(socket.getInputStream());
    }
    catch(Exception e)
    {
      System.out.println("Error occurred creating the socket");
    }
  }

  public void sendMessage(String messageToClient)
  {
    try
    {
      oos.writeObject(messageToClient);
    }
    catch(Exception e)
    {
      System.out.println("Error occurred sending a message");
    }
  }

  public String retrieveMessage()
  {
    String messageFromClient = "";
    try
    {
      messageFromClient = (String) ois.readObject();
    }
    catch(Exception e)
    {
      System.out.println("Error occurred retrieving a message");
    }
    return messageFromClient;
  }
}
