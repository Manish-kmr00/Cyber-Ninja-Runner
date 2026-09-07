package com.fyber.inneractive.sdk;

import android.app.Activity;
import com.fyber.inneractive.sdk.config.U;
import com.fyber.inneractive.sdk.config.global.r;
import com.fyber.inneractive.sdk.dv.i;
import com.fyber.inneractive.sdk.network.C3146w;
import com.fyber.inneractive.sdk.network.EnumC3144u;

/* JADX INFO: loaded from: classes11.dex */
public abstract class a extends com.fyber.inneractive.sdk.dv.a {
    public com.fyber.inneractive.sdk.dv.interstitial.a j;

    public a(U u, r rVar, i iVar) {
        super(u, rVar, iVar);
        this.j = null;
    }

    public abstract void a(com.fyber.inneractive.sdk.dv.interstitial.a aVar, Activity activity);

    public final void h() {
        try {
            new C3146w(EnumC3144u.EVENT_READY_ON_CLIENT, this.f1840a, (i) this.b).a((String) null);
        } catch (Exception unused) {
        }
    }
}
