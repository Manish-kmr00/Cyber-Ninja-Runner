package com.facebook.ads.redexgen.core;

import com.google.common.base.Ascii;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.93, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AnonymousClass93 {
    public static byte[] A00;

    static {
        A03();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 65);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A00 = new byte[]{-74, -72, -85, -84, -59, -71, -86, -79, -59, -87, -89, -87, -82, -85, -35, -33, -46, -45, -20, -32, -47, -40, -20, -38, -50, -37, -50, -44, -46, -47, -20, -48, -50, -48, -43, -46, -54, -56, -54, -49, -52, -28, -31, -12, -27, -33, -13, -27, -12, 33, 52, 44, 37, 46, 33, 47, Ascii.ESC, 37, 42, -40, -61, -50, -41, -57};
    }

    public static String A01(C2698k0 c2698k0) {
        return BJ.A00(c2698k0).getString(A00(0, 14, 37), null);
    }

    public static Map<String, String> A02(C2698k0 c2698k0) {
        String sdkCache = BJ.A00(c2698k0).getString(A00(14, 22, 76), null);
        if (sdkCache == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(sdkCache);
            HashSet hashSet = new HashSet();
            HashMap map = new HashMap();
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                if (jSONObject2.getLong(A00(41, 8, 63)) + ((long) (jSONObject2.getInt(A00(49, 10, Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE)) * 1000)) < System.currentTimeMillis()) {
                    hashSet.add(next);
                } else {
                    map.put(next, jSONObject2.getString(A00(59, 5, 33)));
                }
            }
            if (!hashSet.isEmpty()) {
                Iterator it = hashSet.iterator();
                while (it.hasNext()) {
                    jSONObject.remove((String) it.next());
                }
                A06(c2698k0, jSONObject);
            }
            return map;
        } catch (JSONException e) {
            c2698k0.A08().AAu(A00(36, 5, 38), AbstractC14128a.A2U, new C14138b(e));
            return null;
        }
    }

    public static void A04(C2698k0 c2698k0, String str) {
        BJ.A00(c2698k0).edit().putString(A00(0, 14, 37), str).apply();
    }

    public static void A05(C2698k0 c2698k0, String str) {
        if (str == null) {
            return;
        }
        String sdkCache = BJ.A00(c2698k0).getString(A00(14, 22, 76), null);
        try {
            JSONObject jSONObject = sdkCache == null ? new JSONObject() : new JSONObject(sdkCache);
            JSONObject jSONObject2 = new JSONObject(str);
            Iterator<String> itKeys = jSONObject2.keys();
            while (itKeys.hasNext()) {
                String key = itKeys.next();
                JSONObject jSONObject3 = jSONObject2.getJSONObject(key);
                jSONObject3.put(A00(41, 8, 63), System.currentTimeMillis());
                jSONObject.put(key, jSONObject3);
            }
            A06(c2698k0, jSONObject);
        } catch (JSONException e) {
            c2698k0.A08().AAu(A00(36, 5, 38), AbstractC14128a.A2V, new C14138b(e));
        }
    }

    public static void A06(C2698k0 c2698k0, JSONObject jSONObject) {
        BJ.A00(c2698k0).edit().putString(A00(14, 22, 76), jSONObject.toString()).apply();
    }
}
