package com.yandex.mobile.ads.impl;

import java.io.IOException;

/* JADX INFO: loaded from: classes9.dex */
public class ic0 implements x70 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final x70 f9200a;

    public ic0(tz tzVar) {
        this.f9200a = tzVar;
    }

    @Override // com.yandex.mobile.ads.impl.nv
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        return this.f9200a.read(bArr, i, i2);
    }

    @Override // com.yandex.mobile.ads.impl.x70
    public final void b(int i) throws IOException {
        this.f9200a.b(i);
    }

    @Override // com.yandex.mobile.ads.impl.x70
    public final void c() {
        this.f9200a.c();
    }

    @Override // com.yandex.mobile.ads.impl.x70
    public long d() {
        return this.f9200a.d();
    }

    @Override // com.yandex.mobile.ads.impl.x70
    public long a() {
        return this.f9200a.a();
    }

    @Override // com.yandex.mobile.ads.impl.x70
    public final void a(byte[] bArr, int i, int i2) throws IOException {
        this.f9200a.a(bArr, i, i2);
    }

    @Override // com.yandex.mobile.ads.impl.x70
    public long b() {
        return this.f9200a.b();
    }

    @Override // com.yandex.mobile.ads.impl.x70
    public final boolean a(byte[] bArr, int i, int i2, boolean z) throws IOException {
        return this.f9200a.a(bArr, 0, i2, z);
    }

    @Override // com.yandex.mobile.ads.impl.x70
    public final boolean b(byte[] bArr, int i, int i2, boolean z) throws IOException {
        return this.f9200a.b(bArr, 0, i2, z);
    }

    @Override // com.yandex.mobile.ads.impl.x70
    public final void a(int i) throws IOException {
        this.f9200a.a(i);
    }

    @Override // com.yandex.mobile.ads.impl.x70
    public final void b(byte[] bArr, int i, int i2) throws IOException {
        this.f9200a.b(bArr, i, i2);
    }
}
