package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui;

import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.profileinstaller.ProfileVerifier;
import com.json.mediationsdk.utils.IronSourceConstants;
import kotlin.UInt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function10;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes9.dex */
public final class d {

    public static final class a extends Lambda implements Function10<BoxScope, Boolean, Boolean, Function0<? extends Unit>, Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, ? extends Unit>, Boolean, UInt, UInt, Composer, Integer, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Alignment f6704a;
        public final /* synthetic */ PaddingValues b;
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c.EnumC0707a c;
        public final /* synthetic */ int d;
        public final /* synthetic */ o e;
        public final /* synthetic */ Function0<Unit> f;
        public final /* synthetic */ long g;
        public final /* synthetic */ long h;
        public final /* synthetic */ long i;
        public final /* synthetic */ com.moloco.sdk.internal.ortb.model.i j;

        /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.d$a$a, reason: collision with other inner class name */
        public static final class C0621a extends Lambda implements Function3<AnimatedVisibilityScope, Composer, Integer, Unit> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c.EnumC0707a f6705a;
            public final /* synthetic */ Function1<com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, Unit> b;
            public final /* synthetic */ int c;
            public final /* synthetic */ int d;
            public final /* synthetic */ boolean e;
            public final /* synthetic */ o f;
            public final /* synthetic */ boolean g;
            public final /* synthetic */ int h;
            public final /* synthetic */ int i;
            public final /* synthetic */ Function0<Unit> j;
            public final /* synthetic */ Function0<Unit> k;
            public final /* synthetic */ long l;
            public final /* synthetic */ long m;
            public final /* synthetic */ long n;
            public final /* synthetic */ com.moloco.sdk.internal.ortb.model.i o;

            /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.d$a$a$a, reason: collision with other inner class name */
            public static final class C0622a extends Lambda implements Function3<Modifier, Composer, Integer, Unit> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ boolean f6706a;
                public final /* synthetic */ o b;
                public final /* synthetic */ boolean c;
                public final /* synthetic */ int d;
                public final /* synthetic */ int e;
                public final /* synthetic */ Function0<Unit> f;
                public final /* synthetic */ Function0<Unit> g;
                public final /* synthetic */ int h;
                public final /* synthetic */ int i;
                public final /* synthetic */ long j;
                public final /* synthetic */ long k;
                public final /* synthetic */ long l;
                public final /* synthetic */ com.moloco.sdk.internal.ortb.model.i m;

                /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.d$a$a$a$a, reason: collision with other inner class name */
                public static final class C0623a extends Lambda implements Function0<Unit> {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    public final /* synthetic */ Function0<Unit> f6707a;
                    public final /* synthetic */ Function0<Unit> b;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public C0623a(Function0<Unit> function0, Function0<Unit> function1) {
                        super(0);
                        this.f6707a = function0;
                        this.b = function1;
                    }

                    public final void a() {
                        this.f6707a.invoke();
                        Function0<Unit> function0 = this.b;
                        if (function0 != null) {
                            function0.invoke();
                        }
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        a();
                        return Unit.INSTANCE;
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C0622a(boolean z, o oVar, boolean z2, int i, int i2, Function0<Unit> function0, Function0<Unit> function1, int i3, int i4, long j, long j2, long j3, com.moloco.sdk.internal.ortb.model.i iVar) {
                    super(3);
                    this.f6706a = z;
                    this.b = oVar;
                    this.c = z2;
                    this.d = i;
                    this.e = i2;
                    this.f = function0;
                    this.g = function1;
                    this.h = i3;
                    this.i = i4;
                    this.j = j;
                    this.k = j2;
                    this.l = j3;
                    this.m = iVar;
                }

                public final void a(Modifier modifier, Composer composer, int i) {
                    int i2;
                    Intrinsics.checkNotNullParameter(modifier, "modifier");
                    if ((i & 14) == 0) {
                        i2 = i | (composer.changed(modifier) ? 4 : 2);
                    } else {
                        i2 = i;
                    }
                    if ((i2 & 91) == 18 && composer.getSkipping()) {
                        composer.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-239633113, i2, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.adCountdownButton.<anonymous>.<anonymous>.<anonymous> (AdCountdownButton.kt:66)");
                    }
                    o aVar = this.f6706a ? this.b : new o.a(this.c, this.d, this.e, null);
                    Function0<Unit> function0 = this.f;
                    Function0<Unit> function1 = this.g;
                    composer.startReplaceableGroup(511388516);
                    boolean zChanged = composer.changed(function0) | composer.changed(function1);
                    Object objRememberedValue = composer.rememberedValue();
                    if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new C0623a(function0, function1);
                        composer.updateRememberedValue(objRememberedValue);
                    }
                    composer.endReplaceableGroup();
                    boolean z = this.f6706a;
                    long j = this.j;
                    long j2 = this.k;
                    long j3 = this.l;
                    com.moloco.sdk.internal.ortb.model.i iVar = this.m;
                    int i3 = ((i2 << 3) & 112) | ((this.h << 6) & 7168);
                    int i4 = this.i;
                    int i5 = i4 << 6;
                    n.a(aVar, modifier, (Function0) objRememberedValue, z, j, j2, j3, iVar, composer, ((i4 >> 3) & 29360128) | i3 | (i5 & 57344) | (i5 & 458752) | (i5 & 3670016), 0);
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
            public C0621a(com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c.EnumC0707a enumC0707a, Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, Unit> function1, int i, int i2, boolean z, o oVar, boolean z2, int i3, int i4, Function0<Unit> function0, Function0<Unit> function2, long j, long j2, long j3, com.moloco.sdk.internal.ortb.model.i iVar) {
                super(3);
                this.f6705a = enumC0707a;
                this.b = function1;
                this.c = i;
                this.d = i2;
                this.e = z;
                this.f = oVar;
                this.g = z2;
                this.h = i3;
                this.i = i4;
                this.j = function0;
                this.k = function2;
                this.l = j;
                this.m = j2;
                this.n = j3;
                this.o = iVar;
            }

            public final void a(AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i) {
                Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1799237255, i, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.adCountdownButton.<anonymous>.<anonymous> (AdCountdownButton.kt:61)");
                }
                v.a(Modifier.INSTANCE, this.f6705a, this.b, ComposableLambdaKt.composableLambda(composer, -239633113, true, new C0622a(this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.d, this.c, this.l, this.m, this.n, this.o)), composer, ((this.c >> 15) & 112) | IronSourceConstants.BN_REFRESH_PAUSE | ((this.d >> 6) & 896), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer, Integer num) {
                a(animatedVisibilityScope, composer, num.intValue());
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Alignment alignment, PaddingValues paddingValues, com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c.EnumC0707a enumC0707a, int i, o oVar, Function0<Unit> function0, long j, long j2, long j3, com.moloco.sdk.internal.ortb.model.i iVar) {
            super(10);
            this.f6704a = alignment;
            this.b = paddingValues;
            this.c = enumC0707a;
            this.d = i;
            this.e = oVar;
            this.f = function0;
            this.g = j;
            this.h = j2;
            this.i = j3;
            this.j = iVar;
        }

        public final void a(BoxScope boxScope, boolean z, boolean z2, Function0<Unit> onClick, Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, Unit> onButtonRendered, boolean z3, int i, int i2, Composer composer, int i3) {
            int i4;
            Intrinsics.checkNotNullParameter(boxScope, "$this$null");
            Intrinsics.checkNotNullParameter(onClick, "onClick");
            Intrinsics.checkNotNullParameter(onButtonRendered, "onButtonRendered");
            if ((i3 & 14) == 0) {
                i4 = (composer.changed(boxScope) ? 4 : 2) | i3;
            } else {
                i4 = i3;
            }
            if ((i3 & 112) == 0) {
                i4 |= composer.changed(z) ? 32 : 16;
            }
            if ((i3 & 896) == 0) {
                i4 |= composer.changed(z2) ? 256 : 128;
            }
            if ((i3 & 7168) == 0) {
                i4 |= composer.changed(onClick) ? 2048 : 1024;
            }
            if ((57344 & i3) == 0) {
                i4 |= composer.changed(onButtonRendered) ? 16384 : 8192;
            }
            if ((458752 & i3) == 0) {
                i4 |= composer.changed(z3) ? 131072 : 65536;
            }
            if ((3670016 & i3) == 0) {
                i4 |= composer.changed(i) ? 1048576 : 524288;
            }
            if ((i3 & 29360128) == 0) {
                i4 |= composer.changed(i2) ? 8388608 : 4194304;
            }
            int i5 = i4;
            if ((191739611 & i5) == 38347922 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1575255135, i5, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.adCountdownButton.<anonymous> (AdCountdownButton.kt:53)");
            }
            AnimatedVisibilityKt.AnimatedVisibility(z2, PaddingKt.padding(WindowInsetsPadding_androidKt.displayCutoutPadding(boxScope.align(Modifier.INSTANCE, this.f6704a)), this.b), (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.composableLambda(composer, 1799237255, true, new C0621a(this.c, onButtonRendered, this.d, i5, z, this.e, z3, i, i2, onClick, this.f, this.g, this.h, this.i, this.j)), composer, ((i5 >> 6) & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 28);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }

        @Override // kotlin.jvm.functions.Function10
        public /* bridge */ /* synthetic */ Unit invoke(BoxScope boxScope, Boolean bool, Boolean bool2, Function0<? extends Unit> function0, Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, ? extends Unit> function1, Boolean bool3, UInt uInt, UInt uInt2, Composer composer, Integer num) {
            a(boxScope, bool.booleanValue(), bool2.booleanValue(), function0, function1, bool3.booleanValue(), uInt.getData(), uInt2.getData(), composer, num.intValue());
            return Unit.INSTANCE;
        }
    }

    public static final Function10<BoxScope, Boolean, Boolean, Function0<Unit>, Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, Unit>, Boolean, UInt, UInt, Composer, Integer, Unit> a(Alignment alignment, PaddingValues padding, long j, long j2, long j3, o afterCountdownButtonPart, com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c.EnumC0707a buttonType, Function0<Unit> function0, com.moloco.sdk.internal.ortb.model.i iVar, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(alignment, "alignment");
        Intrinsics.checkNotNullParameter(padding, "padding");
        Intrinsics.checkNotNullParameter(afterCountdownButtonPart, "afterCountdownButtonPart");
        Intrinsics.checkNotNullParameter(buttonType, "buttonType");
        composer.startReplaceableGroup(803707432);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(803707432, i, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.adCountdownButton (AdCountdownButton.kt:43)");
        }
        ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer, 1575255135, true, new a(alignment, padding, buttonType, i, afterCountdownButtonPart, function0, j, j2, j3, iVar));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return composableLambda;
    }
}
