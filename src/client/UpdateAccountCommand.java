import java.util.List;

public class UpdateAccountCommand extends Command
{
  public UpdateAccountCommand(String outputText, List<String> inputs)
  {
    super(outputText, inputs);
  }

  @Override
  public String execute()
  {
    String messageToBuild = MenuOption.UPDATE_ACCOUNT.ordinal() + "=";
    messageToBuild += super.execute();
    return messageToBuild;
  }
}
