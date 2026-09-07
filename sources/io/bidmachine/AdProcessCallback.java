package io.bidmachine;

import io.bidmachine.core.VisibilitySource;
import io.bidmachine.utils.BMError;

/* JADX INFO: loaded from: classes13.dex */
public interface AdProcessCallback {
    void processClicked();

    void processClosed();

    void processDestroy();

    void processExpired();

    void processFillAd();

    void processFinished();

    void processLoadFail(BMError bMError);

    void processLoadSuccess();

    void processShowFail(BMError bMError);

    void processShown();

    void processStartVisibilityTracker();

    void processVisibilityTrackerImpression();

    boolean processVisibilityTrackerShown();

    void setVisibilitySource(VisibilitySource visibilitySource);
}
