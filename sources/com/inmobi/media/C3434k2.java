package com.inmobi.media;

import java.util.concurrent.FutureTask;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.inmobi.media.k2, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C3434k2 extends FutureTask implements Comparable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile B9 f3354a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3434k2(Runnable runnable, B9 priority) {
        super(runnable, null);
        Intrinsics.checkNotNullParameter(priority, "priority");
        this.f3354a = priority;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        C3434k2 other = (C3434k2) obj;
        Intrinsics.checkNotNullParameter(other, "other");
        return Intrinsics.compare(this.f3354a.f3034a, other.f3354a.f3034a);
    }
}
