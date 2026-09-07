package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class z60 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o10 f10793a;
    private final gy1 b;

    public final fy1 a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f10793a.getClass();
        File cacheDir = o10.a(context, "mobileads-video-cache");
        int i = iw1.l;
        cu1 cu1VarA = iw1.a.a().a(context);
        kr0 cacheEvictor = new kr0(f01.a.a(context, 41943040L, (cu1VarA == null || cu1VarA.B() == 0) ? 52428800L : cu1VarA.B()));
        h60 databaseProvider = new h60(context);
        this.b.getClass();
        Intrinsics.checkNotNullParameter(cacheDir, "cacheDir");
        Intrinsics.checkNotNullParameter(cacheEvictor, "cacheEvictor");
        Intrinsics.checkNotNullParameter(databaseProvider, "databaseProvider");
        return new fy1(cacheDir, cacheEvictor, databaseProvider);
    }

    public /* synthetic */ z60() {
        this(new o10(), new gy1());
    }

    public z60(o10 diskCacheProvider, gy1 simpleCacheFactory) {
        Intrinsics.checkNotNullParameter(diskCacheProvider, "diskCacheProvider");
        Intrinsics.checkNotNullParameter(simpleCacheFactory, "simpleCacheFactory");
        this.f10793a = diskCacheProvider;
        this.b = simpleCacheFactory;
    }
}
