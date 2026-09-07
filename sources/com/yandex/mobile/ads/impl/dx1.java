package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class dx1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final qr f8741a;

    public static boolean a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        int i = iw1.l;
        cu1 cu1VarA = iw1.a.a().a(context);
        return cu1VarA != null && cu1VarA.e0();
    }

    public final boolean b(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        int i = iw1.l;
        cu1 sdkConfiguration = iw1.a.a().a(context);
        if (sdkConfiguration != null && sdkConfiguration.w0() && !a(context)) {
            this.f8741a.getClass();
            Intrinsics.checkNotNullParameter(sdkConfiguration, "sdkConfiguration");
            if (Intrinsics.areEqual(iw1.a.a().f(), sdkConfiguration.T()) || !Intrinsics.areEqual(iw1.a.a().f(), Boolean.TRUE)) {
                return false;
            }
        }
        return true;
    }

    public /* synthetic */ dx1() {
        this(new qr());
    }

    public dx1(qr consentUpdateValidator) {
        Intrinsics.checkNotNullParameter(consentUpdateValidator, "consentUpdateValidator");
        this.f8741a = consentUpdateValidator;
    }
}
