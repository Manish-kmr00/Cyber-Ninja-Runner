package com.bytedance.sdk.openadsdk.core;

import android.app.Application;
import android.content.Context;
import com.bytedance.sdk.openadsdk.ApmHelper;

/* JADX INFO: loaded from: classes2.dex */
public class DX {
    private boolean Og;
    private final com.bytedance.sdk.openadsdk.utils.pA pA = new com.bytedance.sdk.openadsdk.utils.pA();

    public static DX pA() {
        return pA.pA;
    }

    private static class pA {
        private static final DX pA = new DX();
    }

    public void Og() {
        try {
            Context contextPA = aBv.pA();
            if (contextPA instanceof Application) {
                ((Application) contextPA).registerActivityLifecycleCallbacks(this.pA);
                this.Og = true;
            } else {
                if (contextPA == null || contextPA.getApplicationContext() == null) {
                    return;
                }
                ((Application) contextPA.getApplicationContext()).registerActivityLifecycleCallbacks(this.pA);
                this.Og = true;
            }
        } catch (Throwable th) {
            ApmHelper.reportCustomError("registerActivityLifecycleError", "registerActivityLifecycle", th);
        }
    }

    public boolean KZx() {
        return this.Og;
    }

    public boolean ZZv() {
        return this.pA.pA();
    }

    public boolean pA(boolean z) {
        return this.pA.pA(z);
    }

    public com.bytedance.sdk.openadsdk.utils.pA ML() {
        return this.pA;
    }
}
