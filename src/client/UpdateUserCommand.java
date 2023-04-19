import java.util.List;

public class UpdateUserCommand extends Command
{
  public UpdateUserCommand(String outputText, List<String> inputs)
  {
    super(outputText, inputs);
  }

  @Override
  public String execute()
  {
    String messageToBuild = MenuOption.UPDATE_USER.ordinal() + "=";
    messageToBuild += super.execute();
    return messageToBuild;
  }
}
