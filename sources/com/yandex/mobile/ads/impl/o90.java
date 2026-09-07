package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class o90 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o3 f9795a;
    private final f30 b;

    public final n90 a(Context context, List<rk1> preloadedDivKitDesigns) {
        Object next;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(preloadedDivKitDesigns, "preloadedDivKitDesigns");
        this.b.getClass();
        if (f30.a(context)) {
            Iterator<T> it = preloadedDivKitDesigns.iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!Intrinsics.areEqual(((rk1) next).c().e(), e10.c.a()));
            rk1 rk1Var = (rk1) next;
            if (rk1Var != null) {
                return new n90(rk1Var, this.f9795a, new j20(), new er0());
            }
        }
        return null;
    }

    public /* synthetic */ o90(o3 o3Var) {
        this(o3Var, new f30());
    }

    public o90(o3 adConfiguration, f30 divKitIntegrationValidator) {
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(divKitIntegrationValidator, "divKitIntegrationValidator");
        this.f9795a = adConfiguration;
        this.b = divKitIntegrationValidator;
    }
}
