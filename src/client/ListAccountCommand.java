import java.util.List;

public class ListAccountCommand extends Command
{
  public ListAccountCommand(String outputText, List<String> inputs)
  {
    super(outputText, inputs);
  }

  @Override
  String execute()
  {
    return "";
  }
}
