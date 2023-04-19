import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.net.InetAddress;
import java.net.Socket;

public class ClientMessageHandler
{
  private final int port = 1234;
  private Socket socket;
  private ObjectOutputStream oos;
  private ObjectInputStream ois;

  public ClientMessageHandler()
  {
    try
    {
      InetAddress host = InetAddress.getLocalHost();
      socket = new Socket(host.getHostName(), port);
      oos = new ObjectOutputStream(socket.getOutputStream());
      ois = new ObjectInputStream(socket.getInputStream());
    }
    catch(Exception e)
    {
      System.out.println("Error occurred creating the socket");
    }
  }

  public void sendMessage(String messageToServer)
  {
    try
    {
      oos.writeObject(messageToServer);
    }
    catch(Exception e)
    {
      System.out.println("Error occurred sending a message");
    }
  }

  public String retrieveMessage()
  {
    String responseMessageFromServer = "";
    try
    {
      responseMessageFromServer = (String) ois.readObject();
    }
    catch(Exception e)
    {
      System.out.println("Error occurred retrieving a message");
    }
    return responseMessageFromServer;
  }
}
