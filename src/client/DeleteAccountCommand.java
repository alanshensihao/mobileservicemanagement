import java.util.List;

public class DeleteAccountCommand extends Command
{
  public DeleteAccountCommand(String outputText, List<String> inputs)
  {
    super(outputText, inputs);
  }

  @Override
  public String execute()
  {
    String messageToBuild = MenuOption.DELETE_ACCOUNT.ordinal() + "=";
    messageToBuild += super.execute();
    return messageToBuild;
  }
}
