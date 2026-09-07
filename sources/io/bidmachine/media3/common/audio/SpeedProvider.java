package io.bidmachine.media3.common.audio;

/* JADX INFO: loaded from: classes11.dex */
public interface SpeedProvider {
    long getNextSpeedChangeTimeUs(long j);

    float getSpeed(long j);
}
