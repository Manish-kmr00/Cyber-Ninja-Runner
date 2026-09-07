package com.facebook.ads.redexgen.core;

import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.io.encoding.Base64;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.mo, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2866mo implements InterfaceC12581y {
    public static byte[] A08;
    public final EnumC12571x A00;
    public final String A01;
    public final String A02;
    public final String A03;
    public final String A04;
    public final String A05;
    public final Collection<String> A06;
    public final Map<String, String> A07;

    static {
        A02();
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static C2866mo A00(M5 m5, JSONObject jSONObject) {
        String strOptString = jSONObject.optString(A01(33, 6, 120));
        String strOptString2 = jSONObject.optString(A01(0, 18, Sdk.SDKError.Reason.PROTOBUF_SERIALIZATION_ERROR_VALUE));
        String strOptString3 = jSONObject.optString(A01(47, 10, 52));
        String strA02 = CV.A02(jSONObject, A01(18, 2, 83));
        EnumC12571x enumC12571xA00 = AbstractC12591z.A00(jSONObject);
        Collection<String> collectionA03 = AbstractC12591z.A03(m5, jSONObject);
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(A01(39, 8, 66));
        HashMap map = new HashMap();
        if (jSONObjectOptJSONObject != null) {
            Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                map.put(next, jSONObjectOptJSONObject.optString(next));
            }
        }
        return new C2866mo(strOptString, strOptString2, enumC12571xA00, collectionA03, map, strOptString3, strA02, CV.A02(jSONObject, A01(20, 13, 89)));
    }

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A08, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 119);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A08 = new byte[]{78, 80, 97, 86, 99, 78, 97, 86, 92, 91, 76, 80, 92, 90, 90, 78, 91, 81, 45, 62, 53, 62, 51, 66, 73, SignedBytes.MAX_POWER_OF_TWO, 68, 53, 52, 47, 51, SignedBytes.MAX_POWER_OF_TWO, Base64.padSymbol, 92, 80, 97, 90, 100, 95, 38, Ascii.RS, 45, Ascii.SUB, Ascii.GS, Ascii.SUB, 45, Ascii.SUB, Ascii.GS, Ascii.DLE, Ascii.FS, 32, Ascii.DLE, Ascii.RS, Ascii.US, 10, Ascii.DC4, Ascii.SI};
    }

    public C2866mo(String str, String str2, EnumC12571x enumC12571x, Collection<String> detectionStrings, Map<String, String> metadata, String str3, String str4, String str5) {
        this.A04 = str;
        this.A01 = str2;
        this.A00 = enumC12571x;
        this.A06 = detectionStrings;
        this.A07 = metadata;
        this.A05 = str3;
        this.A02 = str4;
        this.A03 = str5;
    }

    public final String A03() {
        return this.A01;
    }

    public final String A04() {
        return this.A04;
    }

    public final String A05() {
        return this.A03;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC12581y
    public final String A7E() {
        return this.A02;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC12581y
    public final Collection<String> A7f() {
        return this.A06;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC12581y
    public final EnumC12571x A8A() {
        return this.A00;
    }
}
