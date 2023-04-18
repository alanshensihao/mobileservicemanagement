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
        UserManagement userManagement = new UserManagement();
        BundleManagement bundleManagement = new BundleManagement();
        AccountManagement accountManagement = new AccountManagement();
        System.out.println("Listening to the client...");
        Socket socket = server.accept();  

        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        String message = (String) ois.readObject();
        System.out.println("Retrieved Message: " + message);
        String[] parameters = message.split(",\\s*");
        System.out.println("parameters: " + parameters);
        String menu_option = parameters[0];
        String acknowledgement;
        switch (menu_option)
        {
          case "1":
            User user1 = new User(parameters[1], parameters[2], parameters[3]);
            userManagement.addUser(user1);
            acknowledgement = "Successfully added the user " + parameters[1];
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(acknowledgement);
            System.out.println("Sent Message: " + acknowledgement);
            oos.close();
            break;
          case "3":
            userManagement.updateUser(parameters[1], parameters[2], parameters[3]);
            acknowledgement = "Successfully updated the user " + parameters[1];
            ObjectOutputStream oos1 = new ObjectOutputStream(socket.getOutputStream());
            oos1.writeObject(acknowledgement);
            System.out.println("Sent Message: " + acknowledgement);
            oos1.close();
            break;
          case "4":
            userManagement.deleteUser(parameters[1]);
            acknowledgement = "Successfully deleted the user " + parameters[1];
            ObjectOutputStream oos2 = new ObjectOutputStream(socket.getOutputStream());
            oos2.writeObject(acknowledgement);
            System.out.println("Sent Message: " + acknowledgement);
            oos2.close();
            break;
        }
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
