package io.bidmachine.core;

import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes11.dex */
public class VisibilityParams {
    public static final boolean DEF_IGNORE_OVERLAP = false;
    public static final boolean DEF_IGNORE_WINDOW_FOCUS = false;
    public static final float DEF_PIXEL_THRESHOLD = 1.0f;
    public static final long DEF_TIME_THRESHOLD_SEC = 1;
    private long timeThresholdMs = TimeUnit.SECONDS.toMillis(1);
    private float pixelThreshold = 1.0f;
    private boolean ignoreWindowFocus = false;
    private boolean ignoreOverlap = false;

    public long getTimeThresholdMs() {
        return this.timeThresholdMs;
    }

    public void setTimeThresholdSec(long j) {
        setTimeThresholdMs(TimeUnit.SECONDS.toMillis(j));
    }

    public void setTimeThresholdMs(long j) {
        this.timeThresholdMs = j;
    }

    public float getPixelThreshold() {
        return this.pixelThreshold;
    }

    public void setPixelThreshold(float f) {
        this.pixelThreshold = f;
    }

    public boolean isIgnoreWindowFocus() {
        return this.ignoreWindowFocus;
    }

    public void setIgnoreWindowFocus(boolean z) {
        this.ignoreWindowFocus = z;
    }

    public boolean isIgnoreOverlap() {
        return this.ignoreOverlap;
    }

    public void setIgnoreOverlap(boolean z) {
        this.ignoreOverlap = z;
    }
}
