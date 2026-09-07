package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class qe1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final he1 f10011a;
    private final ie1 b;
    private final re1 c;
    private final Context d;

    public qe1(Context context, qa2 verificationNotExecutedListener, he1 omSdkAdSessionProvider, ie1 omSdkInitializer, re1 omSdkUsageValidator) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(verificationNotExecutedListener, "verificationNotExecutedListener");
        Intrinsics.checkNotNullParameter(omSdkAdSessionProvider, "omSdkAdSessionProvider");
        Intrinsics.checkNotNullParameter(omSdkInitializer, "omSdkInitializer");
        Intrinsics.checkNotNullParameter(omSdkUsageValidator, "omSdkUsageValidator");
        this.f10011a = omSdkAdSessionProvider;
        this.b = omSdkInitializer;
        this.c = omSdkUsageValidator;
        this.d = context.getApplicationContext();
    }

    public final pe1 a(List<oa2> verifications) {
        Intrinsics.checkNotNullParameter(verifications, "verifications");
        re1 re1Var = this.c;
        Context context = this.d;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        if (!re1Var.a(context)) {
            return null;
        }
        ie1 ie1Var = this.b;
        Context context2 = this.d;
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        ie1Var.a(context2);
        mn2 mn2VarA = this.f10011a.a(verifications);
        if (mn2VarA == null) {
            return null;
        }
        zv0 zv0VarA = zv0.a(mn2VarA);
        Intrinsics.checkNotNullExpressionValue(zv0VarA, "createMediaEvents(...)");
        p3 p3VarA = p3.a(mn2VarA);
        Intrinsics.checkNotNullExpressionValue(p3VarA, "createAdEvents(...)");
        return new pe1(mn2VarA, zv0VarA, p3VarA);
    }
}
