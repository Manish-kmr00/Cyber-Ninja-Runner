package com.fyber.inneractive.sdk.web;

import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.digitalturbine.ignite.cl.aidl.IIgniteServiceAPI;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.flow.C3116v;
import com.fyber.inneractive.sdk.network.EnumC3143t;
import com.fyber.inneractive.sdk.util.AbstractC3251o;
import com.fyber.inneractive.sdk.util.IAlog;
import com.safedk.android.internal.partials.DTExchangeNetworkBridge;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes13.dex */
public final class W implements com.fyber.inneractive.sdk.ignite.r {
    public boolean B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WebView f2397a;
    public final com.fyber.inneractive.sdk.ignite.h b;
    public final String c;
    public com.fyber.inneractive.sdk.ignite.m d;
    public final String e;
    public final String f;
    public final String g;
    public final C3116v h;
    public U i;
    public String k;
    public final com.fyber.inneractive.sdk.config.global.r m;
    public long o;
    public N p;
    public WeakReference q;
    public String j = "invalid_task_id";
    public boolean l = false;
    public long n = 10;
    public boolean r = false;
    public boolean s = false;
    public final AtomicInteger t = new AtomicInteger(0);
    public final AtomicBoolean u = new AtomicBoolean(false);
    public final AtomicBoolean v = new AtomicBoolean(false);
    public boolean w = false;
    public boolean x = false;
    public boolean y = false;
    public boolean z = false;
    public boolean A = false;
    public boolean C = false;
    public boolean D = false;
    public final M E = new M(this);

    public W(X x) {
        this.c = x.f2398a;
        this.d = x.b;
        this.e = x.c;
        this.m = x.d;
        this.f = x.e;
        this.g = x.f;
        this.h = x.g;
        com.fyber.inneractive.sdk.ignite.h hVar = IAConfigManager.O.E;
        this.b = hVar;
        hVar.h.add(this);
        this.f2397a = new WebView(AbstractC3251o.f2370a);
    }

    @Override // com.fyber.inneractive.sdk.ignite.r
    public final void a(String str, String str2) {
        if (str == null || str2 == null || !str2.equals(this.c)) {
            return;
        }
        this.j = str;
    }

    @Override // com.fyber.inneractive.sdk.ignite.r
    public final void b(String str) {
        this.z = false;
        this.A = true;
        if (this.j.equals(str)) {
            this.b.m();
            d("onInstallationSuccess();");
        }
    }

    @Override // com.fyber.inneractive.sdk.ignite.r
    public final void c(String str) {
        C3116v c3116v;
        IIgniteServiceAPI iIgniteServiceAPI;
        if (this.v.get() && str != null) {
            if (str.equals(com.fyber.inneractive.sdk.ignite.j.NOT_CONNECTED.a()) || str.equals(com.fyber.inneractive.sdk.ignite.j.SESSION_EXPIRED.a())) {
                if (this.t.getAndIncrement() < 2) {
                    this.b.a(new Q(this));
                    return;
                }
                com.fyber.inneractive.sdk.ignite.h hVar = this.b;
                com.fyber.inneractive.sdk.ignite.l lVar = hVar.p;
                if (lVar == null || !lVar.isConnected() || (iIgniteServiceAPI = hVar.b) == null || !iIgniteServiceAPI.asBinder().isBinderAlive()) {
                    com.fyber.inneractive.sdk.ignite.j jVar = com.fyber.inneractive.sdk.ignite.j.FAILED_TO_BIND_SERVICE;
                    com.fyber.inneractive.sdk.ignite.h hVar2 = this.b;
                    if (hVar2.i || (c3116v = this.h) == null) {
                        return;
                    }
                    hVar2.i = true;
                    c3116v.a(EnumC3143t.IGNITE_FLOW_FAILED_TO_START, null, jVar.a(), null);
                }
            }
        }
    }

    public final void d(String str) {
        com.fyber.inneractive.sdk.util.r.b.post(new O(this, str));
    }

    public final void e(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.k = str;
        WebSettings settings = this.f2397a.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setUseWideViewPort(true);
        this.f2397a.setInitialScale(1);
        this.f2397a.setBackgroundColor(-1);
        this.f2397a.setWebViewClient(this.E);
        WebView webView = this.f2397a;
        webView.setLongClickable(false);
        webView.setOnLongClickListener(new com.fyber.inneractive.sdk.util.P());
        DTExchangeNetworkBridge.onAddedJavascriptInterface(this.f2397a, new V(this), "nativeInterface");
        DTExchangeNetworkBridge.webviewLoadUrl(this.f2397a, str);
        com.fyber.inneractive.sdk.config.global.r rVar = this.m;
        if (rVar != null) {
            TimeUnit timeUnit = TimeUnit.SECONDS;
            Integer numA = ((com.fyber.inneractive.sdk.config.global.features.r) rVar.a(com.fyber.inneractive.sdk.config.global.features.r.class)).a("load_timeout");
            int i = 10;
            int iIntValue = numA != null ? numA.intValue() : 10;
            if (iIntValue < 30 && iIntValue > 2) {
                i = iIntValue;
            }
            long millis = timeUnit.toMillis(i);
            this.n = millis;
            IAlog.a("InternalStoreWebpageController: Starting load timeout with %d", Long.valueOf(millis));
        }
        this.o = System.currentTimeMillis();
        N n = new N(this);
        this.p = n;
        com.fyber.inneractive.sdk.util.r.b.postDelayed(n, this.n);
    }

    @Override // com.fyber.inneractive.sdk.ignite.r
    public final void a(String str) {
        this.z = true;
        if (this.j.equals(str)) {
            this.b.m();
            d("onInstallStart();");
        }
    }

    @Override // com.fyber.inneractive.sdk.ignite.r
    public final void a(String str, int i, double d) {
        if (this.j.equals(str)) {
            if (i == 0) {
                d(String.format("onDownloadProgress(%f);", Double.valueOf(d)));
            } else {
                if (i != 1) {
                    return;
                }
                d("onInstallationProgress();");
            }
        }
    }

    @Override // com.fyber.inneractive.sdk.ignite.r
    public final void a(String str, String str2, String str3) {
        C3116v c3116v;
        IIgniteServiceAPI iIgniteServiceAPI;
        if (this.D) {
            this.z = false;
            if (this.j.equals(str)) {
                this.b.m();
                if (!this.v.get() && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str2) && str2.equals("App already installed")) {
                    d("onInstallationSuccess();");
                    this.A = true;
                    return;
                }
            }
            if ((str2 != null && (str2.equals(com.fyber.inneractive.sdk.ignite.j.NOT_CONNECTED.a()) || str2.equals(com.fyber.inneractive.sdk.ignite.j.SESSION_EXPIRED.a()))) || !this.b.n()) {
                if (this.t.getAndIncrement() < 2) {
                    this.b.a(new P(this, str2, str3));
                    return;
                }
                this.b.m();
                d("onInstallationFailed();");
                com.fyber.inneractive.sdk.ignite.h hVar = this.b;
                com.fyber.inneractive.sdk.ignite.l lVar = hVar.p;
                if (lVar == null || !lVar.isConnected() || (iIgniteServiceAPI = hVar.b) == null || !iIgniteServiceAPI.asBinder().isBinderAlive()) {
                    com.fyber.inneractive.sdk.ignite.j jVar = com.fyber.inneractive.sdk.ignite.j.FAILED_TO_BIND_SERVICE;
                    com.fyber.inneractive.sdk.ignite.h hVar2 = this.b;
                    if (!hVar2.i && (c3116v = this.h) != null) {
                        hVar2.i = true;
                        c3116v.a(EnumC3143t.IGNITE_FLOW_FAILED_TO_START, null, jVar.a(), null);
                    }
                }
            } else if (!TextUtils.equals(str2, com.fyber.inneractive.sdk.ignite.j.DOWNLOAD_IS_CANCELLED.a())) {
                this.b.m();
                d("onInstallationFailed();");
            }
            com.fyber.inneractive.sdk.ignite.m mVar = this.d;
            if (mVar != null) {
                this.h.a(EnumC3143t.IGNITE_FLOW_FAILED_TO_INSTALL_APP, str2, str3, mVar);
            }
        }
    }
}
