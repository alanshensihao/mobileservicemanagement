import java.util.List;

public class AddPacBundleV1Command extends Command
{
  public AddPacBundleV1Command(String outputText, List<String> inputs)
  {
    super(outputText, inputs);
  }

  @Override
  public String execute()
  {
    String messageToBuild = MenuOption.ADD_PAC_BUNDLE_V1.ordinal() + "=";
    messageToBuild += super.execute();
    return messageToBuild;
  }
}
