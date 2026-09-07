package com.google.android.exoplayer2.transformer;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.util.Assertions;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes8.dex */
final class TransformerMuxingVideoRenderer extends TransformerBaseRenderer {
    private static final String TAG = "TransformerVideoRenderer";
    private final DecoderInputBuffer buffer;
    private boolean formatRead;
    private boolean isBufferPending;
    private boolean isInputStreamEnded;
    private SampleTransformer sampleTransformer;

    public TransformerMuxingVideoRenderer(MuxerWrapper muxerWrapper, TransformerMediaClock transformerMediaClock, Transformation transformation) {
        super(2, muxerWrapper, transformerMediaClock, transformation);
        this.buffer = new DecoderInputBuffer(2);
    }

    @Override // com.google.android.exoplayer2.Renderer, com.google.android.exoplayer2.RendererCapabilities
    public String getName() {
        return TAG;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public void render(long j, long j2) {
        boolean zWriteSample;
        if (!this.isRendererStarted || isEnded()) {
            return;
        }
        if (!this.formatRead) {
            FormatHolder formatHolder = getFormatHolder();
            if (readSource(formatHolder, this.buffer, 2) != -5) {
                return;
            }
            Format format = (Format) Assertions.checkNotNull(formatHolder.format);
            this.formatRead = true;
            if (this.transformation.flattenForSlowMotion) {
                this.sampleTransformer = new SefSlowMotionVideoSampleTransformer(format);
            }
            this.muxerWrapper.addTrackFormat(format);
        }
        do {
            if (!this.isBufferPending && !readAndTransformBuffer()) {
                return;
            }
            zWriteSample = this.muxerWrapper.writeSample(getTrackType(), this.buffer.data, this.buffer.isKeyFrame(), this.buffer.timeUs);
            this.isBufferPending = !zWriteSample;
        } while (zWriteSample);
    }

    @Override // com.google.android.exoplayer2.Renderer
    public boolean isEnded() {
        return this.isInputStreamEnded;
    }

    private boolean readAndTransformBuffer() {
        this.buffer.clear();
        int source = readSource(getFormatHolder(), this.buffer, 0);
        if (source == -5) {
            throw new IllegalStateException("Format changes are not supported.");
        }
        if (source == -3) {
            return false;
        }
        if (this.buffer.isEndOfStream()) {
            this.isInputStreamEnded = true;
            this.muxerWrapper.endTrack(getTrackType());
            return false;
        }
        this.mediaClock.updateTimeForTrackType(getTrackType(), this.buffer.timeUs);
        this.buffer.timeUs -= this.streamOffsetUs;
        ((ByteBuffer) Assertions.checkNotNull(this.buffer.data)).flip();
        SampleTransformer sampleTransformer = this.sampleTransformer;
        if (sampleTransformer != null) {
            sampleTransformer.transformSample(this.buffer);
        }
        return true;
    }
}
