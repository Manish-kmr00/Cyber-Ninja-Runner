package com.amazon.aps.ads.metrics;

import com.amazon.device.ads.DTBAdBannerListener;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;

/* JADX INFO: compiled from: ApsMetricsBannerListenerAdapter.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0002\u0010\u0006R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/amazon/aps/ads/metrics/ApsMetricsBannerListenerAdapter;", "Lcom/amazon/aps/ads/metrics/ApsMetricsAdListenerAdapterBase;", "Lcom/amazon/device/ads/DTBAdBannerListener;", "bidId", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "(Ljava/lang/String;Lcom/amazon/device/ads/DTBAdBannerListener;)V", "getBidId", "()Ljava/lang/String;", "setBidId", "(Ljava/lang/String;)V", "getListener", "()Lcom/amazon/device/ads/DTBAdBannerListener;", "DTBAndroidSDK_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ApsMetricsBannerListenerAdapter extends ApsMetricsAdListenerAdapterBase implements DTBAdBannerListener {
    private String bidId;
    private final DTBAdBannerListener listener;

    @Override // com.amazon.aps.ads.metrics.ApsMetricsAdListenerAdapterBase
    public String getBidId() {
        return this.bidId;
    }

    @Override // com.amazon.aps.ads.metrics.ApsMetricsAdListenerAdapterBase
    public void setBidId(String str) {
        this.bidId = str;
    }

    @Override // com.amazon.aps.ads.metrics.ApsMetricsAdListenerAdapterBase
    public DTBAdBannerListener getListener() {
        return this.listener;
    }

    public ApsMetricsBannerListenerAdapter(String str, DTBAdBannerListener dTBAdBannerListener) {
        super(str, dTBAdBannerListener);
        this.bidId = str;
        this.listener = dTBAdBannerListener;
    }
}
