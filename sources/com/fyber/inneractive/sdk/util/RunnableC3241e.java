package com.fyber.inneractive.sdk.util;

import android.os.Handler;
import android.text.TextUtils;
import com.fyber.inneractive.sdk.external.InneractiveErrorCode;
import com.fyber.inneractive.sdk.external.InneractiveInfrastructureError;
import com.fyber.inneractive.sdk.flow.EnumC3104i;
import com.fyber.inneractive.sdk.web.AbstractC3270i;
import com.fyber.inneractive.sdk.web.C3266e;
import com.fyber.inneractive.sdk.web.C3274m;
import com.fyber.inneractive.sdk.web.InterfaceC3268g;
import com.json.cc;
import com.pubmatic.sdk.common.POBCommonConstants;
import com.safedk.android.internal.partials.DTExchangeNetworkBridge;

/* JADX INFO: renamed from: com.fyber.inneractive.sdk.util.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes13.dex */
public final class RunnableC3241e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object f2360a;
    public final /* synthetic */ C3266e b;

    public RunnableC3241e(C3266e c3266e, String str) {
        this.b = c3266e;
        this.f2360a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C3266e c3266e = this.b;
        Object obj = this.f2360a;
        c3266e.getClass();
        String str = (String) obj;
        String str2 = AbstractC3255t.a() ? com.safedk.android.analytics.brandsafety.creatives.discoveries.d.v : "https://";
        if (!TextUtils.isEmpty(str) && !c3266e.f2406a.isTerminated() && !c3266e.f2406a.isShutdown()) {
            if (TextUtils.isEmpty(c3266e.k)) {
                c3266e.l.p = str2.concat("wv.inner-active.mobi/");
            } else {
                c3266e.l.p = str2 + c3266e.k;
            }
            if (c3266e.f) {
                return;
            }
            AbstractC3270i abstractC3270i = c3266e.l;
            C3274m c3274m = abstractC3270i.b;
            if (c3274m != null) {
                DTExchangeNetworkBridge.webviewLoadDataWithBaseURL(c3274m, abstractC3270i.p, str, POBCommonConstants.CONTENT_TYPE_HTML, cc.N, null);
                c3266e.l.q = str;
            } else {
                InneractiveInfrastructureError inneractiveInfrastructureError = new InneractiveInfrastructureError(InneractiveErrorCode.SDK_INTERNAL_ERROR, EnumC3104i.COULD_NOT_LOAD_TO_WEBVIEW);
                InterfaceC3268g interfaceC3268g = abstractC3270i.f;
                if (interfaceC3268g != null) {
                    interfaceC3268g.a(inneractiveInfrastructureError);
                }
                abstractC3270i.b(true);
            }
        } else if (!c3266e.f2406a.isTerminated() && !c3266e.f2406a.isShutdown()) {
            AbstractC3270i abstractC3270i2 = c3266e.l;
            InneractiveInfrastructureError inneractiveInfrastructureError2 = new InneractiveInfrastructureError(InneractiveErrorCode.SDK_INTERNAL_ERROR, EnumC3104i.EMPTY_FINAL_HTML);
            InterfaceC3268g interfaceC3268g2 = abstractC3270i2.f;
            if (interfaceC3268g2 != null) {
                interfaceC3268g2.a(inneractiveInfrastructureError2);
            }
            abstractC3270i2.b(true);
        }
        c3266e.f = true;
        c3266e.f2406a.shutdownNow();
        Handler handler = c3266e.b;
        if (handler != null) {
            RunnableC3240d runnableC3240d = c3266e.d;
            if (runnableC3240d != null) {
                handler.removeCallbacks(runnableC3240d);
            }
            RunnableC3241e runnableC3241e = c3266e.c;
            if (runnableC3241e != null) {
                c3266e.b.removeCallbacks(runnableC3241e);
            }
            c3266e.b = null;
        }
        c3266e.l.o = null;
    }
}
