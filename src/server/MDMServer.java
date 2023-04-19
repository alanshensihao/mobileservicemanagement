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

    String messageToClient = "test";
    serverMessageHandler.sendMessage(messageToClient);
    System.out.println("messageToClient: " + messageToClient);
  }

  public static void main(String args[])
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
