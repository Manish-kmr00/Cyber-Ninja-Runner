package com.yandex.mobile.ads.impl;

import android.content.Context;
import com.yandex.div2.DivData;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class hj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o3 f9101a;
    private final f30 b;

    public final gj a(Context context, m61 nativeAdPrivate) {
        y20 y20Var;
        Object next;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(nativeAdPrivate, "nativeAdPrivate");
        this.b.getClass();
        if (f30.a(context)) {
            List<y20> listC = nativeAdPrivate.c();
            if (listC != null) {
                Iterator<T> it = listC.iterator();
                do {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                } while (!Intrinsics.areEqual(((y20) next).e(), e10.c.a()));
                y20Var = (y20) next;
            } else {
                y20Var = null;
            }
            if (y20Var != null) {
                DivData divDataB = y20Var.b();
                o3 o3Var = this.f9101a;
                return new gj(divDataB, o3Var, new j20(), new t10(o3Var.q().c(), new yz1()), new er0());
            }
        }
        return null;
    }

    public /* synthetic */ hj(o3 o3Var) {
        this(o3Var, new f30());
    }

    public hj(o3 adConfiguration, f30 divKitIntegrationValidator) {
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(divKitIntegrationValidator, "divKitIntegrationValidator");
        this.f9101a = adConfiguration;
        this.b = divKitIntegrationValidator;
    }
}
