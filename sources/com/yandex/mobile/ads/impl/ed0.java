package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class ed0 implements ah0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o8<String> f8786a;
    private final rg0 b;
    private final u1 c;
    private cs d;
    private m62 e;

    public ed0(Context context, uu1 sdkEnvironmentModule, o3 adConfiguration, o8<String> adResponse, t8 adResultReceiver) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sdkEnvironmentModule, "sdkEnvironmentModule");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(adResultReceiver, "adResultReceiver");
        this.f8786a = adResponse;
        this.b = new rg0(context, adConfiguration);
        this.c = new u1(context, adResponse, adResultReceiver, sdkEnvironmentModule, adConfiguration);
    }

    @Override // com.yandex.mobile.ads.impl.ah0
    public final void a(w3 adFetchRequestError) {
        Intrinsics.checkNotNullParameter(adFetchRequestError, "adFetchRequestError");
        cs csVar = this.d;
        if (csVar != null) {
            csVar.a(adFetchRequestError);
        }
    }

    @Override // com.yandex.mobile.ads.impl.ah0
    public final void a(boolean z) {
    }

    @Override // com.yandex.mobile.ads.impl.ah0
    public final void a(uf1 webView, Map trackingParameters) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(trackingParameters, "trackingParameters");
        m62 m62Var = this.e;
        if (m62Var != null) {
            m62Var.a(trackingParameters);
        }
        cs csVar = this.d;
        if (csVar != null) {
            csVar.a();
        }
    }

    @Override // com.yandex.mobile.ads.impl.ah0
    public final void a(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.b.a(url, this.f8786a, this.c);
    }

    public final void a(cs csVar) {
        this.d = csVar;
    }

    public final void a(xc0 xc0Var) {
        this.e = xc0Var;
    }
}
