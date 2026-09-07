package io.bidmachine.unified;

import io.bidmachine.core.VisibilitySource;
import io.bidmachine.utils.BMError;

/* JADX INFO: loaded from: classes12.dex */
public interface UnifiedAdCallback {
    void onAdClicked();

    void onAdExpired();

    void onAdLoadFailed(BMError bMError);

    void onAdShowFailed(BMError bMError);

    void onAdShown();

    void setVisibilitySource(VisibilitySource visibilitySource);
}
