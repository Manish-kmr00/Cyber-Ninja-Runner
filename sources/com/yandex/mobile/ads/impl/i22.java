package com.yandex.mobile.ads.impl;

/* JADX INFO: loaded from: classes14.dex */
final class i22 extends ic0 {
    private final long b;

    public i22(tz tzVar, long j) {
        super(tzVar);
        hg.a(tzVar.a() >= j);
        this.b = j;
    }

    @Override // com.yandex.mobile.ads.impl.ic0, com.yandex.mobile.ads.impl.x70
    public final long a() {
        return super.a() - this.b;
    }

    @Override // com.yandex.mobile.ads.impl.ic0, com.yandex.mobile.ads.impl.x70
    public final long d() {
        return super.d() - this.b;
    }

    @Override // com.yandex.mobile.ads.impl.ic0, com.yandex.mobile.ads.impl.x70
    public final long b() {
        return super.b() - this.b;
    }
}
