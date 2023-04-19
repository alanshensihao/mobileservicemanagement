import java.util.List;

public class ListAllPacBundlesCommand extends Command
{
  public ListAllPacBundlesCommand(String outputText, List<String> inputs)
  {
    super(outputText, inputs);
  }

  @Override
  public String execute()
  {
    String messageToBuild = MenuOption.LIST_ALL_PAC_BUNDLES.ordinal() + "=";
    messageToBuild += super.execute();
    return messageToBuild;
  }
}
