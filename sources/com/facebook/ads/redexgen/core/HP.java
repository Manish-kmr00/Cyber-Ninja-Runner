package com.facebook.ads.redexgen.core;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class HP implements Runnable {
    public static String[] A01 = {"0fkcP0qkooJjHTVfbhLx2tkCpGd0OFna", "p1gd3B5Ct7DKPvODYQTolzrd0LgfrtBN", "rmYfyU8Bm9KxYrCEfCG", "sF1L969qasPiePpmXEx7adR9aJdAWeLw", "kzt7lopfME6s7OSgWGNwxJKX", "QC51vbu0F72OIK2HY8z2UEZFD0jBOwFS", "4XYSXLyM8M4TfgzDQg4ZpOu7aTKHTlFn", "dVoCiQNodru3wB58oCUk2hQhzsuXsRx5"};
    public final /* synthetic */ C2310db A00;

    public HP(C2310db c2310db) {
        this.A00 = c2310db;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        if (BQ.A02(this)) {
            return;
        }
        try {
            this.A00.A00.A0H(AE.A0b);
        } catch (Throwable th) {
            String[] strArr = A01;
            if (strArr[0].charAt(2) == strArr[5].charAt(2)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A01;
            strArr2[0] = "pO48jkJcNoSwJSuqskXr7bXGjqoRTLk3";
            strArr2[5] = "lGhpcmGFOUbeRs6EVQop3O3OMYtXEEPa";
            BQ.A00(th, this);
        }
    }
}
