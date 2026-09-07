package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.view.ViewGroup;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class gr0<V extends ViewGroup> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f9031a;
    private final ViewGroup b;
    private final fr0<V> c;
    private final dr0<V> d;
    private final cr0<V> e;

    public gr0(Context context, ViewGroup container, ArrayList designs, fr0 layoutDesignProvider, dr0 layoutDesignCreator, cr0 layoutDesignBinder) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(designs, "designs");
        Intrinsics.checkNotNullParameter(layoutDesignProvider, "layoutDesignProvider");
        Intrinsics.checkNotNullParameter(layoutDesignCreator, "layoutDesignCreator");
        Intrinsics.checkNotNullParameter(layoutDesignBinder, "layoutDesignBinder");
        this.f9031a = context;
        this.b = container;
        this.c = layoutDesignProvider;
        this.d = layoutDesignCreator;
        this.e = layoutDesignBinder;
    }

    public final boolean a() {
        ViewGroup viewGroupA;
        br0<V> br0VarA = this.c.a(this.f9031a);
        if (br0VarA == null || (viewGroupA = this.d.a(this.b, br0VarA)) == null) {
            return false;
        }
        this.e.a(this.b, viewGroupA, br0VarA);
        return true;
    }

    public final void b() {
        this.e.a(this.b);
    }
}
