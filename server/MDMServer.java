import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MDMServer
{
    private static ServerSocket server;
    private static int port = 1234;
    
    public static void main(String args[])
	{
		try
		{
			server = new ServerSocket(port);
			
			while (true)
			{
				System.out.println("Pending request from clients...");
				Socket socket = server.accept();	
				
				ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
				String message = (String) ois.readObject();
				System.out.println("Retrieved Message: " + message);

				ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
				oos.writeObject(message);
				System.out.println("Sent Message: " + message);

				oos.close();
				ois.close();
				socket.close();

				break;
			}

			server.close();
		}
		catch (Exception e) 
		{
			System.out.println("Error");
		}
    }
}