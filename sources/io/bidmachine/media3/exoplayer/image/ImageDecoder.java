package io.bidmachine.media3.exoplayer.image;

import io.bidmachine.media3.common.Format;
import io.bidmachine.media3.decoder.Decoder;
import io.bidmachine.media3.decoder.DecoderInputBuffer;

/* JADX INFO: loaded from: classes9.dex */
public interface ImageDecoder extends Decoder<DecoderInputBuffer, ImageOutputBuffer, ImageDecoderException> {

    public interface Factory {
        public static final Factory DEFAULT = new BitmapFactoryImageDecoder.Factory();

        ImageDecoder createImageDecoder();

        int supportsFormat(Format format);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.bidmachine.media3.decoder.Decoder
    ImageOutputBuffer dequeueOutputBuffer() throws ImageDecoderException;

    @Override // io.bidmachine.media3.decoder.Decoder
    void queueInputBuffer(DecoderInputBuffer decoderInputBuffer) throws ImageDecoderException;
}
