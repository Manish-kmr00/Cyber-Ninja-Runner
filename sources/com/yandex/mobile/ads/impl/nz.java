package com.yandex.mobile.ads.impl;

import android.util.SparseArray;
import java.lang.reflect.Constructor;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes5.dex */
public final class nz implements z30 {
    private static final SparseArray<Constructor<? extends y30>> c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final vm.a f9764a;
    private final Executor b;

    static {
        SparseArray<Constructor<? extends y30>> sparseArray = new SparseArray<>();
        try {
            sparseArray.put(0, a(Class.forName("com.monetization.ads.exo.source.dash.offline.DashDownloader")));
        } catch (ClassNotFoundException unused) {
        }
        try {
            sparseArray.put(2, a(Class.forName("com.monetization.ads.exo.source.hls.offline.HlsDownloader")));
        } catch (ClassNotFoundException unused2) {
        }
        try {
            sparseArray.put(1, a(Class.forName("com.monetization.ads.exo.source.smoothstreaming.offline.SsDownloader")));
        } catch (ClassNotFoundException unused3) {
        }
        c = sparseArray;
    }

    public nz(vm.a aVar, ExecutorService executorService) {
        this.f9764a = (vm.a) hg.a(aVar);
        this.b = (Executor) hg.a(executorService);
    }

    public final y30 a(x30 x30Var) {
        int iA = x82.a(x30Var.c, x30Var.d);
        if (iA != 0 && iA != 1 && iA != 2) {
            if (iA == 4) {
                return new yl1(new fw0.a().a(x30Var.c).a(x30Var.g).a(), this.f9764a, this.b);
            }
            throw new IllegalArgumentException(oe.a("Unsupported type: ", iA));
        }
        Constructor<? extends y30> constructor = c.get(iA);
        if (constructor != null) {
            try {
                return constructor.newInstance(new fw0.a().a(x30Var.c).a(x30Var.e).a(x30Var.g).a(), this.f9764a, this.b);
            } catch (Exception unused) {
                throw new IllegalStateException(oe.a("Failed to instantiate downloader for content type ", iA));
            }
        }
        throw new IllegalStateException(oe.a("Module missing for content type ", iA));
    }

    private static Constructor<? extends y30> a(Class<?> cls) {
        try {
            return cls.asSubclass(y30.class).getConstructor(fw0.class, vm.a.class, Executor.class);
        } catch (NoSuchMethodException e) {
            throw new IllegalStateException("Downloader constructor missing", e);
        }
    }
}
