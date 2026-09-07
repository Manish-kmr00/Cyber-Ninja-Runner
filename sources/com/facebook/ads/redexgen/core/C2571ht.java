package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.ht, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2571ht extends AnonymousClass67 {
    public static String[] A01 = {"LeWmJ2AEMrGR8tgfwsG9m8UwM76zwmUz", "6Bm", "ck2sw", "Oj1Ntvfg6dck0NxJmQASjzaKZXVqT4Sf", "CtYf7ZmPdO", "plI1JnuA", "RZR4g54lk6KTwqItkRA6ECctcTUw", "cGd5igXf7vOVCpmuGQi5cRxrBgQCM2pW"};
    public final /* synthetic */ C12411h A00;

    public C2571ht(C12411h c12411h) {
        this.A00 = c12411h;
    }

    @Override // com.facebook.ads.redexgen.core.AnonymousClass67
    public final void A0L(MG mg, int i) {
        int iA23;
        DY dy;
        super.A0L(mg, i);
        C2771lC linearLayoutManager = this.A00.getLayoutManager();
        if (linearLayoutManager != null && (iA23 = linearLayoutManager.A23()) >= 0) {
            C12411h c12411h = this.A00;
            int scrollPosition = A01[3].charAt(13);
            if (scrollPosition == 48) {
                throw new RuntimeException();
            }
            A01[5] = "JmqJ93Os7fwoNBdh";
            if (c12411h.getAdapter() == null || iA23 >= this.A00.getAdapter().A0C() || (dy = (DY) mg.A1F(iA23)) == null) {
                return;
            }
            dy.AIL();
        }
    }
}
