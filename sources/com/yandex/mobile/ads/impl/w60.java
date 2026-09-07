package com.yandex.mobile.ads.impl;

import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class w60 {
    private static final long c = TimeUnit.SECONDS.toMillis(10);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final di1.b f10536a;
    private final ig1 b;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ w60(di1.b bVar) {
        this(bVar, ig1.a.a(false));
        int i = ig1.f9217a;
    }

    public w60(di1.b eventListener, ig1 pausableTimer) {
        Intrinsics.checkNotNullParameter(eventListener, "eventListener");
        Intrinsics.checkNotNullParameter(pausableTimer, "pausableTimer");
        this.f10536a = eventListener;
        this.b = pausableTimer;
    }

    public final void b() {
        this.b.stop();
    }

    private final class a implements kg1 {
        public a() {
        }

        @Override // com.yandex.mobile.ads.impl.kg1
        public final void a() {
            w60.this.f10536a.b(j60.a());
        }
    }

    public final void a() {
        this.b.a(c, new a());
    }
}
