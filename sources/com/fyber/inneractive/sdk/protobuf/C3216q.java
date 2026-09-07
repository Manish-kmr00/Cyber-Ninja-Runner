package com.fyber.inneractive.sdk.protobuf;

import java.nio.charset.Charset;

/* JADX INFO: renamed from: com.fyber.inneractive.sdk.protobuf.q, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes13.dex */
public class C3216q extends AbstractC3213p {
    private static final long serialVersionUID = 1;
    public final byte[] d;

    public C3216q(byte[] bArr) {
        bArr.getClass();
        this.d = bArr;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.AbstractC3221s
    public void a(int i, byte[] bArr) {
        System.arraycopy(this.d, 0, bArr, 0, i);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.AbstractC3221s
    public byte c(int i) {
        return this.d[i];
    }

    @Override // com.fyber.inneractive.sdk.protobuf.AbstractC3221s
    public byte d(int i) {
        return this.d[i];
    }

    @Override // com.fyber.inneractive.sdk.protobuf.AbstractC3221s
    public final AbstractC3221s e(int i) {
        int iA = AbstractC3221s.a(0, i, size());
        return iA == 0 ? AbstractC3221s.b : new C3207n(this.d, g(), iA);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC3221s) || size() != ((AbstractC3221s) obj).size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (!(obj instanceof C3216q)) {
            return obj.equals(this);
        }
        C3216q c3216q = (C3216q) obj;
        int i = this.f2297a;
        int i2 = c3216q.f2297a;
        if (i != 0 && i2 != 0 && i != i2) {
            return false;
        }
        int size = size();
        if (size > c3216q.size()) {
            throw new IllegalArgumentException("Length too large: " + size + size());
        }
        if (size > c3216q.size()) {
            throw new IllegalArgumentException(com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.l.a("Ran off end of other: 0, ", size, ", ").append(c3216q.size()).toString());
        }
        byte[] bArr = this.d;
        byte[] bArr2 = c3216q.d;
        int iG = g() + size;
        int iG2 = g();
        int iG3 = c3216q.g();
        while (iG2 < iG) {
            if (bArr[iG2] != bArr2[iG3]) {
                return false;
            }
            iG2++;
            iG3++;
        }
        return true;
    }

    public int g() {
        return 0;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.AbstractC3221s
    public int size() {
        return this.d.length;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.AbstractC3221s
    public final void a(AbstractC3198k abstractC3198k) {
        abstractC3198k.a(this.d, g(), size());
    }

    @Override // com.fyber.inneractive.sdk.protobuf.AbstractC3221s
    public final boolean c() {
        int iG = g();
        return E1.f2253a.b(this.d, iG, size() + iG);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.AbstractC3221s
    public final AbstractC3229w d() {
        byte[] bArr = this.d;
        int iG = g();
        int size = size();
        C3223t c3223t = new C3223t(bArr, iG, size, true);
        try {
            c3223t.d(size);
            return c3223t;
        } catch (C3211o0 e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override // com.fyber.inneractive.sdk.protobuf.AbstractC3221s
    public final int a(int i, int i2) {
        byte[] bArr = this.d;
        int iG = g();
        Charset charset = AbstractC3205m0.f2291a;
        for (int i3 = iG; i3 < iG + i2; i3++) {
            i = (i * 31) + bArr[i3];
        }
        return i;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.AbstractC3221s
    public final String e() {
        return new String(this.d, g(), size(), AbstractC3205m0.f2291a);
    }
}
