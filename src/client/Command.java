import java.util.List;

public class Command
{
  public String outputText;
  public List<String> inputs;
  public boolean allowMultiple;

  public Command()
  {
    allowMultiple = false;
  }
}
