package com.moloco.sdk.internal.services;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class e implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f6367a;

    public e(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f6367a = context;
    }

    @Override // com.moloco.sdk.internal.services.d
    public c a() {
        Object objM7904constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            objM7904constructorimpl = Result.m7904constructorimpl(AdvertisingIdClient.getAdvertisingIdInfo(this.f6367a));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(th));
        }
        c aVar = null;
        if (Result.m7910isFailureimpl(objM7904constructorimpl)) {
            objM7904constructorimpl = null;
        }
        AdvertisingIdClient.Info info = (AdvertisingIdClient.Info) objM7904constructorimpl;
        if (info != null) {
            if (info.isLimitAdTrackingEnabled()) {
                aVar = c.b.f6355a;
            } else {
                String id = info.getId();
                if (id != null) {
                    Intrinsics.checkNotNullExpressionValue(id, "this");
                    aVar = new c.a(id);
                }
            }
            if (aVar != null) {
                return aVar;
            }
        }
        return c.b.f6355a;
    }
}
