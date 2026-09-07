package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes12.dex */
public final class cv1<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o3 f8644a;
    private final j9 b;
    private final bv1<T> c;

    public cv1(o3 adConfiguration, j9 sizeValidator, bv1<T> sdkHtmlAdCreateController) {
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(sizeValidator, "sizeValidator");
        Intrinsics.checkNotNullParameter(sdkHtmlAdCreateController, "sdkHtmlAdCreateController");
        this.f8644a = adConfiguration;
        this.b = sizeValidator;
        this.c = sdkHtmlAdCreateController;
    }

    public final void a() {
        this.c.a();
    }

    public final void a(Context context, o8<String> adResponse, dv1<T> creationListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(creationListener, "creationListener");
        String strI = adResponse.I();
        zy1 zy1VarM = adResponse.M();
        boolean zA = this.b.a(context, zy1VarM);
        zy1 zy1VarR = this.f8644a.r();
        if (!zA) {
            creationListener.a(w7.k());
            return;
        }
        if (zy1VarR == null) {
            creationListener.a(w7.m());
            return;
        }
        if (!bz1.a(context, adResponse, zy1VarM, this.b, zy1VarR)) {
            creationListener.a(w7.a(zy1VarR.c(context), zy1VarR.a(context), zy1VarM.getWidth(), zy1VarM.getHeight(), oh2.c(context), oh2.b(context)));
            return;
        }
        if (strI != null && !StringsKt.isBlank(strI)) {
            if (!oa.a(context)) {
                creationListener.a(w7.z());
                return;
            }
            try {
                this.c.a(adResponse, zy1VarR, strI, creationListener);
                return;
            } catch (lj2 unused) {
                creationListener.a(w7.y());
                return;
            }
        }
        creationListener.a(w7.k());
    }
}
