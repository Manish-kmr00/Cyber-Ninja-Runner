package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class k implements com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f7076a;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.j b;

    public k(j resource, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.j jVar) {
        Intrinsics.checkNotNullParameter(resource, "resource");
        this.f7076a = resource;
        this.b = jVar;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.j
    public void destroy() {
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.j jVar = this.b;
        if (jVar != null) {
            jVar.destroy();
        }
    }

    public final j j() {
        return this.f7076a;
    }

    public /* synthetic */ k(j jVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.j jVar2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(jVar, (i & 2) != 0 ? null : jVar2);
    }
}
