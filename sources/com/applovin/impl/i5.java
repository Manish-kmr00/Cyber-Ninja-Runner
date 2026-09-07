package com.applovin.impl;

import android.app.Activity;
import android.text.TextUtils;
import com.amazon.aps.shared.util.APSSharedUtil;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class i5 extends g5 {
    private final List g;
    private final Activity h;

    public i5(List list, Activity activity, com.applovin.impl.sdk.k kVar) {
        super("TaskAutoInitAdapters", kVar, true);
        this.g = list;
        this.h = activity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(h3 h3Var) {
        if (com.applovin.impl.sdk.o.a()) {
            this.c.a(this.b, "Auto-initing adapter: " + h3Var);
        }
        this.f424a.S().a(h3Var, this.h);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.g.size() > 0) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.a(this.b, "Auto-initing " + this.g.size() + " adapters" + (this.f424a.t0().c() ? " in test mode" : "") + APSSharedUtil.TRUNCATE_SEPARATOR);
            }
            if (TextUtils.isEmpty(this.f424a.V())) {
                this.f424a.Q0();
            } else if (!this.f424a.H0()) {
                com.applovin.impl.sdk.o.h("AppLovinSdk", "Auto-initing adapters for non-MAX mediation provider: " + this.f424a.V());
            }
            if (this.h == null) {
                com.applovin.impl.sdk.o.h("AppLovinSdk", "\n**********\nAttempting to init 3rd-party SDKs without an Activity instance.\n**********\n");
            }
            for (final h3 h3Var : this.g) {
                if (h3Var.s()) {
                    this.f424a.r0().a(new Runnable() { // from class: com.applovin.impl.i5$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.a(h3Var);
                        }
                    }, b6.b.MEDIATION);
                } else {
                    this.f424a.O();
                    if (com.applovin.impl.sdk.o.a()) {
                        this.f424a.O().a(this.b, "Skipping eager auto-init for adapter " + h3Var);
                    }
                }
            }
        }
    }
}
