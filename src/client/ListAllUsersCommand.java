import java.util.List;

public class ListAllUsersCommand extends Command
{
  public ListAllUsersCommand(String outputText, List<String> inputs)
  {
    super(outputText, inputs);
  }

  @Override
  String execute()
  {
    return "";
  }
}
