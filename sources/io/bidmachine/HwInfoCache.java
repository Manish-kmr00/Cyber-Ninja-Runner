package io.bidmachine;

import android.content.Context;
import android.os.Build;

/* JADX INFO: loaded from: classes13.dex */
final class HwInfoCache {
    private static final String KEY_HW = Build.MANUFACTURER + Build.MODEL;

    HwInfoCache() {
    }

    String read(Context context, String str) {
        return BidMachineSharedPreference.getHwInfo(context, str + KEY_HW);
    }

    void store(Context context, String str, String str2) {
        BidMachineSharedPreference.setHwInfo(context, str + KEY_HW, str2);
    }
}
