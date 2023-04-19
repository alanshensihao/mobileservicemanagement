public class MDMServer
{
  private static ServerMessageHandler serverMessageHandler;

  private static UserManagement userManagement;
  private static BundleManagement bundleManagement;
  private static AccountManagement accountManagement;

  private static void serverLoop()
  {
    String messageFromClient = serverMessageHandler.retrieveMessage();
    System.out.println("messageFromClient: " + messageFromClient);

    parseMessage(messageFromClient);

    String messageToClient = "test";
    serverMessageHandler.sendMessage(messageToClient);
    System.out.println("messageToClient: " + messageToClient);
  }

  private static void parseMessage(String messageFromClient)
  {
    final int MINIMUM_MESSAGE_SIZE = 2;
    try
    {
      if (messageFromClient.length() < MINIMUM_MESSAGE_SIZE + 1)
      {
        throw new Exception("Invalid message");
      }

      String messageOption = messageFromClient.substring(0,1);
      String message = "";
      message = messageFromClient.substring(2, messageFromClient.length());
      if (!message.isEmpty())
      {
        String[] messageContents = message.split(";");
        for (String messageContent : messageContents)
        {
          System.out.println(messageContent);
        }
      }

      MenuOption selectedOption = MenuOption.values()[Integer.parseInt(messageOption)];
    }
    catch(Exception e)
    {
      System.out.println("Error parsing the message from the client");
    }
  }


  public static void main(String[] args) 
  {
    serverMessageHandler = new ServerMessageHandler();

    userManagement = new UserManagement();
    bundleManagement = new BundleManagement();
    accountManagement = new AccountManagement();

    while (true)
    {
      serverLoop();
    }
  }
}
