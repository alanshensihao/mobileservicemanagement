import java.util.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class BundleManagement implements PropertyChangeListener
{
  Map<String, Bundle> bundles = new HashMap<>();
  private MessageContainer messageContainer;

  ServerMessageHandler serverMessageHandler;

  public BundleManagement(ServerMessageHandler msgHandler)
  {
    this.serverMessageHandler = msgHandler;
  }

  public void propertyChange(PropertyChangeEvent evt)
  {
    this.messageContainer = (MessageContainer)evt.getNewValue();
    this.performRequestedTask();
  }

  public void performRequestedTask()
  {
    // case wise handling of message passed down by server
    switch(messageContainer.menuOption)
    {
      case ADD_PRE_BUNDLE:
        break;

      case ADD_PAC_BUNDLE_V1:
        break;

      case ADD_PAC_BUNDLE_V2:
        break;

      case ADD_PAC_BUNDLE_V3:
        break;

      case LIST_MONTHLY_FEES:
        break;

      case LIST_MONTHLY_FEES_ALL:
        break;

      case LIST_BUNDLE_DETAILS:
        break;

      case LIST_ALL_PRE_BUNDLES:
        break;

      case LIST_ALL_PAC_BUNDLES:
        break;

      default:
        System.out.println("Nothing to be done by Bundle Manager.\n");
        break;
    }
  }

  // should be able to handle both preconfig and PaC bundle types
  public void addBundle(Bundle bundle)
  {
    bundles.put(bundle.name, bundle);
  }

  public void addPaCWithCalling(String callingPlan)
  {
    Bundle newBundle = new Bundle("Pick and Choose");
    newBundle.setPaCCallingOption(callingPlan);
    this.addBundle(newBundle);
  }

  public void addPaCWithMessaging(String messagingPlan)
  {
    Bundle newBundle = new Bundle("Pick and Choose");
    newBundle.setPaCMessagingOption(messagingPlan);
    this.addBundle(newBundle);
  }

  Bundle getBundle(String name)
  {
    return bundles.get(name);
  }
}
