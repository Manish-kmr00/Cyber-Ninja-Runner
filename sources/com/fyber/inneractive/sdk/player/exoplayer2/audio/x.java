package com.fyber.inneractive.sdk.player.exoplayer2.audio;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

/* JADX INFO: loaded from: classes6.dex */
public final class x implements c {
    public w d;
    public ByteBuffer g;
    public ShortBuffer h;
    public ByteBuffer i;
    public long j;
    public long k;
    public boolean l;
    public float e = 1.0f;
    public float f = 1.0f;
    public int b = -1;
    public int c = -1;

    public x() {
        ByteBuffer byteBuffer = c.f1975a;
        this.g = byteBuffer;
        this.h = byteBuffer.asShortBuffer();
        this.i = byteBuffer;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.audio.c
    public final boolean a(int i, int i2, int i3) throws b {
        if (i3 != 2) {
            throw new b(i, i2, i3);
        }
        if (this.c == i && this.b == i2) {
            return false;
        }
        this.c = i;
        this.b = i2;
        return true;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.audio.c
    public final void b() {
        int i;
        w wVar = this.d;
        int i2 = wVar.q;
        float f = wVar.o;
        float f2 = wVar.p;
        int i3 = wVar.r + ((int) ((((i2 / (f / f2)) + wVar.s) / f2) + 0.5f));
        wVar.a((wVar.e * 2) + i2);
        int i4 = 0;
        while (true) {
            i = wVar.e * 2;
            int i5 = wVar.b;
            if (i4 >= i * i5) {
                break;
            }
            wVar.h[(i5 * i2) + i4] = 0;
            i4++;
        }
        wVar.q = i + wVar.q;
        wVar.a();
        if (wVar.r > i3) {
            wVar.r = i3;
        }
        wVar.q = 0;
        wVar.t = 0;
        wVar.s = 0;
        this.l = true;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.audio.c
    public final boolean c() {
        w wVar;
        return this.l && ((wVar = this.d) == null || wVar.r == 0);
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.audio.c
    public final boolean d() {
        return Math.abs(this.e - 1.0f) >= 0.01f || Math.abs(this.f - 1.0f) >= 0.01f;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.audio.c
    public final int e() {
        return this.b;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.audio.c
    public final void f() {
        this.d = null;
        ByteBuffer byteBuffer = c.f1975a;
        this.g = byteBuffer;
        this.h = byteBuffer.asShortBuffer();
        this.i = byteBuffer;
        this.b = -1;
        this.c = -1;
        this.j = 0L;
        this.k = 0L;
        this.l = false;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.audio.c
    public final void flush() {
        w wVar = new w(this.c, this.b);
        this.d = wVar;
        wVar.o = this.e;
        wVar.p = this.f;
        this.i = c.f1975a;
        this.j = 0L;
        this.k = 0L;
        this.l = false;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.audio.c
    public final void a(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            ShortBuffer shortBufferAsShortBuffer = byteBuffer.asShortBuffer();
            int iRemaining = byteBuffer.remaining();
            this.j += (long) iRemaining;
            w wVar = this.d;
            wVar.getClass();
            int iRemaining2 = shortBufferAsShortBuffer.remaining();
            int i = wVar.b;
            int i2 = iRemaining2 / i;
            wVar.a(i2);
            shortBufferAsShortBuffer.get(wVar.h, wVar.q * wVar.b, ((i * i2) * 2) / 2);
            wVar.q += i2;
            wVar.a();
            byteBuffer.position(byteBuffer.position() + iRemaining);
        }
        int i3 = this.d.r * this.b * 2;
        if (i3 > 0) {
            if (this.g.capacity() < i3) {
                ByteBuffer byteBufferOrder = ByteBuffer.allocateDirect(i3).order(ByteOrder.nativeOrder());
                this.g = byteBufferOrder;
                this.h = byteBufferOrder.asShortBuffer();
            } else {
                this.g.clear();
                this.h.clear();
            }
            w wVar2 = this.d;
            ShortBuffer shortBuffer = this.h;
            wVar2.getClass();
            int iMin = Math.min(shortBuffer.remaining() / wVar2.b, wVar2.r);
            shortBuffer.put(wVar2.j, 0, wVar2.b * iMin);
            int i4 = wVar2.r - iMin;
            wVar2.r = i4;
            short[] sArr = wVar2.j;
            int i5 = wVar2.b;
            System.arraycopy(sArr, iMin * i5, sArr, 0, i4 * i5);
            this.k += (long) i3;
            this.g.limit(i3);
            this.i = this.g;
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.audio.c
    public final ByteBuffer a() {
        ByteBuffer byteBuffer = this.i;
        this.i = c.f1975a;
        return byteBuffer;
    }
}
