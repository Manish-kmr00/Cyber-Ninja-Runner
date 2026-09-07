package com.facebook.ads.redexgen.core;

import android.net.Uri;
import com.vungle.ads.internal.protos.Sdk;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class T0 implements UK {
    public static byte[] A0C;
    public static String[] A0D = {"cgFenzwDW5KqcG", "Ec", "vVHSxJjqeSREjo7F022y1r5oD8PWH0Xg", "x76UAYGklYukrRCESs63QXBLPT5V7IGo", "UQ5JyBbvoDZayl", "ilFZSXQCeq61y12", "wyRrrqqdz7Pkdmn3kQgUDLsZGAplu5cK", "qYTY3RjP5zhXG2SSI8LioXR4R26oJPDS"};
    public static final UO A0E;
    public int A00;
    public long A01;
    public long A02;
    public UL A03;
    public boolean A04;
    public boolean A05;
    public boolean A06;
    public final int A07;
    public final C1922Sz A08;
    public final C2446fp A09;
    public final C2447fq A0A;
    public final C2447fq A0B;

    public static String A03(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0C, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 105);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A04() {
        A0C = new byte[]{95, 115, 126, 116, 125, 96, 127, 119, 118, 50, 83, 86, 70, 65, 50, 97, 102, 96, 119, 115, 127};
    }

    static {
        A04();
        A0E = new UO() { // from class: com.facebook.ads.redexgen.X.T1
            @Override // com.facebook.ads.redexgen.core.UO
            public final UK[] A5D() {
                return T0.A07();
            }

            @Override // com.facebook.ads.redexgen.core.UO
            public final /* synthetic */ UK[] A5E(Uri uri, Map map) {
                return UN.A01(this, uri, map);
            }
        };
    }

    public T0() {
        this(0);
    }

    public T0(int i) {
        this.A07 = (i & 2) != 0 ? i | 1 : i;
        this.A08 = new C1922Sz(true);
        this.A0A = new C2447fq(2048);
        this.A00 = -1;
        this.A01 = -1L;
        this.A0B = new C2447fq(10);
        this.A09 = new C2446fp(this.A0B.A0l());
    }

    public static int A00(int i, long j) {
        return (int) (((((long) i) * 8) * 1000000) / j);
    }

    private int A01(WJ wj) throws IOException {
        int i = 0;
        while (true) {
            wj.AG1(this.A0B.A0l(), 0, 10);
            this.A0B.A0f(0);
            int iA0K = this.A0B.A0K();
            String[] strArr = A0D;
            String str = strArr[4];
            String str2 = strArr[0];
            int length = str.length();
            int firstFramePosition = str2.length();
            if (length != firstFramePosition) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0D;
            strArr2[4] = "wP00ATDHt4wP9R";
            strArr2[0] = "ejQ9Of1kEavypa";
            if (iA0K != 4801587) {
                wj.AHr();
                wj.A3x(i);
                if (this.A01 == -1) {
                    this.A01 = i;
                }
                return i;
            }
            C2447fq c2447fq = this.A0B;
            String[] strArr3 = A0D;
            String str3 = strArr3[7];
            String str4 = strArr3[3];
            int iCharAt = str3.charAt(21);
            int firstFramePosition2 = str4.charAt(21);
            if (iCharAt != firstFramePosition2) {
                c2447fq.A0g(3);
                int length2 = this.A0B.A0H();
                int firstFramePosition3 = length2 + 10;
                i += firstFramePosition3;
                wj.A3x(length2);
            } else {
                A0D[2] = "h9F4Q195dJ4ftkf4KGDaWoWkGct7LrBx";
                c2447fq.A0g(3);
                int length3 = this.A0B.A0H();
                int firstFramePosition4 = length3 + 10;
                i += firstFramePosition4;
                wj.A3x(length3);
            }
        }
    }

    private WV A02(long j, boolean z) {
        return new WV(j, this.A01, A00(this.A00, this.A08.A0J()), this.A00, z);
    }

    @RequiresNonNull({"extractorOutput"})
    private void A05(long j, boolean z) {
        if (this.A05) {
            return;
        }
        boolean z2 = (this.A07 & 1) != 0 && this.A00 > 0;
        if (z2 && this.A08.A0J() == -9223372036854775807L && !z) {
            return;
        }
        if (!z2 || this.A08.A0J() == -9223372036854775807L) {
            this.A03.AID(new C1991Vy(-9223372036854775807L));
        } else {
            this.A03.AID(A02(j, (this.A07 & 2) != 0));
        }
        this.A05 = true;
    }

    /* JADX WARN: Code duplicated, block: B:35:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:41:0x00d4  */
    private void A06(WJ wj) throws IOException {
        if (this.A04) {
            return;
        }
        this.A00 = -1;
        wj.AHr();
        if (wj.A8d() == 0) {
            A01(wj);
        }
        int currentFrameSize = 0;
        String[] strArr = A0D;
        if (strArr[7].charAt(21) != strArr[3].charAt(21)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0D;
        strArr2[4] = "drDm1EUlHFo4FY";
        strArr2[0] = "aneJqUI13EnV7a";
        long j = 0;
        while (true) {
            try {
                if (wj.AG2(this.A0B.A0l(), 0, 2, true)) {
                    this.A0B.A0f(0);
                    if (C1922Sz.A0F(this.A0B.A0M())) {
                        if (wj.AG2(this.A0B.A0l(), 0, 4, true)) {
                            this.A09.A08(14);
                            int iA04 = this.A09.A04(13);
                            int numValidFrames = A0D[6].charAt(4);
                            if (numValidFrames != 114) {
                                A0D[2] = "0VIbKUnWjYbiZbrdpxWBEEMjm5nHxFx0";
                                if (iA04 <= 6) {
                                    this.A04 = true;
                                    throw Q6.A01(A03(0, 21, Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE), null);
                                }
                                j += (long) iA04;
                                currentFrameSize++;
                                if (currentFrameSize == 1000 && wj.A3y(iA04 - 6, true)) {
                                }
                            } else {
                                String[] strArr3 = A0D;
                                strArr3[7] = "7ogHHFrhWZ939f5KnDf16XelqnXPwYbw";
                                strArr3[3] = "Um7VfUyHvC6VVjFNAMrMkXurlKY4h9LR";
                                if (iA04 <= 6) {
                                    this.A04 = true;
                                    throw Q6.A01(A03(0, 21, Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE), null);
                                }
                                j += (long) iA04;
                                currentFrameSize++;
                                if (currentFrameSize == 1000) {
                                }
                            }
                        }
                    } else {
                        currentFrameSize = 0;
                    }
                }
            } catch (EOFException unused) {
            }
            wj.AHr();
            int numValidFrames2 = A0D[6].charAt(4);
            if (numValidFrames2 != 114) {
                if (currentFrameSize > 0) {
                    this.A00 = (int) (j / ((long) currentFrameSize));
                } else {
                    this.A00 = -1;
                }
            } else {
                A0D[6] = "xa6xrebUfS98mlFlNpUCPZtzD2kACzau";
                if (currentFrameSize > 0) {
                    this.A00 = (int) (j / ((long) currentFrameSize));
                } else {
                    this.A00 = -1;
                }
            }
            this.A04 = true;
            return;
        }
    }

    public static /* synthetic */ UK[] A07() {
        return new UK[]{new T0()};
    }

    @Override // com.facebook.ads.redexgen.core.UK
    public final void AA0(UL ul) {
        this.A03 = ul;
        this.A08.A5S(ul, new YS(0, 1));
        ul.A6E();
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0042  */
    @Override // com.facebook.ads.redexgen.core.UK
    public final int AGT(WJ wj, C1952Ug c1952Ug) throws IOException {
        boolean z;
        AbstractC2388es.A02(this.A03);
        long jA8E = wj.A8E();
        if ((this.A07 & 2) == 0) {
            if ((this.A07 & 1) != 0) {
                String[] strArr = A0D;
                if (strArr[7].charAt(21) != strArr[3].charAt(21)) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A0D;
                strArr2[7] = "OE1NfJIxS5SHcv1aN31TwXwGA5ejZFvk";
                strArr2[3] = "uRSs1jsQWOPkb5tmplkhyX6U4DWChd5h";
                z = jA8E != -1;
            }
        }
        if (z) {
            A06(wj);
        }
        int i = wj.read(this.A0A.A0l(), 0, 2048);
        boolean z2 = i == -1;
        A05(jA8E, z2);
        if (z2) {
            return -1;
        }
        this.A0A.A0f(0);
        this.A0A.A0e(i);
        if (!this.A06) {
            this.A08.AFy(this.A02, 4);
            this.A06 = true;
        }
        this.A08.A50(this.A0A);
        return 0;
    }

    @Override // com.facebook.ads.redexgen.core.UK
    public final void AGj() {
    }

    @Override // com.facebook.ads.redexgen.core.UK
    public final void AIC(long j, long j2) {
        this.A06 = false;
        this.A08.AIB();
        this.A02 = j2;
    }

    @Override // com.facebook.ads.redexgen.core.UK
    public final boolean AJB(WJ wj) throws IOException {
        int iA01 = A01(wj);
        int i = iA01;
        int frameSize = 0;
        int syncBytes = 0;
        do {
            wj.AG1(this.A0B.A0l(), 0, 2);
            this.A0B.A0f(0);
            int startPosition = this.A0B.A0M();
            if (!C1922Sz.A0F(startPosition)) {
                syncBytes = 0;
                frameSize = 0;
                i++;
                wj.AHr();
                wj.A3x(i);
            } else {
                syncBytes++;
                if (syncBytes >= 4 && frameSize > 188) {
                    return true;
                }
                wj.AG1(this.A0B.A0l(), 0, 4);
                this.A09.A08(14);
                int headerPosition = this.A09.A04(13);
                if (headerPosition <= 6) {
                    syncBytes = 0;
                    frameSize = 0;
                    i++;
                    String[] strArr = A0D;
                    String str = strArr[4];
                    String str2 = strArr[0];
                    int headerPosition2 = str.length();
                    int startPosition2 = str2.length();
                    if (headerPosition2 != startPosition2) {
                        throw new RuntimeException();
                    }
                    A0D[2] = "rGwe6hw4R5Xd7NHfbMgWBrUiWSTU8lSN";
                    wj.AHr();
                    wj.A3x(i);
                } else {
                    int startPosition3 = headerPosition - 6;
                    wj.A3x(startPosition3);
                    frameSize += headerPosition;
                }
            }
        } while (i - iA01 < 8192);
        return false;
    }
}
