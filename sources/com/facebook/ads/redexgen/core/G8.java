package com.facebook.ads.redexgen.core;

import android.view.View;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class G8 implements View.OnClickListener {
    public static byte[] A02;
    public static String[] A03 = {"5siEYkdbttFpPpKGpl3QSuzD1TdUzqaY", "myaIheKQJ4XKLjb9jwKnfQPKdgb03x65", "7UC9gtjSNciDETfiVIuIcEpkShzxljy2", "zUgtzOTCnewqlW3ay8eN5ZGY8omlP8wl", "HCNRIc1Jq5CHui75", "5JldaPh0422ECqUrSdIW3CP66xzzDRpo", "6NBLbo7bp32p6xzITlg23gMBc6vteD1q", "6aVSVJl49uZRPmkaVoTjRyLu3FUElegz"};
    public final /* synthetic */ ViewOnClickListenerC2488gW A00;
    public final /* synthetic */ G9 A01;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            if (A03[6].charAt(12) == 'g') {
                throw new RuntimeException();
            }
            String[] strArr = A03;
            strArr[0] = "VNdWttTdUjFkQFP8JWlqZZM22OaN4Km2";
            strArr[3] = "R7Bf4UcSP1AaUkuG6x1PRuhjomEl3ayd";
            if (i4 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 11);
            i4++;
        }
    }

    public static void A01() {
        A02 = new byte[]{87, 90, 94, 91, 90, 77};
    }

    static {
        A01();
    }

    public G8(G9 g9, ViewOnClickListenerC2488gW viewOnClickListenerC2488gW) {
        this.A01 = g9;
        this.A00 = viewOnClickListenerC2488gW;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (BQ.A02(this)) {
            return;
        }
        try {
            if (this.A00 != null) {
                this.A00.A0A(A00(0, 6, 52));
            }
        } catch (Throwable th) {
            if (A03[6].charAt(12) == 'g') {
                throw new RuntimeException();
            }
            String[] strArr = A03;
            strArr[5] = "pv88L2Qv4olKMchOaCJJbvU1UVpDqKti";
            strArr[2] = "h7t7tL7arYQ0kU7vuWKWmfHlmY1cI4wR";
            BQ.A00(th, this);
        }
    }
}
