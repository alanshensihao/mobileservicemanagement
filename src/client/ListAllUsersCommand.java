import java.util.List;

public class ListAllUsersCommand extends Command
{
  public ListAllUsersCommand(String outputText, List<String> inputs)
  {
    super(outputText, inputs);
  }

  @Override
  public String execute()
  {
    String messageToBuild = MenuOption.LIST_ALL_USERS.ordinal() + "=";
    messageToBuild += super.execute();
    return messageToBuild;
  }
}
