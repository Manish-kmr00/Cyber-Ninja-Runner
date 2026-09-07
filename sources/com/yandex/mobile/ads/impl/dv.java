package com.yandex.mobile.ads.impl;

import android.media.MediaCodec;

/* JADX INFO: loaded from: classes3.dex */
public final class dv {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f8735a;
    public byte[] b;
    public int c;
    public int[] d;
    public int[] e;
    public int f;
    public int g;
    public int h;
    private final MediaCodec.CryptoInfo i;
    private final a j;

    public dv() {
        MediaCodec.CryptoInfo cryptoInfo = new MediaCodec.CryptoInfo();
        this.i = cryptoInfo;
        this.j = x82.f10629a >= 24 ? new a(cryptoInfo) : null;
    }

    public final MediaCodec.CryptoInfo a() {
        return this.i;
    }

    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final MediaCodec.CryptoInfo f8736a;
        private final MediaCodec.CryptoInfo.Pattern b;

        private a(MediaCodec.CryptoInfo cryptoInfo) {
            this.f8736a = cryptoInfo;
            this.b = new MediaCodec.CryptoInfo.Pattern(0, 0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i, int i2) {
            this.b.set(i, i2);
            this.f8736a.setPattern(this.b);
        }
    }

    public final void a(int i) {
        if (i == 0) {
            return;
        }
        if (this.d == null) {
            int[] iArr = new int[1];
            this.d = iArr;
            this.i.numBytesOfClearData = iArr;
        }
        int[] iArr2 = this.d;
        iArr2[0] = iArr2[0] + i;
    }

    public final void a(int i, int[] iArr, int[] iArr2, byte[] bArr, byte[] bArr2, int i2, int i3, int i4) {
        this.f = i;
        this.d = iArr;
        this.e = iArr2;
        this.b = bArr;
        this.f8735a = bArr2;
        this.c = i2;
        this.g = i3;
        this.h = i4;
        MediaCodec.CryptoInfo cryptoInfo = this.i;
        cryptoInfo.numSubSamples = i;
        cryptoInfo.numBytesOfClearData = iArr;
        cryptoInfo.numBytesOfEncryptedData = iArr2;
        cryptoInfo.key = bArr;
        cryptoInfo.iv = bArr2;
        cryptoInfo.mode = i2;
        if (x82.f10629a >= 24) {
            a aVar = this.j;
            aVar.getClass();
            aVar.a(i3, i4);
        }
    }
}
