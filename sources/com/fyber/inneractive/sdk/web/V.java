package com.fyber.inneractive.sdk.web;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.digitalturbine.ignite.cl.aidl.IIgniteServiceAPI;
import com.fyber.inneractive.sdk.activities.InternalStoreWebpageActivity;
import com.fyber.inneractive.sdk.flow.C3116v;
import com.fyber.inneractive.sdk.network.AbstractC3149z;
import com.fyber.inneractive.sdk.network.EnumC3144u;
import com.fyber.inneractive.sdk.util.AbstractC3251o;
import com.fyber.inneractive.sdk.util.IAlog;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.utils.Logger;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes13.dex */
public final class V {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ W f2396a;

    public V(W w) {
        this.f2396a = w;
    }

    public static void safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(Context p0, Intent p1) {
        Logger.d("SafeDK-Special|SafeDK: Call> Landroid/content/Context;->startActivity(Landroid/content/Intent;)V");
        if (p1 == null) {
            return;
        }
        BrandSafetyUtils.detectAdClick(p1, com.safedk.android.utils.h.p);
        p0.startActivity(p1);
    }

    @JavascriptInterface
    public void onBackButtonPressed() {
        WeakReference weakReference = this.f2396a.q;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        ((InternalStoreWebpageActivity) this.f2396a.q.get()).finish();
    }

    @JavascriptInterface
    public void onCancelButtonPressed() {
        com.fyber.inneractive.sdk.ignite.m mVar;
        com.fyber.inneractive.sdk.ignite.m mVar2;
        W w = this.f2396a;
        w.d = w.B ? com.fyber.inneractive.sdk.ignite.m.TRUE_SINGLE_TAP : com.fyber.inneractive.sdk.ignite.m.SINGLE_TAP;
        String str = w.j;
        if (str != null) {
            w.v.set(true);
            w.u.set(false);
            com.fyber.inneractive.sdk.ignite.h hVar = w.b;
            S s = new S(w);
            if (!hVar.n() || hVar.o()) {
                for (com.fyber.inneractive.sdk.ignite.r rVar : hVar.h) {
                    if (rVar != null) {
                        rVar.c((hVar.o() ? com.fyber.inneractive.sdk.ignite.j.SESSION_EXPIRED : com.fyber.inneractive.sdk.ignite.j.NOT_CONNECTED).a());
                    }
                }
            } else {
                try {
                    IIgniteServiceAPI iIgniteServiceAPI = hVar.b;
                    Bundle bundle = hVar.c;
                    hVar.d.getClass();
                    iIgniteServiceAPI.cancel(str, bundle, new com.fyber.inneractive.sdk.ignite.a(s));
                } catch (Exception unused) {
                    IAlog.a("Failed to cancel task", new Object[0]);
                    s.a(false);
                }
            }
            com.fyber.inneractive.sdk.util.r.b.postDelayed(new T(w), 2500L);
            C3116v c3116v = w.h;
            if (c3116v != null && !w.r && (mVar2 = w.d) != null) {
                w.r = true;
                c3116v.a(EnumC3144u.IGNITE_FLOW_CANCEL_INSTALL_CLICKED, mVar2);
            }
        }
        W w2 = this.f2396a;
        C3116v c3116v2 = w2.h;
        if (c3116v2 == null || w2.r || (mVar = w2.d) == null) {
            return;
        }
        w2.r = true;
        c3116v2.a(EnumC3144u.IGNITE_FLOW_CANCEL_INSTALL_CLICKED, mVar);
    }

    @JavascriptInterface
    public void onInstallButtonPressed() {
        com.fyber.inneractive.sdk.ignite.m mVar;
        W w = this.f2396a;
        com.fyber.inneractive.sdk.ignite.m mVar2 = w.B ? com.fyber.inneractive.sdk.ignite.m.TRUE_SINGLE_TAP : com.fyber.inneractive.sdk.ignite.m.SINGLE_TAP;
        w.d = mVar2;
        w.b.a(w.c, new com.fyber.inneractive.sdk.ignite.g(w.f, mVar2, w.h.f1833a));
        W w2 = this.f2396a;
        C3116v c3116v = w2.h;
        if (c3116v == null || w2.s || (mVar = w2.d) == null) {
            return;
        }
        w2.s = true;
        c3116v.a(EnumC3144u.IGNITE_FLOW_INSTALL_CLICKED, mVar);
    }

    @JavascriptInterface
    public void onNavigatedInsideStorePage() {
        this.f2396a.w = true;
    }

    @JavascriptInterface
    public void onNavigatedToMainPage() {
        this.f2396a.w = false;
    }

    @JavascriptInterface
    public void onOpenButtonPressed() {
        Intent launchIntentForPackage;
        if (TextUtils.isEmpty(this.f2396a.c)) {
            W w = this.f2396a;
            w.getClass();
            IAlog.f("%smPackageName is null", IAlog.a(w));
            return;
        }
        if (TextUtils.isEmpty(this.f2396a.g)) {
            launchIntentForPackage = AbstractC3251o.f2370a.getPackageManager().getLaunchIntentForPackage(this.f2396a.c);
        } else {
            launchIntentForPackage = new Intent("android.intent.action.MAIN");
            W w2 = this.f2396a;
            launchIntentForPackage.setClassName(w2.c, w2.g);
        }
        if (launchIntentForPackage == null) {
            W w3 = this.f2396a;
            w3.getClass();
            IAlog.f("%sPackage %s not found", IAlog.a(w3), this.f2396a.c);
            return;
        }
        launchIntentForPackage.setFlags(268435456);
        try {
            safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(AbstractC3251o.f2370a, launchIntentForPackage);
        } catch (Exception e) {
            C3116v c3116v = this.f2396a.h;
            if (c3116v != null) {
                String simpleName = e.getClass().getSimpleName();
                String message = e.getMessage();
                com.fyber.inneractive.sdk.flow.w wVar = c3116v.f1833a;
                AbstractC3149z.a(simpleName, message, wVar.f1840a, wVar.b);
            }
        }
    }

    @JavascriptInterface
    public void onTransitionEnded() {
        this.f2396a.x = false;
    }

    @JavascriptInterface
    public void onTransitionStarting() {
        this.f2396a.x = true;
    }
}
