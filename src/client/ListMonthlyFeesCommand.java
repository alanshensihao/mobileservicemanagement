import java.util.List;

public class ListMonthlyFeesCommand extends Command
{
  public ListMonthlyFeesCommand(String outputText, List<String> inputs)
  {
    super(outputText, inputs);
  }

  @Override
  public String execute()
  {
    String messageToBuild = MenuOption.LIST_MONTHLY_FEES.ordinal() + "=";
    messageToBuild += super.execute();
    return messageToBuild;
  }
}
