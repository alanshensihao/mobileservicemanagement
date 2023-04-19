import java.util.List;
import java.util.ArrayList;

public class Builder
{
  public class MessageContainer
  {
    public MenuOption menuOption;
    public List<String> messageContents;

    public MessageContainer()
    {
      this.messageContents = new ArrayList<String>();
    } 
  }

  public Builder()
  {
  }

  public void handleResponse(String message)
  {
    MessageContainer messageContainer = parseMessage(message);

    System.out.println("Message Option: " + messageContainer.menuOption);
    for (String messageContent : messageContainer.messageContents)
    {
      System.out.println("Message Content: " + messageContent);
    }
    handleMessage(messageContainer);
  }

  public void handleMessage(MessageContainer messageContainer)
  {
    switch(messageContainer.menuOption)
    {
      case ADD_USER:
				break;

      case ADD_USERS:
				break;

      case UPDATE_USER:
				break;

      case DELETE_USER:
				break;

      case DELETE_USERS:
				break;

      case ADD_ACCOUNT_V1:
				break;

      case ADD_ACCOUNT_V2:
				break;

      case DELETE_ACCOUNT:
				break;

      case UPDATE_ACCOUNT:
				break;

      case ADD_PRE_BUNDLE:
				break;

      case ADD_PAC_BUNDLE_V1:
				break;

      case ADD_PAC_BUNDLE_V2:
				break;

      case ADD_PAC_BUNDLE_V3:
				break;

      case LIST_USER_DETAILS:
				break;

      case LIST_ALL_USERS:
				break;

      case LIST_ACCOUNT:
				break;

      case LIST_ACCOUNTS:
				break;

      case LIST_MONTHLY_FEES:
				break;

      case LIST_MONTHLY_FEES_ALL:
				break;

      case LIST_BUNDLE_DETAILS:
				break;

      case LIST_ALL_PRE_BUNDLES:
				break;

      case LIST_ALL_PAC_BUNDLES:
				break;

      default:
        System.out.println("Invalid menuOption");
				break;
		}
  }


  // TODO: The messages could be formatted better so the parsing is less error prone
  // Doesn't handle blank entries or entires with ';' currently
  // Likely fine for now, but this area could be improved later if we have time
  private MessageContainer parseMessage(String messageFromClient)
  {
    final int MINIMUM_MESSAGE_SIZE = 3;

    MessageContainer messageContainer = new MessageContainer();
    try
    {
      if (messageFromClient.length() < MINIMUM_MESSAGE_SIZE + 1)
      {
        throw new Exception("Invalid message");
      }

      String messageOption = messageFromClient.substring(0,1);
      MenuOption selectedOption = MenuOption.values()[Integer.parseInt(messageOption)];
      messageContainer.menuOption = selectedOption;

      String message = "";
      message = messageFromClient.substring(2, messageFromClient.length());
      if (!message.isEmpty())
      {
        String[] messageContents = message.split(";");
        for (String messageContent : messageContents)
        {
          messageContainer.messageContents.add(messageContent);
        }
      }
    }
    catch(Exception e)
    {
      System.out.println("Error parsing the message from the client");
    }
    return messageContainer;
  }
}
