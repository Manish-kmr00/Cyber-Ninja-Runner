package com.facebook.ads.redexgen.core;

import android.net.Uri;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import com.google.common.base.Ascii;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import kotlin.io.encoding.Base64;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class RB implements InterfaceC2164bF {
    public static byte[] A03;
    public static String[] A04 = {"51zoTUQSZUkAm9N", "UmDZDEYxiFNidmc", "juFDCpz3v21RfDAwdfYhV9A2wKaxsmcO", "MhCn0J4SV0NDUAwG4DVpMSgSbJKOqp8K", "mTgNIz0SrBR0YJWzZDcYYsasjGQnrGPZ", "gUk4H2YjEaz2W3r8htX3i3SxyPgmNb3p", "gIYq6lStA20yFLF", "d0bSd06rXARdF1mViNDpEI0PQMof55jj"};
    public UK A00;
    public WJ A01;
    public final UO A02;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            if (A04[5].charAt(2) == 'Y') {
                throw new RuntimeException();
            }
            A04[1] = "JhJbGfNBWj2SchhK4njS";
            if (i4 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 86);
            i4++;
        }
    }

    public static void A01() {
        A03 = new byte[]{106, 99, 32, 44, 54, 47, 39, 99, 49, 38, 34, 39, 99, 55, 43, 38, 99, 48, 55, 49, 38, 34, 46, 109, Ascii.ESC, 58, 59, 48, 117, 58, 51, 117, 33, Base64.padSymbol, 48, 117, 52, 35, 52, 60, 57, 52, 55, 57, 48, 117, 48, 45, 33, 39, 52, 54, 33, 58, 39, 38, 117, 125};
    }

    static {
        A01();
    }

    public RB(UO uo) {
        this.A02 = uo;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2164bF
    @MetaExoPlayerCustomization("No op, we don't include mp3 extractor due to apk size")
    public final void A5o() {
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2164bF
    public final long A7Q() {
        if (this.A01 != null) {
            return this.A01.A8d();
        }
        return -1L;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0071  */
    @Override // com.facebook.ads.redexgen.core.InterfaceC2164bF
    public final void AA2(@MetaExoPlayerCustomization(" To be replaced with DataReader after upstream is updated") Q7 q7, Uri uri, Map<String, List<String>> map, long j, long j2, UL ul) throws IOException {
        C1488Bm c1488Bm = new C1488Bm(q7, j, j2);
        this.A01 = c1488Bm;
        if (this.A00 != null) {
            return;
        }
        UK[] extractors = this.A02.A5E(uri, map);
        if (extractors.length == 1) {
            this.A00 = extractors[0];
        } else {
            for (UK uk : extractors) {
                try {
                    if (uk.AJB(c1488Bm)) {
                        this.A00 = uk;
                        AbstractC2388es.A08(this.A00 != null || c1488Bm.A8d() == j);
                        c1488Bm.AHr();
                        break;
                    }
                    UK uk2 = this.A00;
                    if (A04[5].charAt(2) != 'Y') {
                        String[] strArr = A04;
                        strArr[3] = "8kj5VrbPtwaIoo0LpNzSKZhngqRFdq29";
                        strArr[2] = "nhcaDnfi33aQSZlbYtXEwDlk6HBHndor";
                        boolean z = uk2 != null || c1488Bm.A8d() == j;
                        AbstractC2388es.A08(z);
                        c1488Bm.AHr();
                    } else {
                        throw new RuntimeException();
                    }
                } catch (EOFException unused) {
                    if (this.A00 != null || c1488Bm.A8d() == j) {
                    }
                } catch (Throwable th) {
                    AbstractC2388es.A08(this.A00 != null || c1488Bm.A8d() == j);
                    c1488Bm.AHr();
                    throw th;
                }
                AbstractC2388es.A08(z);
                c1488Bm.AHr();
            }
            if (this.A00 == null) {
                throw new C1861Qp(A00(24, 34, 3) + AbstractC2471gE.A0s(extractors) + A00(0, 24, 21), (Uri) AbstractC2388es.A01(uri));
            }
        }
        this.A00.AA0(ul);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2164bF
    public final int AGU(C1952Ug c1952Ug) throws IOException {
        return ((UK) AbstractC2388es.A01(this.A00)).AGT((WJ) AbstractC2388es.A01(this.A01), c1952Ug);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2164bF
    public final void AGj() {
        if (this.A00 != null) {
            this.A00.AGj();
            this.A00 = null;
        }
        this.A01 = null;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2164bF
    public final void AIC(long j, long j2) {
        ((UK) AbstractC2388es.A01(this.A00)).AIC(j, j2);
    }
}
