import java.util.List;

public class AddPacBundleV3Command extends Command
{
  public AddPacBundleV3Command(String outputText, List<String> inputs)
  {
    super(outputText, inputs);
  }

  @Override
  public String execute()
  {
    String messageToBuild = MenuOption.ADD_PAC_BUNDLE_V3.ordinal() + "=";
    messageToBuild += super.execute();
    return messageToBuild;
  }
}
