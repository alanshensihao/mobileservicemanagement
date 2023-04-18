import java.util.HashMap;
import java.util.Map;

public class AccountManagement
{
  Map<String, ServiceAccount> accounts = new HashMap<>();

  public void addServiceAccount(ServiceAccount account)
  {
    if (null == account)
    {
      throw new IllegalArgumentException("Service account invalid. Nothing added by Account Manager.\n");
    }
    accounts.put(account.phoneNumber, account);
  }

  public void addServiceAccount(User user, String phoneNumber, Bundle bundle)
  {
    if (null == user || null == phoneNumber || null == bundle)
    {
      throw new IllegalArgumentException("Service account details invalid. Nothing added by Account Manager.\n");
    }

    // create account
    ServiceAccount newAccount = new ServiceAccount(phoneNumber, user, bundle);
    accounts.put(phoneNumber, newAccount);
  }

  ServiceAccount getServiceAccount(String phoneNumber)
  {
    return accounts.get(phoneNumber);
  }

  void updateServiceAccount(String phoneNumber, Bundle newBundle)
  {
    ServiceAccount account = accounts.get(phoneNumber);

    if (account != null)
    {
      account.changeBundle(newBundle);
    }
  }

  void deleteServiceAccount(String phoneNumber)
  {
    accounts.remove(phoneNumber);
  }
}
