package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class a0 {
    public static final int d = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z f6886a;
    public final List<z> b;
    public final List<z> c;

    public a0(z zVar, List<z> clickTrackingList, List<z> customClickList) {
        Intrinsics.checkNotNullParameter(clickTrackingList, "clickTrackingList");
        Intrinsics.checkNotNullParameter(customClickList, "customClickList");
        this.f6886a = zVar;
        this.b = clickTrackingList;
        this.c = customClickList;
    }

    public final z a() {
        return this.f6886a;
    }

    public final List<z> b() {
        return this.b;
    }

    public final List<z> c() {
        return this.c;
    }
}
