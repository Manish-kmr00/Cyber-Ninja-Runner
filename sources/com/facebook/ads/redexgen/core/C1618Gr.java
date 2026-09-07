package com.facebook.ads.redexgen.core;

import android.util.Base64;
import com.google.common.base.Ascii;
import com.vungle.ads.internal.protos.Sdk;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Gr, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1618Gr {
    public static byte[] A0K;
    public static String[] A0L = {"QJ7W4e4PJvclr77cDyA2o1qIxMihX3tE", "RH0qaB2vXSlWTV", "TMgHIdn8e0jRrsJAq9rOuGvMgMhVzLRj", "8zeB", "h3DHJTryp4843oQXq4V40YlaMfy8fMY9", "5EUDcWbBtTwBMpPZObVlQHA1Luk9oa", "lBOFkjXt9ejA3EivMitoOA5tI6ifJJ8U", "jkkICjKEbDq5EoZUmm0oqZxt7dyZ5DGY"};
    public static final AtomicInteger A0M;
    public static final AtomicInteger A0N;
    public InterfaceC1607Gg A02;
    public InterfaceC1616Gp A03;
    public InterfaceC1617Gq A04;
    public JL A05;
    public final int A08;
    public final AbstractC2855md A09;
    public final C14067t A0A;
    public final C2699k1 A0B;
    public final A7 A0C;
    public final AF A0D;
    public final C1605Ge A0E;
    public final C2412fH A0F;
    public final C1626Gz A0G;
    public final H0 A0H;
    public final LinkedList<C1615Go> A0J = new LinkedList<>();
    public C1518Cv A01 = new C1518Cv();
    public boolean A07 = true;
    public boolean A06 = false;
    public long A00 = -1;
    public final String A0I = UUID.randomUUID().toString();

    public static String A0A(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0K, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 56);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0D() {
        A0K = new byte[]{-71, -79, -87, -84, -76, -87, -85, -67, -22, -32, -18, -21, -27, -32, -59, -22, -16, -31, -18, -30, -35, -33, -31, -12, -9, -27, -8, 3, 2, 5, 7, -4, 1, -6, -39, -4, 1, -4, 6, -5, -8, -9, -69, -70, -72, 6, -70, -68, -50, -37, -34, -52, -33, -22, -23, -20, -18, -29, -24, -31, -51, -18, -37, -20, -18, -33, -34, -94, -95, -97, -19, -95, -93, -75, -103, -84, -84, -103, -101, -96, -99, -100, -113, -114, -122, -83, -91, -16, -17, 2, -15, -10, -13, -14, -44, 0, -17, -5, -13, -46, -17, 2, -17, 6, Ascii.CAN, Ascii.NAK, Ascii.NAK, 8, 17, Ascii.ETB, -6, -7, -15, Ascii.CAN, Ascii.DLE, Ascii.FS, 40, Ascii.ETB, 35, Ascii.ESC, 41, -52, -53, -98, -64, -47, -58, -45, -58, -47, -42, -83, -66, -46, -48, -62, -63, -123, -124, -126, -48, -124, -122, -104, -29, -30, -75, -41, -24, -35, -22, -35, -24, -19, -58, -39, -25, -23, -31, -39, -40, -100, -101, -103, -25, -101, -99, -81, Ascii.DC4, 19, -24, 17, Ascii.DC4, Ascii.CAN, 10, -21, Ascii.SUB, 17, 17, Ascii.CAN, 8, Ascii.ETB, 10, 10, 19, -5, Ascii.SO, 10, Ascii.FS, -51, -52, -54, Ascii.CAN, -52, -50, -83, -84, -124, -77, -86, -86, -79, -95, -80, -93, -93, -84, -108, -89, -93, -75, 102, 101, 99, -79, 101, 103, -82, -83, -107, -96, -85, -76, -92, -111, -92, -96, -93, 103, 102, 100, -78, 102, 107, 95, 102, 100, -78, 102, 107, 95, 102, 100, -78, 102, 104, 122, Ascii.FS, Ascii.ESC, 3, Ascii.SO, Ascii.EM, 34, Ascii.DC2, 4, Ascii.US, Ascii.SYN, 33, 33, Ascii.DC2, Ascii.ESC, -43, -44, -46, 32, -44, -39, -51, -44, -46, 32, -44, -42, -24, -71, -85, -87, -75, -76, -86, -91, -87, -82, -89, -76, -76, -85, -78, -81, -95, -80, 125, -79, -80, -92, -121, -95, -75, 100, 99, 97, -81, 99, 104, 99, 97, -81, 99, 101, 119, -9, -23, -8, -58, -27, -9, -23, -70, -72, -59, -9, -9, -23, -8, -9, -84, -85, -87, -9, -85, -80, -85, -87, -9, -85, -83, -31, -45, -30, -80, -49, -31, -45, -92, -94, -79, -35, -36, -44, -41, -43, -106, -107, -109, -31, -107, -102, -107, -109, -31, -107, -105, -77, -82, -77, -96, -85, -106, -107, -115, -76, -84, -58, -61, -67, -34, -47, -52, -51, -41, -83, -34, -51, -42, -36, -112, -113, -115, -37, -113, -108, -120, -113, -115, -37, -113, -108, -120, -113, -115, -37, -113, -111, -93, -78, -91, -95, -77, -114, -95, -99, -96, -75, -112, -85, -113, -92, -85, -77, 100, 99, 97, -81, 99, 101, 119};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public final void A0i(Map<String, String> map) {
        String strA0A = A0A(87, 16, 86);
        if (map.containsKey(strA0A) && C14499m.A1t(this.A0B)) {
            try {
                JSONArray jSONArray = new JSONArray(map.get(strA0A));
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONArray jSONArray2 = new JSONArray(jSONArray.getString(i));
                    String string = jSONArray2.getString(0);
                    String string2 = jSONArray2.getString(1);
                    String string3 = jSONArray2.getString(2);
                    String string4 = jSONArray2.getString(3);
                    if (string != null && string2 != null && string3 != null) {
                        C1748Ls c1748Ls = new C1748Ls(this.A09.A1g(), Long.parseLong(string), Long.parseLong(string2), Long.parseLong(string3));
                        c1748Ls.A06(Long.parseLong(string4));
                        arrayList.add(c1748Ls);
                    }
                }
                String strA01 = C1747Lr.A01(arrayList);
                HashMap map2 = new HashMap();
                map2.put(A0A(115, 6, 126), strA01);
                if (strA01 != null) {
                    this.A0C.ABL(this.A09.A1g(), map2);
                }
            } catch (Exception e) {
                this.A0B.A08().AAu(A0A(274, 14, 14), 3600, new C14138b(e));
            }
        }
        boolean zContainsKey = map.containsKey(strA0A);
        if (A0L[0].charAt(7) != 'P') {
            throw new RuntimeException();
        }
        String[] strArr = A0L;
        strArr[4] = "rUTki8v1ZwD35w0l1wx8OInXS6BY1neH";
        strArr[7] = "OANcXSK4xu3EG1xYwZDVITEIbLyQGtEs";
        if (zContainsKey) {
            map.remove(strA0A);
        }
        this.A0C.AAt(this.A09.A1g(), new FB(map).A03(this.A05).A05());
    }

    static {
        A0D();
        A0N = new AtomicInteger();
        A0M = new AtomicInteger();
    }

    public C1618Gr(C2699k1 c2699k1, AbstractC2855md abstractC2855md, A7 a7, int i) {
        this.A0B = c2699k1;
        this.A0C = a7;
        this.A09 = abstractC2855md;
        this.A08 = i;
        this.A0F = new C2412fH(this, c2699k1);
        this.A0A = new C14067t(this.A0B);
        this.A0D = new AF(abstractC2855md.A1g(), a7);
        this.A0E = new C1605Ge(abstractC2855md.A0r(), abstractC2855md.A1b().A0F().A09(), i);
        this.A0H = H1.A00(this.A0B, abstractC2855md.A0u(), this.A0A, this.A0D, this.A0E, A0H());
        this.A0G = new C1626Gz(this.A0B, this, a7, this.A0E, this.A0I, abstractC2855md.A1g());
    }

    public static AtomicInteger A0B() {
        return A0M;
    }

    private void A0C() {
        A0F(new C1615Go(A0A(288, 22, 4), new String[]{this.A0I, A0A(1, 6, 67)}));
        String strReplace = Base64.encodeToString(this.A0H.A04.toString().getBytes(), 0).replace(A0A(0, 1, Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE), A0A(0, 0, 35));
        String assets = this.A0I;
        A0F(new C1615Go(A0A(310, 26, 76), new String[]{strReplace, assets}));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void A0E() {
        if (this.A06) {
            while (!this.A0J.isEmpty()) {
                C1615Go c1615GoPoll = this.A0J.poll();
                if (c1615GoPoll != null) {
                    this.A0F.A05(String.format(Locale.US, c1615GoPoll.A00, c1615GoPoll.A02));
                    if (c1615GoPoll.A01) {
                        this.A0D.A04(AE.A0L, null);
                        this.A0B.A0F().A5v(c1615GoPoll.A00);
                    } else {
                        continue;
                    }
                }
            }
        }
    }

    private synchronized void A0F(C1615Go c1615Go) {
        this.A0J.offer(c1615Go);
        A0E();
    }

    private boolean A0H() {
        return !A0I();
    }

    private boolean A0I() {
        return C14499m.A2q(this.A0B, J3.A03());
    }

    public final AF A0K() {
        return this.A0D;
    }

    public final C1518Cv A0L() {
        return this.A01;
    }

    public final C1605Ge A0M() {
        return this.A0E;
    }

    public final InterfaceC1607Gg A0N() {
        return this.A02;
    }

    public final C2412fH A0O() {
        return this.A0F;
    }

    public final void A0P() {
        A0F(new C1615Go(A0A(23, 26, 91), new String[]{this.A0I}));
    }

    public final void A0Q() {
        A0F(new C1615Go(A0A(49, 25, 66), new String[]{this.A0I}));
    }

    public final void A0R() {
        this.A07 = true;
    }

    public final void A0S() {
        this.A07 = false;
    }

    public final void A0T() {
        A0F(new C1615Go(A0A(Sdk.SDKError.Reason.TPAT_ERROR_VALUE, 23, 37), new String[]{this.A0I}));
    }

    public final void A0U() {
        A0F(new C1615Go(A0A(168, 27, 109), new String[]{this.A0I}));
    }

    public final void A0V() {
        A0F(new C1615Go(A0A(195, 22, 6), new String[]{this.A0I}));
    }

    public final void A0W() {
        A0F(new C1615Go(A0A(404, 22, 4), new String[]{this.A0I}));
    }

    public final void A0X() {
        this.A0F.addJavascriptInterface(this.A0G, A0A(7, 16, 68));
        this.A0D.A04(AE.A0O, null);
        String str = this.A0H.A00;
        this.A0F.loadUrl(str);
        this.A00 = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        try {
            String url = A0A(372, 3, 25);
            jSONObject.put(url, str);
            String url2 = A0A(103, 12, 107);
            jSONObject.put(url2, AbstractC1619Gs.A00());
            String url3 = A0A(362, 10, 7);
            jSONObject.put(url3, A0N.getAndIncrement());
            String url4 = A0A(74, 13, 0);
            jSONObject.put(url4, A0M);
        } catch (JSONException unused) {
        }
        this.A0B.A0F().A61(jSONObject.toString());
        A0C();
    }

    public final void A0Y() {
        A0F(new C1615Go(A0A(144, 24, 60), new String[]{this.A0I}));
    }

    public final void A0Z(C1518Cv c1518Cv) {
        this.A01 = c1518Cv;
    }

    public final void A0a(InterfaceC1607Gg interfaceC1607Gg) {
        this.A02 = interfaceC1607Gg;
    }

    public final void A0b(InterfaceC1616Gp interfaceC1616Gp) {
        this.A03 = interfaceC1616Gp;
    }

    public final void A0c(InterfaceC1617Gq interfaceC1617Gq) {
        this.A04 = interfaceC1617Gq;
    }

    public final void A0d(InterfaceC2411fG interfaceC2411fG) {
        this.A0G.A0N(interfaceC2411fG);
    }

    public final void A0e(JL jl) {
        this.A05 = jl;
    }

    public final void A0f(String str) {
        A0F(new C1615Go(A0A(247, 27, 117), new String[]{this.A0I, str}));
    }

    public final void A0g(String str, String str2) {
        A0F(new C1615Go(A0A(Sdk.SDKError.Reason.AD_RESPONSE_TIMED_OUT_VALUE, 30, 7), new String[]{this.A0I, str, str2}));
    }

    public final void A0h(String str, JSONObject jSONObject) {
        A0F(new C1615Go(A0A(375, 29, 48), new String[]{this.A0I, str, jSONObject.toString()}, false));
    }

    public final void A0j(JSONObject jSONObject) {
        String strReplace = Base64.encodeToString(jSONObject.toString().getBytes(), 0).replace(A0A(0, 1, Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE), A0A(0, 0, 35));
        String assets = this.A0I;
        A0F(new C1615Go(A0A(336, 26, 54), new String[]{strReplace, assets}));
    }

    public final boolean A0k() {
        return this.A0G.A0O();
    }

    public final boolean A0l() {
        return this.A07;
    }
}
