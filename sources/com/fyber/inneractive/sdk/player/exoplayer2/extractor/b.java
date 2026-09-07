package com.fyber.inneractive.sdk.player.exoplayer2.extractor;

import com.fyber.inneractive.sdk.player.exoplayer2.util.z;
import java.io.EOFException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes13.dex */
public final class b {
    public static final byte[] g = new byte[4096];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.fyber.inneractive.sdk.player.exoplayer2.upstream.h f1998a;
    public final long b;
    public long c;
    public byte[] d = new byte[65536];
    public int e;
    public int f;

    public b(com.fyber.inneractive.sdk.player.exoplayer2.upstream.h hVar, long j, long j2) {
        this.f1998a = hVar;
        this.c = j;
        this.b = j2;
    }

    public final boolean a(byte[] bArr, int i, int i2, boolean z) {
        if (!a(i2, z)) {
            return false;
        }
        System.arraycopy(this.d, this.e - i2, bArr, i, i2);
        return true;
    }

    public final boolean b(byte[] bArr, int i, int i2, boolean z) throws InterruptedException, EOFException {
        int iA;
        int i3 = this.f;
        if (i3 == 0) {
            iA = 0;
        } else {
            int iMin = Math.min(i3, i2);
            System.arraycopy(this.d, 0, bArr, i, iMin);
            b(iMin);
            iA = iMin;
        }
        while (iA < i2 && iA != -1) {
            iA = a(bArr, i, i2, iA, z);
        }
        if (iA != -1) {
            this.c += (long) iA;
        }
        return iA != -1;
    }

    public final boolean a(int i, boolean z) throws InterruptedException, EOFException {
        int i2 = this.e + i;
        byte[] bArr = this.d;
        if (i2 > bArr.length) {
            int i3 = z.f2192a;
            this.d = Arrays.copyOf(this.d, Math.max(65536 + i2, Math.min(bArr.length * 2, i2 + 524288)));
        }
        int iMin = Math.min(this.f - this.e, i);
        while (iMin < i) {
            iMin = a(this.d, this.e, i, iMin, z);
            if (iMin == -1) {
                return false;
            }
        }
        int i4 = this.e + i;
        this.e = i4;
        this.f = Math.max(this.f, i4);
        return true;
    }

    public final void b(int i) {
        int i2 = this.f - i;
        this.f = i2;
        this.e = 0;
        byte[] bArr = this.d;
        byte[] bArr2 = i2 < bArr.length - 524288 ? new byte[65536 + i2] : bArr;
        System.arraycopy(bArr, i, bArr2, 0, i2);
        this.d = bArr2;
    }

    public final void a(int i) throws InterruptedException, EOFException {
        int iMin = Math.min(this.f, i);
        b(iMin);
        int iA = iMin;
        while (iA < i && iA != -1) {
            iA = a(g, -iA, Math.min(i, iA + 4096), iA, false);
        }
        if (iA != -1) {
            this.c += (long) iA;
        }
    }

    public final int a(byte[] bArr, int i, int i2, int i3, boolean z) throws InterruptedException, EOFException {
        if (!Thread.interrupted()) {
            int i4 = this.f1998a.read(bArr, i + i3, i2 - i3);
            if (i4 != -1) {
                return i3 + i4;
            }
            if (i3 == 0 && z) {
                return -1;
            }
            throw new EOFException();
        }
        throw new InterruptedException();
    }
}
