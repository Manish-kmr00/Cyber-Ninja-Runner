package com.yandex.mobile.ads.impl;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes3.dex */
public abstract class hk implements th {
    protected th.a b;
    protected th.a c;
    private th.a d;
    private th.a e;
    private ByteBuffer f;
    private ByteBuffer g;
    private boolean h;

    protected abstract th.a b(th.a aVar) throws th.b;

    protected void f() {
    }

    protected void g() {
    }

    protected void h() {
    }

    public hk() {
        ByteBuffer byteBuffer = th.f10299a;
        this.f = byteBuffer;
        this.g = byteBuffer;
        th.a aVar = th.a.e;
        this.d = aVar;
        this.e = aVar;
        this.b = aVar;
        this.c = aVar;
    }

    @Override // com.yandex.mobile.ads.impl.th
    public final th.a a(th.a aVar) throws th.b {
        this.d = aVar;
        this.e = b(aVar);
        return isActive() ? this.e : th.a.e;
    }

    @Override // com.yandex.mobile.ads.impl.th
    public boolean isActive() {
        return this.e != th.a.e;
    }

    @Override // com.yandex.mobile.ads.impl.th
    public final void d() {
        this.h = true;
        g();
    }

    @Override // com.yandex.mobile.ads.impl.th
    public ByteBuffer c() {
        ByteBuffer byteBuffer = this.g;
        this.g = th.f10299a;
        return byteBuffer;
    }

    @Override // com.yandex.mobile.ads.impl.th
    public final void flush() {
        this.g = th.f10299a;
        this.h = false;
        this.b = this.d;
        this.c = this.e;
        f();
    }

    @Override // com.yandex.mobile.ads.impl.th
    public final void b() {
        flush();
        this.f = th.f10299a;
        th.a aVar = th.a.e;
        this.d = aVar;
        this.e = aVar;
        this.b = aVar;
        this.c = aVar;
        h();
    }

    protected final boolean e() {
        return this.g.hasRemaining();
    }

    @Override // com.yandex.mobile.ads.impl.th
    public boolean a() {
        return this.h && this.g == th.f10299a;
    }

    protected final ByteBuffer a(int i) {
        if (this.f.capacity() < i) {
            this.f = ByteBuffer.allocateDirect(i).order(ByteOrder.nativeOrder());
        } else {
            this.f.clear();
        }
        ByteBuffer byteBuffer = this.f;
        this.g = byteBuffer;
        return byteBuffer;
    }
}
