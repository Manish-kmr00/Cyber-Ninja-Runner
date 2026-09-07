package com.bytedance.sdk.openadsdk;

import android.content.Context;
import com.bytedance.sdk.openadsdk.api.open.PAGAppOpenAdLoadListener;
import com.bytedance.sdk.openadsdk.component.SD;
import com.bytedance.sdk.openadsdk.component.SD.pA;

/* JADX INFO: loaded from: classes10.dex */
public class TTC2Proxy {
    private TTC2Proxy() {
    }

    public static void load(Context context, AdSlot adSlot, PAGAppOpenAdLoadListener pAGAppOpenAdLoadListener, int i) {
        adSlot.setDurationSlotType(3);
        SD.pA(context).pA(adSlot, pAGAppOpenAdLoadListener, i);
    }

    public static void a(Context context) {
        pA.pA(context);
    }
}
