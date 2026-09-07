package com.facebook.ads.redexgen.core;

import android.graphics.Color;
import android.text.TextUtils;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import com.amazon.device.ads.DtbConstants;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.google.common.base.Ascii;
import com.json.mediationsdk.logger.IronSourceError;
import com.json.mediationsdk.utils.IronSourceConstants;
import com.unity3d.mediation.LevelPlayAdError;
import com.unity3d.services.UnityAdsConstants;
import com.vungle.ads.internal.protos.Sdk;
import io.bidmachine.protobuf.EventTypeExtended;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.f1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC2397f1 {
    public static byte[] A00;
    public static String[] A01 = {"", "bFsSnTfkzafq3ud5Xpkap2O", "GLZ", "hau", "uB0YVdoRw1zsTDmiKeOy4sh", "ppG9G71cS2AbXblDaOGYYoKfoVAFLAFU", "7BISMRC2cRfpEi5PGprWoLMbnPXnrgw6", "36lBigIXSfR2IRBCU0VRTecUGIJ0fKix"};
    public static final Map<String, Integer> A02;
    public static final Pattern A03;
    public static final Pattern A04;
    public static final Pattern A05;

    public static String A03(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 57);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A04() {
        A00 = new byte[]{94, -86, -66, -77, -82, -88, 116, 116, -88, -80, -57, 125, 120, 127, -55, 117, 120, 116, -88, -80, -57, 125, 120, 127, -55, 117, 120, 116, -88, -80, -57, 125, 120, 127, -55, 117, -88, 117, 112, -34, -14, -25, -30, -31, -36, -88, -88, -36, -28, -5, -79, -84, -77, -3, -87, -84, -88, -36, -28, -5, -79, -84, -77, -3, -87, -84, -88, -36, -28, -5, -79, -84, -77, -3, -87, -84, -88, -36, -28, -86, -36, -82, -65, -36, -28, -86, -65, -87, -36, -87, -92, -24, -4, -15, -20, -21, -26, -78, -78, -26, -18, 5, -69, -74, -67, 7, -77, -74, -78, -26, -18, 5, -69, -74, -67, 7, -77, -74, -78, -26, -18, 5, -69, -74, -67, 7, -77, -74, -78, -26, -18, 5, -69, -74, -67, 7, -77, -26, -77, -82, -71, -60, -63, -69, -67, -70, -60, -51, -67, 5, Ascii.DC2, Ascii.CAN, Ascii.CR, Ascii.NAK, Ascii.EM, 9, Ascii.ESC, Ascii.FF, Ascii.CR, Ascii.CAN, 9, -6, 10, Ascii.SO, -6, -79, -63, -59, -79, -67, -79, -62, -71, -66, -75, -29, -4, -9, -12, -25, -53, -50, -46, -48, -50, -34, -27, -17, -19, -15, -31, -57, -47, -58, -56, -48, -63, -53, -64, -51, -62, -57, -60, -61, -64, -53, -52, -50, -51, -61, -92, -82, -73, -89, -74, -64, -55, -71, -54, -67, -61, -64, -71, -56, 4, Ascii.DC4, 17, Ascii.EM, Ascii.DLE, 9, Ascii.FS, Ascii.EM, 19, 32, Ascii.RS, Ascii.SYN, Ascii.SYN, Ascii.VT, -60, -62, -59, -58, -43, -61, -51, -42, -58, -72, -67, -74, -57, -55, -57, -70, -54, -56, -70, -68, -63, -56, -68, -56, -59, -70, -51, -66, Ascii.CR, Ascii.EM, Ascii.FS, Ascii.VT, Ascii.SYN, 6, Ascii.DC2, Ascii.NAK, 17, 9, Ascii.SI, Ascii.DC2, Ascii.SUB, 8, Ascii.NAK, 5, Ascii.SI, Ascii.CAN, 8, Ascii.SO, Ascii.SUB, Ascii.GS, Ascii.EM, Ascii.RS, Ascii.DC4, Ascii.ETB, Ascii.SYN, -36, -21, -30, -26, -20, -24, -25, -63, -41, -65, -52, -84, -87, -70, -77, -86, -76, -67, -83, -45, -48, -31, -38, -46, -24, -48, -35, -71, -74, -57, -64, -68, -60, -63, -71, -70, -61, -57, -60, -71, -50, -53, -36, -43, -47, -36, -53, -29, -70, -73, -56, -63, -67, -56, -69, -69, -60, -58, -61, -44, -51, -55, -44, -57, -37, Ascii.VT, 8, Ascii.EM, Ascii.DC2, Ascii.DC2, Ascii.SI, 8, Ascii.DC2, Ascii.DLE, Ascii.SUB, Ascii.ETB, 40, 33, 35, Ascii.ETB, Ascii.GS, Ascii.ESC, 36, 42, Ascii.ETB, 1, -2, Ascii.SI, 8, Ascii.FF, 9, 6, 19, 2, 4, Ascii.SI, 2, 2, Ascii.VT, -58, -61, -44, -51, -47, -44, -61, -48, -55, -57, -47, -50, -33, -40, -36, -33, -48, -43, -42, -47, -32, -35, -18, -25, -18, -31, -32, -43, -46, -29, -36, -28, -46, -35, -34, -32, -33, -60, -63, -46, -53, -45, -59, -63, -57, -46, -59, -59, -50, -30, -33, -16, -23, -15, -22, -33, -14, -29, -32, -22, -13, -29, -36, -39, -22, -29, -21, -28, -39, -20, -35, -33, -22, -39, -15, -2, -5, Ascii.FF, 5, Ascii.CR, 6, -5, Ascii.SO, -1, 1, Ascii.FF, -1, 19, Ascii.DLE, Ascii.CR, Ascii.RS, Ascii.ETB, 32, 33, Ascii.RS, Ascii.GS, 33, Ascii.ESC, Ascii.NAK, Ascii.US, 17, Ascii.FS, Ascii.EM, 42, 35, 46, 33, 39, 36, Ascii.GS, 44, Ascii.VT, Ascii.FF, Ascii.FF, Ascii.ETB, Ascii.ETB, Ascii.DLE, Ascii.NAK, Ascii.DC2, 1, 2, 2, Ascii.CR, Ascii.DLE, 8, Ascii.SYN, -1, 9, Ascii.DC2, 2, -48, -43, -39, -45, -34, -51, -27, -33, -28, -24, -30, -19, -32, -12, -75, -64, -75, -72, -74, -61, -77, -67, -58, -74, Ascii.ETB, Ascii.SUB, 35, Ascii.SYN, 19, 35, Ascii.SUB, Ascii.DC4, Ascii.FS, -86, -80, -77, -74, -91, -80, -69, -84, -83, -72, -87, -97, -88, -85, -98, -84, -83, -96, -85, -98, -98, -89, 1, Ascii.DLE, -2, 3, Ascii.SO, 4, -4, -1, -7, 1, 6, Ascii.VT, -6, 7, 10, 7, 7, 8, Ascii.SI, 19, Ascii.DC4, Ascii.ETB, 8, 9, Ascii.DC4, 5, -46, -38, -41, -49, -5, 3, 0, -8, -7, 2, 6, 3, -8, Ascii.SUB, 37, Ascii.DC4, 44, -31, -20, -33, -33, -24, Ascii.GS, 40, Ascii.ESC, Ascii.ESC, 36, 47, Ascii.ESC, 34, 34, 37, 45, -42, -31, -44, -24, -32, -25, -26, -35, -15, -36, -35, -17, -2, 5, 10, 6, -1, 4, 1, -81, -76, -86, -81, -89, -76, -72, -85, -86, Ascii.DC2, Ascii.ETB, Ascii.CR, Ascii.DC2, Ascii.DLE, Ascii.CAN, -50, -37, -44, -41, -34, -72, -75, -82, -72, -74, -51, -62, -41, -58, -49, -59, -58, -45, -67, -78, -57, -74, -65, -75, -74, -61, -77, -67, -58, -60, -71, 33, Ascii.SYN, 44, 35, Ascii.FS, 39, Ascii.SUB, Ascii.SUB, 35, -23, -30, -22, -20, -21, -32, -27, -26, -29, -29, -20, -21, -37, -40, -42, -41, -29, -47, -37, -28, -44, -48, -51, -53, -52, -40, -57, -45, -42, -59, -48, Ascii.DLE, Ascii.CR, Ascii.VT, Ascii.FF, Ascii.CAN, 7, Ascii.GS, 5, Ascii.DC2, 9, 6, 4, 5, 17, 4, Ascii.FF, 9, 1, 2, Ascii.VT, Ascii.SI, Ascii.FF, 1, Ascii.SYN, 2, 9, 9, Ascii.FF, Ascii.DC4, Ascii.GS, Ascii.SUB, Ascii.CAN, Ascii.EM, 37, Ascii.CAN, 35, Ascii.DC2, 42, -75, -78, -80, -79, -67, -80, -69, -82, -82, -73, -6, -9, -11, -10, 2, -11, 0, -13, 7, -56, -59, -61, -60, -48, -52, -59, -54, -57, -20, -23, -25, -24, -12, -13, -31, -20, -19, -17, -18, -16, -19, -21, -20, -8, -9, -23, -27, -21, -10, -23, -23, -14, -9, -12, -14, -13, -1, -2, -10, 4, -19, -9, 0, -16, 1, -2, -4, -3, 9, 8, 1, -10, 9, -6, -4, 7, -10, Ascii.SO, -69, -72, -74, -73, -61, -62, -69, -80, -61, -76, -74, -63, -76, -56, 0, -3, -5, -4, 8, 7, 8, -7, -7, 0, -10, 0, 9, -7, -79, -82, -84, -83, -71, -66, -86, -79, -79, -76, -68, -89, -92, -88, -96, Ascii.VT, 8, Ascii.FF, 4, 6, 17, 4, 4, Ascii.CR, -61, -64, -59, -68, -59, -49, -61, -55, -57, -48, -42, -61, -39, -51, -34, -37, -37, -38, -12, -20, -21, -16, -4, -12, -24, -8, -4, -24, -12, -24, -7, -16, -11, -20, -46, -54, -55, -50, -38, -46, -57, -47, -38, -54, -85, -93, -94, -89, -77, -85, -83, -80, -95, -90, -89, -94, -1, -9, -10, -5, 7, -1, 2, 7, 4, 2, -2, -9, -74, -82, -83, -78, -66, -74, -68, -82, -86, -80, -69, -82, -82, -73, -39, -47, -48, -43, -31, -39, -33, -40, -51, 
        -32, -47, -50, -40, -31, -47, Ascii.ESC, 19, Ascii.DC2, Ascii.ETB, 35, Ascii.ESC, 33, Ascii.RS, 32, Ascii.ETB, Ascii.FS, Ascii.NAK, Ascii.NAK, 32, 19, 19, Ascii.FS, -58, -66, -67, -62, -50, -58, -51, -50, -53, -54, -50, -56, -62, -52, -66, -40, -48, -49, -44, -32, -40, -31, -44, -38, -41, -48, -33, -35, -48, -49, -5, -9, -14, -4, -9, -11, -10, 2, -16, -6, 3, -13, -4, -8, -3, 3, -14, 1, -12, -16, -4, -53, -57, -47, -46, -41, -48, -51, -47, -61, -41, -39, -51, -51, -53, -35, -45, -40, -64, -77, -56, -77, -68, -63, -55, -70, -69, -58, -73, -56, -69, -48, -45, Ascii.EM, Ascii.SYN, Ascii.SO, Ascii.SYN, Ascii.VT, Ascii.CR, Ascii.SI, Ascii.GS, Ascii.SUB, Ascii.ETB, 36, 19, -46, -49, -52, -39, -56, -57, -43, -60, -59, 34, 37, Ascii.DC4, 33, Ascii.SUB, Ascii.CAN, -18, -15, -32, -19, -26, -28, -15, -28, -29, -21, -18, -33, -28, -27, -32, -81, -96, -85, -92, -90, -82, -85, -93, -92, -83, -79, -82, -93, Ascii.CAN, 9, Ascii.DC4, Ascii.CR, Ascii.SI, Ascii.SUB, Ascii.CR, Ascii.CR, Ascii.SYN, -24, -39, -28, -35, -20, -19, -22, -23, -19, -25, -31, -21, -35, -76, -91, -80, -87, -70, -83, -77, -80, -87, -72, -74, -87, -88, Ascii.NAK, 6, Ascii.NAK, 6, Ascii.RS, 6, Ascii.FS, Ascii.CR, Ascii.SO, Ascii.NAK, 19, 8, 4, 6, Ascii.VT, 19, Ascii.CAN, 9, 9, -5, -16, -3, 0, -54, -61, -56, -59, -56, -60, -51, -59, Ascii.DC2, 17, Ascii.EM, 6, 7, Ascii.DC4, 4, Ascii.SO, Ascii.ETB, 7, -60, -55, -58, -60, -64, -71, -19, -32, -35, -32, -34, -34, -36, -21, -16, -19, -21, -25, -32, -67, -80, -81, -58, -69, -74, -10, -21, -26, -27, -73, -76, -72, -66, -89, -73, -76, -68, -77, 9, 6, Ascii.DLE, -8, 3, -7, 3, Ascii.FF, -4, -84, -102, -99, -99, -91, -98, -101, -85, -88, -80, -89, -53, -71, -60, -59, -57, -58, -57, -75, -62, -72, -51, -74, -58, -61, -53, -62, 9, -5, -9, -3, 8, -5, -5, 4, -44, -58, -62, -44, -55, -58, -51, -51, Ascii.DC2, 8, 4, Ascii.CR, Ascii.CR, 0, 10, 0, 3, Ascii.CR, -4, 9, -4, -12, 2, -21, -11, -2, -18, -2, -9, -20, -1, -16, -19, -9, 0, -16, -65, -72, -83, -64, -79, -77, -66, -83, -59, -84, -91, -102, -83, -98, -96, -85, -98, -78, -43, -48, -47, -39, -64, -67, -65, -74, -69, -76, -76, -65, -78, -78, -69, Ascii.CAN, Ascii.EM, 10, 10, 17, 7, 17, Ascii.SUB, 10, 40, Ascii.NAK, 34, 32, 17, Ascii.CR, Ascii.CAN, 32, Ascii.DC4, Ascii.NAK, Ascii.US, 32, Ascii.CAN, 17, -3, -8, -10, -22, -3, -8, 43, 41, Ascii.CAN, 37, 42, 39, Ascii.CAN, 41, Ascii.FS, 37, 43, -74, -73, -76, -77, -73, -79, -85, -75, -89, -65, -78, -72, -75, -82, -67, -9, -24, -27, -31, -12, 46, Ascii.US, 32, 43, Ascii.FS, -15, -30, -29, -18, -33, -19, -25, -23, -27, -33, Ascii.CAN, 4, Ascii.VT, Ascii.VT, Ascii.SO, Ascii.SYN, 43, Ascii.ETB, Ascii.RS, Ascii.RS, 33, 41, Ascii.EM, 36, Ascii.ETB, Ascii.ETB, 32};
    }

    static {
        A04();
        A05 = Pattern.compile(A03(1, 38, 19));
        A04 = Pattern.compile(A03(91, 49, 81));
        A03 = Pattern.compile(A03(39, 52, 71));
        A02 = new HashMap();
        A02.put(A03(IronSourceConstants.USING_CACHE_FOR_INIT_EVENT, 9, 31), -984833);
        A02.put(A03(149, 12, 107), -332841);
        A02.put(A03(161, 4, 96), -16711681);
        A02.put(A03(165, 10, 23), -8388652);
        A02.put(A03(175, 5, 73), -983041);
        A02.put(A03(180, 5, 48), -657956);
        A02.put(A03(185, 6, 67), -6972);
        A02.put(A03(191, 5, 44), Integer.valueOf(ViewCompat.MEASURED_STATE_MASK));
        A02.put(A03(196, 14, 38), -5171);
        A02.put(A03(210, 4, 9), -16776961);
        A02.put(A03(Sdk.SDKError.Reason.INVALID_GZIP_BID_PAYLOAD_VALUE, 10, 27), -7722014);
        A02.put(A03(224, 5, 105), -5952982);
        A02.put(A03(229, 9, 110), -2180985);
        A02.put(A03(238, 9, 40), -10510688);
        A02.put(A03(247, 10, 28), -8388864);
        A02.put(A03(257, 9, 32), -2987746);
        A02.put(A03(266, 5, 113), -32944);
        A02.put(A03(271, 14, 106), -10185235);
        A02.put(A03(285, 8, 114), -1828);
        A02.put(A03(293, 7, 64), -2354116);
        A02.put(A03(300, 4, 37), -16711681);
        A02.put(A03(304, 8, 15), -16777077);
        A02.put(A03(312, 8, 54), -16741493);
        A02.put(A03(320, 13, 28), -4684277);
        A02.put(A03(333, 8, 49), -5658199);
        A02.put(A03(FacebookRequestErrorClassification.EC_TOO_MANY_USER_ACTION_CALLS, 9, 29), -16751616);
        A02.put(A03(350, 8, 41), -5658199);
        A02.put(A03(358, 9, 110), -4343957);
        A02.put(A03(367, 11, Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE), -7667573);
        A02.put(A03(378, 14, 100), -11179217);
        A02.put(A03(392, 10, 41), -29696);
        A02.put(A03(402, 10, 52), -6737204);
        A02.put(A03(412, 7, 67), -7667712);
        A02.put(A03(419, 10, 56), -1468806);
        A02.put(A03(429, 12, 39), -7357297);
        A02.put(A03(441, 13, 69), -12042869);
        A02.put(A03(454, 13, 63), -13676721);
        A02.put(A03(467, 13, 97), -13676721);
        A02.put(A03(DtbConstants.DEFAULT_PLAYER_HEIGHT, 13, 115), -16724271);
        A02.put(A03(FacebookRequestErrorClassification.ESC_APP_INACTIVE, 10, 127), -7077677);
        A02.put(A03(503, 8, 110), -60269);
        A02.put(A03(511, 11, 100), -16728065);
        A02.put(A03(522, 7, 51), -9868951);
        A02.put(A03(529, 7, 66), -9868951);
        A02.put(A03(536, 10, 24), -14774017);
        A02.put(A03(546, 9, 120), -5103070);
        A02.put(A03(555, 11, 11), -1296);
        A02.put(A03(566, 11, 0), -14513374);
        A02.put(A03(577, 7, 98), -65281);
        A02.put(A03(584, 9, 95), -2302756);
        A02.put(A03(593, 10, 103), -460545);
        A02.put(A03(603, 4, 50), -10496);
        A02.put(A03(607, 9, 91), -2448096);
        A02.put(A03(616, 4, Sdk.SDKError.Reason.INVALID_ADS_ENDPOINT_VALUE), -8355712);
        A02.put(A03(IronSourceError.ERROR_DO_BN_LOAD_DURING_SHOW, 5, 65), -16744448);
        A02.put(A03(LevelPlayAdError.ERROR_CODE_LOAD_BEFORE_INIT_SUCCESS_CALLBACK, 11, Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE), -5374161);
        A02.put(A03(636, 4, 54), -8355712);
        A02.put(A03(640, 8, 63), -983056);
        A02.put(A03(648, 7, 93), -38476);
        A02.put(A03(655, 9, 13), -3318692);
        A02.put(A03(664, 6, 112), -11861886);
        A02.put(A03(670, 5, 44), -16);
        A02.put(A03(675, 5, 20), -989556);
        A02.put(A03(680, 8, 40), -1644806);
        A02.put(A03(688, 13, 24), -3851);
        A02.put(A03(701, 9, Sdk.SDKError.Reason.INVALID_LOG_ERROR_ENDPOINT_VALUE), -8586240);
        A02.put(A03(710, 12, 68), -1331);
        A02.put(A03(722, 9, 54), -5383962);
        A02.put(A03(731, 10, 43), -1015680);
        A02.put(A03(741, 9, 107), -2031617);
        A02.put(A03(UnityAdsConstants.AdOperations.GET_TOKEN_TIMEOUT_MS, 20, 100), -329006);
        A02.put(A03(770, 9, 120), -2894893);
        A02.put(A03(779, 10, 16), -7278960);
        A02.put(A03(789, 9, 85), -2894893);
        A02.put(A03(798, 9, 35), -18751);
        A02.put(A03(807, 11, 71), -24454);
        A02.put(A03(818, 13, 75), -14634326);
        A02.put(A03(831, 12, 82), -7876870);
        A02.put(A03(843, 14, 92), -8943463);
        A02.put(A03(857, 14, 22), -8943463);
        A02.put(A03(871, 14, 91), -5192482);
        A02.put(A03(885, 11, 12), -32);
        A02.put(A03(896, 4, 2), -16711936);
        A02.put(A03(900, 9, 102), -13447886);
        A02.put(A03(EventTypeExtended.EVENT_TYPE_EXTENDED_AD_UNIT_LOSS_VALUE, 5, 30), -331546);
        A02.put(A03(914, 7, 41), -65281);
        A02.put(A03(921, 6, 51), -8388608);
        A02.put(A03(927, 16, 78), -10039894);
        A02.put(A03(943, 10, 44), -16777011);
        A02.put(A03(953, 12, 5), -4565549);
        A02.put(A03(965, 12, 89), -7114533);
        A02.put(A03(977, 14, 16), -12799119);
        A02.put(A03(991, 15, 51), -8689426);
        A02.put(A03(1006, 17, 117), -16713062);
        A02.put(A03(1023, 15, 32), -12004916);
        A02.put(A03(IronSourceError.ERROR_RV_SHOW_EXCEPTION, 15, 50), -3730043);
        A02.put(A03(1053, 12, 85), -15132304);
        A02.put(A03(1065, 9, 86), -655366);
        A02.put(A03(1074, 9, 37), -6943);
        A02.put(A03(1083, 8, 49), -6987);
        A02.put(A03(1091, 11, 25), -8531);
        A02.put(A03(IronSourceConstants.RV_API_HAS_AVAILABILITY_FALSE, 4, 33), -16777088);
        A02.put(A03(1106, 7, 113), -133658);
        A02.put(A03(IronSourceConstants.RV_CALLBACK_SHOW_FAILED, 5, 117), -8355840);
        A02.put(A03(IronSourceConstants.RV_CALLBACK_AD_DISPLAYED, 9, 42), -9728477);
        A02.put(A03(1127, 6, Sdk.SDKError.Reason.INVALID_ADS_ENDPOINT_VALUE), -23296);
        A02.put(A03(1133, 9, 70), -47872);
        A02.put(A03(1142, 6, 67), -2461482);
        A02.put(A03(1148, 13, 6), -1120086);
        A02.put(A03(1161, 9, 111), -6751336);
        A02.put(A03(1170, 13, 63), -5247250);
        A02.put(A03(1183, 13, 11), -2396013);
        A02.put(A03(1196, 10, 108), -4139);
        A02.put(A03(1206, 9, 106), -9543);
        A02.put(A03(1215, 4, 82), -3308225);
        A02.put(A03(1219, 4, 33), -16181);
        A02.put(A03(1223, 4, 31), -2252579);
        A02.put(A03(1227, 10, 105), -5185306);
        A02.put(A03(1237, 6, 27), -8388480);
        A02.put(A03(1243, 13, 66), -10079335);
        A02.put(A03(1256, 3, 18), Integer.valueOf(SupportMenu.CATEGORY_MASK));
        A02.put(A03(1266, 9, 12), -4419697);
        A02.put(A03(1275, 9, 94), -12490271);
        A02.put(A03(1284, 11, 0), -7650029);
        A02.put(A03(1295, 6, 31), -360334);
        A02.put(A03(1301, 10, 27), -744352);
        A02.put(A03(IronSourceConstants.RV_AUCTION_RESPONSE_WATERFALL, 8, 93), -13726889);
        A02.put(A03(1319, 8, 40), -2578);
        A02.put(A03(1327, 6, 102), -6270419);
        A02.put(A03(1333, 6, 94), -4144960);
        A02.put(A03(1339, 7, 80), -7876885);
        A02.put(A03(1346, 9, 82), -9807155);
        A02.put(A03(1355, 9, 19), -9404272);
        A02.put(A03(1364, 9, 0), -9404272);
        A02.put(A03(1373, 4, 41), -1286);
        A02.put(A03(1377, 11, 20), -16711809);
        A02.put(A03(1388, 9, 108), -12156236);
        A02.put(A03(1397, 3, Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE), -2968436);
        A02.put(A03(IronSourceConstants.RV_CAP_PLACEMENT, 4, 115), -16744320);
        A02.put(A03(1404, 7, 115), -2572328);
        A02.put(A03(1411, 6, 80), -40121);
        A02.put(A03(1417, 11, 126), 0);
        A02.put(A03(1428, 9, 9), -12525360);
        A02.put(A03(1437, 6, 16), -1146130);
        A02.put(A03(1443, 5, 71), -663885);
        A02.put(A03(1448, 5, 126), -1);
        A02.put(A03(1453, 10, 65), -657931);
        A02.put(A03(1463, 6, 102), Integer.valueOf(InputDeviceCompat.SOURCE_ANY));
        A02.put(A03(1469, 11, Sdk.SDKError.Reason.TPAT_ERROR_VALUE), -6632142);
    }

    public static int A00(String str) {
        return A02(str, true);
    }

    public static int A01(String str) {
        return A02(str, false);
    }

    public static int A02(String str, boolean z) {
        int i;
        AbstractC2388es.A07(!TextUtils.isEmpty(str));
        String strReplace = str.replace(A03(0, 1, 5), A03(0, 0, 84));
        if (strReplace.charAt(0) == '#') {
            int i2 = (int) Long.parseLong(strReplace.substring(1), 16);
            if (strReplace.length() == 7) {
                return (-16777216) | i2;
            }
            if (strReplace.length() == 9) {
                return ((i2 & 255) << 24) | (i2 >>> 8);
            }
            throw new IllegalArgumentException();
        }
        if (strReplace.startsWith(A03(1262, 4, 75))) {
            Matcher matcher = (z ? A03 : A04).matcher(strReplace);
            if (matcher.matches()) {
                if (z) {
                    float f = Float.parseFloat((String) AbstractC2388es.A01(matcher.group(4)));
                    String[] strArr = A01;
                    if (strArr[7].charAt(8) != strArr[5].charAt(8)) {
                        throw new RuntimeException();
                    }
                    String[] strArr2 = A01;
                    strArr2[1] = "0W0AdbdhOBR49PwQn0cLrTr";
                    strArr2[4] = "iJcdUCXMJbCBHsWpAnAYYk2";
                    i = (int) (f * 255.0f);
                } else {
                    i = Integer.parseInt((String) AbstractC2388es.A01(matcher.group(4)), 10);
                }
                return Color.argb(i, Integer.parseInt((String) AbstractC2388es.A01(matcher.group(1)), 10), Integer.parseInt((String) AbstractC2388es.A01(matcher.group(2)), 10), Integer.parseInt((String) AbstractC2388es.A01(matcher.group(3)), 10));
            }
        } else if (strReplace.startsWith(A03(1259, 3, 27))) {
            Matcher matcher2 = A05.matcher(strReplace);
            if (matcher2.matches()) {
                return Color.rgb(Integer.parseInt((String) AbstractC2388es.A01(matcher2.group(1)), 10), Integer.parseInt((String) AbstractC2388es.A01(matcher2.group(2)), 10), Integer.parseInt((String) AbstractC2388es.A01(matcher2.group(3)), 10));
            }
        } else {
            Integer color = A02.get(AbstractC2555hb.A01(strReplace));
            if (color != null) {
                return color.intValue();
            }
        }
        throw new IllegalArgumentException();
    }
}
