package com.smaato.sdk.video.vast.buildlight.compare;

/* JADX INFO: loaded from: classes9.dex */
enum VideoQuality {
    LOW(360, 600),
    MEDIUM(576, 1100),
    HIGH(720, 2000);

    public final int averageBitrate;
    public final int maxWidth;

    VideoQuality(int i, int i2) {
        this.maxWidth = i;
        this.averageBitrate = i2;
    }
}
