package com.smaato.sdk.core.locationaware;

import android.content.Context;
import android.telephony.TelephonyManager;

/* JADX INFO: loaded from: classes13.dex */
public class SimInfoImpl implements SimInfo {
    private final TelephonyManager tm;

    SimInfoImpl(Context context) {
        this.tm = (TelephonyManager) context.getSystemService("phone");
    }

    @Override // com.smaato.sdk.core.locationaware.SimInfo
    public String getSimCountryIso() {
        return this.tm.getSimCountryIso();
    }

    @Override // com.smaato.sdk.core.locationaware.SimInfo
    public String getNetworkCountryIso() {
        return this.tm.getNetworkCountryIso();
    }
}
