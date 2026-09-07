package com.google.android.exoplayer2.source.rtsp;

import android.net.Uri;
import android.util.Base64;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.audio.AacUtil;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.CodecSpecificDataUtil;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.vungle.ads.internal.protos.Sdk;
import io.appmetrica.analytics.coreutils.internal.StringUtils;

/* JADX INFO: loaded from: classes13.dex */
final class RtspMediaTrack {
    private static final String AAC_CODECS_PREFIX = "mp4a.40.";
    private static final String GENERIC_CONTROL_ATTR = "*";
    private static final String H264_CODECS_PREFIX = "avc1.";
    private static final String PARAMETER_PROFILE_LEVEL_ID = "profile-level-id";
    private static final String PARAMETER_SPROP_PARAMS = "sprop-parameter-sets";
    public final RtpPayloadFormat payloadFormat;
    public final Uri uri;

    public RtspMediaTrack(MediaDescription mediaDescription, Uri uri) {
        Assertions.checkArgument(mediaDescription.attributes.containsKey(SessionDescription.ATTR_CONTROL));
        this.payloadFormat = generatePayloadFormat(mediaDescription);
        this.uri = extractTrackUri(uri, (String) Util.castNonNull(mediaDescription.attributes.get(SessionDescription.ATTR_CONTROL)));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RtspMediaTrack rtspMediaTrack = (RtspMediaTrack) obj;
        return this.payloadFormat.equals(rtspMediaTrack.payloadFormat) && this.uri.equals(rtspMediaTrack.uri);
    }

    public int hashCode() {
        return ((Sdk.SDKError.Reason.AD_RESPONSE_TIMED_OUT_VALUE + this.payloadFormat.hashCode()) * 31) + this.uri.hashCode();
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0075  */
    static RtpPayloadFormat generatePayloadFormat(MediaDescription mediaDescription) {
        int iInferChannelCount;
        byte b;
        Format.Builder builder = new Format.Builder();
        if (mediaDescription.bitrate > 0) {
            builder.setAverageBitrate(mediaDescription.bitrate);
        }
        int i = mediaDescription.rtpMapAttribute.payloadType;
        String mimeTypeFromRtpMediaType = RtpPayloadFormat.getMimeTypeFromRtpMediaType(mediaDescription.rtpMapAttribute.mediaEncoding);
        builder.setSampleMimeType(mimeTypeFromRtpMediaType);
        int i2 = mediaDescription.rtpMapAttribute.clockRate;
        if ("audio".equals(mediaDescription.mediaType)) {
            iInferChannelCount = inferChannelCount(mediaDescription.rtpMapAttribute.encodingParameters, mimeTypeFromRtpMediaType);
            builder.setSampleRate(i2).setChannelCount(iInferChannelCount);
        } else {
            iInferChannelCount = -1;
        }
        ImmutableMap<String, String> fmtpParametersAsMap = mediaDescription.getFmtpParametersAsMap();
        int iHashCode = mimeTypeFromRtpMediaType.hashCode();
        if (iHashCode != -53558318) {
            if (iHashCode != 187078296) {
                if (iHashCode == 1331836730 && mimeTypeFromRtpMediaType.equals("video/avc")) {
                    b = 1;
                } else {
                    b = -1;
                }
            } else if (mimeTypeFromRtpMediaType.equals("audio/ac3")) {
                b = 2;
            } else {
                b = -1;
            }
        } else if (mimeTypeFromRtpMediaType.equals("audio/mp4a-latm")) {
            b = 0;
        } else {
            b = -1;
        }
        if (b == 0) {
            Assertions.checkArgument(iInferChannelCount != -1);
            Assertions.checkArgument(!fmtpParametersAsMap.isEmpty());
            processAacFmtpAttribute(builder, fmtpParametersAsMap, iInferChannelCount, i2);
        } else if (b == 1) {
            Assertions.checkArgument(!fmtpParametersAsMap.isEmpty());
            processH264FmtpAttribute(builder, fmtpParametersAsMap);
        }
        Assertions.checkArgument(i2 > 0);
        Assertions.checkArgument(i >= 96);
        return new RtpPayloadFormat(builder.build(), i, i2, fmtpParametersAsMap);
    }

    private static int inferChannelCount(int i, String str) {
        if (i != -1) {
            return i;
        }
        return str.equals("audio/ac3") ? 6 : 1;
    }

    private static void processAacFmtpAttribute(Format.Builder builder, ImmutableMap<String, String> immutableMap, int i, int i2) {
        Assertions.checkArgument(immutableMap.containsKey(PARAMETER_PROFILE_LEVEL_ID));
        String str = (String) Assertions.checkNotNull(immutableMap.get(PARAMETER_PROFILE_LEVEL_ID));
        String strValueOf = String.valueOf(AAC_CODECS_PREFIX);
        String strValueOf2 = String.valueOf(str);
        builder.setCodecs(strValueOf2.length() != 0 ? strValueOf.concat(strValueOf2) : new String(strValueOf));
        builder.setInitializationData(ImmutableList.of(AacUtil.buildAacLcAudioSpecificConfig(i2, i)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void processH264FmtpAttribute(Format.Builder builder, ImmutableMap<String, String> immutableMap) {
        Assertions.checkArgument(immutableMap.containsKey(PARAMETER_SPROP_PARAMS));
        String[] strArrSplit = Util.split((String) Assertions.checkNotNull(immutableMap.get(PARAMETER_SPROP_PARAMS)), StringUtils.COMMA);
        Assertions.checkArgument(strArrSplit.length == 2);
        ImmutableList immutableListOf = ImmutableList.of(getH264InitializationDataFromParameterSet(strArrSplit[0]), getH264InitializationDataFromParameterSet(strArrSplit[1]));
        builder.setInitializationData(immutableListOf);
        byte[] bArr = (byte[]) immutableListOf.get(0);
        NalUnitUtil.SpsData spsNalUnit = NalUnitUtil.parseSpsNalUnit(bArr, NalUnitUtil.NAL_START_CODE.length, bArr.length);
        builder.setPixelWidthHeightRatio(spsNalUnit.pixelWidthHeightRatio);
        builder.setHeight(spsNalUnit.height);
        builder.setWidth(spsNalUnit.width);
        String str = immutableMap.get(PARAMETER_PROFILE_LEVEL_ID);
        if (str != null) {
            String strValueOf = String.valueOf(H264_CODECS_PREFIX);
            String strValueOf2 = String.valueOf(str);
            builder.setCodecs(strValueOf2.length() != 0 ? strValueOf.concat(strValueOf2) : new String(strValueOf));
            return;
        }
        builder.setCodecs(CodecSpecificDataUtil.buildAvcCodecString(spsNalUnit.profileIdc, spsNalUnit.constraintsFlagsAndReservedZero2Bits, spsNalUnit.levelIdc));
    }

    private static byte[] getH264InitializationDataFromParameterSet(String str) {
        byte[] bArrDecode = Base64.decode(str, 0);
        byte[] bArr = new byte[bArrDecode.length + NalUnitUtil.NAL_START_CODE.length];
        System.arraycopy(NalUnitUtil.NAL_START_CODE, 0, bArr, 0, NalUnitUtil.NAL_START_CODE.length);
        System.arraycopy(bArrDecode, 0, bArr, NalUnitUtil.NAL_START_CODE.length, bArrDecode.length);
        return bArr;
    }

    private static Uri extractTrackUri(Uri uri, String str) {
        Uri uri2 = Uri.parse(str);
        if (uri2.isAbsolute()) {
            return uri2;
        }
        return str.equals("*") ? uri : uri.buildUpon().appendEncodedPath(str).build();
    }
}
