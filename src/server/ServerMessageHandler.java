import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMessageHandler
{
  private static final int port = 1234;
	private static ServerSocket server;
  private static Socket socket;

  public ServerMessageHandler()
  {
		try
    {
      server = new ServerSocket(port);
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
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			oos.writeObject(messageToClient);
			oos.close();
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
      System.out.println("Listening to the client...");
      socket = server.accept();

			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			messageFromClient = (String) ois.readObject();
			ois.close();
		}
		catch(Exception e)
		{
			System.out.println("Error occurred retrieving a message");
		}
		return messageFromClient;
  }
}
