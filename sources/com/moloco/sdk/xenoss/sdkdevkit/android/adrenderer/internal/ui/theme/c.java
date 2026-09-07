package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.theme;

import androidx.compose.foundation.DarkThemeKt;
import androidx.compose.material.Colors;
import androidx.compose.material.ColorsKt;
import androidx.compose.material.MaterialThemeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes8.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Colors f6780a;
    public static final Colors b;

    public static final class a extends Lambda implements Function2<Composer, Integer, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f6781a;
        public final /* synthetic */ Function2<Composer, Integer, Unit> b;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(boolean z, Function2<? super Composer, ? super Integer, Unit> function2, int i, int i2) {
            super(2);
            this.f6781a = z;
            this.b = function2;
            this.c = i;
            this.d = i2;
        }

        public final void a(Composer composer, int i) {
            c.a(this.f6781a, this.b, composer, this.c | 1, this.d);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            a(composer, num.intValue());
            return Unit.INSTANCE;
        }
    }

    static {
        long jF = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.theme.a.f();
        long jF2 = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.theme.a.f();
        Color.Companion companion = Color.INSTANCE;
        f6780a = ColorsKt.m999darkColors2qZNXz8$default(jF, jF2, companion.m1668getWhite0d7_KjU(), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 4088, null);
        b = ColorsKt.m1000lightColors2qZNXz8((4095 & 1) != 0 ? ColorKt.Color(4284612846L) : com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.theme.a.f(), (4095 & 2) != 0 ? ColorKt.Color(4281794739L) : com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.theme.a.f(), (4095 & 4) != 0 ? ColorKt.Color(4278442694L) : companion.m1668getWhite0d7_KjU(), (4095 & 8) != 0 ? ColorKt.Color(4278290310L) : 0L, (4095 & 16) != 0 ? Color.INSTANCE.m1668getWhite0d7_KjU() : 0L, (4095 & 32) != 0 ? Color.INSTANCE.m1668getWhite0d7_KjU() : 0L, (4095 & 64) != 0 ? ColorKt.Color(4289724448L) : 0L, (4095 & 128) != 0 ? Color.INSTANCE.m1668getWhite0d7_KjU() : 0L, (4095 & 256) != 0 ? Color.INSTANCE.m1657getBlack0d7_KjU() : 0L, (4095 & 512) != 0 ? Color.INSTANCE.m1657getBlack0d7_KjU() : 0L, (4095 & 1024) != 0 ? Color.INSTANCE.m1657getBlack0d7_KjU() : 0L, (4095 & 2048) != 0 ? Color.INSTANCE.m1668getWhite0d7_KjU() : 0L);
    }

    public static final void a(boolean z, Function2<? super Composer, ? super Integer, Unit> content, Composer composer, int i, int i2) {
        int i3;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1535794432);
        if ((i & 14) == 0) {
            i3 = (((i2 & 1) == 0 && composerStartRestartGroup.changed(z)) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 112) == 0) {
            i3 |= composerStartRestartGroup.changed(content) ? 32 : 16;
        }
        if ((i3 & 91) == 18 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i2 & 1) != 0) {
                    i3 &= -15;
                }
            } else if ((i2 & 1) != 0) {
                z = DarkThemeKt.isSystemInDarkTheme(composerStartRestartGroup, 0);
                i3 &= -15;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1535794432, i3, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.theme.Theme (Theme.kt:31)");
            }
            MaterialThemeKt.MaterialTheme(z ? f6780a : b, d.a(), b.a(), content, composerStartRestartGroup, ((i3 << 6) & 7168) | 432, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new a(z, content, i, i2));
    }
}
