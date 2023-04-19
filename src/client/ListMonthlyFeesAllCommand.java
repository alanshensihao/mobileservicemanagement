import java.util.List;

public class ListMonthlyFeesAllCommand extends Command
{
  public ListMonthlyFeesAllCommand(String outputText, List<String> inputs)
  {
    super(outputText, inputs);
  }

  @Override
  public String execute()
  {
    String messageToBuild = MenuOption.LIST_MONTHLY_FEES_ALL.ordinal() + "=";
    messageToBuild += super.execute();
    return messageToBuild;
  }
}
