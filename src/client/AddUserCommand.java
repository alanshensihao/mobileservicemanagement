import java.util.List;

public class AddUserCommand extends Command
{
  public AddUserCommand(String outputText, List<String> inputs)
  {
    super(outputText, inputs);
  }

  @Override
  public String execute()
  {
    String messageToBuild = MenuOption.ADD_USER.ordinal() + "=";
    messageToBuild += super.execute();
    return messageToBuild;
  }
}
