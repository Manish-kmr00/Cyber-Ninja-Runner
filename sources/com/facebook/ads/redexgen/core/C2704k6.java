package com.facebook.ads.redexgen.core;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.k6, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2704k6 extends BY {
    public static String[] A05 = {"peP5GJDM9me8QDpiMTE0HYbhk5UQvsuj", "UmJsGkUZcFFvxG21gGzKuNxtLbnsNH0B", "InCZKAYVJ2xyVT3RLHGk", "cxu83bHx4KSubY78z6WW", "55WyHuuOCemh1dLUozRA9kNqY", "hUMsj3tCoCX6inz1bILbzXUTN", "Ib1pT8H4oQaxudtz", "STVRCs5pIYaR1pHj"};
    public final /* synthetic */ InterfaceC13987l A00;
    public final /* synthetic */ C13997m A01;
    public final /* synthetic */ C14067t A02;
    public final /* synthetic */ ArrayList A03;
    public final /* synthetic */ ArrayList A04;

    public C2704k6(C14067t c14067t, ArrayList arrayList, C13997m c13997m, InterfaceC13987l interfaceC13987l, ArrayList arrayList2) {
        this.A02 = c14067t;
        this.A03 = arrayList;
        this.A01 = c13997m;
        this.A00 = interfaceC13987l;
        this.A04 = arrayList2;
    }

    @Override // com.facebook.ads.redexgen.core.BY
    public final void A05() {
        AtomicBoolean atomicBooleanA0D = C14067t.A0D(this.A03);
        if (this.A02.A04 instanceof C2699k1) {
            C2699k1 c2699k1 = (C2699k1) this.A02.A04;
            if (this.A01.A00 == -1) {
                boolean z = atomicBooleanA0D.get();
                String[] strArr = A05;
                if (strArr[6].length() == strArr[7].length()) {
                    String[] strArr2 = A05;
                    strArr2[3] = "VVOoEaVD2AhQqE2eihnl";
                    strArr2[2] = "7KTPepw5ZZxiUEMCto3C";
                    if (z) {
                        c2699k1.A0F().A4f(C1517Cu.A01(this.A02.A00));
                    } else {
                        c2699k1.A0F().A4d(C1517Cu.A01(this.A02.A00));
                    }
                }
                throw new RuntimeException();
            }
            if (atomicBooleanA0D.get()) {
                InterfaceC12391f interfaceC12391fA0F = c2699k1.A0F();
                long jA01 = C1517Cu.A01(this.A02.A00);
                C13997m c13997m = this.A01;
                String[] strArr3 = A05;
                if (strArr3[4].length() == strArr3[5].length()) {
                    String[] strArr4 = A05;
                    strArr4[4] = "xsAs6ZK2AKeTr6tr707KlGvOM";
                    strArr4[5] = "GxI5mwrGpMJ9ldsuxbhmmAcT7";
                    interfaceC12391fA0F.A4g(jA01, c13997m.A00);
                }
                throw new RuntimeException();
            }
            c2699k1.A0F().A4e(C1517Cu.A01(this.A02.A00), this.A01.A00);
        }
        this.A02.A02.post(new C2705k7(this, atomicBooleanA0D));
        C14067t.A0D(this.A04);
    }
}
