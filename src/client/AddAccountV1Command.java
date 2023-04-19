import java.util.List;

public class AddAccountV1Command extends Command
{
  public AddAccountV1Command(String outputText, List<String> inputs)
  {
    super(outputText, inputs);
  }

  @Override
  public String execute()
  {
    String messageToBuild = MenuOption.ADD_ACCOUNT_V1.ordinal() + "=";
    messageToBuild += super.execute();
    return messageToBuild;
  }
}
