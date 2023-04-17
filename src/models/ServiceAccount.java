package models;
import models.*;


public class ServiceAccount {
    public String phoneNumber;
    public User user;
    public Bundle bundle;

    public ServiceAccount(String phoneNumber, User user, Bundle bundle) {
        this.phoneNumber = phoneNumber;
        this.user = user;
        this.bundle = bundle;
    }

    public void changeBundle(Bundle newBundle) {
        if (null == newBundle) {
            throw new IllegalArgumentException("Cannot change account bundle to invalid value. Nothing done.\n");
            return;
        }
        this.bundle = newBundle;
    }
}
