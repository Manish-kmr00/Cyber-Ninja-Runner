package com.yandex.mobile.ads.impl;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public final class l01 extends rk implements Handler.Callback {
    private final i01 n;
    private final k01 o;
    private final Handler p;
    private final j01 q;
    private h01 r;
    private boolean s;
    private boolean t;
    private long u;
    private long v;
    private g01 w;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l01(k01 k01Var, Looper looper) {
        super(5);
        i01 i01Var = i01.f9159a;
        this.o = (k01) hg.a(k01Var);
        this.p = looper == null ? null : x82.a(looper, (Handler.Callback) this);
        this.n = (i01) hg.a(i01Var);
        this.q = new j01();
        this.v = -9223372036854775807L;
    }

    @Override // com.yandex.mobile.ads.impl.ro1
    public final boolean d() {
        return true;
    }

    @Override // com.yandex.mobile.ads.impl.ro1, com.yandex.mobile.ads.impl.so1
    public final String getName() {
        return "MetadataRenderer";
    }

    private void a(g01 g01Var, ArrayList arrayList) {
        for (int i = 0; i < g01Var.c(); i++) {
            gc0 gc0VarA = g01Var.a(i).a();
            if (gc0VarA == null || !this.n.a(gc0VarA)) {
                arrayList.add(g01Var.a(i));
            } else {
                ly1 ly1VarB = this.n.b(gc0VarA);
                byte[] bArrB = g01Var.a(i).b();
                bArrB.getClass();
                this.q.b();
                this.q.e(bArrB.length);
                ByteBuffer byteBuffer = this.q.d;
                int i2 = x82.f10629a;
                byteBuffer.put(bArrB);
                this.q.h();
                g01 g01VarA = ly1VarB.a(this.q);
                if (g01VarA != null) {
                    a(g01VarA, arrayList);
                }
            }
        }
    }

    @Override // com.yandex.mobile.ads.impl.rk
    protected final void u() {
        this.w = null;
        this.v = -9223372036854775807L;
        this.r = null;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        if (message.what == 0) {
            this.o.a((g01) message.obj);
            return true;
        }
        throw new IllegalStateException();
    }

    @Override // com.yandex.mobile.ads.impl.rk, com.yandex.mobile.ads.impl.ro1
    public final boolean a() {
        return this.t;
    }

    @Override // com.yandex.mobile.ads.impl.rk
    protected final void a(long j, boolean z) {
        this.w = null;
        this.v = -9223372036854775807L;
        this.s = false;
        this.t = false;
    }

    @Override // com.yandex.mobile.ads.impl.rk
    protected final void a(gc0[] gc0VarArr, long j, long j2) {
        this.r = this.n.b(gc0VarArr[0]);
    }

    @Override // com.yandex.mobile.ads.impl.ro1
    public final void a(long j, long j2) {
        boolean z;
        do {
            z = false;
            if (!this.s && this.w == null) {
                this.q.b();
                hc0 hc0VarQ = q();
                int iA = a(hc0VarQ, this.q, 0);
                if (iA == -4) {
                    if (this.q.f()) {
                        this.s = true;
                    } else {
                        j01 j01Var = this.q;
                        j01Var.j = this.u;
                        j01Var.h();
                        h01 h01Var = this.r;
                        int i = x82.f10629a;
                        g01 g01VarA = h01Var.a(this.q);
                        if (g01VarA != null) {
                            ArrayList arrayList = new ArrayList(g01VarA.c());
                            a(g01VarA, arrayList);
                            if (!arrayList.isEmpty()) {
                                this.w = new g01(arrayList);
                                this.v = this.q.f;
                            }
                        }
                    }
                } else if (iA == -5) {
                    gc0 gc0Var = hc0VarQ.b;
                    gc0Var.getClass();
                    this.u = gc0Var.q;
                }
            }
            g01 g01Var = this.w;
            if (g01Var != null && this.v <= j) {
                Handler handler = this.p;
                if (handler != null) {
                    handler.obtainMessage(0, g01Var).sendToTarget();
                } else {
                    this.o.a(g01Var);
                }
                this.w = null;
                this.v = -9223372036854775807L;
                z = true;
            }
            if (this.s && this.w == null) {
                this.t = true;
            }
        } while (z);
    }

    @Override // com.yandex.mobile.ads.impl.so1
    public final int a(gc0 gc0Var) {
        if (this.n.a(gc0Var)) {
            return so1.a(gc0Var.F == 0 ? 4 : 2, 0, 0);
        }
        return so1.a(0, 0, 0);
    }
}
