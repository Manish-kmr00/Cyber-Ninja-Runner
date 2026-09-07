package com.monetization.ads.quality.base;

import com.json.nu;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H&¨\u0006\u0007"}, d2 = {"Lcom/monetization/ads/quality/base/AdQualityVerifierAdEventListener;", "", nu.f, "", nu.g, "onAdWillDisplay", "onInvalidated", "mobileads_externalRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface AdQualityVerifierAdEventListener {
    void onAdClicked();

    void onAdClosed();

    void onAdWillDisplay();

    void onInvalidated();
}
