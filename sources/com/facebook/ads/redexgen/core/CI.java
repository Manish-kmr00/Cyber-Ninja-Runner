package com.facebook.ads.redexgen.core;

import android.app.Activity;
import android.os.Build;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class CI implements Runnable {
    public static byte[] A04;
    public static String[] A05 = {"rpDB7rKXNsFsWkDz6IFMGYiQm5SIurhV", "Zw7gqQaUB6b8OXSgkCM5acQChbi0fPQB", "ij96xAlSFdb9T8", "9lv2KZaF3yGNFfkp5oM5AxENUzlVWnoh", "BtiLNkHShKV4ox8o5K74B7kMcT6dIDQ3", "4qYR1HKsivt0y2MxZdwkaRz4cXsJEuH0", "44IOIp9GJ1CB282l", "5xjMlDyVDQDeuAskdNZft2cHBWd2iktp"};
    public final /* synthetic */ C12672h A00;
    public final /* synthetic */ CL A01;
    public final /* synthetic */ String A02;
    public final /* synthetic */ String A03;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 29);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A04 = new byte[]{56, 62, 40, 63, 46, 33, 36, 46, 38};
    }

    static {
        A01();
    }

    public CI(CL cl, String str, C12672h c12672h, String str2) {
        this.A01 = cl;
        this.A03 = str;
        this.A00 = c12672h;
        this.A02 = str2;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        if (BQ.A02(this)) {
            return;
        }
        try {
            if (!this.A01.A00) {
                return;
            }
            boolean z = false;
            this.A01.A00 = false;
            Activity activityA0E = this.A01.A03.A0E();
            boolean z2 = false;
            int i = Build.VERSION.SDK_INT;
            String[] strArr = A05;
            if (strArr[1].charAt(30) != strArr[4].charAt(30)) {
                throw new RuntimeException();
            }
            A05[2] = "zngGPNErwRp983";
            if (i >= 24) {
                if (activityA0E != null && activityA0E.isInMultiWindowMode()) {
                    z = true;
                }
                z2 = z;
            }
            if (!z2 && C1493Bw.A00().A03()) {
                return;
            }
            this.A01.A05(this.A03 != null ? this.A03 : A00(0, 9, 80), this.A00, this.A02);
        } catch (Throwable th) {
            if (A05[2].length() != 14) {
                BQ.A00(th, this);
            } else {
                A05[2] = "Mnh0XYPOQy81qp";
                BQ.A00(th, this);
            }
        }
    }
}
