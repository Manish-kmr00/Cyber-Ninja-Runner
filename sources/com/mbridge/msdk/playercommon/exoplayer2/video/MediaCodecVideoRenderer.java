package com.mbridge.msdk.playercommon.exoplayer2.video;

import android.content.Context;
import android.graphics.Point;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.Surface;
import com.amazon.device.ads.DtbConstants;
import com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.json.b9;
import com.json.mediationsdk.utils.IronSourceConstants;
import com.mbridge.msdk.playercommon.exoplayer2.BaseRenderer;
import com.mbridge.msdk.playercommon.exoplayer2.ExoPlaybackException;
import com.mbridge.msdk.playercommon.exoplayer2.Format;
import com.mbridge.msdk.playercommon.exoplayer2.decoder.DecoderCounters;
import com.mbridge.msdk.playercommon.exoplayer2.decoder.DecoderInputBuffer;
import com.mbridge.msdk.playercommon.exoplayer2.drm.DrmInitData;
import com.mbridge.msdk.playercommon.exoplayer2.drm.DrmSessionManager;
import com.mbridge.msdk.playercommon.exoplayer2.drm.FrameworkMediaCrypto;
import com.mbridge.msdk.playercommon.exoplayer2.mediacodec.MediaCodecInfo;
import com.mbridge.msdk.playercommon.exoplayer2.mediacodec.MediaCodecRenderer;
import com.mbridge.msdk.playercommon.exoplayer2.mediacodec.MediaCodecSelector;
import com.mbridge.msdk.playercommon.exoplayer2.mediacodec.MediaCodecUtil;
import com.mbridge.msdk.playercommon.exoplayer2.mediacodec.MediaFormatUtil;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.mbridge.msdk.playercommon.exoplayer2.util.TraceUtil;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer;
import com.unity3d.services.core.di.ServiceProvider;
import io.bidmachine.iab.vast.tags.VastAttributes;
import java.nio.ByteBuffer;
import kotlin.io.encoding.Base64;

/* JADX INFO: loaded from: classes10.dex */
public class MediaCodecVideoRenderer extends MediaCodecRenderer {
    private static final String KEY_CROP_BOTTOM = "crop-bottom";
    private static final String KEY_CROP_LEFT = "crop-left";
    private static final String KEY_CROP_RIGHT = "crop-right";
    private static final String KEY_CROP_TOP = "crop-top";
    private static final int MAX_PENDING_OUTPUT_STREAM_OFFSET_COUNT = 10;
    private static final int[] STANDARD_LONG_EDGE_VIDEO_PX = {1920, IronSourceConstants.RV_OPERATIONAL_LOAD_AD, 1440, 1280, 960, 854, 640, 540, DtbConstants.DEFAULT_PLAYER_HEIGHT};
    private static final String TAG = "MediaCodecVideoRenderer";
    private static boolean deviceNeedsSetOutputSurfaceWorkaround;
    private static boolean evaluatedDeviceNeedsSetOutputSurfaceWorkaround;
    private final long allowedJoiningTimeMs;
    private int buffersInCodecCount;
    private CodecMaxValues codecMaxValues;
    private boolean codecNeedsSetOutputSurfaceWorkaround;
    private int consecutiveDroppedFrameCount;
    private final Context context;
    private int currentHeight;
    private float currentPixelWidthHeightRatio;
    private int currentUnappliedRotationDegrees;
    private int currentWidth;
    private final boolean deviceNeedsAutoFrcWorkaround;
    private long droppedFrameAccumulationStartTimeMs;
    private int droppedFrames;
    private Surface dummySurface;
    private final VideoRendererEventListener.EventDispatcher eventDispatcher;
    private final VideoFrameReleaseTimeHelper frameReleaseTimeHelper;
    private long initialPositionUs;
    private long joiningDeadlineMs;
    private long lastInputTimeUs;
    private long lastRenderTimeUs;
    private final int maxDroppedFramesToNotify;
    private long outputStreamOffsetUs;
    private int pendingOutputStreamOffsetCount;
    private final long[] pendingOutputStreamOffsetsUs;
    private final long[] pendingOutputStreamSwitchTimesUs;
    private float pendingPixelWidthHeightRatio;
    private int pendingRotationDegrees;
    private boolean renderedFirstFrame;
    private int reportedHeight;
    private float reportedPixelWidthHeightRatio;
    private int reportedUnappliedRotationDegrees;
    private int reportedWidth;
    private int scalingMode;
    private Surface surface;
    private boolean tunneling;
    private int tunnelingAudioSessionId;
    OnFrameRenderedListenerV23 tunnelingOnFrameRenderedListener;

    protected static final class CodecMaxValues {
        public final int height;
        public final int inputSize;
        public final int width;

        public CodecMaxValues(int i, int i2, int i3) {
            this.width = i;
            this.height = i2;
            this.inputSize = i3;
        }
    }

    private final class OnFrameRenderedListenerV23 implements MediaCodec.OnFrameRenderedListener {
        @Override // android.media.MediaCodec.OnFrameRenderedListener
        public void onFrameRendered(MediaCodec mediaCodec, long j, long j2) {
            MediaCodecVideoRenderer mediaCodecVideoRenderer = MediaCodecVideoRenderer.this;
            if (this != mediaCodecVideoRenderer.tunnelingOnFrameRenderedListener) {
                return;
            }
            mediaCodecVideoRenderer.maybeNotifyRenderedFirstFrame();
        }

        private OnFrameRenderedListenerV23(MediaCodec mediaCodec) {
            mediaCodec.setOnFrameRenderedListener(this, new Handler());
        }
    }

    public MediaCodecVideoRenderer(Context context, MediaCodecSelector mediaCodecSelector) {
        this(context, mediaCodecSelector, 0L);
    }

    private static boolean areAdaptationCompatible(boolean z, Format format, Format format2) {
        return format.sampleMimeType.equals(format2.sampleMimeType) && format.rotationDegrees == format2.rotationDegrees && (z || (format.width == format2.width && format.height == format2.height)) && Util.areEqual(format.colorInfo, format2.colorInfo);
    }

    private void clearRenderedFirstFrame() {
        MediaCodec codec;
        this.renderedFirstFrame = false;
        if (Util.SDK_INT < 23 || !this.tunneling || (codec = getCodec()) == null) {
            return;
        }
        this.tunnelingOnFrameRenderedListener = new OnFrameRenderedListenerV23(codec);
    }

    private void clearReportedVideoSize() {
        this.reportedWidth = -1;
        this.reportedHeight = -1;
        this.reportedPixelWidthHeightRatio = -1.0f;
        this.reportedUnappliedRotationDegrees = -1;
    }

    private static void configureTunnelingV21(MediaFormat mediaFormat, int i) {
        mediaFormat.setFeatureEnabled("tunneled-playback", true);
        mediaFormat.setInteger("audio-session-id", i);
    }

    private static boolean deviceNeedsAutoFrcWorkaround() {
        return Util.SDK_INT <= 22 && "foster".equals(Util.DEVICE) && "NVIDIA".equals(Util.MANUFACTURER);
    }

    private static Point getCodecMaxSize(MediaCodecInfo mediaCodecInfo, Format format) throws MediaCodecUtil.DecoderQueryException {
        int i = format.height;
        int i2 = format.width;
        boolean z = i > i2;
        int i3 = z ? i : i2;
        if (z) {
            i = i2;
        }
        float f = i / i3;
        for (int i4 : STANDARD_LONG_EDGE_VIDEO_PX) {
            int i5 = (int) (i4 * f);
            if (i4 <= i3 || i5 <= i) {
                break;
            }
            if (Util.SDK_INT >= 21) {
                int i6 = z ? i5 : i4;
                if (!z) {
                    i4 = i5;
                }
                Point pointAlignVideoSizeV21 = mediaCodecInfo.alignVideoSizeV21(i6, i4);
                if (mediaCodecInfo.isVideoSizeAndRateSupportedV21(pointAlignVideoSizeV21.x, pointAlignVideoSizeV21.y, format.frameRate)) {
                    return pointAlignVideoSizeV21;
                }
            } else {
                int iCeilDivide = Util.ceilDivide(i4, 16) * 16;
                int iCeilDivide2 = Util.ceilDivide(i5, 16) * 16;
                if (iCeilDivide * iCeilDivide2 <= MediaCodecUtil.maxH264DecodableFrameSize()) {
                    int i7 = z ? iCeilDivide2 : iCeilDivide;
                    if (!z) {
                        iCeilDivide = iCeilDivide2;
                    }
                    return new Point(i7, iCeilDivide);
                }
            }
        }
        return null;
    }

    private static int getMaxInputSize(MediaCodecInfo mediaCodecInfo, Format format) {
        if (format.maxInputSize == -1) {
            return getMaxInputSize(mediaCodecInfo, format.sampleMimeType, format.width, format.height);
        }
        int size = format.initializationData.size();
        int length = 0;
        for (int i = 0; i < size; i++) {
            length += format.initializationData.get(i).length;
        }
        return format.maxInputSize + length;
    }

    private static boolean isBufferLate(long j) {
        return j < -30000;
    }

    private static boolean isBufferVeryLate(long j) {
        return j < -500000;
    }

    private void maybeNotifyDroppedFrames() {
        if (this.droppedFrames > 0) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            this.eventDispatcher.droppedFrames(this.droppedFrames, jElapsedRealtime - this.droppedFrameAccumulationStartTimeMs);
            this.droppedFrames = 0;
            this.droppedFrameAccumulationStartTimeMs = jElapsedRealtime;
        }
    }

    private void maybeNotifyVideoSizeChanged() {
        int i = this.currentWidth;
        if (i == -1 && this.currentHeight == -1) {
            return;
        }
        if (this.reportedWidth == i && this.reportedHeight == this.currentHeight && this.reportedUnappliedRotationDegrees == this.currentUnappliedRotationDegrees && this.reportedPixelWidthHeightRatio == this.currentPixelWidthHeightRatio) {
            return;
        }
        this.eventDispatcher.videoSizeChanged(i, this.currentHeight, this.currentUnappliedRotationDegrees, this.currentPixelWidthHeightRatio);
        this.reportedWidth = this.currentWidth;
        this.reportedHeight = this.currentHeight;
        this.reportedUnappliedRotationDegrees = this.currentUnappliedRotationDegrees;
        this.reportedPixelWidthHeightRatio = this.currentPixelWidthHeightRatio;
    }

    private void maybeRenotifyRenderedFirstFrame() {
        if (this.renderedFirstFrame) {
            this.eventDispatcher.renderedFirstFrame(this.surface);
        }
    }

    private void maybeRenotifyVideoSizeChanged() {
        int i = this.reportedWidth;
        if (i == -1 && this.reportedHeight == -1) {
            return;
        }
        this.eventDispatcher.videoSizeChanged(i, this.reportedHeight, this.reportedUnappliedRotationDegrees, this.reportedPixelWidthHeightRatio);
    }

    private void setJoiningDeadlineMs() {
        this.joiningDeadlineMs = this.allowedJoiningTimeMs > 0 ? SystemClock.elapsedRealtime() + this.allowedJoiningTimeMs : -9223372036854775807L;
    }

    private static void setOutputSurfaceV23(MediaCodec mediaCodec, Surface surface) {
        mediaCodec.setOutputSurface(surface);
    }

    private void setSurface(Surface surface) throws ExoPlaybackException {
        if (surface == null) {
            Surface surface2 = this.dummySurface;
            if (surface2 != null) {
                surface = surface2;
            } else {
                MediaCodecInfo codecInfo = getCodecInfo();
                if (codecInfo != null && shouldUseDummySurface(codecInfo)) {
                    surface = DummySurface.newInstanceV17(this.context, codecInfo.secure);
                    this.dummySurface = surface;
                }
            }
        }
        if (this.surface == surface) {
            if (surface == null || surface == this.dummySurface) {
                return;
            }
            maybeRenotifyVideoSizeChanged();
            maybeRenotifyRenderedFirstFrame();
            return;
        }
        this.surface = surface;
        int state = getState();
        if (state == 1 || state == 2) {
            MediaCodec codec = getCodec();
            if (Util.SDK_INT < 23 || codec == null || surface == null || this.codecNeedsSetOutputSurfaceWorkaround) {
                releaseCodec();
                maybeInitCodec();
            } else {
                setOutputSurfaceV23(codec, surface);
            }
        }
        if (surface == null || surface == this.dummySurface) {
            clearReportedVideoSize();
            clearRenderedFirstFrame();
            return;
        }
        maybeRenotifyVideoSizeChanged();
        clearRenderedFirstFrame();
        if (state == 2) {
            setJoiningDeadlineMs();
        }
    }

    private boolean shouldUseDummySurface(MediaCodecInfo mediaCodecInfo) {
        return Util.SDK_INT >= 23 && !this.tunneling && !codecNeedsSetOutputSurfaceWorkaround(mediaCodecInfo.name) && (!mediaCodecInfo.secure || DummySurface.isSecureSupported(this.context));
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.mediacodec.MediaCodecRenderer
    protected int canKeepCodec(MediaCodec mediaCodec, MediaCodecInfo mediaCodecInfo, Format format, Format format2) {
        if (!areAdaptationCompatible(mediaCodecInfo.adaptive, format, format2)) {
            return 0;
        }
        int i = format2.width;
        CodecMaxValues codecMaxValues = this.codecMaxValues;
        if (i > codecMaxValues.width || format2.height > codecMaxValues.height || getMaxInputSize(mediaCodecInfo, format2) > this.codecMaxValues.inputSize) {
            return 0;
        }
        return format.initializationDataEquals(format2) ? 1 : 3;
    }

    /* JADX WARN: Code duplicated, block: B:368:0x059f  */
    /* JADX WARN: Code duplicated, block: B:383:0x05ca  */
    protected boolean codecNeedsSetOutputSurfaceWorkaround(String str) {
        int i = Util.SDK_INT;
        byte b = 0;
        byte b2 = Ascii.ESC;
        if (i >= 27 || str.startsWith("OMX.google")) {
            return false;
        }
        synchronized (MediaCodecVideoRenderer.class) {
            if (!evaluatedDeviceNeedsSetOutputSurfaceWorkaround) {
                String str2 = Util.DEVICE;
                switch (str2.hashCode()) {
                    case -2144781245:
                        if (!str2.equals("GIONEE_SWW1609")) {
                            b2 = -1;
                        } else {
                            b2 = 39;
                        }
                        break;
                    case -2144781185:
                        if (!str2.equals("GIONEE_SWW1627")) {
                            b2 = -1;
                        } else {
                            b2 = 40;
                        }
                        break;
                    case -2144781160:
                        if (!str2.equals("GIONEE_SWW1631")) {
                            b2 = -1;
                        } else {
                            b2 = 41;
                        }
                        break;
                    case -2097309513:
                        if (!str2.equals("K50a40")) {
                            b2 = -1;
                        } else {
                            b2 = 57;
                        }
                        break;
                    case -2022874474:
                        if (!str2.equals("CP8676_I02")) {
                            b2 = -1;
                        } else {
                            b2 = Ascii.DLE;
                        }
                        break;
                    case -1978993182:
                        if (!str2.equals("NX541J")) {
                            b2 = -1;
                        } else {
                            b2 = 69;
                        }
                        break;
                    case -1978990237:
                        if (!str2.equals("NX573J")) {
                            b2 = -1;
                        } else {
                            b2 = 70;
                        }
                        break;
                    case -1936688988:
                        if (!str2.equals("PGN528")) {
                            b2 = -1;
                        } else {
                            b2 = 80;
                        }
                        break;
                    case -1936688066:
                        if (!str2.equals("PGN610")) {
                            b2 = -1;
                        } else {
                            b2 = 81;
                        }
                        break;
                    case -1936688065:
                        if (!str2.equals("PGN611")) {
                            b2 = -1;
                        } else {
                            b2 = 82;
                        }
                        break;
                    case -1931988508:
                        if (!str2.equals("AquaPowerM")) {
                            b2 = -1;
                        } else {
                            b2 = 10;
                        }
                        break;
                    case -1696512866:
                        if (!str2.equals("XT1663")) {
                            b2 = -1;
                        } else {
                            b2 = 115;
                        }
                        break;
                    case -1680025915:
                        if (!str2.equals("ComioS1")) {
                            b2 = -1;
                        } else {
                            b2 = Ascii.SI;
                        }
                        break;
                    case -1615810839:
                        if (!str2.equals("Phantom6")) {
                            b2 = -1;
                        } else {
                            b2 = 83;
                        }
                        break;
                    case -1554255044:
                        if (!str2.equals("vernee_M5")) {
                            b2 = -1;
                        } else {
                            b2 = 108;
                        }
                        break;
                    case -1481772737:
                        if (!str2.equals("panell_dl")) {
                            b2 = -1;
                        } else {
                            b2 = 76;
                        }
                        break;
                    case -1481772730:
                        if (!str2.equals("panell_ds")) {
                            b2 = -1;
                        } else {
                            b2 = 77;
                        }
                        break;
                    case -1481772729:
                        if (!str2.equals("panell_dt")) {
                            b2 = -1;
                        } else {
                            b2 = 78;
                        }
                        break;
                    case -1320080169:
                        if (!str2.equals("GiONEE_GBL7319")) {
                            b2 = -1;
                        } else {
                            b2 = 37;
                        }
                        break;
                    case -1217592143:
                        if (!str2.equals("BRAVIA_ATV2")) {
                            b2 = -1;
                        } else {
                            b2 = Ascii.CR;
                        }
                        break;
                    case -1180384755:
                        if (!str2.equals("iris60")) {
                            b2 = -1;
                        } else {
                            b2 = 53;
                        }
                        break;
                    case -1139198265:
                        if (!str2.equals("Slate_Pro")) {
                            b2 = -1;
                        } else {
                            b2 = 96;
                        }
                        break;
                    case -1052835013:
                        if (!str2.equals("namath")) {
                            b2 = -1;
                        } else {
                            b2 = 67;
                        }
                        break;
                    case -993250464:
                        if (!str2.equals("A10-70F")) {
                            b2 = -1;
                        } else {
                            b2 = 3;
                        }
                        break;
                    case -965403638:
                        if (!str2.equals("s905x018")) {
                            b2 = -1;
                        } else {
                            b2 = 98;
                        }
                        break;
                    case -958336948:
                        if (!str2.equals("ELUGA_Ray_X")) {
                            b2 = -1;
                        } else {
                            b2 = Ascii.SUB;
                        }
                        break;
                    case -879245230:
                        if (!str2.equals("tcl_eu")) {
                            b2 = -1;
                        } else {
                            b2 = 104;
                        }
                        break;
                    case -842500323:
                        if (!str2.equals("nicklaus_f")) {
                            b2 = -1;
                        } else {
                            b2 = 68;
                        }
                        break;
                    case -821392978:
                        if (!str2.equals("A7000-a")) {
                            b2 = -1;
                        } else {
                            b2 = 6;
                        }
                        break;
                    case -797483286:
                        if (!str2.equals("SVP-DTV15")) {
                            b2 = -1;
                        } else {
                            b2 = 97;
                        }
                        break;
                    case -794946968:
                        if (!str2.equals("watson")) {
                            b2 = -1;
                        } else {
                            b2 = 109;
                        }
                        break;
                    case -788334647:
                        if (!str2.equals("whyred")) {
                            b2 = -1;
                        } else {
                            b2 = 110;
                        }
                        break;
                    case -782144577:
                        if (!str2.equals("OnePlus5T")) {
                            b2 = -1;
                        } else {
                            b2 = 71;
                        }
                        break;
                    case -575125681:
                        if (!str2.equals("GiONEE_CBL7513")) {
                            b2 = -1;
                        } else {
                            b2 = 36;
                        }
                        break;
                    case -521118391:
                        if (!str2.equals("GIONEE_GBL7360")) {
                            b2 = -1;
                        } else {
                            b2 = 38;
                        }
                        break;
                    case -430914369:
                        if (!str2.equals("Pixi4-7_3G")) {
                            b2 = -1;
                        } else {
                            b2 = 84;
                        }
                        break;
                    case -290434366:
                        if (!str2.equals("taido_row")) {
                            b2 = -1;
                        } else {
                            b2 = 99;
                        }
                        break;
                    case -282781963:
                        if (!str2.equals("BLACK-1X")) {
                            b2 = -1;
                        } else {
                            b2 = Ascii.FF;
                        }
                        break;
                    case -277133239:
                        if (!str2.equals("Z12_PRO")) {
                            b2 = -1;
                        } else {
                            b2 = 116;
                        }
                        break;
                    case -173639913:
                        if (!str2.equals("ELUGA_A3_Pro")) {
                            b2 = -1;
                        } else {
                            b2 = Ascii.ETB;
                        }
                        break;
                    case -56598463:
                        if (!str2.equals("woods_fn")) {
                            b2 = -1;
                        } else {
                            b2 = 112;
                        }
                        break;
                    case 2126:
                        if (!str2.equals("C1")) {
                            b2 = -1;
                        } else {
                            b2 = Ascii.SO;
                        }
                        break;
                    case 2564:
                        if (!str2.equals("Q5")) {
                            b2 = -1;
                        } else {
                            b2 = 92;
                        }
                        break;
                    case 2715:
                        if (!str2.equals("V1")) {
                            b2 = -1;
                        } else {
                            b2 = 105;
                        }
                        break;
                    case 2719:
                        if (!str2.equals("V5")) {
                            b2 = -1;
                        } else {
                            b2 = 107;
                        }
                        break;
                    case 3483:
                        if (!str2.equals("mh")) {
                            b2 = -1;
                        } else {
                            b2 = SignedBytes.MAX_POWER_OF_TWO;
                        }
                        break;
                    case 73405:
                        if (!str2.equals("JGZ")) {
                            b2 = -1;
                        } else {
                            b2 = 56;
                        }
                        break;
                    case 75739:
                        if (!str2.equals("M5c")) {
                            b2 = -1;
                        } else {
                            b2 = 60;
                        }
                        break;
                    case 76779:
                        if (!str2.equals("MX6")) {
                            b2 = -1;
                        } else {
                            b2 = 66;
                        }
                        break;
                    case 78669:
                        if (!str2.equals("P85")) {
                            b2 = -1;
                        } else {
                            b2 = 74;
                        }
                        break;
                    case 79305:
                        if (!str2.equals("PLE")) {
                            b2 = -1;
                        } else {
                            b2 = 86;
                        }
                        break;
                    case 80618:
                        if (!str2.equals("QX1")) {
                            b2 = -1;
                        } else {
                            b2 = 94;
                        }
                        break;
                    case 88274:
                        if (!str2.equals("Z80")) {
                            b2 = -1;
                        } else {
                            b2 = 117;
                        }
                        break;
                    case 98846:
                        if (!str2.equals("cv1")) {
                            b2 = -1;
                        } else {
                            b2 = 19;
                        }
                        break;
                    case 98848:
                        if (!str2.equals("cv3")) {
                            b2 = -1;
                        } else {
                            b2 = Ascii.DC4;
                        }
                        break;
                    case 99329:
                        if (!str2.equals("deb")) {
                            b2 = -1;
                        } else {
                            b2 = Ascii.NAK;
                        }
                        break;
                    case 101481:
                        if (!str2.equals("flo")) {
                            b2 = -1;
                        } else {
                            b2 = 35;
                        }
                        break;
                    case 1513190:
                        if (!str2.equals("1601")) {
                            b2 = -1;
                        } else {
                            b2 = 0;
                        }
                        break;
                    case 1514184:
                        if (!str2.equals("1713")) {
                            b2 = -1;
                        } else {
                            b2 = 1;
                        }
                        break;
                    case 1514185:
                        if (!str2.equals("1714")) {
                            b2 = -1;
                        } else {
                            b2 = 2;
                        }
                        break;
                    case 2436959:
                        if (!str2.equals("P681")) {
                            b2 = -1;
                        } else {
                            b2 = 73;
                        }
                        break;
                    case 2463773:
                        if (!str2.equals("Q350")) {
                            b2 = -1;
                        } else {
                            b2 = 88;
                        }
                        break;
                    case 2464648:
                        if (!str2.equals("Q427")) {
                            b2 = -1;
                        } else {
                            b2 = 90;
                        }
                        break;
                    case 2689555:
                        if (!str2.equals("XE2X")) {
                            b2 = -1;
                        } else {
                            b2 = 114;
                        }
                        break;
                    case 3351335:
                        if (!str2.equals("mido")) {
                            b2 = -1;
                        } else {
                            b2 = 65;
                        }
                        break;
                    case 3386211:
                        if (!str2.equals("p212")) {
                            b2 = -1;
                        } else {
                            b2 = 72;
                        }
                        break;
                    case 41325051:
                        if (!str2.equals("MEIZU_M5")) {
                            b2 = -1;
                        } else {
                            b2 = 63;
                        }
                        break;
                    case 55178625:
                        if (!str2.equals("Aura_Note_2")) {
                            b2 = -1;
                        } else {
                            b2 = Ascii.VT;
                        }
                        break;
                    case 61542055:
                        if (!str2.equals("A1601")) {
                            b2 = -1;
                        } else {
                            b2 = 4;
                        }
                        break;
                    case 65355429:
                        if (!str2.equals("E5643")) {
                            b2 = -1;
                        } else {
                            b2 = Ascii.SYN;
                        }
                        break;
                    case 66214468:
                        if (!str2.equals("F3111")) {
                            b2 = -1;
                        } else {
                            b2 = Ascii.FS;
                        }
                        break;
                    case 66214470:
                        if (!str2.equals("F3113")) {
                            b2 = -1;
                        } else {
                            b2 = Ascii.GS;
                        }
                        break;
                    case 66214473:
                        if (!str2.equals("F3116")) {
                            b2 = -1;
                        } else {
                            b2 = Ascii.RS;
                        }
                        break;
                    case 66215429:
                        if (!str2.equals("F3211")) {
                            b2 = -1;
                        } else {
                            b2 = Ascii.US;
                        }
                        break;
                    case 66215431:
                        if (!str2.equals("F3213")) {
                            b2 = -1;
                        } else {
                            b2 = 32;
                        }
                        break;
                    case 66215433:
                        if (!str2.equals("F3215")) {
                            b2 = -1;
                        } else {
                            b2 = 33;
                        }
                        break;
                    case 66216390:
                        if (!str2.equals("F3311")) {
                            b2 = -1;
                        } else {
                            b2 = 34;
                        }
                        break;
                    case 76402249:
                        if (!str2.equals("PRO7S")) {
                            b2 = -1;
                        } else {
                            b2 = 87;
                        }
                        break;
                    case 76404105:
                        if (!str2.equals("Q4260")) {
                            b2 = -1;
                        } else {
                            b2 = 89;
                        }
                        break;
                    case 76404911:
                        if (!str2.equals("Q4310")) {
                            b2 = -1;
                        } else {
                            b2 = 91;
                        }
                        break;
                    case 80963634:
                        if (!str2.equals("V23GB")) {
                            b2 = -1;
                        } else {
                            b2 = 106;
                        }
                        break;
                    case 82882791:
                        if (!str2.equals("X3_HK")) {
                            b2 = -1;
                        } else {
                            b2 = 113;
                        }
                        break;
                    case 102844228:
                        if (!str2.equals("le_x6")) {
                            b2 = -1;
                        } else {
                            b2 = 58;
                        }
                        break;
                    case 165221241:
                        if (!str2.equals("A2016a40")) {
                            b2 = -1;
                        } else {
                            b2 = 5;
                        }
                        break;
                    case 182191441:
                        if (!str2.equals("CPY83_I00")) {
                            b2 = -1;
                        } else {
                            b2 = Ascii.DC2;
                        }
                        break;
                    case 245388979:
                        if (!str2.equals("marino_f")) {
                            b2 = -1;
                        } else {
                            b2 = 62;
                        }
                        break;
                    case 287431619:
                        if (!str2.equals("griffin")) {
                            b2 = -1;
                        } else {
                            b2 = 45;
                        }
                        break;
                    case 307593612:
                        if (!str2.equals("A7010a48")) {
                            b2 = -1;
                        } else {
                            b2 = 8;
                        }
                        break;
                    case 308517133:
                        if (!str2.equals("A7020a48")) {
                            b2 = -1;
                        } else {
                            b2 = 9;
                        }
                        break;
                    case 316215098:
                        if (!str2.equals("TB3-730F")) {
                            b2 = -1;
                        } else {
                            b2 = 100;
                        }
                        break;
                    case 316215116:
                        if (!str2.equals("TB3-730X")) {
                            b2 = -1;
                        } else {
                            b2 = 101;
                        }
                        break;
                    case 316246811:
                        if (!str2.equals("TB3-850F")) {
                            b2 = -1;
                        } else {
                            b2 = 102;
                        }
                        break;
                    case 316246818:
                        if (!str2.equals("TB3-850M")) {
                            b2 = -1;
                        } else {
                            b2 = 103;
                        }
                        break;
                    case 407160593:
                        if (!str2.equals("Pixi5-10_4G")) {
                            b2 = -1;
                        } else {
                            b2 = 85;
                        }
                        break;
                    case 507412548:
                        if (!str2.equals("QM16XE_U")) {
                            b2 = -1;
                        } else {
                            b2 = 93;
                        }
                        break;
                    case 793982701:
                        if (!str2.equals("GIONEE_WBL5708")) {
                            b2 = -1;
                        } else {
                            b2 = 42;
                        }
                        break;
                    case 794038622:
                        if (!str2.equals("GIONEE_WBL7365")) {
                            b2 = -1;
                        } else {
                            b2 = 43;
                        }
                        break;
                    case 794040393:
                        if (!str2.equals("GIONEE_WBL7519")) {
                            b2 = -1;
                        } else {
                            b2 = 44;
                        }
                        break;
                    case 835649806:
                        if (!str2.equals("manning")) {
                            b2 = -1;
                        } else {
                            b2 = Base64.padSymbol;
                        }
                        break;
                    case 917340916:
                        if (!str2.equals("A7000plus")) {
                            b2 = -1;
                        } else {
                            b2 = 7;
                        }
                        break;
                    case 958008161:
                        if (!str2.equals("j2xlteins")) {
                            b2 = -1;
                        } else {
                            b2 = 55;
                        }
                        break;
                    case 1060579533:
                        if (!str2.equals("panell_d")) {
                            b2 = -1;
                        } else {
                            b2 = 75;
                        }
                        break;
                    case 1150207623:
                        if (!str2.equals("LS-5017")) {
                            b2 = -1;
                        } else {
                            b2 = 59;
                        }
                        break;
                    case 1176899427:
                        if (!str2.equals("itel_S41")) {
                            b2 = -1;
                        } else {
                            b2 = 54;
                        }
                        break;
                    case 1280332038:
                        if (!str2.equals("hwALE-H")) {
                            b2 = -1;
                        } else {
                            b2 = 47;
                        }
                        break;
                    case 1306947716:
                        if (!str2.equals("EverStar_S")) {
                            b2 = -1;
                        }
                        break;
                    case 1349174697:
                        if (!str2.equals("htc_e56ml_dtul")) {
                            b2 = -1;
                        } else {
                            b2 = 46;
                        }
                        break;
                    case 1522194893:
                        if (!str2.equals("woods_f")) {
                            b2 = -1;
                        } else {
                            b2 = 111;
                        }
                        break;
                    case 1691543273:
                        if (!str2.equals("CPH1609")) {
                            b2 = -1;
                        } else {
                            b2 = 17;
                        }
                        break;
                    case 1709443163:
                        if (!str2.equals("iball8735_9806")) {
                            b2 = -1;
                        } else {
                            b2 = 51;
                        }
                        break;
                    case 1865889110:
                        if (!str2.equals("santoni")) {
                            b2 = -1;
                        } else {
                            b2 = 95;
                        }
                        break;
                    case 1906253259:
                        if (!str2.equals("PB2-670M")) {
                            b2 = -1;
                        } else {
                            b2 = 79;
                        }
                        break;
                    case 1977196784:
                        if (!str2.equals("Infinix-X572")) {
                            b2 = -1;
                        } else {
                            b2 = 52;
                        }
                        break;
                    case 2029784656:
                        if (!str2.equals("HWBLN-H")) {
                            b2 = -1;
                        } else {
                            b2 = 48;
                        }
                        break;
                    case 2030379515:
                        if (!str2.equals("HWCAM-H")) {
                            b2 = -1;
                        } else {
                            b2 = 49;
                        }
                        break;
                    case 2047190025:
                        if (!str2.equals("ELUGA_Note")) {
                            b2 = -1;
                        } else {
                            b2 = Ascii.CAN;
                        }
                        break;
                    case 2047252157:
                        if (!str2.equals("ELUGA_Prim")) {
                            b2 = -1;
                        } else {
                            b2 = Ascii.EM;
                        }
                        break;
                    case 2048319463:
                        if (!str2.equals("HWVNS-H")) {
                            b2 = -1;
                        } else {
                            b2 = 50;
                        }
                        break;
                    default:
                        b2 = -1;
                        break;
                }
                switch (b2) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                    case 14:
                    case 15:
                    case 16:
                    case 17:
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                    case 30:
                    case 31:
                    case 32:
                    case 33:
                    case 34:
                    case 35:
                    case 36:
                    case 37:
                    case 38:
                    case 39:
                    case 40:
                    case 41:
                    case 42:
                    case 43:
                    case 44:
                    case 45:
                    case 46:
                    case 47:
                    case 48:
                    case 49:
                    case 50:
                    case 51:
                    case 52:
                    case 53:
                    case 54:
                    case 55:
                    case 56:
                    case 57:
                    case TokenParametersOuterClass$TokenParameters.LASTADVERTISEDBUNDLES_FIELD_NUMBER /* 58 */:
                    case TokenParametersOuterClass$TokenParameters.PRIORCLICKS_FIELD_NUMBER /* 59 */:
                    case 60:
                    case 61:
                    case 62:
                    case 63:
                    case 64:
                    case 65:
                    case 66:
                    case 67:
                    case TokenParametersOuterClass$TokenParameters.IGNITEPACKAGENAME_FIELD_NUMBER /* 68 */:
                    case TokenParametersOuterClass$TokenParameters.CHILDMODE_FIELD_NUMBER /* 69 */:
                    case 70:
                    case 71:
                    case 72:
                    case 73:
                    case 74:
                    case 75:
                    case 76:
                    case 77:
                    case 78:
                    case 79:
                    case 80:
                    case IronSourceConstants.TROUBLESHOOTING_AD_QUALITY_SDK_INITIALIZED_SUCCESSFULLY_EVENT /* 81 */:
                    case IronSourceConstants.TROUBLESHOOTING_AD_QUALITY_SDK_WAS_ALREADY_INITIALIZED_EVENT /* 82 */:
                    case IronSourceConstants.TROUBLESHOOTING_AD_QUALITY_SDK_FAILED_TO_INITIALIZE_EVENT /* 83 */:
                    case IronSourceConstants.TROUBLESHOOTING_AD_QUALITY_SDK_NOT_EXIST /* 84 */:
                    case 85:
                    case 86:
                    case 87:
                    case 88:
                    case 89:
                    case 90:
                    case 91:
                    case 92:
                    case 93:
                    case 94:
                    case 95:
                    case 96:
                    case 97:
                    case 98:
                    case 99:
                    case 100:
                    case 101:
                    case 102:
                    case 103:
                    case 104:
                    case 105:
                    case 106:
                    case 107:
                    case 108:
                    case 109:
                    case 110:
                    case 111:
                    case 112:
                    case 113:
                    case 114:
                    case 115:
                    case 116:
                    case 117:
                        deviceNeedsSetOutputSurfaceWorkaround = true;
                        break;
                }
                String str3 = Util.MODEL;
                int iHashCode = str3.hashCode();
                if (iHashCode != 2006354) {
                    if (iHashCode == 2006367 && str3.equals("AFTN")) {
                        b = 1;
                    } else {
                        b = -1;
                    }
                } else if (!str3.equals("AFTA")) {
                    b = -1;
                }
                if (b == 0 || b == 1) {
                    deviceNeedsSetOutputSurfaceWorkaround = true;
                }
                evaluatedDeviceNeedsSetOutputSurfaceWorkaround = true;
            }
        }
        return deviceNeedsSetOutputSurfaceWorkaround;
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.mediacodec.MediaCodecRenderer
    protected void configureCodec(MediaCodecInfo mediaCodecInfo, MediaCodec mediaCodec, Format format, MediaCrypto mediaCrypto) throws MediaCodecUtil.DecoderQueryException {
        CodecMaxValues codecMaxValues = getCodecMaxValues(mediaCodecInfo, format, getStreamFormats());
        this.codecMaxValues = codecMaxValues;
        MediaFormat mediaFormat = getMediaFormat(format, codecMaxValues, this.deviceNeedsAutoFrcWorkaround, this.tunnelingAudioSessionId);
        if (this.surface == null) {
            Assertions.checkState(shouldUseDummySurface(mediaCodecInfo));
            if (this.dummySurface == null) {
                this.dummySurface = DummySurface.newInstanceV17(this.context, mediaCodecInfo.secure);
            }
            this.surface = this.dummySurface;
        }
        mediaCodec.configure(mediaFormat, this.surface, mediaCrypto, 0);
        if (Util.SDK_INT < 23 || !this.tunneling) {
            return;
        }
        this.tunnelingOnFrameRenderedListener = new OnFrameRenderedListenerV23(mediaCodec);
    }

    protected void dropOutputBuffer(MediaCodec mediaCodec, int i, long j) {
        TraceUtil.beginSection("dropVideoBuffer");
        mediaCodec.releaseOutputBuffer(i, false);
        TraceUtil.endSection();
        updateDroppedBufferCounters(1);
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.mediacodec.MediaCodecRenderer
    protected void flushCodec() throws ExoPlaybackException {
        super.flushCodec();
        this.buffersInCodecCount = 0;
    }

    protected CodecMaxValues getCodecMaxValues(MediaCodecInfo mediaCodecInfo, Format format, Format[] formatArr) throws MediaCodecUtil.DecoderQueryException {
        int iMax = format.width;
        int iMax2 = format.height;
        int maxInputSize = getMaxInputSize(mediaCodecInfo, format);
        if (formatArr.length == 1) {
            return new CodecMaxValues(iMax, iMax2, maxInputSize);
        }
        boolean z = false;
        for (Format format2 : formatArr) {
            if (areAdaptationCompatible(mediaCodecInfo.adaptive, format, format2)) {
                int i = format2.width;
                z |= i == -1 || format2.height == -1;
                iMax = Math.max(iMax, i);
                iMax2 = Math.max(iMax2, format2.height);
                maxInputSize = Math.max(maxInputSize, getMaxInputSize(mediaCodecInfo, format2));
            }
        }
        if (z) {
            Log.w(TAG, "Resolutions unknown. Codec max resolution: " + iMax + VastAttributes.HORIZONTAL_POSITION + iMax2);
            Point codecMaxSize = getCodecMaxSize(mediaCodecInfo, format);
            if (codecMaxSize != null) {
                iMax = Math.max(iMax, codecMaxSize.x);
                iMax2 = Math.max(iMax2, codecMaxSize.y);
                maxInputSize = Math.max(maxInputSize, getMaxInputSize(mediaCodecInfo, format.sampleMimeType, iMax, iMax2));
                Log.w(TAG, "Codec max resolution adjusted to: " + iMax + VastAttributes.HORIZONTAL_POSITION + iMax2);
            }
        }
        return new CodecMaxValues(iMax, iMax2, maxInputSize);
    }

    protected MediaFormat getMediaFormat(Format format, CodecMaxValues codecMaxValues, boolean z, int i) {
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", format.sampleMimeType);
        mediaFormat.setInteger("width", format.width);
        mediaFormat.setInteger("height", format.height);
        MediaFormatUtil.setCsdBuffers(mediaFormat, format.initializationData);
        MediaFormatUtil.maybeSetFloat(mediaFormat, "frame-rate", format.frameRate);
        MediaFormatUtil.maybeSetInteger(mediaFormat, "rotation-degrees", format.rotationDegrees);
        MediaFormatUtil.maybeSetColorInfo(mediaFormat, format.colorInfo);
        mediaFormat.setInteger("max-width", codecMaxValues.width);
        mediaFormat.setInteger("max-height", codecMaxValues.height);
        MediaFormatUtil.maybeSetInteger(mediaFormat, "max-input-size", codecMaxValues.inputSize);
        if (Util.SDK_INT >= 23) {
            mediaFormat.setInteger(HandleInvocationsFromAdViewer.KEY_DOWNLOAD_PRIORITY, 0);
        }
        if (z) {
            mediaFormat.setInteger("auto-frc", 0);
        }
        if (i != 0) {
            configureTunnelingV21(mediaFormat, i);
        }
        return mediaFormat;
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.BaseRenderer, com.mbridge.msdk.playercommon.exoplayer2.PlayerMessage.Target
    public void handleMessage(int i, Object obj) throws ExoPlaybackException {
        if (i == 1) {
            setSurface((Surface) obj);
            return;
        }
        if (i != 4) {
            super.handleMessage(i, obj);
            return;
        }
        this.scalingMode = ((Integer) obj).intValue();
        MediaCodec codec = getCodec();
        if (codec != null) {
            codec.setVideoScalingMode(this.scalingMode);
        }
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.mediacodec.MediaCodecRenderer, com.mbridge.msdk.playercommon.exoplayer2.Renderer
    public boolean isReady() {
        Surface surface;
        if (super.isReady() && (this.renderedFirstFrame || (((surface = this.dummySurface) != null && this.surface == surface) || getCodec() == null || this.tunneling))) {
            this.joiningDeadlineMs = -9223372036854775807L;
            return true;
        }
        if (this.joiningDeadlineMs == -9223372036854775807L) {
            return false;
        }
        if (SystemClock.elapsedRealtime() < this.joiningDeadlineMs) {
            return true;
        }
        this.joiningDeadlineMs = -9223372036854775807L;
        return false;
    }

    protected boolean maybeDropBuffersToKeyframe(MediaCodec mediaCodec, int i, long j, long j2) throws ExoPlaybackException {
        int iSkipSource = skipSource(j2);
        if (iSkipSource == 0) {
            return false;
        }
        this.decoderCounters.droppedToKeyframeCount++;
        updateDroppedBufferCounters(this.buffersInCodecCount + iSkipSource);
        flushCodec();
        return true;
    }

    void maybeNotifyRenderedFirstFrame() {
        if (this.renderedFirstFrame) {
            return;
        }
        this.renderedFirstFrame = true;
        this.eventDispatcher.renderedFirstFrame(this.surface);
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.mediacodec.MediaCodecRenderer
    protected void onCodecInitialized(String str, long j, long j2) {
        this.eventDispatcher.decoderInitialized(str, j, j2);
        this.codecNeedsSetOutputSurfaceWorkaround = codecNeedsSetOutputSurfaceWorkaround(str);
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.mediacodec.MediaCodecRenderer, com.mbridge.msdk.playercommon.exoplayer2.BaseRenderer
    protected void onDisabled() {
        this.currentWidth = -1;
        this.currentHeight = -1;
        this.currentPixelWidthHeightRatio = -1.0f;
        this.pendingPixelWidthHeightRatio = -1.0f;
        this.outputStreamOffsetUs = -9223372036854775807L;
        this.lastInputTimeUs = -9223372036854775807L;
        this.pendingOutputStreamOffsetCount = 0;
        clearReportedVideoSize();
        clearRenderedFirstFrame();
        this.frameReleaseTimeHelper.disable();
        this.tunnelingOnFrameRenderedListener = null;
        this.tunneling = false;
        try {
            super.onDisabled();
        } finally {
            this.decoderCounters.ensureUpdated();
            this.eventDispatcher.disabled(this.decoderCounters);
        }
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.mediacodec.MediaCodecRenderer, com.mbridge.msdk.playercommon.exoplayer2.BaseRenderer
    protected void onEnabled(boolean z) throws ExoPlaybackException {
        super.onEnabled(z);
        int i = getConfiguration().tunnelingAudioSessionId;
        this.tunnelingAudioSessionId = i;
        this.tunneling = i != 0;
        this.eventDispatcher.enabled(this.decoderCounters);
        this.frameReleaseTimeHelper.enable();
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.mediacodec.MediaCodecRenderer
    protected void onInputFormatChanged(Format format) throws ExoPlaybackException {
        super.onInputFormatChanged(format);
        this.eventDispatcher.inputFormatChanged(format);
        this.pendingPixelWidthHeightRatio = format.pixelWidthHeightRatio;
        this.pendingRotationDegrees = format.rotationDegrees;
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.mediacodec.MediaCodecRenderer
    protected void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        boolean z = mediaFormat.containsKey(KEY_CROP_RIGHT) && mediaFormat.containsKey(KEY_CROP_LEFT) && mediaFormat.containsKey(KEY_CROP_BOTTOM) && mediaFormat.containsKey(KEY_CROP_TOP);
        this.currentWidth = z ? (mediaFormat.getInteger(KEY_CROP_RIGHT) - mediaFormat.getInteger(KEY_CROP_LEFT)) + 1 : mediaFormat.getInteger("width");
        int integer = z ? (mediaFormat.getInteger(KEY_CROP_BOTTOM) - mediaFormat.getInteger(KEY_CROP_TOP)) + 1 : mediaFormat.getInteger("height");
        this.currentHeight = integer;
        float f = this.pendingPixelWidthHeightRatio;
        this.currentPixelWidthHeightRatio = f;
        if (Util.SDK_INT >= 21) {
            int i = this.pendingRotationDegrees;
            if (i == 90 || i == 270) {
                int i2 = this.currentWidth;
                this.currentWidth = integer;
                this.currentHeight = i2;
                this.currentPixelWidthHeightRatio = 1.0f / f;
            }
        } else {
            this.currentUnappliedRotationDegrees = this.pendingRotationDegrees;
        }
        mediaCodec.setVideoScalingMode(this.scalingMode);
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.mediacodec.MediaCodecRenderer, com.mbridge.msdk.playercommon.exoplayer2.BaseRenderer
    protected void onPositionReset(long j, boolean z) throws ExoPlaybackException {
        super.onPositionReset(j, z);
        clearRenderedFirstFrame();
        this.initialPositionUs = -9223372036854775807L;
        this.consecutiveDroppedFrameCount = 0;
        this.lastInputTimeUs = -9223372036854775807L;
        int i = this.pendingOutputStreamOffsetCount;
        if (i != 0) {
            this.outputStreamOffsetUs = this.pendingOutputStreamOffsetsUs[i - 1];
            this.pendingOutputStreamOffsetCount = 0;
        }
        if (z) {
            setJoiningDeadlineMs();
        } else {
            this.joiningDeadlineMs = -9223372036854775807L;
        }
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.mediacodec.MediaCodecRenderer
    protected void onProcessedOutputBuffer(long j) {
        this.buffersInCodecCount--;
        while (true) {
            int i = this.pendingOutputStreamOffsetCount;
            if (i == 0 || j < this.pendingOutputStreamSwitchTimesUs[0]) {
                return;
            }
            long[] jArr = this.pendingOutputStreamOffsetsUs;
            this.outputStreamOffsetUs = jArr[0];
            int i2 = i - 1;
            this.pendingOutputStreamOffsetCount = i2;
            System.arraycopy(jArr, 1, jArr, 0, i2);
            long[] jArr2 = this.pendingOutputStreamSwitchTimesUs;
            System.arraycopy(jArr2, 1, jArr2, 0, this.pendingOutputStreamOffsetCount);
        }
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.mediacodec.MediaCodecRenderer
    protected void onQueueInputBuffer(DecoderInputBuffer decoderInputBuffer) {
        this.buffersInCodecCount++;
        this.lastInputTimeUs = Math.max(decoderInputBuffer.timeUs, this.lastInputTimeUs);
        if (Util.SDK_INT >= 23 || !this.tunneling) {
            return;
        }
        maybeNotifyRenderedFirstFrame();
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.mediacodec.MediaCodecRenderer, com.mbridge.msdk.playercommon.exoplayer2.BaseRenderer
    protected void onStarted() {
        super.onStarted();
        this.droppedFrames = 0;
        this.droppedFrameAccumulationStartTimeMs = SystemClock.elapsedRealtime();
        this.lastRenderTimeUs = SystemClock.elapsedRealtime() * 1000;
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.mediacodec.MediaCodecRenderer, com.mbridge.msdk.playercommon.exoplayer2.BaseRenderer
    protected void onStopped() {
        this.joiningDeadlineMs = -9223372036854775807L;
        maybeNotifyDroppedFrames();
        super.onStopped();
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.BaseRenderer
    protected void onStreamChanged(Format[] formatArr, long j) throws ExoPlaybackException {
        if (this.outputStreamOffsetUs == -9223372036854775807L) {
            this.outputStreamOffsetUs = j;
        } else {
            int i = this.pendingOutputStreamOffsetCount;
            if (i == this.pendingOutputStreamOffsetsUs.length) {
                Log.w(TAG, "Too many stream changes, so dropping offset: " + this.pendingOutputStreamOffsetsUs[this.pendingOutputStreamOffsetCount - 1]);
            } else {
                this.pendingOutputStreamOffsetCount = i + 1;
            }
            long[] jArr = this.pendingOutputStreamOffsetsUs;
            int i2 = this.pendingOutputStreamOffsetCount - 1;
            jArr[i2] = j;
            this.pendingOutputStreamSwitchTimesUs[i2] = this.lastInputTimeUs;
        }
        super.onStreamChanged(formatArr, j);
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.mediacodec.MediaCodecRenderer
    protected boolean processOutputBuffer(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z) throws ExoPlaybackException {
        if (this.initialPositionUs == -9223372036854775807L) {
            this.initialPositionUs = j;
        }
        long j4 = j3 - this.outputStreamOffsetUs;
        if (z) {
            skipOutputBuffer(mediaCodec, i, j4);
            return true;
        }
        long j5 = j3 - j;
        if (this.surface == this.dummySurface) {
            if (!isBufferLate(j5)) {
                return false;
            }
            skipOutputBuffer(mediaCodec, i, j4);
            return true;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime() * 1000;
        boolean z2 = getState() == 2;
        if (!this.renderedFirstFrame || (z2 && shouldForceRenderOutputBuffer(j5, jElapsedRealtime - this.lastRenderTimeUs))) {
            if (Util.SDK_INT >= 21) {
                renderOutputBufferV21(mediaCodec, i, j4, System.nanoTime());
                return true;
            }
            renderOutputBuffer(mediaCodec, i, j4);
            return true;
        }
        if (z2 && j != this.initialPositionUs) {
            long jNanoTime = System.nanoTime();
            long jAdjustReleaseTime = this.frameReleaseTimeHelper.adjustReleaseTime(j3, ((j5 - (jElapsedRealtime - j2)) * 1000) + jNanoTime);
            long j6 = (jAdjustReleaseTime - jNanoTime) / 1000;
            if (shouldDropBuffersToKeyframe(j6, j2) && maybeDropBuffersToKeyframe(mediaCodec, i, j4, j)) {
                return false;
            }
            if (shouldDropOutputBuffer(j6, j2)) {
                dropOutputBuffer(mediaCodec, i, j4);
                return true;
            }
            if (Util.SDK_INT >= 21) {
                if (j6 < ServiceProvider.SCAR_SIGNALS_FETCH_TIMEOUT) {
                    renderOutputBufferV21(mediaCodec, i, j4, jAdjustReleaseTime);
                    return true;
                }
            } else if (j6 < 30000) {
                if (j6 > 11000) {
                    try {
                        Thread.sleep((j6 - 10000) / 1000);
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                        return false;
                    }
                }
                renderOutputBuffer(mediaCodec, i, j4);
                return true;
            }
        }
        return false;
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.mediacodec.MediaCodecRenderer
    protected void releaseCodec() {
        Surface surface;
        try {
            super.releaseCodec();
            this.buffersInCodecCount = 0;
            surface = this.dummySurface;
            if (surface != null) {
                if (this.surface == surface) {
                    this.surface = null;
                }
            }
        } finally {
            this.buffersInCodecCount = 0;
            if (this.dummySurface != null) {
                Surface surface2 = this.surface;
                surface = this.dummySurface;
                if (surface2 == surface) {
                    this.surface = null;
                }
                surface.release();
                this.dummySurface = null;
            }
        }
    }

    protected void renderOutputBuffer(MediaCodec mediaCodec, int i, long j) {
        maybeNotifyVideoSizeChanged();
        TraceUtil.beginSection("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i, true);
        TraceUtil.endSection();
        this.lastRenderTimeUs = SystemClock.elapsedRealtime() * 1000;
        this.decoderCounters.renderedOutputBufferCount++;
        this.consecutiveDroppedFrameCount = 0;
        maybeNotifyRenderedFirstFrame();
    }

    protected void renderOutputBufferV21(MediaCodec mediaCodec, int i, long j, long j2) {
        maybeNotifyVideoSizeChanged();
        TraceUtil.beginSection("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i, j2);
        TraceUtil.endSection();
        this.lastRenderTimeUs = SystemClock.elapsedRealtime() * 1000;
        this.decoderCounters.renderedOutputBufferCount++;
        this.consecutiveDroppedFrameCount = 0;
        maybeNotifyRenderedFirstFrame();
    }

    protected boolean shouldDropBuffersToKeyframe(long j, long j2) {
        return isBufferVeryLate(j);
    }

    protected boolean shouldDropOutputBuffer(long j, long j2) {
        return isBufferLate(j);
    }

    protected boolean shouldForceRenderOutputBuffer(long j, long j2) {
        return isBufferLate(j) && j2 > 100000;
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.mediacodec.MediaCodecRenderer
    protected boolean shouldInitCodec(MediaCodecInfo mediaCodecInfo) {
        return this.surface != null || shouldUseDummySurface(mediaCodecInfo);
    }

    protected void skipOutputBuffer(MediaCodec mediaCodec, int i, long j) {
        TraceUtil.beginSection("skipVideoBuffer");
        mediaCodec.releaseOutputBuffer(i, false);
        TraceUtil.endSection();
        this.decoderCounters.skippedOutputBufferCount++;
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.mediacodec.MediaCodecRenderer
    protected int supportsFormat(MediaCodecSelector mediaCodecSelector, DrmSessionManager<FrameworkMediaCrypto> drmSessionManager, Format format) throws MediaCodecUtil.DecoderQueryException {
        boolean z;
        int i;
        int i2;
        String str = format.sampleMimeType;
        if (!MimeTypes.isVideo(str)) {
            return 0;
        }
        DrmInitData drmInitData = format.drmInitData;
        if (drmInitData != null) {
            z = false;
            for (int i3 = 0; i3 < drmInitData.schemeDataCount; i3++) {
                z |= drmInitData.get(i3).requiresSecureDecryption;
            }
        } else {
            z = false;
        }
        MediaCodecInfo decoderInfo = mediaCodecSelector.getDecoderInfo(str, z);
        if (decoderInfo == null) {
            return (!z || mediaCodecSelector.getDecoderInfo(str, false) == null) ? 1 : 2;
        }
        if (!BaseRenderer.supportsFormatDrm(drmSessionManager, drmInitData)) {
            return 2;
        }
        boolean zIsCodecSupported = decoderInfo.isCodecSupported(format.codecs);
        if (zIsCodecSupported && (i = format.width) > 0 && (i2 = format.height) > 0) {
            if (Util.SDK_INT >= 21) {
                zIsCodecSupported = decoderInfo.isVideoSizeAndRateSupportedV21(i, i2, format.frameRate);
            } else {
                boolean z2 = i * i2 <= MediaCodecUtil.maxH264DecodableFrameSize();
                if (!z2) {
                    Log.d(TAG, "FalseCheck [legacyFrameSize, " + format.width + VastAttributes.HORIZONTAL_POSITION + format.height + "] [" + Util.DEVICE_DEBUG_INFO + b9.i.e);
                }
                zIsCodecSupported = z2;
            }
        }
        return (zIsCodecSupported ? 4 : 3) | (decoderInfo.adaptive ? 16 : 8) | (decoderInfo.tunneling ? 32 : 0);
    }

    protected void updateDroppedBufferCounters(int i) {
        DecoderCounters decoderCounters = this.decoderCounters;
        decoderCounters.droppedBufferCount += i;
        this.droppedFrames += i;
        int i2 = this.consecutiveDroppedFrameCount + i;
        this.consecutiveDroppedFrameCount = i2;
        decoderCounters.maxConsecutiveDroppedBufferCount = Math.max(i2, decoderCounters.maxConsecutiveDroppedBufferCount);
        if (this.droppedFrames >= this.maxDroppedFramesToNotify) {
            maybeNotifyDroppedFrames();
        }
    }

    public MediaCodecVideoRenderer(Context context, MediaCodecSelector mediaCodecSelector, long j) {
        this(context, mediaCodecSelector, j, null, null, -1);
    }

    public MediaCodecVideoRenderer(Context context, MediaCodecSelector mediaCodecSelector, long j, Handler handler, VideoRendererEventListener videoRendererEventListener, int i) {
        this(context, mediaCodecSelector, j, null, false, handler, videoRendererEventListener, i);
    }

    public MediaCodecVideoRenderer(Context context, MediaCodecSelector mediaCodecSelector, long j, DrmSessionManager<FrameworkMediaCrypto> drmSessionManager, boolean z, Handler handler, VideoRendererEventListener videoRendererEventListener, int i) {
        super(2, mediaCodecSelector, drmSessionManager, z);
        this.allowedJoiningTimeMs = j;
        this.maxDroppedFramesToNotify = i;
        Context applicationContext = context.getApplicationContext();
        this.context = applicationContext;
        this.frameReleaseTimeHelper = new VideoFrameReleaseTimeHelper(applicationContext);
        this.eventDispatcher = new VideoRendererEventListener.EventDispatcher(handler, videoRendererEventListener);
        this.deviceNeedsAutoFrcWorkaround = deviceNeedsAutoFrcWorkaround();
        this.pendingOutputStreamOffsetsUs = new long[10];
        this.pendingOutputStreamSwitchTimesUs = new long[10];
        this.outputStreamOffsetUs = -9223372036854775807L;
        this.lastInputTimeUs = -9223372036854775807L;
        this.joiningDeadlineMs = -9223372036854775807L;
        this.currentWidth = -1;
        this.currentHeight = -1;
        this.currentPixelWidthHeightRatio = -1.0f;
        this.pendingPixelWidthHeightRatio = -1.0f;
        this.scalingMode = 1;
        clearReportedVideoSize();
    }

    private static int getMaxInputSize(MediaCodecInfo mediaCodecInfo, String str, int i, int i2) {
        int iCeilDivide;
        if (i == -1 || i2 == -1) {
            return -1;
        }
        str.hashCode();
        str.hashCode();
        int i3 = 4;
        switch (str) {
            case "video/3gpp":
            case "video/mp4v-es":
            case "video/x-vnd.on2.vp8":
                iCeilDivide = i * i2;
                i3 = 2;
                return (iCeilDivide * 3) / (i3 * 2);
            case "video/hevc":
            case "video/x-vnd.on2.vp9":
                iCeilDivide = i * i2;
                return (iCeilDivide * 3) / (i3 * 2);
            case "video/avc":
                String str2 = Util.MODEL;
                if ("BRAVIA 4K 2015".equals(str2) || ("Amazon".equals(Util.MANUFACTURER) && ("KFSOWI".equals(str2) || ("AFTS".equals(str2) && mediaCodecInfo.secure)))) {
                    return -1;
                }
                iCeilDivide = Util.ceilDivide(i, 16) * Util.ceilDivide(i2, 16) * 256;
                i3 = 2;
                return (iCeilDivide * 3) / (i3 * 2);
            default:
                return -1;
        }
    }
}
