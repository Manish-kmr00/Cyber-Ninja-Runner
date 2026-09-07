package com.applovin.impl;

import android.os.Bundle;
import android.os.SystemClock;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public class z2 extends v2 implements s1 {
    private String A;
    private final Bundle u;
    private final AtomicReference v;
    private final AtomicBoolean w;
    private final AtomicBoolean x;
    private final AtomicBoolean y;
    private boolean z;

    public z2(x2 x2Var, JSONObject jSONObject, JSONObject jSONObject2, com.applovin.impl.sdk.k kVar) {
        super(x2Var, jSONObject, jSONObject2, null, kVar);
        this.u = new Bundle();
        this.x = new AtomicBoolean();
        this.y = new AtomicBoolean();
        this.v = new AtomicReference();
        this.w = new AtomicBoolean();
    }

    private long e0() {
        long jA = a("ad_expiration_ms", -1L);
        return jA < 0 ? b("ad_expiration_ms", ((Long) this.f436a.a(o3.I7)).longValue()) : jA;
    }

    @Override // com.applovin.impl.v2
    public v2 a(com.applovin.impl.mediation.h hVar) {
        return new z2(this, hVar);
    }

    public void d0() {
        this.w.set(true);
    }

    public long f0() {
        return a("ahdm", ((Long) this.f436a.a(o3.C7)).longValue());
    }

    public long g0() {
        long jA = a("ad_hidden_on_ad_dismiss_callback_delay_ms", -1L);
        return jA >= 0 ? jA : b("ad_hidden_on_ad_dismiss_callback_delay_ms", ((Long) this.f436a.a(o3.Q7)).longValue());
    }

    @Override // com.applovin.impl.s1
    public long getTimeToLiveMillis() {
        return e0() - (SystemClock.elapsedRealtime() - H());
    }

    public long h0() {
        long jA = a("ad_hidden_timeout_ms", -1L);
        return jA >= 0 ? jA : b("ad_hidden_timeout_ms", ((Long) this.f436a.a(o3.N7)).longValue());
    }

    public l4 i0() {
        return (l4) this.v.getAndSet(null);
    }

    public void j(String str) {
        this.A = str;
    }

    public long j0() {
        if (H() > 0) {
            return SystemClock.elapsedRealtime() - H();
        }
        return -1L;
    }

    public Bundle k0() {
        return this.u;
    }

    public long l0() {
        long jA = a("fullscreen_display_delay_ms", -1L);
        return jA >= 0 ? jA : ((Long) this.f436a.a(o3.A7)).longValue();
    }

    public String m0() {
        return b("mcode", "");
    }

    public AtomicBoolean n0() {
        return this.x;
    }

    public String o0() {
        return this.A;
    }

    public AtomicBoolean p0() {
        return this.y;
    }

    public boolean q0() {
        return this.w.get();
    }

    public boolean r0() {
        if (a("schedule_ad_hidden_on_ad_dismiss", Boolean.FALSE).booleanValue()) {
            return true;
        }
        return b("schedule_ad_hidden_on_ad_dismiss", (Boolean) this.f436a.a(o3.O7)).booleanValue();
    }

    public boolean s0() {
        if (a("schedule_ad_hidden_on_single_task_app_relaunch", Boolean.FALSE).booleanValue()) {
            return true;
        }
        return b("schedule_ad_hidden_on_single_task_app_relaunch", (Boolean) this.f436a.a(o3.P7)).booleanValue();
    }

    @Override // com.applovin.impl.s1
    public void setExpired() {
        this.z = true;
    }

    public boolean t0() {
        return a("susaode", (Boolean) this.f436a.a(o3.B7)).booleanValue();
    }

    @Override // com.applovin.impl.v2
    public void a(Bundle bundle) {
        Bundle bundle2;
        super.a(bundle);
        if (bundle == null || (bundle2 = bundle.getBundle("applovin_ad_view_info")) == null) {
            return;
        }
        this.u.putBundle("applovin_ad_view_info", bundle2);
    }

    public void a(l4 l4Var) {
        this.v.set(l4Var);
    }

    private z2(z2 z2Var, com.applovin.impl.mediation.h hVar) {
        super(z2Var.M(), z2Var.a(), z2Var.g(), hVar, z2Var.f436a);
        this.u = new Bundle();
        this.x = new AtomicBoolean();
        this.y = new AtomicBoolean();
        this.v = z2Var.v;
        this.w = z2Var.w;
    }
}
