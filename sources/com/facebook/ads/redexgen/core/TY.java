package com.facebook.ads.redexgen.core;

import com.google.common.base.Ascii;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import kotlin.io.encoding.Base64;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class TY implements InterfaceC2002Wj {
    public static byte[] A0C;
    public static String[] A0D = {"WF46WHJCw3SZqgir0OhX0e", "Fm6tH6FGx2F2eoHEi3xJmouac8yIuHtD", "QwVzU1PUWaoHSlEIfRInoqEV2ghoZbA4", "wjMneY5bvWAB28JkWtcJxA3MQdDdUQyN", "Z", "sSPeRGAZuf2l2BWEhdFMdqCU2CN9JTIb", "bEqy2Eixis9SHXvU", "iJDRrAM0ll7BlV6JG0oI0qSX1V3YVwgB"};
    public int A00;
    public long A01;
    public long A02;
    public long A03;
    public long A04;
    public long A05;
    public long A06;
    public long A07;
    public final long A08;
    public final long A09;
    public final C2001Wi A0A;
    public final AbstractC2005Wm A0B;

    public static String A07(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0C, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 101);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A08() {
        A0C = new byte[]{Ascii.NAK, 52, 123, 52, 60, 60, 123, 43, 58, 60, 62, 123, 56, 58, 53, 123, 57, 62, 123, Base64.padSymbol, 52, 46, 53, 63, 117};
    }

    static {
        A08();
    }

    public TY(AbstractC2005Wm abstractC2005Wm, long j, long j2, long j3, long j4, boolean z) {
        AbstractC2388es.A07(j >= 0 && j2 > j);
        this.A0B = abstractC2005Wm;
        this.A09 = j;
        this.A08 = j2;
        if (j3 == j2 - j || z) {
            this.A07 = j4;
            this.A00 = 4;
        } else {
            this.A00 = 0;
        }
        this.A0A = new C2001Wi();
    }

    private long A00(WJ wj) throws IOException {
        if (this.A04 == this.A01) {
            return -1L;
        }
        long jA8d = wj.A8d();
        if (!this.A0A.A04(wj, this.A01)) {
            if (this.A04 != jA8d) {
                return this.A04;
            }
            throw new IOException(A07(0, 25, 62));
        }
        this.A0A.A05(wj, false);
        wj.AHr();
        long offset = this.A06 - this.A0A.A05;
        int i = this.A0A.A01 + this.A0A.A00;
        if (0 <= offset && offset < 72000) {
            return -1L;
        }
        String[] strArr = A0D;
        if (strArr[5].charAt(24) != strArr[2].charAt(24)) {
            throw new RuntimeException();
        }
        A0D[4] = "i";
        if (offset < 0) {
            this.A01 = jA8d;
            this.A02 = this.A0A.A05;
        } else {
            long currentPosition = wj.A8d();
            this.A04 = currentPosition + ((long) i);
            this.A05 = this.A0A.A05;
        }
        if (this.A01 - this.A04 < 100000) {
            this.A01 = this.A04;
            return this.A04;
        }
        long currentPosition2 = i;
        long jA8d2 = wj.A8d() - (currentPosition2 * (offset <= 0 ? 2L : 1L));
        long granuleDistance = this.A01;
        long granuleDistance2 = (granuleDistance - this.A04) * offset;
        long currentPosition3 = this.A02;
        long nextPosition = jA8d2 + (granuleDistance2 / (currentPosition3 - this.A05));
        return AbstractC2471gE.A0T(nextPosition, this.A04, this.A01 - 1);
    }

    private final long A01(WJ wj) throws IOException {
        this.A0A.A02();
        if (this.A0A.A03(wj)) {
            this.A0A.A05(wj, false);
            wj.AJ9(this.A0A.A01 + this.A0A.A00);
            long j = this.A0A.A05;
            while ((this.A0A.A04 & 4) != 4 && this.A0A.A03(wj) && wj.A8d() < this.A08) {
                C2001Wi c2001Wi = this.A0A;
                if (A0D[6].length() != 16) {
                    throw new RuntimeException();
                }
                A0D[6] = "04w2Ylrvfp1ZeLi2";
                if (!c2001Wi.A05(wj, true) || !UM.A02(wj, this.A0A.A01 + this.A0A.A00)) {
                    return j;
                }
                j = this.A0A.A05;
            }
            return j;
        }
        throw new EOFException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.core.InterfaceC2002Wj
    /* JADX INFO: renamed from: A05, reason: merged with bridge method [inline-methods] */
    public final TZ A5P() {
        C1999Wg c1999Wg = null;
        if (this.A07 != 0) {
            return new TZ(this);
        }
        return null;
    }

    private void A09(WJ wj) throws IOException {
        while (true) {
            this.A0A.A03(wj);
            this.A0A.A05(wj, false);
            if (this.A0A.A05 > this.A06) {
                wj.AHr();
                return;
            } else {
                wj.AJ9(this.A0A.A01 + this.A0A.A00);
                this.A04 = wj.A8d();
                this.A05 = this.A0A.A05;
            }
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2002Wj
    public final long AGV(WJ wj) throws IOException {
        switch (this.A00) {
            case 0:
                this.A03 = wj.A8d();
                this.A00 = 1;
                long j = this.A08 - 65307;
                if (j > this.A03) {
                    return j;
                }
            case 1:
                long lastPageSearchPosition = A01(wj);
                this.A07 = lastPageSearchPosition;
                this.A00 = 4;
                return this.A03;
            case 2:
                long jA00 = A00(wj);
                if (jA00 != -1) {
                    return jA00;
                }
                this.A00 = 3;
                break;
            case 3:
                A09(wj);
                this.A00 = 4;
                return -(this.A05 + 2);
            case 4:
                return -1L;
            default:
                throw new IllegalStateException();
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2002Wj
    public final void AJH(long j) {
        this.A06 = AbstractC2471gE.A0T(j, 0L, this.A07 - 1);
        this.A00 = 2;
        this.A04 = this.A09;
        this.A01 = this.A08;
        this.A05 = 0L;
        this.A02 = this.A07;
    }
}
