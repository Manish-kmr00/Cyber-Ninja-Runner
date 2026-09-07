package com.yandex.mobile.ads.impl;

/* JADX INFO: loaded from: classes12.dex */
public final class j00 implements gr1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f9275a;
    private int b;
    private final int c;
    private final float d;

    public j00() {
        this(1.0f, 2500, 1);
    }

    public j00(float f, int i, int i2) {
        this.f9275a = i;
        this.c = i2;
        this.d = f;
    }

    @Override // com.yandex.mobile.ads.impl.gr1
    public final int a() {
        return this.f9275a;
    }

    @Override // com.yandex.mobile.ads.impl.gr1
    public final int b() {
        return this.b;
    }

    @Override // com.yandex.mobile.ads.impl.gr1
    public final void a(ki2 ki2Var) throws ki2 {
        int i = this.b + 1;
        this.b = i;
        int i2 = this.f9275a;
        this.f9275a = i2 + ((int) (i2 * this.d));
        if (i > this.c) {
            throw ki2Var;
        }
    }
}
