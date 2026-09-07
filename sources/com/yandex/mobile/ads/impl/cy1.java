package com.yandex.mobile.ads.impl;

import com.google.android.exoplayer2.audio.SilenceSkippingAudioProcessor;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes12.dex */
public final class cy1 extends hk {
    private final long i = SilenceSkippingAudioProcessor.DEFAULT_MINIMUM_SILENCE_DURATION_US;
    private final long j = 20000;
    private final short k = 1024;
    private int l;
    private boolean m;
    private byte[] n;
    private byte[] o;
    private int p;
    private int q;
    private int r;
    private boolean s;
    private long t;

    public cy1(int i) {
        byte[] bArr = x82.f;
        this.n = bArr;
        this.o = bArr;
    }

    public final long i() {
        return this.t;
    }

    @Override // com.yandex.mobile.ads.impl.hk
    public final th.a b(th.a aVar) throws th.b {
        if (aVar.c == 2) {
            return this.m ? aVar : th.a.e;
        }
        throw new th.b(aVar);
    }

    @Override // com.yandex.mobile.ads.impl.hk, com.yandex.mobile.ads.impl.th
    public final boolean isActive() {
        return this.m;
    }

    @Override // com.yandex.mobile.ads.impl.th
    public final void a(ByteBuffer byteBuffer) {
        int iLimit;
        int iLimit2;
        int iPosition;
        while (byteBuffer.hasRemaining() && !e()) {
            int i = this.p;
            if (i == 0) {
                int iLimit3 = byteBuffer.limit();
                byteBuffer.limit(Math.min(iLimit3, byteBuffer.position() + this.n.length));
                int iLimit4 = byteBuffer.limit() - 2;
                while (true) {
                    if (iLimit4 >= byteBuffer.position()) {
                        if (Math.abs((int) byteBuffer.getShort(iLimit4)) > this.k) {
                            int i2 = this.l;
                            iPosition = ((iLimit4 / i2) * i2) + i2;
                            break;
                        }
                        iLimit4 -= 2;
                    } else {
                        iPosition = byteBuffer.position();
                        break;
                    }
                }
                if (iPosition == byteBuffer.position()) {
                    this.p = 1;
                } else {
                    byteBuffer.limit(iPosition);
                    int iRemaining = byteBuffer.remaining();
                    a(iRemaining).put(byteBuffer).flip();
                    if (iRemaining > 0) {
                        this.s = true;
                    }
                }
                byteBuffer.limit(iLimit3);
            } else if (i == 1) {
                int iLimit5 = byteBuffer.limit();
                int iPosition2 = byteBuffer.position();
                while (true) {
                    if (iPosition2 < byteBuffer.limit()) {
                        if (Math.abs((int) byteBuffer.getShort(iPosition2)) > this.k) {
                            int i3 = this.l;
                            iLimit2 = (iPosition2 / i3) * i3;
                            break;
                        }
                        iPosition2 += 2;
                    } else {
                        iLimit2 = byteBuffer.limit();
                        break;
                    }
                }
                int iPosition3 = iLimit2 - byteBuffer.position();
                byte[] bArr = this.n;
                int length = bArr.length;
                int i4 = this.q;
                int i5 = length - i4;
                if (iLimit2 < iLimit5 && iPosition3 < i5) {
                    a(i4).put(bArr, 0, i4).flip();
                    if (i4 > 0) {
                        this.s = true;
                    }
                    this.q = 0;
                    this.p = 0;
                } else {
                    int iMin = Math.min(iPosition3, i5);
                    byteBuffer.limit(byteBuffer.position() + iMin);
                    byteBuffer.get(this.n, this.q, iMin);
                    int i6 = this.q + iMin;
                    this.q = i6;
                    byte[] bArr2 = this.n;
                    if (i6 == bArr2.length) {
                        if (this.s) {
                            int i7 = this.r;
                            a(i7).put(bArr2, 0, i7).flip();
                            if (i7 > 0) {
                                this.s = true;
                            }
                            this.t += (long) ((this.q - (this.r * 2)) / this.l);
                        } else {
                            this.t += (long) ((i6 - this.r) / this.l);
                        }
                        byte[] bArr3 = this.n;
                        int i8 = this.q;
                        int iMin2 = Math.min(byteBuffer.remaining(), this.r);
                        int i9 = this.r - iMin2;
                        System.arraycopy(bArr3, i8 - i9, this.o, 0, i9);
                        byteBuffer.position(byteBuffer.limit() - iMin2);
                        byteBuffer.get(this.o, i9, iMin2);
                        this.q = 0;
                        this.p = 2;
                    }
                    byteBuffer.limit(iLimit5);
                }
            } else if (i == 2) {
                int iLimit6 = byteBuffer.limit();
                int iPosition4 = byteBuffer.position();
                while (true) {
                    if (iPosition4 < byteBuffer.limit()) {
                        if (Math.abs((int) byteBuffer.getShort(iPosition4)) > this.k) {
                            int i10 = this.l;
                            iLimit = (iPosition4 / i10) * i10;
                            break;
                        }
                        iPosition4 += 2;
                    } else {
                        iLimit = byteBuffer.limit();
                        break;
                    }
                }
                byteBuffer.limit(iLimit);
                this.t += (long) (byteBuffer.remaining() / this.l);
                byte[] bArr4 = this.o;
                int i11 = this.r;
                int iMin3 = Math.min(byteBuffer.remaining(), this.r);
                int i12 = this.r - iMin3;
                System.arraycopy(bArr4, i11 - i12, this.o, 0, i12);
                byteBuffer.position(byteBuffer.limit() - iMin3);
                byteBuffer.get(this.o, i12, iMin3);
                if (iLimit < iLimit6) {
                    byte[] bArr5 = this.o;
                    int i13 = this.r;
                    a(i13).put(bArr5, 0, i13).flip();
                    if (i13 > 0) {
                        this.s = true;
                    }
                    this.p = 0;
                    byteBuffer.limit(iLimit6);
                }
            } else {
                throw new IllegalStateException();
            }
        }
    }

    @Override // com.yandex.mobile.ads.impl.hk
    protected final void g() {
        int i = this.q;
        if (i > 0) {
            a(i).put(this.n, 0, i).flip();
            if (i > 0) {
                this.s = true;
            }
        }
        if (this.s) {
            return;
        }
        this.t += (long) (this.r / this.l);
    }

    @Override // com.yandex.mobile.ads.impl.hk
    protected final void f() {
        if (this.m) {
            th.a aVar = this.b;
            int i = aVar.d;
            this.l = i;
            long j = this.i;
            long j2 = aVar.f10300a;
            int i2 = ((int) ((j * j2) / 1000000)) * i;
            if (this.n.length != i2) {
                this.n = new byte[i2];
            }
            int i3 = ((int) ((this.j * j2) / 1000000)) * i;
            this.r = i3;
            if (this.o.length != i3) {
                this.o = new byte[i3];
            }
        }
        this.p = 0;
        this.t = 0L;
        this.q = 0;
        this.s = false;
    }

    @Override // com.yandex.mobile.ads.impl.hk
    protected final void h() {
        this.m = false;
        this.r = 0;
        byte[] bArr = x82.f;
        this.n = bArr;
        this.o = bArr;
    }

    public final void a(boolean z) {
        this.m = z;
    }
}
