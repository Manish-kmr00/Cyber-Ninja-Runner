package com.yandex.mobile.ads.impl;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes6.dex */
final class yk extends oy {
    private long j;
    private int k;
    private int l;

    public yk() {
        super(2);
        this.l = 32;
    }

    @Override // com.yandex.mobile.ads.impl.oy, com.yandex.mobile.ads.impl.fm
    public final void b() {
        super.b();
        this.k = 0;
    }

    public final void f(int i) {
        if (i > 0) {
            this.l = i;
            return;
        }
        throw new IllegalArgumentException();
    }

    public final long k() {
        return this.j;
    }

    public final int l() {
        return this.k;
    }

    public final boolean m() {
        return this.k > 0;
    }

    public final boolean a(oy oyVar) {
        ByteBuffer byteBuffer;
        if (!oyVar.i()) {
            if (!oyVar.d()) {
                if (!oyVar.f()) {
                    if (m()) {
                        if (this.k >= this.l || oyVar.e() != e()) {
                            return false;
                        }
                        ByteBuffer byteBuffer2 = oyVar.d;
                        if (byteBuffer2 != null && (byteBuffer = this.d) != null) {
                            if (byteBuffer2.remaining() + byteBuffer.position() > 3072000) {
                                return false;
                            }
                        }
                    }
                    int i = this.k;
                    this.k = i + 1;
                    if (i == 0) {
                        this.f = oyVar.f;
                        if (oyVar.g()) {
                            d(1);
                        }
                    }
                    if (oyVar.e()) {
                        d(Integer.MIN_VALUE);
                    }
                    ByteBuffer byteBuffer3 = oyVar.d;
                    if (byteBuffer3 != null) {
                        e(byteBuffer3.remaining());
                        this.d.put(byteBuffer3);
                    }
                    this.j = oyVar.f;
                    return true;
                }
                throw new IllegalArgumentException();
            }
            throw new IllegalArgumentException();
        }
        throw new IllegalArgumentException();
    }
}
