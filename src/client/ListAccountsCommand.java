import java.util.List;

public class ListAccountsCommand extends Command
{
  public ListAccountsCommand(String outputText, List<String> inputs)
  {
    super(outputText, inputs);
  }

  @Override
  String execute()
  {
    return "";
  }
}
