package com.smaato.sdk.banner.csm;

import android.content.Context;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public interface SMABannerNetworkEvent {
    String getNetworkName();

    void onDestroy();

    void requestBanner(Context context, SMABannerNetworkEventListener sMABannerNetworkEventListener, Map<String, String> map, Map<String, Object> map2);
}
