package com.pubmatic.sdk.openwrap.core.nativead;

/* JADX INFO: loaded from: classes12.dex */
public enum POBNativeContextType {
    CONTENT_CENTRIC(1),
    SOCIAL_CENTRIC(2),
    PRODUCT(3),
    EXCHANGE(500);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f7754a;

    POBNativeContextType(int i) {
        this.f7754a = i;
    }

    public int getValue() {
        return this.f7754a;
    }
}
