public class MDMServer
{
  private static ServerMessageHandler serverMessageHandler;
  private static Builder builder;

  private static UserManagement userManagement;
  private static BundleManagement bundleManagement;
  private static AccountManagement accountManagement;

  private static void serverLoop()
  {
    String messageFromClient = serverMessageHandler.retrieveMessage();

    builder.handleResponse(messageFromClient);

    String messageToClient = "test";
    serverMessageHandler.sendMessage(messageToClient);
    System.out.println("messageToClient: " + messageToClient);
  }

  public static void main(String[] args) 
  {
    serverMessageHandler = new ServerMessageHandler();
    builder = new Builder();

    userManagement = new UserManagement(serverMessageHandler);
    bundleManagement = new BundleManagement(serverMessageHandler);
    accountManagement = new AccountManagement(serverMessageHandler);

    builder.addPropertyChangeListener(userManagement);
    builder.addPropertyChangeListener(bundleManagement);
    builder.addPropertyChangeListener(accountManagement);

    while (true)
    {
      serverLoop();
    }
  }
}
