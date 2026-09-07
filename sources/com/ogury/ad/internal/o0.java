package com.ogury.ad.internal;

import android.content.Context;
import com.ogury.ad.common.OguryMediation;
import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f7370a;
    public final k9 b;

    public o0(Context context) {
        k9 uuidUtils = new k9();
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uuidUtils, "uuidUtils");
        this.f7370a = context;
        this.b = uuidUtils;
    }

    public final x a(d adConfig, o adType, OguryMediation oguryMediation, boolean z) {
        Intrinsics.checkNotNullParameter(adConfig, "adConfig");
        Intrinsics.checkNotNullParameter(adType, "adType");
        Context context = this.f7370a;
        this.b.getClass();
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return new x(context, string, oguryMediation, adConfig, adType, z);
    }
}
