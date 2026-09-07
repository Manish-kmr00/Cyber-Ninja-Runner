package com.pubmatic.sdk.openwrap.core.nativead;

/* JADX INFO: loaded from: classes9.dex */
public enum POBNativeEventType {
    IMPRESSION(1),
    VIEWABLE_MRC50(2),
    VIEWABLE_MRC100(3),
    VIEWABLE_VIDEO_MRC50(4),
    OMID(555);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f7757a;

    POBNativeEventType(int i) {
        this.f7757a = i;
    }

    public static POBNativeEventType getEventType(int i) {
        if (i == 555) {
            return OMID;
        }
        if (i == 1) {
            return IMPRESSION;
        }
        if (i == 2) {
            return VIEWABLE_MRC50;
        }
        if (i == 3) {
            return VIEWABLE_MRC100;
        }
        if (i != 4) {
            return null;
        }
        return VIEWABLE_VIDEO_MRC50;
    }

    public int getEventTypeValue() {
        return this.f7757a;
    }
}
