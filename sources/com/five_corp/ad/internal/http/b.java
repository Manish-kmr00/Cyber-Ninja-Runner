package com.five_corp.ad.internal.http;

import com.pubmatic.sdk.omsdk.POBOMSDKLogConstants;

/* JADX INFO: loaded from: classes7.dex */
public abstract /* synthetic */ class b {
    public static /* synthetic */ int a(int i) {
        int i2 = 1;
        if (i != 1) {
            i2 = 2;
            if (i != 2) {
                if (i == 3) {
                    return 3;
                }
                throw null;
            }
        }
        return i2;
    }

    public static /* synthetic */ String b(int i) {
        if (i == 1) {
            return "DEFAULT";
        }
        if (i == 2) {
            return POBOMSDKLogConstants.MSG_OMSDK_LOADED_EVENT;
        }
        if (i == 3) {
            return "PLAYING";
        }
        throw null;
    }
}
