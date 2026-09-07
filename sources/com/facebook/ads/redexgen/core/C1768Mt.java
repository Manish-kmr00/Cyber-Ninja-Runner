package com.facebook.ads.redexgen.core;

import android.view.View;
import com.facebook.ads.internal.protocol.AdErrorType;
import com.google.common.base.Ascii;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Mt, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1768Mt extends AbstractC2835mI {
    public static byte[] A03;
    public long A00;
    public View A01;
    public M5 A02;

    static {
        A05();
    }

    public static String A03(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 81);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A05() {
        A03 = new byte[]{Ascii.DC4, Ascii.ETB, 38, -15, -16, -3, -3, -12, 1, -18, 1, -12, -11, 1, -12, 2, -9, -18, 3, -8, -4, -12, -5, 0, -7, 1, 6, -9, 8, -7, 10, -7, 5, Ascii.VT, 38, 55, Ascii.ESC, 40, 40, 37, 40, -42, 45, Ascii.RS, Ascii.US, 34, Ascii.ESC, -42, 38, Ascii.ETB, 40, 41, Ascii.US, 36, Ascii.GS, -42, Ascii.EM, Ascii.RS, Ascii.ETB, Ascii.US, 36, Ascii.ESC, Ascii.SUB, -42, Ascii.ETB, Ascii.SUB, 41, -42, -8, Ascii.ETB, 36, 36, Ascii.ESC, 40};
    }

    public C1768Mt(M5 m5, AnonymousClass37 anonymousClass37) {
        super(m5, anonymousClass37);
        this.A00 = 10000L;
        this.A02 = m5;
    }

    private C2838mL A01(Runnable runnable) {
        return new C2838mL(this, runnable);
    }

    private List<JSONObject> A04(AnonymousClass38 anonymousClass38) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObjectA03 = anonymousClass38.A03();
        String strA03 = A03(22, 12, 71);
        if (jSONObjectA03.has(strA03)) {
            try {
                this.A00 = jSONObjectA03.getJSONObject(strA03).optInt(A03(3, 19, 62), 10000);
                JSONArray adsArray = jSONObjectA03.getJSONArray(A03(0, 3, 98));
                if (adsArray.length() > 0) {
                    for (int i = 0; i < adsArray.length(); i++) {
                        arrayList.add((JSONObject) adsArray.get(i));
                    }
                }
            } catch (JSONException unused) {
                String strA04 = A03(36, 38, 101);
                this.A02.A0F().A5W(C1468Ag.A01(AdErrorType.UNKNOWN_ERROR, strA04).A03().getErrorCode(), strA04);
                return arrayList;
            }
        } else {
            arrayList.add(jSONObjectA03);
        }
        return arrayList;
    }

    private void A06(InterfaceC2887n9 interfaceC2887n9, JSONObject jSONObject, C14328u c14328u) {
        this.A0C = false;
        C2837mK c2837mK = new C2837mK(this, interfaceC2887n9, CV.A02(jSONObject, A03(34, 2, 114)));
        A0H().postDelayed(c2837mK, c14328u.A05());
        interfaceC2887n9.AAi(this.A02, this.A09, this.A08.A08, A01(c2837mK), jSONObject, c14328u);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2835mI
    public final void A0P() {
        if (this.A01 != null) {
            this.A02.A0F().A4U();
            this.A07.A0E(this.A01);
        } else {
            this.A02.A0F().A4V();
        }
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2835mI
    public final void A0R(AnonymousClass23 anonymousClass23, C14318t c14318t, C14298r c14298r, final AnonymousClass38 anonymousClass38) {
        this.A02.A0F().A4O();
        final InterfaceC2887n9 interfaceC2887n9 = (InterfaceC2887n9) anonymousClass23;
        if (interfaceC2887n9.AJQ()) {
            final List<JSONObject> listA04 = A04(anonymousClass38);
            A06(interfaceC2887n9, listA04.get(0), anonymousClass38.A01());
            if (listA04.size() > 1) {
                A0H().postDelayed(new Runnable() { // from class: com.facebook.ads.redexgen.X.39
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.A02.A0a(interfaceC2887n9, listA04, anonymousClass38);
                    }
                }, this.A00);
                return;
            }
            return;
        }
        A06(interfaceC2887n9, anonymousClass38.A03(), anonymousClass38.A01());
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2835mI
    public final void A0U(String str) {
        this.A02.A0F().A4T(str != null);
        super.A0U(str);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2835mI
    public final void A0Y(boolean z) {
        super.A0Y(z);
        this.A01 = null;
    }

    public final /* synthetic */ void A0a(InterfaceC2887n9 interfaceC2887n9, List list, AnonymousClass38 anonymousClass38) {
        A06(interfaceC2887n9, (JSONObject) list.get(1), anonymousClass38.A01());
    }
}
