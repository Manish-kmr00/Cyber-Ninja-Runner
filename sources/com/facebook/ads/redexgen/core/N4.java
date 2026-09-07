package com.facebook.ads.redexgen.core;

import android.text.TextUtils;
import com.facebook.ads.internal.protocol.AdErrorType;
import com.facebook.ads.internal.protocol.AdPlacementType;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class N4 implements InterfaceC2887n9 {
    public static byte[] A09;
    public static String[] A0A = {"0TFgGHCmbDEnT", "P3BoNX3HbYs3p91Xznd9cH02Ego1LEzw", "OWrFl7C0gkEmqIZvATANnxtRvMpHSetZ", "XjLJU23F7IQ7TgYJbWjoa78", "8eUGin29aZrVydG4hLQZ04ng176drDiv", "tE42BGb8ExLW22Y3fw0IicKZ4ID1w2IZ", "N0c3cK9W7W98ikBdYu66t8J", "EarR2SOYmotvRVJvY11PbnGgxllwGrNq"};
    public C2B A01;
    public C2C A02;
    public C2863ml A03;
    public C2860mi A04;
    public M5 A05;
    public InterfaceC1535Dm A06;
    public C1536Dn A07;
    public final String A08 = UUID.randomUUID().toString();
    public long A00 = -1;

    public static String A03(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A09, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 16);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A04() {
        A09 = new byte[]{-81, -64, -11, -19, -20, -15, -3, -11, -25, -6, -19, -21, -4, -23, -10, -17, -12, -19};
    }

    static {
        A04();
    }

    private void A05(M5 m5, C2860mi c2860mi, C14067t c14067t, C2B c2b, C1536Dn c1536Dn) {
        String strA7E = c2860mi.A7E();
        if (!TextUtils.isEmpty(strA7E)) {
            c14067t.A0d(new AF(strA7E, m5.A0A()));
        }
        AU auA0F = c2860mi.A0F();
        String[] strArr = A0A;
        String clientToken = strArr[3];
        if (clientToken.length() != strArr[6].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0A;
        strArr2[3] = "l0iKT0z7S0YTo68xxrsf1qJ";
        strArr2[6] = "FTb7Q8n5ne47CtPUjUxYv1n";
        if (auA0F != null) {
            C14047r c14047r = new C14047r(c2860mi.A0F().getUrl(), c2860mi.A0F().getHeight(), c2860mi.A0F().getWidth(), c2860mi.A0Y(), A03(2, 16, 120));
            c14047r.A00 = new C7z(false, -1, -1);
            c14067t.A0V();
            c14067t.A0b(c14047r);
        }
        if (c2860mi.A0E() != null) {
            c14067t.A0b(new C14047r(c2860mi.A0E().getUrl(), c2860mi.A0E().getHeight(), c2860mi.A0E().getWidth(), c2860mi.A0Y(), A03(2, 16, 120)));
        }
        String strA0b = c2860mi.A0b();
        if (strA0b != null && !TextUtils.isEmpty(strA0b)) {
            c14067t.A0a(new C14027p(strA0b, c2860mi.A0Y(), A03(2, 16, 120), c2860mi.A0A()));
        }
        C2875mx c2875mx = new C2875mx(this, c1536Dn, c2b, m5);
        String strA0Y = c2860mi.A0Y();
        String clientToken2 = A03(2, 16, 120);
        c14067t.A0W(c2875mx, new C13997m(strA0Y, clientToken2));
    }

    @Override // com.facebook.ads.redexgen.core.AnonymousClass23
    public final String A7E() {
        if (this.A04 == null) {
            return null;
        }
        return this.A04.A7E();
    }

    @Override // com.facebook.ads.redexgen.core.AnonymousClass23
    public final AdPlacementType A8a() {
        return AdPlacementType.MEDIUM_RECTANGLE;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2887n9
    public final void AAi(M5 m5, A7 a7, EnumC1470Aj enumC1470Aj, C2B c2b, JSONObject jSONObject, C14328u c14328u) {
        m5.A0F().A4D();
        this.A05 = m5;
        this.A01 = c2b;
        C14067t c14067t = new C14067t(m5);
        this.A00 = System.currentTimeMillis();
        C2860mi c2860miA00 = C2K.A00(m5, jSONObject, CV.A02(jSONObject, A03(0, 2, 60)));
        this.A04 = c2860miA00;
        if (!AbstractC12591z.A06(m5, c2860miA00, a7)) {
            InterfaceC1535Dm adViewListener = new C2877mz(this, m5);
            this.A06 = adViewListener;
            C1536Dn c1536Dn = new C1536Dn(m5, a7, c14067t, new WeakReference(adViewListener), c14328u.A04(), c14328u.A07(), c14328u.A08(), c14328u.A09(), c2860miA00, this.A08);
            this.A07 = c1536Dn;
            this.A03 = new C2863ml(m5, new C2876my(this, m5, c2b), c1536Dn.getViewabilityChecker(), a7, c2860miA00);
            A05(m5, c2860miA00, c14067t, c2b, c1536Dn);
            this.A02 = new C2C(m5, this.A08, this, c2b);
            this.A02.A02();
            return;
        }
        m5.A0F().A4s();
        c2b.ADc(this, C1468Ag.A00(AdErrorType.NO_FILL));
    }

    @Override // com.facebook.ads.redexgen.core.AnonymousClass23
    public final boolean AJQ() {
        return false;
    }

    @Override // com.facebook.ads.redexgen.core.AnonymousClass23
    public final void onDestroy() {
        if (this.A05 != null) {
            InterfaceC2905nR interfaceC2905nRA0F = this.A05.A0F();
            String[] strArr = A0A;
            if (strArr[1].charAt(24) == strArr[4].charAt(24)) {
                throw new RuntimeException();
            }
            A0A[7] = "tMGyCfr9ucO4oWdztKDfdPlDfRrhkMp8";
            interfaceC2905nRA0F.A4B(this.A07 != null);
        }
        if (this.A07 != null) {
            this.A07.A0I();
            this.A07 = null;
            this.A06 = null;
        }
        C2C c2c = this.A02;
        if (A0A[0].length() == 16) {
            throw new RuntimeException();
        }
        A0A[7] = "5ZoCIskAsYlLTmabnaeKVzywNB4LbbVC";
        if (c2c != null) {
            this.A02.A03();
        }
    }
}
