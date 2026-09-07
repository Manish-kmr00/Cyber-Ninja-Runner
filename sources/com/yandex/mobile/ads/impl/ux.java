package com.yandex.mobile.ads.impl;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* JADX INFO: loaded from: classes6.dex */
public final class ux implements sx {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final js0 f10432a;
    private final ho1 b;
    private final zw c;
    private final CoroutineDispatcher d;
    private ox e;
    private final Mutex f;

    public ux(js0 localDataSource, ho1 remoteDataSource, zw dataMerger, CoroutineDispatcher ioDispatcher) {
        Intrinsics.checkNotNullParameter(localDataSource, "localDataSource");
        Intrinsics.checkNotNullParameter(remoteDataSource, "remoteDataSource");
        Intrinsics.checkNotNullParameter(dataMerger, "dataMerger");
        Intrinsics.checkNotNullParameter(ioDispatcher, "ioDispatcher");
        this.f10432a = localDataSource;
        this.b = remoteDataSource;
        this.c = dataMerger;
        this.d = ioDispatcher;
        this.f = MutexKt.Mutex$default(false, 1, null);
    }

    @Override // com.yandex.mobile.ads.impl.sx
    public final Object a(boolean z, ContinuationImpl continuationImpl) {
        return BuildersKt.withContext(this.d, new tx(this, z, null), continuationImpl);
    }

    @Override // com.yandex.mobile.ads.impl.sx
    public final boolean a() {
        return this.f10432a.a().c().a();
    }

    @Override // com.yandex.mobile.ads.impl.sx
    public final void a(boolean z) {
        this.f10432a.a(z);
    }
}
