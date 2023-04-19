import java.util.List;

public class AddAccountV2Command extends Command
{
  public AddAccountV2Command(String outputText, List<String> inputs)
  {
    super(outputText, inputs);
  }

  @Override
  public String execute()
  {
    String messageToBuild = MenuOption.ADD_ACCOUNT_V2.ordinal() + "=";
    messageToBuild += super.execute();
    return messageToBuild;
  }
}
