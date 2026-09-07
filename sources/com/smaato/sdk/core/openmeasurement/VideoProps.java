package com.smaato.sdk.core.openmeasurement;

/* JADX INFO: loaded from: classes13.dex */
public class VideoProps {
    public final boolean isAutoPlay;
    public final boolean isSkippable;
    public final float skipOffset;

    private VideoProps(boolean z, float f) {
        this.isAutoPlay = true;
        this.isSkippable = z;
        this.skipOffset = f;
    }

    private VideoProps(boolean z) {
        this(z, Float.MIN_VALUE);
    }

    public static VideoProps buildForSkippableVideo(float f) {
        return new VideoProps(true, f);
    }

    public static VideoProps buildForNonSkippableVideo() {
        return new VideoProps(false);
    }
}
