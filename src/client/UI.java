import java.util.Map;
import java.util.TreeMap;
import java.util.Arrays;
import java.util.ArrayList;

enum MenuOption
{
  ADD_USER, 
  ADD_USERS,
  UPDATE_USER,
  DELETE_USER,
  DELETE_USERS,
  ADD_ACCOUNT_V1,
  ADD_ACCOUNT_V2,
  DELETE_ACCOUNT,
  UPDATE_ACCOUNT,
  ADD_PRE_BUNDLE,
  ADD_PAC_BUNDLE_V1,
  ADD_PAC_BUNDLE_V2,
  ADD_PAC_BUNDLE_V3,
  LIST_USER_DETAILS,
  LIST_ALL_USERS,
  LIST_ACCOUNT,
  LIST_ACCOUNTS,
  LIST_MONTHLY_FEES,
  LIST_MONTHLY_FEES_ALL,
  LIST_BUNDLE_DETAILS,
  LIST_ALL_PRE_BUNDLES,
  LIST_ALL_PAC_BUNDLES
}

class UI
{
  public final Map<MenuOption, Command> uiMap = createMap();

  public void printUI()
  {
    System.out.println();
    System.out.println("========== Please Enter A Menu Option ==========");
    for (Map.Entry<MenuOption, Command> mapEntry : uiMap.entrySet())
    {
      System.out.print(mapEntry.getKey().ordinal() + 1 + ". ");
      System.out.print(mapEntry.getValue().outputText + " ");

      if (mapEntry.getValue().inputs.size() != 0)
      {
        System.out.print("<");
        for (int i = 0; i < mapEntry.getValue().inputs.size(); ++i)
        {
          System.out.print(mapEntry.getValue().inputs.get(i));
          if (i != mapEntry.getValue().inputs.size() - 1)
          {
            System.out.print(", ");
          }
        }
        System.out.print(">");
      }
      System.out.println();
    }
  }

  public String retrieveUserInput()
  {
    final int lastMenuVal = MenuOption.values()[MenuOption.values().length - 1].ordinal() + 1;
    System.out.print(" > ");
    String userInput = System.console().readLine();
    String messageToServer = "";

    if (userInput.equalsIgnoreCase("q") || userInput.equalsIgnoreCase("quit") || userInput.equalsIgnoreCase("exit"))
    {
      System.exit(0);
    }

    try
    {
      int menuOption = Integer.parseInt(userInput);

      if (menuOption > 0 && menuOption < (lastMenuVal + 1))
      {
        messageToServer = userInput;
      }
      else
      {
        throw new Exception("Invalid number");
      }
    }
    catch (Exception e)
    {
      System.out.println("Error: Number expected between 1 and " + lastMenuVal);
    }
    return messageToServer;
  }

  private Map<MenuOption, Command> createMap()
  {
    Map<MenuOption, Command> newMap = new TreeMap<MenuOption, Command>();
    for (MenuOption menuOption : MenuOption.values())
    {
      Command newCommand = buildCommand(menuOption);
      newMap.put(menuOption, newCommand);
    }
    return newMap;
  }

  private Command buildCommand(MenuOption menuOption)
  {
    Command newCommand = new Command();
    switch(menuOption)
    {
      case ADD_USER:
        newCommand.outputText = "Add User";
        newCommand.inputs = Arrays.asList("First Name", "Last Name", "Phone Number", "Address", "Email Address");
        break;
      case ADD_USERS:
        newCommand.outputText = "Add Users";
        newCommand.inputs = Arrays.asList("First Name", "Last Name", "Phone Number", "Address", "Email Address", "...");
        newCommand.allowMultiple = true;
        break;
      case UPDATE_USER:
        newCommand.outputText = "Update User";
        newCommand.inputs = Arrays.asList("Username");
        break;
      case DELETE_USER:
        newCommand.outputText = "Delete User";
        newCommand.inputs = Arrays.asList("Username");
        break;
      case DELETE_USERS:
        newCommand.outputText = "Delete Users";
        newCommand.inputs = Arrays.asList("Username", "...");
        newCommand.allowMultiple = true;
        break;
      case ADD_ACCOUNT_V1:
        newCommand.outputText = "Add Account";
        newCommand.inputs = Arrays.asList("Phone", "Username", "Bundle");
        break;
      case ADD_ACCOUNT_V2:
        newCommand.outputText = "Add Account";
        newCommand.inputs = Arrays.asList("Account");
        break;
      case DELETE_ACCOUNT:
        newCommand.outputText = "Delete Account";
        newCommand.inputs = Arrays.asList("Phone");
        break;
      case UPDATE_ACCOUNT:
        newCommand.outputText = "Update Account";
        newCommand.inputs = Arrays.asList("Phone", "Bundle");
        break;
      case ADD_PRE_BUNDLE:
        newCommand.outputText = "Add Preconfigured Bundle";
        newCommand.inputs = Arrays.asList("Bundle Name");
        break;
      case ADD_PAC_BUNDLE_V1:
        newCommand.outputText = "Add PaC Bundle";
        newCommand.inputs = Arrays.asList("Bundle Name");
        break;
      case ADD_PAC_BUNDLE_V2:
        newCommand.outputText = "Add PaC Bundle with Calling Option";
        newCommand.inputs = Arrays.asList("Calling Plan Name");
        break;
      case ADD_PAC_BUNDLE_V3:
        newCommand.outputText = "Add PaC Bundle with Messaging Option";
        newCommand.inputs = Arrays.asList("Messaging Plan Name");
        break;
      case LIST_USER_DETAILS:
        newCommand.outputText = "List User Details";
        newCommand.inputs = Arrays.asList("Username");
        break;
      case LIST_ALL_USERS:
        newCommand.outputText = "List All Users' Names";
        newCommand.inputs = new ArrayList<String>();
        break;
      case LIST_ACCOUNT:
        newCommand.outputText = "List Account";
        newCommand.inputs = Arrays.asList("Phone Number");
        break;
      case LIST_ACCOUNTS:
        newCommand.outputText = "List Accounts";
        newCommand.inputs = Arrays.asList("Username");
        break;
      case LIST_MONTHLY_FEES:
        newCommand.outputText = "List Monthly Fees";
        newCommand.inputs = Arrays.asList("Phone Number");
        break;
      case LIST_MONTHLY_FEES_ALL:
        newCommand.outputText = "List Monthly Fees All Accounts";
        newCommand.inputs = Arrays.asList("Username");
        break;
      case LIST_BUNDLE_DETAILS:
        newCommand.outputText = "List Bundle Details";
        newCommand.inputs = Arrays.asList("Bundle Name");
        break;
      case LIST_ALL_PRE_BUNDLES:
        newCommand.outputText = "List All Preconfigured Bundle Names";
        newCommand.inputs = new ArrayList<String>();
        break;
      case LIST_ALL_PAC_BUNDLES:
        newCommand.outputText = "List All PaC Bundle Names";
        newCommand.inputs = new ArrayList<String>();
        break;
      default:
        System.out.println("Invalid menuOption");
        break;
    }
    return newCommand;
  }
}
