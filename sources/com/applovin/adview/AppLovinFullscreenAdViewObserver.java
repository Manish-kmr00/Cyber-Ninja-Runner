package com.applovin.adview;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.applovin.impl.m2;
import com.applovin.impl.v1;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes13.dex */
public class AppLovinFullscreenAdViewObserver implements LifecycleObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Lifecycle f314a;
    private m2 b;
    private final AtomicBoolean c = new AtomicBoolean(true);
    private v1 d;

    public AppLovinFullscreenAdViewObserver(Lifecycle lifecycle, m2 m2Var) {
        this.f314a = lifecycle;
        this.b = m2Var;
        lifecycle.addObserver(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        this.f314a.removeObserver(this);
        m2 m2Var = this.b;
        if (m2Var != null) {
            m2Var.a();
            this.b = null;
        }
        v1 v1Var = this.d;
        if (v1Var != null) {
            v1Var.a("lifecycle_on_destroy");
            this.d.q();
            this.d = null;
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause() {
        v1 v1Var = this.d;
        if (v1Var != null) {
            v1Var.r();
            this.d.u();
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume() {
        v1 v1Var;
        if (this.c.getAndSet(false) || (v1Var = this.d) == null) {
            return;
        }
        v1Var.s();
        this.d.b(0L);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStop() {
        v1 v1Var = this.d;
        if (v1Var != null) {
            v1Var.t();
        }
    }

    public void setPresenter(v1 v1Var) {
        this.d = v1Var;
    }
}
