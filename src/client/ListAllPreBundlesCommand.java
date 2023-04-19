import java.util.List;

public class ListAllPreBundlesCommand extends Command
{
  public ListAllPreBundlesCommand(String outputText, List<String> inputs)
  {
    super(outputText, inputs);
  }

  @Override
  public String execute()
  {
    String messageToBuild = MenuOption.LIST_ALL_PRE_BUNDLES.ordinal() + "=";
    messageToBuild += super.execute();
    return messageToBuild;
  }
}
