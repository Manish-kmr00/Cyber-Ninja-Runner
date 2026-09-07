package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.Modifier;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes9.dex */
public final class v {

    public static final class a extends Lambda implements Function1<com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1<com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, Unit> f6785a;
        public final /* synthetic */ MutableState<com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c> b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, Unit> function1, MutableState<com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c> mutableState) {
            super(1);
            this.f6785a = function1;
            this.b = mutableState;
        }

        public final void a(com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c it) {
            Intrinsics.checkNotNullParameter(it, "it");
            v.a(this.b, it);
            this.f6785a.invoke(it);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c cVar) {
            a(cVar);
            return Unit.INSTANCE;
        }
    }

    public static final class b extends Lambda implements Function2<Composer, Integer, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Modifier f6786a;
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c.EnumC0707a b;
        public final /* synthetic */ Function1<com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, Unit> c;
        public final /* synthetic */ Function3<Modifier, Composer, Integer, Unit> d;
        public final /* synthetic */ int e;
        public final /* synthetic */ int f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public b(Modifier modifier, com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c.EnumC0707a enumC0707a, Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, Unit> function1, Function3<? super Modifier, ? super Composer, ? super Integer, Unit> function3, int i, int i2) {
            super(2);
            this.f6786a = modifier;
            this.b = enumC0707a;
            this.c = function1;
            this.d = function3;
            this.e = i;
            this.f = i2;
        }

        public final void a(Composer composer, int i) {
            v.a(this.f6786a, this.b, this.c, this.d, composer, this.e | 1, this.f);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            a(composer, num.intValue());
            return Unit.INSTANCE;
        }
    }

    public static final void a(Modifier modifier, com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c.EnumC0707a buttonType, Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, Unit> onButtonRendered, Function3<? super Modifier, ? super Composer, ? super Integer, Unit> content, Composer composer, int i, int i2) {
        int i3;
        Intrinsics.checkNotNullParameter(buttonType, "buttonType");
        Intrinsics.checkNotNullParameter(onButtonRendered, "onButtonRendered");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(-361890132);
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 112) == 0) {
            i3 |= composerStartRestartGroup.changed(buttonType) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 896) == 0) {
            i3 |= composerStartRestartGroup.changed(onButtonRendered) ? 256 : 128;
        }
        if ((i2 & 8) != 0) {
            i3 |= 3072;
        } else if ((i & 7168) == 0) {
            i3 |= composerStartRestartGroup.changed(content) ? 2048 : 1024;
        }
        if ((i3 & 5851) == 1170 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (i4 != 0) {
                modifier = Modifier.INSTANCE;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-361890132, i3, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.TrackableButton (TrackableButton.kt:17)");
            }
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils.b.a(buttonType), null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            MutableState mutableState = (MutableState) objRememberedValue;
            com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c cVarA = a(mutableState);
            composerStartRestartGroup.startReplaceableGroup(511388516);
            boolean zChanged = composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(onButtonRendered);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = new a(onButtonRendered, mutableState);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            composerStartRestartGroup.endReplaceableGroup();
            content.invoke(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.modifiers.a.a(modifier, cVarA, (Function1) objRememberedValue2), composerStartRestartGroup, Integer.valueOf((i3 >> 6) & 112));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        Modifier modifier2 = modifier;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new b(modifier2, buttonType, onButtonRendered, content, i, i2));
    }

    public static final com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c a(MutableState<com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c> mutableState) {
        return mutableState.getValue();
    }

    public static final void a(MutableState<com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c> mutableState, com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c cVar) {
        mutableState.setValue(cVar);
    }
}
