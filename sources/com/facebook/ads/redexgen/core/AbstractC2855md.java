package com.facebook.ads.redexgen.core;

import com.facebook.ads.internal.adapters.datamodels.AdInfo;
import com.google.common.base.Ascii;
import com.vungle.ads.internal.protos.Sdk;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.io.encoding.Base64;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.md, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC2855md extends C2S implements Serializable {
    public static JSONObject A0H = null;
    public static byte[] A0I = null;
    public static String[] A0J = {"MTFiGS2hyLPfirnVlCyKu8FL5ydCU71a", "6CtUdYtPnHS0iwt", "3FBcQYGRSJhXKbj7ODsddhFyR1abGnGF", "UQ7LtGE24TX4QkAlsGDlXXS4Vcev", "JcPJu", "s3C", "M3uL5ar3Pz1QrNsTamNzt8iOeyqnSnZC", "bpoJK"};
    public static final LinkedHashMap<String, String> A0K;
    public static final long serialVersionUID = -5352540727250859603L;
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public int A04;
    public C2P A05;
    public C12672h A06;
    public C12702k A07;
    public C12732n A08;
    public C12792t A09;
    public String A0A;
    public final List<C2T> A0F;
    public boolean A0B = false;
    public boolean A0C = false;
    public boolean A0E = false;
    public boolean A0D = false;
    public final Map<String, String> A0G = new HashMap();

    public static String A05(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0I, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 112);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A09() {
        A0I = new byte[]{81, 84, 111, 83, 88, 95, 89, 83, 85, 67, 111, 92, 89, 94, 91, 111, 69, 66, 92, 122, 117, 68, 119, 116, 124, 116, 68, 111, 98, 107, 126, Ascii.GS, 9, 8, 19, Ascii.US, Ascii.DLE, Ascii.NAK, Ascii.US, Ascii.ETB, 35, Ascii.US, 19, 9, Ascii.DC2, 8, Ascii.CAN, 19, Ascii.VT, Ascii.DC2, 35, 8, Ascii.NAK, 17, Ascii.EM, 53, 33, 32, 59, 55, 56, Base64.padSymbol, 55, 63, Ascii.VT, 55, 32, 53, Ascii.VT, 32, Base64.padSymbol, 57, 49, 76, 88, 89, 66, 78, 65, 68, 78, 70, 114, 75, 65, 76, 91, 66, 95, 85, 87, 85, 94, 83, 105, 87, 69, 69, 83, 66, 69, 45, 47, 60, 33, 59, Base64.padSymbol, 43, 34, 59, 48, 57, 49, 54, 7, 57, 60, 43, 7, 62, 42, Base64.padSymbol, 41, 45, Base64.padSymbol, 54, 59, 33, Ascii.SI, 3, 1, 66, 10, Ascii.CR, Ascii.SI, 9, Ascii.SO, 3, 3, 7, 66, Ascii.CR, 8, Ascii.US, 66, 5, 2, Ascii.CAN, 9, Ascii.RS, Ascii.US, Ascii.CAN, 5, Ascii.CAN, 5, Ascii.CR, 0, 66, 10, 5, 2, 5, Ascii.US, 4, 51, Ascii.CR, Ascii.SI, Ascii.CAN, 5, Ascii.SUB, 5, Ascii.CAN, Ascii.NAK, 6, 17, 91, 76, 83, 96, 94, 79, 79, 96, 93, 80, 74, 81, 91, 96, 74, 77, 83, 76, 36, 32, 118, 35, Ascii.GS, 37, 50, Ascii.GS, 45, 52, 39, 48, 46, 35, 59, Ascii.GS, 49, 39, 33, 55, 48, 39, Ascii.GS, 54, 45, 41, 39, 44, 101, 111, 99, 98, 84, 83, 78, 73, 92, 81, 81, 98, 79, 88, 91, 88, 79, 79, 88, 79, 120, 127, 101, 116, 99, 98, 101, 120, 101, 120, 112, 125, 67, 78, 65, 75, 92, 76, 78, 95, 74, 86, 91, 67, 85, 79, 78, 82, 77, 80, 86, 80, 67, 75, 86, Ascii.US, 8, Ascii.SUB, Ascii.FF, Ascii.US, 9, 8, 9, 50, Ascii.ESC, 4, 9, 8, 2, 68, 95, 88, 66, 91, 83, 104, 91, 88, 80, 104, 86, 89, 78, 104, 94, 86, 85, 104, 84, 91, 94, 84, 92, 104, 88, 89, 84, 82, 121, 98, 101, 125, 85, 100, 111, 114, 126, 85, 105, 126, 107, 85, 101, 100, 85, 111, 100, 110, 105, 107, 120, 110, Ascii.FF, 17, Ascii.FF, Ascii.DC4, Ascii.GS, 45, 54, 54, 53, 59, 56, 43, 6, 56, 58, 45, 6, 56, 42, 6, 58, 45, 56, 60, 59, 37};
    }

    static {
        A09();
        A0K = new LinkedHashMap<>(10, 0.75f, false);
    }

    public AbstractC2855md(List<C2T> list) {
        this.A0F = list;
    }

    public static String A06(String str) {
        return A0K.get(str);
    }

    private HashMap<String, String> A07(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(A05(175, 18, 79));
        HashMap<String, String> map = new HashMap<>();
        if (jSONObjectOptJSONObject == null) {
            return map;
        }
        Iterator<String> nameItr = jSONObjectOptJSONObject.keys();
        while (nameItr.hasNext()) {
            try {
                String next = nameItr.next();
                map.put(next, jSONObjectOptJSONObject.getString(next));
            } catch (JSONException unused) {
            }
        }
        return map;
    }

    public static List<C2T> A08(JSONObject jSONObject, C2699k1 c2699k1, InterfaceC12652f interfaceC12652f) {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(A05(101, 8, 62));
        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
            return AbstractC12612b.A01(jSONArrayOptJSONArray, jSONObject, c2699k1, interfaceC12652f);
        }
        List<AdInfo> adInfoList = new ArrayList<>();
        C2T c2tA00 = C2T.A00(jSONObject);
        interfaceC12652f.A3o(c2tA00, jSONObject);
        adInfoList.add(c2tA00);
        return adInfoList;
    }

    private void A0A(int i) {
        this.A00 = i;
    }

    private final void A0B(int i) {
        this.A04 = i;
    }

    private void A0C(C2P c2p) {
        this.A05 = c2p;
    }

    private final void A0D(C12672h c12672h) {
        this.A06 = c12672h;
    }

    private void A0E(C12702k c12702k) {
        this.A07 = c12702k;
    }

    private final void A0F(C12732n c12732n) {
        this.A08 = c12732n;
    }

    private void A0G(C12792t c12792t) {
        this.A09 = c12792t;
    }

    private void A0H(String str) {
        this.A0A = str;
    }

    public final int A1V() {
        return this.A00;
    }

    public final int A1W() {
        return this.A01;
    }

    public final int A1X() {
        return this.A02;
    }

    public final int A1Y() {
        return this.A03;
    }

    public final int A1Z() {
        return this.A04;
    }

    public final C2P A1a() {
        return this.A05;
    }

    public final C2T A1b() {
        return this.A0F.get(0);
    }

    public final C12672h A1c() {
        return this.A06;
    }

    public final C12702k A1d() {
        return this.A07;
    }

    public final C12732n A1e() {
        return this.A08;
    }

    public final C12792t A1f() {
        return this.A09;
    }

    public final String A1g() {
        return this.A0A;
    }

    public final String A1h(String str) {
        return this.A0G.get(str);
    }

    public final List<C2T> A1i() {
        return Collections.unmodifiableList(this.A0F);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:4:0x000b  */
    public final void A1j(DR dr) {
        byte b;
        String strA0i = A0i();
        switch (strA0i.hashCode()) {
            case -1364000502:
                if (!strA0i.equals(A05(276, 14, 29))) {
                    b = -1;
                } else {
                    b = 1;
                }
                break;
            case 604727084:
                if (!strA0i.equals(A05(241, 12, 97))) {
                    b = -1;
                } else {
                    b = 0;
                }
                break;
            default:
                b = -1;
                break;
        }
        switch (b) {
            case 0:
                dr.A4Z(A05(128, 45, 28));
                break;
            case 1:
                break;
            default:
                return;
        }
        dr.A4Z(IV.A08.A03());
    }

    public final void A1k(JSONObject jSONObject) {
        String strA05;
        A0D(C12672h.A00(jSONObject.optJSONObject(A05(225, 16, 77))));
        A0H = jSONObject.optJSONObject(A05(89, 12, 70));
        C12722m c12722mA06 = new C12722m().A06(jSONObject.optString(A05(343, 5, 8)));
        String strA06 = A05(Sdk.SDKError.Reason.AD_LOAD_FAIL_RETRY_AFTER_VALUE, 4, Sdk.SDKError.Reason.INVALID_LOG_ERROR_ENDPOINT_VALUE);
        if (jSONObject.optJSONObject(strA06) != null) {
            strA05 = jSONObject.optJSONObject(strA06).optString(A05(366, 3, 57));
        } else {
            strA05 = A05(0, 0, 15);
        }
        A0F(c12722mA06.A05(strA05).A04(jSONObject.optString(A05(0, 19, 64))).A07(AbstractC12742o.A03(jSONObject)).A08());
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(A05(262, 6, 74));
        JSONObject layoutObject = jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optJSONObject(A05(268, 8, 82)) : null;
        C12622c c12622cA01 = C12622c.A01(layoutObject);
        String[] strArr = A0J;
        if (strArr[1].length() == strArr[7].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0J;
        strArr2[2] = "MaJS3iOjDVpkOvzQIu4XnTvkYtI43ENf";
        strArr2[6] = "dcadpZfpRdAwhtf1LK3imqQWfZ9Fu8JJ";
        A0C(new C2P(c12622cA01, C12622c.A01(jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optJSONObject(A05(253, 9, 95)) : null)));
        A0G(AbstractC12742o.A01(jSONObject));
        A0E(AbstractC12742o.A00(jSONObject));
        A0A(jSONObject.optInt(A05(19, 12, 107), 0));
        A0B(jSONObject.optInt(A05(109, 19, 40), -1));
        this.A0G.putAll(A07(jSONObject));
        this.A03 = jSONObject.optInt(A05(55, 18, 36), 0);
        this.A01 = jSONObject.optInt(A05(73, 16, 93), 1);
        this.A0E = jSONObject.optBoolean(A05(348, 18, 41), false);
        this.A0D = jSONObject.optBoolean(A05(Sdk.SDKError.Reason.SILENT_MODE_MONITOR_ERROR_VALUE, 24, Sdk.SDKError.Reason.INVALID_ADS_ENDPOINT_VALUE), false);
        this.A0C = jSONObject.optBoolean(A05(290, 29, 71), false);
        this.A02 = jSONObject.optInt(A05(31, 24, 12), this.A03);
        String strOptString = jSONObject.optString(A05(173, 2, 21));
        A0H(strOptString);
        A0K.put(strOptString, jSONObject.optString(A05(193, 28, 50)));
        A12(jSONObject);
    }

    public final void A1l(boolean z) {
        this.A0B = z;
    }

    public final boolean A1m() {
        return this.A0B;
    }

    public final boolean A1n() {
        return this.A0C;
    }

    public final boolean A1o() {
        return this.A0D;
    }

    public final boolean A1p() {
        return this.A0E;
    }
}
