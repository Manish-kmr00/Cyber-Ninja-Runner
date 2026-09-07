package io.bidmachine.media3.exoplayer.upstream.experimental;

/* JADX INFO: loaded from: classes5.dex */
public interface BandwidthStatistic {
    void addSample(long j, long j2);

    long getBandwidthEstimate();

    void reset();
}
