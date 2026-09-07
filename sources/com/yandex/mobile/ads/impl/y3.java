package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.lang.ref.WeakReference;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class y3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zp1 f10696a;
    private final WeakReference<bk<?>> b;

    public static final class a {
        public static w3 a(o3 o3Var, x3 adFetchStatus) {
            Intrinsics.checkNotNullParameter(adFetchStatus, "adFetchStatus");
            switch (adFetchStatus.ordinal()) {
                case 0:
                case 5:
                    int i = w7.A;
                    return w7.a(o3Var != null ? o3Var.c() : null);
                case 1:
                    return w7.k();
                case 2:
                    return w7.q();
                case 3:
                    return w7.j();
                case 4:
                    return w7.v();
                case 6:
                    return w7.h();
                case 7:
                    return w7.g();
                case 8:
                    return w7.u();
                case 9:
                    return w7.p();
                case 10:
                    return w7.w();
                case 11:
                    return w7.a();
                case 12:
                    return w7.c();
                case 13:
                    return w7.r();
                case 14:
                    return w7.n();
                default:
                    throw new NoWhenBranchMatchedException();
            }
        }
    }

    public y3(bk<?> loadController, zp1 requestManager, WeakReference<bk<?>> loadControllerRef) {
        Intrinsics.checkNotNullParameter(loadController, "loadController");
        Intrinsics.checkNotNullParameter(requestManager, "requestManager");
        Intrinsics.checkNotNullParameter(loadControllerRef, "loadControllerRef");
        this.f10696a = requestManager;
        this.b = loadControllerRef;
    }

    public final void a() {
        bk<?> bkVar = this.b.get();
        if (bkVar != null) {
            zp1 zp1Var = this.f10696a;
            Context contextL = bkVar.l();
            String strA = oa.a(bkVar);
            zp1Var.getClass();
            zp1.a(contextL, strA);
        }
    }

    public final void a(zj<?> request) {
        Intrinsics.checkNotNullParameter(request, "request");
        bk<?> bkVar = this.b.get();
        if (bkVar != null) {
            zp1 zp1Var = this.f10696a;
            Context context = bkVar.l();
            synchronized (zp1Var) {
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(request, "request");
                dd1.a(context).a(request);
            }
        }
    }

    public final void b() {
        a();
        this.b.clear();
    }
}
