package com.applovin.impl.mediation;

import android.app.Activity;
import android.os.Bundle;
import com.amazon.aps.shared.util.APSSharedUtil;
import com.applovin.impl.k7;
import com.applovin.impl.sdk.k;
import com.applovin.impl.sdk.o;
import com.applovin.impl.z2;

/* JADX INFO: loaded from: classes5.dex */
public class a extends com.applovin.impl.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.c f523a;
    private final o b;
    private final String c;
    private InterfaceC0134a d;
    private z2 e;
    private String f;

    /* JADX INFO: renamed from: com.applovin.impl.mediation.a$a, reason: collision with other inner class name */
    public interface InterfaceC0134a {
        void b(z2 z2Var);
    }

    a(k kVar) {
        this.b = kVar.O();
        this.f523a = kVar.e();
        this.c = k7.a(k.o(), "AdActivityObserver", kVar);
    }

    public void a(z2 z2Var, InterfaceC0134a interfaceC0134a) {
        if (o.a()) {
            this.b.a("AdActivityObserver", "Starting for ad " + z2Var.getAdUnitId() + APSSharedUtil.TRUNCATE_SEPARATOR);
        }
        a();
        this.d = interfaceC0134a;
        this.e = z2Var;
        this.f523a.a(this);
    }

    @Override // com.applovin.impl.b, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        if (!activity.getClass().getName().equals(this.c) || !this.e.s0()) {
            if (this.f == null) {
                this.f = activity.getClass().getName();
                if (o.a()) {
                    this.b.a("AdActivityObserver", "Started tracking ad Activity: " + this.f);
                    return;
                }
                return;
            }
            return;
        }
        if (o.a()) {
            this.b.a("AdActivityObserver", "App relaunched via launcher without an ad hidden callback, manually invoking ad hidden");
        }
        if (this.d != null) {
            if (o.a()) {
                this.b.a("AdActivityObserver", "Invoking callback...");
            }
            this.d.b(this.e);
        }
        a();
    }

    @Override // com.applovin.impl.b, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        if (activity.getClass().getName().equals(this.f)) {
            if (o.a()) {
                this.b.a("AdActivityObserver", "Ad Activity destroyed: " + this.f);
            }
            if (this.d != null) {
                if (o.a()) {
                    this.b.a("AdActivityObserver", "Invoking callback...");
                }
                this.d.b(this.e);
            }
            a();
        }
    }

    public void a() {
        if (o.a()) {
            this.b.a("AdActivityObserver", "Cancelling...");
        }
        this.f523a.b(this);
        this.d = null;
        this.e = null;
        this.f = null;
    }
}
