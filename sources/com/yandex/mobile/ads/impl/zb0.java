package com.yandex.mobile.ads.impl;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes12.dex */
final class zb0 extends hk {
    private static final int i = Float.floatToIntBits(Float.NaN);

    zb0() {
    }

    @Override // com.yandex.mobile.ads.impl.hk
    public final th.a b(th.a aVar) throws th.b {
        int i2 = aVar.c;
        if (i2 != 536870912 && i2 != 805306368 && i2 != 4) {
            throw new th.b(aVar);
        }
        if (i2 != 4) {
            return new th.a(aVar.f10300a, aVar.b, 4);
        }
        return th.a.e;
    }

    @Override // com.yandex.mobile.ads.impl.th
    public final void a(ByteBuffer byteBuffer) {
        ByteBuffer byteBufferA;
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit();
        int i2 = iLimit - iPosition;
        int i3 = this.b.c;
        if (i3 == 536870912) {
            byteBufferA = a((i2 / 3) * 4);
            while (iPosition < iLimit) {
                int iFloatToIntBits = Float.floatToIntBits((float) (((double) (((byteBuffer.get(iPosition) & 255) << 8) | ((byteBuffer.get(iPosition + 1) & 255) << 16) | ((byteBuffer.get(iPosition + 2) & 255) << 24))) * 4.656612875245797E-10d));
                if (iFloatToIntBits == i) {
                    iFloatToIntBits = Float.floatToIntBits(0.0f);
                }
                byteBufferA.putInt(iFloatToIntBits);
                iPosition += 3;
            }
        } else if (i3 == 805306368) {
            byteBufferA = a(i2);
            while (iPosition < iLimit) {
                int iFloatToIntBits2 = Float.floatToIntBits((float) (((double) ((byteBuffer.get(iPosition) & 255) | ((byteBuffer.get(iPosition + 1) & 255) << 8) | ((byteBuffer.get(iPosition + 2) & 255) << 16) | ((byteBuffer.get(iPosition + 3) & 255) << 24))) * 4.656612875245797E-10d));
                if (iFloatToIntBits2 == i) {
                    iFloatToIntBits2 = Float.floatToIntBits(0.0f);
                }
                byteBufferA.putInt(iFloatToIntBits2);
                iPosition += 4;
            }
        } else {
            throw new IllegalStateException();
        }
        byteBuffer.position(byteBuffer.limit());
        byteBufferA.flip();
    }
}
