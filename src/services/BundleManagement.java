package services;
import java.util.*;
import models.Bundle;
public class BundleManagement {
    Map<String, Bundle> bundles = new HashMap<>();

    public void addBundle(Bundle bundle) {
        bundles.put(bundle.name, bundle);
    }

    Bundle getBundle(String name) {
        return bundles.get(name);
    }
}
