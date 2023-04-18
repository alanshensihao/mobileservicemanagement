import java.util.Map;
import java.util.TreeMap;
import java.util.Arrays;

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
    System.out.println("---------- Please enter a menu option ----------");
    for (Map.Entry<MenuOption, Command> mapEntry : uiMap.entrySet())
    {
      System.out.print(mapEntry.getKey().ordinal() + 1 + ". ");
      System.out.print(mapEntry.getValue().outputText + " ");

      if (!(mapEntry.getValue().inputs.size() == 1 && mapEntry.getValue().inputs.get(0).isEmpty()))
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

  // TODO: Is USER and USERNAME different?
  // TODO: Is PHONE and PHONE NUMBER different?
  // TODO: Is ACCOUNT an ID?
  // TODO: What user information to store? Currently only the username
  private Command buildCommand(MenuOption menuOption)
  {
    Command newCommand = new Command();
    switch(menuOption)
    {
      case ADD_USER:
        newCommand.outputText = "Add User";
        newCommand.inputs = Arrays.asList("Username", "...");
        break;
      case ADD_USERS:
        newCommand.outputText = "Add Users";
        newCommand.inputs = Arrays.asList("Username", "...");
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
        newCommand.inputs = Arrays.asList("");
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
        newCommand.inputs = Arrays.asList("");
        break;
      case LIST_ALL_PAC_BUNDLES:
        newCommand.outputText = "List All PaC Bundle Names";
        newCommand.inputs = Arrays.asList("");
        break;
      default:
        System.out.println("Invalid menuOption");
        break;
    }
    return newCommand;
  }
}
