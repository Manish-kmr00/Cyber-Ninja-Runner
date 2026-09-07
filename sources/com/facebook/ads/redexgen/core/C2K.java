package com.facebook.ads.redexgen.core;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.json.mediationsdk.logger.IronSourceError;
import com.pubmatic.sdk.nativead.POBNativeConstants;
import com.safedk.android.analytics.brandsafety.creatives.discoveries.l;
import com.vungle.ads.internal.protos.Sdk;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import kotlin.io.encoding.Base64;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.2K, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class C2K {
    public static byte[] A00;
    public static String[] A01 = {"rumqJp0zjtXTj7VCZC", "TMr6rmpz3eFeqFi1AyEescympmX4mKYs", "yKc30ML1ifcOIqfiQ1Y0n8yeP8tTgKvd", "ifxbXcWS1dksd5gxUX3XXpeR8fGAW9", "ARavVsGpFp1prhlT9X", "AJCuKBIGe5nliswM6BoL4M7qaWNzDabC", "wiV5dRZ8vBgNvrirj4IbquLjXKvqAP", "mqXFYOGhIorfWow0I7OGPDKbQEIe0IwJ"};

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static C2860mi A01(C2699k1 c2699k1, JSONObject jSONObject, String str, boolean z, int i, int i2) {
        boolean zOptBoolean;
        int iOptInt;
        ArrayList arrayList;
        if (jSONObject == null) {
            return new C2860mi();
        }
        CC.A04(c2699k1, A02(0, 23, 112));
        String strOptString = jSONObject.optString(A02(371, 10, 72));
        int iOptInt2 = jSONObject.optInt(A02(116, 12, 106), 0);
        String strOptString2 = jSONObject.optString(A02(253, 13, 18));
        String strA02 = CV.A02(jSONObject, A02(266, 12, 52));
        Uri uriA00 = TextUtils.isEmpty(strA02) ? null : C5.A00(strA02);
        String strA03 = CV.A02(jSONObject, A02(128, 4, 54));
        String strA01 = AbstractC1510Cn.A01(strA03);
        String strA04 = CV.A02(jSONObject, A02(101, 15, 34));
        String strA05 = CV.A02(jSONObject, A02(485, 5, 32));
        String strA06 = CV.A02(jSONObject, A02(477, 8, 43));
        String strA07 = CV.A02(jSONObject, A02(POBNativeConstants.POB_NATIVE_MAIN_IMG_W, 8, 99));
        String strA08 = CV.A02(jSONObject, A02(431, 14, 94));
        String strA09 = CV.A02(jSONObject, A02(l.h, 16, Sdk.SDKError.Reason.INVALID_ADS_ENDPOINT_VALUE));
        String strA010 = CV.A02(jSONObject, A02(445, 21, 1));
        String strA011 = CV.A02(jSONObject, A02(87, 14, 99));
        String strA012 = CV.A02(jSONObject, A02(351, 20, Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE));
        String strA013 = CV.A02(jSONObject, A02(335, 16, 114));
        String strA014 = CV.A02(jSONObject, A02(318, 17, 38));
        String strA015 = CV.A02(jSONObject, A02(Sdk.SDKError.Reason.OMSDK_DOWNLOAD_JS_ERROR_VALUE, 14, 16));
        C1770Mv c1770MvA02 = C1770Mv.A02(jSONObject, c2699k1);
        AU auA00 = AU.A00(jSONObject.optJSONObject(A02(286, 4, 38)));
        AU auA01 = AU.A00(jSONObject.optJSONObject(A02(290, 5, 12)));
        AV avA00 = AV.A00(jSONObject.optJSONObject(A02(466, 11, 29)));
        String strA016 = CV.A02(jSONObject, A02(490, 15, 41));
        boolean zOptBoolean2 = jSONObject.optBoolean(A02(238, 15, 64));
        boolean zOptBoolean3 = jSONObject.optBoolean(A02(Sdk.SDKError.Reason.MRAID_JS_COPY_FAILED_VALUE, 19, 54));
        int iOptInt3 = jSONObject.optInt(A02(406, 25, Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE), 4);
        int iOptInt4 = jSONObject.optInt(A02(381, 25, 38), 0);
        int iOptInt5 = jSONObject.optInt(A02(569, 31, 83), 0);
        int iOptInt6 = jSONObject.optInt(A02(600, 26, 76), 1000);
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(A02(53, 15, 30));
        AU auA02 = jSONObjectOptJSONObject != null ? AU.A00(jSONObjectOptJSONObject) : null;
        String strA017 = CV.A02(jSONObject, A02(68, 19, 95));
        EnumC12571x enumC12571xA00 = AbstractC12591z.A00(jSONObject);
        Collection<String> collectionA03 = AbstractC12591z.A03(c2699k1, jSONObject);
        String strA018 = CV.A02(jSONObject, A02(560, 9, 10));
        long jOptLong = jSONObject.optLong(A02(536, 24, 82), -1L);
        if (A01[2].charAt(6) == 'o') {
            throw new RuntimeException();
        }
        String[] strArr = A01;
        strArr[1] = "3DgIwYJYxCZHaga7jdAdEfDBKsaQLEaY";
        strArr[0] = "PJjdxes2PDM40JhdCx";
        String strA019 = CV.A02(jSONObject, A02(IronSourceError.ERROR_NON_EXISTENT_INSTANCE, 9, Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE));
        String strA020 = A02(505, 22, Sdk.SDKError.Reason.INVALID_LOG_ERROR_ENDPOINT_VALUE);
        AZ az = jSONObject.has(strA020) ? jSONObject.optBoolean(strA020) ? AZ.A05 : AZ.A04 : AZ.A03;
        String strA021 = A02(FacebookRequestErrorClassification.EC_INVALID_TOKEN, 29, 111);
        if (A01[2].charAt(6) != 'o') {
            A01[5] = "EiaN2GrSxKmld9dBg6rLOOlJPXBJhn44";
            zOptBoolean = jSONObject.optBoolean(strA021);
            iOptInt = jSONObject.optInt(A02(154, 36, 107), 100);
            arrayList = null;
        } else {
            zOptBoolean = jSONObject.optBoolean(strA021);
            iOptInt = jSONObject.optInt(A02(154, 36, 107), 100);
            arrayList = null;
        }
        try {
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(A02(POBNativeConstants.POB_NATIVE_MAIN_IMG_H, 8, 26));
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                int length = jSONArrayOptJSONArray.length();
                ArrayList arrayList2 = new ArrayList(length);
                for (int i3 = 0; i3 < length; i3++) {
                    try {
                        arrayList2.add(A01(c2699k1, jSONArrayOptJSONArray.getJSONObject(i3), str, true, i3, length));
                    } catch (JSONException e) {
                        e = e;
                        arrayList = arrayList2;
                        c2699k1.A08().AAu(A02(311, 7, 111), AbstractC14128a.A2A, new C14138b(e));
                        Log.e(C2873mv.A0E, A02(23, 30, 97), e);
                        return new C2860mi(strA017, strA01, strA03, strA04, strA05, strA06, strA07, strA08, strA09, strA010, strA011, strA012, strA013, strA014, strA015, auA02, c1770MvA02, auA00, auA01, avA00, strA018, strA019, jOptLong, az, z, i, i2, arrayList, str, strOptString, iOptInt2, strOptString2, uriA00, strA016, zOptBoolean2, zOptBoolean3, iOptInt4, iOptInt3, iOptInt5, iOptInt6, enumC12571xA00, collectionA03, iOptInt, zOptBoolean);
                    }
                }
                arrayList = arrayList2;
            }
        } catch (JSONException e2) {
            e = e2;
        }
        return new C2860mi(strA017, strA01, strA03, strA04, strA05, strA06, strA07, strA08, strA09, strA010, strA011, strA012, strA013, strA014, strA015, auA02, c1770MvA02, auA00, auA01, avA00, strA018, strA019, jOptLong, az, z, i, i2, arrayList, str, strOptString, iOptInt2, strOptString2, uriA00, strA016, zOptBoolean2, zOptBoolean3, iOptInt4, iOptInt3, iOptInt5, iOptInt6, enumC12571xA00, collectionA03, iOptInt, zOptBoolean);
    }

    public static String A02(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 105);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A00 = new byte[]{Ascii.SUB, 78, Base64.padSymbol, 66, 62, 71, 60, 62, -7, 39, 62, 77, 80, 72, 75, 68, -7, 37, 72, 58, Base64.padSymbol, 62, Base64.padSymbol, Ascii.US, 56, 43, 44, 54, 47, -22, 62, 57, -22, 58, 43, 60, Base64.padSymbol, 47, -22, 45, 43, 60, 57, 63, Base64.padSymbol, 47, 54, -22, 46, 43, 62, 43, -8, -24, -21, -26, -22, -17, -10, -16, -22, -20, -6, -26, -16, -22, -10, -11, 41, 44, 39, 43, 48, 55, 49, 43, 45, 59, 39, 52, 49, 54, 51, 39, Base64.padSymbol, 58, 52, 45, 48, 43, SignedBytes.MAX_POWER_OF_TWO, 62, 45, 58, 63, 56, 45, SignedBytes.MAX_POWER_OF_TWO, 53, 59, 58, -20, -17, 1, -16, -3, -1, -12, -2, -16, -3, -22, -7, -20, -8, -16, 52, 65, 50, 63, 66, 58, 66, 50, 71, 76, 67, 56, 1, Ascii.SO, 3, Ascii.CAN, -36, -38, -27, -27, -40, -19, -24, -40, -38, -36, -19, -30, -24, -25, -26, -28, -11, -14, -8, -10, -24, -17, 55, 67, 66, 72, 53, Base64.padSymbol, 66, 57, 70, 51, 74, Base64.padSymbol, 57, 75, 53, 54, Base64.padSymbol, SignedBytes.MAX_POWER_OF_TWO, Base64.padSymbol, 72, 77, 51, 55, 60, 57, 55, 63, 51, Base64.padSymbol, 66, 72, 57, 70, 74, 53, SignedBytes.MAX_POWER_OF_TWO, 59, 71, 70, 76, 57, 65, 70, Base64.padSymbol, 74, 55, 78, 65, Base64.padSymbol, 79, 57, 58, 65, 68, 65, 76, 81, 55, Base64.padSymbol, 70, 57, 58, 68, Base64.padSymbol, 60, 4, Ascii.CR, 0, 1, Ascii.VT, 4, -2, Ascii.DC2, Ascii.CR, 0, Ascii.SI, Ascii.DC2, 7, Ascii.SO, 19, -2, Ascii.VT, Ascii.SO, 6, Ascii.SO, Ascii.ETB, 10, Ascii.VT, Ascii.NAK, Ascii.SO, 8, Ascii.US, Ascii.DC2, Ascii.SO, 32, 8, Ascii.NAK, Ascii.CAN, Ascii.DLE, -32, -23, -34, -19, -12, -21, -17, -32, -33, -38, -34, -21, -24, 3, -1, -2, 1, -4, 0, Ascii.FF, 10, 10, -2, Ascii.VT, 1, 52, 49, 45, 48, 56, 53, 58, 49, -8, -14, -2, -3, -34, -30, -42, -36, -38, 79, 76, 81, 78, 66, 71, 72, 86, 70, 85, 76, 83, 87, 76, 82, 81, 72, 57, 74, 75, 65, 70, 63, -1, -16, 4, 2, -12, -18, 3, 1, -16, -3, 2, -5, -16, 3, -8, -2, -3, 75, 71, 60, 84, 58, 79, 77, 60, 73, 78, 71, 60, 79, 68, 74, 73, 86, 88, 85, 83, 85, 90, 75, 74, 69, 90, 88, 71, 84, 89, 82, 71, 90, 79, 85, 84, 35, Ascii.SYN, 34, 38, Ascii.SYN, 36, 37, Ascii.DLE, Ascii.SUB, Ascii.NAK, 2, -3, -16, -1, 2, -9, -2, 3, -18, -14, -2, -4, -1, 1, -12, 2, 2, -18, 0, 4, -16, -5, -8, 3, 8, 87, 82, 69, 84, 87, 76, 83, 88, 67, 80, 83, 75, 67, 72, 73, 80, 69, 93, 67, 87, 73, 71, 83, 82, 72, 58, 54, 42, 48, 40, 51, 38, 42, 54, 53, 59, 44, 63, 59, -35, -38, -39, -40, -35, -39, -36, -49, -50, -55, -34, -36, -53, -40, -35, -42, -53, -34, -45, -39, -40, -7, -6, -25, -8, -27, -8, -25, -6, -17, -12, -19, 7, 9, -10, 8, -3, 8, 0, -7, -3, -14, -3, -11, -18, 7, 5, -9, -10, -15, 4, -9, 2, 1, 4, 6, -15, 7, 4, -2, 91, 78, 73, 74, 84, 68, 70, 90, 89, 84, 85, 81, 70, 94, 68, 74, 83, 70, 71, 81, 74, 73, 90, 77, 72, 73, 83, 67, 81, 84, 72, 49, 36, Ascii.US, 32, 42, Ascii.SUB, 43, 45, 32, 39, 42, Ascii.FS, Ascii.US, Ascii.SUB, 46, 36, 53, 32, Ascii.SUB, Ascii.GS, 52, 47, 32, 46, -23, -36, -41, -40, -30, -46, -24, -27, -33, 50, 37, 33, 51, Ascii.GS, Ascii.RS, 37, 40, 37, 48, 53, Ascii.ESC, Ascii.US, 36, 33, Ascii.US, 39, Ascii.ESC, 37, 42, 37, 48, 37, Ascii.GS, 40, Ascii.ESC, 32, 33, 40, Ascii.GS, 53, 43, Ascii.RS, Ascii.SUB, 44, Ascii.SYN, Ascii.ETB, Ascii.RS, 33, Ascii.RS, 41, 46, Ascii.DC4, Ascii.CAN, Ascii.GS, Ascii.SUB, Ascii.CAN, 32, Ascii.DC4, Ascii.RS, 35, 41, Ascii.SUB, 39, 43, Ascii.SYN, 33};
    }

    static {
        A03();
    }

    public static C2860mi A00(C2699k1 c2699k1, JSONObject jSONObject, String str) {
        return A01(c2699k1, jSONObject, str, false, -1, 0);
    }
}
