package com.yandex.mobile.ads.impl;

import java.nio.ByteBuffer;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* JADX INFO: loaded from: classes5.dex */
public class oy extends fm {
    public final dv c;
    public ByteBuffer d;
    public boolean e;
    public long f;
    public ByteBuffer g;
    private final int h;
    private final int i;

    static {
        r60.a("goog.exo.decoder");
    }

    public static oy j() {
        return new oy(0, 0);
    }

    public static final class a extends IllegalStateException {
        public a(int i, int i2) {
            super("Buffer too small (" + i + " < " + i2 + ")");
        }
    }

    public oy(int i) {
        this(i, 0);
    }

    public oy(int i, int i2) {
        this.c = new dv();
        this.h = i;
        this.i = 0;
    }

    @EnsuresNonNull({"data"})
    public final void e(int i) {
        ByteBuffer byteBufferAllocateDirect;
        ByteBuffer byteBufferAllocateDirect2;
        int i2 = i + this.i;
        ByteBuffer byteBuffer = this.d;
        if (byteBuffer == null) {
            int i3 = this.h;
            if (i3 == 1) {
                byteBufferAllocateDirect2 = ByteBuffer.allocate(i2);
            } else if (i3 == 2) {
                byteBufferAllocateDirect2 = ByteBuffer.allocateDirect(i2);
            } else {
                throw new a(byteBuffer != null ? byteBuffer.capacity() : 0, i2);
            }
            this.d = byteBufferAllocateDirect2;
            return;
        }
        int iCapacity = byteBuffer.capacity();
        int iPosition = byteBuffer.position();
        int i4 = i2 + iPosition;
        if (iCapacity >= i4) {
            this.d = byteBuffer;
            return;
        }
        int i5 = this.h;
        if (i5 == 1) {
            byteBufferAllocateDirect = ByteBuffer.allocate(i4);
        } else if (i5 == 2) {
            byteBufferAllocateDirect = ByteBuffer.allocateDirect(i4);
        } else {
            ByteBuffer byteBuffer2 = this.d;
            throw new a(byteBuffer2 != null ? byteBuffer2.capacity() : 0, i4);
        }
        byteBufferAllocateDirect.order(byteBuffer.order());
        if (iPosition > 0) {
            byteBuffer.flip();
            byteBufferAllocateDirect.put(byteBuffer);
        }
        this.d = byteBufferAllocateDirect;
    }

    public final boolean i() {
        return c(1073741824);
    }

    public final void h() {
        ByteBuffer byteBuffer = this.d;
        if (byteBuffer != null) {
            byteBuffer.flip();
        }
        ByteBuffer byteBuffer2 = this.g;
        if (byteBuffer2 != null) {
            byteBuffer2.flip();
        }
    }

    @Override // com.yandex.mobile.ads.impl.fm
    public void b() {
        super.b();
        ByteBuffer byteBuffer = this.d;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
        ByteBuffer byteBuffer2 = this.g;
        if (byteBuffer2 != null) {
            byteBuffer2.clear();
        }
        this.e = false;
    }
}
