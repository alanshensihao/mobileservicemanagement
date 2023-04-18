import java.io.IOException;

public class MDMClient
{
  private static UI ui;
  private static ClientMessageHandler clientMessageHandler;

  private static void clientLoop()
  {
    ui.printUI();
    String messageToServer = ui.retrieveUserInput();
    if (!messageToServer.isEmpty())
    {
      clientMessageHandler.sendMessage(messageToServer);
      String responseMessageFromServer = clientMessageHandler.retrieveMessage();

      System.out.println(responseMessageFromServer);
    }
  }

  public static void main(String[] args) 
  {
    ui = new UI();
    clientMessageHandler = new ClientMessageHandler();

    try
    {
      while (true)
      {
        clientLoop();
      }
    }
    catch (Exception e)
    {
      System.out.println("Error");
    }
  }
}
