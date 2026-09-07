package com.chartboost.sdk.ads;

import com.json.m5;
import kotlin.Metadata;
import net.pubnative.lite.sdk.analytics.Reporting;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001J\b\u0010\u0006\u001a\u00020\u0007H&J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0003H&J\b\u0010\t\u001a\u00020\u0007H&J\b\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\u0007H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u0082\u0001\u0003\r\u000e\u000f¨\u0006\u0010"}, d2 = {"Lcom/chartboost/sdk/ads/Ad;", "", "location", "", "getLocation", "()Ljava/lang/String;", Reporting.EventType.CACHE, "", "bidResponse", "clearCache", "isCached", "", m5.v, "Lcom/chartboost/sdk/ads/Banner;", "Lcom/chartboost/sdk/ads/Interstitial;", "Lcom/chartboost/sdk/ads/Rewarded;", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface Ad {
    void cache();

    void cache(String bidResponse);

    void clearCache();

    String getLocation();

    boolean isCached();

    void show();
}
