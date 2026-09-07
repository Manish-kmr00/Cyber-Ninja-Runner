package com.google.android.exoplayer2.source.hls;

import com.google.android.exoplayer2.source.chunk.MediaChunk;
import com.google.android.exoplayer2.util.Util;
import com.json.b9;
import java.io.IOException;

/* JADX INFO: loaded from: classes8.dex */
final class UnexpectedSampleTimestampException extends IOException {
    public final long lastAcceptedSampleTimeUs;
    public final MediaChunk mediaChunk;
    public final long rejectedSampleTimeUs;

    /* JADX WARN: Illegal instructions before constructor call */
    public UnexpectedSampleTimestampException(MediaChunk mediaChunk, long j, long j2) {
        long jUsToMs = Util.usToMs(j2);
        long j3 = mediaChunk.startTimeUs;
        super(new StringBuilder(103).append("Unexpected sample timestamp: ").append(jUsToMs).append(" in chunk [").append(j3).append(", ").append(mediaChunk.endTimeUs).append(b9.i.e).toString());
        this.mediaChunk = mediaChunk;
        this.lastAcceptedSampleTimeUs = j;
        this.rejectedSampleTimeUs = j2;
    }
}
