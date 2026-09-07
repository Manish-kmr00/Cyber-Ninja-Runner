package com.applovin.impl;

import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinAdLoadListener;

/* JADX INFO: loaded from: classes2.dex */
class n6 extends g5 {
    private final p7 g;
    private final AppLovinAdLoadListener h;

    n6(p7 p7Var, AppLovinAdLoadListener appLovinAdLoadListener, com.applovin.impl.sdk.k kVar) {
        super("TaskResolveVastWrapper", kVar);
        this.h = appLovinAdLoadListener;
        this.g = p7Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        String strA = x7.a(this.g);
        if (!StringUtils.isValidString(strA)) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.b(this.b, "Resolving VAST failed. Could not find resolution URL");
            }
            a(-1);
            return;
        }
        if (com.applovin.impl.sdk.o.a()) {
            this.c.a(this.b, "Resolving VAST ad with depth " + this.g.d() + " at " + strA);
        }
        try {
            this.f424a.r0().a(new a(com.applovin.impl.sdk.network.a.a(this.f424a).b(strA).c("GET").a(m8.f).a(((Integer) this.f424a.a(v4.K4)).intValue()).c(((Integer) this.f424a.a(v4.L4)).intValue()).a(false).a(), this.f424a));
        } catch (Throwable th) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.a(this.b, "Unable to resolve VAST wrapper", th);
            }
            a(-1);
        }
    }

    class a extends j6 {
        a(com.applovin.impl.sdk.network.a aVar, com.applovin.impl.sdk.k kVar) {
            super(aVar, kVar);
        }

        @Override // com.applovin.impl.j6, com.applovin.impl.q0.e
        public void a(String str, m8 m8Var, int i) {
            this.f424a.r0().a(f6.a(m8Var, n6.this.g, n6.this.h, n6.this.f424a));
        }

        @Override // com.applovin.impl.j6, com.applovin.impl.q0.e
        public void a(String str, int i, String str2, m8 m8Var) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.b(this.b, "Unable to resolve VAST wrapper. Server returned " + i);
            }
            n6.this.a(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        if (com.applovin.impl.sdk.o.a()) {
            this.c.b(this.b, "Failed to resolve VAST wrapper due to error code " + i);
        }
        if (i == -1009) {
            AppLovinAdLoadListener appLovinAdLoadListener = this.h;
            if (appLovinAdLoadListener != null) {
                appLovinAdLoadListener.failedToReceiveAd(i);
                return;
            }
            return;
        }
        x7.a(this.g, this.h, i == -1001 ? q7.TIMED_OUT : q7.GENERAL_WRAPPER_ERROR, i, this.f424a);
    }
}
