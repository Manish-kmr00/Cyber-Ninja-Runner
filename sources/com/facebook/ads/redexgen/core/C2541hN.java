package com.facebook.ads.redexgen.core;

import android.text.TextUtils;
import com.google.common.base.Ascii;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.hN, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2541hN implements InterfaceC1639Hm {
    public static byte[] A01;
    public static String[] A02 = {"BHXiYjXxfgjD7yDB", "kPfw5HKETqo8dV", "SlBKzsC69frNfTspgJs5v90302jxH173", "0t7u2eeKUCj5gcxeWZIOCTpidMAeGJtt", "hTXrvsDVbOi3Q9xrUBZOJj7T", "iLbLRTjnBQIJ87KFXaIFUijyWt7EPIGc", "0utayShxEdwMeaV3UZeoWviAuyaBWRmj", "gyVOCm6F1v6TZALkbG"};
    public final /* synthetic */ C2540hM A00;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 58);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{Ascii.EM, Ascii.ETB, 9, Ascii.SYN, 7, Ascii.DLE, Ascii.CR, 7, Ascii.SI};
    }

    static {
        A01();
    }

    public C2541hN(C2540hM c2540hM) {
        this.A00 = c2540hM;
    }

    public /* synthetic */ C2541hN(C2540hM c2540hM, C2548hU c2548hU) {
        this(c2540hM);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1639Hm
    public final void ACm() {
        this.A00.A0U(true, A00(0, 9, 106));
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1639Hm
    public final void ADP() {
        if (!this.A00.A0Z) {
            if (!TextUtils.isEmpty(this.A00.A0I.A1g())) {
                this.A00.A0M.AB0(this.A00.A0I.A1g(), new FB().A03(this.A00.A07.getViewabilityChecker()).A02(this.A00.A07.getTouchDataRecorder()).A05());
                C1485Bh.A00(this.A00.A0L).A0E(this.A00.A0R.A8b(), this.A00.A0I.A1g());
                C12672h.A07(this.A00.A0I.A1c(), this.A00.A0L);
                AbstractC12863a.A02(this.A00.A0I.A0g(), AbstractC1501Ce.A00(this.A00.A0I.A0i()));
                this.A00.A0L.A0F().A3B();
                if (this.A00.A0J.A0P()) {
                    this.A00.A0L.A0F().ADh();
                }
            }
            C2540hM c2540hM = this.A00;
            String[] strArr = A02;
            if (strArr[5].charAt(12) == strArr[2].charAt(12)) {
                throw new RuntimeException();
            }
            A02[4] = "GzK3XL6hk7idJD";
            c2540hM.A0Q.A4Z(this.A00.A0R.A86());
            return;
        }
        this.A00.A0L.A0F().ADi();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1639Hm
    public final void ADv() {
        this.A00.A0Q.A4Z(this.A00.A0R.A7r());
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1639Hm
    public final void AFo() {
        this.A00.A0Q.ACY(15);
    }
}
