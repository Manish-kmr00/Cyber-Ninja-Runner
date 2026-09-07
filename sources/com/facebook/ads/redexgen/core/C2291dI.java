package com.facebook.ads.redexgen.core;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.dI, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2291dI extends AnonymousClass67 {
    public static byte[] A0H;
    public static String[] A0I = {"oHxG", "", "w7XeyG7wcXlBDThCLG4YobF5JePdGcu8", "IQ8LgqWvoXOpUTXgnww89j6rU6uuZ1nj", "", "WKMwHhIum9", "0nm7H4VWCUBWNiJwCQAonSVvBZFyt", "hLsDwSpuFLAE"};
    public GU A02;
    public JL A04;
    public List<C1629Hc> A05;
    public boolean A09;
    public final int A0A;
    public final Context A0B;
    public final C2771lC A0C;
    public final C6F A0D;
    public final Set<Integer> A0G = new HashSet();
    public boolean A08 = true;
    public boolean A06 = true;
    public boolean A07 = true;
    public int A01 = -1;
    public float A00 = 0.0f;
    public final GY A0F = new C2297dO(this);
    public GW A03 = new C2296dN(this);
    public final GX A0E = new C2292dJ(this);

    public static String A05(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0H, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 7);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A08() {
        String[] strArr = A0I;
        if (strArr[0].length() == strArr[5].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0I;
        strArr2[7] = "Cbp585p0FHy9";
        strArr2[6] = "QC7w158vCCR5KGktiGCBodiqPhNZq";
        A0H = new byte[]{-122, -102, -103, -108, -92, -107, -111, -122, -98, -92, -118, -109, -122, -121, -111, -118, -119, -92, -107, -122, -105, -122, -110, 81, 91, 103, 78, 81, 90, 91, 92, 103, 94, 81, 76, 77, 87, 103, 88, 73, 90, 73, 85, -51, -58, -61, -52, -60, -68, -42, -61, -68, -51, -68, -61, -42, -57, -72, -55, -72, -60};
    }

    static {
        A08();
    }

    public C2291dI(C12411h c12411h, int i, List<C1629Hc> list, JL jl, Bundle bundle) {
        this.A0C = c12411h.getLayoutManager();
        this.A0A = i;
        this.A05 = list;
        this.A04 = jl;
        this.A0D = new C2770lB(c12411h.getContext());
        this.A0B = c12411h.getContext();
        c12411h.A1h(this);
        A0D(bundle);
    }

    private AbstractC2445fo A03(int i, int i2) {
        return A04(i, i2, true);
    }

    private AbstractC2445fo A04(int i, int i2, boolean z) {
        AbstractC2445fo abstractC2445fo = null;
        while (i <= i2) {
            AbstractC2445fo abstractC2445fo2 = (AbstractC2445fo) this.A0C.A1m(i);
            if (abstractC2445fo2 == null || abstractC2445fo2.A1E()) {
                return null;
            }
            boolean zA0a = A0a(abstractC2445fo2);
            if (abstractC2445fo == null && abstractC2445fo2.A1F() && zA0a && !this.A0G.contains(Integer.valueOf(i)) && (!z || A0I(abstractC2445fo2, this.A0A))) {
                abstractC2445fo = abstractC2445fo2;
            }
            if (abstractC2445fo2.A1F() && !zA0a) {
                A0C(i, false);
            }
            i++;
        }
        return abstractC2445fo;
    }

    private void A06() {
        if (!this.A07) {
            return;
        }
        int lastVisibleItem = this.A0C.A24();
        int firstVisibleItem = this.A0C.A25();
        AbstractC2445fo abstractC2445foA03 = A03(lastVisibleItem, firstVisibleItem);
        if (abstractC2445foA03 != null) {
            abstractC2445foA03.A1C();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A07() {
        int iA23 = this.A0C.A23();
        if (iA23 != -1) {
            int curPos = this.A05.size();
            if (iA23 < curPos - 1) {
                int curPos2 = iA23 + 1;
                A0U(curPos2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A09(int i) {
        AbstractC2445fo abstractC2445foA04 = A04(i + 1, this.A0C.A25(), false);
        if (abstractC2445foA04 != null) {
            abstractC2445foA04.A1C();
            A0U(((Integer) abstractC2445foA04.getTag(-1593835536)).intValue());
        }
    }

    private void A0A(int i, int i2) {
        while (i <= i2) {
            A0T(i);
            i++;
        }
    }

    private final void A0B(int i, int i2) {
        A0S(i);
        A0S(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0C(int i, boolean z) {
        if (z) {
            this.A0G.add(Integer.valueOf(i));
        } else {
            this.A0G.remove(Integer.valueOf(i));
        }
    }

    private void A0D(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        this.A00 = bundle.getFloat(A05(43, 18, 112), 0.0f);
        this.A07 = bundle.getBoolean(A05(0, 23, 62), true);
        this.A08 = bundle.getBoolean(A05(23, 20, 1), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean A0H() {
        return this.A0A == 1;
    }

    public static boolean A0I(AbstractC1594Ft abstractC1594Ft, int i) {
        int allowedAreaMaxX;
        int furthestX;
        if (i == 2) {
            allowedAreaMaxX = CP.A04.widthPixels - 1;
        } else {
            int width = abstractC1594Ft.getWidth();
            int allowedAreaMinX = CP.A04.widthPixels;
            allowedAreaMaxX = (int) (((width + allowedAreaMinX) * 1.3f) / 2.0f);
        }
        if (i == 2) {
            furthestX = 1;
        } else {
            int i2 = CP.A04.widthPixels;
            int allowedAreaMinX2 = abstractC1594Ft.getWidth();
            furthestX = (int) (((i2 - allowedAreaMinX2) * 0.7f) / 2.0f);
        }
        float x = abstractC1594Ft.getX();
        int allowedAreaMinX3 = abstractC1594Ft.getWidth();
        return ((int) (x + ((float) allowedAreaMinX3))) <= allowedAreaMaxX && abstractC1594Ft.getX() >= ((float) furthestX);
    }

    private boolean A0J(AbstractC2445fo abstractC2445fo) {
        if (!this.A08 || !abstractC2445fo.A1F()) {
            return false;
        }
        this.A08 = false;
        return true;
    }

    @Override // com.facebook.ads.redexgen.core.AnonymousClass67
    public void A0L(MG mg, int i) {
        super.A0L(mg, i);
        if (i == 0) {
            this.A09 = true;
            A06();
        }
    }

    @Override // com.facebook.ads.redexgen.core.AnonymousClass67
    public void A0M(MG mg, int i, int i2) {
        super.A0M(mg, i, i2);
        this.A09 = false;
        if (this.A06) {
            this.A09 = true;
            A06();
            this.A06 = false;
        }
        int lastVisibleItem = this.A0C.A24();
        int firstVisibleItem = this.A0C.A25();
        A0B(lastVisibleItem, firstVisibleItem);
        A0A(lastVisibleItem, firstVisibleItem);
        A0V(lastVisibleItem, firstVisibleItem, i);
    }

    public final GW A0N() {
        return this.A03;
    }

    public final GX A0O() {
        return this.A0E;
    }

    public final GY A0P() {
        return this.A0F;
    }

    public final void A0Q() {
        this.A01 = -1;
        int iA25 = this.A0C.A25();
        for (int iA24 = this.A0C.A24(); iA24 <= iA25 && iA24 >= 0; iA24++) {
            AbstractC2445fo card = (AbstractC2445fo) this.A0C.A1m(iA24);
            String[] strArr = A0I;
            String str = strArr[1];
            String str2 = strArr[4];
            int lastPos = str.length();
            int firstPos = str2.length();
            if (lastPos != firstPos) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0I;
            strArr2[0] = "4n0r";
            strArr2[5] = "UAml839wpr";
            if (card != null && card.A1E()) {
                this.A01 = iA24;
                card.A1B();
                return;
            }
        }
    }

    public final void A0R() {
        AbstractC2445fo abstractC2445fo = (AbstractC2445fo) this.A0C.A1m(this.A01);
        if (abstractC2445fo != null && this.A01 >= 0) {
            abstractC2445fo.A1C();
        }
    }

    public final void A0S(int i) {
        AbstractC2445fo abstractC2445fo = (AbstractC2445fo) this.A0C.A1m(i);
        if (abstractC2445fo != null && !A0a(abstractC2445fo)) {
            A0Z(abstractC2445fo, false);
        }
    }

    public final void A0T(int i) {
        AbstractC2445fo abstractC2445fo = (AbstractC2445fo) this.A0C.A1m(i);
        if (abstractC2445fo == null) {
            return;
        }
        if (A0a(abstractC2445fo)) {
            A0Z(abstractC2445fo, true);
        }
        if (A0J(abstractC2445fo) && this.A05 != null) {
            this.A0F.setVolume(this.A05.get(((Integer) abstractC2445fo.getTag(-1593835536)).intValue()).A03().A0F().A0A() ? 0.0f : 1.0f);
        }
    }

    public final void A0U(int i) {
        this.A0D.A0A(i);
        this.A0C.A1L(this.A0D);
    }

    public final void A0V(int i, int i2, int i3) {
        if (!A0H() || this.A02 == null) {
            return;
        }
        int recomputeFrom = this.A0C.A23();
        if (recomputeFrom == -1) {
            recomputeFrom = i3 < 0 ? i : i2;
        }
        this.A02.AJf(recomputeFrom);
    }

    public final void A0W(Bundle bundle) {
        bundle.putFloat(A05(43, 18, 112), this.A00);
        bundle.putBoolean(A05(0, 23, 62), this.A07);
        bundle.putBoolean(A05(23, 20, 1), this.A08);
    }

    public void A0X(View view, boolean z) {
        view.setAlpha(z ? 1.0f : 0.5f);
    }

    public final void A0Y(GU gu) {
        this.A02 = gu;
    }

    public void A0Z(AbstractC2445fo abstractC2445fo, boolean z) {
        if (A0H()) {
            A0X(abstractC2445fo, z);
        }
        if (!z && abstractC2445fo.A1E()) {
            abstractC2445fo.A1B();
        }
    }

    public boolean A0a(View view) {
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        return ((float) rect.width()) / ((float) view.getWidth()) >= 0.15f;
    }
}
