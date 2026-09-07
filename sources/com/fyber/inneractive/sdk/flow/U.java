package com.fyber.inneractive.sdk.flow;

import com.fyber.inneractive.sdk.config.IAConfigManager;

/* JADX INFO: loaded from: classes10.dex */
public abstract class U {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f1782a = true;
    public String b;

    public boolean getAllowFullscreen() {
        return this.f1782a;
    }

    public String getMediationName() {
        return IAConfigManager.O.l;
    }

    public String getMediationVersion() {
        return IAConfigManager.O.n;
    }
}
