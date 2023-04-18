import java.util.List;

public class DeleteUserCommand extends Command
{
  public DeleteUserCommand(String outputText, List<String> inputs)
  {
    super(outputText, inputs);
  }

  @Override
  String execute()
  {
    return "";
  }
}
