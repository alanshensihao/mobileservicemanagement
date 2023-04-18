import java.util.List;

public class AddUserCommand extends Command
{
  public AddUserCommand(String outputText, List<String> inputs)
  {
    super(outputText, inputs);
  }

  @Override
  String execute()
  {
    return "";
  }
}
