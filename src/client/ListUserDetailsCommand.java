import java.util.List;

public class ListUserDetailsCommand extends Command
{
  public ListUserDetailsCommand(String outputText, List<String> inputs)
  {
    super(outputText, inputs);
  }

  @Override
  public String execute()
  {
    String messageToBuild = MenuOption.LIST_USER_DETAILS.ordinal() + "=";
    messageToBuild += super.execute();
    return messageToBuild;
  }
}
