package com.yandex.mobile.ads.impl;

/* JADX INFO: loaded from: classes8.dex */
final class dm1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f8710a;
    public final a b;
    public final int c;
    public final boolean d;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final b[] f8711a;

        public final b a() {
            return this.f8711a[0];
        }

        public a(b... bVarArr) {
            this.f8711a = bVarArr;
        }

        public final int b() {
            return this.f8711a.length;
        }
    }

    public dm1(a aVar, a aVar2, int i) {
        this.f8710a = aVar;
        this.b = aVar2;
        this.c = i;
        this.d = aVar == aVar2;
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f8712a;
        public final int b;
        public final float[] c;
        public final float[] d;

        public b(int i, float[] fArr, float[] fArr2, int i2) {
            this.f8712a = i;
            hg.a(((long) fArr.length) * 2 == ((long) fArr2.length) * 3);
            this.c = fArr;
            this.d = fArr2;
            this.b = i2;
        }

        public final int a() {
            return this.c.length / 3;
        }
    }
}
