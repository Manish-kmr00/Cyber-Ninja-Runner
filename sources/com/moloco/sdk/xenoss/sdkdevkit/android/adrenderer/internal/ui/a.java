package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.IconKt;
import androidx.compose.material.MaterialThemeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Dp;
import com.moloco.sdk.R;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: loaded from: classes9.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f6689a = "https://cdn-f.adsmoloco.com/moloco-cdn/privacy.html";

    /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.a$a, reason: collision with other inner class name */
    public static final class C0618a extends Lambda implements Function1<SemanticsPropertyReceiver, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f6690a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0618a(String str) {
            super(1);
            this.f6690a = str;
        }

        public final void a(SemanticsPropertyReceiver semantics) {
            Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
            String str = this.f6690a;
            SemanticsPropertiesKt.setContentDescription(semantics, str);
            SemanticsPropertiesKt.setTestTag(semantics, str);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
            a(semanticsPropertyReceiver);
            return Unit.INSTANCE;
        }
    }

    public static final class b extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1<String, Unit> f6691a;
        public final /* synthetic */ String b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public b(Function1<? super String, Unit> function1, String str) {
            super(0);
            this.f6691a = function1;
            this.b = str;
        }

        public final void a() {
            this.f6691a.invoke(this.b);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    public static final class c extends Lambda implements Function2<Composer, Integer, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Modifier f6692a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Function1<String, Unit> c;
        public final /* synthetic */ int d;
        public final /* synthetic */ int e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public c(Modifier modifier, String str, Function1<? super String, Unit> function1, int i, int i2) {
            super(2);
            this.f6692a = modifier;
            this.b = str;
            this.c = function1;
            this.d = i;
            this.e = i2;
        }

        public final void a(Composer composer, int i) {
            a.a(this.f6692a, this.b, this.c, composer, this.d | 1, this.e);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            a(composer, num.intValue());
            return Unit.INSTANCE;
        }
    }

    public static final class d extends Lambda implements Function2<Composer, Integer, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f6693a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(int i) {
            super(2);
            this.f6693a = i;
        }

        public final void a(Composer composer, int i) {
            a.a(composer, this.f6693a | 1);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            a(composer, num.intValue());
            return Unit.INSTANCE;
        }
    }

    public static final class e extends Lambda implements Function1<String, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.m f6694a;
        public final /* synthetic */ String b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.m mVar, String str) {
            super(1);
            this.f6694a = mVar;
            this.b = str;
        }

        public final void a(String it) {
            Intrinsics.checkNotNullParameter(it, "it");
            this.f6694a.a(this.b);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            a(str);
            return Unit.INSTANCE;
        }
    }

    public static final class f extends Lambda implements Function2<Composer, Integer, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Modifier f6695a;
        public final /* synthetic */ String b;
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.m c;
        public final /* synthetic */ Function1<String, Unit> d;
        public final /* synthetic */ int e;
        public final /* synthetic */ int f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public f(Modifier modifier, String str, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.m mVar, Function1<? super String, Unit> function1, int i, int i2) {
            super(2);
            this.f6695a = modifier;
            this.b = str;
            this.c = mVar;
            this.d = function1;
            this.e = i;
            this.f = i2;
        }

        public final void a(Composer composer, int i) {
            a.a(this.f6695a, this.b, this.c, this.d, composer, this.e | 1, this.f);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            a(composer, num.intValue());
            return Unit.INSTANCE;
        }
    }

    public static final class g extends Lambda implements Function1<String, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.m f6696a;
        public final /* synthetic */ String b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.m mVar, String str) {
            super(1);
            this.f6696a = mVar;
            this.b = str;
        }

        public final void a(String it) {
            Intrinsics.checkNotNullParameter(it, "it");
            this.f6696a.a(this.b);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            a(str);
            return Unit.INSTANCE;
        }
    }

    public static final class i extends Lambda implements Function1<String, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.m f6700a;
        public final /* synthetic */ String b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.m mVar, String str) {
            super(1);
            this.f6700a = mVar;
            this.b = str;
        }

        public final void a(String it) {
            Intrinsics.checkNotNullParameter(it, "it");
            this.f6700a.a(this.b);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            a(str);
            return Unit.INSTANCE;
        }
    }

    public static final class j extends Lambda implements Function4<BoxScope, Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, ? extends Unit>, Composer, Integer, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Modifier f6701a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Function1<String, Unit> c;
        public final /* synthetic */ int d;

        /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.a$j$a, reason: collision with other inner class name */
        public static final class C0620a extends Lambda implements Function3<Modifier, Composer, Integer, Unit> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Modifier f6702a;
            public final /* synthetic */ String b;
            public final /* synthetic */ Function1<String, Unit> c;
            public final /* synthetic */ int d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public C0620a(Modifier modifier, String str, Function1<? super String, Unit> function1, int i) {
                super(3);
                this.f6702a = modifier;
                this.b = str;
                this.c = function1;
                this.d = i;
            }

            public final void a(Modifier trackableModifier, Composer composer, int i) {
                int i2;
                Intrinsics.checkNotNullParameter(trackableModifier, "trackableModifier");
                if ((i & 14) == 0) {
                    i2 = (composer.changed(trackableModifier) ? 4 : 2) | i;
                } else {
                    i2 = i;
                }
                if ((i2 & 91) == 18 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2083907100, i, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.defaultWebViewAdBadge.<anonymous>.<anonymous> (AdBadge.kt:135)");
                }
                Modifier modifierThen = this.f6702a.then(trackableModifier);
                String str = this.b;
                Function1<String, Unit> function1 = this.c;
                int i3 = this.d;
                a.a(modifierThen, str, function1, composer, (i3 & 112) | ((i3 >> 3) & 896), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Modifier modifier, Composer composer, Integer num) {
                a(modifier, composer, num.intValue());
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public j(Modifier modifier, String str, Function1<? super String, Unit> function1, int i) {
            super(4);
            this.f6701a = modifier;
            this.b = str;
            this.c = function1;
            this.d = i;
        }

        public final void a(BoxScope boxScope, Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, Unit> onButtonRendered, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(boxScope, "$this$null");
            Intrinsics.checkNotNullParameter(onButtonRendered, "onButtonRendered");
            if ((i & 112) == 0) {
                i |= composer.changed(onButtonRendered) ? 32 : 16;
            }
            if ((i & 721) == 144 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1426546556, i, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.defaultWebViewAdBadge.<anonymous> (AdBadge.kt:131)");
            }
            v.a(null, com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c.EnumC0707a.AD_BADGE, onButtonRendered, ComposableLambdaKt.composableLambda(composer, 2083907100, true, new C0620a(this.f6701a, this.b, this.c, this.d)), composer, ((i << 3) & 896) | 3120, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(BoxScope boxScope, Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, ? extends Unit> function1, Composer composer, Integer num) {
            a(boxScope, function1, composer, num.intValue());
            return Unit.INSTANCE;
        }
    }

    public static final void a(Modifier modifier, String clickUrl, Function1<? super String, Unit> onClick, Composer composer, int i2, int i3) {
        Modifier modifier2;
        int i4;
        Modifier modifier3;
        Intrinsics.checkNotNullParameter(clickUrl, "clickUrl");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(1037954372);
        int i5 = i3 & 1;
        if (i5 != 0) {
            i4 = i2 | 6;
            modifier2 = modifier;
        } else if ((i2 & 14) == 0) {
            modifier2 = modifier;
            i4 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i2;
        } else {
            modifier2 = modifier;
            i4 = i2;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
        } else if ((i2 & 112) == 0) {
            i4 |= composerStartRestartGroup.changed(clickUrl) ? 32 : 16;
        }
        if ((i3 & 4) != 0) {
            i4 |= 384;
        } else if ((i2 & 896) == 0) {
            i4 |= composerStartRestartGroup.changed(onClick) ? 256 : 128;
        }
        if ((i4 & 731) == 146 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            modifier3 = i5 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1037954372, i4, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.AdBadge (AdBadge.kt:41)");
            }
            composerStartRestartGroup.startReplaceableGroup(1157296644);
            boolean zChanged = composerStartRestartGroup.changed("Ad Badge");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new C0618a("Ad Badge");
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            Modifier modifierM456requiredSize3ABfNKs = SizeKt.m456requiredSize3ABfNKs(SemanticsModifierKt.semantics$default(modifier3, false, (Function1) objRememberedValue, 1, null), Dp.m3843constructorimpl(12));
            composerStartRestartGroup.startReplaceableGroup(511388516);
            boolean zChanged2 = composerStartRestartGroup.changed(onClick) | composerStartRestartGroup.changed(clickUrl);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new b(onClick, clickUrl);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            composerStartRestartGroup.endReplaceableGroup();
            IconKt.m1076Iconww6aTOc(PainterResources_androidKt.painterResource(R.drawable.info_badge, composerStartRestartGroup, 0), "Ad Badge", ClickableKt.m195clickableXHw0xAI$default(modifierM456requiredSize3ABfNKs, false, null, null, (Function0) objRememberedValue2, 7, null), Color.INSTANCE.m1667getUnspecified0d7_KjU(), composerStartRestartGroup, 3128, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new c(modifier3, clickUrl, onClick, i2, i3));
    }

    public static final Function4<BoxScope, Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, Unit>, Composer, Integer, Unit> c(Modifier modifier, String str, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.m mVar, Function1<? super String, Unit> function1, Composer composer, int i2, int i3) {
        composer.startReplaceableGroup(210063909);
        if ((i3 & 1) != 0) {
            modifier = Modifier.INSTANCE;
        }
        if ((i3 & 2) != 0) {
            str = f6689a;
        }
        if ((i3 & 4) != 0) {
            mVar = com.moloco.sdk.service_locator.a.h.f6477a.d();
        }
        if ((i3 & 8) != 0) {
            function1 = new i(mVar, str);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(210063909, i2, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.defaultWebViewAdBadge (AdBadge.kt:125)");
        }
        ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer, 1426546556, true, new j(modifier, str, function1, i2));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return composableLambda;
    }

    public static final Function5<BoxScope, Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, Unit>, StateFlow<? extends com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i.a>, Composer, Integer, Unit> b(Modifier modifier, String str, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.m mVar, Function1<? super String, Unit> function1, Composer composer, int i2, int i3) {
        composer.startReplaceableGroup(-751111043);
        if ((i3 & 1) != 0) {
            modifier = Modifier.INSTANCE;
        }
        if ((i3 & 2) != 0) {
            str = f6689a;
        }
        if ((i3 & 4) != 0) {
            mVar = com.moloco.sdk.service_locator.a.h.f6477a.d();
        }
        if ((i3 & 8) != 0) {
            function1 = new g(mVar, str);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-751111043, i2, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.defaultVastAdBadge (AdBadge.kt:74)");
        }
        ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer, -1620589869, true, new h(modifier, str, function1, i2));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return composableLambda;
    }

    public static final class h extends Lambda implements Function5<BoxScope, Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, ? extends Unit>, StateFlow<? extends com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i.a>, Composer, Integer, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Modifier f6697a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Function1<String, Unit> c;
        public final /* synthetic */ int d;

        /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.a$h$a, reason: collision with other inner class name */
        public static final class C0619a extends Lambda implements Function3<Modifier, Composer, Integer, Unit> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Modifier f6698a;
            public final /* synthetic */ String b;
            public final /* synthetic */ Function1<String, Unit> c;
            public final /* synthetic */ int d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public C0619a(Modifier modifier, String str, Function1<? super String, Unit> function1, int i) {
                super(3);
                this.f6698a = modifier;
                this.b = str;
                this.c = function1;
                this.d = i;
            }

            public final void a(Modifier trackableModifier, Composer composer, int i) {
                int i2;
                Intrinsics.checkNotNullParameter(trackableModifier, "trackableModifier");
                if ((i & 14) == 0) {
                    i2 = (composer.changed(trackableModifier) ? 4 : 2) | i;
                } else {
                    i2 = i;
                }
                if ((i2 & 91) == 18 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1432640859, i, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.defaultVastAdBadge.<anonymous>.<anonymous>.<anonymous> (AdBadge.kt:88)");
                }
                Modifier modifierThen = this.f6698a.then(trackableModifier);
                String str = this.b;
                Function1<String, Unit> function1 = this.c;
                int i3 = this.d;
                a.a(modifierThen, str, function1, composer, (i3 & 112) | ((i3 >> 3) & 896), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Modifier modifier, Composer composer, Integer num) {
                a(modifier, composer, num.intValue());
                return Unit.INSTANCE;
            }
        }

        public static final class b extends Lambda implements Function3<Modifier, Composer, Integer, Unit> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Modifier f6699a;
            public final /* synthetic */ String b;
            public final /* synthetic */ Function1<String, Unit> c;
            public final /* synthetic */ int d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public b(Modifier modifier, String str, Function1<? super String, Unit> function1, int i) {
                super(3);
                this.f6699a = modifier;
                this.b = str;
                this.c = function1;
                this.d = i;
            }

            public final void a(Modifier trackableModifier, Composer composer, int i) {
                int i2;
                Intrinsics.checkNotNullParameter(trackableModifier, "trackableModifier");
                if ((i & 14) == 0) {
                    i2 = (composer.changed(trackableModifier) ? 4 : 2) | i;
                } else {
                    i2 = i;
                }
                if ((i2 & 91) == 18 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-159323954, i, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.defaultVastAdBadge.<anonymous>.<anonymous>.<anonymous> (AdBadge.kt:100)");
                }
                Modifier modifierThen = this.f6699a.then(trackableModifier);
                String str = this.b;
                Function1<String, Unit> function1 = this.c;
                int i3 = this.d;
                a.a(modifierThen, str, function1, composer, (i3 & 112) | ((i3 >> 3) & 896), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Modifier modifier, Composer composer, Integer num) {
                a(modifier, composer, num.intValue());
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public h(Modifier modifier, String str, Function1<? super String, Unit> function1, int i) {
            super(5);
            this.f6697a = modifier;
            this.b = str;
            this.c = function1;
            this.d = i;
        }

        public final void a(BoxScope boxScope, Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, Unit> onButtonRendered, StateFlow<? extends com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i.a> stateFlow, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(boxScope, "$this$null");
            Intrinsics.checkNotNullParameter(onButtonRendered, "onButtonRendered");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1620589869, i, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.defaultVastAdBadge.<anonymous> (AdBadge.kt:80)");
            }
            if (stateFlow != null) {
                Modifier modifier = this.f6697a;
                String str = this.b;
                Function1<String, Unit> function1 = this.c;
                int i2 = this.d;
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i.a aVarA = a(SnapshotStateKt.collectAsState(stateFlow, null, composer, 8, 1));
                if (aVarA instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i.a.c) {
                    composer.startReplaceableGroup(-1855563398);
                    v.a(null, com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c.EnumC0707a.AD_BADGE, onButtonRendered, ComposableLambdaKt.composableLambda(composer, -1432640859, true, new C0619a(modifier, str, function1, i2)), composer, ((i << 3) & 896) | 3120, 1);
                    composer.endReplaceableGroup();
                } else if (aVarA instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i.a.C0652a) {
                    composer.startReplaceableGroup(-1855562947);
                    v.a(null, com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c.EnumC0707a.AD_BADGE, onButtonRendered, ComposableLambdaKt.composableLambda(composer, -159323954, true, new b(modifier, str, function1, i2)), composer, ((i << 3) & 896) | 3120, 1);
                    composer.endReplaceableGroup();
                } else if (aVarA instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i.a.b) {
                    composer.startReplaceableGroup(-1855562502);
                    composer.endReplaceableGroup();
                } else if (aVarA instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i.a.d) {
                    composer.startReplaceableGroup(-1855562444);
                    composer.endReplaceableGroup();
                } else if (aVarA == null) {
                    composer.startReplaceableGroup(-1855562409);
                    composer.endReplaceableGroup();
                } else {
                    composer.startReplaceableGroup(-1855562385);
                    composer.endReplaceableGroup();
                }
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }

        @Override // kotlin.jvm.functions.Function5
        public /* bridge */ /* synthetic */ Unit invoke(BoxScope boxScope, Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, ? extends Unit> function1, StateFlow<? extends com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i.a> stateFlow, Composer composer, Integer num) {
            a(boxScope, function1, stateFlow, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public static final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i.a a(State<? extends com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i.a> state) {
            return state.getValue();
        }
    }

    public static final void a(Modifier modifier, String str, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.m mVar, Function1<? super String, Unit> function1, Composer composer, int i2, int i3) {
        int i4;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1950835232);
        int i5 = i3 & 1;
        if (i5 != 0) {
            i4 = i2 | 6;
        } else if ((i2 & 14) == 0) {
            i4 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        int i6 = i3 & 2;
        if (i6 != 0) {
            i4 |= 48;
        } else if ((i2 & 112) == 0) {
            i4 |= composerStartRestartGroup.changed(str) ? 32 : 16;
        }
        if ((i2 & 896) == 0) {
            i4 |= ((i3 & 4) == 0 && composerStartRestartGroup.changed(mVar)) ? 256 : 128;
        }
        if ((i2 & 7168) == 0) {
            i4 |= ((i3 & 8) == 0 && composerStartRestartGroup.changed(function1)) ? 2048 : 1024;
        }
        if ((i4 & 5851) == 1170 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i2 & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                if (i5 != 0) {
                    modifier = Modifier.INSTANCE;
                }
                if (i6 != 0) {
                    str = f6689a;
                }
                if ((i3 & 4) != 0) {
                    mVar = com.moloco.sdk.service_locator.a.h.f6477a.d();
                    i4 &= -897;
                }
                if ((i3 & 8) != 0) {
                    function1 = new e(mVar, str);
                    i4 &= -7169;
                }
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i3 & 4) != 0) {
                    i4 &= -897;
                }
                if ((i3 & 8) != 0) {
                    i4 &= -7169;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1950835232, i4, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.defaultNativeAdImageBadge (AdBadge.kt:149)");
            }
            a(modifier, str, function1, composerStartRestartGroup, (i4 & 126) | ((i4 >> 3) & 896), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        Modifier modifier2 = modifier;
        String str2 = str;
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.m mVar2 = mVar;
        Function1<? super String, Unit> function2 = function1;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new f(modifier2, str2, mVar2, function2, i2, i3));
    }

    public static final void a(Composer composer, int i2) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-1309369895);
        if (i2 == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1309369895, i2, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.AdBadgePreview (AdBadge.kt:165)");
            }
            MaterialThemeKt.MaterialTheme(null, null, null, k.f6719a.a(), composerStartRestartGroup, 3072, 7);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new d(i2));
    }
}
