package com.unisys.fairylights.springbootfairylights.util;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class Alerts {

    private static final String BUNDLE_NAME = "alerts";

    private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

    private Alerts() {
    }

    public static String getString(String description) {
        try {
            return RESOURCE_BUNDLE.getString(description);
        } catch (MissingResourceException e) {
            return description;
        }
    }
}
