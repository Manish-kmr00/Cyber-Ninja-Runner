package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.hV, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2549hV extends JK {
    public static String[] A01 = {"M3Te92XvVv4q3bfKEkaCq6oPQP87x4vv", "LzmiiHhJsyKuUkJv7K1Ir2o", "KopJ75", "b4r1pmUHtrvrrbICXjY", "ceBgm8EiRhrot5ffXZtZ35omPt2ZFFf0", "0EayevzsZQe4lRY4RLfa4MEWre", "N9h8Vj", "K1Ob6mZ8MwS9WZtXZ80XEzEALvtTcRJ2"};
    public final /* synthetic */ C1536Dn A00;

    public C2549hV(C1536Dn c1536Dn) {
        this.A00 = c1536Dn;
    }

    @Override // com.facebook.ads.redexgen.core.JK
    public final void A03() {
        if (this.A00.A07 == null || this.A00.A07.A0D()) {
            this.A00.A09.A0V();
            if (!this.A00.A05.A07()) {
                this.A00.A05.A05();
            }
            InterfaceC1535Dm listener = (InterfaceC1535Dm) this.A00.A0B.get();
            if (listener != null) {
                listener.ADP();
            }
            C1536Dn c1536Dn = this.A00;
            String[] strArr = A01;
            if (strArr[1].length() == strArr[3].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A01;
            strArr2[1] = "2rS8p9kEkH8XxeBlGl7RSlB";
            strArr2[3] = "nqXy6qNf0NylKakjBUJ";
            c1536Dn.A09.A0V();
            return;
        }
        this.A00.A09.A0T();
    }
}
