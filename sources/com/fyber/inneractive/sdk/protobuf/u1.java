package com.fyber.inneractive.sdk.protobuf;

import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes9.dex */
public final class u1 extends x1 {
    public u1(Unsafe unsafe) {
        super(unsafe);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.x1
    public final void a(Object obj, long j, byte b) {
        if (y1.h) {
            y1.a(obj, j, b);
        } else {
            y1.b(obj, j, b);
        }
    }

    @Override // com.fyber.inneractive.sdk.protobuf.x1
    public final boolean b() {
        return false;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.x1
    public final double c(Object obj, long j) {
        return Double.longBitsToDouble(this.f2303a.getLong(obj, j));
    }

    @Override // com.fyber.inneractive.sdk.protobuf.x1
    public final float d(Object obj, long j) {
        return Float.intBitsToFloat(this.f2303a.getInt(obj, j));
    }

    @Override // com.fyber.inneractive.sdk.protobuf.x1
    public final byte b(Object obj, long j) {
        return y1.h ? y1.a(obj, j) : y1.b(obj, j);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.x1
    public final boolean a(Object obj, long j) {
        if (y1.h) {
            return y1.a(obj, j) != 0;
        }
        return y1.b(obj, j) != 0;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.x1
    public final void a(Object obj, long j, boolean z) {
        if (y1.h) {
            y1.a(obj, j, z ? (byte) 1 : (byte) 0);
        } else {
            y1.b(obj, j, z ? (byte) 1 : (byte) 0);
        }
    }

    @Override // com.fyber.inneractive.sdk.protobuf.x1
    public final void a(Object obj, long j, float f) {
        this.f2303a.putInt(obj, j, Float.floatToIntBits(f));
    }

    @Override // com.fyber.inneractive.sdk.protobuf.x1
    public final void a(Object obj, long j, double d) {
        this.f2303a.putLong(obj, j, Double.doubleToLongBits(d));
    }

    @Override // com.fyber.inneractive.sdk.protobuf.x1
    public final byte a(long j) {
        throw new UnsupportedOperationException();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.x1
    public final void a(long j, byte[] bArr, long j2) {
        throw new UnsupportedOperationException();
    }
}
