package com.facebook.ads.redexgen.core;

import com.google.android.exoplayer2.Metadata;
import java.io.EOFException;
import java.io.IOException;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class UX {
    public final C2447fq A00 = new C2447fq(10);

    public final Metadata A00(WJ wj, VP vp) throws IOException {
        int tagLength = 0;
        Metadata metadataA0S = null;
        while (true) {
            try {
                wj.AG1(this.A00.A0l(), 0, 10);
                this.A00.A0f(0);
                if (this.A00.A0K() != 4801587) {
                    break;
                }
                this.A00.A0g(3);
                int iA0H = this.A00.A0H();
                int framesLength = iA0H + 10;
                if (metadataA0S == null) {
                    byte[] bArr = new byte[framesLength];
                    System.arraycopy(this.A00.A0l(), 0, bArr, 0, 10);
                    wj.AG1(bArr, 10, iA0H);
                    metadataA0S = new B2(vp).A0S(bArr, framesLength);
                } else {
                    wj.A3x(iA0H);
                }
                tagLength += framesLength;
            } catch (EOFException unused) {
            }
        }
        wj.AHr();
        wj.A3x(tagLength);
        return metadataA0S;
    }
}
