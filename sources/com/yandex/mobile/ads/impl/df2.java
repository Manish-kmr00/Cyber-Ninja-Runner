package com.yandex.mobile.ads.impl;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class df2 implements ku {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f8690a;
    private final dt0 b;
    private final LinkedHashSet c;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(df2 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Iterator it = this$0.a().iterator();
        while (it.hasNext()) {
            ((ku) it.next()).onVideoPaused();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(df2 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Iterator it = this$0.a().iterator();
        while (it.hasNext()) {
            ((ku) it.next()).onVideoPrepared();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(df2 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Iterator it = this$0.a().iterator();
        while (it.hasNext()) {
            ((ku) it.next()).onVideoResumed();
        }
    }

    public final void a(ue2 listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        synchronized (this.f8690a) {
            this.c.add(listener);
        }
    }

    public /* synthetic */ df2() {
        this(new Object(), new dt0());
    }

    private final HashSet a() {
        HashSet hashSet;
        synchronized (this.f8690a) {
            hashSet = new HashSet(this.c);
        }
        return hashSet;
    }

    public df2(Object lock, dt0 mainThreadExecutor) {
        Intrinsics.checkNotNullParameter(lock, "lock");
        Intrinsics.checkNotNullParameter(mainThreadExecutor, "mainThreadExecutor");
        this.f8690a = lock;
        this.b = mainThreadExecutor;
        this.c = new LinkedHashSet();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(df2 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Iterator it = this$0.a().iterator();
        while (it.hasNext()) {
            ((ku) it.next()).onVideoCompleted();
        }
    }

    public final void b() {
        this.c.clear();
        this.b.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(df2 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Iterator it = this$0.a().iterator();
        while (it.hasNext()) {
            ((ku) it.next()).onVideoError();
        }
    }

    @Override // com.yandex.mobile.ads.impl.ku
    public final void onVideoPrepared() {
        this.b.a(new Runnable() { // from class: com.yandex.mobile.ads.impl.df2$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                df2.d(this.f$0);
            }
        });
    }

    @Override // com.yandex.mobile.ads.impl.ku
    public final void onVideoCompleted() {
        this.b.a(new Runnable() { // from class: com.yandex.mobile.ads.impl.df2$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                df2.a(this.f$0);
            }
        });
    }

    @Override // com.yandex.mobile.ads.impl.ku
    public final void onVideoResumed() {
        this.b.a(new Runnable() { // from class: com.yandex.mobile.ads.impl.df2$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                df2.e(this.f$0);
            }
        });
    }

    @Override // com.yandex.mobile.ads.impl.ku
    public final void onVideoPaused() {
        this.b.a(new Runnable() { // from class: com.yandex.mobile.ads.impl.df2$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                df2.c(this.f$0);
            }
        });
    }

    @Override // com.yandex.mobile.ads.impl.ku
    public final void onVideoError() {
        this.b.a(new Runnable() { // from class: com.yandex.mobile.ads.impl.df2$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                df2.b(this.f$0);
            }
        });
    }
}
