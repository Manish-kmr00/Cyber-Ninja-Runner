package com.moloco.sdk.internal.utils;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.sync.Mutex;

/* JADX INFO: loaded from: classes9.dex */
public final class d implements CoroutineContext.Key<c> {
    public static final int b = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Mutex f6446a;

    public d(Mutex mutex) {
        Intrinsics.checkNotNullParameter(mutex, "mutex");
        this.f6446a = mutex;
    }

    public final Mutex a() {
        return this.f6446a;
    }

    public final Mutex b() {
        return this.f6446a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof d) && Intrinsics.areEqual(this.f6446a, ((d) obj).f6446a);
    }

    public int hashCode() {
        return this.f6446a.hashCode();
    }

    public String toString() {
        return "ReentrantMutexContextKey(mutex=" + this.f6446a + ')';
    }

    public final d a(Mutex mutex) {
        Intrinsics.checkNotNullParameter(mutex, "mutex");
        return new d(mutex);
    }

    public static /* synthetic */ d a(d dVar, Mutex mutex, int i, Object obj) {
        if ((i & 1) != 0) {
            mutex = dVar.f6446a;
        }
        return dVar.a(mutex);
    }
}
