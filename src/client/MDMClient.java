import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.net.InetAddress;
import java.net.Socket;

public class MDMClient
{
  private static final int port = 1234;
  private static UI ui;

  private static void clientLoop()
  {
    ui.printUI();
    String messageToServer = ui.retrieveUserInput();
    if (!messageToServer.isEmpty())
    {

    }
  }

  public static void main(String[] args) 
  {
    ui = new UI();
    try
    {
      while (true)
      {
        clientLoop();
                /*
        String userInput = System.console().readLine();
        try
        {
          Integer.parseInt(userInput);
        }
        catch (NumberFormatException e)
        {

        }

        int menuOption = Integer.parseInt(System.console().readLine());
        InetAddress host = InetAddress.getLocalHost();
        Socket socket = new Socket(host.getHostName(), port);
        switch (menuOption)
        {
          case 1:
          case 2:
          case 3:
          case 4:
            String s =String.valueOf(menuOption);
            System.out.println("please type the values");
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            BufferedReader userPrompt = new BufferedReader(new InputStreamReader(System.in));
            String userMessage;
            userMessage = userPrompt.readLine();
            oos.writeObject(s+','+userMessage);
            System.out.println("Sent Message: " + userMessage);
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            message = (String) ois.readObject();
            System.out.println("Retrieved acknowledgement: " + message);
            ois.close();
            oos.close();
            break;
          case 5:
          case 6:
          case 7:
          case 8:
          case 9:
          case 10:
          case 11:
            System.out.println("Our team is still working on these options!!! Please try again later :)");
            break;
        }
        */
      }
    }
    catch (Exception e)
    {
      System.out.println("Error");
    }
  }
}
