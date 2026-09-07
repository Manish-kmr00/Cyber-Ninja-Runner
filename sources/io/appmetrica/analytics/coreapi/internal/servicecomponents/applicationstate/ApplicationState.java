package io.appmetrica.analytics.coreapi.internal.servicecomponents.applicationstate;

import io.appmetrica.analytics.impl.J2;
import io.bidmachine.iab.vast.tags.VastAttributes;

/* JADX INFO: loaded from: classes12.dex */
public enum ApplicationState {
    UNKNOWN("unknown"),
    BACKGROUND(J2.g),
    VISIBLE(VastAttributes.VISIBLE);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f10974a;

    ApplicationState(String str) {
        this.f10974a = str;
    }

    public static ApplicationState fromString(String str) {
        ApplicationState applicationState = UNKNOWN;
        for (ApplicationState applicationState2 : values()) {
            if (applicationState2.f10974a.equals(str)) {
                return applicationState2;
            }
        }
        return applicationState;
    }

    public String getStringValue() {
        return this.f10974a;
    }
}
