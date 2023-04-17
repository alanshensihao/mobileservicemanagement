package services;
import java.util.*;
import models.ServiceAccount;
import models.Bundle;

public class AccountManagement {

    Map<String, ServiceAccount> accounts = new HashMap<>();

    public void addServiceAccount(ServiceAccount account) {
        if (null == account) {
            throw new IllegalArgumentException("Service account invalid. Nothing added by Account Manager.\n");
            return;
        }
        accounts.put(account.phoneNumber, account);
    }

    public void addServiceAccount(User user, String phoneNumber, Bundle bundle) {
        if (null == user || null == phoneNumber || null == bundle) {
            throw new IllegalArgumentException("Service account details invalid. Nothing added by Account Manager.\n");
        }
        // create account
        ServiceAccount newAccount(user, phoneNumber, bundle);
        accounts.put(phoneNumber, newAccount);
    }

    ServiceAccount getServiceAccount(String phoneNumber) {
        return accounts.get(phoneNumber);
    }

    void updateServiceAccount(String phoneNumber, Bundle newBundle) {
        ServiceAccount account = accounts.get(phoneNumber);
        if (account != null) {
            account.changeBundle(newBundle);
        }
    }

    void deleteServiceAccount(String phoneNumber) {
        String storeName = account.get(phoneNumber).getName();
        int nameOccurence = 0;
        for (Map.entry<String, ServiceAccount> entry : accounts.entrySet()) {
            if (storeName == entry.getValue().getName()) {
                nameOccurence += 1;
            }
        }
        accounts.remove(phoneNumber);
        if (nameOccurence == 0) {
            // user manager to delete user
            return;
        }
    }
}
