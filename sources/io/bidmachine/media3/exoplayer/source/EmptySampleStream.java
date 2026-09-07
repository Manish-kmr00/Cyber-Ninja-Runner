package io.bidmachine.media3.exoplayer.source;

import io.bidmachine.media3.decoder.DecoderInputBuffer;
import io.bidmachine.media3.exoplayer.FormatHolder;

/* JADX INFO: loaded from: classes11.dex */
public final class EmptySampleStream implements SampleStream {
    @Override // io.bidmachine.media3.exoplayer.source.SampleStream
    public boolean isReady() {
        return true;
    }

    @Override // io.bidmachine.media3.exoplayer.source.SampleStream
    public void maybeThrowError() {
    }

    @Override // io.bidmachine.media3.exoplayer.source.SampleStream
    public int skipData(long j) {
        return 0;
    }

    @Override // io.bidmachine.media3.exoplayer.source.SampleStream
    public int readData(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i) {
        decoderInputBuffer.setFlags(4);
        return -4;
    }
}
