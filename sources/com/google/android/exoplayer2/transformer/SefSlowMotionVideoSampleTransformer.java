package com.google.android.exoplayer2.transformer;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.mp4.SlowMotionData;
import com.google.android.exoplayer2.metadata.mp4.SmtaMetadataEntry;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.Ascii;
import com.google.common.collect.ImmutableList;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Iterator;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: loaded from: classes6.dex */
final class SefSlowMotionVideoSampleTransformer implements SampleTransformer {
    static final int INPUT_FRAME_RATE = 30;
    private static final int NAL_START_CODE_LENGTH = NalUnitUtil.NAL_START_CODE.length;
    private static final int NAL_UNIT_TYPE_PREFIX = 14;
    private static final int TARGET_OUTPUT_FRAME_RATE = 30;
    private final float captureFrameRate;
    private SegmentInfo currentSegmentInfo;
    private long frameTimeDeltaUs;
    private final int inputMaxLayer;
    private SegmentInfo nextSegmentInfo;
    private final int normalSpeedMaxLayer;
    private final byte[] scratch = new byte[NAL_START_CODE_LENGTH];
    private final Iterator<SlowMotionData.Segment> segmentIterator;
    private final SlowMotionData slowMotionData;

    private static final class MetadataInfo {
        public float captureFrameRate = -3.4028235E38f;
        public int inputMaxLayer = -1;
        public int normalSpeedMaxLayer = -1;
        public SlowMotionData slowMotionData;
    }

    public SefSlowMotionVideoSampleTransformer(Format format) {
        MetadataInfo metadataInfo = getMetadataInfo(format.metadata);
        SlowMotionData slowMotionData = metadataInfo.slowMotionData;
        this.slowMotionData = slowMotionData;
        Iterator<SlowMotionData.Segment> it = (slowMotionData != null ? slowMotionData.segments : ImmutableList.of()).iterator();
        this.segmentIterator = it;
        this.captureFrameRate = metadataInfo.captureFrameRate;
        int i = metadataInfo.inputMaxLayer;
        this.inputMaxLayer = i;
        int i2 = metadataInfo.normalSpeedMaxLayer;
        this.normalSpeedMaxLayer = i2;
        this.nextSegmentInfo = it.hasNext() ? new SegmentInfo(it.next(), i, i2) : null;
        if (slowMotionData != null) {
            boolean zEquals = "video/avc".equals(format.sampleMimeType);
            String strValueOf = String.valueOf(format.sampleMimeType);
            Assertions.checkArgument(zEquals, strValueOf.length() != 0 ? "Unsupported MIME type for SEF slow motion video track: ".concat(strValueOf) : new String("Unsupported MIME type for SEF slow motion video track: "));
        }
    }

    @Override // com.google.android.exoplayer2.transformer.SampleTransformer
    public void transformSample(DecoderInputBuffer decoderInputBuffer) {
        if (this.slowMotionData == null) {
            return;
        }
        ByteBuffer byteBuffer = (ByteBuffer) Util.castNonNull(decoderInputBuffer.data);
        byteBuffer.position(byteBuffer.position() + NAL_START_CODE_LENGTH);
        boolean z = false;
        byteBuffer.get(this.scratch, 0, 4);
        byte[] bArr = this.scratch;
        int i = bArr[0] & Ascii.US;
        boolean z2 = ((bArr[1] & 255) >> 7) == 1;
        if (i == 14 && z2) {
            z = true;
        }
        Assertions.checkState(z, "Missing SVC extension prefix NAL unit.");
        if (processCurrentFrame((this.scratch[3] & 255) >> 5, decoderInputBuffer.timeUs)) {
            decoderInputBuffer.timeUs = getCurrentFrameOutputTimeUs(decoderInputBuffer.timeUs);
            skipToNextNalUnit(byteBuffer);
        } else {
            decoderInputBuffer.data = null;
        }
    }

    boolean processCurrentFrame(int i, long j) {
        while (true) {
            SegmentInfo segmentInfo = this.nextSegmentInfo;
            if (segmentInfo == null || j < segmentInfo.endTimeUs) {
                break;
            }
            enterNextSegment();
        }
        SegmentInfo segmentInfo2 = this.nextSegmentInfo;
        if (segmentInfo2 != null && j >= segmentInfo2.startTimeUs) {
            enterNextSegment();
        } else {
            SegmentInfo segmentInfo3 = this.currentSegmentInfo;
            if (segmentInfo3 != null && j >= segmentInfo3.endTimeUs) {
                leaveCurrentSegment();
            }
        }
        SegmentInfo segmentInfo4 = this.currentSegmentInfo;
        return i <= (segmentInfo4 != null ? segmentInfo4.maxLayer : this.normalSpeedMaxLayer) || shouldKeepFrameForOutputValidity(i, j);
    }

    private void enterNextSegment() {
        if (this.currentSegmentInfo != null) {
            leaveCurrentSegment();
        }
        this.currentSegmentInfo = this.nextSegmentInfo;
        this.nextSegmentInfo = this.segmentIterator.hasNext() ? new SegmentInfo(this.segmentIterator.next(), this.inputMaxLayer, this.normalSpeedMaxLayer) : null;
    }

    @RequiresNonNull({"currentSegmentInfo"})
    private void leaveCurrentSegment() {
        this.frameTimeDeltaUs += (this.currentSegmentInfo.endTimeUs - this.currentSegmentInfo.startTimeUs) * ((long) (this.currentSegmentInfo.speedDivisor - 1));
        this.currentSegmentInfo = null;
    }

    private boolean shouldKeepFrameForOutputValidity(int i, long j) {
        SegmentInfo segmentInfo = this.nextSegmentInfo;
        if (segmentInfo != null && i < segmentInfo.maxLayer) {
            long j2 = ((this.nextSegmentInfo.startTimeUs - j) * 30) / 1000000;
            float f = (-(1 << (this.inputMaxLayer - this.nextSegmentInfo.maxLayer))) + 0.45f;
            for (int i2 = 1; i2 < this.nextSegmentInfo.maxLayer && j2 < (1 << (this.inputMaxLayer - i2)) + f; i2++) {
                if (i <= i2) {
                    return true;
                }
            }
        }
        return false;
    }

    long getCurrentFrameOutputTimeUs(long j) {
        long j2 = this.frameTimeDeltaUs + j;
        SegmentInfo segmentInfo = this.currentSegmentInfo;
        if (segmentInfo != null) {
            j2 += (j - segmentInfo.startTimeUs) * ((long) (this.currentSegmentInfo.speedDivisor - 1));
        }
        return Math.round((j2 * 30) / this.captureFrameRate);
    }

    private void skipToNextNalUnit(ByteBuffer byteBuffer) {
        int iPosition = byteBuffer.position();
        while (true) {
            int iRemaining = byteBuffer.remaining();
            int i = NAL_START_CODE_LENGTH;
            if (iRemaining >= i) {
                byteBuffer.get(this.scratch, 0, i);
                if (Arrays.equals(this.scratch, NalUnitUtil.NAL_START_CODE)) {
                    byteBuffer.position(iPosition);
                    return;
                } else {
                    iPosition++;
                    byteBuffer.position(iPosition);
                }
            } else {
                throw new IllegalStateException("Could not find NAL unit start code.");
            }
        }
    }

    private static MetadataInfo getMetadataInfo(Metadata metadata) {
        MetadataInfo metadataInfo = new MetadataInfo();
        if (metadata == null) {
            return metadataInfo;
        }
        for (int i = 0; i < metadata.length(); i++) {
            Metadata.Entry entry = metadata.get(i);
            if (entry instanceof SmtaMetadataEntry) {
                SmtaMetadataEntry smtaMetadataEntry = (SmtaMetadataEntry) entry;
                metadataInfo.captureFrameRate = smtaMetadataEntry.captureFrameRate;
                metadataInfo.inputMaxLayer = smtaMetadataEntry.svcTemporalLayerCount - 1;
            } else if (entry instanceof SlowMotionData) {
                metadataInfo.slowMotionData = (SlowMotionData) entry;
            }
        }
        if (metadataInfo.slowMotionData == null) {
            return metadataInfo;
        }
        Assertions.checkState(metadataInfo.inputMaxLayer != -1, "SVC temporal layer count not found.");
        Assertions.checkState(metadataInfo.captureFrameRate != -3.4028235E38f, "Capture frame rate not found.");
        Assertions.checkState(metadataInfo.captureFrameRate % 1.0f == 0.0f && metadataInfo.captureFrameRate % 30.0f == 0.0f, new StringBuilder(43).append("Invalid capture frame rate: ").append(metadataInfo.captureFrameRate).toString());
        int i2 = ((int) metadataInfo.captureFrameRate) / 30;
        for (int i3 = metadataInfo.inputMaxLayer; i3 >= 0; i3--) {
            if ((i2 & 1) == 1) {
                Assertions.checkState((i2 >> 1) == 0, new StringBuilder(84).append("Could not compute normal speed max SVC layer for capture frame rate  ").append(metadataInfo.captureFrameRate).toString());
                metadataInfo.normalSpeedMaxLayer = i3;
                break;
            }
            i2 >>= 1;
        }
        return metadataInfo;
    }

    private static final class SegmentInfo {
        public final long endTimeUs;
        public final int maxLayer;
        public final int speedDivisor;
        public final long startTimeUs;

        public SegmentInfo(SlowMotionData.Segment segment, int i, int i2) {
            this.startTimeUs = Util.msToUs(segment.startTimeMs);
            this.endTimeUs = Util.msToUs(segment.endTimeMs);
            int i3 = segment.speedDivisor;
            this.speedDivisor = i3;
            this.maxLayer = getSlowMotionMaxLayer(i3, i, i2);
        }

        private static int getSlowMotionMaxLayer(int i, int i2, int i3) {
            for (int i4 = i; i4 > 0; i4 >>= 1) {
                if ((i4 & 1) == 1) {
                    Assertions.checkState((i4 >> 1) == 0, new StringBuilder(34).append("Invalid speed divisor: ").append(i).toString());
                    break;
                }
                i3++;
            }
            return Math.min(i3, i2);
        }
    }
}
