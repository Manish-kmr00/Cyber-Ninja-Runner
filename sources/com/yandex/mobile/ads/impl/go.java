package com.yandex.mobile.ads.impl;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes3.dex */
final class go extends hk {
    private int[] i;
    private int[] j;

    go() {
    }

    @Override // com.yandex.mobile.ads.impl.hk
    public final th.a b(th.a aVar) throws th.b {
        int[] iArr = this.i;
        if (iArr == null) {
            return th.a.e;
        }
        if (aVar.c == 2) {
            boolean z = aVar.b != iArr.length;
            int i = 0;
            while (i < iArr.length) {
                int i2 = iArr[i];
                if (i2 >= aVar.b) {
                    throw new th.b(aVar);
                }
                z |= i2 != i;
                i++;
            }
            if (z) {
                return new th.a(aVar.f10300a, iArr.length, 2);
            }
            return th.a.e;
        }
        throw new th.b(aVar);
    }

    @Override // com.yandex.mobile.ads.impl.th
    public final void a(ByteBuffer byteBuffer) {
        int[] iArr = this.j;
        iArr.getClass();
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit();
        ByteBuffer byteBufferA = a(((iLimit - iPosition) / this.b.d) * this.c.d);
        while (iPosition < iLimit) {
            for (int i : iArr) {
                byteBufferA.putShort(byteBuffer.getShort((i * 2) + iPosition));
            }
            iPosition += this.b.d;
        }
        byteBuffer.position(iLimit);
        byteBufferA.flip();
    }

    @Override // com.yandex.mobile.ads.impl.hk
    protected final void f() {
        this.j = this.i;
    }

    @Override // com.yandex.mobile.ads.impl.hk
    protected final void h() {
        this.j = null;
        this.i = null;
    }

    public final void a(int[] iArr) {
        this.i = iArr;
    }
}
