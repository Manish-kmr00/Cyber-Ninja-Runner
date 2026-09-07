package com.pubmatic.sdk.openwrap.core.nativead;

/* JADX INFO: loaded from: classes9.dex */
public enum POBNativeContextSubType {
    GENERAL(10),
    ARTICLE(11),
    VIDEO(12),
    AUDIO(13),
    IMAGE(14),
    USER_GENERATED(15),
    SOCIAL(20),
    EMAIL(21),
    CHAT_IM(22),
    SELLING_PRODUCTS(30),
    MARKETPLACE(31),
    PRODUCT_REVIEW_SITE(32),
    EXCHANGE(500);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f7753a;

    POBNativeContextSubType(int i) {
        this.f7753a = i;
    }

    public int getValue() {
        return this.f7753a;
    }
}
