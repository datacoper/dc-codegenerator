package com.datacoper.maven.mojos;

import java.util.Optional;

public abstract class MojoConstants {
    public static final String PROPERTY_NOT_INFORMED = "void";
    public static final String STOP_INFORMATION_PARAMS = "Q";

    private MojoConstants() {
    }

    public static final boolean isPropertyNotInformed(String value) {
        return PROPERTY_NOT_INFORMED.equalsIgnoreCase(value);
    }

    public static final boolean isStopInformationParams(String value) {
        return STOP_INFORMATION_PARAMS.equalsIgnoreCase(value);
    }

    public static final boolean isStopInformationParams(Optional<String> value) {
        return value.isPresent() && STOP_INFORMATION_PARAMS.equalsIgnoreCase(value.get());
    }
}
