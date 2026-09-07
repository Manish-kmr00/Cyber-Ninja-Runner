package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.viewinterop.AndroidView_androidKt;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.t;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes8.dex */
public final class a {

    /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.a$a, reason: collision with other inner class name */
    public static final class C0690a extends Lambda implements Function1<Context, FrameLayout> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WebView f7125a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0690a(WebView webView) {
            super(1);
            this.f7125a = webView;
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final FrameLayout invoke(Context it) {
            Intrinsics.checkNotNullParameter(it, "it");
            FrameLayout frameLayout = new FrameLayout(it);
            WebView webView = this.f7125a;
            webView.setBackgroundColor(0);
            webView.setVisibility(0);
            frameLayout.addView(webView, new ViewGroup.LayoutParams(-1, -1));
            return frameLayout;
        }
    }

    public static final class b extends Lambda implements Function2<Composer, Integer, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Unit f7126a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Unit unit) {
            super(2);
            this.f7126a = unit;
        }

        public final void a(Composer composer, int i) {
            if ((i & 11) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1018657295, i, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.AdWebView.<anonymous>.<anonymous> (AdWebView.kt:40)");
            }
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

    public static final class c extends Lambda implements Function1<DisposableEffectScope, DisposableEffectResult> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WebView f7127a;

        /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.a$c$a, reason: collision with other inner class name */
        public static final class C0691a implements DisposableEffectResult {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ WebView f7128a;

            public C0691a(WebView webView) {
                this.f7128a = webView;
            }

            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                ViewParent parent = this.f7128a.getParent();
                ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
                if (viewGroup != null) {
                    viewGroup.removeView(this.f7128a);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(WebView webView) {
            super(1);
            this.f7127a = webView;
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
            Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
            return new C0691a(this.f7127a);
        }
    }

    public static final class d extends Lambda implements Function2<Composer, Integer, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WebView f7129a;
        public final /* synthetic */ Modifier b;
        public final /* synthetic */ t c;
        public final /* synthetic */ int d;
        public final /* synthetic */ int e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(WebView webView, Modifier modifier, t tVar, int i, int i2) {
            super(2);
            this.f7129a = webView;
            this.b = modifier;
            this.c = tVar;
            this.d = i;
            this.e = i2;
        }

        public final void a(Composer composer, int i) {
            a.a(this.f7129a, this.b, this.c, composer, this.d | 1, this.e);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            a(composer, num.intValue());
            return Unit.INSTANCE;
        }
    }

    public static final void a(WebView webView, Modifier modifier, t tVar, Composer composer, int i, int i2) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1111633024);
        if ((i2 & 2) != 0) {
            modifier = Modifier.INSTANCE;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1111633024, i, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.AdWebView (AdWebView.kt:13)");
        }
        composerStartRestartGroup.startReplaceableGroup(-1335812377);
        AndroidView_androidKt.AndroidView(new C0690a(webView), modifier, null, composerStartRestartGroup, i & 112, 4);
        Unit unit = Unit.INSTANCE;
        if (tVar != null) {
            tVar.a(ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1018657295, true, new b(unit)), composerStartRestartGroup, ((i >> 3) & 112) | 6);
        }
        composerStartRestartGroup.endReplaceableGroup();
        EffectsKt.DisposableEffect(webView, new c(webView), composerStartRestartGroup, 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new d(webView, modifier, tVar, i, i2));
    }
}
