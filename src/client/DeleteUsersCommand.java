import java.util.List;

public class DeleteUsersCommand extends Command
{
  public DeleteUsersCommand(String outputText, List<String> inputs)
  {
    super(outputText, inputs);
  }

  @Override
  public String execute()
  {
    String messageToBuild = MenuOption.DELETE_USERS.ordinal() + "=";
    String userInput = "";
    do
    {
      messageToBuild += super.execute();
      System.out.print("Do you want to enter another user? [y/n] ");
      userInput = System.console().readLine();
    }
    while (userInput.equalsIgnoreCase("y"));
    return messageToBuild;
  }
}
