package com.yandex.mobile.ads.impl;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes6.dex */
public abstract class ny1 extends iy1<k32, l32, i32> implements h32 {
    protected abstract g32 a(byte[] bArr, int i, boolean z) throws i32;

    @Override // com.yandex.mobile.ads.impl.h32
    public final void a(long j) {
    }

    @Override // com.yandex.mobile.ads.impl.iy1
    protected final k32 c() {
        return new k32();
    }

    @Override // com.yandex.mobile.ads.impl.iy1
    protected final py d() {
        return new my1(this);
    }

    protected ny1() {
        super(new k32[2], new l32[2]);
        f();
    }

    @Override // com.yandex.mobile.ads.impl.iy1
    protected final i32 a(oy oyVar, py pyVar, boolean z) {
        k32 k32Var = (k32) oyVar;
        l32 l32Var = (l32) pyVar;
        try {
            ByteBuffer byteBuffer = k32Var.d;
            byteBuffer.getClass();
            l32Var.a(k32Var.f, a(byteBuffer.array(), byteBuffer.limit(), z), k32Var.j);
            l32Var.c();
            return null;
        } catch (i32 e) {
            return e;
        }
    }
}
