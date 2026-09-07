package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class dr0<V extends ViewGroup> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zs1<V> f8725a;

    public final V a(ViewGroup container, br0<V> layoutDesign) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(layoutDesign, "layoutDesign");
        Context context = container.getContext();
        int iC = layoutDesign.c();
        Class<V> clsD = layoutDesign.d();
        zs1<V> zs1Var = this.f8725a;
        Intrinsics.checkNotNull(context);
        zs1Var.getClass();
        return (V) zs1.a(context, clsD, iC, container);
    }

    public /* synthetic */ dr0() {
        this(new zs1());
    }

    public dr0(zs1<V> safeLayoutInflater) {
        Intrinsics.checkNotNullParameter(safeLayoutInflater, "safeLayoutInflater");
        this.f8725a = safeLayoutInflater;
    }
}
