package com.facebook.ads.redexgen.core;

import android.view.View;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class G7 implements View.OnClickListener {
    public static byte[] A02;
    public static String[] A03 = {"524C9pC8aLVKflbvvv2K7MlVaT1Y4oXj", "lRM8H52A4hKqkKdkEH8S6", "pzMD8hEzrN8WJeuHzmUfipPCg7LRhl7h", "lnDY", "95wdtjn99T2hJygpaQjrD03HNRuLahXP", "M3Z", "WkizL2fPiwDBFcFyMDRmv7nfAM7GjuvS", "zFeU71BaV6LqmyzLw1trLotvqmYyyi91"};
    public final /* synthetic */ ViewOnClickListenerC2488gW A00;
    public final /* synthetic */ G9 A01;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 10);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A02 = new byte[]{93, 86, 92, 91, 89, 74, 92, 75};
    }

    static {
        A01();
    }

    public G7(G9 g9, ViewOnClickListenerC2488gW viewOnClickListenerC2488gW) {
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
                this.A00.A0A(A00(0, 8, 50));
            }
        } catch (Throwable th) {
            BQ.A00(th, this);
            if (A03[6].charAt(18) == 'Y') {
                throw new RuntimeException();
            }
            String[] strArr = A03;
            strArr[3] = "HSmZ";
            strArr[1] = "XRAr9C2gXTfshR7ejhjPx";
        }
    }
}
