package com.facebook.ads.redexgen.core;

import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import com.google.android.exoplayer2.Metadata;
import java.util.Arrays;
import java.util.List;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class TT extends AbstractC2005Wm {
    public static byte[] A01;
    public static String[] A02 = {"7v8", "DJnAqA6E6GDxffX70NYr0", "HMLexD2OfxLNkU4i", "PdG9cApk0h3cc1dwc0B2XtSkTW0Y6TE7", "k5UYWxYoR6LVtHRSH", "eRCldoUDD0o6zGdoEaM2lUCIMkyllDxL", "lqQ9oYP4JspO70UG6xFVp2o", "mWW9QFKoLcrpuCRp3uybTZIfvCH3M1OH"};
    public static final byte[] A03;
    public static final byte[] A04;
    public boolean A00;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            String[] strArr = A02;
            if (strArr[1].length() == strArr[4].length()) {
                throw new RuntimeException();
            }
            A02[7] = "0GryWP3WhhGjhrW1os7LcWQKbX07XUhe";
            if (i4 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 101);
            i4++;
        }
    }

    public static void A01() {
        A01 = new byte[]{-26, -6, -23, -18, -12, -76, -12, -11, -6, -8};
    }

    static {
        A01();
        A04 = new byte[]{79, 112, 117, 115, 72, 101, 97, 100};
        A03 = new byte[]{79, 112, 117, 115, 84, 97, 103, 115};
    }

    public static boolean A02(C2447fq c2447fq) {
        return A03(c2447fq, A04);
    }

    public static boolean A03(C2447fq c2447fq, byte[] bArr) {
        if (c2447fq.A07() < bArr.length) {
            return false;
        }
        int iA09 = c2447fq.A09();
        int startPosition = bArr.length;
        byte[] header = new byte[startPosition];
        int startPosition2 = bArr.length;
        c2447fq.A0k(header, 0, startPosition2);
        c2447fq.A0f(iA09);
        return Arrays.equals(header, bArr);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2005Wm
    public final long A0E(C2447fq c2447fq) {
        return A0D(AbstractC1950Ue.A05(c2447fq.A0l()));
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2005Wm
    public final void A0I(boolean z) {
        super.A0I(z);
        if (z) {
            this.A00 = false;
        }
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2005Wm
    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    @MetaExoPlayerCustomization("Replaces ImmutableList.of with MetaExoPlayerCustomizedCollections")
    public final boolean A0J(C2447fq c2447fq, long j, C2004Wl c2004Wl) throws Q6 {
        if (A03(c2447fq, A04)) {
            byte[] headerBytes = Arrays.copyOf(c2447fq.A0l(), c2447fq.A0A());
            int iA01 = AbstractC1950Ue.A01(headerBytes);
            List<byte[]> listA06 = AbstractC1950Ue.A06(headerBytes);
            if (c2004Wl.A00 != null) {
                return true;
            }
            c2004Wl.A00 = new P5().A11(A00(0, 10, 32)).A0b(iA01).A0m(48000).A12(listA06).A14();
            return true;
        }
        if (A03(c2447fq, A03)) {
            AbstractC2388es.A02(c2004Wl.A00);
            if (this.A00) {
                return true;
            }
            this.A00 = true;
            c2447fq.A0g(A03.length);
            C1961Us c1961UsA05 = AbstractC1964Uv.A05(c2447fq, false, false);
            String[] strArr = A02;
            if (strArr[6].length() == strArr[0].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A02;
            strArr2[1] = "KPvlxsXHjKjWQgdGdRHEY";
            strArr2[4] = "TRmC9Fc3RAZb1EOf4";
            Metadata metadataA02 = AbstractC1964Uv.A02(MetaExoPlayerCustomizedCollections.A02(c1961UsA05.A02));
            if (metadataA02 == null) {
                return true;
            }
            c2004Wl.A00 = c2004Wl.A00.A07().A0v(metadataA02.A04(c2004Wl.A00.A0P)).A14();
            return true;
        }
        AbstractC2388es.A02(c2004Wl.A00);
        return false;
    }
}
