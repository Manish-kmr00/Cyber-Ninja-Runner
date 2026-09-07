package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes11.dex */
public final class i {
    public static final int d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<Unit> f6996a;
    public final Function0<Unit> b;
    public final Function0<Unit> c;

    public i() {
        this(null, null, null, 7, null);
    }

    public final Function0<Unit> a() {
        return this.b;
    }

    public final Function0<Unit> b() {
        return this.c;
    }

    public final Function0<Unit> c() {
        return this.f6996a;
    }

    public i(Function0<Unit> function0, Function0<Unit> function1, Function0<Unit> function2) {
        this.f6996a = function0;
        this.b = function1;
        this.c = function2;
    }

    public /* synthetic */ i(Function0 function0, Function0 function1, Function0 function2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : function0, (i & 2) != 0 ? null : function1, (i & 4) != 0 ? null : function2);
    }
}
