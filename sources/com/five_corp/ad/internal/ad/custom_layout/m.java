package com.five_corp.ad.internal.ad.custom_layout;

import com.pubmatic.sdk.omsdk.POBOMSDKLogConstants;

/* JADX INFO: loaded from: classes8.dex */
public abstract /* synthetic */ class m {
    public static /* synthetic */ String a(int i) {
        if (i == 1) {
            return "CENTER";
        }
        if (i != 2) {
            return i != 3 ? "null" : "END";
        }
        return POBOMSDKLogConstants.MSG_OMSDK_START_EVENT;
    }
}
