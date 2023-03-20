package services;
import java.util.*;
import models.ServiceAccount;
import models.Bundle;
public class AccountManagement {

    Map<String, ServiceAccount> accounts = new HashMap<>();

    public void addServiceAccount(ServiceAccount account) {
        accounts.put(account.phoneNumber, account);
    }

    ServiceAccount getServiceAccount(String phoneNumber) {
        return accounts.get(phoneNumber);
    }

    void updateServiceAccount(String phoneNumber, Bundle newBundle) {
        ServiceAccount account = accounts.get(phoneNumber);
        if (account != null) {
            account.bundle = newBundle;
        }
    }

    void deleteServiceAccount(String phoneNumber) {
        accounts.remove(phoneNumber);
    }
}
