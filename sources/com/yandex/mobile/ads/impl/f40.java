package com.yandex.mobile.ads.impl;

import android.os.Looper;

/* JADX INFO: loaded from: classes9.dex */
public interface f40 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f40 f8865a = new a();

    public interface b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f8866a = new b() { // from class: com.yandex.mobile.ads.impl.f40$b$$ExternalSyntheticLambda0
            @Override // com.yandex.mobile.ads.impl.f40.b
            public final void release() {
                f40.b.lambda$static$0();
            }
        };

        static /* synthetic */ void lambda$static$0() {
        }

        void release();
    }

    int a(gc0 gc0Var);

    default b a(e40.a aVar, gc0 gc0Var) {
        return b.f8866a;
    }

    void a(Looper looper, ii1 ii1Var);

    d40 b(e40.a aVar, gc0 gc0Var);

    default void prepare() {
    }

    default void release() {
    }

    final class a implements f40 {
        @Override // com.yandex.mobile.ads.impl.f40
        public final void a(Looper looper, ii1 ii1Var) {
        }

        a() {
        }

        @Override // com.yandex.mobile.ads.impl.f40
        public final d40 b(e40.a aVar, gc0 gc0Var) {
            if (gc0Var.p == null) {
                return null;
            }
            return new r50(new d40.a(new e82(), 6001));
        }

        @Override // com.yandex.mobile.ads.impl.f40
        public final int a(gc0 gc0Var) {
            return gc0Var.p != null ? 1 : 0;
        }
    }
}
