package models;

public class ServiceAccount {
    public String phoneNumber;
    public User user;
    public Bundle bundle;

    public ServiceAccount(String phoneNumber, User user, Bundle bundle) {
        this.phoneNumber = phoneNumber;
        this.user = user;
        this.bundle = bundle;
    }
}
