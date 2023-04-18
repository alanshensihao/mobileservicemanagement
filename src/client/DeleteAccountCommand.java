import java.util.List;

public class DeleteAccountCommand extends Command
{
  public DeleteAccountCommand(String outputText, List<String> inputs)
  {
    super(outputText, inputs);
  }

  @Override
  String execute()
  {
    return "";
  }
}
