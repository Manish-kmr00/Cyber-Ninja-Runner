package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose;

import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes7.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Function5<BoxScope, Boolean, Function0<Unit>, Composer, Integer, Unit> f6997a = c.f6969a.a();

    public static final class a extends Lambda implements Function7<BoxScope, Boolean, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, Function1<? super Boolean, ? extends Unit>, Function0<? extends Unit>, Composer, Integer, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function5<BoxScope, Boolean, Function0<Unit>, Composer, Integer, Unit> f6998a;
        public final /* synthetic */ int b;

        /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.j$a$a, reason: collision with other inner class name */
        public static final class C0668a extends Lambda implements Function0<Unit> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i f6999a;
            public final /* synthetic */ Function0<Unit> b;
            public final /* synthetic */ Function1<Boolean, Unit> c;
            public final /* synthetic */ boolean d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public C0668a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i iVar, Function0<Unit> function0, Function1<? super Boolean, Unit> function1, boolean z) {
                super(0);
                this.f6999a = iVar;
                this.b = function0;
                this.c = function1;
                this.d = z;
            }

            public final void a() {
                if (this.f6999a instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i.a) {
                    this.b.invoke();
                } else {
                    this.c.invoke(Boolean.valueOf(!this.d));
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                a();
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(Function5<? super BoxScope, ? super Boolean, ? super Function0<Unit>, ? super Composer, ? super Integer, Unit> function5, int i) {
            super(7);
            this.f6998a = function5;
            this.b = i;
        }

        public final void a(BoxScope boxScope, boolean z, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i progress, Function1<? super Boolean, Unit> onShouldPlay, Function0<Unit> onShouldReplay, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(boxScope, "$this$null");
            Intrinsics.checkNotNullParameter(progress, "progress");
            Intrinsics.checkNotNullParameter(onShouldPlay, "onShouldPlay");
            Intrinsics.checkNotNullParameter(onShouldReplay, "onShouldReplay");
            int i2 = (i & 14) == 0 ? (composer.changed(boxScope) ? 4 : 2) | i : i;
            if ((i & 112) == 0) {
                i2 |= composer.changed(z) ? 32 : 16;
            }
            if ((i & 896) == 0) {
                i2 |= composer.changed(progress) ? 256 : 128;
            }
            if ((i & 7168) == 0) {
                i2 |= composer.changed(onShouldPlay) ? 2048 : 1024;
            }
            if ((i & 57344) == 0) {
                i2 |= composer.changed(onShouldReplay) ? 16384 : 8192;
            }
            if ((374491 & i2) == 74898 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1279825651, i2, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.defaultPlaybackControl.<anonymous> (PlaybackControl.kt:30)");
            }
            Object[] objArr = {progress, onShouldReplay, onShouldPlay, Boolean.valueOf(z)};
            composer.startReplaceableGroup(-568225417);
            boolean zChanged = false;
            for (int i3 = 0; i3 < 4; i3++) {
                zChanged |= composer.changed(objArr[i3]);
            }
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new C0668a(progress, onShouldReplay, onShouldPlay, z);
                composer.updateRememberedValue(objRememberedValue);
            }
            composer.endReplaceableGroup();
            this.f6998a.invoke(boxScope, Boolean.valueOf(z), (Function0) objRememberedValue, composer, Integer.valueOf((i2 & 126) | ((this.b << 9) & 7168)));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }

        @Override // kotlin.jvm.functions.Function7
        public /* bridge */ /* synthetic */ Unit invoke(BoxScope boxScope, Boolean bool, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i iVar, Function1<? super Boolean, ? extends Unit> function1, Function0<? extends Unit> function0, Composer composer, Integer num) {
            a(boxScope, bool.booleanValue(), iVar, function1, function0, composer, num.intValue());
            return Unit.INSTANCE;
        }
    }

    public static final Function7<BoxScope, Boolean, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, Function1<? super Boolean, Unit>, Function0<Unit>, Composer, Integer, Unit> a(Function5<? super BoxScope, ? super Boolean, ? super Function0<Unit>, ? super Composer, ? super Integer, Unit> function5, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(1756131298);
        if ((i2 & 1) != 0) {
            function5 = f6997a;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1756131298, i, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.defaultPlaybackControl (PlaybackControl.kt:28)");
        }
        ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer, -1279825651, true, new a(function5, i));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return composableLambda;
    }

    public static final Function5<BoxScope, Boolean, Function0<Unit>, Composer, Integer, Unit> a() {
        return f6997a;
    }
}
