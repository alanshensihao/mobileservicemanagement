import java.util.List;

public class AddPreBundleCommand extends Command
{
  public AddPreBundleCommand(String outputText, List<String> inputs)
  {
    super(outputText, inputs);
  }

  @Override
  public String execute()
  {
    String messageToBuild = MenuOption.ADD_PRE_BUNDLE.ordinal() + "=";
    messageToBuild += super.execute();
    return messageToBuild;
  }
}
