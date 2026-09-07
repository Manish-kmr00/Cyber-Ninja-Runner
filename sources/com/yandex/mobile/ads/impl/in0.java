package com.yandex.mobile.ads.impl;

/* JADX INFO: loaded from: classes10.dex */
public final class in0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f9247a;
    private final float b;
    private final boolean c;
    private final float d;

    /* synthetic */ in0(a aVar) {
        this(aVar.e(), aVar.b(), aVar.d(), aVar.c());
    }

    public final boolean d() {
        return this.f9247a;
    }

    public final float a() {
        return this.b;
    }

    private in0(boolean z, float f, boolean z2, float f2) {
        this.f9247a = z;
        this.b = f;
        this.c = z2;
        this.d = f2;
    }

    public final boolean c() {
        return this.c;
    }

    public final float b() {
        return this.d;
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f9248a;
        private float b;
        private boolean c;
        private float d;

        public final boolean e() {
            return this.f9248a;
        }

        public final float b() {
            return this.b;
        }

        public final void b(float f) {
            this.d = f;
        }

        public final boolean d() {
            return this.c;
        }

        public final float c() {
            return this.d;
        }

        public final a a(float f) {
            this.b = f;
            return this;
        }

        public final void a(boolean z) {
            this.c = z;
        }

        public final in0 a() {
            return new in0(this);
        }

        public final a b(boolean z) {
            this.f9248a = z;
            return this;
        }
    }
}
