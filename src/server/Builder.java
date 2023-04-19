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

  public void buildResponse(String message)
  {
    MessageContainer messageContainer = parseMessage(message);

    System.out.println("Message Option: " + messageContainer.menuOption);
    for (String messageContent : messageContainer.messageContents)
    {
      System.out.println("Message Content: " + messageContent);
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
