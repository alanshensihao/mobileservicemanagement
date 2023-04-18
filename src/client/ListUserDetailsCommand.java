import java.util.List;

public class ListUserDetailsCommand extends Command
{
  public ListUserDetailsCommand(String outputText, List<String> inputs)
  {
    super(outputText, inputs);
  }

  @Override
  String execute()
  {
    return "";
  }
}
