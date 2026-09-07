package com.yandex.mobile.ads.impl;

import com.facebook.internal.ServerProtocol;
import kotlin.jvm.internal.Intrinsics;
import net.pubnative.lite.sdk.analytics.Reporting;

/* JADX INFO: loaded from: classes5.dex */
public final class q8<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final dk.a<T> f9993a;

    public q8(dk.a<T> responseReportDataProvider) {
        Intrinsics.checkNotNullParameter(responseReportDataProvider, "responseReportDataProvider");
        this.f9993a = responseReportDataProvider;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0062  */
    public final ip1 a(int i, o3 adConfiguration, qq1 qq1Var) {
        String str;
        o8 o8Var;
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        ip1 ip1VarA = this.f9993a.a(qq1Var, adConfiguration);
        zy1 zy1VarR = adConfiguration.r();
        if (zy1VarR != null) {
            ip1VarA.b(zy1VarR.a().a(), "size_type");
            ip1VarA.b(Integer.valueOf(zy1VarR.getWidth()), "width");
            ip1VarA.b(Integer.valueOf(zy1VarR.getHeight()), "height");
        }
        ip1VarA.b(Integer.valueOf(i), i == -1 ? "error_code" : "code");
        if (qq1Var == null || (o8Var = (o8) qq1Var.f10044a) == null) {
            str = "empty";
        } else if (o8Var.D() != null) {
            str = "mediation";
        } else if (o8Var.I() != null) {
            str = Reporting.Key.CLICK_SOURCE_TYPE_AD;
        } else {
            str = "empty";
        }
        ip1VarA.b(str, ServerProtocol.DIALOG_PARAM_RESPONSE_TYPE);
        if (qq1Var != null) {
            o8 o8Var2 = (o8) qq1Var.f10044a;
            ip1VarA.a(o8Var2 != null ? o8Var2.a() : null);
        }
        return ip1VarA;
    }
}
