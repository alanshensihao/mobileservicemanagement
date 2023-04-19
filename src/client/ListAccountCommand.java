import java.util.List;

public class ListAccountCommand extends Command
{
  public ListAccountCommand(String outputText, List<String> inputs)
  {
    super(outputText, inputs);
  }

  @Override
  public String execute()
  {
    String messageToBuild = MenuOption.LIST_ACCOUNT.ordinal() + "=";
    messageToBuild += super.execute();
    return messageToBuild;
  }
}
