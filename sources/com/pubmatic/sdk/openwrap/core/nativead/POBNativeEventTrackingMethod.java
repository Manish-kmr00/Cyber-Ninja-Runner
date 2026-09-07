package com.pubmatic.sdk.openwrap.core.nativead;

/* JADX INFO: loaded from: classes11.dex */
public enum POBNativeEventTrackingMethod {
    IMAGE(1),
    JAVASCRIPT(2);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f7756a;

    POBNativeEventTrackingMethod(int i) {
        this.f7756a = i;
    }

    public static POBNativeEventTrackingMethod getEventTrackingMethod(int i) {
        if (i == 1) {
            return IMAGE;
        }
        if (i != 2) {
            return null;
        }
        return JAVASCRIPT;
    }

    public int getEventEventTrackingMethodValue() {
        return this.f7756a;
    }
}
