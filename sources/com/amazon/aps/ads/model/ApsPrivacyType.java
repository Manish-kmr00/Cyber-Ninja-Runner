package com.amazon.aps.ads.model;

import com.amazon.device.ads.DtbConstants;
import com.pubmatic.sdk.openwrap.core.POBConstants;

/* JADX INFO: loaded from: classes6.dex */
public enum ApsPrivacyType {
    IAB_CCPA_US_PRIVACY("us_privacy"),
    IAB_CCPA_APS_PRIVACY(DtbConstants.APS_ADMOB_CONST_CCPA_APS_PRIVACY),
    DSA_PRIVACY(POBConstants.KEY_DSA);

    private String strApsPrivacyType;

    ApsPrivacyType(String str) {
        this.strApsPrivacyType = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.strApsPrivacyType;
    }
}
