import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.net.InetAddress;
import java.net.Socket;

public class ClientMessageHandler
{
  private static final int port = 1234;
  Socket socket;

  public ClientMessageHandler()
  {
    try
    {
      InetAddress host = InetAddress.getLocalHost();
      socket = new Socket(host.getHostName(), port);
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
      ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
      oos.writeObject(messageToServer);
      oos.close();
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
      ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
      responseMessageFromServer = (String) ois.readObject();
      ois.close();
    }
    catch(Exception e)
    {
      System.out.println("Error occurred retrieving a message");
    }
    return responseMessageFromServer;
  }
}
