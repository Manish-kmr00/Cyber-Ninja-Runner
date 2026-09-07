package com.amazon.aps.ads.metrics;

import android.view.View;
import com.amazon.aps.shared.ApsMetrics;
import com.amazon.aps.shared.metrics.ApsMetricsPerfEventModelBuilder;
import com.amazon.aps.shared.metrics.model.ApsMetricsResult;
import com.amazon.device.ads.DTBAdListener;
import com.amazon.device.ads.DTBMetricsConfiguration;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.json.nu;
import kotlin.Metadata;

/* JADX INFO: compiled from: ApsMetricsAdListenerAdapterBase.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0005J\u0006\u0010\f\u001a\u00020\rJ\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0012\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0013\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0014\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0015\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0016\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0017\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0018\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0001X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0019"}, d2 = {"Lcom/amazon/aps/ads/metrics/ApsMetricsAdListenerAdapterBase;", "Lcom/amazon/device/ads/DTBAdListener;", "bidId", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "(Ljava/lang/String;Lcom/amazon/device/ads/DTBAdListener;)V", "getBidId", "()Ljava/lang/String;", "setBidId", "(Ljava/lang/String;)V", "getListener", "()Lcom/amazon/device/ads/DTBAdListener;", "isAllowedToCaptureExtendedMetrics", "", nu.f, "", "view", "Landroid/view/View;", nu.g, "onAdError", "onAdFailed", nu.k, "onAdLoaded", "onAdOpen", "onImpressionFired", "DTBAndroidSDK_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class ApsMetricsAdListenerAdapterBase implements DTBAdListener {
    private String bidId;
    private final DTBAdListener listener;

    public ApsMetricsAdListenerAdapterBase(String str, DTBAdListener dTBAdListener) {
        this.bidId = str;
        this.listener = dTBAdListener;
    }

    public String getBidId() {
        return this.bidId;
    }

    public void setBidId(String str) {
        this.bidId = str;
    }

    public DTBAdListener getListener() {
        return this.listener;
    }

    @Override // com.amazon.device.ads.DTBAdListener
    public void onAdLoaded(View view) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        DTBAdListener listener = getListener();
        if (listener != null) {
            listener.onAdLoaded(view);
        }
        ApsMetrics.INSTANCE.adEvent(getBidId(), new ApsMetricsPerfEventModelBuilder().withBidId(getBidId()).withAdFetchEndTime(ApsMetricsResult.Success, jCurrentTimeMillis));
    }

    @Override // com.amazon.device.ads.DTBAdListener
    public void onAdFailed(View view) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        DTBAdListener listener = getListener();
        if (listener != null) {
            listener.onAdFailed(view);
        }
        ApsMetrics.INSTANCE.adEvent(getBidId(), new ApsMetricsPerfEventModelBuilder().withBidId(getBidId()).withAdFetchEndTime(ApsMetricsResult.Failure, jCurrentTimeMillis));
    }

    @Override // com.amazon.device.ads.DTBAdListener
    public void onAdClicked(View view) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        DTBAdListener listener = getListener();
        if (listener != null) {
            listener.onAdClicked(view);
        }
        if (isAllowedToCaptureExtendedMetrics()) {
            ApsMetrics.INSTANCE.adEvent(getBidId(), new ApsMetricsPerfEventModelBuilder().withBidId(getBidId()).withAdClickEvent(jCurrentTimeMillis));
        }
    }

    public final boolean isAllowedToCaptureExtendedMetrics() {
        return DTBMetricsConfiguration.getInstance().isFeatureEnabled(DTBMetricsConfiguration.FEATURE_APSMETRICS_EXTENDED_METRICS, false);
    }

    @Override // com.amazon.device.ads.DTBAdListener
    public void onAdLeftApplication(View view) {
        DTBAdListener listener = getListener();
        if (listener == null) {
            return;
        }
        listener.onAdLeftApplication(view);
    }

    @Override // com.amazon.device.ads.DTBAdListener
    public void onAdOpen(View view) {
        DTBAdListener listener = getListener();
        if (listener == null) {
            return;
        }
        listener.onAdOpen(view);
    }

    @Override // com.amazon.device.ads.DTBAdListener
    public void onAdClosed(View view) {
        DTBAdListener listener = getListener();
        if (listener == null) {
            return;
        }
        listener.onAdClosed(view);
    }

    @Override // com.amazon.device.ads.DTBAdListener
    public void onImpressionFired(View view) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        DTBAdListener listener = getListener();
        if (listener != null) {
            listener.onImpressionFired(view);
        }
        ApsMetrics.INSTANCE.adEvent(getBidId(), new ApsMetricsPerfEventModelBuilder().withBidId(getBidId()).withAdImpressionEndTime(ApsMetricsResult.Success, jCurrentTimeMillis));
    }

    @Override // com.amazon.device.ads.DTBAdListener
    public void onAdError(View view) {
        DTBAdListener listener = getListener();
        if (listener == null) {
            return;
        }
        listener.onAdError(view);
    }
}
