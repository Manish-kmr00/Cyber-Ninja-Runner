package com.smaato.sdk.rewarded.csm;

import android.content.Context;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public interface SMARewardedNetworkEvent {
    String getNetworkName();

    boolean isValid();

    void onDestroy();

    void requestRewardedInterstitial(Context context, SMARewardedNetworkEventListener sMARewardedNetworkEventListener, Map<String, String> map, Map<String, Object> map2);

    void showAd();
}
