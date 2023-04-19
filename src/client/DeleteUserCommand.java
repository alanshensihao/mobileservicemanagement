import java.util.List;

public class DeleteUserCommand extends Command
{
  public DeleteUserCommand(String outputText, List<String> inputs)
  {
    super(outputText, inputs);
  }

  @Override
  public String execute()
  {
    String messageToBuild = MenuOption.DELETE_USER.ordinal() + "=";
    messageToBuild += super.execute();
    return messageToBuild;
  }
}
