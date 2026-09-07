package com.yandex.mobile.ads.impl;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class g12 implements th {
    private int b;
    private float c = 1.0f;
    private float d = 1.0f;
    private th.a e;
    private th.a f;
    private th.a g;
    private th.a h;
    private boolean i;
    private f12 j;
    private ByteBuffer k;
    private ShortBuffer l;
    private ByteBuffer m;
    private long n;
    private long o;
    private boolean p;

    public g12() {
        th.a aVar = th.a.e;
        this.e = aVar;
        this.f = aVar;
        this.g = aVar;
        this.h = aVar;
        ByteBuffer byteBuffer = th.f10299a;
        this.k = byteBuffer;
        this.l = byteBuffer.asShortBuffer();
        this.m = byteBuffer;
        this.b = -1;
    }

    @Override // com.yandex.mobile.ads.impl.th
    public final th.a a(th.a aVar) throws th.b {
        if (aVar.c == 2) {
            int i = this.b;
            if (i == -1) {
                i = aVar.f10300a;
            }
            this.e = aVar;
            th.a aVar2 = new th.a(i, aVar.b, 2);
            this.f = aVar2;
            this.i = true;
            return aVar2;
        }
        throw new th.b(aVar);
    }

    @Override // com.yandex.mobile.ads.impl.th
    public final boolean isActive() {
        return this.f.f10300a != -1 && (Math.abs(this.c - 1.0f) >= 1.0E-4f || Math.abs(this.d - 1.0f) >= 1.0E-4f || this.f.f10300a != this.e.f10300a);
    }

    @Override // com.yandex.mobile.ads.impl.th
    public final void d() {
        f12 f12Var = this.j;
        if (f12Var != null) {
            f12Var.e();
        }
        this.p = true;
    }

    @Override // com.yandex.mobile.ads.impl.th
    public final ByteBuffer c() {
        int iB;
        f12 f12Var = this.j;
        if (f12Var != null && (iB = f12Var.b()) > 0) {
            if (this.k.capacity() < iB) {
                ByteBuffer byteBufferOrder = ByteBuffer.allocateDirect(iB).order(ByteOrder.nativeOrder());
                this.k = byteBufferOrder;
                this.l = byteBufferOrder.asShortBuffer();
            } else {
                this.k.clear();
                this.l.clear();
            }
            f12Var.a(this.l);
            this.o += (long) iB;
            this.k.limit(iB);
            this.m = this.k;
        }
        ByteBuffer byteBuffer = this.m;
        this.m = th.f10299a;
        return byteBuffer;
    }

    @Override // com.yandex.mobile.ads.impl.th
    public final void flush() {
        if (isActive()) {
            th.a aVar = this.e;
            this.g = aVar;
            th.a aVar2 = this.f;
            this.h = aVar2;
            if (this.i) {
                this.j = new f12(aVar.f10300a, aVar.b, this.c, this.d, aVar2.f10300a);
            } else {
                f12 f12Var = this.j;
                if (f12Var != null) {
                    f12Var.a();
                }
            }
        }
        this.m = th.f10299a;
        this.n = 0L;
        this.o = 0L;
        this.p = false;
    }

    @Override // com.yandex.mobile.ads.impl.th
    public final void b() {
        this.c = 1.0f;
        this.d = 1.0f;
        th.a aVar = th.a.e;
        this.e = aVar;
        this.f = aVar;
        this.g = aVar;
        this.h = aVar;
        ByteBuffer byteBuffer = th.f10299a;
        this.k = byteBuffer;
        this.l = byteBuffer.asShortBuffer();
        this.m = byteBuffer;
        this.b = -1;
        this.i = false;
        this.j = null;
        this.n = 0L;
        this.o = 0L;
        this.p = false;
    }

    public final long a(long j) {
        if (this.o >= 1024) {
            long j2 = this.n;
            f12 f12Var = this.j;
            f12Var.getClass();
            long jC = j2 - ((long) f12Var.c());
            int i = this.h.f10300a;
            int i2 = this.g.f10300a;
            if (i == i2) {
                return x82.a(j, jC, this.o);
            }
            return x82.a(j, jC * ((long) i), this.o * ((long) i2));
        }
        return (long) (((double) this.c) * j);
    }

    public final void b(float f) {
        if (this.c != f) {
            this.c = f;
            this.i = true;
        }
    }

    @Override // com.yandex.mobile.ads.impl.th
    public final boolean a() {
        f12 f12Var;
        return this.p && ((f12Var = this.j) == null || f12Var.b() == 0);
    }

    @Override // com.yandex.mobile.ads.impl.th
    public final void a(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            f12 f12Var = this.j;
            f12Var.getClass();
            ShortBuffer shortBufferAsShortBuffer = byteBuffer.asShortBuffer();
            int iRemaining = byteBuffer.remaining();
            this.n += (long) iRemaining;
            f12Var.b(shortBufferAsShortBuffer);
            byteBuffer.position(byteBuffer.position() + iRemaining);
        }
    }

    public final void a(float f) {
        if (this.d != f) {
            this.d = f;
            this.i = true;
        }
    }
}
