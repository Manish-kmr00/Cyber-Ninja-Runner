package com.fyber.inneractive.sdk.config;

import android.content.Context;
import android.text.TextUtils;
import com.fyber.inneractive.sdk.external.InneractiveAdManager;
import com.fyber.inneractive.sdk.util.IAlog;

/* JADX INFO: loaded from: classes13.dex */
public final class N implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f1677a;
    public final /* synthetic */ C3092w b;

    public N(Context context, C3092w c3092w) {
        this.f1677a = context;
        this.b = c3092w;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (InneractiveAdManager.isCurrentUserAChild()) {
            return;
        }
        try {
            Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient");
            O.a(this.f1677a, this.b);
            C3091v c3091v = AbstractC3090u.f1727a.b;
            if (TextUtils.isEmpty(c3091v != null ? c3091v.f1728a : null)) {
                AbstractC3084n.a(this.f1677a, this.b);
            }
        } catch (Throwable th) {
            IAlog.b("SDK internal error: Make sure that Google Play Services for Mobile Ads is added to the compile dependencies of your project" + th.toString(), new Object[0]);
        }
    }
}
