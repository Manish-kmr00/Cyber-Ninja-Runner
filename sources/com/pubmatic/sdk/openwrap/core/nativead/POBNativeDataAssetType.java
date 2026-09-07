package com.pubmatic.sdk.openwrap.core.nativead;

/* JADX INFO: loaded from: classes11.dex */
public enum POBNativeDataAssetType {
    SPONSORED(1),
    DESCRIPTION(2),
    RATING(3),
    LIKES(4),
    DOWNLOADS(5),
    PRICE(6),
    SALESPRICE(7),
    PHONE(8),
    ADDRESS(9),
    DESCRIPTION2(10),
    DISPLAY_URL(11),
    CTA_TEXT(12);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f7755a;

    POBNativeDataAssetType(int i) {
        this.f7755a = i;
    }

    public static POBNativeDataAssetType getDataAssetType(int i) {
        switch (i) {
            case 1:
                return SPONSORED;
            case 2:
                return DESCRIPTION;
            case 3:
                return RATING;
            case 4:
                return LIKES;
            case 5:
                return DOWNLOADS;
            case 6:
                return PRICE;
            case 7:
                return SALESPRICE;
            case 8:
                return PHONE;
            case 9:
                return ADDRESS;
            case 10:
                return DESCRIPTION2;
            case 11:
                return DISPLAY_URL;
            case 12:
                return CTA_TEXT;
            default:
                return null;
        }
    }

    public int getDataAssetTypeValue() {
        return this.f7755a;
    }
}
