package io.bidmachine.media3.exoplayer.upstream;

import io.bidmachine.media3.datasource.DataSpec;

/* JADX INFO: loaded from: classes11.dex */
public interface TimeToFirstByteEstimator {
    long getTimeToFirstByteEstimateUs();

    void onTransferInitializing(DataSpec dataSpec);

    void onTransferStart(DataSpec dataSpec);

    void reset();
}
