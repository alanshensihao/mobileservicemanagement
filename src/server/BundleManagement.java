import java.util.*;

public class BundleManagement
{
  Map<String, Bundle> bundles = new HashMap<>();

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
