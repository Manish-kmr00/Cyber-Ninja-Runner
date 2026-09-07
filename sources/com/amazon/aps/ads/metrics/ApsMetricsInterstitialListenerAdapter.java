package com.amazon.aps.ads.metrics;

import android.view.View;
import com.amazon.aps.shared.ApsMetrics;
import com.amazon.aps.shared.metrics.ApsMetricsPerfEventModelBuilder;
import com.amazon.device.ads.DTBAdInterstitialListener;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;

/* JADX INFO: compiled from: ApsMetricsInterstitialListenerAdapter.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0002\u0010\u0006J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/amazon/aps/ads/metrics/ApsMetricsInterstitialListenerAdapter;", "Lcom/amazon/aps/ads/metrics/ApsMetricsAdListenerAdapterBase;", "Lcom/amazon/device/ads/DTBAdInterstitialListener;", "bidId", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "(Ljava/lang/String;Lcom/amazon/device/ads/DTBAdInterstitialListener;)V", "getBidId", "()Ljava/lang/String;", "setBidId", "(Ljava/lang/String;)V", "getListener", "()Lcom/amazon/device/ads/DTBAdInterstitialListener;", "onVideoCompleted", "", "view", "Landroid/view/View;", "DTBAndroidSDK_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class ApsMetricsInterstitialListenerAdapter extends ApsMetricsAdListenerAdapterBase implements DTBAdInterstitialListener {
    private String bidId;
    private final DTBAdInterstitialListener listener;

    @Override // com.amazon.aps.ads.metrics.ApsMetricsAdListenerAdapterBase
    public String getBidId() {
        return this.bidId;
    }

    @Override // com.amazon.aps.ads.metrics.ApsMetricsAdListenerAdapterBase
    public void setBidId(String str) {
        this.bidId = str;
    }

    @Override // com.amazon.aps.ads.metrics.ApsMetricsAdListenerAdapterBase
    public DTBAdInterstitialListener getListener() {
        return this.listener;
    }

    public ApsMetricsInterstitialListenerAdapter(String str, DTBAdInterstitialListener dTBAdInterstitialListener) {
        super(str, dTBAdInterstitialListener);
        this.bidId = str;
        this.listener = dTBAdInterstitialListener;
    }

    @Override // com.amazon.device.ads.DTBAdVideoListener
    public void onVideoCompleted(View view) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        DTBAdInterstitialListener listener = getListener();
        if (listener != null) {
            listener.onVideoCompleted(view);
        }
        ApsMetrics.INSTANCE.adEvent(getBidId(), new ApsMetricsPerfEventModelBuilder().withBidId(getBidId()).withVideoCompletedEvent(jCurrentTimeMillis));
    }
}
