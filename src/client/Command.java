import java.util.List;

public abstract class Command
{
  public String outputText;
  public List<String> inputs;

  public Command()
  {
  }

  public Command(String outputText, List<String> inputs)
  {
    this.outputText = outputText;
    this.inputs = inputs;
  }

  abstract String execute();
}
