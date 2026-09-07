package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils;

import android.content.res.Resources;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.unit.IntSize;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f6784a = new c();
    public static final int b = 0;

    public final float a(int i) {
        return i / Resources.getSystem().getDisplayMetrics().density;
    }

    public final com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.g b(LayoutCoordinates layoutCoordinates) {
        Intrinsics.checkNotNullParameter(layoutCoordinates, "<this>");
        return new com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.g(a(IntSize.m4003getWidthimpl(layoutCoordinates.mo3126getSizeYbymL2g())), a(IntSize.m4002getHeightimpl(layoutCoordinates.mo3126getSizeYbymL2g())));
    }

    public final com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.f a(LayoutCoordinates layoutCoordinates) {
        Intrinsics.checkNotNullParameter(layoutCoordinates, "<this>");
        return new com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.f(a((int) Offset.m1395getXimpl(LayoutCoordinatesKt.positionInRoot(layoutCoordinates))), a((int) Offset.m1396getYimpl(LayoutCoordinatesKt.positionInRoot(layoutCoordinates))));
    }

    public final com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.f a(long j) {
        return new com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.f(a((int) Offset.m1395getXimpl(j)), a((int) Offset.m1396getYimpl(j)));
    }

    public final com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c a(LayoutCoordinates layoutCoordinates, com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c.EnumC0707a buttonType) {
        Intrinsics.checkNotNullParameter(layoutCoordinates, "<this>");
        Intrinsics.checkNotNullParameter(buttonType, "buttonType");
        return new com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c(buttonType, a(layoutCoordinates), b(layoutCoordinates));
    }

    public final boolean a(com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0705a.c cVar) {
        Intrinsics.checkNotNullParameter(cVar, "<this>");
        return cVar.f().c() > 0.0f && cVar.f().d() > 0.0f;
    }
}
