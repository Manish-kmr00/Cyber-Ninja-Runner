package io.bidmachine.media3.extractor.metadata;

import io.bidmachine.media3.decoder.DecoderInputBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class MetadataInputBuffer extends DecoderInputBuffer {
    public long subsampleOffsetUs;

    public MetadataInputBuffer() {
        super(1);
    }
}
