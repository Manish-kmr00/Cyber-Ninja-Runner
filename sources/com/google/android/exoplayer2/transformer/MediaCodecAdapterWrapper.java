package com.google.android.exoplayer2.transformer;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.view.Surface;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.mediacodec.MediaCodecAdapter;
import com.google.android.exoplayer2.mediacodec.MediaCodecInfo;
import com.google.android.exoplayer2.mediacodec.SynchronousMediaCodecAdapter;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MediaFormatUtil;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

/* JADX INFO: loaded from: classes8.dex */
final class MediaCodecAdapterWrapper {
    private static final int MEDIA_CODEC_PCM_ENCODING = 2;
    private final MediaCodecAdapter codec;
    private boolean inputStreamEnded;
    private ByteBuffer outputBuffer;
    private Format outputFormat;
    private boolean outputStreamEnded;
    private final MediaCodec.BufferInfo outputBufferInfo = new MediaCodec.BufferInfo();
    private int inputBufferIndex = -1;
    private int outputBufferIndex = -1;

    private static class Factory extends SynchronousMediaCodecAdapter.Factory {
        private Factory() {
        }

        @Override // com.google.android.exoplayer2.mediacodec.SynchronousMediaCodecAdapter.Factory
        protected MediaCodec createCodec(MediaCodecAdapter.Configuration configuration) throws IOException {
            String str = (String) Assertions.checkNotNull(configuration.mediaFormat.getString("mime"));
            if ((configuration.flags & 1) == 0) {
                return MediaCodec.createDecoderByType((String) Assertions.checkNotNull(str));
            }
            return MediaCodec.createEncoderByType((String) Assertions.checkNotNull(str));
        }
    }

    private static MediaCodecInfo createPlaceholderMediaCodecInfo() {
        return MediaCodecInfo.newInstance("name-placeholder", "mime-type-placeholder", "mime-type-placeholder", null, false, false, false, false, false);
    }

    public static MediaCodecAdapterWrapper createForAudioDecoding(Format format) throws Exception {
        MediaCodecAdapter mediaCodecAdapterCreateAdapter = null;
        byte b = 0;
        try {
            MediaFormat mediaFormatCreateAudioFormat = MediaFormat.createAudioFormat((String) Assertions.checkNotNull(format.sampleMimeType), format.sampleRate, format.channelCount);
            MediaFormatUtil.maybeSetInteger(mediaFormatCreateAudioFormat, "max-input-size", format.maxInputSize);
            MediaFormatUtil.setCsdBuffers(mediaFormatCreateAudioFormat, format.initializationData);
            mediaCodecAdapterCreateAdapter = new Factory().createAdapter(MediaCodecAdapter.Configuration.createForAudioDecoding(createPlaceholderMediaCodecInfo(), mediaFormatCreateAudioFormat, format, null));
            return new MediaCodecAdapterWrapper(mediaCodecAdapterCreateAdapter);
        } catch (Exception e) {
            if (mediaCodecAdapterCreateAdapter != null) {
                mediaCodecAdapterCreateAdapter.release();
            }
            throw e;
        }
    }

    public static MediaCodecAdapterWrapper createForVideoDecoding(Format format, Surface surface) throws Exception {
        MediaCodecAdapter mediaCodecAdapterCreateAdapter = null;
        byte b = 0;
        try {
            MediaFormat mediaFormatCreateVideoFormat = MediaFormat.createVideoFormat((String) Assertions.checkNotNull(format.sampleMimeType), format.width, format.height);
            MediaFormatUtil.maybeSetInteger(mediaFormatCreateVideoFormat, "max-input-size", format.maxInputSize);
            MediaFormatUtil.setCsdBuffers(mediaFormatCreateVideoFormat, format.initializationData);
            mediaCodecAdapterCreateAdapter = new Factory().createAdapter(MediaCodecAdapter.Configuration.createForVideoDecoding(createPlaceholderMediaCodecInfo(), mediaFormatCreateVideoFormat, format, surface, null));
            return new MediaCodecAdapterWrapper(mediaCodecAdapterCreateAdapter);
        } catch (Exception e) {
            if (mediaCodecAdapterCreateAdapter != null) {
                mediaCodecAdapterCreateAdapter.release();
            }
            throw e;
        }
    }

    public static MediaCodecAdapterWrapper createForAudioEncoding(Format format) throws Exception {
        MediaCodecAdapter mediaCodecAdapterCreateAdapter = null;
        byte b = 0;
        try {
            MediaFormat mediaFormatCreateAudioFormat = MediaFormat.createAudioFormat((String) Assertions.checkNotNull(format.sampleMimeType), format.sampleRate, format.channelCount);
            mediaFormatCreateAudioFormat.setInteger("bitrate", format.bitrate);
            mediaCodecAdapterCreateAdapter = new Factory().createAdapter(MediaCodecAdapter.Configuration.createForAudioEncoding(createPlaceholderMediaCodecInfo(), mediaFormatCreateAudioFormat, format));
            return new MediaCodecAdapterWrapper(mediaCodecAdapterCreateAdapter);
        } catch (Exception e) {
            if (mediaCodecAdapterCreateAdapter != null) {
                mediaCodecAdapterCreateAdapter.release();
            }
            throw e;
        }
    }

    public static MediaCodecAdapterWrapper createForVideoEncoding(Format format, Map<String, Integer> map) throws Exception {
        Assertions.checkArgument(format.width != -1);
        Assertions.checkArgument(format.height != -1);
        MediaCodecAdapter mediaCodecAdapterCreateAdapter = null;
        byte b = 0;
        try {
            MediaFormat mediaFormatCreateVideoFormat = MediaFormat.createVideoFormat((String) Assertions.checkNotNull(format.sampleMimeType), format.width, format.height);
            mediaFormatCreateVideoFormat.setInteger("color-format", 2130708361);
            mediaFormatCreateVideoFormat.setInteger("frame-rate", 30);
            mediaFormatCreateVideoFormat.setInteger("i-frame-interval", 1);
            mediaFormatCreateVideoFormat.setInteger("bitrate", 413000);
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                mediaFormatCreateVideoFormat.setInteger(entry.getKey(), entry.getValue().intValue());
            }
            mediaCodecAdapterCreateAdapter = new Factory().createAdapter(MediaCodecAdapter.Configuration.createForVideoEncoding(createPlaceholderMediaCodecInfo(), mediaFormatCreateVideoFormat, format));
            return new MediaCodecAdapterWrapper(mediaCodecAdapterCreateAdapter);
        } catch (Exception e) {
            if (mediaCodecAdapterCreateAdapter != null) {
                mediaCodecAdapterCreateAdapter.release();
            }
            throw e;
        }
    }

    private MediaCodecAdapterWrapper(MediaCodecAdapter mediaCodecAdapter) {
        this.codec = mediaCodecAdapter;
    }

    public Surface getInputSurface() {
        return this.codec.getInputSurface();
    }

    @EnsuresNonNullIf(expression = {"#1.data"}, result = true)
    public boolean maybeDequeueInputBuffer(DecoderInputBuffer decoderInputBuffer) {
        if (this.inputStreamEnded) {
            return false;
        }
        if (this.inputBufferIndex < 0) {
            int iDequeueInputBufferIndex = this.codec.dequeueInputBufferIndex();
            this.inputBufferIndex = iDequeueInputBufferIndex;
            if (iDequeueInputBufferIndex < 0) {
                return false;
            }
            decoderInputBuffer.data = this.codec.getInputBuffer(iDequeueInputBufferIndex);
            decoderInputBuffer.clear();
        }
        Assertions.checkNotNull(decoderInputBuffer.data);
        return true;
    }

    public void queueInputBuffer(DecoderInputBuffer decoderInputBuffer) {
        int iPosition;
        int iRemaining;
        Assertions.checkState(!this.inputStreamEnded, "Input buffer can not be queued after the input stream has ended.");
        int i = 0;
        if (decoderInputBuffer.data == null || !decoderInputBuffer.data.hasRemaining()) {
            iPosition = 0;
            iRemaining = 0;
        } else {
            iPosition = decoderInputBuffer.data.position();
            iRemaining = decoderInputBuffer.data.remaining();
        }
        if (decoderInputBuffer.isEndOfStream()) {
            this.inputStreamEnded = true;
            i = 4;
        }
        this.codec.queueInputBuffer(this.inputBufferIndex, iPosition, iRemaining, decoderInputBuffer.timeUs, i);
        this.inputBufferIndex = -1;
        decoderInputBuffer.data = null;
    }

    public void signalEndOfInputStream() {
        this.codec.signalEndOfInputStream();
    }

    public Format getOutputFormat() {
        maybeDequeueOutputBuffer();
        return this.outputFormat;
    }

    public ByteBuffer getOutputBuffer() {
        if (maybeDequeueAndSetOutputBuffer()) {
            return this.outputBuffer;
        }
        return null;
    }

    public MediaCodec.BufferInfo getOutputBufferInfo() {
        if (maybeDequeueOutputBuffer()) {
            return this.outputBufferInfo;
        }
        return null;
    }

    public void releaseOutputBuffer() {
        releaseOutputBuffer(false);
    }

    public void releaseOutputBuffer(boolean z) {
        this.outputBuffer = null;
        this.codec.releaseOutputBuffer(this.outputBufferIndex, z);
        this.outputBufferIndex = -1;
    }

    public boolean isEnded() {
        return this.outputStreamEnded && this.outputBufferIndex == -1;
    }

    public void release() {
        this.outputBuffer = null;
        this.codec.release();
    }

    private boolean maybeDequeueAndSetOutputBuffer() {
        if (!maybeDequeueOutputBuffer()) {
            return false;
        }
        ByteBuffer byteBuffer = (ByteBuffer) Assertions.checkNotNull(this.codec.getOutputBuffer(this.outputBufferIndex));
        this.outputBuffer = byteBuffer;
        byteBuffer.position(this.outputBufferInfo.offset);
        this.outputBuffer.limit(this.outputBufferInfo.offset + this.outputBufferInfo.size);
        return true;
    }

    private boolean maybeDequeueOutputBuffer() {
        if (this.outputBufferIndex >= 0) {
            return true;
        }
        if (this.outputStreamEnded) {
            return false;
        }
        int iDequeueOutputBufferIndex = this.codec.dequeueOutputBufferIndex(this.outputBufferInfo);
        this.outputBufferIndex = iDequeueOutputBufferIndex;
        if (iDequeueOutputBufferIndex < 0) {
            if (iDequeueOutputBufferIndex == -2) {
                this.outputFormat = getFormat(this.codec.getOutputFormat());
            }
            return false;
        }
        if ((this.outputBufferInfo.flags & 4) != 0) {
            this.outputStreamEnded = true;
            if (this.outputBufferInfo.size == 0) {
                releaseOutputBuffer();
                return false;
            }
        }
        if ((this.outputBufferInfo.flags & 2) == 0) {
            return true;
        }
        releaseOutputBuffer();
        return false;
    }

    private static Format getFormat(MediaFormat mediaFormat) {
        ImmutableList.Builder builder = new ImmutableList.Builder();
        int i = 0;
        while (true) {
            ByteBuffer byteBuffer = mediaFormat.getByteBuffer(new StringBuilder(15).append("csd-").append(i).toString());
            if (byteBuffer == null) {
                break;
            }
            byte[] bArr = new byte[byteBuffer.remaining()];
            byteBuffer.get(bArr);
            builder.add(bArr);
            i++;
        }
        String string = mediaFormat.getString("mime");
        Format.Builder initializationData = new Format.Builder().setSampleMimeType(mediaFormat.getString("mime")).setInitializationData(builder.build());
        if (MimeTypes.isVideo(string)) {
            initializationData.setWidth(mediaFormat.getInteger("width")).setHeight(mediaFormat.getInteger("height"));
        } else if (MimeTypes.isAudio(string)) {
            initializationData.setChannelCount(mediaFormat.getInteger("channel-count")).setSampleRate(mediaFormat.getInteger("sample-rate")).setPcmEncoding(2);
        }
        return initializationData.build();
    }
}
