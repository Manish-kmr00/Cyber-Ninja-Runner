package com.pubmatic.sdk.openwrap.core.nativead;

/* JADX INFO: loaded from: classes7.dex */
public enum POBNativeImageAssetType {
    ICON(1),
    MAIN(3);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f7758a;

    POBNativeImageAssetType(int i) {
        this.f7758a = i;
    }

    public static POBNativeImageAssetType getImageAssetType(int i) {
        if (i == 1) {
            return ICON;
        }
        if (i != 3) {
            return null;
        }
        return MAIN;
    }

    public int getImageAssetTypeValue() {
        return this.f7758a;
    }
}
