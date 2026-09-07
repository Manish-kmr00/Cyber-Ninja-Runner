package com.yandex.mobile.ads.impl;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes6.dex */
public final class wn extends rk {
    private final oy n;
    private final wf1 o;
    private long p;
    private vn q;
    private long r;

    @Override // com.yandex.mobile.ads.impl.ro1
    public final boolean d() {
        return true;
    }

    @Override // com.yandex.mobile.ads.impl.ro1, com.yandex.mobile.ads.impl.so1
    public final String getName() {
        return "CameraMotionRenderer";
    }

    @Override // com.yandex.mobile.ads.impl.rk
    protected final void u() {
        vn vnVar = this.q;
        if (vnVar != null) {
            vnVar.f();
        }
    }

    public wn() {
        super(6);
        this.n = new oy(1);
        this.o = new wf1();
    }

    @Override // com.yandex.mobile.ads.impl.rk, com.yandex.mobile.ads.impl.ji1.b
    public final void a(int i, Object obj) throws j60 {
        if (i == 8) {
            this.q = (vn) obj;
        }
    }

    @Override // com.yandex.mobile.ads.impl.rk
    protected final void a(long j, boolean z) {
        this.r = Long.MIN_VALUE;
        vn vnVar = this.q;
        if (vnVar != null) {
            vnVar.f();
        }
    }

    @Override // com.yandex.mobile.ads.impl.rk
    protected final void a(gc0[] gc0VarArr, long j, long j2) {
        this.p = j2;
    }

    @Override // com.yandex.mobile.ads.impl.ro1
    public final void a(long j, long j2) {
        float[] fArr;
        while (!e() && this.r < 100000 + j) {
            this.n.b();
            if (a(q(), this.n, 0) != -4 || this.n.f()) {
                return;
            }
            oy oyVar = this.n;
            this.r = oyVar.f;
            if (this.q != null && !oyVar.e()) {
                this.n.h();
                ByteBuffer byteBuffer = this.n.d;
                int i = x82.f10629a;
                if (byteBuffer.remaining() != 16) {
                    fArr = null;
                } else {
                    this.o.a(byteBuffer.limit(), byteBuffer.array());
                    this.o.e(byteBuffer.arrayOffset() + 4);
                    float[] fArr2 = new float[3];
                    for (int i2 = 0; i2 < 3; i2++) {
                        fArr2[i2] = Float.intBitsToFloat(this.o.k());
                    }
                    fArr = fArr2;
                }
                if (fArr != null) {
                    this.q.a(this.r - this.p, fArr);
                }
            }
        }
    }

    @Override // com.yandex.mobile.ads.impl.so1
    public final int a(gc0 gc0Var) {
        if ("application/x-camera-motion".equals(gc0Var.m)) {
            return so1.a(4, 0, 0);
        }
        return so1.a(0, 0, 0);
    }
}
