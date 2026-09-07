package com.moloco.sdk.internal.services;

import android.content.Context;
import android.content.pm.PackageInfo;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class l implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f6420a;
    public j b;

    public l(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f6420a = context;
    }

    @Override // com.moloco.sdk.internal.services.k
    public j invoke() {
        Object objM7904constructorimpl;
        j jVar = this.b;
        if (jVar != null) {
            return jVar;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            Context context = this.f6420a;
            String string = context.getPackageManager().getApplicationLabel(context.getApplicationInfo()).toString();
            PackageInfo packageInfoA = m.a(this.f6420a);
            String str = packageInfoA.packageName;
            Intrinsics.checkNotNullExpressionValue(str, "it.packageName");
            String str2 = packageInfoA.versionName;
            Intrinsics.checkNotNullExpressionValue(str2, "it.versionName");
            j jVar2 = new j(string, str, str2);
            this.b = jVar2;
            objM7904constructorimpl = Result.m7904constructorimpl(jVar2);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m7910isFailureimpl(objM7904constructorimpl)) {
            objM7904constructorimpl = null;
        }
        j jVar3 = (j) objM7904constructorimpl;
        return jVar3 == null ? new j("", "", "") : jVar3;
    }
}
