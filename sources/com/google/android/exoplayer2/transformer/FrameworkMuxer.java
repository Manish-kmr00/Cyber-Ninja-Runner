package com.google.android.exoplayer2.transformer;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.os.ParcelFileDescriptor;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MediaFormatUtil;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes7.dex */
final class FrameworkMuxer implements Muxer {
    private final MediaCodec.BufferInfo bufferInfo;
    private boolean isStarted;
    private final MediaMuxer mediaMuxer;

    public static final class Factory implements Muxer.Factory {
        @Override // com.google.android.exoplayer2.transformer.Muxer.Factory
        public FrameworkMuxer create(String str, String str2) throws IOException {
            return new FrameworkMuxer(new MediaMuxer(str, FrameworkMuxer.mimeTypeToMuxerOutputFormat(str2)));
        }

        @Override // com.google.android.exoplayer2.transformer.Muxer.Factory
        public FrameworkMuxer create(ParcelFileDescriptor parcelFileDescriptor, String str) throws IOException {
            return new FrameworkMuxer(new MediaMuxer(parcelFileDescriptor.getFileDescriptor(), FrameworkMuxer.mimeTypeToMuxerOutputFormat(str)));
        }

        @Override // com.google.android.exoplayer2.transformer.Muxer.Factory
        public boolean supportsOutputMimeType(String str) {
            try {
                FrameworkMuxer.mimeTypeToMuxerOutputFormat(str);
                return true;
            } catch (IllegalStateException unused) {
                return false;
            }
        }

        @Override // com.google.android.exoplayer2.transformer.Muxer.Factory
        public boolean supportsSampleMimeType(String str, String str2) {
            boolean zIsAudio = MimeTypes.isAudio(str);
            boolean zIsVideo = MimeTypes.isVideo(str);
            if (str2.equals("video/mp4")) {
                if (zIsVideo) {
                    if ("video/3gpp".equals(str) || "video/avc".equals(str) || "video/mp4v-es".equals(str)) {
                        return true;
                    }
                    return Util.SDK_INT >= 24 && "video/hevc".equals(str);
                }
                if (zIsAudio) {
                    return "audio/mp4a-latm".equals(str) || "audio/3gpp".equals(str) || "audio/amr-wb".equals(str);
                }
            } else if (str2.equals("video/webm") && Util.SDK_INT >= 21) {
                if (zIsVideo) {
                    if ("video/x-vnd.on2.vp8".equals(str)) {
                        return true;
                    }
                    return Util.SDK_INT >= 24 && "video/x-vnd.on2.vp9".equals(str);
                }
                if (zIsAudio) {
                    return "audio/vorbis".equals(str);
                }
            }
            return false;
        }
    }

    private FrameworkMuxer(MediaMuxer mediaMuxer) {
        this.mediaMuxer = mediaMuxer;
        this.bufferInfo = new MediaCodec.BufferInfo();
    }

    @Override // com.google.android.exoplayer2.transformer.Muxer
    public int addTrack(Format format) {
        MediaFormat mediaFormatCreateVideoFormat;
        String str = (String) Assertions.checkNotNull(format.sampleMimeType);
        if (MimeTypes.isAudio(str)) {
            mediaFormatCreateVideoFormat = MediaFormat.createAudioFormat((String) Util.castNonNull(str), format.sampleRate, format.channelCount);
        } else {
            mediaFormatCreateVideoFormat = MediaFormat.createVideoFormat((String) Util.castNonNull(str), format.width, format.height);
            this.mediaMuxer.setOrientationHint(format.rotationDegrees);
        }
        MediaFormatUtil.setCsdBuffers(mediaFormatCreateVideoFormat, format.initializationData);
        return this.mediaMuxer.addTrack(mediaFormatCreateVideoFormat);
    }

    @Override // com.google.android.exoplayer2.transformer.Muxer
    public void writeSampleData(int i, ByteBuffer byteBuffer, boolean z, long j) {
        if (!this.isStarted) {
            this.isStarted = true;
            this.mediaMuxer.start();
        }
        int iPosition = byteBuffer.position();
        this.bufferInfo.set(iPosition, byteBuffer.limit() - iPosition, j, z ? 1 : 0);
        this.mediaMuxer.writeSampleData(i, byteBuffer, this.bufferInfo);
    }

    @Override // com.google.android.exoplayer2.transformer.Muxer
    public void release(boolean z) {
        if (!this.isStarted) {
            this.mediaMuxer.release();
            return;
        }
        this.isStarted = false;
        try {
            try {
                this.mediaMuxer.stop();
            } catch (IllegalStateException e) {
                if (Util.SDK_INT < 30) {
                    try {
                        Field declaredField = MediaMuxer.class.getDeclaredField("MUXER_STATE_STOPPED");
                        declaredField.setAccessible(true);
                        int iIntValue = ((Integer) Util.castNonNull((Integer) declaredField.get(this.mediaMuxer))).intValue();
                        Field declaredField2 = MediaMuxer.class.getDeclaredField("mState");
                        declaredField2.setAccessible(true);
                        declaredField2.set(this.mediaMuxer, Integer.valueOf(iIntValue));
                    } catch (Exception unused) {
                    }
                }
                if (!z) {
                    throw e;
                }
            }
            this.mediaMuxer.release();
        } catch (Throwable th) {
            this.mediaMuxer.release();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int mimeTypeToMuxerOutputFormat(String str) {
        if (str.equals("video/mp4")) {
            return 0;
        }
        if (Util.SDK_INT >= 21 && str.equals("video/webm")) {
            return 1;
        }
        String strValueOf = String.valueOf(str);
        throw new IllegalArgumentException(strValueOf.length() != 0 ? "Unsupported output MIME type: ".concat(strValueOf) : new String("Unsupported output MIME type: "));
    }
}
