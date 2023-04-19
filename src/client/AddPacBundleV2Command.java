import java.util.List;

public class AddPacBundleV2Command extends Command
{
  public AddPacBundleV2Command(String outputText, List<String> inputs)
  {
    super(outputText, inputs);
  }

  @Override
  public String execute()
  {
    String messageToBuild = MenuOption.ADD_PAC_BUNDLE_V2.ordinal() + "=";
    messageToBuild += super.execute();
    return messageToBuild;
  }
}
