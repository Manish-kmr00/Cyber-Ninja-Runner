package com.yandex.mobile.ads.impl;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class t61 extends dk<u61> {
    private final x61 c;

    @Override // com.yandex.mobile.ads.impl.dk
    protected final ip1 a(o3 adConfiguration) {
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        ip1 ip1VarA2 = super.a2(adConfiguration);
        ip1VarA2.b(Boolean.valueOf(adConfiguration.u()), "image_loading_automatically");
        List<String> listM = adConfiguration.m();
        if (!listM.isEmpty()) {
            ip1VarA2.b(listM, "image_sizes");
        }
        return ip1VarA2;
    }

    public /* synthetic */ t61() {
        this(new x91(), new x61());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t61(x91 nativeResponseReportDataProvider, x61 nativeAdResponseDataProvider) {
        super(nativeResponseReportDataProvider);
        Intrinsics.checkNotNullParameter(nativeResponseReportDataProvider, "nativeResponseReportDataProvider");
        Intrinsics.checkNotNullParameter(nativeAdResponseDataProvider, "nativeAdResponseDataProvider");
        this.c = nativeAdResponseDataProvider;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.yandex.mobile.ads.impl.dk
    protected final ip1 a(int i, o3 adConfiguration, qq1 qq1Var) {
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        ip1 ip1VarA = super.a(i, adConfiguration, qq1Var);
        hp1.c cVar = null;
        o8 adResponse = qq1Var != null ? (o8) qq1Var.f10044a : null;
        if (204 == i) {
            cVar = hp1.c.e;
        } else if (adResponse != null && i == 200) {
            this.c.getClass();
            Intrinsics.checkNotNullParameter(adResponse, "adResponse");
            u61 u61Var = (u61) adResponse.I();
            if (u61Var != null) {
                cVar = (hp1.c) u61Var.f().get("status");
            } else if (adResponse.D() == null) {
                cVar = hp1.c.d;
            }
        } else {
            cVar = hp1.c.d;
        }
        if (cVar != null) {
            ip1VarA.b(cVar.a(), "status");
        }
        return ip1VarA;
    }
}
