package com.ogury.ad.internal;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f7444a;
    public final d b;
    public final o c;
    public final k9 d;

    public y(Context context, d adConfig, o adType) {
        k9 uuidUtils = new k9();
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adConfig, "adConfig");
        Intrinsics.checkNotNullParameter(adType, "adType");
        Intrinsics.checkNotNullParameter(uuidUtils, "uuidUtils");
        this.f7444a = context;
        this.b = adConfig;
        this.c = adType;
        this.d = uuidUtils;
    }
}
