import java.util.List;

public class ListBundleDetailsCommand extends Command
{
  public ListBundleDetailsCommand(String outputText, List<String> inputs)
  {
    super(outputText, inputs);
  }

  @Override
  public String execute()
  {
    String messageToBuild = MenuOption.LIST_BUNDLE_DETAILS.ordinal() + "=";
    messageToBuild += super.execute();
    return messageToBuild;
  }
}
