package com.facebook.ads.redexgen.core;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.util.Pair;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomizations;
import com.google.android.exoplayer2.Timeline;
import com.google.common.base.Ascii;
import com.vungle.ads.internal.protos.Sdk;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import kotlin.io.encoding.Base64;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class E8 implements Handler.Callback, R8, InterfaceC2288dF, InterfaceC2150ay, OH, QR {
    public static byte[] A0w;
    public static String[] A0x = {"FNv1yg7gplSOMBReEHuDl", "qwSibVPXYhaaXxWnXBbumtSIL5oKuuC", "rhLD3EGe7POXN9aLHIDNMYdZDB4f8iqw", "bjU0csgypDx1p8Ai8tljHkRuVIlZh2eB", "cSwWDHV", "j7z3LKu66x9RSVpdS", "7XnkBgbzYVwaOjOpiFJCZYIuJhfmv6KE", "IctjxhVXeYDq8Szs7awUIix8ZBDi41tz"};
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public long A04;
    public long A06;
    public C1805Oh A08;
    public C1809Ol A09;
    public Q9 A0B;

    @MetaExoPlayerCustomization("D18870411: Adding start stall debug reason")
    public InterfaceC2059Yq A0C;
    public C1859Qn A0D;
    public InterfaceC2151az A0E;
    public boolean A0F;
    public boolean A0G;
    public boolean A0H;
    public boolean A0J;
    public boolean A0L;
    public boolean A0M;
    public boolean A0N;
    public boolean A0O;
    public boolean A0P;
    public boolean A0Q;
    public boolean A0R;
    public boolean A0S;
    public boolean A0T;
    public boolean A0U;
    public InterfaceC2059Yq[] A0V;
    public final long A0X;
    public final long A0Y;
    public final Handler A0Z;
    public final HandlerThread A0a;
    public final C2074Zf A0b;
    public final C1808Ok A0c;
    public final PC A0d;
    public final C2055Ym A0f;
    public final C2050Yh A0g;
    public final C2048Yf A0h;
    public final AbstractC2289dG A0i;
    public final C2290dH A0j;
    public final InterfaceC2301dS A0k;
    public final InterfaceC2395ez A0l;
    public final InterfaceC2423fS A0m;
    public final C13144c A0n;
    public final ArrayList<C1807Oj> A0o;
    public final boolean A0p;
    public final boolean A0q;
    public final boolean A0r;
    public final boolean A0s;
    public final boolean A0t;
    public final InterfaceC2059Yq[] A0u;
    public final InterfaceC1854Qi[] A0v;
    public long A05 = -9223372036854775807L;

    @MetaExoPlayerCustomization("D18870411: Adding start stall debug reason")
    public MI A07 = MI.A09;

    @MetaExoPlayerCustomization("D63737392: Added for negative testing")
    public boolean A0I = false;

    @MetaExoPlayerCustomization("D63737392: Added for negative testing")
    public Q4 A0A = null;

    @MetaExoPlayerCustomization("D63737392: Added for negative testing")
    public boolean A0K = false;
    public final C1827Pf A0e = new C1827Pf();

    @MetaExoPlayerCustomization
    public final int A0W = A00();

    public static String A0C(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0w, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 74);
        }
        return new String(bArrCopyOfRange);
    }

    /* JADX WARN: Code duplicated, block: B:115:0x0244  */
    /* JADX WARN: Code duplicated, block: B:117:0x024a  */
    /* JADX WARN: Code duplicated, block: B:165:0x0336  */
    /* JADX WARN: Code duplicated, block: B:176:0x0359  */
    /* JADX WARN: Code duplicated, block: B:181:0x0374  */
    /* JADX WARN: Code duplicated, block: B:182:0x0380  */
    /* JADX WARN: Code duplicated, block: B:18:0x009e  */
    /* JADX WARN: Code duplicated, block: B:198:0x03d0  */
    /* JADX WARN: Code duplicated, block: B:200:0x03d7  */
    /* JADX WARN: Code duplicated, block: B:205:0x03ec  */
    /* JADX WARN: Code duplicated, block: B:207:0x03f1  */
    /* JADX WARN: Code duplicated, block: B:209:0x0404  */
    /* JADX WARN: Code duplicated, block: B:20:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:211:0x040a  */
    /* JADX WARN: Code duplicated, block: B:213:0x0414  */
    /* JADX WARN: Code duplicated, block: B:214:0x041c  */
    /* JADX WARN: Code duplicated, block: B:22:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:24:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:26:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:28:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:30:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:33:0x00df  */
    /* JADX WARN: Code duplicated, block: B:43:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:45:0x010a  */
    /* JADX WARN: Code duplicated, block: B:47:0x0113  */
    /* JADX WARN: Code duplicated, block: B:49:0x0119  */
    /* JADX WARN: Code duplicated, block: B:51:0x011d  */
    /* JADX WARN: Code duplicated, block: B:68:0x0176  */
    /* JADX WARN: Code duplicated, block: B:72:0x0187  */
    /* JADX WARN: Code duplicated, block: B:73:0x018a  */
    /* JADX WARN: Code duplicated, block: B:76:0x019a  */
    /* JADX WARN: Code duplicated, block: B:77:0x019e  */
    /* JADX WARN: Code duplicated, block: B:78:0x01a2  */
    /* JADX WARN: Code duplicated, block: B:81:0x01af  */
    /* JADX WARN: Code duplicated, block: B:85:0x01b9  */
    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    /* JADX WARN: Instruction removed from duplicated block: B:115:0x0244, please report this as an issue */
    @MetaExoPlayerCustomization("D18870411: Adding start stall debug reason")
    private void A0E() throws EK, IOException {
        String strA0C;
        String strA0C2;
        int iA00;
        int i;
        int i2;
        InterfaceC2059Yq interfaceC2059Yq;
        boolean z;
        boolean zAAE;
        long j;
        long jAJj = this.A0l.AJj();
        A0O();
        if (this.A0e.A0N()) {
            C1822Pa c1822PaA0F = this.A0e.A0F();
            C1822Pa c1822PaA0G = this.A0e.A0G();
            AbstractC2462g5.A02(A0C(353, 10, 86));
            A0P();
            long jElapsedRealtime = SystemClock.elapsedRealtime() * 1000;
            c1822PaA0F.A07.A5q(this.A0B.A0C - this.A0X, this.A0q);
            boolean z2 = false;
            boolean zAAE2 = true;
            boolean z3 = true;
            boolean z4 = this.A0V.length > 1;
            InterfaceC2059Yq[] interfaceC2059YqArr = this.A0V;
            int length = interfaceC2059YqArr.length;
            int i3 = 0;
            while (true) {
                strA0C = A0C(Sdk.SDKError.Reason.STALE_CACHED_RESPONSE_VALUE, 35, 74);
                if (A0x[6].charAt(6) != 'b') {
                    strA0C2 = A0C(0, 21, 8);
                    if (i3 >= length) {
                        break;
                    }
                    interfaceC2059Yq = interfaceC2059YqArr[i3];
                    interfaceC2059Yq.AHd(this.A06, jElapsedRealtime);
                    if (c1822PaA0G.A00.A05) {
                        if (this.A0N) {
                            if (interfaceC2059Yq.A9f()) {
                                interfaceC2059Yq.AIT();
                            } else if (!this.A0G) {
                                j = this.A0B.A0C;
                                if (A0x[3].charAt(28) != 'h') {
                                    A0x[6] = "qA5tc5bmEYyYjSJQ9v0YcmXktsYBFhat";
                                    if (j != -1) {
                                        if (O5.A01(this.A0B.A0C - this.A0B.A02) > 1000) {
                                            interfaceC2059Yq.AIT();
                                        }
                                    }
                                } else if (j != -1) {
                                    if (O5.A01(this.A0B.A0C - this.A0B.A02) > 1000) {
                                        interfaceC2059Yq.AIT();
                                    }
                                }
                            }
                        } else if (this.A0G || interfaceC2059Yq.A9f()) {
                            interfaceC2059Yq.AIT();
                        }
                    }
                    if (!(interfaceC2059Yq instanceof C12300v)) {
                        if (z4 || !interfaceC2059Yq.AAE()) {
                            z4 = false;
                        } else {
                            z4 = true;
                        }
                    }
                    if (zAAE2 || !interfaceC2059Yq.AAE()) {
                        zAAE2 = false;
                    } else {
                        zAAE2 = true;
                    }
                    if (interfaceC2059Yq.AAT()) {
                        z = true;
                    } else {
                        zAAE = interfaceC2059Yq.AAE();
                        if (A0x[4].length() != 14) {
                            A0x[4] = "iwc4KajbQ";
                            if (!zAAE) {
                                if (A16(interfaceC2059Yq)) {
                                    z = false;
                                }
                            }
                        } else {
                            String[] strArr = A0x;
                            strArr[0] = "PTzv1g5mPAOxtO1iVf8ho";
                            strArr[1] = "DXrETG3TnKWmJVi2JEEybkfkSDtqy8L";
                            if (!zAAE) {
                                if (A16(interfaceC2059Yq)) {
                                    z = false;
                                }
                            }
                        }
                        z = true;
                    }
                    if (!z) {
                        z2 = true;
                        try {
                            interfaceC2059Yq.ABp();
                        } catch (C1833Pl e) {
                            if (!e.getClass().equals(C1833Pl.class)) {
                                throw e;
                            }
                            if (!this.A0M) {
                                throw e;
                            }
                            if (this.A05 == -9223372036854775807L) {
                                Log.w(strA0C2, strA0C + e.getMessage());
                                this.A05 = System.currentTimeMillis();
                                if (this.A0p) {
                                    this.A0Z.obtainMessage(4, e).sendToTarget();
                                }
                            } else if (System.currentTimeMillis() - this.A05 > this.A0Y) {
                                throw e;
                            }
                        }
                        this.A0C = interfaceC2059Yq;
                    }
                    if (z3 || !z) {
                        z3 = false;
                    } else {
                        z3 = true;
                    }
                    i3++;
                } else {
                    String[] strArr2 = A0x;
                    strArr2[0] = "KlDJcpNPSgPX3quLbVIep";
                    strArr2[1] = "FcuqUDVfWhs3HAv7z4nXuJ70uFLTrFE";
                    strA0C2 = A0C(0, 21, 8);
                    if (i3 >= length) {
                        break;
                    }
                    interfaceC2059Yq = interfaceC2059YqArr[i3];
                    interfaceC2059Yq.AHd(this.A06, jElapsedRealtime);
                    if (c1822PaA0G.A00.A05) {
                        if (this.A0N) {
                            if (interfaceC2059Yq.A9f()) {
                                interfaceC2059Yq.AIT();
                            } else if (!this.A0G) {
                                j = this.A0B.A0C;
                                if (A0x[3].charAt(28) != 'h') {
                                    A0x[6] = "qA5tc5bmEYyYjSJQ9v0YcmXktsYBFhat";
                                    if (j != -1) {
                                        if (O5.A01(this.A0B.A0C - this.A0B.A02) > 1000) {
                                            interfaceC2059Yq.AIT();
                                        }
                                    }
                                } else if (j != -1) {
                                    if (O5.A01(this.A0B.A0C - this.A0B.A02) > 1000) {
                                        interfaceC2059Yq.AIT();
                                    }
                                }
                            }
                        } else if (this.A0G) {
                            interfaceC2059Yq.AIT();
                        } else {
                            interfaceC2059Yq.AIT();
                        }
                    }
                    if (!(interfaceC2059Yq instanceof C12300v)) {
                        if (z4) {
                            z4 = false;
                        } else {
                            z4 = false;
                        }
                    }
                    if (zAAE2) {
                        zAAE2 = false;
                    } else {
                        zAAE2 = false;
                    }
                    if (interfaceC2059Yq.AAT()) {
                        zAAE = interfaceC2059Yq.AAE();
                        if (A0x[4].length() != 14) {
                            A0x[4] = "iwc4KajbQ";
                            if (!zAAE) {
                                if (A16(interfaceC2059Yq)) {
                                    z = false;
                                }
                            }
                        } else {
                            String[] strArr3 = A0x;
                            strArr3[0] = "PTzv1g5mPAOxtO1iVf8ho";
                            strArr3[1] = "DXrETG3TnKWmJVi2JEEybkfkSDtqy8L";
                            if (!zAAE) {
                                if (A16(interfaceC2059Yq)) {
                                    z = false;
                                }
                            }
                        }
                        z = true;
                    } else {
                        z = true;
                    }
                    if (!z) {
                        z2 = true;
                        interfaceC2059Yq.ABp();
                        this.A0C = interfaceC2059Yq;
                    }
                    if (z3) {
                        z3 = false;
                    } else {
                        z3 = false;
                    }
                    i3++;
                }
            }
            if (!z3) {
                A0H();
            }
            if (this.A0P && z4 && !zAAE2) {
                for (InterfaceC2059Yq interfaceC2059Yq2 : this.A0V) {
                    if (interfaceC2059Yq2 instanceof C12300v) {
                        interfaceC2059Yq2.AHd(9223372036854775806L, 9223372036854775806L);
                        zAAE2 = interfaceC2059Yq2.AAE();
                    }
                }
            }
            long j2 = c1822PaA0F.A00.A00;
            boolean z5 = false;
            if (zAAE2 && ((j2 == -9223372036854775807L || j2 <= this.A0B.A0C) && c1822PaA0F.A00.A05)) {
                A0U(4);
                A0N();
            } else if (this.A0B.A00 == 2 && A18(z3)) {
                if (this.A0I && !this.A0K) {
                    this.A0K = true;
                    Q3 q3A02 = this.A0A.A02();
                    if (q3A02 != null && (iA00 = q3A02.A00()) > 0) {
                        long j3 = iA00;
                        if (A0x[6].charAt(6) != 'b') {
                            A0x[4] = "CfyKaULBDUEEaSyNMYirKSl5tVOdXD";
                            A0Z(jAJj, j3);
                            return;
                        } else {
                            String[] strArr4 = A0x;
                            strArr4[0] = "5FZQTTevDLPXCHxgwpEwq";
                            strArr4[1] = "afUByMXM5dMSXDIJYw9pSbGM8KEhXqb";
                            A0Z(jAJj, j3);
                            return;
                        }
                    }
                }
                if (this.A0C != null && this.A0C.A9D() == 1) {
                    z5 = true;
                }
                A0a(this.A07, z5);
                if (this.A0O) {
                    A0M();
                }
                this.A0C = null;
            } else {
                Q9 q9 = this.A0B;
                String[] strArr5 = A0x;
                if (strArr5[2].charAt(29) != strArr5[7].charAt(29)) {
                    A0x[5] = "FkSsOnKpySRzUL8d6";
                    if (q9.A00 == 3) {
                        if (this.A0V.length == 0 ? !z3 : !A14()) {
                            this.A0Q = this.A0O;
                            if (this.A0C != null && this.A0C.A9D() == 1) {
                                z5 = true;
                            }
                            A0V(2, z5);
                            if (A0x[6].charAt(6) != 'b') {
                                A0x[6] = "5fV7fVbpNj0r5L9rptEqPdnsVywRIPuN";
                                A0N();
                            } else {
                                String[] strArr6 = A0x;
                                strArr6[2] = "jsFJeWuky7dgs5r2My3velnqDBqnJsPM";
                                strArr6[7] = "8xiW1JAWmv2yYMgwlbL3VIZQBqcCiljc";
                                A0N();
                            }
                        }
                    }
                } else {
                    A0x[6] = "8kXAFjbnnNZbebpl5yZI6SARdOp7bJWI";
                    if (q9.A00 == 3) {
                        if (this.A0V.length == 0) {
                            this.A0Q = this.A0O;
                            if (this.A0C != null) {
                                z5 = true;
                            }
                            A0V(2, z5);
                            if (A0x[6].charAt(6) != 'b') {
                                A0x[6] = "5fV7fVbpNj0r5L9rptEqPdnsVywRIPuN";
                                A0N();
                            } else {
                                String[] strArr7 = A0x;
                                strArr7[2] = "jsFJeWuky7dgs5r2My3velnqDBqnJsPM";
                                strArr7[7] = "8xiW1JAWmv2yYMgwlbL3VIZQBqcCiljc";
                                A0N();
                            }
                        } else {
                            this.A0Q = this.A0O;
                            if (this.A0C != null) {
                                z5 = true;
                            }
                            A0V(2, z5);
                            if (A0x[6].charAt(6) != 'b') {
                                A0x[6] = "5fV7fVbpNj0r5L9rptEqPdnsVywRIPuN";
                                A0N();
                            } else {
                                String[] strArr8 = A0x;
                                strArr8[2] = "jsFJeWuky7dgs5r2My3velnqDBqnJsPM";
                                strArr8[7] = "8xiW1JAWmv2yYMgwlbL3VIZQBqcCiljc";
                                A0N();
                            }
                        }
                    }
                }
            }
            int i4 = this.A0B.A00;
            if (A0x[5].length() != 17) {
                String[] strArr9 = A0x;
                strArr9[0] = "yf3rkIXTDXPeDphAaPAbm";
                strArr9[1] = "SJlJFJDunzCpUBY1TWXcPzMmGkKmYwr";
                if (i4 == 2) {
                    for (InterfaceC2059Yq interfaceC2059Yq3 : this.A0V) {
                        z2 = true;
                        try {
                            interfaceC2059Yq3.ABp();
                        } catch (C1833Pl e2) {
                            if (!e2.getClass().equals(C1833Pl.class)) {
                                throw e2;
                            }
                            if (!this.A0M) {
                                throw e2;
                            }
                            if (this.A05 == -9223372036854775807L) {
                                Log.w(strA0C2, strA0C + e2.getMessage());
                                this.A05 = System.currentTimeMillis();
                                if (this.A0p) {
                                    this.A0Z.obtainMessage(4, e2).sendToTarget();
                                }
                            } else if (System.currentTimeMillis() - this.A05 > this.A0Y) {
                                throw e2;
                            }
                        }
                    }
                }
            } else {
                A0x[5] = "omXPJhZ4e04Itdwqy";
                if (i4 == 2) {
                    while (i2 < r4) {
                        z2 = true;
                        interfaceC2059Yq3.ABp();
                    }
                }
            }
            if (this.A0O) {
                int i5 = this.A0B.A00;
                if (A0x[6].charAt(6) == 'b') {
                    String[] strArr10 = A0x;
                    strArr10[0] = "inoOD3jM3t7GeqK01LmWm";
                    strArr10[1] = "UJ2NUFgiIfOxtHeW5FpUW4V8ft3MVTO";
                    if (i5 == 3) {
                        A0Z(jAJj, this.A0W);
                    } else if (this.A0B.A00 == 2) {
                        A0Z(jAJj, this.A0W);
                    } else if (this.A0V.length != 0) {
                        i = this.A0B.A00;
                        if (A0x[3].charAt(28) != 'h') {
                            throw new RuntimeException();
                        }
                        A0x[6] = "yfPyhpbBm2QxtAH92DRfvP5aDUYCoSIh";
                        if (i != 4) {
                            A0Z(jAJj, 1000L);
                        } else {
                            this.A0m.AHZ(2);
                        }
                    } else {
                        this.A0m.AHZ(2);
                    }
                }
            } else if (this.A0B.A00 == 2) {
                A0Z(jAJj, this.A0W);
            } else if (this.A0V.length != 0) {
                i = this.A0B.A00;
                if (A0x[3].charAt(28) != 'h') {
                    throw new RuntimeException();
                }
                A0x[6] = "yfPyhpbBm2QxtAH92DRfvP5aDUYCoSIh";
                if (i != 4) {
                    A0Z(jAJj, 1000L);
                } else {
                    this.A0m.AHZ(2);
                }
            } else {
                this.A0m.AHZ(2);
            }
            if (!z2) {
                this.A05 = -9223372036854775807L;
            }
            AbstractC2462g5.A00();
            return;
        }
        A0H();
        if (A0x[6].charAt(6) == 'b') {
            String[] strArr11 = A0x;
            strArr11[2] = "08JHwivxCWuuXECgdSLxPSm5EcWpnecV";
            strArr11[7] = "ontfc528z2weiDamt3VP6eXE7WlBDF1D";
            A0Z(jAJj, 10L);
            return;
        }
        throw new RuntimeException();
    }

    /* JADX WARN: Code duplicated, block: B:100:0x01f5 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:101:0x01f7  */
    /* JADX WARN: Code duplicated, block: B:102:0x0224  */
    /* JADX WARN: Code duplicated, block: B:96:0x01d4 A[PHI: r1 r2
  0x01d4: PHI (r1v46 com.facebook.ads.redexgen.X.Ql) = (r1v45 com.facebook.ads.redexgen.X.Ql), (r1v60 com.facebook.ads.redexgen.X.Ql) binds: [B:106:0x0234, B:95:0x01d2] A[DONT_GENERATE, DONT_INLINE]
  0x01d4: PHI (r2v18 com.facebook.ads.redexgen.X.Ql) = (r2v17 com.facebook.ads.redexgen.X.Ql), (r2v28 com.facebook.ads.redexgen.X.Ql) binds: [B:106:0x0234, B:95:0x01d2] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:98:0x01e7  */
    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    private void A0O() throws EK, IOException {
        C1857Ql c1857Ql;
        C1857Ql c1857Ql2;
        boolean zEquals;
        if (this.A0E == null) {
            return;
        }
        int i = this.A02;
        String[] strArr = A0x;
        if (strArr[0].length() != strArr[1].length()) {
            A0x[4] = "X6Hi0URVqRt9qecqtGNkOnZt9";
            if (i > 0) {
                this.A0E.ABo();
                return;
            }
            A0I();
            C1822Pa c1822PaA0E = this.A0e.A0E();
            if (c1822PaA0E == null || c1822PaA0E.A0R()) {
                A0x(false);
            } else if (!this.A0B.A0A) {
                A0v(false);
            }
            if (!this.A0e.A0N()) {
                return;
            }
            C1822Pa c1822PaA0F = this.A0e.A0F();
            C1827Pf c1827Pf = this.A0e;
            if (A0x[6].charAt(6) == 'b') {
                A0x[3] = "mLrJPfI9Kat8tNCleHEojKJq7cjahUbT";
                C1822Pa c1822PaA0G = c1827Pf.A0G();
                boolean z = false;
                while (this.A0O && c1822PaA0F != c1822PaA0G && this.A06 >= c1822PaA0F.A0I().A0H(this.A0J)) {
                    if (z) {
                        A0G();
                    }
                    int i2 = c1822PaA0F.A00.A07 ? 0 : 3;
                    C1822Pa c1822Pa = c1822PaA0F;
                    c1822PaA0F = this.A0e.A0B();
                    A0f(c1822Pa);
                    this.A0B = this.A0B.A06(c1822PaA0F.A00.A04, c1822PaA0F.A00.A03, c1822PaA0F.A00.A02, A01());
                    this.A0c.A04(i2);
                    A0P();
                    z = true;
                }
                boolean z2 = c1822PaA0G.A00.A05;
                if (A0x[5].length() != 17) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A0x;
                strArr2[0] = "gaDpyTTHLThqnHWJTVtUe";
                strArr2[1] = "51BvZWxysTU3FDUYqxba6TmJIFhjB4S";
                if (z2) {
                    for (int i3 = 0; i3 < this.A0u.length; i3++) {
                        InterfaceC2059Yq interfaceC2059Yq = this.A0u[i3];
                        InterfaceC2180bV interfaceC2180bV = c1822PaA0G.A09[i3];
                        if (interfaceC2180bV != null && interfaceC2059Yq.A93() == interfaceC2180bV) {
                            boolean zA9f = interfaceC2059Yq.A9f();
                            String[] strArr3 = A0x;
                            if (strArr3[0].length() == strArr3[1].length()) {
                                throw new RuntimeException();
                            }
                            A0x[6] = "NIxY9tbDJJKyIkaakH6FCGngwv8mjtH0";
                            if (zA9f) {
                                interfaceC2059Yq.AIT();
                            }
                        }
                    }
                    return;
                }
                if (c1822PaA0G.A0I() == null || !c1822PaA0G.A0I().A02) {
                    return;
                }
                for (int i4 = 0; i4 < this.A0u.length; i4++) {
                    InterfaceC2059Yq interfaceC2059Yq2 = this.A0u[i4];
                    InterfaceC2180bV interfaceC2180bV2 = c1822PaA0G.A09[i4];
                    if (interfaceC2059Yq2.A93() != interfaceC2180bV2) {
                        return;
                    }
                    if (interfaceC2180bV2 != null && !interfaceC2059Yq2.A9f()) {
                        return;
                    }
                }
                C2290dH c2290dHA0K = c1822PaA0G.A0K();
                C1822Pa c1822PaA0C = this.A0e.A0C();
                C2290dH c2290dHA0K2 = c1822PaA0C.A0K();
                boolean z3 = c1822PaA0C.A07.AGY() != -9223372036854775807L;
                for (int i5 = 0; i5 < this.A0u.length; i5++) {
                    InterfaceC2059Yq interfaceC2059Yq3 = this.A0u[i5];
                    if (c2290dHA0K.A00(i5)) {
                        if (z3) {
                            interfaceC2059Yq3.AIT();
                        } else if (!interfaceC2059Yq3.AAC()) {
                            QD qd = c2290dHA0K2.A04[i5];
                            boolean zA00 = c2290dHA0K2.A00(i5);
                            boolean z4 = this.A0v[i5].A9D() == -2;
                            C1857Ql[] c1857QlArr = c2290dHA0K.A03;
                            String[] strArr4 = A0x;
                            if (strArr4[0].length() != strArr4[1].length()) {
                                A0x[4] = "8VxvtMOSHcaN";
                                c1857Ql = c1857QlArr[i5];
                                c1857Ql2 = c2290dHA0K2.A03[i5];
                                if (zA00) {
                                    zEquals = c1857Ql2.equals(c1857Ql);
                                    if (A0x[3].charAt(28) != 'h') {
                                        String[] strArr5 = A0x;
                                        strArr5[0] = "a1phYEZvOSNX56JR2QOEL";
                                        strArr5[1] = "Gb2w3Dh3pB36ok4QAfXUO6zSVBkHXA4";
                                        if (zEquals) {
                                            if (!z4) {
                                                ZM[] zmArrA19 = A19(qd);
                                                Log.e(A0C(0, 21, 8), A0C(392, 13, 87));
                                                interfaceC2059Yq3.AHg(zmArrA19, c1822PaA0C.A09[i5], c1822PaA0C.A0H(this.A0J), c1822PaA0C.A0B());
                                            }
                                        }
                                    } else {
                                        A0x[6] = "cYLXTpbp9L44JxkLwiaX0284An1XewZA";
                                        if (zEquals) {
                                            if (!z4) {
                                                ZM[] zmArrA110 = A19(qd);
                                                Log.e(A0C(0, 21, 8), A0C(392, 13, 87));
                                                interfaceC2059Yq3.AHg(zmArrA110, c1822PaA0C.A09[i5], c1822PaA0C.A0H(this.A0J), c1822PaA0C.A0B());
                                            }
                                        }
                                    }
                                }
                            } else {
                                c1857Ql = c1857QlArr[i5];
                                c1857Ql2 = c2290dHA0K2.A03[i5];
                                if (zA00) {
                                    zEquals = c1857Ql2.equals(c1857Ql);
                                    if (A0x[3].charAt(28) != 'h') {
                                        String[] strArr6 = A0x;
                                        strArr6[0] = "a1phYEZvOSNX56JR2QOEL";
                                        strArr6[1] = "Gb2w3Dh3pB36ok4QAfXUO6zSVBkHXA4";
                                        if (zEquals) {
                                            if (!z4) {
                                                ZM[] zmArrA111 = A19(qd);
                                                Log.e(A0C(0, 21, 8), A0C(392, 13, 87));
                                                interfaceC2059Yq3.AHg(zmArrA111, c1822PaA0C.A09[i5], c1822PaA0C.A0H(this.A0J), c1822PaA0C.A0B());
                                            }
                                        }
                                    } else {
                                        A0x[6] = "cYLXTpbp9L44JxkLwiaX0284An1XewZA";
                                        if (zEquals) {
                                            if (!z4) {
                                                ZM[] zmArrA112 = A19(qd);
                                                Log.e(A0C(0, 21, 8), A0C(392, 13, 87));
                                                interfaceC2059Yq3.AHg(zmArrA112, c1822PaA0C.A09[i5], c1822PaA0C.A0H(this.A0J), c1822PaA0C.A0B());
                                            }
                                        }
                                    }
                                }
                            }
                            interfaceC2059Yq3.AIT();
                        }
                    }
                }
                return;
            }
        }
        throw new RuntimeException();
    }

    public static void A0Q() {
        A0w = new byte[]{7, 58, 45, Ascii.DC2, 46, 35, 59, 39, 48, Ascii.VT, 47, 50, 46, Ascii.VT, 44, 54, 39, 48, 44, 35, 46, Base64.padSymbol, 0, Ascii.ETB, 40, Ascii.DC4, Ascii.EM, 1, Ascii.GS, 10, 49, Ascii.NAK, 8, Ascii.DC4, 49, Ascii.SYN, Ascii.FF, Ascii.GS, 10, Ascii.SYN, Ascii.EM, Ascii.DC4, 66, 48, Ascii.EM, Ascii.SYN, Ascii.FS, Ascii.DC4, Ascii.GS, 10, Ascii.FS, 50, 59, 58, 39, 60, 59, 50, 117, 56, 48, 38, 38, 52, 50, 48, 38, 117, 38, 48, 59, 33, 117, 52, 51, 33, 48, 39, 117, 39, 48, 57, 48, 52, 38, 48, 123, 36, 3, Ascii.EM, 8, Ascii.US, 3, Ascii.FF, 1, 77, Ascii.US, Ascii.CAN, 3, Ascii.EM, 4, 0, 8, 77, 8, Ascii.US, Ascii.US, 2, Ascii.US, 67, 79, 115, 126, 102, 125, 126, 124, 116, 63, 122, 109, 109, 112, 109, 49, 80, 108, 97, 121, 98, 97, 99, 107, 80, 111, 115, 105, 116, 105, 111, 110, 77, 115, 58, 32, 37, 100, 44, 32, 98, 117, 102, 102, 101, 114, 101, 100, 68, 117, 114, 97, 116, 105, 111, 110, 77, 115, 58, 32, 37, 100, 44, 32, 110, 101, 120, 116, 76, 111, 97, 100, 80, 111, 115, 105, 116, 105, 111, 110, 77, 115, 58, 32, 37, 100, 115, 79, 85, 82, 67, 69, 0, 69, 82, 82, 79, 82, Ascii.SO, Ascii.DC2, 53, 46, 49, 97, 39, 32, 40, 45, 36, 37, 111, Ascii.GS, 8, Ascii.SO, 84, 101, 109, 112, 111, 114, 97, 114, 105, 108, 121, 32, 105, 103, 110, 111, 114, 105, 110, 103, 32, 115, 116, 114, 101, 97, 109, 32, 101, 114, 114, 111, 114, 58, 32, 92, 122, 113, 97, 102, 111, 40, 124, 103, 40, 123, 109, 102, 108, 40, 101, 109, 123, 123, 105, 111, 109, 40, 103, 102, 40, 105, 40, 108, 109, 105, 108, 40, 124, 96, 122, 109, 105, 108, 38, 5, 62, 53, 40, 32, 53, 51, 36, 53, 52, 112, 53, 34, 34, 63, 34, 112, 52, 53, 60, 57, 38, 53, 34, 57, 62, 55, 112, Base64.padSymbol, 53, 35, 35, 49, 55, 53, 112, 63, 62, 112, 53, 40, 36, 53, 34, 62, 49, 60, 112, 36, 56, 34, 53, 49, 52, 126, 120, 115, 79, 115, 113, 121, 75, 115, 110, 119, 59, 51, 50, 63, 55, 6, 51, 36, 63, 57, 50, Ascii.US, 50, 17, 4, 19, 8, Ascii.SO, 5, 49, Ascii.SO, Ascii.DC2, 8, Ascii.NAK, 8, Ascii.SO, Ascii.SI, 52, Ascii.DC2, 111, 120, 109, 113, 124, 126, 120, 78, 105, 111, 120, 124, 112};
    }

    /* JADX WARN: Code duplicated, block: B:91:0x017b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:93:0x014d A[SYNTHETIC] */
    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    private void A0d(C1806Oi c1806Oi) throws EK {
        if (c1806Oi.A01 != this.A0E) {
            return;
        }
        Timeline timeline = this.A0B.A04;
        Timeline timeline2 = c1806Oi.A00;
        this.A0B = this.A0B.A04(timeline2);
        A0L();
        if (this.A02 > 0) {
            this.A0c.A03(this.A02);
            this.A02 = 0;
            if (this.A09 != null) {
                Pair<Object, Long> pairA08 = A08(this.A09, true);
                this.A09 = null;
                if (pairA08 == null) {
                    A0F();
                    return;
                }
                Object obj = pairA08.first;
                long jLongValue = ((Long) pairA08.second).longValue();
                R5 r5A0K = this.A0e.A0K(timeline2, obj, jLongValue);
                this.A0B = this.A0B.A06(r5A0K, r5A0K.A00() ? 0L : jLongValue, jLongValue, this.A0B.A0D);
                return;
            }
            if (0 != 0) {
                throw new NullPointerException(A0C(376, 16, 43));
            }
            if (this.A0B.A02 == -9223372036854775807L) {
                if (timeline2.A0N()) {
                    A0F();
                    return;
                }
                Pair<Object, Long> pairA09 = A09(timeline2, timeline2.A0B(this.A0U), -9223372036854775807L);
                Object obj2 = pairA09.first;
                long jLongValue2 = ((Long) pairA09.second).longValue();
                R5 r5A0K2 = this.A0e.A0K(timeline2, obj2, jLongValue2);
                this.A0B = this.A0B.A06(r5A0K2, r5A0K2.A00() ? 0L : jLongValue2, jLongValue2, this.A0B.A0D);
                return;
            }
            return;
        }
        Object obj3 = this.A0B.A06.A04;
        long j = this.A0B.A01;
        if (timeline.A0N()) {
            if (timeline2.A0N()) {
                return;
            }
            R5 r5A0K3 = this.A0e.A0K(timeline2, obj3, j);
            this.A0B = this.A0B.A06(r5A0K3, r5A0K3.A00() ? 0L : j, j, this.A0B.A0D);
            return;
        }
        C1822Pa c1822PaA0D = this.A0e.A0D();
        Object obj4 = c1822PaA0D == null ? this.A0B.A06.A04 : c1822PaA0D.A08;
        String[] strArr = A0x;
        if (strArr[2].charAt(29) == strArr[7].charAt(29)) {
            throw new RuntimeException();
        }
        A0x[3] = "pob9zYdIANNiSNd8gfvG94ZMcYyVhI41";
        int iA0A = timeline2.A0A(obj4);
        if (iA0A != -1) {
            R5 r5 = this.A0B.A06;
            if (r5.A00()) {
                R5 r5A0K4 = this.A0e.A0K(timeline2, Integer.valueOf(iA0A), j);
                if (!r5A0K4.equals(r5)) {
                    this.A0B = this.A0B.A06(r5A0K4, A06(r5A0K4, r5A0K4.A00() ? 0L : j), j, A01());
                    return;
                }
            }
            if (!this.A0e.A0R(timeline2, r5, this.A06)) {
                A0w(false);
            }
            A0u(false);
            return;
        }
        Object objA0B = A0B(obj4, timeline, timeline2);
        if (objA0B == null) {
            A0F();
            return;
        }
        Pair<Object, Long> pairA010 = A09(timeline2, timeline2.A0J(objA0B, this.A0g).A00, -9223372036854775807L);
        Object obj5 = pairA010.first;
        long jLongValue3 = ((Long) pairA010.second).longValue();
        R5 r5A0K5 = this.A0e.A0K(timeline2, obj5, jLongValue3);
        if (c1822PaA0D != null) {
            while (true) {
                C1822Pa c1822PaA0I = c1822PaA0D.A0I();
                if (A0x[6].charAt(6) != 'b') {
                    String[] strArr2 = A0x;
                    strArr2[0] = "Y6PV8AcgszdcplKWeDC1m";
                    strArr2[1] = "4cPd246p95BXRlJjydErhDtkvSOj7As";
                    if (c1822PaA0I == null) {
                        break;
                    }
                    c1822PaA0D = c1822PaA0D.A0I();
                    if (c1822PaA0D.A00.A04.equals(r5A0K5)) {
                        c1822PaA0D.A00 = this.A0e.A0I(timeline2, c1822PaA0D.A00);
                    }
                } else {
                    A0x[5] = "qKCb0oRAl0dMsUjCC";
                    if (c1822PaA0I == null) {
                        break;
                    }
                    c1822PaA0D = c1822PaA0D.A0I();
                    if (c1822PaA0D.A00.A04.equals(r5A0K5)) {
                        c1822PaA0D.A00 = this.A0e.A0I(timeline2, c1822PaA0D.A00);
                    }
                }
            }
        }
        this.A0B = this.A0B.A06(r5A0K5, A06(r5A0K5, r5A0K5.A00() ? 0L : jLongValue3), jLongValue3, A01());
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    private void A0e(C1809Ol c1809Ol) throws Throwable {
        long jLongValue;
        R5 r5A0K;
        long jLongValue2;
        boolean z;
        this.A0c.A03(1);
        Pair<Object, Long> pairA08 = A08(c1809Ol, true);
        if (pairA08 == null) {
            r5A0K = A0A();
            jLongValue2 = -9223372036854775807L;
            jLongValue = -9223372036854775807L;
            z = true;
        } else {
            Object obj = pairA08.first;
            jLongValue = ((Long) pairA08.second).longValue();
            r5A0K = this.A0e.A0K(this.A0B.A04, obj, jLongValue);
            if (r5A0K.A00()) {
                jLongValue2 = 0;
                z = true;
            } else {
                jLongValue2 = ((Long) pairA08.second).longValue();
                z = c1809Ol.A01 == -9223372036854775807L;
            }
        }
        try {
            try {
                if (this.A0E == null || this.A02 > 0) {
                    this.A09 = c1809Ol;
                    this.A08 = null;
                } else {
                    try {
                        if (jLongValue2 != -9223372036854775807L) {
                            long jA6h = jLongValue2;
                            if (r5A0K.equals(this.A0B.A06)) {
                                C1822Pa c1822PaA0F = this.A0e.A0F();
                                if (c1822PaA0F != null && jA6h != 0) {
                                    jA6h = c1822PaA0F.A07.A6h(jA6h, this.A0D);
                                }
                                if (O5.A01(jA6h) == O5.A01(this.A0B.A0C)) {
                                    this.A0B = this.A0B.A06(r5A0K, this.A0B.A0C, jLongValue, A01());
                                    if (z) {
                                        this.A0c.A04(2);
                                        return;
                                    }
                                    return;
                                }
                            }
                            long jA06 = A06(r5A0K, jA6h);
                            String[] strArr = A0x;
                            if (strArr[2].charAt(29) != strArr[7].charAt(29)) {
                                A0x[5] = "9MolVziE7AMl4tyo0";
                                z |= jLongValue2 != jA06;
                                if (A0x[6].charAt(6) != 'b') {
                                    throw new RuntimeException();
                                }
                                A0x[3] = "sTwa87yAQU1k0tK3nFOiI0I8k7WphADR";
                                jLongValue2 = jA06;
                            }
                            throw new RuntimeException();
                        }
                        A0U(4);
                        A12(false, true, false);
                    } catch (Throwable th) {
                        th = th;
                        this.A0B = this.A0B.A06(r5A0K, jLongValue2, jLongValue, A01());
                        if (z) {
                            C1808Ok c1808Ok = this.A0c;
                            String[] strArr2 = A0x;
                            if (strArr2[0].length() != strArr2[1].length()) {
                                A0x[5] = "RygvwfhImY7bD2oRl";
                                c1808Ok.A04(2);
                            }
                        }
                        throw th;
                    }
                }
                this.A0B = this.A0B.A06(r5A0K, jLongValue2, jLongValue, A01());
                if (z) {
                    this.A0c.A04(2);
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    static {
        A0Q();
    }

    public E8(InterfaceC2059Yq[] interfaceC2059YqArr, AbstractC2289dG abstractC2289dG, C2290dH c2290dH, PC pc, InterfaceC2301dS interfaceC2301dS, boolean z, int i, boolean z2, Handler handler, InterfaceC2395ez interfaceC2395ez, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, long j, boolean z9, int i2, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, RK rk) {
        this.A0u = interfaceC2059YqArr;
        this.A0i = abstractC2289dG;
        this.A0j = c2290dH;
        this.A0d = pc;
        this.A0k = interfaceC2301dS;
        this.A0O = z;
        this.A03 = i;
        this.A0U = z2;
        this.A0Z = handler;
        this.A0l = interfaceC2395ez;
        this.A0T = z3;
        this.A0G = z4;
        this.A0F = z5;
        this.A0L = z6;
        this.A0H = z7;
        this.A0S = z8;
        this.A0Y = j;
        this.A0p = z9;
        this.A00 = i2;
        this.A0t = z11;
        this.A0r = z10;
        this.A0N = z12;
        this.A0P = z13;
        this.A0J = z14;
        this.A0s = z15;
        this.A0M = j > 0;
        this.A0X = pc.A6q();
        this.A0q = pc.AHt();
        this.A0D = C1859Qn.A04;
        this.A0B = new Q9(Timeline.A02, -9223372036854775807L, C1863Qs.A06, c2290dH);
        this.A0c = new C1808Ok();
        this.A0v = new InterfaceC1854Qi[interfaceC2059YqArr.length];
        for (int i3 = 0; i3 < interfaceC2059YqArr.length; i3++) {
            interfaceC2059YqArr[i3].A9z(i3, rk);
            this.A0v[i3] = interfaceC2059YqArr[i3].A73();
        }
        this.A0b = new C2074Zf(this, interfaceC2395ez);
        this.A0f = new C2055Ym(interfaceC2395ez);
        this.A0n = z11 ? new C13144c(interfaceC2395ez) : null;
        this.A0o = new ArrayList<>();
        this.A0V = new InterfaceC2059Yq[0];
        this.A0h = new C2048Yf();
        this.A0g = new C2050Yh();
        abstractC2289dG.A02(this, interfaceC2301dS);
        this.A0a = new HandlerThread(A0C(21, 29, 50), -16);
        this.A0a.start();
        this.A0m = interfaceC2395ez.A5F(this.A0a.getLooper(), this);
    }

    @MetaExoPlayerCustomization
    private int A00() {
        int exoplayerThreadPollingIntervalMs = MetaExoPlayerUpgradeConfig.A00(EnumC1765Mo.A04);
        if (exoplayerThreadPollingIntervalMs > 0) {
            return exoplayerThreadPollingIntervalMs;
        }
        return 10;
    }

    private long A01() {
        return A04(this.A0B.A0B);
    }

    private final long A02() {
        long loadingPeriodStartPositionUs;
        C1822Pa c1822PaA0E = this.A0e.A0E();
        if (c1822PaA0E == null) {
            loadingPeriodStartPositionUs = 0;
        } else {
            loadingPeriodStartPositionUs = A05(c1822PaA0E);
        }
        if (c1822PaA0E == null || loadingPeriodStartPositionUs == -9223372036854775807L) {
            return 0L;
        }
        return c1822PaA0E.A0C(loadingPeriodStartPositionUs);
    }

    private final long A03() {
        C1822Pa c1822PaA0F = this.A0e.A0F();
        return (c1822PaA0F == null ? 0L : c1822PaA0F.A0C(c1822PaA0F.A0D(this.A06))) + A02();
    }

    private long A04(long j) {
        C1822Pa c1822PaA0E = this.A0e.A0E();
        if (c1822PaA0E == null) {
            return 0L;
        }
        return j - c1822PaA0E.A0D(this.A06);
    }

    private final long A05(C1822Pa c1822Pa) {
        long jMin = Long.MAX_VALUE;
        InterfaceC2180bV[] interfaceC2180bVArr = c1822Pa.A09;
        for (int i = 0; i < interfaceC2180bVArr.length; i++) {
            if (interfaceC2180bVArr[i] instanceof InterfaceC2181bW) {
                long periodStartPositionUs = ((InterfaceC2181bW) interfaceC2180bVArr[i]).A7z();
                jMin = Math.min(jMin, periodStartPositionUs);
            }
        }
        if (jMin == Long.MAX_VALUE) {
            return -9223372036854775807L;
        }
        return jMin;
    }

    private long A06(R5 r5, long j) throws EK {
        return A07(false, r5, j, this.A0e.A0F() != this.A0e.A0G());
    }

    private long A07(boolean z, R5 r5, long j, boolean z2) throws EK {
        A0N();
        this.A0Q = false;
        A0U(2);
        C1822Pa c1822PaA0F = this.A0e.A0F();
        C1822Pa c1822PaA0B = c1822PaA0F;
        while (c1822PaA0B != null) {
            if (A17(r5, j, c1822PaA0B)) {
                this.A0e.A0P(c1822PaA0B);
                break;
            }
            c1822PaA0B = this.A0e.A0B();
        }
        if (c1822PaA0F != c1822PaA0B || z2) {
            for (InterfaceC2059Yq interfaceC2059Yq : this.A0V) {
                A0l(interfaceC2059Yq);
            }
            this.A0V = new InterfaceC2059Yq[0];
            c1822PaA0F = null;
        }
        if (c1822PaA0B != null) {
            A0f(c1822PaA0F);
            if (c1822PaA0B.A01) {
                j = c1822PaA0B.A07.AIE(j, z);
                c1822PaA0B.A07.A5q(j - this.A0X, this.A0q);
            }
            A0X(j);
            A0v(this.A0F);
        } else {
            C1827Pf c1827Pf = this.A0e;
            String[] strArr = A0x;
            if (strArr[0].length() == strArr[1].length()) {
                throw new RuntimeException();
            }
            A0x[3] = "OhY7i9Wcx9AoKgvI7foVAuQZlGQuhmAa";
            c1827Pf.A0M(true);
            A0X(j);
        }
        A0u(false);
        this.A0m.AIG(2);
        return j;
    }

    private Pair<Object, Long> A08(C1809Ol c1809Ol, boolean z) {
        int iA0A;
        Timeline timeline = this.A0B.A04;
        Timeline timeline2 = c1809Ol.A02;
        if (timeline.A0N()) {
            return null;
        }
        if (timeline2.A0N()) {
            timeline2 = timeline;
        }
        try {
            Pair<Object, Long> periodPosition = timeline2.A0E(this.A0h, this.A0g, c1809Ol.A00, c1809Ol.A01);
            if (timeline == timeline2 || (iA0A = timeline.A0A(periodPosition.first)) != -1) {
                return periodPosition;
            }
            if (!z || A0B(periodPosition.first, timeline2, timeline) == null) {
                return null;
            }
            return A09(timeline, timeline.A0H(iA0A, this.A0g).A00, -9223372036854775807L);
        } catch (IndexOutOfBoundsException unused) {
            throw new P8(timeline, c1809Ol.A00, c1809Ol.A01);
        }
    }

    private Pair<Object, Long> A09(Timeline timeline, int i, long j) {
        return timeline.A0D(this.A0h, this.A0g, i, j);
    }

    private R5 A0A() {
        Timeline timeline = this.A0B.A04;
        if (timeline.A0N()) {
            return Q9.A0E;
        }
        return new R5(timeline.A0M(timeline.A0K(timeline.A0B(this.A0U), this.A0h).A00));
    }

    private Object A0B(Object obj, Timeline timeline, Timeline timeline2) {
        int iA0A = timeline.A0A(obj);
        int i = -1;
        int maxIterations = timeline.A06();
        for (int newPeriodIndex = 0; newPeriodIndex < maxIterations && i == -1 && (iA0A = timeline.A09(iA0A, this.A0g, this.A0h, this.A03, this.A0U)) != -1; newPeriodIndex++) {
            i = timeline2.A0A(timeline.A0M(iA0A));
        }
        if (i == -1) {
            return null;
        }
        return timeline2.A0M(i);
    }

    private void A0D() {
        C1822Pa c1822PaA0E = this.A0e.A0E();
        if (c1822PaA0E == null) {
            return;
        }
        c1822PaA0E.A07.A4i(c1822PaA0E.A0D(this.A06));
    }

    private void A0F() {
        A0U(4);
        A12(false, true, false);
    }

    private void A0G() {
        int i;
        if (this.A0c.A06(this.A0B)) {
            Handler handler = this.A0Z;
            int i2 = this.A0c.A01;
            if (!this.A0c.A03) {
                i = -1;
            } else {
                i = this.A0c.A00;
            }
            handler.obtainMessage(0, i2, i, this.A0B).sendToTarget();
            this.A0c.A05(this.A0B);
        }
    }

    private void A0H() throws IOException {
        C1822Pa c1822PaA0E = this.A0e.A0E();
        C1822Pa readingPeriodHolder = this.A0e.A0G();
        if (c1822PaA0E != null && !c1822PaA0E.A02) {
            if (readingPeriodHolder != null) {
                C1822Pa loadingPeriodHolder = readingPeriodHolder.A0I();
                if (loadingPeriodHolder != c1822PaA0E) {
                    return;
                }
            }
            for (InterfaceC2059Yq interfaceC2059Yq : this.A0V) {
                if (!interfaceC2059Yq.A9f()) {
                    return;
                }
            }
            c1822PaA0E.A07.ABn();
        }
    }

    private void A0I() throws IOException {
        this.A0e.A0L(this.A06);
        if (this.A0e.A0O()) {
            C1824Pc c1824PcA0H = this.A0e.A0H(this.A06, this.A0B);
            if (c1824PcA0H == null) {
                this.A0E.ABo();
                return;
            }
            this.A0e.A0J(this.A0v, this.A0s ? 60000000L : 0L, this.A0i, this.A0d.A6l(), this.A0E, c1824PcA0H, this.A0j).AGD(this, c1824PcA0H.A03);
            A0x(true);
            A0u(false);
        }
    }

    private void A0J() {
        A12(true, true, true);
        this.A0d.AEm();
        A0U(1);
        this.A0a.quit();
        synchronized (this) {
            this.A0R = true;
            notifyAll();
        }
    }

    /* JADX WARN: Code duplicated, block: B:42:0x010b  */
    private void A0K() throws EK {
        boolean z;
        if (!this.A0e.A0N()) {
            return;
        }
        C2074Zf c2074Zf = this.A0b;
        String[] strArr = A0x;
        if (strArr[2].charAt(29) == strArr[7].charAt(29)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0x;
        strArr2[0] = "1HMk1dV51tKZkGOAyQUQb";
        strArr2[1] = "Sx4gTI9hvNrNa8NBIzGQgczMy7mp6p9";
        float f = c2074Zf.A8c().A01;
        C1822Pa readingPeriodHolder = this.A0e.A0G();
        boolean z2 = true;
        for (C1822Pa c1822PaA0F = this.A0e.A0F(); c1822PaA0F != null; c1822PaA0F = c1822PaA0F.A0I()) {
            boolean z3 = c1822PaA0F.A02;
            String[] strArr3 = A0x;
            if (strArr3[0].length() == strArr3[1].length()) {
                throw new RuntimeException();
            }
            String[] strArr4 = A0x;
            strArr4[2] = "9soGDb9GgluXN8p8cdubLngyaHHWGwzM";
            strArr4[7] = "A7x7j3DP8OfQfdMNxQLenqP9vNKic9q7";
            if (!z3) {
                return;
            }
            C2290dH c2290dHA0L = c1822PaA0F.A0L(f, this.A0B.A04);
            if (c2290dHA0L != null) {
                if (z2) {
                    C1822Pa c1822PaA0F2 = this.A0e.A0F();
                    boolean zA0P = this.A0e.A0P(c1822PaA0F2);
                    boolean[] zArr = new boolean[this.A0u.length];
                    long jA0G = c1822PaA0F2.A0G(c2290dHA0L, this.A0B.A0C, zA0P, zArr);
                    if (this.A0B.A00 != 4 && jA0G != this.A0B.A0C) {
                        this.A0B = this.A0B.A06(this.A0B.A06, jA0G, this.A0B.A01, A01());
                        this.A0c.A04(4);
                        A0X(jA0G);
                    }
                    int i = 0;
                    boolean[] zArr2 = new boolean[this.A0u.length];
                    for (int i2 = 0; i2 < this.A0u.length; i2++) {
                        InterfaceC2059Yq interfaceC2059Yq = this.A0u[i2];
                        zArr2[i2] = interfaceC2059Yq.A90() != 0;
                        InterfaceC2180bV interfaceC2180bV = c1822PaA0F2.A09[i2];
                        if (interfaceC2180bV != null) {
                            i++;
                        }
                        if (zArr2[i2]) {
                            if (interfaceC2180bV != interfaceC2059Yq.A93()) {
                                A0l(interfaceC2059Yq);
                            } else {
                                boolean z4 = zArr[i2];
                                String[] strArr5 = A0x;
                                if (strArr5[2].charAt(29) != strArr5[7].charAt(29)) {
                                    A0x[6] = "ExGDDGbfemICDt7I0guZ3T32kAjRpQNI";
                                    if (z4) {
                                        interfaceC2059Yq.AHs(this.A06);
                                    }
                                } else {
                                    A0x[6] = "2Ptzbtb5GwdiMq6Rg96jTXMfpGBsmS4j";
                                    if (z4) {
                                        interfaceC2059Yq.AHs(this.A06);
                                    }
                                }
                            }
                        }
                    }
                    this.A0B = this.A0B.A07(c1822PaA0F2.A0J(), c1822PaA0F2.A0K());
                    A13(zArr2, i);
                    z = false;
                } else {
                    this.A0e.A0P(c1822PaA0F);
                    if (c1822PaA0F.A02) {
                        z = false;
                        c1822PaA0F.A0F(c2290dHA0L, Math.max(c1822PaA0F.A00.A03, c1822PaA0F.A0D(this.A06)), false);
                    } else {
                        z = false;
                    }
                }
                A0u(true);
                if (this.A0B.A00 != 4) {
                    A0v(z);
                    A0P();
                    this.A0m.AIG(2);
                    return;
                }
                return;
            }
            if (c1822PaA0F == readingPeriodHolder) {
                z2 = false;
            }
        }
    }

    private void A0L() {
        for (int size = this.A0o.size() - 1; size >= 0; size--) {
            if (!A15(this.A0o.get(size))) {
                this.A0o.get(size).A03.A0A(false);
                this.A0o.remove(size);
            }
        }
        Collections.sort(this.A0o);
    }

    private void A0M() throws EK {
        this.A0Q = false;
        this.A0b.A05();
        this.A0f.A00();
        if (this.A0t) {
            this.A0n.A00();
        }
        for (InterfaceC2059Yq interfaceC2059Yq : this.A0V) {
            interfaceC2059Yq.start();
        }
    }

    private void A0N() throws EK {
        this.A0b.A06();
        this.A0f.A01();
        if (this.A0t) {
            this.A0n.A01();
        }
        for (InterfaceC2059Yq interfaceC2059Yq : this.A0V) {
            A0m(interfaceC2059Yq);
        }
    }

    private void A0P() throws EK {
        if (!this.A0e.A0N()) {
            return;
        }
        C1822Pa c1822PaA0F = this.A0e.A0F();
        long jAGY = c1822PaA0F.A07.AGY();
        if (jAGY != -9223372036854775807L) {
            A0X(jAGY);
            if (jAGY != this.A0B.A0C) {
                this.A0B = this.A0B.A06(this.A0B.A06, jAGY, this.A0B.A01, A01());
                this.A0c.A04(4);
            }
        } else {
            C2074Zf c2074Zf = this.A0b;
            C1822Pa playingPeriodHolder = this.A0e.A0G();
            long jA04 = c2074Zf.A04(c1822PaA0F != playingPeriodHolder);
            if (A0x[4].length() == 14) {
                throw new RuntimeException();
            }
            String[] strArr = A0x;
            strArr[0] = "FmdEkHxnKg1RaLHfWvGqo";
            strArr[1] = "v5poHSGYgVp6KRWTZ4prlSd2j0l4imd";
            this.A06 = jA04;
            long jA0D = c1822PaA0F.A0D(this.A06);
            A0Y(this.A0B.A0C, jA0D);
            this.A0B.A0C = jA0D;
        }
        C1822Pa playingPeriodHolder2 = this.A0e.A0E();
        this.A0B.A0B = playingPeriodHolder2.A09();
        this.A0B.A0D = A01();
        this.A0B.A0D = c1822PaA0F.A0C(this.A0B.A0C);
    }

    private void A0R(byte b) {
        C1822Pa c1822PaA0E = this.A0e.A0E();
        if (c1822PaA0E == null) {
            return;
        }
        boolean z = this.A0T;
        String[] strArr = A0x;
        if (strArr[2].charAt(29) == strArr[7].charAt(29)) {
            throw new RuntimeException();
        }
        A0x[6] = "SYGDhYbotQVVmHvMkNUg0YgZHLo8Cpdm";
        if (z) {
            c1822PaA0E.A07.AJg(b);
        }
    }

    private void A0S(float f) {
        for (C1822Pa c1822PaA0D = this.A0e.A0D(); c1822PaA0D != null && c1822PaA0D.A02; c1822PaA0D = c1822PaA0D.A0I()) {
            for (QD qd : c1822PaA0D.A0K().A04) {
                if (qd != null) {
                    qd.AEW(f);
                }
            }
        }
    }

    private void A0T(int i) throws EK {
        this.A03 = i;
        if (!this.A0e.A0Q(this.A0B.A04, i)) {
            A0w(true);
        }
        A0u(false);
    }

    private void A0U(int i) {
        if (this.A0B.A00 != i) {
            this.A0B = this.A0B.A01(i);
            if (i == 2) {
                this.A04 = System.currentTimeMillis();
            } else {
                this.A04 = -1L;
            }
        }
    }

    private void A0V(int i, boolean z) {
        if (this.A0B.A00 != i) {
            this.A0B = this.A0B.A03(i, z);
            if (i == 2) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (A0x[5].length() != 17) {
                    throw new RuntimeException();
                }
                A0x[6] = "NKtMUWbh8IEHnmL8CqkTIFih5HReATD9";
                this.A04 = jCurrentTimeMillis;
                return;
            }
            this.A04 = -1L;
        }
    }

    private void A0W(int i, boolean playing, int i2) throws EK {
        C1822Pa c1822PaA0F = this.A0e.A0F();
        InterfaceC2059Yq interfaceC2059Yq = this.A0u[i];
        this.A0V[i2] = interfaceC2059Yq;
        if (interfaceC2059Yq.A90() == 0) {
            C1822Pa c1822PaA0G = this.A0e.A0G();
            C1822Pa playingPeriodHolder = this.A0e.A0F();
            boolean z = c1822PaA0G == playingPeriodHolder;
            C1857Ql c1857Ql = c1822PaA0F.A0K().A03[i];
            ZM[] zmArrA19 = A19(c1822PaA0F.A0K().A04[i]);
            boolean z2 = this.A0O && this.A0B.A00 == 3;
            interfaceC2059Yq.A6B(c1857Ql, zmArrA19, c1822PaA0F.A09[i], this.A06, !playing && z2, z, c1822PaA0G.A0H(this.A0J), c1822PaA0F.A0B());
            this.A0b.A09(interfaceC2059Yq);
            if (z2) {
                interfaceC2059Yq.start();
            }
        }
    }

    private void A0X(long j) throws EK {
        long jA0E;
        if (this.A0e.A0N()) {
            jA0E = this.A0e.A0F().A0E(j);
        } else {
            jA0E = ((long) (this.A0s ? 60000000 : 0)) + j;
        }
        this.A06 = jA0E;
        this.A0b.A07(this.A06);
        InterfaceC2059Yq[] interfaceC2059YqArr = this.A0V;
        String[] strArr = A0x;
        if (strArr[2].charAt(29) == strArr[7].charAt(29)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0x;
        strArr2[2] = "6cjt0DftUlyJkt5YxoU4x5BScAJaPycf";
        strArr2[7] = "iFkJhCDP58OQsIBkGOD6QVFtJMCkBvAk";
        for (InterfaceC2059Yq renderer : interfaceC2059YqArr) {
            renderer.AHs(this.A06);
        }
    }

    /* JADX WARN: Code duplicated, block: B:61:0x0127  */
    /* JADX WARN: Code duplicated, block: B:73:0x0177  */
    private void A0Y(long j, long j2) throws EK {
        C1807Oj c1807Oj;
        C1807Oj c1807Oj2;
        if (this.A0o.isEmpty() || this.A0B.A06.A00()) {
            return;
        }
        long j3 = this.A0B.A02;
        String[] strArr = A0x;
        if (strArr[0].length() != strArr[1].length()) {
            A0x[6] = "cuwXnxbitzQJ52kynMBodhKZ5HDDqisU";
            if (j3 == j) {
                j--;
            }
            int iA0A = this.A0B.A04.A0A(this.A0B.A06.A04);
            int currentPeriodIndex = this.A01;
            if (currentPeriodIndex > 0) {
                ArrayList<C1807Oj> arrayList = this.A0o;
                int currentPeriodIndex2 = this.A01;
                C1807Oj c1807Oj3 = arrayList.get(currentPeriodIndex2 - 1);
                if (A0x[4].length() != 14) {
                    String[] strArr2 = A0x;
                    strArr2[2] = "YjrfBycalZNuS3OLS6XZ8178vqqa0uBe";
                    strArr2[7] = "ztVn8xoPlLBBTcKHO2CFHO61dL9Fz34q";
                    c1807Oj = c1807Oj3;
                }
            } else {
                c1807Oj = null;
            }
            while (c1807Oj != null) {
                int currentPeriodIndex3 = c1807Oj.A00;
                if (currentPeriodIndex3 <= iA0A) {
                    int currentPeriodIndex4 = c1807Oj.A00;
                    if (currentPeriodIndex4 != iA0A || c1807Oj.A01 <= j) {
                        break;
                    }
                }
                int currentPeriodIndex5 = this.A01;
                this.A01 = currentPeriodIndex5 - 1;
                int currentPeriodIndex6 = this.A01;
                if (currentPeriodIndex6 > 0) {
                    ArrayList<C1807Oj> arrayList2 = this.A0o;
                    int currentPeriodIndex7 = this.A01;
                    c1807Oj = arrayList2.get(currentPeriodIndex7 - 1);
                } else {
                    c1807Oj = null;
                }
            }
            int i = this.A01;
            int currentPeriodIndex8 = this.A0o.size();
            if (i < currentPeriodIndex8) {
                ArrayList<C1807Oj> arrayList3 = this.A0o;
                int currentPeriodIndex9 = this.A01;
                c1807Oj2 = arrayList3.get(currentPeriodIndex9);
            } else {
                c1807Oj2 = null;
            }
            while (c1807Oj2 != null && c1807Oj2.A02 != null) {
                int currentPeriodIndex10 = c1807Oj2.A00;
                if (currentPeriodIndex10 >= iA0A) {
                    int currentPeriodIndex11 = c1807Oj2.A00;
                    if (currentPeriodIndex11 != iA0A || c1807Oj2.A01 > j) {
                        break;
                    }
                }
                int currentPeriodIndex12 = this.A01;
                this.A01 = currentPeriodIndex12 + 1;
                int i2 = this.A01;
                int currentPeriodIndex13 = this.A0o.size();
                if (i2 < currentPeriodIndex13) {
                    ArrayList<C1807Oj> arrayList4 = this.A0o;
                    int currentPeriodIndex14 = this.A01;
                    c1807Oj2 = arrayList4.get(currentPeriodIndex14);
                } else {
                    c1807Oj2 = null;
                }
            }
            while (c1807Oj2 != null && c1807Oj2.A02 != null) {
                int i3 = c1807Oj2.A00;
                if (A0x[6].charAt(6) == 'b') {
                    A0x[5] = "cxT6GxJO7aNKYdqzV";
                    if (i3 != iA0A) {
                        return;
                    }
                } else if (i3 != iA0A) {
                    return;
                }
                if (c1807Oj2.A01 > j && c1807Oj2.A01 <= j2) {
                    A0j(c1807Oj2.A03);
                    if (c1807Oj2.A03.A0B()) {
                        ArrayList<C1807Oj> arrayList5 = this.A0o;
                        int currentPeriodIndex15 = this.A01;
                        arrayList5.remove(currentPeriodIndex15);
                    } else {
                        boolean zA0D = c1807Oj2.A03.A0D();
                        if (A0x[5].length() == 17) {
                            String[] strArr3 = A0x;
                            strArr3[2] = "km3n4sgMhGJslo2UceVishmSiwmQ8Apx";
                            strArr3[7] = "RYoWwBUP7QLUCcHKLkK5nm2JuBoJnx6A";
                            if (zA0D) {
                                ArrayList<C1807Oj> arrayList6 = this.A0o;
                                int currentPeriodIndex16 = this.A01;
                                arrayList6.remove(currentPeriodIndex16);
                            } else {
                                int currentPeriodIndex17 = this.A01;
                                this.A01 = currentPeriodIndex17 + 1;
                            }
                        } else if (zA0D) {
                            ArrayList<C1807Oj> arrayList7 = this.A0o;
                            int currentPeriodIndex18 = this.A01;
                            arrayList7.remove(currentPeriodIndex18);
                        } else {
                            int currentPeriodIndex19 = this.A01;
                            this.A01 = currentPeriodIndex19 + 1;
                        }
                    }
                    int i4 = this.A01;
                    int currentPeriodIndex20 = this.A0o.size();
                    if (i4 < currentPeriodIndex20) {
                        ArrayList<C1807Oj> arrayList8 = this.A0o;
                        int currentPeriodIndex21 = this.A01;
                        C1807Oj c1807Oj4 = arrayList8.get(currentPeriodIndex21);
                        if (A0x[3].charAt(28) == 'h') {
                            String[] strArr4 = A0x;
                            strArr4[0] = "Xjw536nOOKpb09ZA4XmKi";
                            strArr4[1] = "U00GMAN7IvWet8rWJBBv9SUN09m19Av";
                            c1807Oj2 = c1807Oj4;
                        }
                    } else {
                        c1807Oj2 = null;
                    }
                } else {
                    return;
                }
            }
            return;
        }
        throw new RuntimeException();
    }

    private void A0Z(long j, long j2) {
        this.A0m.AHZ(2);
        this.A0m.AIH(2, j + j2);
    }

    @MetaExoPlayerCustomization("D18870411: Adding start stall debug reason")
    private void A0a(MI mi, boolean z) {
        if (this.A0B.A00 != 3) {
            this.A0B = this.A0B.A02(3, mi, z);
            this.A04 = -1L;
        }
    }

    private void A0b(C1805Oh c1805Oh) throws EK {
        throw new NullPointerException(A0C(376, 16, 43));
    }

    private void A0c(C1805Oh c1805Oh, boolean z) throws EK {
        this.A0c.A03(1);
        throw new NullPointerException(A0C(363, 13, 28));
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0083  */
    private void A0f(C1822Pa c1822Pa) throws EK {
        C1822Pa c1822PaA0F = this.A0e.A0F();
        if (c1822PaA0F == null || c1822Pa == c1822PaA0F) {
            return;
        }
        int i = 0;
        boolean[] zArr = new boolean[this.A0u.length];
        for (int i2 = 0; i2 < this.A0u.length; i2++) {
            InterfaceC2059Yq interfaceC2059Yq = this.A0u[i2];
            zArr[i2] = interfaceC2059Yq.A90() != 0;
            C2290dH c2290dHA0K = c1822PaA0F.A0K();
            int enabledRendererCount = A0x[5].length();
            if (enabledRendererCount != 17) {
                throw new RuntimeException();
            }
            A0x[4] = "gT1PRuQGo4WesX7dCGV4FK";
            if (c2290dHA0K.A00(i2)) {
                i++;
            }
            if (zArr[i2]) {
                if (c1822PaA0F.A0K().A00(i2)) {
                    if (interfaceC2059Yq.AAC()) {
                        InterfaceC2180bV interfaceC2180bVA93 = interfaceC2059Yq.A93();
                        InterfaceC2180bV interfaceC2180bV = c1822Pa.A09[i2];
                        int enabledRendererCount2 = A0x[6].charAt(6);
                        if (enabledRendererCount2 != 98) {
                            throw new RuntimeException();
                        }
                        A0x[6] = "ZKRARkboyfOczpGve6cKwyMhictp2PLx";
                        if (interfaceC2180bVA93 == interfaceC2180bV) {
                            A0l(interfaceC2059Yq);
                        }
                    } else {
                        continue;
                    }
                } else {
                    A0l(interfaceC2059Yq);
                }
            }
        }
        this.A0B = this.A0B.A07(c1822PaA0F.A0J(), c1822PaA0F.A0K());
        A13(zArr, i);
    }

    private void A0g(C2064Yv c2064Yv) {
        this.A0b.AIj(c2064Yv);
        if (this.A0n != null) {
            this.A0n.AIj(c2064Yv);
        }
        if (this.A0f != null) {
            this.A0f.AIj(c2064Yv);
        }
    }

    private void A0h(QT qt) throws EK {
        if (qt.A0D()) {
            return;
        }
        try {
            qt.A04().A9Y(qt.A01(), qt.A09());
        } finally {
            qt.A0A(true);
        }
    }

    private void A0i(QT qt) throws EK {
        if (qt.A02() == -9223372036854775807L) {
            A0j(qt);
            return;
        }
        if (this.A0E == null || this.A02 > 0) {
            this.A0o.add(new C1807Oj(qt));
            return;
        }
        C1807Oj c1807Oj = new C1807Oj(qt);
        if (A15(c1807Oj)) {
            this.A0o.add(c1807Oj);
            Collections.sort(this.A0o);
        } else {
            qt.A0A(false);
        }
    }

    private void A0j(QT qt) throws EK {
        if (qt.A03() == this.A0m.A8H()) {
            A0h(qt);
            if (this.A0B.A00 != 3) {
                int i = this.A0B.A00;
                String[] strArr = A0x;
                if (strArr[0].length() == strArr[1].length()) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A0x;
                strArr2[0] = "IflZ3gYpudwozPWfp62r4";
                strArr2[1] = "kDwc6g6BttOxIaR9WB7qOD9wvYhT2l9";
                if (i != 2) {
                    return;
                }
            }
            this.A0m.AIG(2);
            return;
        }
        this.A0m.AC4(15, qt).A02();
    }

    private void A0k(final QT qt) {
        Looper looperA03 = qt.A03();
        if (!looperA03.getThread().isAlive()) {
            Log.w(A0C(Sdk.SDKError.Reason.AD_RESPONSE_RETRY_AFTER_VALUE, 3, 3), A0C(258, 40, 66));
            qt.A0A(false);
        } else {
            this.A0l.A5F(looperA03, null).A03(new Runnable() { // from class: com.facebook.ads.redexgen.X.Of
                @Override // java.lang.Runnable
                public final void run() {
                    this.A00.A1C(qt);
                }
            });
        }
    }

    private void A0l(InterfaceC2059Yq interfaceC2059Yq) throws EK {
        this.A0b.A08(interfaceC2059Yq);
        A0m(interfaceC2059Yq);
        interfaceC2059Yq.A5n();
    }

    private void A0m(InterfaceC2059Yq interfaceC2059Yq) throws EK {
        if (interfaceC2059Yq.A90() == 2) {
            interfaceC2059Yq.stop();
        }
    }

    private void A0n(C1859Qn c1859Qn) {
        this.A0D = c1859Qn;
    }

    private void A0o(R7 r7) {
        if (!this.A0e.A0T(r7)) {
            return;
        }
        C1827Pf c1827Pf = this.A0e;
        if (A0x[6].charAt(6) != 'b') {
            throw new RuntimeException();
        }
        A0x[3] = "N2YsFookWO0YHNtVSQlDYkRhdslXhp1Z";
        c1827Pf.A0L(this.A06);
        A0v(false);
    }

    /* JADX WARN: Code duplicated, block: B:18:0x007d  */
    /* JADX WARN: Code duplicated, block: B:23:0x008e  */
    private void A0p(R7 r7) throws EK {
        byte b;
        if (!this.A0e.A0T(r7)) {
            return;
        }
        C1822Pa c1822PaA0E = this.A0e.A0E();
        c1822PaA0E.A0N(this.A0b.A8c().A01, this.A0B.A04);
        A0s(c1822PaA0E.A0J(), c1822PaA0E.A0K());
        if (!this.A0e.A0N()) {
            C1822Pa loadingPeriodHolder = this.A0e.A0B();
            A0X(loadingPeriodHolder.A00.A03);
            A0f(null);
        }
        boolean z = this.A0L;
        if (A0x[5].length() != 17) {
            throw new RuntimeException();
        }
        A0x[4] = "X90kmegW";
        if (z) {
            b = 0;
        } else {
            boolean z2 = this.A0O;
            if (A0x[4].length() != 14) {
                String[] strArr = A0x;
                strArr[2] = "ooe8Ubhu9oCVsapmfipAXADpBd4J5cmP";
                strArr[7] = "aSCXJA5N9UbyM7e2VXbRy1jNGUXDVNUP";
                if (z2) {
                    b = 0;
                } else {
                    b = 2;
                }
            } else if (z2) {
                b = 0;
            } else {
                b = 2;
            }
        }
        A0R(b);
        A0z(this.A0O);
        A0v(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.core.InterfaceC2183bY
    /* JADX INFO: renamed from: A0q, reason: merged with bridge method [inline-methods] */
    public final void ACl(R7 r7) {
        this.A0m.AC4(10, r7).A02();
    }

    private void A0r(InterfaceC2151az interfaceC2151az, boolean z, boolean z2) {
        this.A02++;
        A12(true, z, z2);
        this.A0d.onPrepared();
        this.A0E = interfaceC2151az;
        A0U(2);
        interfaceC2151az.AGF(this, null);
        this.A0m.AIG(2);
    }

    private void A0s(C1863Qs c1863Qs, C2290dH c2290dH) {
        this.A0d.AFN(this.A0u, c1863Qs, c2290dH.A04);
    }

    @MetaExoPlayerCustomization(type = {"NEW_METHOD"}, value = "D63737392: Added for negative testing")
    private void A0t(String str) {
        boolean z = false;
        if (str == null) {
            this.A0I = false;
            this.A0A = null;
            return;
        }
        if (str != null && str.length() > 0) {
            z = true;
        }
        this.A0I = z;
        this.A0A = new Q4(str);
    }

    private void A0u(boolean z) {
        C1822Pa c1822PaA0E = this.A0e.A0E();
        R5 r5 = c1822PaA0E == null ? this.A0B.A06 : c1822PaA0E.A00.A04;
        boolean z2 = !this.A0B.A05.equals(r5);
        if (z2) {
            this.A0B = this.A0B.A05(r5);
        }
        if ((z2 || z) && c1822PaA0E != null && c1822PaA0E.A02) {
            A0s(c1822PaA0E.A0J(), c1822PaA0E.A0K());
        }
    }

    /* JADX WARN: Code duplicated, block: B:28:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:41:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:43:0x010a  */
    /* JADX WARN: Code duplicated, block: B:46:0x0118  */
    /* JADX WARN: Code duplicated, block: B:50:? A[RETURN, SYNTHETIC] */
    @MetaExoPlayerCustomization("Customized Buffered Duration MS D23157182")
    private void A0v(boolean z) {
        long jA0C;
        boolean z2;
        boolean zAJ1;
        long playbackPositionUs;
        C1822Pa c1822PaA0E = this.A0e.A0E();
        long jA0A = c1822PaA0E.A0A();
        if (jA0A == Long.MIN_VALUE) {
            A0x(false);
            return;
        }
        long bufferedDurationUs = c1822PaA0E.A0D(this.A06);
        if (this.A0r && c1822PaA0E != this.A0e.A0F()) {
            C1827Pf c1827Pf = this.A0e;
            String[] strArr = A0x;
            if (strArr[2].charAt(29) != strArr[7].charAt(29)) {
                A0x[6] = "BnWuPNbniw1G8VSQjUKCLSiqaJpfjD1Q";
                if (c1827Pf.A0F() != null) {
                    jA0C = A02();
                }
                PC pc = this.A0d;
                float f = this.A0b.A8c().A01;
                if (!this.A0O || z) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                zAJ1 = pc.AJ1(bufferedDurationUs, jA0C, f, z2);
                if (this.A0S && this.A0O && this.A0Q && !zAJ1 && this.A0B.A00 == 2) {
                    this.A0Z.obtainMessage(5, AbstractC2471gE.A0n(A0C(Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE, 70, 74), Long.valueOf(bufferedDurationUs / 1000), Long.valueOf(jA0C / 1000), Long.valueOf(jA0A / 1000))).sendToTarget();
                    this.A0S = false;
                }
                A0x(zAJ1);
                if (zAJ1) {
                    playbackPositionUs = this.A06;
                    if (A0x[4].length() != 14) {
                        throw new RuntimeException();
                    }
                    A0x[6] = "L451UJbZN9SaDsstlPxLY9vCXavau12l";
                    c1822PaA0E.A0O(playbackPositionUs);
                    return;
                }
                return;
            }
            throw new RuntimeException();
        }
        jA0C = c1822PaA0E.A0C(bufferedDurationUs);
        if (A0x[6].charAt(6) == 'b') {
            String[] strArr2 = A0x;
            strArr2[0] = "6iPguvhasdZ2wvHuVjqVN";
            strArr2[1] = "ARuNV7j6IDAuE7ay1d3QbXncKUTHdhB";
            if (this.A0N) {
                for (C1822Pa c1822PaA0F = this.A0e.A0F(); c1822PaA0F != null && c1822PaA0F != c1822PaA0E; c1822PaA0F = c1822PaA0F.A0I()) {
                    jA0C += c1822PaA0F.A0C(c1822PaA0F.A0D(this.A06));
                }
            }
            PC pc2 = this.A0d;
            float f2 = this.A0b.A8c().A01;
            if (this.A0O) {
                z2 = true;
            } else {
                z2 = true;
            }
            zAJ1 = pc2.AJ1(bufferedDurationUs, jA0C, f2, z2);
            if (this.A0S) {
                this.A0Z.obtainMessage(5, AbstractC2471gE.A0n(A0C(Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE, 70, 74), Long.valueOf(bufferedDurationUs / 1000), Long.valueOf(jA0C / 1000), Long.valueOf(jA0A / 1000))).sendToTarget();
                this.A0S = false;
            }
            A0x(zAJ1);
            if (zAJ1) {
                playbackPositionUs = this.A06;
                if (A0x[4].length() != 14) {
                    throw new RuntimeException();
                }
                A0x[6] = "L451UJbZN9SaDsstlPxLY9vCXavau12l";
                c1822PaA0E.A0O(playbackPositionUs);
                return;
            }
            return;
        }
        throw new RuntimeException();
    }

    private void A0w(boolean z) throws EK {
        R5 r5 = this.A0e.A0F().A00.A04;
        long jA07 = A07(false, r5, this.A0B.A0C, true);
        if (jA07 != this.A0B.A0C) {
            this.A0B = this.A0B.A06(r5, jA07, this.A0B.A01, A01());
            if (z) {
                this.A0c.A04(4);
            }
        }
    }

    private void A0x(boolean z) {
        if (this.A0B.A0A != z) {
            this.A0B = this.A0B.A08(z);
        }
    }

    private void A0y(boolean z) throws EK {
        try {
            this.A0Q = false;
            this.A0O = z;
            A0z(z);
            if (!z) {
                A0N();
                A0P();
                A0R((byte) 2);
                if (this.A0H) {
                    A0D();
                }
            } else {
                A0R((byte) 0);
                if (this.A0B.A00 != 3) {
                    if (this.A0B.A00 == 2) {
                        this.A0m.AIG(2);
                    }
                } else {
                    A0M();
                    this.A0m.AIG(2);
                }
            }
        } finally {
            this.A0Z.obtainMessage(3, Boolean.valueOf(z)).sendToTarget();
        }
    }

    @MetaExoPlayerCustomization("D19875605 Prevent further error loading once pausing video")
    private void A0z(boolean z) {
        C1822Pa loadingPeriod = this.A0e.A0E();
        if (loadingPeriod == null) {
            return;
        }
        loadingPeriod.A07.AIi(z);
    }

    private void A10(boolean z) throws EK {
        this.A0U = z;
        if (!this.A0e.A0S(this.A0B.A04, z)) {
            A0w(true);
        }
        A0u(false);
    }

    private void A11(boolean z, boolean z2) {
        A12(true, z, z);
        this.A0c.A03(this.A02 + (z2 ? 1 : 0));
        this.A02 = 0;
        this.A0d.AFF();
        A0U(1);
    }

    private void A12(boolean z, boolean z2, boolean z3) {
        InterfaceC2059Yq[] interfaceC2059YqArr;
        int length;
        int i;
        long startPositionUs;
        C2290dH c2290dH;
        this.A0m.AHZ(2);
        this.A0Q = false;
        this.A0b.A06();
        this.A0f.A01();
        if (this.A0t) {
            this.A0n.A01();
        }
        boolean z4 = this.A0s;
        String[] strArr = A0x;
        if (strArr[2].charAt(29) == strArr[7].charAt(29)) {
            throw new RuntimeException();
        }
        A0x[4] = "5dWxzzJ98Fka";
        this.A06 = z4 ? 60000000L : 0L;
        if (A0x[5].length() == 17) {
            A0x[3] = "irXoD6IMK3951LOgJnhrgpRIUxubhL7p";
            interfaceC2059YqArr = this.A0V;
            length = interfaceC2059YqArr.length;
            i = 0;
        } else {
            interfaceC2059YqArr = this.A0V;
            length = interfaceC2059YqArr.length;
            i = 0;
        }
        while (i < length) {
            try {
                A0l(interfaceC2059YqArr[i]);
            } catch (EK | RuntimeException e) {
                String strA0C = A0C(0, 21, 8);
                String strA0C2 = A0C(208, 12, 11);
                if (A0x[5].length() != 17) {
                    A0x[5] = "yoYrePxBNWNpTCNXS";
                    Log.e(strA0C, strA0C2, e);
                } else {
                    String[] strArr2 = A0x;
                    strArr2[2] = "zYQChwMC0acuWOdO4Tu2vsdnZs4BHCBS";
                    strArr2[7] = "5ysXUZs2wF2c5Iiia3xGHcTqnidP19eH";
                    Log.e(strA0C, strA0C2, e);
                }
            }
            i++;
        }
        this.A0V = new InterfaceC2059Yq[0];
        this.A0e.A0M(!z2);
        A0x(false);
        if (A0x[3].charAt(28) != 'h') {
            throw new RuntimeException();
        }
        String[] strArr3 = A0x;
        strArr3[0] = "9mCMXGvhk13EZa5CjgfAY";
        strArr3[1] = "xwnh7YG3XxTfSdfdJLzgH1PTV0TrZRq";
        if (z2) {
            this.A09 = null;
        }
        if (z3) {
            Iterator<C1807Oj> it = this.A0o.iterator();
            while (true) {
                boolean zHasNext = it.hasNext();
                String[] strArr4 = A0x;
                if (strArr4[2].charAt(29) == strArr4[7].charAt(29)) {
                    throw new RuntimeException();
                }
                A0x[3] = "vKma2dcDyA9GzTABWD8bVPAONyaHh975";
                if (zHasNext) {
                    it.next().A03.A0A(false);
                } else {
                    this.A0o.clear();
                    this.A01 = 0;
                    break;
                }
            }
        }
        R5 mediaPeriodId = z2 ? A0A() : this.A0B.A06;
        long contentPositionUs = -9223372036854775807L;
        if (z2) {
            startPositionUs = -9223372036854775807L;
        } else {
            startPositionUs = this.A0B.A0C;
        }
        if (!z2) {
            contentPositionUs = this.A0B.A01;
        }
        Timeline timeline = z3 ? Timeline.A02 : this.A0B.A04;
        int i2 = this.A0B.A00;
        C1863Qs c1863Qs = z3 ? C1863Qs.A06 : this.A0B.A07;
        if (z3) {
            c2290dH = this.A0j;
        } else {
            c2290dH = this.A0B.A08;
        }
        this.A0B = new Q9(timeline, mediaPeriodId, startPositionUs, contentPositionUs, i2, false, c1863Qs, c2290dH, mediaPeriodId, startPositionUs, 0L, startPositionUs);
        if (z && this.A0E != null) {
            this.A0E.AGt(this);
            this.A0E = null;
        }
    }

    private void A13(boolean[] zArr, int i) throws EK {
        this.A0V = new InterfaceC2059Yq[i];
        int enabledRendererCount = 0;
        C1822Pa c1822PaA0F = this.A0e.A0F();
        for (int i2 = 0; i2 < enabledRendererCount; i2++) {
            if (c1822PaA0F.A0K().A00(i2)) {
                A0W(i2, zArr[i2], enabledRendererCount);
                enabledRendererCount++;
            }
        }
    }

    private boolean A14() {
        C1822Pa playingPeriodHolder = this.A0e.A0F();
        C1822Pa c1822PaA0I = playingPeriodHolder.A0I();
        long j = playingPeriodHolder.A00.A00;
        return j == -9223372036854775807L || this.A0B.A0C < j || (c1822PaA0I != null && (c1822PaA0I.A02 || c1822PaA0I.A00.A04.A00()));
    }

    private boolean A15(C1807Oj c1807Oj) {
        if (c1807Oj.A02 == null) {
            Pair<Object, Long> pairA08 = A08(new C1809Ol(c1807Oj.A03.A08(), c1807Oj.A03.A00(), O5.A00(c1807Oj.A03.A02())), false);
            if (pairA08 == null) {
                return false;
            }
            c1807Oj.A01(this.A0B.A04.A0A(pairA08.first), ((Long) pairA08.second).longValue(), pairA08.first);
        } else {
            int iA0A = this.A0B.A04.A0A(c1807Oj.A02);
            if (iA0A == -1) {
                return false;
            }
            c1807Oj.A00 = iA0A;
        }
        if (A0x[4].length() == 14) {
            throw new RuntimeException();
        }
        A0x[5] = "pTp429R6g8QE6OWae";
        return true;
    }

    private boolean A16(InterfaceC2059Yq interfaceC2059Yq) {
        C1822Pa c1822PaA0G = this.A0e.A0G();
        C1822Pa readingPeriodHolder = c1822PaA0G.A0I();
        if (readingPeriodHolder != null) {
            C1822Pa readingPeriodHolder2 = c1822PaA0G.A0I();
            if (readingPeriodHolder2.A02 && interfaceC2059Yq.A9f()) {
                return true;
            }
        }
        return false;
    }

    private boolean A17(R5 r5, long j, C1822Pa c1822Pa) {
        if (r5.equals(c1822Pa.A00.A04) && c1822Pa.A02) {
            Timeline timeline = this.A0B.A04;
            String[] strArr = A0x;
            if (strArr[2].charAt(29) == strArr[7].charAt(29)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0x;
            strArr2[2] = "472eJP3zn9qYE5XrsvvjufYNTfvHco5v";
            strArr2[7] = "mD7AGQLdMY8WzkfpubN5JhXBAhWtDxAx";
            timeline.A0J(this.A0B.A06.A04, this.A0g);
            int iA07 = this.A0g.A07(j);
            if (iA07 == -1 || this.A0g.A0D(iA07) == c1822Pa.A00.A01) {
                return true;
            }
            return false;
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:43:0x00b2  */
    @MetaExoPlayerCustomizations({@MetaExoPlayerCustomization("Customized Buffered Duration MS D23157182"), @MetaExoPlayerCustomization("D18870411: Adding start stall debug reason")})
    private boolean A18(boolean z) {
        long jA0C;
        boolean z2;
        if (this.A0V.length == 0) {
            return A14();
        }
        if (!z) {
            if (this.A0C != null) {
                this.A07 = this.A0C.A8z();
            }
            return false;
        }
        if (!this.A0B.A0A) {
            return true;
        }
        C1822Pa loadingHolder = this.A0e.A0E();
        boolean z3 = loadingHolder.A0R() && loadingHolder.A00.A05;
        if (!this.A0r || this.A0e.A0F() == this.A0e.A0E() || this.A0e.A0F() == null) {
            jA0C = loadingHolder.A0C(loadingHolder.A0D(this.A06));
        } else {
            jA0C = A03();
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (this.A00 > 0 && this.A04 > 0) {
            long j = jCurrentTimeMillis - this.A04;
            String[] strArr = A0x;
            if (strArr[2].charAt(29) == strArr[7].charAt(29)) {
                throw new RuntimeException();
            }
            A0x[6] = "8HA0HKbYdvvMPLwaVeNTaJrDoSfEgujA";
            if (j < this.A00) {
                z2 = true;
            } else {
                z2 = false;
            }
        } else {
            z2 = false;
        }
        boolean z4 = z3 || this.A0d.AJ4(jA0C, this.A0b.A8c().A01, this.A0Q, z2, -9223372036854775807L);
        if (!z4) {
            this.A07 = MI.A04;
        }
        return z4;
    }

    public static ZM[] A19(InterfaceC2283dA interfaceC2283dA) {
        int length = interfaceC2283dA != null ? interfaceC2283dA.length() : 0;
        ZM[] zmArr = new ZM[length];
        for (int i = 0; i < length; i++) {
            zmArr[i] = interfaceC2283dA.A81(i);
        }
        return zmArr;
    }

    public final Looper A1A() {
        return this.A0a.getLooper();
    }

    public final synchronized void A1B() {
        if (this.A0R) {
            return;
        }
        this.A0m.AIG(7);
        boolean z = false;
        while (!wasInterrupted) {
            try {
                wait();
            } catch (InterruptedException unused) {
                z = true;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
    }

    public final /* synthetic */ void A1C(QT qt) {
        try {
            A0h(qt);
        } catch (EK e) {
            Log.e(A0C(0, 21, 8), A0C(298, 55, 26), e);
            throw new RuntimeException(e);
        }
    }

    public final void A1D(Timeline timeline, int i, long j) {
        this.A0m.AC4(3, new C1809Ol(timeline, i, j)).A02();
    }

    public final void A1E(InterfaceC2151az interfaceC2151az, boolean z, boolean z2) {
        this.A0m.AC3(0, z ? 1 : 0, z2 ? 1 : 0, interfaceC2151az).A02();
    }

    public final void A1F(boolean z) {
        this.A0m.AC2(1, z ? 1 : 0, 0).A02();
    }

    public final void A1G(boolean z) {
        this.A0m.AC2(6, z ? 1 : 0, 0).A02();
    }

    @Override // com.facebook.ads.redexgen.core.OH
    public final void AEV(C2064Yv c2064Yv) {
        this.A0Z.obtainMessage(1, c2064Yv).sendToTarget();
        A0S(c2064Yv.A01);
    }

    @Override // com.facebook.ads.redexgen.core.R8
    public final void AEd(R7 r7) {
        this.A0m.AC4(9, r7).A02();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2150ay
    public final void AFA(InterfaceC2151az interfaceC2151az, Timeline timeline) {
        this.A0m.AC4(8, new C1806Oi(interfaceC2151az, timeline)).A02();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2288dF
    public final void AFL() {
        this.A0m.AIG(11);
    }

    @Override // com.facebook.ads.redexgen.core.QR
    public final synchronized void AII(QT qt) {
        if (this.A0R) {
            Log.w(A0C(0, 21, 8), A0C(50, 37, 31));
            qt.A0A(false);
        } else {
            this.A0m.AC4(14, qt).A02();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) throws Throwable {
        String strA0C = A0C(0, 21, 8);
        try {
            switch (message.what) {
                case 0:
                    A0r((InterfaceC2151az) message.obj, message.arg1 != 0, message.arg2 != 0);
                    A0G();
                    return true;
                case 1:
                    A0y(message.arg1 != 0);
                    A0G();
                    return true;
                case 2:
                    A0E();
                    A0G();
                    return true;
                case 3:
                    A0e((C1809Ol) message.obj);
                    A0G();
                    return true;
                case 4:
                    A0g((C2064Yv) message.obj);
                    A0G();
                    return true;
                case 5:
                    A0n((C1859Qn) message.obj);
                    A0G();
                    return true;
                case 6:
                    A11(message.arg1 != 0, true);
                    A0G();
                    return true;
                case 7:
                    A0J();
                    return true;
                case 8:
                    A0d((C1806Oi) message.obj);
                    A0G();
                    return true;
                case 9:
                    A0p((R7) message.obj);
                    A0G();
                    return true;
                case 10:
                    A0o((R7) message.obj);
                    A0G();
                    return true;
                case 11:
                    A0K();
                    A0G();
                    return true;
                case 12:
                    A0T(message.arg1);
                    A0G();
                    return true;
                case 13:
                    A10(message.arg1 != 0);
                    A0G();
                    return true;
                case 14:
                    A0i((QT) message.obj);
                    A0G();
                    return true;
                case 15:
                    A0k((QT) message.obj);
                    A0G();
                    return true;
                case 16:
                    A0G();
                    return true;
                case 17:
                    A0c(null, false);
                    throw null;
                case 18:
                    A0b(null);
                    throw null;
                case 19:
                    A0t((String) message.obj);
                    A0G();
                    return true;
                default:
                    return false;
            }
        } catch (EK e) {
            Log.e(strA0C, A0C(110, 15, 85), e);
            A11(false, false);
            this.A0Z.obtainMessage(2, e).sendToTarget();
            A0G();
        } catch (IOException e2) {
            Log.e(strA0C, A0C(195, 13, 106), e2);
            A11(false, false);
            this.A0Z.obtainMessage(2, EK.A01(e2, 2000)).sendToTarget();
            A0G();
        } catch (RuntimeException e3) {
            Log.e(strA0C, A0C(87, 23, 39), e3);
            A11(false, false);
            this.A0Z.obtainMessage(2, EK.A02(e3)).sendToTarget();
            A0G();
        }
    }
}
