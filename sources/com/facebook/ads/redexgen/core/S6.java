package com.facebook.ads.redexgen.core;

import android.net.Uri;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import com.google.common.base.Ascii;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class S6 implements UK {
    public static byte[] A0J;
    public static String[] A0K = {"eDvXBaCAnR01P9qg8KFXxWzDorbp", "CRsHUvPEDNwaTOIgGmTgbppY0hNsu16", "EDdwnZx2KKVwxMceSQpB2cO", "t5FzYzbh", "PwaApQ4WU9tlruSB0zoA", "qQN2rfQuW5CGDsO6CGRl87SPVFyk8uDK", "B05BLw5GkThczKxdvDGAT0SP1wHQCD0f", "LZ8OUp6xbGW2dhYkkMwhqLlIV5pcJd4p"};
    public static final UO A0L;
    public int A00;
    public int A01;
    public int A02;
    public UL A03;
    public SL A04;
    public YT A05;
    public boolean A06;
    public boolean A07;
    public boolean A08;
    public final int A09;
    public final int A0A;
    public final SparseArray<YT> A0B;
    public final SparseBooleanArray A0C;
    public final SparseBooleanArray A0D;
    public final SparseIntArray A0E;
    public final YM A0F;
    public final YQ A0G;
    public final C2447fq A0H;
    public final List<C2461g4> A0I;

    public static String A0D(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0J, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 41);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0G() {
        A0J = new byte[]{-43, -13, 0, 0, 1, 6, -78, -8, -5, 0, -10, -78, 5, Ascii.VT, 0, -11, -78, -12, Ascii.VT, 6, -9, -64, -78, -33, 1, 5, 6, -78, -2, -5, -3, -9, -2, Ascii.VT, -78, 0, 1, 6, -78, -13, -78, -26, 4, -13, 0, 5, 2, 1, 4, 6, -78, -27, 6, 4, -9, -13, -1, -64};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    @Override // com.facebook.ads.redexgen.core.UK
    public final int AGT(WJ wj, C1952Ug c1952Ug) throws IOException {
        long jA8E = wj.A8E();
        if (this.A08) {
            if (((jA8E == -1 || this.A09 == 2) ? false : true) && !this.A0F.A0A()) {
                return this.A0F.A07(wj, c1952Ug, this.A01);
            }
            A0H(jA8E);
            if (this.A07) {
                this.A07 = false;
                AIC(0L, 0L);
                if (wj.A8d() != 0) {
                    c1952Ug.A00 = 0L;
                    return 1;
                }
            }
            if (this.A04 != null && this.A04.A0B()) {
                return this.A04.A08(wj, c1952Ug);
            }
        }
        if (!A0J(wj)) {
            return -1;
        }
        int iA00 = A00();
        int iA0A = this.A0H.A0A();
        if (iA00 > iA0A) {
            return 0;
        }
        int iA0C = this.A0H.A0C();
        if ((8388608 & iA0C) != 0) {
            this.A0H.A0f(iA00);
            return 0;
        }
        int i = 0 | ((4194304 & iA0C) != 0 ? 1 : 0);
        int i2 = (2096896 & iA0C) >> 8;
        boolean z = (iA0C & 32) != 0;
        YT yt = (iA0C & 16) != 0 ? this.A0B.get(i2) : null;
        if (yt == null) {
            this.A0H.A0f(iA00);
            return 0;
        }
        if (this.A09 != 2) {
            int i3 = iA0C & 15;
            int i4 = this.A0E.get(i2, i3 - 1);
            this.A0E.put(i2, i3);
            if (i4 == i3) {
                this.A0H.A0f(iA00);
                return 0;
            }
            if (i3 != ((i4 + 1) & 15)) {
                yt.AIB();
            }
        }
        if (z) {
            int iA0I = this.A0H.A0I();
            i |= (this.A0H.A0I() & 64) != 0 ? 2 : 0;
            this.A0H.A0g(iA0I - 1);
        }
        boolean z2 = this.A08;
        if (A0I(i2)) {
            this.A0H.A0e(iA00);
            yt.A51(this.A0H, i);
            this.A0H.A0e(iA0A);
        }
        if (this.A09 != 2 && !z2 && this.A08 && jA8E != -1) {
            this.A07 = true;
        }
        this.A0H.A0f(iA00);
        return 0;
    }

    static {
        A0G();
        A0L = new UO() { // from class: com.facebook.ads.redexgen.X.SK
            @Override // com.facebook.ads.redexgen.core.UO
            public final UK[] A5D() {
                return S6.A0M();
            }

            @Override // com.facebook.ads.redexgen.core.UO
            public final /* synthetic */ UK[] A5E(Uri uri, Map map) {
                return UN.A01(this, uri, map);
            }
        };
    }

    public S6() {
        this(0);
    }

    public S6(int i) {
        this(1, i, 112800);
    }

    public S6(int i, int i2, int i3) {
        this(i, new C2461g4(0L), new C1921Sy(i2), i3);
    }

    public S6(int i, C2461g4 c2461g4, YQ yq, int i2) {
        this.A0G = (YQ) AbstractC2388es.A01(yq);
        this.A0A = i2;
        this.A09 = i;
        if (i == 1 || i == 2) {
            this.A0I = Collections.singletonList(c2461g4);
        } else {
            this.A0I = new ArrayList();
            this.A0I.add(c2461g4);
        }
        this.A0H = new C2447fq(new byte[9400], 0);
        this.A0C = new SparseBooleanArray();
        this.A0D = new SparseBooleanArray();
        this.A0B = new SparseArray<>();
        this.A0E = new SparseIntArray();
        this.A0F = new YM(i2);
        this.A03 = UL.A00;
        this.A01 = -1;
        A0F();
    }

    private int A00() throws Q6 {
        int iA09 = this.A0H.A09();
        int endOfPacket = this.A0H.A0A();
        int limit = YU.A00(this.A0H.A0l(), iA09, endOfPacket);
        this.A0H.A0f(limit);
        int syncBytePosition = limit + 188;
        if (syncBytePosition > endOfPacket) {
            int searchStart = this.A00;
            this.A00 = searchStart + (limit - iA09);
            if (this.A09 == 2 && this.A00 > 376) {
                throw Q6.A01(A0D(0, 58, 105), null);
            }
        } else {
            this.A00 = 0;
        }
        return syncBytePosition;
    }

    public static /* synthetic */ int A02(S6 s6) {
        int i = s6.A02;
        s6.A02 = i + 1;
        return i;
    }

    private void A0F() {
        this.A0C.clear();
        this.A0B.clear();
        SparseArray<YT> sparseArrayA5G = this.A0G.A5G();
        int size = sparseArrayA5G.size();
        for (int i = 0; i < size; i++) {
            SparseArray<YT> sparseArray = this.A0B;
            int initialPayloadReadersSize = sparseArrayA5G.keyAt(i);
            sparseArray.put(initialPayloadReadersSize, sparseArrayA5G.valueAt(i));
        }
        this.A0B.put(0, new SU(new S8(this)));
        this.A05 = null;
    }

    private void A0H(long j) {
        if (!this.A06) {
            this.A06 = true;
            if (this.A0F.A08() != -9223372036854775807L) {
                this.A04 = new SL(this.A0F.A09(), this.A0F.A08(), j, this.A01, this.A0A);
                this.A03.AID(this.A04.A09());
            } else {
                this.A03.AID(new C1991Vy(this.A0F.A08()));
            }
        }
    }

    private boolean A0I(int i) {
        return this.A09 == 2 || this.A08 || !this.A0D.get(i, false);
    }

    private boolean A0J(WJ wj) throws IOException {
        byte[] bArrA0l = this.A0H.A0l();
        if (9400 - this.A0H.A09() < 188) {
            int iA07 = this.A0H.A07();
            if (iA07 > 0) {
                C2447fq c2447fq = this.A0H;
                int bytesLeft = A0K[1].length();
                if (bytesLeft != 31) {
                    throw new RuntimeException();
                }
                String[] strArr = A0K;
                strArr[3] = "mVmQJwG5";
                strArr[4] = "wWSd6EQydIaldTPyDth7";
                System.arraycopy(bArrA0l, c2447fq.A09(), bArrA0l, 0, iA07);
            }
            this.A0H.A0j(bArrA0l, iA07);
        }
        while (this.A0H.A07() < 188) {
            int iA0A = this.A0H.A0A();
            int limit = wj.read(bArrA0l, iA0A, 9400 - iA0A);
            if (limit == -1) {
                return false;
            }
            this.A0H.A0e(iA0A + limit);
        }
        return true;
    }

    public static /* synthetic */ UK[] A0M() {
        return new UK[]{new S6()};
    }

    @Override // com.facebook.ads.redexgen.core.UK
    public final void AA0(UL ul) {
        this.A03 = ul;
    }

    @Override // com.facebook.ads.redexgen.core.UK
    public final void AGj() {
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0068  */
    @Override // com.facebook.ads.redexgen.core.UK
    public final void AIC(long j, long j2) {
        AbstractC2388es.A08(this.A09 != 2);
        int size = this.A0I.size();
        for (int i = 0; i < size; i++) {
            C2461g4 c2461g4 = this.A0I.get(i);
            boolean z = c2461g4.A04() == -9223372036854775807L;
            if (!z) {
                long jA02 = c2461g4.A02();
                if (jA02 == -9223372036854775807L || jA02 == 0) {
                    z = false;
                } else {
                    String[] strArr = A0K;
                    if (strArr[2].length() == strArr[0].length()) {
                        throw new RuntimeException();
                    }
                    String[] strArr2 = A0K;
                    strArr2[2] = "fBsuPiT1Wh0kLzGMNGcOHST";
                    strArr2[0] = "cB0wbCFgxRATzfLY8tY0cWgNuZKQ";
                    if (jA02 != j2) {
                        z = true;
                    } else {
                        z = false;
                    }
                }
            }
            if (z) {
                c2461g4.A07(j2);
            }
        }
        if (A0K[1].length() != 31) {
            throw new RuntimeException();
        }
        String[] strArr3 = A0K;
        strArr3[5] = "2cw28rXfaum1nsk3xkwwYNSI11bUSNZ3";
        strArr3[6] = "ymcuFd0Ci2EoarZokr4bkCSKpC4DCbUe";
        if (j2 != 0 && this.A04 != null) {
            this.A04.A0A(j2);
        }
        this.A0H.A0d(0);
        this.A0E.clear();
        for (int i2 = 0; i2 < this.A0B.size(); i2++) {
            this.A0B.valueAt(i2).AIB();
        }
        this.A00 = 0;
    }

    @Override // com.facebook.ads.redexgen.core.UK
    public final boolean AJB(WJ wj) throws IOException {
        byte[] bArrA0l = this.A0H.A0l();
        wj.AG1(bArrA0l, 0, 940);
        for (int i = 0; i < 188; i++) {
            boolean isSyncBytePatternCorrect = true;
            for (int i2 = 0; i2 < 5; i2++) {
                int startPosCandidate = bArrA0l[(i2 * 188) + i];
                if (startPosCandidate != 71) {
                    isSyncBytePatternCorrect = false;
                    break;
                }
            }
            if (isSyncBytePatternCorrect) {
                wj.AJ9(i);
                String[] strArr = A0K;
                String str = strArr[2];
                String str2 = strArr[0];
                int startPosCandidate2 = str.length();
                if (startPosCandidate2 == str2.length()) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A0K;
                strArr2[3] = "pXazUYtr";
                strArr2[4] = "sPcm7pqopUXHJIOxWE2u";
                return true;
            }
        }
        return false;
    }
}
