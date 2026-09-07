package com.mbridge.msdk.playercommon.exoplayer2.extractor;

/* JADX INFO: loaded from: classes11.dex */
public interface ExtractorOutput {
    void endTracks();

    void seekMap(SeekMap seekMap);

    TrackOutput track(int i, int i2);
}
