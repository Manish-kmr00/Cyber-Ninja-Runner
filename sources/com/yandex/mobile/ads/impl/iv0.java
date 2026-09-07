package com.yandex.mobile.ads.impl;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaCryptoException;
import android.media.MediaFormat;
import android.media.metrics.LogSessionId;
import android.os.Bundle;
import android.os.SystemClock;
import com.google.common.base.Ascii;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public abstract class iv0 extends rk {
    private static final jv0 F0 = jm1.f();
    private static final byte[] G0 = {0, 0, 1, 103, 66, -64, Ascii.VT, -38, 37, -112, 0, 0, 1, 104, -50, Ascii.SI, 19, 32, 0, 0, 1, 101, -120, -124, Ascii.CR, -50, 113, Ascii.CAN, -96, 0, 47, -65, Ascii.FS, 49, -61, 39, 93, 120};
    private final long[] A;
    private j60 A0;
    private gc0 B;
    protected my B0;
    private gc0 C;
    private long C0;
    private d40 D;
    private long D0;
    private d40 E;
    private int E0;
    private MediaCrypto F;
    private boolean G;
    private long H;
    private float I;
    private float J;
    private cv0 K;
    private gc0 L;
    private MediaFormat M;
    private boolean N;
    private float O;
    private ArrayDeque<gv0> P;
    private b Q;
    private gv0 R;
    private int S;
    private boolean T;
    private boolean U;
    private boolean V;
    private boolean W;
    private boolean X;
    private boolean Y;
    private boolean Z;
    private boolean a0;
    private boolean b0;
    private boolean c0;
    private pm d0;
    private long e0;
    private int f0;
    private int g0;
    private ByteBuffer h0;
    private boolean i0;
    private boolean j0;
    private boolean k0;
    private boolean l0;
    private boolean m0;
    private final cv0.b n;
    private boolean n0;
    private final kv0 o;
    private int o0;
    private final boolean p;
    private int p0;
    private final float q;
    private int q0;
    private final oy r;
    private boolean r0;
    private final oy s;
    private boolean s0;
    private final oy t;
    private boolean t0;
    private final yk u;
    private long u0;
    private final a52<gc0> v;
    private long v0;
    private final ArrayList<Long> w;
    private boolean w0;
    private final MediaCodec.BufferInfo x;
    private boolean x0;
    private final long[] y;
    private boolean y0;
    private final long[] z;
    private boolean z0;

    public static class b extends Exception {
        public final String b;
        public final boolean c;
        public final gv0 d;
        public final String e;

        public b(int i, gc0 gc0Var, ov0.b bVar, boolean z) {
            this("Decoder init failed: [" + i + "], " + gc0Var, bVar, gc0Var.m, z, null, a(i));
        }

        private b(String str, Throwable th, String str2, boolean z, gv0 gv0Var, String str3) {
            super(str, th);
            this.b = str2;
            this.c = z;
            this.d = gv0Var;
            this.e = str3;
        }

        private static String a(int i) {
            return "com.monetization.ads.exoplayer2.mediacodec.MediaCodecRenderer_" + (i < 0 ? "neg_" : "") + Math.abs(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static String a(Exception exc) {
            if (exc instanceof MediaCodec.CodecException) {
                return ((MediaCodec.CodecException) exc).getDiagnosticInfo();
            }
            return null;
        }
    }

    protected boolean G() {
        return false;
    }

    protected abstract void L();

    protected void O() throws j60 {
    }

    protected abstract float a(float f, gc0[] gc0VarArr);

    protected abstract int a(kv0 kv0Var, gc0 gc0Var) throws ov0.b;

    protected abstract cv0.a a(gv0 gv0Var, gc0 gc0Var, MediaCrypto mediaCrypto, float f);

    protected abstract qy a(gv0 gv0Var, gc0 gc0Var, gc0 gc0Var2);

    protected abstract ArrayList a(kv0 kv0Var, gc0 gc0Var, boolean z) throws ov0.b;

    protected abstract void a(gc0 gc0Var, MediaFormat mediaFormat) throws j60;

    protected void a(oy oyVar) throws j60 {
    }

    protected abstract void a(Exception exc);

    protected abstract void a(String str);

    protected abstract void a(String str, long j, long j2);

    protected abstract boolean a(long j, long j2, cv0 cv0Var, ByteBuffer byteBuffer, int i, int i2, int i3, long j3, boolean z, boolean z2, gc0 gc0Var) throws j60;

    protected boolean a(gv0 gv0Var) {
        return true;
    }

    protected abstract void b(oy oyVar) throws j60;

    protected boolean b(gc0 gc0Var) {
        return false;
    }

    @Override // com.yandex.mobile.ads.impl.rk, com.yandex.mobile.ads.impl.so1
    public final int f() {
        return 8;
    }

    public iv0(int i, c00 c00Var, kv0 kv0Var, float f) {
        super(i);
        this.n = c00Var;
        this.o = (kv0) hg.a(kv0Var);
        this.p = false;
        this.q = f;
        this.r = oy.j();
        this.s = new oy(0);
        this.t = new oy(2);
        yk ykVar = new yk();
        this.u = ykVar;
        this.v = new a52<>();
        this.w = new ArrayList<>();
        this.x = new MediaCodec.BufferInfo();
        this.I = 1.0f;
        this.J = 1.0f;
        this.H = -9223372036854775807L;
        this.y = new long[10];
        this.z = new long[10];
        this.A = new long[10];
        this.C0 = -9223372036854775807L;
        this.D0 = -9223372036854775807L;
        ykVar.e(0);
        ykVar.d.order(ByteOrder.nativeOrder());
        this.O = -1.0f;
        this.S = 0;
        this.o0 = 0;
        this.f0 = -1;
        this.g0 = -1;
        this.e0 = -9223372036854775807L;
        this.u0 = -9223372036854775807L;
        this.v0 = -9223372036854775807L;
        this.p0 = 0;
        this.q0 = 0;
    }

    private boolean c(long j, long j2) throws j60 {
        boolean z;
        boolean zA;
        int iA;
        boolean z2;
        if (this.g0 < 0) {
            if (this.X && this.s0) {
                try {
                    iA = this.K.a(this.x);
                } catch (IllegalStateException unused) {
                    M();
                    if (this.x0) {
                        N();
                    }
                    return false;
                }
            } else {
                iA = this.K.a(this.x);
            }
            if (iA < 0) {
                if (iA != -2) {
                    if (this.c0 && (this.w0 || this.p0 == 2)) {
                        M();
                    }
                    return false;
                }
                this.t0 = true;
                MediaFormat mediaFormatA = this.K.a();
                if (this.S != 0 && mediaFormatA.getInteger("width") == 32 && mediaFormatA.getInteger("height") == 32) {
                    this.b0 = true;
                } else {
                    if (this.Z) {
                        mediaFormatA.setInteger("channel-count", 1);
                    }
                    this.M = mediaFormatA;
                    this.N = true;
                }
                return true;
            }
            if (this.b0) {
                this.b0 = false;
                this.K.a(false, iA);
                return true;
            }
            MediaCodec.BufferInfo bufferInfo = this.x;
            if (bufferInfo.size == 0 && (bufferInfo.flags & 4) != 0) {
                M();
                return false;
            }
            this.g0 = iA;
            ByteBuffer byteBufferC = this.K.c(iA);
            this.h0 = byteBufferC;
            if (byteBufferC != null) {
                byteBufferC.position(this.x.offset);
                ByteBuffer byteBuffer = this.h0;
                MediaCodec.BufferInfo bufferInfo2 = this.x;
                byteBuffer.limit(bufferInfo2.offset + bufferInfo2.size);
            }
            if (this.Y) {
                MediaCodec.BufferInfo bufferInfo3 = this.x;
                if (bufferInfo3.presentationTimeUs == 0 && (bufferInfo3.flags & 4) != 0) {
                    long j3 = this.u0;
                    if (j3 != -9223372036854775807L) {
                        bufferInfo3.presentationTimeUs = j3;
                    }
                }
            }
            long j4 = this.x.presentationTimeUs;
            int size = this.w.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    z2 = false;
                    break;
                }
                if (this.w.get(i).longValue() == j4) {
                    this.w.remove(i);
                    z2 = true;
                    break;
                }
                i++;
            }
            this.i0 = z2;
            long j5 = this.v0;
            long j6 = this.x.presentationTimeUs;
            this.j0 = j5 == j6;
            d(j6);
        }
        if (this.X && this.s0) {
            try {
                cv0 cv0Var = this.K;
                ByteBuffer byteBuffer2 = this.h0;
                int i2 = this.g0;
                MediaCodec.BufferInfo bufferInfo4 = this.x;
                z = false;
                try {
                    zA = a(j, j2, cv0Var, byteBuffer2, i2, bufferInfo4.flags, 1, bufferInfo4.presentationTimeUs, this.i0, this.j0, this.C);
                } catch (IllegalStateException unused2) {
                    M();
                    if (this.x0) {
                        N();
                    }
                    return z;
                }
            } catch (IllegalStateException unused3) {
                z = false;
            }
        } else {
            z = false;
            cv0 cv0Var2 = this.K;
            ByteBuffer byteBuffer3 = this.h0;
            int i3 = this.g0;
            MediaCodec.BufferInfo bufferInfo5 = this.x;
            zA = a(j, j2, cv0Var2, byteBuffer3, i3, bufferInfo5.flags, 1, bufferInfo5.presentationTimeUs, this.i0, this.j0, this.C);
        }
        if (zA) {
            c(this.x.presentationTimeUs);
            boolean z3 = (this.x.flags & 4) != 0 ? true : z;
            this.g0 = -1;
            this.h0 = null;
            if (!z3) {
                return r14;
            }
            M();
        }
        return z;
    }

    protected final void C() throws j60 {
        if (D()) {
            K();
        }
    }

    protected void P() {
        this.f0 = -1;
        this.s.d = null;
        this.g0 = -1;
        this.h0 = null;
        this.e0 = -9223372036854775807L;
        this.s0 = false;
        this.r0 = false;
        this.a0 = false;
        this.b0 = false;
        this.i0 = false;
        this.j0 = false;
        this.w.clear();
        this.u0 = -9223372036854775807L;
        this.v0 = -9223372036854775807L;
        pm pmVar = this.d0;
        if (pmVar != null) {
            pmVar.a();
        }
        this.p0 = 0;
        this.q0 = 0;
        this.o0 = this.n0 ? 1 : 0;
    }

    @Override // com.yandex.mobile.ads.impl.rk
    protected void v() {
        try {
            this.m0 = false;
            this.u.b();
            this.t.b();
            this.l0 = false;
            this.k0 = false;
            N();
        } finally {
            d40.a(this.E, null);
            this.E = null;
        }
    }

    protected final void K() throws j60 {
        gc0 gc0Var;
        if (this.K != null || this.k0 || (gc0Var = this.B) == null) {
            return;
        }
        boolean z = false;
        if (this.E == null && b(gc0Var)) {
            gc0 gc0Var2 = this.B;
            this.m0 = false;
            this.u.b();
            this.t.b();
            this.l0 = false;
            this.k0 = false;
            String str = gc0Var2.m;
            if (!"audio/mp4a-latm".equals(str) && !"audio/mpeg".equals(str) && !"audio/opus".equals(str)) {
                this.u.f(1);
            } else {
                this.u.f(32);
            }
            this.k0 = true;
            return;
        }
        d40 d40Var = this.E;
        d40.a(this.D, d40Var);
        this.D = d40Var;
        String str2 = this.B.m;
        if (d40Var != null) {
            if (this.F == null) {
                oc0 oc0VarA = a(d40Var);
                if (oc0VarA == null) {
                    if (this.D.getError() == null) {
                        return;
                    }
                } else {
                    try {
                        MediaCrypto mediaCrypto = new MediaCrypto(oc0VarA.f9807a, oc0VarA.b);
                        this.F = mediaCrypto;
                        if (!oc0VarA.c && mediaCrypto.requiresSecureDecoderComponent(str2)) {
                            z = true;
                        }
                        this.G = z;
                    } catch (MediaCryptoException e) {
                        throw a(e, this.B, 6006);
                    }
                }
            }
            if (oc0.d) {
                int state = this.D.getState();
                if (state == 1) {
                    d40.a error = this.D.getError();
                    error.getClass();
                    throw a(error, this.B, error.b);
                }
                if (state != 4) {
                    return;
                }
            }
        }
        try {
            a(this.F, this.G);
        } catch (b e2) {
            throw a(e2, this.B, 4001);
        }
    }

    protected final cv0 E() {
        return this.K;
    }

    protected final MediaFormat H() {
        return this.M;
    }

    protected final gv0 F() {
        return this.R;
    }

    @Override // com.yandex.mobile.ads.impl.rk
    protected void u() {
        this.B = null;
        this.C0 = -9223372036854775807L;
        this.D0 = -9223372036854775807L;
        this.E0 = 0;
        D();
    }

    protected final void N() {
        try {
            cv0 cv0Var = this.K;
            if (cv0Var != null) {
                cv0Var.release();
                this.B0.b++;
                a(this.R.f9037a);
            }
            this.K = null;
            try {
                MediaCrypto mediaCrypto = this.F;
                if (mediaCrypto != null) {
                    mediaCrypto.release();
                }
            } finally {
                this.F = null;
                d40.a(this.D, null);
                this.D = null;
                Q();
            }
        } catch (Throwable th) {
            this.K = null;
            try {
                MediaCrypto mediaCrypto2 = this.F;
                if (mediaCrypto2 != null) {
                    mediaCrypto2.release();
                }
                throw th;
            } finally {
                this.F = null;
                d40.a(this.D, null);
                this.D = null;
                Q();
            }
        }
    }

    protected final boolean D() {
        if (this.K == null) {
            return false;
        }
        int i = this.q0;
        if (i != 3 && !this.U && ((!this.V || this.t0) && (!this.W || !this.s0))) {
            if (i == 2) {
                int i2 = x82.f10629a;
                if (i2 < 23) {
                    throw new IllegalStateException();
                }
                if (i2 >= 23) {
                    try {
                        S();
                    } catch (j60 e) {
                        at0.b("MediaCodecRenderer", "Failed to update the DRM session, releasing the codec instead.", e);
                        N();
                        return true;
                    }
                }
            }
            B();
            return false;
        }
        N();
        return true;
    }

    private void B() {
        try {
            this.K.flush();
        } finally {
            P();
        }
    }

    protected final void Q() {
        P();
        this.A0 = null;
        this.d0 = null;
        this.P = null;
        this.R = null;
        this.L = null;
        this.M = null;
        this.N = false;
        this.t0 = false;
        this.O = -1.0f;
        this.S = 0;
        this.T = false;
        this.U = false;
        this.V = false;
        this.W = false;
        this.X = false;
        this.Y = false;
        this.Z = false;
        this.c0 = false;
        this.n0 = false;
        this.o0 = 0;
        this.G = false;
    }

    private List<gv0> a(boolean z) throws ov0.b {
        ArrayList arrayListA = a(this.o, this.B, z);
        if (arrayListA.isEmpty() && z) {
            arrayListA = a(this.o, this.B, false);
            if (!arrayListA.isEmpty()) {
                at0.d("MediaCodecRenderer", "Drm session requires secure decoder for " + this.B.m + ", but no secure decoder available. Trying to proceed with " + arrayListA + ".");
            }
        }
        return arrayListA;
    }

    /* JADX WARN: Code duplicated, block: B:144:0x026e  */
    /* JADX WARN: Code duplicated, block: B:145:0x0271  */
    /* JADX WARN: Code duplicated, block: B:146:0x0274  */
    /* JADX WARN: Code duplicated, block: B:74:0x012b  */
    /* JADX WARN: Code duplicated, block: B:75:0x012e  */
    /* JADX WARN: Code duplicated, block: B:76:0x0131  */
    private boolean A() throws j60 {
        int i;
        int i2;
        cv0 cv0Var = this.K;
        if (cv0Var == null || this.p0 == 2 || this.w0) {
            return false;
        }
        if (this.f0 < 0) {
            int iB = cv0Var.b();
            this.f0 = iB;
            if (iB < 0) {
                return false;
            }
            this.s.d = this.K.b(iB);
            this.s.b();
        }
        if (this.p0 == 1) {
            if (!this.c0) {
                this.s0 = true;
                this.K.a(this.f0, 0, 0L, 4);
                this.f0 = -1;
                this.s.d = null;
            }
            this.p0 = 2;
            return false;
        }
        if (this.a0) {
            this.a0 = false;
            ByteBuffer byteBuffer = this.s.d;
            byte[] bArr = G0;
            byteBuffer.put(bArr);
            this.K.a(this.f0, bArr.length, 0L, 0);
            this.f0 = -1;
            this.s.d = null;
            this.r0 = true;
            return true;
        }
        if (this.o0 == 1) {
            for (int i3 = 0; i3 < this.L.o.size(); i3++) {
                this.s.d.put(this.L.o.get(i3));
            }
            this.o0 = 2;
        }
        int iPosition = this.s.d.position();
        hc0 hc0VarQ = q();
        try {
            int iA = a(hc0VarQ, this.s, 0);
            if (e()) {
                this.v0 = this.u0;
            }
            if (iA == -3) {
                return false;
            }
            if (iA == -5) {
                if (this.o0 == 2) {
                    this.s.b();
                    this.o0 = 1;
                }
                a(hc0VarQ);
                return true;
            }
            if (this.s.f()) {
                if (this.o0 == 2) {
                    this.s.b();
                    this.o0 = 1;
                }
                this.w0 = true;
                if (!this.r0) {
                    M();
                    return false;
                }
                try {
                    if (!this.c0) {
                        this.s0 = true;
                        this.K.a(this.f0, 0, 0L, 4);
                        this.f0 = -1;
                        this.s.d = null;
                    }
                    return false;
                } catch (MediaCodec.CryptoException e) {
                    gc0 gc0Var = this.B;
                    int errorCode = e.getErrorCode();
                    int i4 = x82.f10629a;
                    if (errorCode == 2 || errorCode == 4) {
                        i2 = 6005;
                    } else if (errorCode == 10) {
                        i2 = 6004;
                    } else if (errorCode == 7) {
                        i2 = 6005;
                    } else if (errorCode != 8) {
                        switch (errorCode) {
                            case 15:
                                i2 = 6003;
                                break;
                            case 16:
                            case 18:
                                i2 = 6005;
                                break;
                            case 17:
                            case 19:
                            case 20:
                            case 21:
                            case 22:
                                i2 = 6004;
                                break;
                            default:
                                switch (errorCode) {
                                    case 24:
                                    case 25:
                                    case 26:
                                    case 27:
                                    case 28:
                                        i2 = 6002;
                                        break;
                                    default:
                                        i2 = 6006;
                                        break;
                                }
                                break;
                        }
                    } else {
                        i2 = 6003;
                    }
                    throw a(e, gc0Var, i2);
                }
            }
            if (!this.r0 && !this.s.g()) {
                this.s.b();
                if (this.o0 == 2) {
                    this.o0 = 1;
                }
                return true;
            }
            boolean zI = this.s.i();
            if (zI) {
                this.s.c.a(iPosition);
            }
            if (this.T && !zI) {
                ByteBuffer byteBuffer2 = this.s.d;
                byte[] bArr2 = a41.f8364a;
                int iPosition2 = byteBuffer2.position();
                int i5 = 0;
                int i6 = 0;
                while (true) {
                    int i7 = i5 + 1;
                    if (i7 < iPosition2) {
                        int i8 = byteBuffer2.get(i5) & 255;
                        if (i6 == 3) {
                            if (i8 == 1 && (byteBuffer2.get(i7) & Ascii.US) == 7) {
                                ByteBuffer byteBufferDuplicate = byteBuffer2.duplicate();
                                byteBufferDuplicate.position(i5 - 3);
                                byteBufferDuplicate.limit(iPosition2);
                                byteBuffer2.position(0);
                                byteBuffer2.put(byteBufferDuplicate);
                                break;
                            }
                        } else if (i8 == 0) {
                            i6++;
                        }
                        if (i8 != 0) {
                            i6 = 0;
                        }
                        i5 = i7;
                    } else {
                        byteBuffer2.clear();
                        break;
                    }
                }
                if (this.s.d.position() == 0) {
                    return true;
                }
                this.T = false;
            }
            oy oyVar = this.s;
            long jA = oyVar.f;
            pm pmVar = this.d0;
            if (pmVar != null) {
                jA = pmVar.a(this.B, oyVar);
                this.u0 = Math.max(this.u0, this.d0.a(this.B));
            }
            if (this.s.e()) {
                this.w.add(Long.valueOf(jA));
            }
            if (this.y0) {
                this.v.a(this.B, jA);
                this.y0 = false;
            }
            this.u0 = Math.max(this.u0, jA);
            this.s.h();
            if (this.s.d()) {
                a(this.s);
            }
            b(this.s);
            try {
                if (zI) {
                    this.K.a(this.f0, this.s.c, jA);
                } else {
                    this.K.a(this.f0, this.s.d.limit(), jA, 0);
                }
                this.f0 = -1;
                this.s.d = null;
                this.r0 = true;
                this.o0 = 0;
                this.B0.c++;
                return true;
            } catch (MediaCodec.CryptoException e2) {
                gc0 gc0Var2 = this.B;
                int errorCode2 = e2.getErrorCode();
                int i9 = x82.f10629a;
                if (errorCode2 == 2 || errorCode2 == 4) {
                    i = 6005;
                } else if (errorCode2 == 10) {
                    i = 6004;
                } else if (errorCode2 == 7) {
                    i = 6005;
                } else if (errorCode2 != 8) {
                    switch (errorCode2) {
                        case 15:
                            i = 6003;
                            break;
                        case 16:
                        case 18:
                            i = 6005;
                            break;
                        case 17:
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                            i = 6004;
                            break;
                        default:
                            switch (errorCode2) {
                                case 24:
                                case 25:
                                case 26:
                                case 27:
                                case 28:
                                    i = 6002;
                                    break;
                                default:
                                    i = 6006;
                                    break;
                            }
                            break;
                    }
                } else {
                    i = 6003;
                }
                throw a(e2, gc0Var2, i);
            }
        } catch (oy.a e3) {
            a(e3);
            c(0);
            B();
            return true;
        }
    }

    @Override // com.yandex.mobile.ads.impl.ro1
    public boolean d() {
        return this.B != null && (t() || this.g0 >= 0 || (this.e0 != -9223372036854775807L && SystemClock.elapsedRealtime() < this.e0));
    }

    protected final float J() {
        return this.I;
    }

    protected void c(long j) {
        while (true) {
            int i = this.E0;
            if (i == 0 || j < this.A[0]) {
                return;
            }
            long[] jArr = this.y;
            this.C0 = jArr[0];
            this.D0 = this.z[0];
            int i2 = i - 1;
            this.E0 = i2;
            System.arraycopy(jArr, 1, jArr, 0, i2);
            long[] jArr2 = this.z;
            System.arraycopy(jArr2, 1, jArr2, 0, this.E0);
            long[] jArr3 = this.A;
            System.arraycopy(jArr3, 1, jArr3, 0, this.E0);
            L();
        }
    }

    private boolean z() throws j60 {
        if (this.r0) {
            this.p0 = 1;
            if (!this.U && !this.W) {
                this.q0 = 2;
            } else {
                this.q0 = 3;
                return false;
            }
        } else {
            S();
        }
        return true;
    }

    private void M() throws j60 {
        int i = this.q0;
        if (i == 1) {
            B();
            return;
        }
        if (i == 2) {
            B();
            S();
        } else if (i != 3) {
            this.x0 = true;
            O();
        } else {
            N();
            K();
        }
    }

    protected final void R() {
        this.z0 = true;
    }

    protected final long I() {
        return this.D0;
    }

    private void S() throws j60 {
        try {
            this.F.setMediaDrmSession(a(this.E).b);
            d40 d40Var = this.E;
            d40.a(this.D, d40Var);
            this.D = d40Var;
            this.p0 = 0;
            this.q0 = 0;
        } catch (MediaCryptoException e) {
            throw a(e, this.B, 6006);
        }
    }

    private boolean b(long j, long j2) throws j60 {
        boolean z;
        if (!this.x0) {
            if (this.u.m()) {
                yk ykVar = this.u;
                ByteBuffer byteBuffer = ykVar.d;
                int i = this.g0;
                int iL = ykVar.l();
                yk ykVar2 = this.u;
                if (!a(j, j2, null, byteBuffer, i, 0, iL, ykVar2.f, ykVar2.e(), this.u.f(), this.C)) {
                    return false;
                }
                c(this.u.k());
                this.u.b();
                z = false;
            } else {
                z = false;
            }
            if (this.w0) {
                this.x0 = true;
                return z;
            }
            if (this.l0) {
                if (this.u.a(this.t)) {
                    this.l0 = z;
                } else {
                    throw new IllegalStateException();
                }
            }
            if (this.m0) {
                if (this.u.m()) {
                    return true;
                }
                this.m0 = z;
                this.u.b();
                this.t.b();
                this.l0 = z;
                this.k0 = z;
                this.m0 = z;
                K();
                if (!this.k0) {
                    return z;
                }
            }
            y();
            if (this.u.m()) {
                this.u.h();
            }
            if (this.u.m() || this.w0 || this.m0) {
                return true;
            }
            return z;
        }
        throw new IllegalStateException();
    }

    private void y() throws j60 {
        if (!this.w0) {
            hc0 hc0VarQ = q();
            this.t.b();
            do {
                this.t.b();
                int iA = a(hc0VarQ, this.t, 0);
                if (iA == -5) {
                    a(hc0VarQ);
                    return;
                }
                if (iA != -4) {
                    if (iA != -3) {
                        throw new IllegalStateException();
                    }
                    return;
                } else {
                    if (this.t.f()) {
                        this.w0 = true;
                        return;
                    }
                    if (this.y0) {
                        gc0 gc0Var = this.B;
                        gc0Var.getClass();
                        this.C = gc0Var;
                        a(gc0Var, (MediaFormat) null);
                        this.y0 = false;
                    }
                    this.t.h();
                }
            } while (this.u.a(this.t));
            this.l0 = true;
            return;
        }
        throw new IllegalStateException();
    }

    protected final void d(long j) throws j60 {
        gc0 gc0VarB = this.v.b(j);
        if (gc0VarB == null && this.N) {
            gc0VarB = this.v.c();
        }
        if (gc0VarB != null) {
            this.C = gc0VarB;
        } else if (!this.N || this.C == null) {
            return;
        }
        a(this.C, this.M);
        this.N = false;
    }

    private static final class a {
        public static void a(cv0.a aVar, ii1 ii1Var) {
            LogSessionId logSessionIdA = ii1Var.a();
            if (logSessionIdA.equals(LogSessionId.LOG_SESSION_ID_NONE)) {
                return;
            }
            aVar.b.setString("log-session-id", logSessionIdA.getStringId());
        }
    }

    private boolean c(int i) throws j60 {
        hc0 hc0VarQ = q();
        this.r.b();
        int iA = a(hc0VarQ, this.r, i | 4);
        if (iA == -5) {
            a(hc0VarQ);
            return true;
        }
        if (iA != -4 || !this.r.f()) {
            return false;
        }
        this.w0 = true;
        M();
        return false;
    }

    private boolean c(gc0 gc0Var) throws j60 {
        if (x82.f10629a >= 23 && this.K != null && this.q0 != 3 && getState() != 0) {
            float fA = a(this.J, s());
            float f = this.O;
            if (f == fA) {
                return true;
            }
            if (fA == -1.0f) {
                if (this.r0) {
                    this.p0 = 1;
                    this.q0 = 3;
                    return false;
                }
                N();
                K();
                return false;
            }
            if (f == -1.0f && fA <= this.q) {
                return true;
            }
            Bundle bundle = new Bundle();
            bundle.putFloat("operating-rate", fA);
            this.K.a(bundle);
            this.O = fA;
        }
        return true;
    }

    private oc0 a(d40 d40Var) throws j60 {
        cv cryptoConfig = d40Var.getCryptoConfig();
        if (cryptoConfig != null && !(cryptoConfig instanceof oc0)) {
            throw a(new IllegalArgumentException("Expecting FrameworkCryptoConfig but found: " + cryptoConfig), this.B, 6001);
        }
        return (oc0) cryptoConfig;
    }

    /* JADX WARN: Code duplicated, block: B:114:0x0212  */
    /* JADX WARN: Code duplicated, block: B:136:0x0266  */
    /* JADX WARN: Code duplicated, block: B:145:0x028b  */
    /* JADX WARN: Code duplicated, block: B:27:0x009f  */
    /* JADX WARN: Code duplicated, block: B:29:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:31:0x00af  */
    /* JADX WARN: Code duplicated, block: B:33:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:35:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:42:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:58:0x0125 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:59:0x0127  */
    /* JADX WARN: Code duplicated, block: B:67:0x014c  */
    /* JADX WARN: Code duplicated, block: B:87:0x01a0  */
    private void a(gv0 gv0Var, MediaCrypto mediaCrypto) throws Exception {
        int i;
        jv0 jv0Var;
        String strF;
        String str;
        boolean z;
        boolean z2;
        boolean z3;
        jv0 jv0Var2;
        boolean z4;
        String str2;
        jv0 jv0Var3;
        String str3 = gv0Var.f9037a;
        int i2 = x82.f10629a;
        float fA = i2 < 23 ? -1.0f : a(this.J, s());
        float f = fA > this.q ? fA : -1.0f;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        cv0.a aVarA = a(gv0Var, this.B, mediaCrypto, f);
        if (i2 >= 31) {
            a.a(aVarA, r());
        }
        try {
            n52.a("createCodec:" + str3);
            this.K = this.n.a(aVarA);
            n52.a();
            long jElapsedRealtime2 = SystemClock.elapsedRealtime();
            this.R = gv0Var;
            this.O = f;
            this.L = this.B;
            if (i2 <= 25) {
                jv0 jv0Var4 = F0;
                if (jv0Var4.p().equals(str3)) {
                    String str4 = x82.d;
                    if (str4.startsWith(jv0Var4.J()) || str4.startsWith(jv0Var4.F()) || str4.startsWith(jv0Var4.G()) || str4.startsWith(jv0Var4.I())) {
                        i = 2;
                    } else if (i2 < 24) {
                        jv0Var = F0;
                        if (!jv0Var.s().equals(str3) || jv0Var.t().equals(str3)) {
                            strF = jv0Var.f();
                            str = x82.b;
                            if (!strF.equals(str) || jv0Var.g().equals(str) || jv0Var.k().equals(str) || jv0Var.M().equals(str)) {
                                i = 1;
                            } else {
                                i = 0;
                            }
                        } else {
                            i = 0;
                        }
                    } else {
                        i = 0;
                    }
                } else if (i2 < 24) {
                    jv0Var = F0;
                    if (jv0Var.s().equals(str3)) {
                        strF = jv0Var.f();
                        str = x82.b;
                        if (strF.equals(str)) {
                        }
                        i = 1;
                    } else {
                        strF = jv0Var.f();
                        str = x82.b;
                        if (strF.equals(str)) {
                        }
                        i = 1;
                    }
                } else {
                    i = 0;
                }
            } else if (i2 < 24) {
                jv0Var = F0;
                if (jv0Var.s().equals(str3)) {
                    strF = jv0Var.f();
                    str = x82.b;
                    if (strF.equals(str)) {
                    }
                    i = 1;
                } else {
                    strF = jv0Var.f();
                    str = x82.b;
                    if (strF.equals(str)) {
                    }
                    i = 1;
                }
            } else {
                i = 0;
            }
            this.S = i;
            this.T = i2 < 21 && this.L.o.isEmpty() && F0.r().equals(str3);
            if (i2 < 18) {
                z = true;
            } else if (i2 == 18) {
                jv0 jv0Var5 = F0;
                if (jv0Var5.u().equals(str3) || jv0Var5.v().equals(str3)) {
                    z = true;
                } else {
                    if (i2 == 19) {
                        str2 = x82.d;
                        jv0Var3 = F0;
                        if (!str2.startsWith(jv0Var3.H()) && (jv0Var3.o().equals(str3) || jv0Var3.p().equals(str3))) {
                            z = true;
                        }
                    }
                    z = false;
                }
            } else {
                if (i2 == 19) {
                    str2 = x82.d;
                    jv0Var3 = F0;
                    if (!str2.startsWith(jv0Var3.H())) {
                    }
                }
                z = false;
            }
            this.U = z;
            this.V = i2 == 29 && F0.d().equals(str3);
            if (i2 > 23 || !F0.D().equals(str3)) {
                if (i2 <= 19) {
                    jv0 jv0Var6 = F0;
                    String strL = jv0Var6.l();
                    String str5 = x82.b;
                    z2 = (strL.equals(str5) || jv0Var6.L().equals(str5)) && (jv0Var6.y().equals(str3) || jv0Var6.z().equals(str3));
                }
            }
            this.W = z2;
            this.X = i2 == 21 && F0.C().equals(str3);
            if (i2 < 21) {
                jv0 jv0Var7 = F0;
                if (jv0Var7.w().equals(str3) && jv0Var7.K().equals(x82.c)) {
                    String str6 = x82.b;
                    if (str6.startsWith(jv0Var7.c()) || str6.startsWith(jv0Var7.j()) || str6.startsWith(jv0Var7.h()) || str6.startsWith(jv0Var7.i()) || str6.startsWith(jv0Var7.m()) || str6.startsWith(jv0Var7.n())) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                } else {
                    z3 = false;
                }
            } else {
                z3 = false;
            }
            this.Y = z3;
            this.Z = i2 <= 18 && this.L.z == 1 && F0.q().equals(str3);
            String str7 = gv0Var.f9037a;
            if ((i2 <= 25 && F0.E().equals(str7)) || (i2 <= 17 && F0.x().equals(str7))) {
                z4 = true;
            } else if (i2 <= 29) {
                jv0 jv0Var8 = F0;
                if (jv0Var8.A().equals(str7) || jv0Var8.B().equals(str7)) {
                    z4 = true;
                } else {
                    jv0Var2 = F0;
                    if ((!jv0Var2.b().equals(x82.c) && jv0Var2.a().equals(x82.d) && gv0Var.f) || G()) {
                        z4 = true;
                    }
                }
            } else {
                jv0Var2 = F0;
                z4 = !jv0Var2.b().equals(x82.c) ? false : false;
            }
            this.c0 = z4;
            this.K.getClass();
            if (F0.e().equals(gv0Var.f9037a)) {
                this.d0 = new pm();
            }
            if (getState() == 2) {
                this.e0 = SystemClock.elapsedRealtime() + 1000;
            }
            this.B0.f9677a++;
            a(str3, jElapsedRealtime2, jElapsedRealtime2 - jElapsedRealtime);
        } catch (Throwable th) {
            n52.a();
            throw th;
        }
    }

    @Override // com.yandex.mobile.ads.impl.rk, com.yandex.mobile.ads.impl.ro1
    public boolean a() {
        return this.x0;
    }

    /* JADX WARN: Code duplicated, block: B:33:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:34:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:37:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:38:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:56:0x00ef A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:62:0x0049 A[SYNTHETIC] */
    private void a(MediaCrypto mediaCrypto, boolean z) throws b {
        b bVar;
        String strA;
        b bVar2;
        if (this.P == null) {
            try {
                List<gv0> listA = a(z);
                ArrayDeque<gv0> arrayDeque = new ArrayDeque<>();
                this.P = arrayDeque;
                if (this.p) {
                    arrayDeque.addAll(listA);
                } else if (!listA.isEmpty()) {
                    this.P.add(listA.get(0));
                }
                this.Q = null;
            } catch (ov0.b e) {
                throw new b(-49998, this.B, e, z);
            }
        }
        if (!this.P.isEmpty()) {
            gv0 gv0VarPeekFirst = this.P.peekFirst();
            while (this.K == null) {
                gv0 gv0VarPeekFirst2 = this.P.peekFirst();
                if (!a(gv0VarPeekFirst2)) {
                    return;
                }
                try {
                    a(gv0VarPeekFirst2, mediaCrypto);
                } catch (Exception e2) {
                    if (gv0VarPeekFirst2 == gv0VarPeekFirst) {
                        try {
                            at0.d("MediaCodecRenderer", "Preferred decoder instantiation failed. Sleeping for 50ms then retrying.");
                            Thread.sleep(50L);
                            a(gv0VarPeekFirst2, mediaCrypto);
                        } catch (Exception e3) {
                            at0.b("MediaCodecRenderer", "Failed to initialize decoder: " + gv0VarPeekFirst2, e3);
                            this.P.removeFirst();
                            gc0 gc0Var = this.B;
                            String str = "Decoder init failed: " + gv0VarPeekFirst2.f9037a + ", " + gc0Var;
                            String str2 = gc0Var.m;
                            if (x82.f10629a >= 21) {
                                strA = b.a(e3);
                            } else {
                                strA = null;
                            }
                            bVar = new b(str, e3, str2, z, gv0VarPeekFirst2, strA);
                            a(bVar);
                            bVar2 = this.Q;
                            if (bVar2 == null) {
                                this.Q = bVar;
                            } else {
                                this.Q = new b(bVar2.getMessage(), bVar2.getCause(), bVar2.b, bVar2.c, bVar2.d, bVar2.e);
                            }
                            if (!this.P.isEmpty()) {
                                throw this.Q;
                            }
                        }
                    } else {
                        throw e2;
                    }
                    at0.b("MediaCodecRenderer", "Failed to initialize decoder: " + gv0VarPeekFirst2, e3);
                    this.P.removeFirst();
                    gc0 gc0Var2 = this.B;
                    String str3 = "Decoder init failed: " + gv0VarPeekFirst2.f9037a + ", " + gc0Var2;
                    String str4 = gc0Var2.m;
                    if (x82.f10629a >= 21) {
                        strA = b.a(e3);
                    } else {
                        strA = null;
                    }
                    bVar = new b(str3, e3, str4, z, gv0VarPeekFirst2, strA);
                    a(bVar);
                    bVar2 = this.Q;
                    if (bVar2 == null) {
                        this.Q = bVar;
                    } else {
                        this.Q = new b(bVar2.getMessage(), bVar2.getCause(), bVar2.b, bVar2.c, bVar2.d, bVar2.e);
                    }
                    if (!this.P.isEmpty()) {
                        throw this.Q;
                    }
                }
            }
            this.P = null;
            return;
        }
        throw new b(-49999, this.B, null, z);
    }

    @Override // com.yandex.mobile.ads.impl.rk
    protected void a(boolean z, boolean z2) throws j60 {
        this.B0 = new my();
    }

    /* JADX WARN: Code duplicated, block: B:82:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:97:0x0108  */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0072, code lost:
    
        if (r12 != false) goto L112;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected com.yandex.mobile.ads.impl.qy a(com.yandex.mobile.ads.impl.hc0 r12) throws com.yandex.mobile.ads.impl.j60 {
        /*
            Method dump skipped, instruction units count: 344
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yandex.mobile.ads.impl.iv0.a(com.yandex.mobile.ads.impl.hc0):com.yandex.mobile.ads.impl.qy");
    }

    @Override // com.yandex.mobile.ads.impl.rk
    protected void a(long j, boolean z) throws j60 {
        this.w0 = false;
        this.x0 = false;
        this.z0 = false;
        if (this.k0) {
            this.u.b();
            this.t.b();
            this.l0 = false;
        } else {
            C();
        }
        if (this.v.d() > 0) {
            this.y0 = true;
        }
        this.v.a();
        int i = this.E0;
        if (i != 0) {
            int i2 = i - 1;
            this.D0 = this.z[i2];
            this.C0 = this.y[i2];
            this.E0 = 0;
        }
    }

    @Override // com.yandex.mobile.ads.impl.rk
    protected final void a(gc0[] gc0VarArr, long j, long j2) throws j60 {
        if (this.D0 == -9223372036854775807L) {
            if (this.C0 == -9223372036854775807L) {
                this.C0 = j;
                this.D0 = j2;
                return;
            }
            throw new IllegalStateException();
        }
        int i = this.E0;
        if (i == this.z.length) {
            at0.d("MediaCodecRenderer", "Too many stream changes, so dropping offset: " + this.z[this.E0 - 1]);
        } else {
            this.E0 = i + 1;
        }
        long[] jArr = this.y;
        int i2 = this.E0 - 1;
        jArr[i2] = j;
        this.z[i2] = j2;
        this.A[i2] = this.u0;
    }

    @Override // com.yandex.mobile.ads.impl.ro1
    public final void a(long j, long j2) throws j60 {
        boolean z = false;
        if (this.z0) {
            this.z0 = false;
            M();
        }
        j60 j60Var = this.A0;
        if (j60Var == null) {
            try {
                if (this.x0) {
                    O();
                    return;
                }
                if (this.B != null || c(2)) {
                    K();
                    if (this.k0) {
                        n52.a("bypassRender");
                        while (b(j, j2)) {
                        }
                        n52.a();
                    } else if (this.K != null) {
                        long jElapsedRealtime = SystemClock.elapsedRealtime();
                        n52.a("drainAndFeed");
                        while (c(j, j2) && (this.H == -9223372036854775807L || SystemClock.elapsedRealtime() - jElapsedRealtime < this.H)) {
                        }
                        while (A() && (this.H == -9223372036854775807L || SystemClock.elapsedRealtime() - jElapsedRealtime < this.H)) {
                        }
                        n52.a();
                    } else {
                        this.B0.d += b(j);
                        c(1);
                    }
                    synchronized (this.B0) {
                    }
                    return;
                }
                return;
            } catch (IllegalStateException e) {
                int i = x82.f10629a;
                if (i < 21 || !(e instanceof MediaCodec.CodecException)) {
                    StackTraceElement[] stackTrace = e.getStackTrace();
                    if (stackTrace.length <= 0 || !stackTrace[0].getClassName().equals("android.media.MediaCodec")) {
                        throw e;
                    }
                }
                a(e);
                if (i >= 21 && (e instanceof MediaCodec.CodecException) && ((MediaCodec.CodecException) e).isRecoverable()) {
                    z = true;
                }
                if (z) {
                    N();
                }
                throw a(4003, this.B, a(e, this.R), z);
            }
        }
        this.A0 = null;
        throw j60Var;
    }

    protected final void a(j60 j60Var) {
        this.A0 = j60Var;
    }

    @Override // com.yandex.mobile.ads.impl.ro1
    public void a(float f, float f2) throws j60 {
        this.I = f;
        this.J = f2;
        c(this.L);
    }

    @Override // com.yandex.mobile.ads.impl.so1
    public final int a(gc0 gc0Var) throws j60 {
        try {
            return a(this.o, gc0Var);
        } catch (ov0.b e) {
            throw a(e, gc0Var, 4002);
        }
    }

    protected fv0 a(IllegalStateException illegalStateException, gv0 gv0Var) {
        return new fv0(illegalStateException, gv0Var);
    }
}
