import java.util.List;

public class ListAccountsCommand extends Command
{
  public ListAccountsCommand(String outputText, List<String> inputs)
  {
    super(outputText, inputs);
  }

  @Override
  public String execute()
  {
    String messageToBuild = MenuOption.LIST_ACCOUNTS.ordinal() + "=";
    messageToBuild += super.execute();
    return messageToBuild;
  }
}
