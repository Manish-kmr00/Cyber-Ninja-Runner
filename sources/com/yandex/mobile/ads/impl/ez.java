package com.yandex.mobile.ads.impl;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.media.PlaybackParams;
import android.media.metrics.LogSessionId;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Pair;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.concurrent.Executor;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: loaded from: classes3.dex */
public final class ez implements vh {
    private int A;
    private long B;
    private long C;
    private long D;
    private long E;
    private int F;
    private boolean G;
    private boolean H;
    private long I;
    private float J;
    private th[] K;
    private ByteBuffer[] L;
    private ByteBuffer M;
    private int N;
    private ByteBuffer O;
    private byte[] P;
    private int Q;
    private int R;
    private boolean S;
    private boolean T;
    private boolean U;
    private boolean V;
    private int W;
    private ii X;
    private boolean Y;
    private long Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final qh f8843a;
    private boolean a0;
    private final c b;
    private boolean b0;
    private final boolean c;
    private final go d;
    private final a72 e;
    private final th[] f;
    private final th[] g;
    private final gr h;
    private final yh i;
    private final ArrayDeque<i> j;
    private final boolean k;
    private final int l;
    private l m;
    private final j<vh.b> n;
    private final j<vh.e> o;
    private final fz p;
    private ii1 q;
    private vh.c r;
    private f s;
    private f t;
    private AudioTrack u;
    private oh v;
    private i w;
    private i x;
    private xh1 y;
    private ByteBuffer z;

    final class a extends Thread {
        final /* synthetic */ AudioTrack b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(AudioTrack audioTrack) {
            super("ExoPlayer:AudioTrackReleaseThread");
            this.b = audioTrack;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            try {
                this.b.flush();
                this.b.release();
            } finally {
                ez.this.h.e();
            }
        }
    }

    public interface c {
    }

    interface d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final fz f8844a = new fz(new fz.a());
    }

    public static final class e {
        private g b;
        private boolean c;
        private boolean d;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private qh f8845a = qh.d;
        private int e = 0;
        fz f = d.f8844a;

        public final e b() {
            this.d = false;
            return this;
        }

        public final e c() {
            this.c = false;
            return this;
        }

        public final e d() {
            this.e = 0;
            return this;
        }

        public final ez a() {
            if (this.b == null) {
                this.b = new g(new th[0], new cy1(0), new g12());
            }
            return new ez(this);
        }

        public final e a(qh qhVar) {
            qhVar.getClass();
            this.f8845a = qhVar;
            return this;
        }
    }

    public static final class h extends RuntimeException {
    }

    private static final class j<T extends Exception> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private T f8849a;
        private long b;
    }

    @Override // com.yandex.mobile.ads.impl.vh
    public final void c() {
        if (x82.f10629a < 21) {
            throw new IllegalStateException();
        }
        if (!this.V) {
            throw new IllegalStateException();
        }
        if (this.Y) {
            return;
        }
        this.Y = true;
        flush();
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0049  */
    /* JADX WARN: Code duplicated, block: B:27:0x0082  */
    private void a(long j2) {
        xh1 xh1Var;
        boolean z;
        if (this.Y || !"audio/raw".equals(this.t.f8846a.m)) {
            xh1Var = xh1.e;
        } else {
            int i2 = this.t.f8846a.B;
            if (this.c) {
                int i3 = x82.f10629a;
                if (i2 == 536870912 || i2 == 805306368 || i2 == 4) {
                    xh1Var = xh1.e;
                }
            }
            c cVar = this.b;
            xh1Var = i().f8848a;
            g gVar = (g) cVar;
            gVar.c.b(xh1Var.b);
            gVar.c.a(xh1Var.c);
        }
        xh1 xh1Var2 = xh1Var;
        int i4 = 0;
        if (this.Y || !"audio/raw".equals(this.t.f8846a.m)) {
            z = false;
        } else {
            int i5 = this.t.f8846a.B;
            if (this.c) {
                int i6 = x82.f10629a;
                if (i5 == 536870912 || i5 == 805306368 || i5 == 4) {
                    z = false;
                }
            }
            c cVar2 = this.b;
            z = i().b;
            ((g) cVar2).b.a(z);
        }
        this.j.add(new i(xh1Var2, z, Math.max(0L, j2), (j() * 1000000) / ((long) this.t.e)));
        th[] thVarArr = this.t.i;
        ArrayList arrayList = new ArrayList();
        for (th thVar : thVarArr) {
            if (thVar.isActive()) {
                arrayList.add(thVar);
            } else {
                thVar.flush();
            }
        }
        int size = arrayList.size();
        this.K = (th[]) arrayList.toArray(new th[size]);
        this.L = new ByteBuffer[size];
        while (true) {
            th[] thVarArr2 = this.K;
            if (i4 >= thVarArr2.length) {
                break;
            }
            th thVar2 = thVarArr2[i4];
            thVar2.flush();
            this.L[i4] = thVar2.c();
            i4++;
        }
        vh.c cVar3 = this.r;
        if (cVar3 != null) {
            ((dv0.a) cVar3).a(z);
        }
    }

    @Override // com.yandex.mobile.ads.impl.vh
    public final void a(gc0 gc0Var, int[] iArr) throws vh.a {
        th[] thVarArr;
        int i2;
        int i3;
        int iIntValue;
        int iIntValue2;
        int i4;
        int iB;
        int i5;
        int iMax;
        int i6;
        th[] thVarArr2;
        int i7;
        int i8;
        th[] thVarArr3;
        int[] iArr2;
        if ("audio/raw".equals(gc0Var.m)) {
            if (x82.e(gc0Var.B)) {
                int iB2 = x82.b(gc0Var.B, gc0Var.z);
                int i9 = gc0Var.B;
                if (this.c && (i9 == 536870912 || i9 == 805306368 || i9 == 4)) {
                    thVarArr3 = this.g;
                } else {
                    thVarArr3 = this.f;
                }
                this.e.a(gc0Var.C, gc0Var.D);
                if (x82.f10629a < 21 && gc0Var.z == 8 && iArr == null) {
                    iArr2 = new int[6];
                    for (int i10 = 0; i10 < 6; i10++) {
                        iArr2[i10] = i10;
                    }
                } else {
                    iArr2 = iArr;
                }
                this.d.a(iArr2);
                th.a aVar = new th.a(gc0Var.A, gc0Var.z, gc0Var.B);
                for (th thVar : thVarArr3) {
                    try {
                        th.a aVarA = thVar.a(aVar);
                        if (thVar.isActive()) {
                            aVar = aVarA;
                        }
                    } catch (th.b e2) {
                        throw new vh.a(e2, gc0Var);
                    }
                }
                int i11 = aVar.c;
                int i12 = aVar.f10300a;
                int iA = x82.a(aVar.b);
                thVarArr = thVarArr3;
                iB = x82.b(i11, aVar.b);
                i4 = i12;
                iIntValue2 = iA;
                iIntValue = i11;
                i2 = iB2;
                i3 = 0;
            } else {
                throw new IllegalArgumentException();
            }
        } else {
            thVarArr = new th[0];
            int i13 = gc0Var.A;
            i2 = -1;
            if (a(gc0Var, this.v)) {
                String str = gc0Var.m;
                str.getClass();
                int iB3 = s01.b(str, gc0Var.j);
                iIntValue2 = x82.a(gc0Var.z);
                i3 = 1;
                iIntValue = iB3;
            } else {
                Pair<Integer, Integer> pairA = this.f8843a.a(gc0Var);
                if (pairA != null) {
                    i3 = 2;
                    iIntValue = ((Integer) pairA.first).intValue();
                    iIntValue2 = ((Integer) pairA.second).intValue();
                } else {
                    throw new vh.a("Unable to configure passthrough for: " + gc0Var, gc0Var);
                }
            }
            i4 = i13;
            iB = -1;
        }
        fz fzVar = this.p;
        int minBufferSize = AudioTrack.getMinBufferSize(i4, iIntValue2, iIntValue);
        if (minBufferSize != -2) {
            double d2 = this.k ? 8.0d : 1.0d;
            fzVar.getClass();
            if (i3 == 0) {
                long j2 = i4;
                long j3 = iB;
                int iA2 = dq0.a(((((long) 250000) * j2) * j3) / 1000000);
                i5 = i2;
                int iA3 = dq0.a(((((long) 750000) * j2) * j3) / 1000000);
                int i14 = x82.f10629a;
                iMax = Math.max(iA2, Math.min(minBufferSize * 4, iA3));
            } else if (i3 == 1) {
                switch (iIntValue) {
                    case 5:
                        i7 = 80000;
                        break;
                    case 6:
                    case 18:
                        i7 = 768000;
                        break;
                    case 7:
                        i7 = 192000;
                        break;
                    case 8:
                        i7 = 2250000;
                        break;
                    case 9:
                        i7 = 40000;
                        break;
                    case 10:
                        i7 = 100000;
                        break;
                    case 11:
                        i7 = 16000;
                        break;
                    case 12:
                        i7 = 7000;
                        break;
                    case 13:
                    default:
                        throw new IllegalArgumentException();
                    case 14:
                        i7 = 3062500;
                        break;
                    case 15:
                        i7 = 8000;
                        break;
                    case 16:
                        i7 = 256000;
                        break;
                    case 17:
                        i7 = 336000;
                        break;
                }
                iMax = dq0.a((((long) 50000000) * ((long) i7)) / 1000000);
                i5 = i2;
            } else if (i3 == 2) {
                int i15 = iIntValue == 5 ? 500000 : 250000;
                switch (iIntValue) {
                    case 5:
                        i8 = 80000;
                        break;
                    case 6:
                    case 18:
                        i8 = 768000;
                        break;
                    case 7:
                        i8 = 192000;
                        break;
                    case 8:
                        i8 = 2250000;
                        break;
                    case 9:
                        i8 = 40000;
                        break;
                    case 10:
                        i8 = 100000;
                        break;
                    case 11:
                        i8 = 16000;
                        break;
                    case 12:
                        i8 = 7000;
                        break;
                    case 13:
                    default:
                        throw new IllegalArgumentException();
                    case 14:
                        i8 = 3062500;
                        break;
                    case 15:
                        i8 = 8000;
                        break;
                    case 16:
                        i8 = 256000;
                        break;
                    case 17:
                        i8 = 336000;
                        break;
                }
                iMax = dq0.a((((long) i15) * ((long) i8)) / 1000000);
                i5 = i2;
            } else {
                throw new IllegalArgumentException();
            }
            int iMax2 = (((Math.max(minBufferSize, (int) (((double) iMax) * d2)) + iB) - 1) / iB) * iB;
            if (iIntValue == 0) {
                throw new vh.a("Invalid output encoding (mode=" + i3 + ") for: " + gc0Var, gc0Var);
            }
            if (iIntValue2 != 0) {
                this.a0 = false;
                f fVar = new f(gc0Var, i5, i3, iB, i6, iIntValue2, iIntValue, iMax2, thVarArr2);
                if (l()) {
                    i6 = i4;
                    thVarArr2 = thVarArr;
                    this.s = fVar;
                    return;
                } else {
                    i6 = i4;
                    thVarArr2 = thVarArr;
                    this.t = fVar;
                    return;
                }
            }
            throw new vh.a("Invalid output channel config (mode=" + i3 + ") for: " + gc0Var, gc0Var);
        }
        throw new IllegalStateException();
    }

    public static class g implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final th[] f8847a;
        private final cy1 b;
        private final g12 c;

        public g(th[] thVarArr, cy1 cy1Var, g12 g12Var) {
            th[] thVarArr2 = new th[thVarArr.length + 2];
            this.f8847a = thVarArr2;
            System.arraycopy(thVarArr, 0, thVarArr2, 0, thVarArr.length);
            this.b = cy1Var;
            this.c = g12Var;
            thVarArr2[thVarArr.length] = cy1Var;
            thVarArr2[thVarArr.length + 1] = g12Var;
        }

        public final th[] a() {
            return this.f8847a;
        }
    }

    @RequiresNonNull({"#1.audioProcessorChain"})
    private ez(e eVar) {
        this.f8843a = eVar.f8845a;
        g gVar = eVar.b;
        this.b = gVar;
        int i2 = x82.f10629a;
        this.c = i2 >= 21 && eVar.c;
        this.k = i2 >= 23 && eVar.d;
        this.l = i2 >= 29 ? eVar.e : 0;
        this.p = eVar.f;
        gr grVar = new gr(0);
        this.h = grVar;
        grVar.e();
        this.i = new yh(new k());
        go goVar = new go();
        this.d = goVar;
        a72 a72Var = new a72();
        this.e = a72Var;
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, new mq1(), goVar, a72Var);
        Collections.addAll(arrayList, gVar.a());
        this.f = (th[]) arrayList.toArray(new th[0]);
        this.g = new th[]{new zb0()};
        this.J = 1.0f;
        this.v = oh.h;
        this.W = 0;
        this.X = new ii();
        xh1 xh1Var = xh1.e;
        this.x = new i(xh1Var, false, 0L, 0L);
        this.y = xh1Var;
        this.R = -1;
        this.K = new th[0];
        this.L = new ByteBuffer[0];
        this.j = new ArrayDeque<>();
        this.n = new j<>();
        this.o = new j<>();
    }

    @Override // com.yandex.mobile.ads.impl.vh
    public final int b(gc0 gc0Var) {
        if (!"audio/raw".equals(gc0Var.m)) {
            return ((this.a0 || !a(gc0Var, this.v)) && this.f8843a.a(gc0Var) == null) ? 0 : 2;
        }
        if (!x82.e(gc0Var.B)) {
            at0.d("DefaultAudioSink", "Invalid PCM encoding: " + gc0Var.B);
            return 0;
        }
        int i2 = gc0Var.B;
        return (i2 == 2 || (this.c && i2 == 4)) ? 2 : 1;
    }

    @Override // com.yandex.mobile.ads.impl.vh
    public final long a(boolean z) {
        long jA;
        if (!l() || this.H) {
            return Long.MIN_VALUE;
        }
        long jMin = Math.min(this.i.a(z), (j() * 1000000) / ((long) this.t.e));
        while (!this.j.isEmpty() && jMin >= this.j.getFirst().d) {
            this.x = this.j.remove();
        }
        i iVar = this.x;
        long j2 = jMin - iVar.d;
        if (iVar.f8848a.equals(xh1.e)) {
            jA = this.x.c + j2;
        } else if (this.j.isEmpty()) {
            jA = ((g) this.b).c.a(j2) + this.x.c;
        } else {
            i first = this.j.getFirst();
            long jRound = first.d - jMin;
            float f2 = this.x.f8848a.b;
            int i2 = x82.f10629a;
            if (f2 != 1.0f) {
                jRound = Math.round(jRound * ((double) f2));
            }
            jA = first.c - jRound;
        }
        return ((((g) this.b).b.i() * 1000000) / ((long) this.t.e)) + jA;
    }

    /* JADX WARN: Code duplicated, block: B:58:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:65:? A[SYNTHETIC] */
    private boolean k() throws vh.b {
        AudioTrack audioTrackA;
        ii1 ii1Var;
        if (!this.h.d()) {
            return false;
        }
        try {
            f fVar = this.t;
            fVar.getClass();
            try {
                audioTrackA = fVar.a(this.Y, this.v, this.W);
            } catch (vh.b e2) {
                vh.c cVar = this.r;
                if (cVar != null) {
                    ((dv0.a) cVar).a(e2);
                }
                throw e2;
            }
        } catch (vh.b e3) {
            f fVar2 = this.t;
            if (fVar2.h > 1000000) {
                f fVar3 = new f(fVar2.f8846a, fVar2.b, fVar2.c, fVar2.d, fVar2.e, fVar2.f, fVar2.g, 1000000, fVar2.i);
                try {
                    try {
                        audioTrackA = fVar3.a(this.Y, this.v, this.W);
                        this.t = fVar3;
                    } catch (vh.b e4) {
                        e3.addSuppressed(e4);
                        if (this.t.c == 1) {
                            this.a0 = true;
                            throw e3;
                        }
                        throw e3;
                    }
                } catch (vh.b e5) {
                    vh.c cVar2 = this.r;
                    if (cVar2 != null) {
                        ((dv0.a) cVar2).a(e5);
                    }
                    throw e5;
                }
            }
            if (this.t.c == 1) {
                this.a0 = true;
                throw e3;
            }
            throw e3;
        }
        this.u = audioTrackA;
        if (a(audioTrackA)) {
            AudioTrack audioTrack = this.u;
            if (this.m == null) {
                this.m = new l();
            }
            this.m.a(audioTrack);
            if (this.l != 3) {
                AudioTrack audioTrack2 = this.u;
                gc0 gc0Var = this.t.f8846a;
                audioTrack2.setOffloadDelayPadding(gc0Var.C, gc0Var.D);
            }
        }
        int i2 = x82.f10629a;
        if (i2 >= 31 && (ii1Var = this.q) != null) {
            b.a(this.u, ii1Var);
        }
        this.W = this.u.getAudioSessionId();
        yh yhVar = this.i;
        AudioTrack audioTrack3 = this.u;
        f fVar4 = this.t;
        yhVar.a(audioTrack3, fVar4.c == 2, fVar4.g, fVar4.d, fVar4.h);
        if (l()) {
            if (i2 >= 21) {
                this.u.setVolume(this.J);
            } else {
                AudioTrack audioTrack4 = this.u;
                float f2 = this.J;
                audioTrack4.setStereoVolume(f2, f2);
            }
        }
        int i3 = this.X.f9222a;
        if (i3 != 0) {
            this.u.attachAuxEffect(i3);
            this.u.setAuxEffectSendLevel(this.X.b);
        }
        this.H = true;
        return true;
    }

    @Override // com.yandex.mobile.ads.impl.vh
    public final void play() {
        this.U = true;
        if (l()) {
            this.i.e();
            this.u.play();
        }
    }

    @Override // com.yandex.mobile.ads.impl.vh
    public final void g() {
        this.G = true;
    }

    @Override // com.yandex.mobile.ads.impl.vh
    public final void d() throws vh.e {
        if (!this.S && l() && h()) {
            if (!this.T) {
                this.T = true;
                this.i.c(j());
                this.u.stop();
                this.A = 0;
            }
            this.S = true;
        }
    }

    /* JADX WARN: Code duplicated, block: B:11:0x001c  */
    /* JADX WARN: Code duplicated, block: B:14:0x0028 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:15:0x0029  */
    /* JADX WARN: Code duplicated, block: B:9:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0029 -> B:5:0x0009). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private boolean h() throws com.yandex.mobile.ads.impl.vh.e {
        /*
            r9 = this;
            int r0 = r9.R
            r1 = 1
            r2 = 0
            r3 = -1
            if (r0 != r3) goto Lb
            r9.R = r2
        L9:
            r0 = r1
            goto Lc
        Lb:
            r0 = r2
        Lc:
            int r4 = r9.R
            com.yandex.mobile.ads.impl.th[] r5 = r9.K
            int r6 = r5.length
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r4 >= r6) goto L2f
            r4 = r5[r4]
            if (r0 == 0) goto L1f
            r4.d()
        L1f:
            r9.b(r7)
            boolean r0 = r4.a()
            if (r0 != 0) goto L29
            return r2
        L29:
            int r0 = r9.R
            int r0 = r0 + r1
            r9.R = r0
            goto L9
        L2f:
            java.nio.ByteBuffer r0 = r9.O
            if (r0 == 0) goto L3b
            r9.a(r0, r7)
            java.nio.ByteBuffer r0 = r9.O
            if (r0 == 0) goto L3b
            return r2
        L3b:
            r9.R = r3
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yandex.mobile.ads.impl.ez.h():boolean");
    }

    @Override // com.yandex.mobile.ads.impl.vh
    public final boolean e() {
        return l() && this.i.d(j());
    }

    @Override // com.yandex.mobile.ads.impl.vh
    public final xh1 getPlaybackParameters() {
        if (this.k) {
            return this.y;
        }
        return i().f8848a;
    }

    @Override // com.yandex.mobile.ads.impl.vh
    public final void f() {
        if (this.Y) {
            this.Y = false;
            flush();
        }
    }

    @Override // com.yandex.mobile.ads.impl.vh
    public final void setVolume(float f2) {
        if (this.J != f2) {
            this.J = f2;
            if (l()) {
                if (x82.f10629a >= 21) {
                    this.u.setVolume(this.J);
                    return;
                }
                AudioTrack audioTrack = this.u;
                float f3 = this.J;
                audioTrack.setStereoVolume(f3, f3);
            }
        }
    }

    @Override // com.yandex.mobile.ads.impl.vh
    public final void pause() {
        this.U = false;
        if (l() && this.i.c()) {
            this.u.pause();
        }
    }

    @Override // com.yandex.mobile.ads.impl.vh
    public final void flush() {
        if (l()) {
            m();
            if (this.i.b()) {
                this.u.pause();
            }
            if (a(this.u)) {
                l lVar = this.m;
                lVar.getClass();
                lVar.b(this.u);
            }
            AudioTrack audioTrack = this.u;
            this.u = null;
            if (x82.f10629a < 21 && !this.V) {
                this.W = 0;
            }
            f fVar = this.s;
            if (fVar != null) {
                this.t = fVar;
                this.s = null;
            }
            this.i.d();
            this.h.c();
            new a(audioTrack).start();
        }
        ((j) this.o).f8849a = null;
        ((j) this.n).f8849a = null;
    }

    private void m() {
        this.B = 0L;
        this.C = 0L;
        this.D = 0L;
        this.E = 0L;
        int i2 = 0;
        this.b0 = false;
        this.F = 0;
        this.x = new i(i().f8848a, i().b, 0L, 0L);
        this.I = 0L;
        this.w = null;
        this.j.clear();
        this.M = null;
        this.N = 0;
        this.O = null;
        this.T = false;
        this.S = false;
        this.R = -1;
        this.z = null;
        this.A = 0;
        this.e.j();
        while (true) {
            th[] thVarArr = this.K;
            if (i2 >= thVarArr.length) {
                return;
            }
            th thVar = thVarArr[i2];
            thVar.flush();
            this.L[i2] = thVar.c();
            i2++;
        }
    }

    private i i() {
        i iVar = this.w;
        if (iVar != null) {
            return iVar;
        }
        if (!this.j.isEmpty()) {
            return this.j.getLast();
        }
        return this.x;
    }

    private boolean l() {
        return this.u != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long j() {
        f fVar = this.t;
        if (fVar.c == 0) {
            return this.D / ((long) fVar.d);
        }
        return this.E;
    }

    private void b(long j2) throws Exception {
        ByteBuffer byteBuffer;
        int length = this.K.length;
        int i2 = length;
        while (i2 >= 0) {
            if (i2 > 0) {
                byteBuffer = this.L[i2 - 1];
            } else {
                byteBuffer = this.M;
                if (byteBuffer == null) {
                    byteBuffer = th.f10299a;
                }
            }
            if (i2 == length) {
                a(byteBuffer, j2);
            } else {
                th thVar = this.K[i2];
                if (i2 > this.R) {
                    thVar.a(byteBuffer);
                }
                ByteBuffer byteBufferC = thVar.c();
                this.L[i2] = byteBufferC;
                if (byteBufferC.hasRemaining()) {
                    i2++;
                }
            }
            if (byteBuffer.hasRemaining()) {
                return;
            } else {
                i2--;
            }
        }
    }

    @Override // com.yandex.mobile.ads.impl.vh
    public final boolean a(ByteBuffer byteBuffer, long j2, int i2) throws Exception {
        long j3;
        int iA;
        int i3;
        byte b2;
        int i4;
        byte b3;
        int i5;
        ByteBuffer byteBuffer2 = this.M;
        if (byteBuffer2 != null && byteBuffer != byteBuffer2) {
            throw new IllegalArgumentException();
        }
        if (this.s != null) {
            if (!h()) {
                return false;
            }
            f fVar = this.s;
            f fVar2 = this.t;
            fVar.getClass();
            if (fVar2.c == fVar.c && fVar2.g == fVar.g && fVar2.e == fVar.e && fVar2.f == fVar.f && fVar2.d == fVar.d) {
                this.t = this.s;
                this.s = null;
                if (a(this.u) && this.l != 3) {
                    if (this.u.getPlayState() == 3) {
                        this.u.setOffloadEndOfStream();
                    }
                    AudioTrack audioTrack = this.u;
                    gc0 gc0Var = this.t.f8846a;
                    audioTrack.setOffloadDelayPadding(gc0Var.C, gc0Var.D);
                    this.b0 = true;
                }
            } else {
                if (!this.T) {
                    this.T = true;
                    this.i.c(j());
                    this.u.stop();
                    this.A = 0;
                }
                if (e()) {
                    return false;
                }
                flush();
            }
            a(j2);
        }
        if (!l()) {
            try {
                if (!k()) {
                    return false;
                }
            } catch (vh.b e2) {
                if (!e2.c) {
                    j<vh.b> jVar = this.n;
                    jVar.getClass();
                    long jElapsedRealtime = SystemClock.elapsedRealtime();
                    if (((j) jVar).f8849a == null) {
                        ((j) jVar).f8849a = e2;
                        ((j) jVar).b = 100 + jElapsedRealtime;
                    }
                    if (jElapsedRealtime < ((j) jVar).b) {
                        return false;
                    }
                    Exception exc = ((j) jVar).f8849a;
                    if (exc != e2) {
                        exc.addSuppressed(e2);
                    }
                    Exception exc2 = ((j) jVar).f8849a;
                    ((j) jVar).f8849a = null;
                    throw exc2;
                }
                throw e2;
            }
        }
        ((j) this.n).f8849a = null;
        if (this.H) {
            this.I = Math.max(0L, j2);
            this.G = false;
            this.H = false;
            if (this.k && x82.f10629a >= 23) {
                b(this.y);
            }
            a(j2);
            if (this.U) {
                play();
            }
        }
        if (!this.i.f(j())) {
            return false;
        }
        if (this.M == null) {
            if (byteBuffer.order() == ByteOrder.LITTLE_ENDIAN) {
                if (!byteBuffer.hasRemaining()) {
                    return true;
                }
                f fVar3 = this.t;
                if (fVar3.c != 0 && this.F == 0) {
                    int i6 = fVar3.g;
                    switch (i6) {
                        case 5:
                        case 6:
                        case 18:
                            iA = t.a(byteBuffer);
                            break;
                        case 7:
                        case 8:
                            int iPosition = byteBuffer.position();
                            byte b4 = byteBuffer.get(iPosition);
                            if (b4 != -2) {
                                if (b4 == -1) {
                                    i3 = (byteBuffer.get(iPosition + 4) & 7) << 4;
                                    b3 = byteBuffer.get(iPosition + 7);
                                } else if (b4 != 31) {
                                    i3 = (byteBuffer.get(iPosition + 4) & 1) << 6;
                                    b2 = byteBuffer.get(iPosition + 5);
                                } else {
                                    i3 = (byteBuffer.get(iPosition + 5) & 7) << 4;
                                    b3 = byteBuffer.get(iPosition + 6);
                                }
                                i4 = b3 & 60;
                                iA = (((i4 >> 2) | i3) + 1) * 32;
                            } else {
                                i3 = (byteBuffer.get(iPosition + 5) & 1) << 6;
                                b2 = byteBuffer.get(iPosition + 4);
                            }
                            i4 = b2 & 252;
                            iA = (((i4 >> 2) | i3) + 1) * 32;
                            break;
                        case 9:
                            int iPosition2 = byteBuffer.position();
                            int i7 = x82.f10629a;
                            int iReverseBytes = byteBuffer.getInt(iPosition2);
                            if (byteBuffer.order() != ByteOrder.BIG_ENDIAN) {
                                iReverseBytes = Integer.reverseBytes(iReverseBytes);
                            }
                            iA = b21.b(iReverseBytes);
                            if (iA == -1) {
                                throw new IllegalArgumentException();
                            }
                            break;
                        case 10:
                        case 16:
                            iA = 1024;
                            break;
                        case 11:
                        case 12:
                            iA = 2048;
                            break;
                        case 13:
                        default:
                            throw new IllegalStateException(oe.a("Unexpected audio encoding: ", i6));
                        case 14:
                            int iPosition3 = byteBuffer.position();
                            int iLimit = byteBuffer.limit() - 10;
                            int i8 = iPosition3;
                            while (true) {
                                if (i8 <= iLimit) {
                                    int i9 = x82.f10629a;
                                    int iReverseBytes2 = byteBuffer.getInt(i8 + 4);
                                    if (byteBuffer.order() != ByteOrder.BIG_ENDIAN) {
                                        iReverseBytes2 = Integer.reverseBytes(iReverseBytes2);
                                    }
                                    if ((iReverseBytes2 & (-2)) == -126718022) {
                                        i5 = i8 - iPosition3;
                                    } else {
                                        i8++;
                                    }
                                } else {
                                    i5 = -1;
                                }
                            }
                            if (i5 != -1) {
                                iA = (40 << ((byteBuffer.get((byteBuffer.position() + i5) + ((byteBuffer.get((byteBuffer.position() + i5) + 7) & 255) == 187 ? 9 : 8)) >> 4) & 7)) * 16;
                            } else {
                                iA = 0;
                            }
                            break;
                        case 15:
                            iA = 512;
                            break;
                        case 17:
                            byte[] bArr = new byte[16];
                            int iPosition4 = byteBuffer.position();
                            byteBuffer.get(bArr);
                            byteBuffer.position(iPosition4);
                            iA = w.a(new vf1(16, bArr)).c;
                            break;
                    }
                    this.F = iA;
                    if (iA == 0) {
                        return true;
                    }
                }
                if (this.w != null) {
                    if (!h()) {
                        return false;
                    }
                    a(j2);
                    this.w = null;
                }
                long j4 = this.I;
                f fVar4 = this.t;
                if (fVar4.c == 0) {
                    j3 = this.B / ((long) fVar4.b);
                } else {
                    j3 = this.C;
                }
                long jI = (((j3 - this.e.i()) * 1000000) / ((long) fVar4.f8846a.A)) + j4;
                if (!this.G && Math.abs(jI - j2) > 200000) {
                    ((dv0.a) this.r).a(new vh.d(j2, jI));
                    this.G = true;
                }
                if (this.G) {
                    if (!h()) {
                        return false;
                    }
                    long j5 = j2 - jI;
                    this.I += j5;
                    this.G = false;
                    a(j2);
                    vh.c cVar = this.r;
                    if (cVar != null && j5 != 0) {
                        ((dv0.a) cVar).c();
                    }
                }
                if (this.t.c == 0) {
                    this.B += (long) byteBuffer.remaining();
                } else {
                    this.C = (((long) this.F) * ((long) i2)) + this.C;
                }
                this.M = byteBuffer;
                this.N = i2;
            } else {
                throw new IllegalArgumentException();
            }
        }
        b(j2);
        if (!this.M.hasRemaining()) {
            this.M = null;
            this.N = 0;
            return true;
        }
        if (!this.i.e(j())) {
            return false;
        }
        at0.d("DefaultAudioSink", "Resetting stalled audio track");
        flush();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    final class l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Handler f8851a = new Handler();
        private final AudioTrack.StreamEventCallback b = new a();

        final class a extends AudioTrack.StreamEventCallback {
            a() {
            }

            @Override // android.media.AudioTrack.StreamEventCallback
            public final void onDataRequest(AudioTrack audioTrack, int i) {
                ez ezVar = ez.this;
                if (audioTrack == ezVar.u) {
                    vh.c cVar = ezVar.r;
                    if (cVar == null || !ezVar.U) {
                        return;
                    }
                    ((dv0.a) cVar).a();
                    return;
                }
                throw new IllegalStateException();
            }

            @Override // android.media.AudioTrack.StreamEventCallback
            public final void onTearDown(AudioTrack audioTrack) {
                ez ezVar = ez.this;
                if (audioTrack == ezVar.u) {
                    vh.c cVar = ezVar.r;
                    if (cVar == null || !ezVar.U) {
                        return;
                    }
                    ((dv0.a) cVar).a();
                    return;
                }
                throw new IllegalStateException();
            }
        }

        public l() {
        }

        public final void a(AudioTrack audioTrack) {
            final Handler handler = this.f8851a;
            Objects.requireNonNull(handler);
            audioTrack.registerStreamEventCallback(new Executor() { // from class: com.yandex.mobile.ads.impl.ez$l$$ExternalSyntheticLambda0
                @Override // java.util.concurrent.Executor
                public final void execute(Runnable runnable) {
                    handler.post(runnable);
                }
            }, this.b);
        }

        public final void b(AudioTrack audioTrack) {
            audioTrack.unregisterStreamEventCallback(this.b);
            this.f8851a.removeCallbacksAndMessages(null);
        }
    }

    private static final class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final xh1 f8848a;
        public final boolean b;
        public final long c;
        public final long d;

        private i(xh1 xh1Var, boolean z, long j, long j2) {
            this.f8848a = xh1Var;
            this.b = z;
            this.c = j;
            this.d = j2;
        }
    }

    private final class k implements yh.a {
        private k() {
        }

        @Override // com.yandex.mobile.ads.impl.yh.a
        public final void b(long j, long j2, long j3, long j4) {
            long j5;
            StringBuilder sbAppend = new StringBuilder("Spurious audio timestamp (system clock mismatch): ").append(j).append(", ").append(j2).append(", ").append(j3).append(", ").append(j4).append(", ");
            ez ezVar = ez.this;
            f fVar = ezVar.t;
            if (fVar.c == 0) {
                j5 = ezVar.B / ((long) fVar.b);
            } else {
                j5 = ezVar.C;
            }
            at0.d("DefaultAudioSink", sbAppend.append(j5).append(", ").append(ez.this.j()).toString());
        }

        @Override // com.yandex.mobile.ads.impl.yh.a
        public final void b(long j) {
            at0.d("DefaultAudioSink", "Ignoring impossibly large audio latency: " + j);
        }

        @Override // com.yandex.mobile.ads.impl.yh.a
        public final void a(long j) {
            vh.c cVar = ez.this.r;
            if (cVar != null) {
                ((dv0.a) cVar).a(j);
            }
        }

        @Override // com.yandex.mobile.ads.impl.yh.a
        public final void a(long j, long j2, long j3, long j4) {
            long j5;
            StringBuilder sbAppend = new StringBuilder("Spurious audio timestamp (frame position mismatch): ").append(j).append(", ").append(j2).append(", ").append(j3).append(", ").append(j4).append(", ");
            ez ezVar = ez.this;
            f fVar = ezVar.t;
            if (fVar.c == 0) {
                j5 = ezVar.B / ((long) fVar.b);
            } else {
                j5 = ezVar.C;
            }
            at0.d("DefaultAudioSink", sbAppend.append(j5).append(", ").append(ez.this.j()).toString());
        }

        @Override // com.yandex.mobile.ads.impl.yh.a
        public final void a(int i, long j) {
            if (ez.this.r != null) {
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                ez ezVar = ez.this;
                ((dv0.a) ezVar.r).a(i, j, jElapsedRealtime - ezVar.Z);
            }
        }
    }

    private static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final gc0 f8846a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;
        public final int f;
        public final int g;
        public final int h;
        public final th[] i;

        private AudioTrack b(boolean z, oh ohVar, int i) {
            int i2 = x82.f10629a;
            if (i2 >= 29) {
                return new AudioTrack.Builder().setAudioAttributes(z ? new AudioAttributes.Builder().setContentType(3).setFlags(16).setUsage(1).build() : ohVar.a().f9816a).setAudioFormat(new AudioFormat.Builder().setSampleRate(this.e).setChannelMask(this.f).setEncoding(this.g).build()).setTransferMode(1).setBufferSizeInBytes(this.h).setSessionId(i).setOffloadedPlayback(this.c == 1).build();
            }
            if (i2 < 21) {
                int iC = x82.c(ohVar.d);
                return i == 0 ? new AudioTrack(iC, this.e, this.f, this.g, this.h, 1) : new AudioTrack(iC, this.e, this.f, this.g, this.h, 1, i);
            }
            return new AudioTrack(z ? new AudioAttributes.Builder().setContentType(3).setFlags(16).setUsage(1).build() : ohVar.a().f9816a, new AudioFormat.Builder().setSampleRate(this.e).setChannelMask(this.f).setEncoding(this.g).build(), this.h, 1, i);
        }

        public f(gc0 gc0Var, int i, int i2, int i3, int i4, int i5, int i6, int i7, th[] thVarArr) {
            this.f8846a = gc0Var;
            this.b = i;
            this.c = i2;
            this.d = i3;
            this.e = i4;
            this.f = i5;
            this.g = i6;
            this.h = i7;
            this.i = thVarArr;
        }

        public final AudioTrack a(boolean z, oh ohVar, int i) throws vh.b {
            try {
                AudioTrack audioTrackB = b(z, ohVar, i);
                int state = audioTrackB.getState();
                if (state == 1) {
                    return audioTrackB;
                }
                try {
                    audioTrackB.release();
                } catch (Exception unused) {
                }
                throw new vh.b(state, this.e, this.f, this.h, this.f8846a, this.c == 1, null);
            } catch (IllegalArgumentException | UnsupportedOperationException e) {
                throw new vh.b(0, this.e, this.f, this.h, this.f8846a, this.c == 1, e);
            }
        }
    }

    private static final class b {
        public static void a(AudioTrack audioTrack, ii1 ii1Var) {
            LogSessionId logSessionIdA = ii1Var.a();
            if (logSessionIdA.equals(LogSessionId.LOG_SESSION_ID_NONE)) {
                return;
            }
            audioTrack.setLogSessionId(logSessionIdA);
        }
    }

    @Override // com.yandex.mobile.ads.impl.vh
    public final void b() {
        flush();
        for (th thVar : this.f) {
            thVar.b();
        }
        for (th thVar2 : this.g) {
            thVar2.b();
        }
        this.U = false;
        this.a0 = false;
    }

    @Override // com.yandex.mobile.ads.impl.vh
    public final boolean a() {
        return !l() || (this.S && !e());
    }

    @Override // com.yandex.mobile.ads.impl.vh
    public final void a(oh ohVar) {
        if (this.v.equals(ohVar)) {
            return;
        }
        this.v = ohVar;
        if (this.Y) {
            return;
        }
        flush();
    }

    private void b(xh1 xh1Var) {
        if (l()) {
            try {
                this.u.setPlaybackParams(new PlaybackParams().allowDefaults().setSpeed(xh1Var.b).setPitch(xh1Var.c).setAudioFallbackMode(2));
            } catch (IllegalArgumentException e2) {
                at0.b("DefaultAudioSink", "Failed to set playback params", e2);
            }
            xh1Var = new xh1(this.u.getPlaybackParams().getSpeed(), this.u.getPlaybackParams().getPitch());
            this.i.a(xh1Var.b);
        }
        this.y = xh1Var;
    }

    @Override // com.yandex.mobile.ads.impl.vh
    public final void b(boolean z) {
        xh1 xh1Var = i().f8848a;
        i iVarI = i();
        if (xh1Var.equals(iVarI.f8848a) && z == iVarI.b) {
            return;
        }
        i iVar = new i(xh1Var, z, -9223372036854775807L, -9223372036854775807L);
        if (l()) {
            this.w = iVar;
        } else {
            this.x = iVar;
        }
    }

    @Override // com.yandex.mobile.ads.impl.vh
    public final void a(int i2) {
        if (this.W != i2) {
            this.W = i2;
            this.V = i2 != 0;
            flush();
        }
    }

    @Override // com.yandex.mobile.ads.impl.vh
    public final void a(ii iiVar) {
        if (this.X.equals(iiVar)) {
            return;
        }
        int i2 = iiVar.f9222a;
        float f2 = iiVar.b;
        AudioTrack audioTrack = this.u;
        if (audioTrack != null) {
            if (this.X.f9222a != i2) {
                audioTrack.attachAuxEffect(i2);
            }
            if (i2 != 0) {
                this.u.setAuxEffectSendLevel(f2);
            }
        }
        this.X = iiVar;
    }

    public final void a(vh.c cVar) {
        this.r = cVar;
    }

    @Override // com.yandex.mobile.ads.impl.vh
    public final void a(xh1 xh1Var) {
        float f2 = xh1Var.b;
        int i2 = x82.f10629a;
        xh1 xh1Var2 = new xh1(Math.max(0.1f, Math.min(f2, 8.0f)), Math.max(0.1f, Math.min(xh1Var.c, 8.0f)));
        if (this.k && x82.f10629a >= 23) {
            b(xh1Var2);
            return;
        }
        boolean z = i().b;
        i iVarI = i();
        if (xh1Var2.equals(iVarI.f8848a) && z == iVarI.b) {
            return;
        }
        i iVar = new i(xh1Var2, z, -9223372036854775807L, -9223372036854775807L);
        if (l()) {
            this.w = iVar;
        } else {
            this.x = iVar;
        }
    }

    @Override // com.yandex.mobile.ads.impl.vh
    public final void a(ii1 ii1Var) {
        this.q = ii1Var;
    }

    @Override // com.yandex.mobile.ads.impl.vh
    public final boolean a(gc0 gc0Var) {
        return b(gc0Var) != 0;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x006c  */
    /* JADX WARN: Code duplicated, block: B:47:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:49:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:50:0x00e0  */
    private void a(ByteBuffer byteBuffer, long j2) throws Exception {
        int iWrite;
        vh.c cVar;
        if (byteBuffer.hasRemaining()) {
            ByteBuffer byteBuffer2 = this.O;
            if (byteBuffer2 == null) {
                this.O = byteBuffer;
                if (x82.f10629a < 21) {
                    int iRemaining = byteBuffer.remaining();
                    byte[] bArr = this.P;
                    if (bArr == null || bArr.length < iRemaining) {
                        this.P = new byte[iRemaining];
                    }
                    int iPosition = byteBuffer.position();
                    byteBuffer.get(this.P, 0, iRemaining);
                    byteBuffer.position(iPosition);
                    this.Q = 0;
                }
            } else if (byteBuffer2 != byteBuffer) {
                throw new IllegalArgumentException();
            }
            int iRemaining2 = byteBuffer.remaining();
            int i2 = x82.f10629a;
            if (i2 < 21) {
                int iB = this.i.b(this.D);
                if (iB > 0) {
                    iWrite = this.u.write(this.P, this.Q, Math.min(iRemaining2, iB));
                    if (iWrite > 0) {
                        this.Q += iWrite;
                        byteBuffer.position(byteBuffer.position() + iWrite);
                    }
                } else {
                    iWrite = 0;
                }
            } else if (!this.Y) {
                iWrite = this.u.write(byteBuffer, iRemaining2, 1);
            } else if (j2 != -9223372036854775807L) {
                AudioTrack audioTrack = this.u;
                if (i2 >= 26) {
                    iWrite = audioTrack.write(byteBuffer, iRemaining2, 1, j2 * 1000);
                } else {
                    if (this.z == null) {
                        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(16);
                        this.z = byteBufferAllocate;
                        byteBufferAllocate.order(ByteOrder.BIG_ENDIAN);
                        this.z.putInt(1431633921);
                    }
                    if (this.A == 0) {
                        this.z.putInt(4, iRemaining2);
                        this.z.putLong(8, j2 * 1000);
                        this.z.position(0);
                        this.A = iRemaining2;
                    }
                    int iRemaining3 = this.z.remaining();
                    if (iRemaining3 > 0) {
                        int iWrite2 = audioTrack.write(this.z, iRemaining3, 1);
                        if (iWrite2 < 0) {
                            this.A = 0;
                            iWrite = iWrite2;
                        } else if (iWrite2 < iRemaining3) {
                            iWrite = 0;
                        } else {
                            iWrite = audioTrack.write(byteBuffer, iRemaining2, 1);
                            if (iWrite < 0) {
                                this.A = 0;
                            } else {
                                this.A -= iWrite;
                            }
                        }
                    } else {
                        iWrite = audioTrack.write(byteBuffer, iRemaining2, 1);
                        if (iWrite < 0) {
                            this.A = 0;
                        } else {
                            this.A -= iWrite;
                        }
                    }
                }
            } else {
                throw new IllegalStateException();
            }
            this.Z = SystemClock.elapsedRealtime();
            if (iWrite < 0) {
                boolean z = (i2 >= 24 && iWrite == -6) || iWrite == -32;
                if (z && this.t.c == 1) {
                    this.a0 = true;
                }
                vh.e eVar = new vh.e(iWrite, this.t.f8846a, z);
                vh.c cVar2 = this.r;
                if (cVar2 != null) {
                    ((dv0.a) cVar2).a(eVar);
                }
                if (!eVar.c) {
                    j<vh.e> jVar = this.o;
                    jVar.getClass();
                    long jElapsedRealtime = SystemClock.elapsedRealtime();
                    if (((j) jVar).f8849a == null) {
                        ((j) jVar).f8849a = eVar;
                        ((j) jVar).b = 100 + jElapsedRealtime;
                    }
                    if (jElapsedRealtime >= ((j) jVar).b) {
                        Exception exc = ((j) jVar).f8849a;
                        if (exc != eVar) {
                            exc.addSuppressed(eVar);
                        }
                        Exception exc2 = ((j) jVar).f8849a;
                        ((j) jVar).f8849a = null;
                        throw exc2;
                    }
                    return;
                }
                throw eVar;
            }
            ((j) this.o).f8849a = null;
            if (a(this.u)) {
                if (this.E > 0) {
                    this.b0 = false;
                }
                if (this.U && (cVar = this.r) != null && iWrite < iRemaining2 && !this.b0) {
                    ((dv0.a) cVar).b();
                }
            }
            int i3 = this.t.c;
            if (i3 == 0) {
                this.D += (long) iWrite;
            }
            if (iWrite == iRemaining2) {
                if (i3 != 0) {
                    if (byteBuffer != this.M) {
                        throw new IllegalStateException();
                    }
                    this.E = (((long) this.F) * ((long) this.N)) + this.E;
                }
                this.O = null;
            }
        }
    }

    private boolean a(gc0 gc0Var, oh ohVar) {
        int iA;
        int playbackOffloadSupport;
        int i2 = x82.f10629a;
        if (i2 < 29 || this.l == 0) {
            return false;
        }
        String str = gc0Var.m;
        str.getClass();
        int iB = s01.b(str, gc0Var.j);
        if (iB == 0 || (iA = x82.a(gc0Var.z)) == 0) {
            return false;
        }
        AudioFormat audioFormatBuild = new AudioFormat.Builder().setSampleRate(gc0Var.A).setChannelMask(iA).setEncoding(iB).build();
        AudioAttributes audioAttributes = ohVar.a().f9816a;
        if (i2 >= 31) {
            playbackOffloadSupport = AudioManager.getPlaybackOffloadSupport(audioFormatBuild, audioAttributes);
        } else if (AudioManager.isOffloadedPlaybackSupported(audioFormatBuild, audioAttributes)) {
            playbackOffloadSupport = (i2 == 30 && x82.d.startsWith("Pixel")) ? 2 : 1;
        } else {
            playbackOffloadSupport = 0;
        }
        if (playbackOffloadSupport == 0) {
            return false;
        }
        if (playbackOffloadSupport == 1) {
            return ((gc0Var.C != 0 || gc0Var.D != 0) && (this.l == 1)) ? false : true;
        }
        if (playbackOffloadSupport == 2) {
            return true;
        }
        throw new IllegalStateException();
    }

    private static boolean a(AudioTrack audioTrack) {
        return x82.f10629a >= 29 && audioTrack.isOffloadedPlayback();
    }
}
