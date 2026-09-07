package com.yandex.mobile.ads.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class nc1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o3 f9721a;
    private final o8<?> b;
    private final List<ig<?>> c;
    private final rr0 d;
    private final bk0 e;

    public /* synthetic */ nc1(o3 o3Var, o8 o8Var, List list, rr0 rr0Var) {
        this(o3Var, o8Var, list, rr0Var, new bk0());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public nc1(o3 adConfiguration, o8<?> adResponse, List<? extends ig<?>> assets, rr0 rr0Var, bk0 imageValuesProvider) {
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(assets, "assets");
        Intrinsics.checkNotNullParameter(imageValuesProvider, "imageValuesProvider");
        this.f9721a = adConfiguration;
        this.b = adResponse;
        this.c = assets;
        this.d = rr0Var;
        this.e = imageValuesProvider;
    }

    public final boolean a() {
        if (this.f9721a.u()) {
            if (this.b.Q()) {
                Set<uj0> setA = this.e.a(this.c, this.d);
                if (!setA.isEmpty()) {
                    Iterator<T> it = setA.iterator();
                    while (it.hasNext()) {
                        if (!((uj0) it.next()).b()) {
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }
}
