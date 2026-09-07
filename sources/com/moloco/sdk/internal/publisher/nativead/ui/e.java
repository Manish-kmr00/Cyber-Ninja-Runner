package com.moloco.sdk.internal.publisher.nativead.ui;

import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.res.PainterResources_androidKt;
import com.moloco.sdk.R;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.n;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function7;

/* JADX INFO: loaded from: classes11.dex */
public final class e {
    public static final Function7<BoxScope, Boolean, Boolean, Function2<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, ? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c.EnumC0707a, Unit>, Function1<? super Boolean, Unit>, Composer, Integer, Unit> a(Composer composer, int i) {
        composer.startReplaceableGroup(-314360066);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-314360066, i, -1, "com.moloco.sdk.internal.publisher.nativead.ui.nativeVideoMuteButton (NativeVideoMuteButton.kt:11)");
        }
        Function7<BoxScope, Boolean, Boolean, Function2<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c, ? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c.EnumC0707a, Unit>, Function1<? super Boolean, Unit>, Composer, Integer, Unit> function7A = n.a(0L, 0L, null, 0L, Alignment.INSTANCE.getTopStart(), null, Color.INSTANCE.m1668getWhite0d7_KjU(), PainterResources_androidKt.painterResource(R.drawable.moloco_twotone_volume_off_24, composer, 0), PainterResources_androidKt.painterResource(R.drawable.moloco_twotone_volume_up_24, composer, 0), null, composer, 152592384, 559);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return function7A;
    }
}
