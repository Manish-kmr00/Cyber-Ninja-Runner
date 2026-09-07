package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer;

import android.content.Context;
import android.view.View;
import androidx.compose.ui.graphics.Color;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class s {
    public static final int i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f7163a;
    public final Boolean b;
    public final int c;
    public final int d;
    public final int e;
    public final boolean f;
    public final boolean g;
    public final Function2<Context, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i, View> h;

    public s() {
        this(false, null, 0, 0, 0, false, false, null, 255, null);
    }

    public final boolean a() {
        return this.g;
    }

    public final boolean b() {
        return this.f;
    }

    public final int c() {
        return this.d;
    }

    public final int d() {
        return this.e;
    }

    public final Boolean e() {
        return this.b;
    }

    public final int f() {
        return this.c;
    }

    public final boolean g() {
        return this.f7163a;
    }

    public final Function2<Context, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i, View> h() {
        return this.h;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public s(boolean z, Boolean bool, int i2, int i3, int i4, boolean z2, boolean z3, Function2<? super Context, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i, ? extends View> VastRenderer) {
        Intrinsics.checkNotNullParameter(VastRenderer, "VastRenderer");
        this.f7163a = z;
        this.b = bool;
        this.c = i2;
        this.d = i3;
        this.e = i4;
        this.f = z2;
        this.g = z3;
        this.h = VastRenderer;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ s(boolean z, Boolean bool, int i2, int i3, int i4, boolean z2, boolean z3, Function2 function2, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        Function2 function2A;
        boolean z4 = (i5 & 1) != 0 ? true : z;
        Boolean bool2 = (i5 & 2) != 0 ? null : bool;
        int i6 = (i5 & 4) != 0 ? 5 : i2;
        int i7 = (i5 & 8) != 0 ? 5 : i3;
        int i8 = (i5 & 16) == 0 ? i4 : 5;
        boolean z5 = (i5 & 32) != 0 ? false : z2;
        boolean z6 = (i5 & 64) == 0 ? z3 : false;
        if ((i5 & 128) != 0) {
            function2A = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.n.a((1023 & 1) != 0 ? Color.INSTANCE.m1657getBlack0d7_KjU() : 0L, (1023 & 2) != 0 ? com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.n.i.f7028a : null, (1023 & 4) != 0 ? com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.n.j.f7029a : null, (1023 & 8) != 0 ? com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.n.k.f7030a : null, (1023 & 16) != 0 ? com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.n.l.f7031a : null, (1023 & 32) != 0 ? null : null, (1023 & 64) != 0 ? com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.n.m.f7032a : null, (1023 & 128) != 0 ? com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.n.C0675n.f7033a : null, (1023 & 256) != 0 ? com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.n.o.f7034a : null, (1023 & 512) != 0 ? com.moloco.sdk.service_locator.a.h.f6477a.h() : null);
        } else {
            function2A = function2;
        }
        this(z4, bool2, i6, i7, i8, z5, z6, function2A);
    }
}
