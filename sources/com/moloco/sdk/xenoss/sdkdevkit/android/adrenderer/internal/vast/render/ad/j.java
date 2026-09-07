package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad;

import android.content.Context;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.m;
import java.util.List;
import kotlin.UInt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes11.dex */
public final class j {
    public static final List<k> a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a aVar, m externalLinkHandler, Context context, com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a customUserEventBuilderService, boolean z, Boolean bool, int i, int i2, int i3, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        Intrinsics.checkNotNullParameter(externalLinkHandler, "externalLinkHandler");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(customUserEventBuilderService, "customUserEventBuilderService");
        k[] kVarArr = new k[3];
        kVarArr[0] = new k.c(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.e(aVar.j(), 0, z, bool, i, z2, z3, context, customUserEventBuilderService, externalLinkHandler));
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.c cVarF = aVar.f();
        kVarArr[1] = cVarF != null ? new k.a(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.companion.c(cVarF, UInt.m8001constructorimpl(RangesKt.coerceAtLeast(i2, 0)), context, customUserEventBuilderService, externalLinkHandler, null)) : null;
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.i iVarG = aVar.g();
        kVarArr[2] = iVarG != null ? new k.b(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.dec.c(iVarG, aVar.j().i(), UInt.m8001constructorimpl(RangesKt.coerceAtLeast(i3, 0)), context, customUserEventBuilderService, externalLinkHandler, null)) : null;
        return CollectionsKt.listOfNotNull((Object[]) kVarArr);
    }
}
