package com.pubmatic.sdk.nativead;

import com.pubmatic.sdk.openwrap.core.nativead.POBNativeContextSubType;
import com.pubmatic.sdk.openwrap.core.nativead.POBNativeContextType;
import com.pubmatic.sdk.openwrap.core.nativead.POBNativePlacementType;

/* JADX INFO: loaded from: classes13.dex */
public class POBNativeAdLoaderConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private POBNativeContextType f7684a = null;
    private POBNativeContextSubType b = null;
    private POBNativePlacementType c = null;

    public POBNativeContextSubType getContextSubType() {
        return this.b;
    }

    public POBNativeContextType getContextType() {
        return this.f7684a;
    }

    public POBNativePlacementType getPlacementType() {
        return this.c;
    }

    public void setContextSubType(POBNativeContextSubType pOBNativeContextSubType) {
        this.b = pOBNativeContextSubType;
    }

    public void setContextType(POBNativeContextType pOBNativeContextType) {
        this.f7684a = pOBNativeContextType;
    }

    public void setPlacementType(POBNativePlacementType pOBNativePlacementType) {
        this.c = pOBNativePlacementType;
    }
}
