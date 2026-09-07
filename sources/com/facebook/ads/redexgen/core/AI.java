package com.facebook.ads.redexgen.core;

import android.content.SharedPreferences;
import com.facebook.ads.internal.util.process.ProcessUtils;
import com.google.common.base.Ascii;
import com.json.mediationsdk.utils.IronSourceConstants;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class AI {
    public static byte[] A00;
    public static final String A01;
    public static final Map<String, Integer> A02;
    public static final AtomicInteger A03;

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 57);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A04() {
        A00 = new byte[]{-82, -96, -50, -27, -9, -96, -10, -31, -20, -11, -27, -70, -96, -111, -88, -124, -87, -77, -80, -95, -76, -93, -88, -87, -82, -89, 96, -84, -81, -93, -95, -84, 96, -93, -81, -75, -82, -76, -91, -78, -77, 122, 96, -4, 33, Ascii.SYN, 37, Ascii.CAN, 32, Ascii.CAN, 33, 39, Ascii.FS, 33, Ascii.SUB, -45, Ascii.SYN, 34, 40, 33, 39, Ascii.CAN, 37, -19, -45, -7, Ascii.FS, Ascii.DLE, Ascii.SO, Ascii.EM, -16, Ascii.FS, 34, Ascii.ESC, 33, Ascii.DC2, Ascii.US, 32, -99, -96, -96, -91, -80, -91, -85, -86, -99, -88, -101, -91, -86, -94, -85, -35, -16, -16, -31, -23, -20, -16, -84, -86, -66, -80, -79, -67, -88, -82, -63, -84, -82, -71, -67, -78, -72, -73, -17, -5, -7, -70, -14, -19, -17, -15, -18, -5, -5, -9, -70, -19, -16, -1, -70, -40, -37, -49, -51, -40, -21, -49, -37, -31, -38, -32, -47, -34, -33, -87, -90, -71, -90, -95, -78, -95, -86, -80, -81, Ascii.CAN, Ascii.ESC, Ascii.SI, Ascii.CR, Ascii.CAN, Ascii.VT, Ascii.SI, Ascii.ESC, 33, Ascii.SUB, 32, 17, Ascii.RS, Ascii.US, -47, -62, -38, -51, -48, -62, -59, -10, -9, -28, -26, -18, -9, -11, -28, -26, -24, -48, -46, -65, -47, -42, -51, -62, -47, -45, -64, -46, -41, -50, -61, -67, -63, -51, -62, -61};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static void A06(AnonymousClass85 anonymousClass85, JR jr, Map<String, ?> map) throws JSONException {
        HashMap map2 = new HashMap();
        map2.put(A01(93, 7, 67), A01(13, 1, 40));
        A0A(anonymousClass85, map2);
        HashMap map3 = new HashMap();
        map3.put(A01(188, 7, 36), A01(157, 14, 115));
        map3.put(A01(195, 12, 37), String.valueOf(IronSourceConstants.BN_AUCTION_FAILED));
        map3.put(A01(100, 16, 16), A01(14, 1, 62));
        map3.put(A01(178, 10, 74), A01(65, 13, 116));
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, ?> entry : map.entrySet()) {
            jSONObject.put(entry.getKey(), String.valueOf(entry.getValue()));
        }
        if (anonymousClass85.A05().AAD()) {
            String str = A01(15, 28, 7) + jSONObject.toString(2);
        }
        map3.put(A01(78, 15, 3), jSONObject.toString());
        A0A(anonymousClass85, map3);
        AnonymousClass94 anonymousClass94A09 = anonymousClass85.A09();
        JSONObject jSONObjectA05 = C14148c.A05(new C14168e(anonymousClass94A09.A01(), anonymousClass94A09.A02(), map3));
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(jSONObjectA05);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(A01(147, 4, 12), new JSONObject(map2));
        jSONObject2.put(A01(151, 6, 3), jSONArray);
        C1684Jf c1684Jf = new C1684Jf();
        c1684Jf.put(A01(171, 7, 40), jSONObject2.toString());
        jr.AG6(anonymousClass85.A05().A7w(), c1684Jf.A08(), new C2635iz(anonymousClass85));
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static void A0A(AnonymousClass85 anonymousClass85, Map<String, String> map) {
        map.putAll(anonymousClass85.A04().A5Q());
    }

    static {
        A04();
        A01 = AI.class.getSimpleName();
        A03 = new AtomicInteger(0);
        A02 = new HashMap();
    }

    public static void A05(AnonymousClass85 anonymousClass85) {
        if (A0C(anonymousClass85)) {
            return;
        }
        synchronized (AI.class) {
            if (A03.get() != 0) {
                return;
            }
            A03.set(1);
            D8.A06.execute(new C2637j1(anonymousClass85));
        }
    }

    public static void A08(AnonymousClass85 anonymousClass85, String str) {
        int value;
        int iIntValue;
        if (A0C(anonymousClass85)) {
            return;
        }
        synchronized (AI.class) {
            if (A03.get() != 2) {
                if (A02.containsKey(str)) {
                    iIntValue = A02.get(str).intValue();
                } else {
                    iIntValue = 0;
                }
                value = iIntValue + 1;
                A02.put(str, Integer.valueOf(value));
            } else {
                SharedPreferences sharedPreferences = anonymousClass85.getApplicationContext().getSharedPreferences(ProcessUtils.getProcessSpecificName(A01(116, 31, 83), anonymousClass85), 0);
                value = sharedPreferences.getInt(str, 0) + 1;
                sharedPreferences.edit().putInt(str, value).apply();
            }
            if (anonymousClass85.A05().AAD()) {
                String str2 = A01(43, 22, Sdk.SDKError.Reason.INVALID_ADS_ENDPOINT_VALUE) + str + A01(0, 13, 71) + value;
            }
        }
    }

    public static void A09(AnonymousClass85 anonymousClass85, String str) {
        if (A0C(anonymousClass85)) {
            return;
        }
        D8.A06.execute(new C2636j0(anonymousClass85, str));
    }

    public static boolean A0B(double d, int i) {
        return i <= 0 || d >= 1.0d / ((double) i);
    }

    public static boolean A0C(AnonymousClass85 anonymousClass85) {
        if (anonymousClass85.A05().AAD()) {
            return false;
        }
        if (!AbstractC14519o.A0U(anonymousClass85)) {
            return true;
        }
        return A0B(anonymousClass85.A09().A00(), AbstractC14519o.A0C(anonymousClass85));
    }
}
