package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class m {
    public static final int c = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6899a;
    public final List<String> b;

    public m(String clickThroughUrl, List<String> clickTrackingUrlList) {
        Intrinsics.checkNotNullParameter(clickThroughUrl, "clickThroughUrl");
        Intrinsics.checkNotNullParameter(clickTrackingUrlList, "clickTrackingUrlList");
        this.f6899a = clickThroughUrl;
        this.b = clickTrackingUrlList;
    }

    public final String a() {
        return this.f6899a;
    }

    public final List<String> b() {
        return this.b;
    }
}
