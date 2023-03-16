import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class MDMClient {

    private static int port = 1234;

    public static void main(String[] args) 
	{
		String message = "Test12345";
		
		try
		{
			InetAddress host = InetAddress.getLocalHost();
			Socket socket = new Socket(host.getHostName(), port);
			
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			
			oos.writeObject(message);
			System.out.println("Sent Message: " + message);
			
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			message = (String) ois.readObject();
			System.out.println("Retrieved Message: " + message);
			
			ois.close();
			oos.close();
		}
		catch (Exception e)
		{
			System.out.println("Error");
		}
    }
}