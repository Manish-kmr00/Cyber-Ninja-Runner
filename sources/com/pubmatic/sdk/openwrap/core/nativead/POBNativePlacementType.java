package com.pubmatic.sdk.openwrap.core.nativead;

/* JADX INFO: loaded from: classes14.dex */
public enum POBNativePlacementType {
    FEED(1),
    ATOMIC(2),
    OUTSIDE_CORE_CONTENT(3),
    BELOW_ARTICLE(4),
    EXCHANGE(500);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f7759a;

    POBNativePlacementType(int i) {
        this.f7759a = i;
    }

    public int getValue() {
        return this.f7759a;
    }
}
