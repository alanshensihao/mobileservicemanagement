public class MDMClient
{
  private static UI ui;
  private static ClientMessageHandler clientMessageHandler;

  private static void clientLoop()
  {
    ui.printUI();
    String messageToServer = ui.retrieveUserInput();

    System.out.println("messageToServer: " + messageToServer);

    if (!messageToServer.isEmpty())
    {
      clientMessageHandler.sendMessage(messageToServer);
      String responseMessageFromServer = clientMessageHandler.retrieveMessage();

      System.out.println("responseMessageFromServer: " + responseMessageFromServer);
    }
  }

  public static void main(String[] args) 
  {
    ui = new UI();
    clientMessageHandler = new ClientMessageHandler();

    while (true)
    {
      clientLoop();
    }
  }
}
