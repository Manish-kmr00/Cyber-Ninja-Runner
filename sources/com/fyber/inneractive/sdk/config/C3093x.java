package com.fyber.inneractive.sdk.config;

import com.fyber.inneractive.sdk.network.C3130f;
import com.fyber.inneractive.sdk.network.RunnableC3127c;
import com.fyber.inneractive.sdk.util.e0;

/* JADX INFO: renamed from: com.fyber.inneractive.sdk.config.x, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes13.dex */
public final class C3093x implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IAConfigManager f1730a;

    public C3093x(IAConfigManager iAConfigManager) {
        this.f1730a = iAConfigManager;
    }

    @Override // com.fyber.inneractive.sdk.config.r
    public final void onGlobalConfigChanged(C3088s c3088s, C3085o c3085o) {
        if (c3085o.a("dv_enabled_v2", 0, 0) == 1) {
            this.f1730a.G.a();
        }
        C3130f c3130f = this.f1730a.I;
        c3130f.getClass();
        int iA = IAConfigManager.O.u.b.a("send_events_batch_interval", 30, -1);
        int i = iA >= 0 ? iA : 30;
        String property = System.getProperty("fyber.marketplace.use_batch_interval");
        int i2 = (property == null || Boolean.getBoolean(property)) ? i : 0;
        c3130f.f = true;
        c3130f.e = i2;
        e0 e0Var = c3130f.d;
        if (e0Var != null && e0Var.hasMessages(12312329)) {
            c3130f.d.removeMessages(12312329);
        }
        long j = c3130f.e * 1000;
        e0 e0Var2 = c3130f.d;
        if (e0Var2 != null) {
            e0Var2.post(new RunnableC3127c(c3130f, 12312329, j));
        }
    }
}
