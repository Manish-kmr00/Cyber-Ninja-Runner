package com.five_corp.ad;

import com.pubmatic.sdk.omsdk.POBOMSDKLogConstants;

/* JADX INFO: loaded from: classes12.dex */
public abstract /* synthetic */ class d {
    public static /* synthetic */ String a(int i) {
        if (i == 1) {
            return POBOMSDKLogConstants.MSG_OMSDK_LOADED_EVENT;
        }
        if (i == 2) {
            return "CLOSED";
        }
        if (i == 3) {
            return "ERROR";
        }
        throw null;
    }
}
