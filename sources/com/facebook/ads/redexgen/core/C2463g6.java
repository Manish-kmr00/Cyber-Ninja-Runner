package com.facebook.ads.redexgen.core;

import android.text.TextUtils;
import java.util.Arrays;
import kotlin.io.encoding.Base64;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.g6, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2463g6 implements InterfaceC1570Ev {
    public static byte[] A01;
    public final /* synthetic */ C2451fu A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 104);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{73, 71, 57, 70, 51, 66, 53, 74, Base64.padSymbol, 59, 53, 72, Base64.padSymbol, 67, 66, 51, Base64.padSymbol, 53, 54};
    }

    public C2463g6(C2451fu c2451fu) {
        this.A00 = c2451fu;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1570Ev
    public final void AEM(String str) {
        this.A00.A0W = false;
        this.A00.A0J.setProgress(100);
        D3.A0L(this.A00.A0J, 8);
        if (this.A00.A0G.A1J() && this.A00.A0K != null) {
            String strA0l = this.A00.A0G.A0l();
            if (!TextUtils.isEmpty(strA0l)) {
                this.A00.A0K.loadUrl(strA0l);
            }
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1570Ev
    public final void AEO(String str) {
        this.A00.A0W = true;
        D3.A0L(this.A00.A0J, 0);
        this.A00.A0I.setUrl(str);
        if (!this.A00.A0U && this.A00.A01 > 1) {
            this.A00.A0U = true;
            this.A00.A0h(A00(0, 19, 108));
        }
        C2451fu.A03(this.A00);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1570Ev
    public final void AEj(int i) {
        if (this.A00.A0W) {
            this.A00.A0J.setProgress(i);
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1570Ev
    public final void AEl(String str) {
        this.A00.A0I.setTitle(str);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1570Ev
    public final void AEo() {
        this.A00.A0M.A0C().ACY(14);
    }
}
