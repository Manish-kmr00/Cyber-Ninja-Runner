package com.facebook.ads.redexgen.core;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.ads.NativeAd;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.kP, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2723kP implements InterfaceC13987l {
    public static String[] A02 = {"XqTxzibSN1zAjaiM9LtVSqsxSG", "xqN5bEwB0Nihon7KSuA", "FVkOY26I4teb9ftOLmk9A45ZS3TS2DIY", "wzTDEcMKt7VvW9W8eKeIWksTnJ0tE", "iGRCr9OHUARnshCNCmKS3XNzEIA09VDm", "MJLgHxMJm3Fw", ExifInterface.LATITUDE_SOUTH, "m77T1m6dtAhGTcgbhkAg"};
    public final List<C2873mv> A00;
    public final /* synthetic */ C2722kO A01;

    public C2723kP(C2722kO c2722kO, List<C2873mv> list) {
        this.A01 = c2722kO;
        this.A00 = list;
    }

    private void A00() {
        this.A01.A00.A05(true);
        this.A01.A00.A02();
        this.A01.A00.A03(0);
        Iterator<C2873mv> it = this.A00.iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            if (A02[4].charAt(3) == 'E') {
                throw new RuntimeException();
            }
            A02[0] = "GKxyFdZ7ADxfGJ";
            if (zHasNext) {
                C2615ie c2615ie = new C2615ie(this.A01.A01, it.next(), null, C2615ie.A0K(), this.A01.A00.A01());
                if (c2615ie.A0z() != null && c2615ie.A0z().A0F() != null) {
                    ((AbstractC2829mC) c2615ie.A0z().A0F()).A00(c2615ie);
                }
                this.A01.A00.A04(new NativeAd(this.A01.A01, c2615ie));
            } else {
                BP.A00(new C2724kQ(this));
                return;
            }
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC13987l
    public final void ACa() {
        A00();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC13987l
    public final void ACj() {
        A00();
    }
}
