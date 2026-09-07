package com.facebook.ads.redexgen.core;

import android.content.Intent;
import android.text.TextUtils;
import com.facebook.ads.AdError;
import com.facebook.ads.CacheFlag;
import com.facebook.ads.RewardData;
import com.google.common.base.Ascii;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.2v, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C12812v {
    public static byte[] A05;
    public static String[] A06 = {"SwW", "nKJOmWTx3LjNZvOp7YbBROgXIyGkfXUh", "cNvS8LZQYgXEdOP85dYAvAy4C3J", "ICxq6EmLG0dgZi7UJ5PBV2wBsvrmCfpb", "tKedy3gZYTLe", "bmz0vq", "hvIAQTYE0cdtFIL2", "tj9oqRvQS19ndgZTuA"};
    public C14067t A00;
    public FF A01 = FF.A05;
    public ArrayList<C1618Gr> A02 = new ArrayList<>();
    public final C2S A03;
    public final InterfaceC12802u A04;

    public static String A04(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A05, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 97);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A06() {
        A05 = new byte[]{-35, Ascii.ETB, 35, Ascii.FS, Ascii.ESC, -66, -29, -23, -38, -25, -29, -42, -31, -107, -70, -25, -25, -28, -25, -107, -89, -91, -91, -85, -107, -20, -34, -23, -35, -28, -22, -23, -107, -42, -107, -21, -42, -31, -34, -39, -107, -74, -39, -66, -29, -37, -28, -93, Ascii.NAK, Ascii.CAN, 19, Ascii.CAN, Ascii.NAK, 40, Ascii.NAK, 19, Ascii.SYN, 41, 34, Ascii.CAN, 32, Ascii.EM, -29, -14, -21, -36, -31, -38, -30, -25, -40, -23, -38, -21, -38, -26, -20, Ascii.DC2, Ascii.ETB, Ascii.DLE, Ascii.CAN, Ascii.GS, Ascii.DC4, 19, -16, 19, -13, Ascii.DLE, 35, Ascii.DLE, -15, 36, Ascii.GS, 19, Ascii.ESC, Ascii.DC4, 63, 68, 74, 59, 72, 73, 74, 63, 74, 63, 55, 66};
    }

    static {
        A06();
    }

    public C12812v(C2699k1 c2699k1, AnonymousClass38 anonymousClass38, InterfaceC12802u interfaceC12802u, String str) {
        JSONObject dataObject = anonymousClass38.A03();
        this.A03 = A01(c2699k1, anonymousClass38, str, dataObject);
        this.A04 = interfaceC12802u;
    }

    private AdError A00(C2699k1 c2699k1, AbstractC2855md abstractC2855md) {
        if (abstractC2855md == null || abstractC2855md.A1i().isEmpty()) {
            c2699k1.A08().AAu(A04(62, 3, 33), AbstractC14128a.A0Z, new C14138b(A04(5, 43, 20)));
            return AdError.internalError(2006);
        }
        return null;
    }

    public static C2S A01(C2699k1 c2699k1, AnonymousClass38 anonymousClass38, String str, JSONObject jSONObject) {
        C2S c2sA02 = null;
        if (jSONObject.has(A04(65, 12, 24))) {
            try {
                c2sA02 = C2853mb.A03(jSONObject, c2699k1, true);
                c2sA02.A13(true);
                c2sA02.A10(A04(96, 12, 117));
            } catch (JSONException unused) {
            }
        }
        if (c2sA02 == null) {
            c2sA02 = C1771Mw.A02(jSONObject, c2699k1);
        }
        c2sA02.A0z(str);
        C14328u c14328uA01 = anonymousClass38.A01();
        if (c14328uA01 != null) {
            c2sA02.A0v(c14328uA01.A06());
        }
        return c2sA02;
    }

    private C14067t A03(C2699k1 c2699k1) {
        return this.A00 != null ? this.A00 : new C14067t(c2699k1);
    }

    public static /* synthetic */ ArrayList A05(C12812v c12812v) {
        return c12812v.A02;
    }

    private void A08(C2699k1 c2699k1, C1771Mw c1771Mw) {
        C12752p playableData = c1771Mw.A1b().A0F().A07();
        A0B(playableData != null ? playableData.A0B() : FF.A05);
        C2844mS c2844mS = new C2844mS(this);
        C14067t c14067t = new C14067t(c2699k1);
        boolean z = C14499m.A28(c2699k1) && C7J.A0A(c1771Mw.A0u());
        if (z) {
            C7J unifiedAssetsLoader = new C7J(c14067t, c1771Mw.A0u(), c1771Mw.A0i(), c1771Mw.A0r(), z, new C2843mR(this));
            c14067t.A0d(new AF(c1771Mw.A1g(), c2699k1.A0A()));
            unifiedAssetsLoader.A0B();
            return;
        }
        AnonymousClass35.A02(c2699k1, c1771Mw, true, c2844mS);
    }

    private void A09(C2699k1 c2699k1, EnumSet<CacheFlag> enumSet, AbstractC2855md abstractC2855md, int i, InterfaceC12802u interfaceC12802u) {
        boolean zA1F = abstractC2855md.A1F();
        C14067t c14067tA03 = A03(c2699k1);
        c14067tA03.A0d(new AF(abstractC2855md.A1g(), c2699k1.A0A()));
        boolean z = C14499m.A28(c2699k1) && C7J.A0A(abstractC2855md.A0u());
        if (z) {
            new C7J(c14067tA03, abstractC2855md.A0u(), abstractC2855md.A0i(), abstractC2855md.A0r(), z, new C2847mV(this, c2699k1, zA1F, abstractC2855md, interfaceC12802u)).A0B();
            return;
        }
        String strA04 = A04(96, 12, 117);
        if (zA1F) {
            C14027p c14027p = new C14027p(abstractC2855md.A0f(), abstractC2855md.A0r(), strA04);
            c14027p.A04 = true;
            c14027p.A03 = A04(0, 5, 78);
            c14067tA03.A0X(c14027p);
        }
        c14067tA03.A0c(new C14047r(abstractC2855md.A1e().A01(), C1628Hb.A04, C1628Hb.A04, abstractC2855md.A0r(), A04(96, 12, 117)));
        boolean zContains = enumSet.contains(CacheFlag.VIDEO);
        int i2 = 0;
        boolean zA2q = C14499m.A2q(c2699k1, J3.A03());
        for (C2T adInfo : abstractC2855md.A1i()) {
            C14047r c14047r = new C14047r(adInfo.A0F().A08(), AnonymousClass31.A00(adInfo.A0F()), AnonymousClass31.A01(adInfo.A0F()), abstractC2855md.A0r(), A04(96, 12, 117));
            if (i2 == 0) {
                c14067tA03.A0b(c14047r);
            } else {
                c14067tA03.A0c(c14047r);
            }
            Iterator<String> it = adInfo.A0I().A02().iterator();
            while (it.hasNext()) {
                c14067tA03.A0c(new C14047r(it.next(), -1, -1, abstractC2855md.A0r(), A04(96, 12, 117)));
            }
            if (zContains && !TextUtils.isEmpty(adInfo.A0F().A09())) {
                C14027p c14027p2 = new C14027p(adInfo.A0F().A09(), abstractC2855md.A0r(), A04(96, 12, 117), adInfo.A0F().A06());
                c14027p2.A04 = false;
                if (i2 == 0) {
                    if (zA1F && !zA2q) {
                        c14067tA03.A0X(c14027p2);
                    } else {
                        c14067tA03.A0a(c14027p2);
                    }
                } else if (zA1F && !zA2q) {
                    c14067tA03.A0Y(c14027p2);
                } else {
                    c14067tA03.A0Z(c14027p2);
                }
            }
            i2++;
        }
        c14067tA03.A0W(new C2845mT(this, c2699k1, zA1F, abstractC2855md, interfaceC12802u), new C13997m(abstractC2855md.A0r(), strA04, i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0A(C2699k1 c2699k1, EnumSet<CacheFlag> enumSet, C2853mb c2853mb, AbstractC2855md abstractC2855md, int i, InterfaceC12802u interfaceC12802u) {
        A09(c2699k1, enumSet, abstractC2855md, i, new C2849mX(this, c2699k1, abstractC2855md, c2853mb, i, interfaceC12802u, enumSet));
    }

    private void A0B(FF ff) {
        this.A01 = ff;
    }

    private boolean A0C(C2699k1 c2699k1, AbstractC2855md abstractC2855md) {
        AdError adErrorA00 = A00(c2699k1, abstractC2855md);
        if (adErrorA00 != null) {
            this.A04.AC8(adErrorA00);
            return true;
        }
        return false;
    }

    public final C2S A0D() {
        return this.A03;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x006c, code lost:
    
        if (r3 != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0070, code lost:
    
        return com.facebook.ads.redexgen.core.BG.A0D;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0071, code lost:
    
        if (r3 != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0076, code lost:
    
        return com.facebook.ads.redexgen.core.BG.A0B;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.facebook.ads.redexgen.core.BG A0E() {
        /*
            r5 = this;
            com.facebook.ads.redexgen.X.2S r0 = r5.A03
            boolean r0 = r0.A1B()
            if (r0 == 0) goto Lb
            com.facebook.ads.redexgen.X.BG r0 = com.facebook.ads.redexgen.core.BG.A04
            return r0
        Lb:
            com.facebook.ads.redexgen.X.2S r4 = r5.A03
            com.facebook.ads.redexgen.X.md r4 = (com.facebook.ads.redexgen.core.AbstractC2855md) r4
            boolean r0 = r4.A1F()
            if (r0 == 0) goto L18
            com.facebook.ads.redexgen.X.BG r0 = com.facebook.ads.redexgen.core.BG.A06
            return r0
        L18:
            java.util.List r0 = r4.A1i()
            int r1 = r0.size()
            r0 = 1
            if (r1 <= r0) goto L26
            com.facebook.ads.redexgen.X.BG r0 = com.facebook.ads.redexgen.core.BG.A0A
            return r0
        L26:
            com.facebook.ads.redexgen.X.2T r0 = r4.A1b()
            com.facebook.ads.redexgen.X.2W r0 = r0.A0F()
            com.facebook.ads.redexgen.X.2p r3 = r0.A07()
            java.lang.String[] r1 = com.facebook.ads.redexgen.core.C12812v.A06
            r0 = 4
            r0 = r1[r0]
            int r1 = r0.length()
            r0 = 14
            if (r1 == r0) goto L77
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.C12812v.A06
            java.lang.String r1 = "HO5lN2vl3hawZ3xdOTbB4PXxItmZOFKM"
            r0 = 1
            r2[r0] = r1
            java.lang.String r1 = "QabHGQsenJFHZf5mHftqzVXi6FXcwsQx"
            r0 = 3
            r2[r0] = r1
            if (r3 == 0) goto L50
            com.facebook.ads.redexgen.X.BG r0 = com.facebook.ads.redexgen.core.BG.A0C
            return r0
        L50:
            boolean r3 = r5.A0L(r4)
            java.lang.String[] r1 = com.facebook.ads.redexgen.core.C12812v.A06
            r0 = 0
            r0 = r1[r0]
            int r1 = r0.length()
            r0 = 2
            if (r1 == r0) goto L71
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.C12812v.A06
            java.lang.String r1 = "iV2CDA2M2IfUZLXvhnmiNr1pV0Sur2CQ"
            r0 = 1
            r2[r0] = r1
            java.lang.String r1 = "GDT4frbvCKvkZrCQcOaJTMqN9T6RIdn0"
            r0 = 3
            r2[r0] = r1
            if (r3 == 0) goto L74
        L6e:
            com.facebook.ads.redexgen.X.BG r0 = com.facebook.ads.redexgen.core.BG.A0D
            return r0
        L71:
            if (r3 == 0) goto L74
            goto L6e
        L74:
            com.facebook.ads.redexgen.X.BG r0 = com.facebook.ads.redexgen.core.BG.A0B
            return r0
        L77:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C12812v.A0E():com.facebook.ads.redexgen.X.BG");
    }

    public final FF A0F() {
        return this.A01;
    }

    public final String A0G() {
        if (this.A03.A1B()) {
            return ((C2853mb) this.A03).A1c();
        }
        return ((AbstractC2855md) this.A03).A1g();
    }

    public final void A0H() {
        this.A04.AJc();
    }

    public final void A0I(Intent intent, RewardData rewardData, String str) {
        this.A03.A0x(rewardData);
        this.A03.A11(str);
        if (A0D().A1B()) {
            intent.putExtra(A04(77, 19, 78), this.A03);
        }
        intent.putExtra(A04(48, 14, 83), this.A03);
    }

    public final void A0J(C2699k1 c2699k1, EnumSet<CacheFlag> enumSet) {
        if (A0E() == BG.A04) {
            C2853mb c2853mb = (C2853mb) this.A03;
            AbstractC2855md abstractC2855mdA1Y = c2853mb.A1Y();
            if (A0C(c2699k1, abstractC2855mdA1Y) || abstractC2855mdA1Y == null) {
                return;
            }
            this.A04.AGg();
            A0A(c2699k1, enumSet, c2853mb, abstractC2855mdA1Y, 0, this.A04);
            return;
        }
        AbstractC2855md abstractC2855md = (AbstractC2855md) this.A03;
        if (A06[5].length() == 0) {
            throw new RuntimeException();
        }
        String[] strArr = A06;
        strArr[1] = "h3j4XQE4N9RDZ4AU6tvjsFYKX3e30HKG";
        strArr[3] = "lDhcJ7lgFtqhZjTb781X3zaoWDc2BWUc";
        if (A0C(c2699k1, abstractC2855md)) {
            return;
        }
        this.A04.AGg();
        if (A0E() == BG.A0C) {
            C1771Mw c1771Mw = (C1771Mw) this.A03;
            String[] strArr2 = A06;
            if (strArr2[2].length() != strArr2[6].length()) {
                A06[7] = "0uVLF1bkkTEn2WeYm46QMmOd1A6";
                A08(c2699k1, c1771Mw);
                return;
            } else {
                A08(c2699k1, c1771Mw);
                return;
            }
        }
        A09(c2699k1, enumSet, (C1771Mw) this.A03, -1, this.A04);
    }

    public final boolean A0K() {
        return this.A03.A17();
    }

    public final boolean A0L(AbstractC2855md abstractC2855md) {
        return !TextUtils.isEmpty(abstractC2855md.A1b().A0F().A09());
    }
}
