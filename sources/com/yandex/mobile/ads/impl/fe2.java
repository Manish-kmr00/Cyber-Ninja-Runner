package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class fe2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile v30 f8888a;
    private static final Object b = new Object();
    public static final /* synthetic */ int c = 0;

    public static v30 b(Context context) {
        v30 v30VarA;
        Intrinsics.checkNotNullParameter(context, "context");
        v30 v30Var = f8888a;
        if (v30Var != null) {
            return v30Var;
        }
        synchronized (b) {
            v30 v30Var2 = f8888a;
            if (v30Var2 != null) {
                return v30Var2;
            }
            try {
                v30VarA = a(context);
                f8888a = v30VarA;
            } catch (Throwable th) {
                String str = "Exception during DownloadManager creating. Exception: " + th;
                op0.b(new Object[0]);
                v30VarA = null;
            }
            return v30VarA;
        }
    }

    private static v30 a(Context context) {
        Context context2 = context.getApplicationContext();
        d22 databaseProvider = new d22(context2);
        int i = a70.e;
        a70 a70VarA = a70.a.a();
        Intrinsics.checkNotNull(context2);
        rm cache = a70VarA.a(context2);
        lz.a upstreamFactory = new lz.a(context2, new vu1(ws1.a()).a(context2));
        ExecutorService executor = Executors.newFixedThreadPool(4);
        Intrinsics.checkNotNull(executor);
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(databaseProvider, "databaseProvider");
        Intrinsics.checkNotNullParameter(cache, "cache");
        Intrinsics.checkNotNullParameter(upstreamFactory, "upstreamFactory");
        Intrinsics.checkNotNullParameter(executor, "executor");
        return new v30(context2, new mz(databaseProvider, 0), new nz(new vm.a().a(cache).a(upstreamFactory), executor));
    }
}
