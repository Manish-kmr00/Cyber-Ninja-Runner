package com.yandex.mobile.ads.impl;

/* JADX INFO: loaded from: classes11.dex */
public interface e70 extends v52 {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final r52 f8769a;
        public final int[] b;
        public final int c;

        public a(int i, r52 r52Var, int[] iArr) {
            if (iArr.length == 0) {
                at0.a("ETSDefinition", "Empty tracks are not allowed", new IllegalArgumentException());
            }
            this.f8769a = r52Var;
            this.b = iArr;
            this.c = i;
        }
    }

    public interface b {
    }

    void a(float f);

    default void a(boolean z) {
    }

    void c();

    void d();

    gc0 e();

    default void f() {
    }

    default void g() {
    }
}
