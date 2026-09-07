package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.webkit.WebView;
import androidx.activity.compose.BackHandlerKt;
import androidx.compose.animation.CrossfadeKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.viewinterop.AndroidView_androidKt;
import com.moloco.sdk.R;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.q;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.s;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.m;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.t;
import kotlin.ResultKt;
import kotlin.UInt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function10;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function9;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: loaded from: classes6.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final float f7130a = Dp.m3843constructorimpl(12);

    public static final class a extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MutableState<Boolean> f7131a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(MutableState<Boolean> mutableState) {
            super(0);
            this.f7131a = mutableState;
        }

        public final void a() {
            this.f7131a.setValue(Boolean.TRUE);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.b$b, reason: collision with other inner class name */
    public static final class C0692b extends Lambda implements Function2<Composer, Integer, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WebView f7132a;
        public final /* synthetic */ int b;
        public final /* synthetic */ MutableState<Boolean> c;
        public final /* synthetic */ Function1<com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, Unit> d;
        public final /* synthetic */ Function0<Unit> e;
        public final /* synthetic */ Modifier f;
        public final /* synthetic */ long g;
        public final /* synthetic */ Function10<BoxScope, Boolean, Boolean, Function0<Unit>, Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, Unit>, Boolean, UInt, UInt, Composer, Integer, Unit> h;
        public final /* synthetic */ t i;
        public final /* synthetic */ float j;
        public final /* synthetic */ boolean k;
        public final /* synthetic */ int l;
        public final /* synthetic */ int m;
        public final /* synthetic */ int n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C0692b(WebView webView, int i, MutableState<Boolean> mutableState, Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, Unit> function1, Function0<Unit> function0, Modifier modifier, long j, Function10<? super BoxScope, ? super Boolean, ? super Boolean, ? super Function0<Unit>, ? super Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, Unit>, ? super Boolean, ? super UInt, ? super UInt, ? super Composer, ? super Integer, Unit> function10, t tVar, float f, boolean z, int i2, int i3, int i4) {
            super(2);
            this.f7132a = webView;
            this.b = i;
            this.c = mutableState;
            this.d = function1;
            this.e = function0;
            this.f = modifier;
            this.g = j;
            this.h = function10;
            this.i = tVar;
            this.j = f;
            this.k = z;
            this.l = i2;
            this.m = i3;
            this.n = i4;
        }

        public final void a(Composer composer, int i) {
            b.a(this.f7132a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, composer, this.l | 1, this.m, this.n);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            a(composer, num.intValue());
            return Unit.INSTANCE;
        }
    }

    public static final class c extends Lambda implements Function3<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i.a, Composer, Integer, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function9<Context, WebView, Integer, MutableStateFlow<Boolean>, Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, Unit>, Function0<Unit>, t, Dp, Boolean, View> f7133a;
        public final /* synthetic */ WebView b;
        public final /* synthetic */ int c;
        public final /* synthetic */ MutableStateFlow<Boolean> d;
        public final /* synthetic */ Function1<com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, Unit> e;
        public final /* synthetic */ t f;
        public final /* synthetic */ Function0<Unit> g;

        public static final class a extends Lambda implements Function1<Context, View> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Function9<Context, WebView, Integer, MutableStateFlow<Boolean>, Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, Unit>, Function0<Unit>, t, Dp, Boolean, View> f7134a;
            public final /* synthetic */ WebView b;
            public final /* synthetic */ int c;
            public final /* synthetic */ MutableStateFlow<Boolean> d;
            public final /* synthetic */ Function1<com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, Unit> e;
            public final /* synthetic */ t f;
            public final /* synthetic */ Function0<Unit> g;

            /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.b$c$a$a, reason: collision with other inner class name */
            public static final class C0693a extends Lambda implements Function0<Unit> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ MutableStateFlow<Boolean> f7135a;
                public final /* synthetic */ Function0<Unit> b;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C0693a(MutableStateFlow<Boolean> mutableStateFlow, Function0<Unit> function0) {
                    super(0);
                    this.f7135a = mutableStateFlow;
                    this.b = function0;
                }

                public final void a() {
                    b.a(this.f7135a, this.b);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    a();
                    return Unit.INSTANCE;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public a(Function9<? super Context, ? super WebView, ? super Integer, ? super MutableStateFlow<Boolean>, ? super Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, Unit>, ? super Function0<Unit>, ? super t, ? super Dp, ? super Boolean, ? extends View> function9, WebView webView, int i, MutableStateFlow<Boolean> mutableStateFlow, Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, Unit> function1, t tVar, Function0<Unit> function0) {
                super(1);
                this.f7134a = function9;
                this.b = webView;
                this.c = i;
                this.d = mutableStateFlow;
                this.e = function1;
                this.f = tVar;
                this.g = function0;
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final View invoke(Context it) {
                Intrinsics.checkNotNullParameter(it, "it");
                Function9<Context, WebView, Integer, MutableStateFlow<Boolean>, Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, Unit>, Function0<Unit>, t, Dp, Boolean, View> function9 = this.f7134a;
                WebView webView = this.b;
                Integer numValueOf = Integer.valueOf(this.c);
                MutableStateFlow<Boolean> mutableStateFlow = this.d;
                return function9.invoke(it, webView, numValueOf, mutableStateFlow, this.e, new C0693a(mutableStateFlow, this.g), this.f, Dp.m3841boximpl(b.a()), Boolean.TRUE);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public c(Function9<? super Context, ? super WebView, ? super Integer, ? super MutableStateFlow<Boolean>, ? super Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, Unit>, ? super Function0<Unit>, ? super t, ? super Dp, ? super Boolean, ? extends View> function9, WebView webView, int i, MutableStateFlow<Boolean> mutableStateFlow, Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, Unit> function1, t tVar, Function0<Unit> function0) {
            super(3);
            this.f7133a = function9;
            this.b = webView;
            this.c = i;
            this.d = mutableStateFlow;
            this.e = function1;
            this.f = tVar;
            this.g = function0;
        }

        public final void a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i.a aVar, Composer composer, int i) {
            int i2;
            if ((i & 14) == 0) {
                i2 = (composer.changed(aVar) ? 4 : 2) | i;
            } else {
                i2 = i;
            }
            if ((i2 & 91) == 18 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1935552634, i, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.MraidAdContainerScreen.<anonymous>.<anonymous> (AdWebViewRenderer.kt:219)");
            }
            if (aVar instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i.a.C0652a) {
                composer.startReplaceableGroup(1878992711);
                composer.endReplaceableGroup();
            } else if (aVar instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i.a.c) {
                composer.startReplaceableGroup(1878992774);
                composer.endReplaceableGroup();
            } else if (aVar instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i.a.b) {
                composer.startReplaceableGroup(1878992854);
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.f.a(((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i.a.b) aVar).d(), null, null, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), composer, 3504, 0);
                composer.endReplaceableGroup();
            } else if (aVar instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i.a.d) {
                composer.startReplaceableGroup(1878993130);
                AndroidView_androidKt.AndroidView(new a(this.f7133a, this.b, this.c, this.d, this.e, this.f, this.g), null, null, composer, 0, 6);
                composer.endReplaceableGroup();
            } else if (aVar == null) {
                composer.startReplaceableGroup(1878993738);
                composer.endReplaceableGroup();
            } else {
                composer.startReplaceableGroup(1878993754);
                composer.endReplaceableGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i.a aVar, Composer composer, Integer num) {
            a(aVar, composer, num.intValue());
            return Unit.INSTANCE;
        }
    }

    public static final class d extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MutableStateFlow<Boolean> f7136a;
        public final /* synthetic */ Function0<Unit> b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(MutableStateFlow<Boolean> mutableStateFlow, Function0<Unit> function0) {
            super(0);
            this.f7136a = mutableStateFlow;
            this.b = function0;
        }

        public final void a() {
            b.a(this.f7136a, this.b);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    public static final class e extends Lambda implements Function2<Composer, Integer, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f7137a;
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i b;
        public final /* synthetic */ WebView c;
        public final /* synthetic */ int d;
        public final /* synthetic */ Function1<com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, Unit> e;
        public final /* synthetic */ Function0<Unit> f;
        public final /* synthetic */ Function9<Context, WebView, Integer, MutableStateFlow<Boolean>, Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, Unit>, Function0<Unit>, t, Dp, Boolean, View> g;
        public final /* synthetic */ t h;
        public final /* synthetic */ Function10<BoxScope, Boolean, Boolean, Function0<Unit>, Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, Unit>, Boolean, UInt, UInt, Composer, Integer, Unit> i;
        public final /* synthetic */ Function10<BoxScope, Boolean, Boolean, Function0<Unit>, Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, Unit>, Boolean, UInt, UInt, Composer, Integer, Unit> j;
        public final /* synthetic */ int k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public e(Activity activity, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i iVar, WebView webView, int i, Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, Unit> function1, Function0<Unit> function0, Function9<? super Context, ? super WebView, ? super Integer, ? super MutableStateFlow<Boolean>, ? super Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, Unit>, ? super Function0<Unit>, ? super t, ? super Dp, ? super Boolean, ? extends View> function9, t tVar, Function10<? super BoxScope, ? super Boolean, ? super Boolean, ? super Function0<Unit>, ? super Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, Unit>, ? super Boolean, ? super UInt, ? super UInt, ? super Composer, ? super Integer, Unit> function10, Function10<? super BoxScope, ? super Boolean, ? super Boolean, ? super Function0<Unit>, ? super Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, Unit>, ? super Boolean, ? super UInt, ? super UInt, ? super Composer, ? super Integer, Unit> function11, int i2) {
            super(2);
            this.f7137a = activity;
            this.b = iVar;
            this.c = webView;
            this.d = i;
            this.e = function1;
            this.f = function0;
            this.g = function9;
            this.h = tVar;
            this.i = function10;
            this.j = function11;
            this.k = i2;
        }

        public final void a(Composer composer, int i) {
            b.a(this.f7137a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, composer, this.k | 1);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            a(composer, num.intValue());
            return Unit.INSTANCE;
        }
    }

    public static final class f extends Lambda implements Function1<Context, View> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function9<Context, WebView, Integer, MutableStateFlow<Boolean>, Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, Unit>, Function0<Unit>, t, Dp, Boolean, View> f7138a;
        public final /* synthetic */ WebView b;
        public final /* synthetic */ int c;
        public final /* synthetic */ MutableStateFlow<Boolean> d;
        public final /* synthetic */ Function1<com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, Unit> e;
        public final /* synthetic */ t f;
        public final /* synthetic */ Function0<Unit> g;

        public static final class a extends Lambda implements Function0<Unit> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ MutableStateFlow<Boolean> f7139a;
            public final /* synthetic */ Function0<Unit> b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(MutableStateFlow<Boolean> mutableStateFlow, Function0<Unit> function0) {
                super(0);
                this.f7139a = mutableStateFlow;
                this.b = function0;
            }

            public final void a() {
                b.b(this.f7139a, this.b);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                a();
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public f(Function9<? super Context, ? super WebView, ? super Integer, ? super MutableStateFlow<Boolean>, ? super Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, Unit>, ? super Function0<Unit>, ? super t, ? super Dp, ? super Boolean, ? extends View> function9, WebView webView, int i, MutableStateFlow<Boolean> mutableStateFlow, Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, Unit> function1, t tVar, Function0<Unit> function0) {
            super(1);
            this.f7138a = function9;
            this.b = webView;
            this.c = i;
            this.d = mutableStateFlow;
            this.e = function1;
            this.f = tVar;
            this.g = function0;
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final View invoke(Context it) {
            Intrinsics.checkNotNullParameter(it, "it");
            Function9<Context, WebView, Integer, MutableStateFlow<Boolean>, Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, Unit>, Function0<Unit>, t, Dp, Boolean, View> function9 = this.f7138a;
            WebView webView = this.b;
            Integer numValueOf = Integer.valueOf(this.c);
            MutableStateFlow<Boolean> mutableStateFlow = this.d;
            return function9.invoke(it, webView, numValueOf, mutableStateFlow, this.e, new a(mutableStateFlow, this.g), this.f, Dp.m3841boximpl(b.a()), Boolean.FALSE);
        }
    }

    public static final class g extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MutableStateFlow<Boolean> f7140a;
        public final /* synthetic */ Function0<Unit> b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(MutableStateFlow<Boolean> mutableStateFlow, Function0<Unit> function0) {
            super(0);
            this.f7140a = mutableStateFlow;
            this.b = function0;
        }

        public final void a() {
            b.b(this.f7140a, this.b);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    public static final class h extends Lambda implements Function2<Composer, Integer, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f7141a;
        public final /* synthetic */ WebView b;
        public final /* synthetic */ int c;
        public final /* synthetic */ Function1<com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, Unit> d;
        public final /* synthetic */ Function0<Unit> e;
        public final /* synthetic */ Function9<Context, WebView, Integer, MutableStateFlow<Boolean>, Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, Unit>, Function0<Unit>, t, Dp, Boolean, View> f;
        public final /* synthetic */ t g;
        public final /* synthetic */ int h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public h(Activity activity, WebView webView, int i, Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, Unit> function1, Function0<Unit> function0, Function9<? super Context, ? super WebView, ? super Integer, ? super MutableStateFlow<Boolean>, ? super Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, Unit>, ? super Function0<Unit>, ? super t, ? super Dp, ? super Boolean, ? extends View> function9, t tVar, int i2) {
            super(2);
            this.f7141a = activity;
            this.b = webView;
            this.c = i;
            this.d = function1;
            this.e = function0;
            this.f = function9;
            this.g = tVar;
            this.h = i2;
        }

        public final void a(Composer composer, int i) {
            b.a(this.f7141a, this.b, this.c, this.d, this.e, this.f, this.g, composer, this.h | 1);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            a(composer, num.intValue());
            return Unit.INSTANCE;
        }
    }

    public static final class i extends Lambda implements Function2<Composer, Integer, Function10<? super BoxScope, ? super Boolean, ? super Boolean, ? super Function0<? extends Unit>, ? super Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, ? extends Unit>, ? super Boolean, ? super UInt, ? super UInt, ? super Composer, ? super Integer, ? extends Unit>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final i f7142a = new i();

        public i() {
            super(2);
        }

        public final Function10<BoxScope, Boolean, Boolean, Function0<Unit>, Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, Unit>, Boolean, UInt, UInt, Composer, Integer, Unit> a(Composer composer, int i) {
            composer.startReplaceableGroup(-189169605);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-189169605, i, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.defaultAdWebViewRenderer.<anonymous> (AdWebViewRenderer.kt:142)");
            }
            Function10<BoxScope, Boolean, Boolean, Function0<Unit>, Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, Unit>, Boolean, UInt, UInt, Composer, Integer, Unit> function10A = q.a(null, null, 0L, 0L, 0L, null, null, null, composer, 0, 255);
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

    public static final class j extends Lambda implements Function9<Context, WebView, Integer, MutableStateFlow<Boolean>, Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, ? extends Unit>, Function0<? extends Unit>, t, Dp, Boolean, ComposeView> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f7143a;
        public final /* synthetic */ Function2<Composer, Integer, Function10<BoxScope, Boolean, Boolean, Function0<Unit>, Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, Unit>, Boolean, UInt, UInt, Composer, Integer, Unit>> b;

        public static final class a extends Lambda implements Function2<Composer, Integer, Unit> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ WebView f7144a;
            public final /* synthetic */ int b;
            public final /* synthetic */ Function1<com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, Unit> c;
            public final /* synthetic */ Function0<Unit> d;
            public final /* synthetic */ long e;
            public final /* synthetic */ Function2<Composer, Integer, Function10<BoxScope, Boolean, Boolean, Function0<Unit>, Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, Unit>, Boolean, UInt, UInt, Composer, Integer, Unit>> f;
            public final /* synthetic */ t g;
            public final /* synthetic */ float h;
            public final /* synthetic */ boolean i;
            public final /* synthetic */ MutableStateFlow<Boolean> j;

            /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.b$j$a$a, reason: collision with other inner class name */
            public static final class C0694a extends Lambda implements Function2<Composer, Integer, Unit> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ WebView f7145a;
                public final /* synthetic */ int b;
                public final /* synthetic */ Function1<com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, Unit> c;
                public final /* synthetic */ Function0<Unit> d;
                public final /* synthetic */ long e;
                public final /* synthetic */ Function2<Composer, Integer, Function10<BoxScope, Boolean, Boolean, Function0<Unit>, Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, Unit>, Boolean, UInt, UInt, Composer, Integer, Unit>> f;
                public final /* synthetic */ t g;
                public final /* synthetic */ float h;
                public final /* synthetic */ boolean i;
                public final /* synthetic */ MutableStateFlow<Boolean> j;

                /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.b$j$a$a$a, reason: collision with other inner class name */
                @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.AdWebViewRendererKt$defaultAdWebViewRenderer$2$1$1$1$1", f = "AdWebViewRenderer.kt", i = {}, l = {157}, m = "invokeSuspend", n = {}, s = {})
                public static final class C0695a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    public int f7146a;
                    public final /* synthetic */ MutableState<Boolean> b;
                    public final /* synthetic */ MutableStateFlow<Boolean> c;

                    /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.b$j$a$a$a$a, reason: collision with other inner class name */
                    public static final class C0696a extends Lambda implements Function0<Boolean> {

                        /* JADX INFO: renamed from: a, reason: collision with root package name */
                        public final /* synthetic */ MutableState<Boolean> f7147a;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        public C0696a(MutableState<Boolean> mutableState) {
                            super(0);
                            this.f7147a = mutableState;
                        }

                        @Override // kotlin.jvm.functions.Function0
                        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                        public final Boolean invoke() {
                            return this.f7147a.getValue();
                        }
                    }

                    /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.b$j$a$a$a$b, reason: collision with other inner class name */
                    public static final class C0697b implements FlowCollector<Boolean> {

                        /* JADX INFO: renamed from: a, reason: collision with root package name */
                        public final /* synthetic */ MutableStateFlow<Boolean> f7148a;

                        public C0697b(MutableStateFlow<Boolean> mutableStateFlow) {
                            this.f7148a = mutableStateFlow;
                        }

                        public final Object a(boolean z, Continuation<? super Unit> continuation) {
                            this.f7148a.setValue(Boxing.boxBoolean(z));
                            return Unit.INSTANCE;
                        }

                        @Override // kotlinx.coroutines.flow.FlowCollector
                        public /* bridge */ /* synthetic */ Object emit(Boolean bool, Continuation continuation) {
                            return a(bool.booleanValue(), continuation);
                        }
                    }

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public C0695a(MutableState<Boolean> mutableState, MutableStateFlow<Boolean> mutableStateFlow, Continuation<? super C0695a> continuation) {
                        super(2, continuation);
                        this.b = mutableState;
                        this.c = mutableStateFlow;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return ((C0695a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new C0695a(this.b, this.c, continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) throws Throwable {
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.f7146a;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            Flow flowSnapshotFlow = SnapshotStateKt.snapshotFlow(new C0696a(this.b));
                            C0697b c0697b = new C0697b(this.c);
                            this.f7146a = 1;
                            if (flowSnapshotFlow.collect(c0697b, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                        }
                        return Unit.INSTANCE;
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                public C0694a(WebView webView, int i, Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, Unit> function1, Function0<Unit> function0, long j, Function2<? super Composer, ? super Integer, ? extends Function10<? super BoxScope, ? super Boolean, ? super Boolean, ? super Function0<Unit>, ? super Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, Unit>, ? super Boolean, ? super UInt, ? super UInt, ? super Composer, ? super Integer, Unit>> function2, t tVar, float f, boolean z, MutableStateFlow<Boolean> mutableStateFlow) {
                    super(2);
                    this.f7145a = webView;
                    this.b = i;
                    this.c = function1;
                    this.d = function0;
                    this.e = j;
                    this.f = function2;
                    this.g = tVar;
                    this.h = f;
                    this.i = z;
                    this.j = mutableStateFlow;
                }

                public final void a(Composer composer, int i) {
                    if ((i & 11) == 2 && composer.getSkipping()) {
                        composer.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1635041213, i, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.defaultAdWebViewRenderer.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AdWebViewRenderer.kt:149)");
                    }
                    MutableStateFlow<Boolean> mutableStateFlow = this.j;
                    composer.startReplaceableGroup(-492369756);
                    Object objRememberedValue = composer.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(mutableStateFlow.getValue(), null, 2, null);
                        composer.updateRememberedValue(objRememberedValue);
                    }
                    composer.endReplaceableGroup();
                    MutableState mutableState = (MutableState) objRememberedValue;
                    EffectsKt.LaunchedEffect(Unit.INSTANCE, new C0695a(mutableState, this.j, null), composer, 70);
                    b.a(this.f7145a, this.b, mutableState, this.c, this.d, null, this.e, this.f.invoke(composer, 0), this.g, this.h, this.i, composer, 392, 0, 32);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    a(composer, num.intValue());
                    return Unit.INSTANCE;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public a(WebView webView, int i, Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, Unit> function1, Function0<Unit> function0, long j, Function2<? super Composer, ? super Integer, ? extends Function10<? super BoxScope, ? super Boolean, ? super Boolean, ? super Function0<Unit>, ? super Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, Unit>, ? super Boolean, ? super UInt, ? super UInt, ? super Composer, ? super Integer, Unit>> function2, t tVar, float f, boolean z, MutableStateFlow<Boolean> mutableStateFlow) {
                super(2);
                this.f7144a = webView;
                this.b = i;
                this.c = function1;
                this.d = function0;
                this.e = j;
                this.f = function2;
                this.g = tVar;
                this.h = f;
                this.i = z;
                this.j = mutableStateFlow;
            }

            public final void a(Composer composer, int i) {
                if ((i & 11) == 2 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(852256256, i, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.defaultAdWebViewRenderer.<anonymous>.<anonymous>.<anonymous> (AdWebViewRenderer.kt:148)");
                }
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.theme.c.a(false, ComposableLambdaKt.composableLambda(composer, 1635041213, true, new C0694a(this.f7144a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j)), composer, 48, 1);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                a(composer, num.intValue());
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public j(long j, Function2<? super Composer, ? super Integer, ? extends Function10<? super BoxScope, ? super Boolean, ? super Boolean, ? super Function0<Unit>, ? super Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, Unit>, ? super Boolean, ? super UInt, ? super UInt, ? super Composer, ? super Integer, Unit>> function2) {
            super(9);
            this.f7143a = j;
            this.b = function2;
        }

        public final ComposeView a(Context context, WebView webView, int i, MutableStateFlow<Boolean> canClose, Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, Unit> onButtonRendered, Function0<Unit> onClose, t tVar, float f, boolean z) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(webView, "webView");
            Intrinsics.checkNotNullParameter(canClose, "canClose");
            Intrinsics.checkNotNullParameter(onButtonRendered, "onButtonRendered");
            Intrinsics.checkNotNullParameter(onClose, "onClose");
            ComposeView composeView = new ComposeView(context, null, 0, 6, null);
            long j = this.f7143a;
            Function2<Composer, Integer, Function10<BoxScope, Boolean, Boolean, Function0<Unit>, Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, Unit>, Boolean, UInt, UInt, Composer, Integer, Unit>> function2 = this.b;
            composeView.setId(R.id.moloco_fullscreen_ad_view_id);
            composeView.setContent(ComposableLambdaKt.composableLambdaInstance(852256256, true, new a(webView, i, onButtonRendered, onClose, j, function2, tVar, f, z, canClose)));
            return composeView;
        }

        @Override // kotlin.jvm.functions.Function9
        public /* bridge */ /* synthetic */ ComposeView invoke(Context context, WebView webView, Integer num, MutableStateFlow<Boolean> mutableStateFlow, Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, ? extends Unit> function1, Function0<? extends Unit> function0, t tVar, Dp dp, Boolean bool) {
            return a(context, webView, num.intValue(), mutableStateFlow, function1, function0, tVar, dp.m3857unboximpl(), bool.booleanValue());
        }
    }

    public static final float a() {
        return f7130a;
    }

    public static final void a(WebView webView, int i2, MutableState<Boolean> mutableState, Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, Unit> function1, Function0<Unit> function0, Modifier modifier, long j2, Function10<? super BoxScope, ? super Boolean, ? super Boolean, ? super Function0<Unit>, ? super Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, Unit>, ? super Boolean, ? super UInt, ? super UInt, ? super Composer, ? super Integer, Unit> function10, t tVar, float f2, boolean z, Composer composer, int i3, int i4, int i5) {
        Function10<? super BoxScope, ? super Boolean, ? super Boolean, ? super Function0<Unit>, ? super Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, Unit>, ? super Boolean, ? super UInt, ? super UInt, ? super Composer, ? super Integer, Unit> function10A;
        int i6;
        Composer composerStartRestartGroup = composer.startRestartGroup(1270178777);
        Modifier modifier2 = (i5 & 32) != 0 ? Modifier.INSTANCE : modifier;
        long jM1657getBlack0d7_KjU = (i5 & 64) != 0 ? Color.INSTANCE.m1657getBlack0d7_KjU() : j2;
        if ((i5 & 128) != 0) {
            function10A = q.a(null, null, 0L, 0L, 0L, null, null, null, composerStartRestartGroup, 0, 255);
            i6 = i3 & (-29360129);
        } else {
            function10A = function10;
            i6 = i3;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1270178777, i6, i4, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.AdWebViewRenderDisplay (AdWebViewRenderer.kt:63)");
        }
        Modifier modifierM176backgroundbw27NRU$default = BackgroundKt.m176backgroundbw27NRU$default(SizeKt.fillMaxSize$default(modifier2, 0.0f, 1, null), jM1657getBlack0d7_KjU, null, 2, null);
        composerStartRestartGroup.startReplaceableGroup(733328855);
        Alignment.Companion companion = Alignment.INSTANCE;
        MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(companion.getTopStart(), false, composerStartRestartGroup, 0);
        composerStartRestartGroup.startReplaceableGroup(-1323940314);
        Density density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
        LayoutDirection layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ViewConfiguration viewConfiguration = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
        ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor = companion2.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM176backgroundbw27NRU$default);
        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        composerStartRestartGroup.startReusableNode();
        if (composerStartRestartGroup.getInserting()) {
            composerStartRestartGroup.createNode(constructor);
        } else {
            composerStartRestartGroup.useNode();
        }
        composerStartRestartGroup.disableReusing();
        Composer composerM1286constructorimpl = Updater.m1286constructorimpl(composerStartRestartGroup);
        Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRememberBoxMeasurePolicy, companion2.getSetMeasurePolicy());
        Updater.m1293setimpl(composerM1286constructorimpl, density, companion2.getSetDensity());
        Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, companion2.getSetLayoutDirection());
        Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, companion2.getSetViewConfiguration());
        composerStartRestartGroup.enableReusing();
        function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
        composerStartRestartGroup.startReplaceableGroup(2058660585);
        composerStartRestartGroup.startReplaceableGroup(-2137368960);
        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
        Modifier.Companion companion3 = Modifier.INSTANCE;
        long j3 = jM1657getBlack0d7_KjU;
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.a.a(webView, SizeKt.fillMaxSize$default(companion3, 0.0f, 1, null), tVar, composerStartRestartGroup, ((i6 >> 18) & 896) | 56, 0);
        composerStartRestartGroup.startReplaceableGroup(-461543684);
        if (function10A != null) {
            Integer numValueOf = Integer.valueOf(i2);
            composerStartRestartGroup.startReplaceableGroup(1157296644);
            boolean zChanged = composerStartRestartGroup.changed(numValueOf);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new m(UInt.m7995boximpl(UInt.m8001constructorimpl(RangesKt.coerceAtLeast(i2, 0))));
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            m mVar = (m) objRememberedValue;
            boolean zBooleanValue = mutableState.getValue().booleanValue();
            composerStartRestartGroup.startReplaceableGroup(1157296644);
            boolean zChanged2 = composerStartRestartGroup.changed(mutableState);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new a(mutableState);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            composerStartRestartGroup.endReplaceableGroup();
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.t.a(boxScopeInstance, mVar, true, zBooleanValue, (Function0) objRememberedValue2, function0, function1, function10A, z, composerStartRestartGroup, ((i6 << 3) & 458752) | 390 | ((i6 << 9) & 3670016) | ((i4 << 24) & 234881024));
        }
        composerStartRestartGroup.endReplaceableGroup();
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.a.c(PaddingKt.m423padding3ABfNKs(boxScopeInstance.align(companion3, companion.getBottomStart()), f2), null, null, null, composerStartRestartGroup, 0, 14).invoke(boxScopeInstance, function1, composerStartRestartGroup, Integer.valueOf(((i6 >> 6) & 112) | 6));
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.endNode();
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new C0692b(webView, i2, mutableState, function1, function0, modifier2, j3, function10A, tVar, f2, z, i3, i4, i5));
    }

    public static final void b(MutableStateFlow<Boolean> mutableStateFlow, Function0<Unit> function0) {
        if (mutableStateFlow.getValue().booleanValue()) {
            function0.invoke();
        }
    }

    public static /* synthetic */ Function9 a(long j2, Function2 function2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j2 = Color.INSTANCE.m1657getBlack0d7_KjU();
        }
        if ((i2 & 2) != 0) {
            function2 = i.f7142a;
        }
        return a(j2, (Function2<? super Composer, ? super Integer, ? extends Function10<? super BoxScope, ? super Boolean, ? super Boolean, ? super Function0<Unit>, ? super Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, Unit>, ? super Boolean, ? super UInt, ? super UInt, ? super Composer, ? super Integer, Unit>>) function2);
    }

    public static final Function9<Context, WebView, Integer, MutableStateFlow<Boolean>, Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, Unit>, Function0<Unit>, t, Dp, Boolean, View> a(long j2, Function2<? super Composer, ? super Integer, ? extends Function10<? super BoxScope, ? super Boolean, ? super Boolean, ? super Function0<Unit>, ? super Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, Unit>, ? super Boolean, ? super UInt, ? super UInt, ? super Composer, ? super Integer, Unit>> adCloseCountdownButton) {
        Intrinsics.checkNotNullParameter(adCloseCountdownButton, "adCloseCountdownButton");
        return new j(j2, adCloseCountdownButton);
    }

    public static final void a(Activity activity, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i adViewModel, WebView webView, int i2, Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, Unit> onButtonRendered, Function0<Unit> onClose, Function9<? super Context, ? super WebView, ? super Integer, ? super MutableStateFlow<Boolean>, ? super Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, Unit>, ? super Function0<Unit>, ? super t, ? super Dp, ? super Boolean, ? extends View> adWebViewRenderer, t tVar, Function10<? super BoxScope, ? super Boolean, ? super Boolean, ? super Function0<Unit>, ? super Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, Unit>, ? super Boolean, ? super UInt, ? super UInt, ? super Composer, ? super Integer, Unit> function10, Function10<? super BoxScope, ? super Boolean, ? super Boolean, ? super Function0<Unit>, ? super Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, Unit>, ? super Boolean, ? super UInt, ? super UInt, ? super Composer, ? super Integer, Unit> function11, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        Intrinsics.checkNotNullParameter(adViewModel, "adViewModel");
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(onButtonRendered, "onButtonRendered");
        Intrinsics.checkNotNullParameter(onClose, "onClose");
        Intrinsics.checkNotNullParameter(adWebViewRenderer, "adWebViewRenderer");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1840546172);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1840546172, i3, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.MraidAdContainerScreen (AdWebViewRenderer.kt:192)");
        }
        Modifier modifierTestTag = TestTagKt.testTag(BackgroundKt.m176backgroundbw27NRU$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), Color.INSTANCE.m1657getBlack0d7_KjU(), null, 2, null), "MraidAdContainerScreen");
        composerStartRestartGroup.startReplaceableGroup(733328855);
        MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composerStartRestartGroup, 0);
        composerStartRestartGroup.startReplaceableGroup(-1323940314);
        Density density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
        LayoutDirection layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ViewConfiguration viewConfiguration = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
        ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor = companion.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierTestTag);
        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        composerStartRestartGroup.startReusableNode();
        if (composerStartRestartGroup.getInserting()) {
            composerStartRestartGroup.createNode(constructor);
        } else {
            composerStartRestartGroup.useNode();
        }
        composerStartRestartGroup.disableReusing();
        Composer composerM1286constructorimpl = Updater.m1286constructorimpl(composerStartRestartGroup);
        Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRememberBoxMeasurePolicy, companion.getSetMeasurePolicy());
        Updater.m1293setimpl(composerM1286constructorimpl, density, companion.getSetDensity());
        Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, companion.getSetLayoutDirection());
        Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, companion.getSetViewConfiguration());
        composerStartRestartGroup.enableReusing();
        function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
        composerStartRestartGroup.startReplaceableGroup(2058660585);
        composerStartRestartGroup.startReplaceableGroup(-2137368960);
        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
        Integer numValueOf = Integer.valueOf(i2);
        composerStartRestartGroup.startReplaceableGroup(1157296644);
        boolean zChanged = composerStartRestartGroup.changed(numValueOf);
        Object objRememberedValue = composerStartRestartGroup.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = StateFlowKt.MutableStateFlow(Boolean.valueOf(i2 == 0));
            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
        }
        composerStartRestartGroup.endReplaceableGroup();
        MutableStateFlow mutableStateFlow = (MutableStateFlow) objRememberedValue;
        State stateCollectAsState = SnapshotStateKt.collectAsState(adViewModel.j(), null, composerStartRestartGroup, 8, 1);
        CrossfadeKt.Crossfade(a(stateCollectAsState), null, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1935552634, true, new c(adWebViewRenderer, webView, i2, mutableStateFlow, onButtonRendered, tVar, onClose)), composerStartRestartGroup, 3072, 6);
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.e.a(boxScopeInstance, adViewModel, a(stateCollectAsState), function11, function10, composerStartRestartGroup, (i3 & 112) | 6 | ((i3 >> 18) & 7168) | ((i3 >> 12) & 57344));
        BackHandlerKt.BackHandler(false, new d(mutableStateFlow, onClose), composerStartRestartGroup, 0, 1);
        s.a(activity, composerStartRestartGroup, 8);
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.endNode();
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new e(activity, adViewModel, webView, i2, onButtonRendered, onClose, adWebViewRenderer, tVar, function10, function11, i3));
    }

    public static final void a(MutableStateFlow<Boolean> mutableStateFlow, Function0<Unit> function0) {
        if (mutableStateFlow.getValue().booleanValue()) {
            function0.invoke();
        }
    }

    public static final void a(Activity activity, WebView webView, int i2, Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, Unit> onButtonRendered, Function0<Unit> onClose, Function9<? super Context, ? super WebView, ? super Integer, ? super MutableStateFlow<Boolean>, ? super Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, Unit>, ? super Function0<Unit>, ? super t, ? super Dp, ? super Boolean, ? extends View> adWebViewRenderer, t tVar, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(onButtonRendered, "onButtonRendered");
        Intrinsics.checkNotNullParameter(onClose, "onClose");
        Intrinsics.checkNotNullParameter(adWebViewRenderer, "adWebViewRenderer");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1336318846);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1336318846, i3, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.StaticAdWebViewScreen (AdWebViewRenderer.kt:265)");
        }
        Modifier modifierM176backgroundbw27NRU$default = BackgroundKt.m176backgroundbw27NRU$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), Color.INSTANCE.m1657getBlack0d7_KjU(), null, 2, null);
        composerStartRestartGroup.startReplaceableGroup(733328855);
        MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composerStartRestartGroup, 0);
        composerStartRestartGroup.startReplaceableGroup(-1323940314);
        Density density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
        LayoutDirection layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ViewConfiguration viewConfiguration = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
        ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor = companion.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM176backgroundbw27NRU$default);
        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        composerStartRestartGroup.startReusableNode();
        if (composerStartRestartGroup.getInserting()) {
            composerStartRestartGroup.createNode(constructor);
        } else {
            composerStartRestartGroup.useNode();
        }
        composerStartRestartGroup.disableReusing();
        Composer composerM1286constructorimpl = Updater.m1286constructorimpl(composerStartRestartGroup);
        Updater.m1293setimpl(composerM1286constructorimpl, measurePolicyRememberBoxMeasurePolicy, companion.getSetMeasurePolicy());
        Updater.m1293setimpl(composerM1286constructorimpl, density, companion.getSetDensity());
        Updater.m1293setimpl(composerM1286constructorimpl, layoutDirection, companion.getSetLayoutDirection());
        Updater.m1293setimpl(composerM1286constructorimpl, viewConfiguration, companion.getSetViewConfiguration());
        composerStartRestartGroup.enableReusing();
        function3MaterializerOf.invoke(SkippableUpdater.m1276boximpl(SkippableUpdater.m1277constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
        composerStartRestartGroup.startReplaceableGroup(2058660585);
        composerStartRestartGroup.startReplaceableGroup(-2137368960);
        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
        Integer numValueOf = Integer.valueOf(i2);
        composerStartRestartGroup.startReplaceableGroup(1157296644);
        boolean zChanged = composerStartRestartGroup.changed(numValueOf);
        Object objRememberedValue = composerStartRestartGroup.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = StateFlowKt.MutableStateFlow(Boolean.valueOf(i2 == 0));
            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
        }
        composerStartRestartGroup.endReplaceableGroup();
        MutableStateFlow mutableStateFlow = (MutableStateFlow) objRememberedValue;
        AndroidView_androidKt.AndroidView(new f(adWebViewRenderer, webView, i2, mutableStateFlow, onButtonRendered, tVar, onClose), null, null, composerStartRestartGroup, 0, 6);
        BackHandlerKt.BackHandler(false, new g(mutableStateFlow, onClose), composerStartRestartGroup, 0, 1);
        s.a(activity, composerStartRestartGroup, 8);
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.endNode();
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new h(activity, webView, i2, onButtonRendered, onClose, adWebViewRenderer, tVar, i3));
    }

    public static final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i.a a(State<? extends com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i.a> state) {
        return state.getValue();
    }
}
