package com.bytedance.sdk.openadsdk;

import android.content.Context;
import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAdLoadListener;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAdLoadListener;
import com.bytedance.sdk.openadsdk.component.KZx.Og;
import com.bytedance.sdk.openadsdk.component.reward.ML;
import com.bytedance.sdk.openadsdk.component.reward.SD;
import com.bytedance.sdk.openadsdk.component.reward.SGo;
import com.bytedance.sdk.openadsdk.component.reward.WV;

/* JADX INFO: loaded from: classes5.dex */
public class TTC3Proxy {
    public static void verityPlayable(String str, int i, String str2, String str3, String str4) {
        SGo.pA(str, i, str2, str3, str4);
    }

    public static void loadReward(Context context, AdSlot adSlot, PAGRewardedAdLoadListener pAGRewardedAdLoadListener) {
        adSlot.setDurationSlotType(7);
        WV.pA(context).pA(adSlot, new SD(pAGRewardedAdLoadListener));
    }

    public static void loadFull(Context context, AdSlot adSlot, PAGInterstitialAdLoadListener pAGInterstitialAdLoadListener) {
        adSlot.setDurationSlotType(8);
        ML.pA(context).pA(adSlot, new Og(pAGInterstitialAdLoadListener));
    }

    public static void a(Context context) {
        try {
            WV.pA(context).pA();
        } catch (Throwable unused) {
        }
        try {
            ML.pA(context).pA();
        } catch (Throwable unused2) {
        }
    }
}
