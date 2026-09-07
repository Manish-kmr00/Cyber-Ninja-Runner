package com.yandex.mobile.ads.impl;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class hm0 implements ht {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f9113a;
    private final dt0 b;
    private final LinkedHashMap c;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(Set set, do0 videoAd) {
        Intrinsics.checkNotNullParameter(videoAd, "$videoAd");
        Iterator it = set.iterator();
        while (it.hasNext()) {
            ((ht) it.next()).i(videoAd);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(Set set, do0 videoAd) {
        Intrinsics.checkNotNullParameter(videoAd, "$videoAd");
        Iterator it = set.iterator();
        while (it.hasNext()) {
            ((ht) it.next()).g(videoAd);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(Set set, do0 videoAd) {
        Intrinsics.checkNotNullParameter(videoAd, "$videoAd");
        Iterator it = set.iterator();
        while (it.hasNext()) {
            ((ht) it.next()).c(videoAd);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(Set set, do0 videoAd) {
        Intrinsics.checkNotNullParameter(videoAd, "$videoAd");
        Iterator it = set.iterator();
        while (it.hasNext()) {
            ((ht) it.next()).b(videoAd);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(Set set, do0 videoAd) {
        Intrinsics.checkNotNullParameter(videoAd, "$videoAd");
        Iterator it = set.iterator();
        while (it.hasNext()) {
            ((ht) it.next()).e(videoAd);
        }
    }

    public final void a(do0 videoAd, ht listener) {
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
        Intrinsics.checkNotNullParameter(listener, "listener");
        synchronized (this.f9113a) {
            Set hashSet = (Set) this.c.get(videoAd);
            if (hashSet == null) {
                hashSet = new HashSet();
                this.c.put(videoAd, hashSet);
            }
            hashSet.add(listener);
        }
    }

    @Override // com.yandex.mobile.ads.impl.ht
    public final void g(final do0 videoAd) {
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
        final HashSet hashSetJ = j(videoAd);
        if (hashSetJ != null) {
            this.b.a(new Runnable() { // from class: com.yandex.mobile.ads.impl.hm0$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    hm0.c(hashSetJ, videoAd);
                }
            });
        }
    }

    @Override // com.yandex.mobile.ads.impl.ht
    public final void h(final do0 videoAd) {
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
        final HashSet hashSetJ = j(videoAd);
        if (hashSetJ != null) {
            this.b.a(new Runnable() { // from class: com.yandex.mobile.ads.impl.hm0$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    hm0.a(hashSetJ, videoAd);
                }
            });
        }
    }

    @Override // com.yandex.mobile.ads.impl.ht
    public final void i(final do0 videoAd) {
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
        final HashSet hashSetJ = j(videoAd);
        if (hashSetJ != null) {
            this.b.a(new Runnable() { // from class: com.yandex.mobile.ads.impl.hm0$$ExternalSyntheticLambda8
                @Override // java.lang.Runnable
                public final void run() {
                    hm0.b(hashSetJ, videoAd);
                }
            });
        }
    }

    public /* synthetic */ hm0() {
        this(new Object(), new dt0());
    }

    private final HashSet j(do0 do0Var) {
        HashSet hashSet;
        synchronized (this.f9113a) {
            Set set = (Set) this.c.get(do0Var);
            hashSet = set != null ? new HashSet(set) : null;
        }
        return hashSet;
    }

    public hm0(Object lock, dt0 mainThreadExecutor) {
        Intrinsics.checkNotNullParameter(lock, "lock");
        Intrinsics.checkNotNullParameter(mainThreadExecutor, "mainThreadExecutor");
        this.f9113a = lock;
        this.b = mainThreadExecutor;
        this.c = new LinkedHashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Set set, do0 videoAd) {
        Intrinsics.checkNotNullParameter(videoAd, "$videoAd");
        Iterator it = set.iterator();
        while (it.hasNext()) {
            ((ht) it.next()).h(videoAd);
        }
    }

    @Override // com.yandex.mobile.ads.impl.ht
    public final void e(final do0 videoAd) {
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
        final HashSet hashSetJ = j(videoAd);
        if (hashSetJ != null) {
            this.b.a(new Runnable() { // from class: com.yandex.mobile.ads.impl.hm0$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    hm0.f(hashSetJ, videoAd);
                }
            });
        }
    }

    @Override // com.yandex.mobile.ads.impl.ht
    public final void d(final do0 videoAd) {
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
        final HashSet hashSetJ = j(videoAd);
        if (hashSetJ != null) {
            this.b.a(new Runnable() { // from class: com.yandex.mobile.ads.impl.hm0$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    hm0.h(hashSetJ, videoAd);
                }
            });
        }
    }

    @Override // com.yandex.mobile.ads.impl.ht
    public final void f(final do0 videoAd) {
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
        final HashSet hashSetJ = j(videoAd);
        if (hashSetJ != null) {
            this.b.a(new Runnable() { // from class: com.yandex.mobile.ads.impl.hm0$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    hm0.i(hashSetJ, videoAd);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(Set set, do0 videoAd) {
        Intrinsics.checkNotNullParameter(videoAd, "$videoAd");
        Iterator it = set.iterator();
        while (it.hasNext()) {
            ((ht) it.next()).f(videoAd);
        }
    }

    @Override // com.yandex.mobile.ads.impl.ht
    public final void b(final do0 videoAd) {
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
        final HashSet hashSetJ = j(videoAd);
        if (hashSetJ != null) {
            this.b.a(new Runnable() { // from class: com.yandex.mobile.ads.impl.hm0$$ExternalSyntheticLambda7
                @Override // java.lang.Runnable
                public final void run() {
                    hm0.e(hashSetJ, videoAd);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(Set set, do0 videoAd) {
        Intrinsics.checkNotNullParameter(videoAd, "$videoAd");
        Iterator it = set.iterator();
        while (it.hasNext()) {
            ((ht) it.next()).d(videoAd);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(Set set, do0 videoAd) {
        Intrinsics.checkNotNullParameter(videoAd, "$videoAd");
        Iterator it = set.iterator();
        while (it.hasNext()) {
            ((ht) it.next()).a(videoAd);
        }
    }

    @Override // com.yandex.mobile.ads.impl.ht
    public final void c(final do0 videoAd) {
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
        final HashSet hashSetJ = j(videoAd);
        if (hashSetJ != null) {
            this.b.a(new Runnable() { // from class: com.yandex.mobile.ads.impl.hm0$$ExternalSyntheticLambda6
                @Override // java.lang.Runnable
                public final void run() {
                    hm0.d(hashSetJ, videoAd);
                }
            });
        }
    }

    @Override // com.yandex.mobile.ads.impl.ht
    public final void a(final do0 videoAd) {
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
        final HashSet hashSetJ = j(videoAd);
        if (hashSetJ != null) {
            this.b.a(new Runnable() { // from class: com.yandex.mobile.ads.impl.hm0$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    hm0.g(hashSetJ, videoAd);
                }
            });
        }
    }

    public final void b(do0 videoAd, ht listener) {
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
        Intrinsics.checkNotNullParameter(listener, "listener");
        synchronized (this.f9113a) {
            Set set = (Set) this.c.get(videoAd);
            if (set != null) {
                Iterator it = set.iterator();
                while (it.hasNext()) {
                    if (Intrinsics.areEqual(listener, (ht) it.next())) {
                        it.remove();
                    }
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // com.yandex.mobile.ads.impl.ht
    public final void a(final do0 videoAd, final pc2 error) {
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
        Intrinsics.checkNotNullParameter(error, "error");
        final HashSet hashSetJ = j(videoAd);
        if (hashSetJ != null) {
            this.b.a(new Runnable() { // from class: com.yandex.mobile.ads.impl.hm0$$ExternalSyntheticLambda10
                @Override // java.lang.Runnable
                public final void run() {
                    hm0.a(hashSetJ, videoAd, error);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Set set, do0 videoAd, pc2 error) {
        Intrinsics.checkNotNullParameter(videoAd, "$videoAd");
        Intrinsics.checkNotNullParameter(error, "$error");
        Iterator it = set.iterator();
        while (it.hasNext()) {
            ((ht) it.next()).a(videoAd, error);
        }
    }

    @Override // com.yandex.mobile.ads.impl.ht
    public final void a(final do0 videoAd, final float f) {
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
        final HashSet hashSetJ = j(videoAd);
        if (hashSetJ != null) {
            this.b.a(new Runnable() { // from class: com.yandex.mobile.ads.impl.hm0$$ExternalSyntheticLambda9
                @Override // java.lang.Runnable
                public final void run() {
                    hm0.a(hashSetJ, videoAd, f);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Set set, do0 videoAd, float f) {
        Intrinsics.checkNotNullParameter(videoAd, "$videoAd");
        Iterator it = set.iterator();
        while (it.hasNext()) {
            ((ht) it.next()).a(videoAd, f);
        }
    }

    public final void a() {
        this.b.a();
    }
}
