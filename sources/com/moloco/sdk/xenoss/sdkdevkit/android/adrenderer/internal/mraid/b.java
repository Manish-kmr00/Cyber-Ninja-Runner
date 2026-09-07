package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.webkit.WebView;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.unit.Dp;
import java.lang.ref.WeakReference;
import kotlin.UInt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function10;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function9;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.flow.MutableStateFlow;

/* JADX INFO: loaded from: classes7.dex */
public final class b {
    public static Function9<? super Context, ? super WebView, ? super Integer, ? super MutableStateFlow<Boolean>, ? super Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, Unit>, ? super Function0<Unit>, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.t, ? super Dp, ? super Boolean, ? extends View> d;
    public static Function0<Unit> f;
    public static c g;
    public static com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.t h;
    public static Function0<Unit> i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f6626a = new b();
    public static WeakReference<j> b = new WeakReference<>(null);
    public static WeakReference<Activity> c = new WeakReference<>(null);
    public static Function2<? super Composer, ? super Integer, ? extends Function10<? super BoxScope, ? super Boolean, ? super Boolean, ? super Function0<Unit>, ? super Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, Unit>, ? super Boolean, ? super UInt, ? super UInt, ? super Composer, ? super Integer, Unit>> e = a.f6627a;

    public static final class a extends Lambda implements Function2<Composer, Integer, Function10<? super BoxScope, ? super Boolean, ? super Boolean, ? super Function0<? extends Unit>, ? super Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, ? extends Unit>, ? super Boolean, ? super UInt, ? super UInt, ? super Composer, ? super Integer, ? extends Unit>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f6627a = new a();

        public a() {
            super(2);
        }

        public final Function10<BoxScope, Boolean, Boolean, Function0<Unit>, Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, Unit>, Boolean, UInt, UInt, Composer, Integer, Unit> a(Composer composer, int i) {
            composer.startReplaceableGroup(39427356);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(39427356, i, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.MraidActivityDataHolder.closeButton.<anonymous> (MraidActivity.kt:259)");
            }
            Function10<BoxScope, Boolean, Boolean, Function0<Unit>, Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, Unit>, Boolean, UInt, UInt, Composer, Integer, Unit> function10A = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.q.a(null, null, 0L, 0L, 0L, null, null, null, composer, 0, 255);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            return function10A;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Function10<? super BoxScope, ? super Boolean, ? super Boolean, ? super Function0<? extends Unit>, ? super Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, ? extends Unit>, ? super Boolean, ? super UInt, ? super UInt, ? super Composer, ? super Integer, ? extends Unit> invoke(Composer composer, Integer num) {
            return a(composer, num.intValue());
        }
    }

    public final void a(j jVar) {
        b = new WeakReference<>(jVar);
    }

    public final Function2<Composer, Integer, Function10<BoxScope, Boolean, Boolean, Function0<Unit>, Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, Unit>, Boolean, UInt, UInt, Composer, Integer, Unit>> b() {
        return e;
    }

    public final Function9<Context, WebView, Integer, MutableStateFlow<Boolean>, Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, Unit>, Function0<Unit>, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.t, Dp, Boolean, View> c() {
        return d;
    }

    public final Function0<Unit> d() {
        return f;
    }

    public final Function0<Unit> e() {
        return i;
    }

    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.t f() {
        return h;
    }

    public final Activity g() {
        return c.get();
    }

    public final j h() {
        return b.get();
    }

    public final void a(Activity activity) {
        c = new WeakReference<>(activity);
    }

    public final void b(Function0<Unit> function0) {
        i = function0;
    }

    public final void a(Function9<? super Context, ? super WebView, ? super Integer, ? super MutableStateFlow<Boolean>, ? super Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, Unit>, ? super Function0<Unit>, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.t, ? super Dp, ? super Boolean, ? extends View> function9) {
        d = function9;
    }

    public final void a(Function2<? super Composer, ? super Integer, ? extends Function10<? super BoxScope, ? super Boolean, ? super Boolean, ? super Function0<Unit>, ? super Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, Unit>, ? super Boolean, ? super UInt, ? super UInt, ? super Composer, ? super Integer, Unit>> function2) {
        Intrinsics.checkNotNullParameter(function2, "<set-?>");
        e = function2;
    }

    public final void a(Function0<Unit> function0) {
        f = function0;
    }

    public final c a() {
        return g;
    }

    public final void a(c cVar) {
        g = cVar;
    }

    public final void a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.t tVar) {
        h = tVar;
    }
}
