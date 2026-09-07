package com.fyber.inneractive.sdk.flow;

import android.os.Handler;
import android.os.HandlerThread;
import com.fyber.inneractive.sdk.config.AbstractC3071a;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveErrorCode;
import com.fyber.inneractive.sdk.external.InneractiveInfrastructureError;
import com.fyber.inneractive.sdk.network.AbstractC3149z;
import com.fyber.inneractive.sdk.util.IAlog;
import java.util.Locale;

/* JADX INFO: renamed from: com.fyber.inneractive.sdk.flow.k, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public abstract class AbstractC3106k implements com.fyber.inneractive.sdk.interfaces.c, com.fyber.inneractive.sdk.interfaces.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public InneractiveAdRequest f1803a;
    public com.fyber.inneractive.sdk.response.e b;
    public x c;
    public com.fyber.inneractive.sdk.interfaces.a d;
    public com.fyber.inneractive.sdk.interfaces.b e;
    public com.fyber.inneractive.sdk.config.T f;
    public com.fyber.inneractive.sdk.config.global.r g;
    public com.fyber.inneractive.sdk.network.timeouts.content.a j;
    public boolean h = false;
    public int i = 0;
    public final RunnableC3105j l = new RunnableC3105j(this);
    public C3099d k = new C3099d(this);

    public final void a(InneractiveAdRequest inneractiveAdRequest, com.fyber.inneractive.sdk.response.e eVar, com.fyber.inneractive.sdk.config.global.r rVar, com.fyber.inneractive.sdk.interfaces.a aVar, com.fyber.inneractive.sdk.interfaces.b bVar) {
        this.f1803a = inneractiveAdRequest;
        this.b = eVar;
        this.d = aVar;
        this.e = bVar;
        this.k = new C3099d(this);
        this.g = rVar;
        UnitDisplayType unitDisplayType = eVar.p;
        this.j = new com.fyber.inneractive.sdk.network.timeouts.content.a((unitDisplayType == UnitDisplayType.INTERSTITIAL || unitDisplayType == UnitDisplayType.REWARDED) ? unitDisplayType.name().toLowerCase(Locale.US) : UnitDisplayType.BANNER.name().toLowerCase(Locale.US), com.fyber.inneractive.sdk.response.a.a(eVar.g) == com.fyber.inneractive.sdk.response.a.RETURNED_ADTYPE_VAST ? "video" : "display", (int) eVar.K, eVar.D, IAConfigManager.O.l, this.g);
        if (this.f1803a == null) {
            this.f = AbstractC3071a.a(eVar.o);
        }
        try {
            h();
        } catch (Throwable th) {
            IAlog.f("Failed to start ContentLoader", IAlog.a(this));
            AbstractC3149z.a(th, inneractiveAdRequest, eVar);
            this.k.a();
            a(new InneractiveInfrastructureError(InneractiveErrorCode.SDK_INTERNAL_ERROR, EnumC3104i.CONTENT_LOADER_START_FAILED));
        }
    }

    public final void b(InneractiveInfrastructureError inneractiveInfrastructureError) {
        com.fyber.inneractive.sdk.util.r.f2374a.execute(new RunnableC3100e(new C3101f(this.b, this.f1803a, d(), this.g.b()), inneractiveInfrastructureError));
    }

    public InneractiveInfrastructureError c() {
        EnumC3104i enumC3104i = EnumC3104i.WEBVIEW_LOAD_TIMEOUT;
        com.fyber.inneractive.sdk.response.e eVar = this.b;
        if ("video".equalsIgnoreCase((eVar == null || com.fyber.inneractive.sdk.response.a.a(eVar.g) != com.fyber.inneractive.sdk.response.a.RETURNED_ADTYPE_VAST) ? "display" : "video")) {
            enumC3104i = EnumC3104i.VIDEO_AD_LOAD_TIMEOUT;
        }
        return new InneractiveInfrastructureError(InneractiveErrorCode.LOAD_TIMEOUT, enumC3104i);
    }

    @Override // com.fyber.inneractive.sdk.interfaces.c
    public abstract void cancel();

    public abstract String d();

    public final com.fyber.inneractive.sdk.config.U e() {
        InneractiveAdRequest inneractiveAdRequest = this.f1803a;
        return inneractiveAdRequest == null ? this.f : inneractiveAdRequest.getSelectedUnitConfig();
    }

    public final void f() {
        String str;
        this.k.a();
        InneractiveAdRequest inneractiveAdRequest = this.f1803a;
        if (inneractiveAdRequest != null) {
            str = inneractiveAdRequest.b;
        } else {
            com.fyber.inneractive.sdk.response.e eVar = this.b;
            if (eVar == null || (str = eVar.B) == null) {
                str = null;
            }
        }
        com.fyber.inneractive.sdk.metrics.d.d.a(str).i();
        x xVar = this.c;
        if (xVar != null) {
            xVar.a(str);
        }
        com.fyber.inneractive.sdk.interfaces.a aVar = this.d;
        if (aVar != null) {
            aVar.a(this.f1803a);
        }
    }

    public abstract void g();

    public final void h() {
        int i = this.i;
        this.i = i + 1;
        com.fyber.inneractive.sdk.network.timeouts.content.a aVar = this.j;
        int i2 = 0;
        if (aVar != null) {
            if (aVar.g) {
                i = aVar.f1932a - i;
            }
            i2 = (i == aVar.f1932a ? aVar.h : 0) + (aVar.b * i) + aVar.d;
        }
        IAlog.a("%s : IAAdContentLoaderImpl : Start timeout: %d, attempt number: %d", IAlog.a(this), Integer.valueOf(i2), Integer.valueOf(this.i - 1));
        C3099d c3099d = this.k;
        if (c3099d.f1786a == null) {
            HandlerThread handlerThread = new HandlerThread("TimeoutHandlerThread");
            handlerThread.start();
            c3099d.f1786a = new Handler(handlerThread.getLooper());
        }
        c3099d.f1786a.postDelayed(c3099d.d, i2);
        g();
    }

    @Override // com.fyber.inneractive.sdk.interfaces.b
    public final void b() {
        String strA = IAlog.a(this);
        Integer numValueOf = Integer.valueOf(this.i - 1);
        int i = this.i - 1;
        com.fyber.inneractive.sdk.network.timeouts.content.a aVar = this.j;
        int i2 = 0;
        if (aVar != null) {
            if (aVar.g) {
                i = aVar.f1932a - i;
            }
            i2 = (i == aVar.f1932a ? aVar.h : 0) + (aVar.b * i) + aVar.d;
        }
        IAlog.a("%s : IAAdContentLoaderImpl : onRetry() attempt: %d timeout: %d", strA, numValueOf, Integer.valueOf(i2));
        com.fyber.inneractive.sdk.interfaces.b bVar = this.e;
        if (bVar != null) {
            bVar.b();
        }
        h();
    }

    public void a() {
        int i;
        InneractiveInfrastructureError inneractiveInfrastructureError;
        String strA = IAlog.a(this);
        Integer numValueOf = Integer.valueOf(this.i - 1);
        int i2 = this.i - 1;
        com.fyber.inneractive.sdk.network.timeouts.content.a aVar = this.j;
        if (aVar != null) {
            if (aVar.g) {
                i2 = aVar.f1932a - i2;
            }
            i = (aVar.b * i2) + aVar.d + (i2 == aVar.f1932a ? aVar.h : 0);
        } else {
            i = 0;
        }
        IAlog.a("%s : IAAdContentLoaderImpl : onTimeout() attempt: %d timeout: %d", strA, numValueOf, Integer.valueOf(i));
        com.fyber.inneractive.sdk.interfaces.b bVar = this.e;
        if (bVar != null) {
            bVar.a();
        }
        com.fyber.inneractive.sdk.network.timeouts.content.a aVar2 = this.j;
        if (this.i <= (aVar2 != null ? aVar2.f1932a : 0)) {
            inneractiveInfrastructureError = c();
        } else {
            inneractiveInfrastructureError = new InneractiveInfrastructureError(InneractiveErrorCode.IN_FLIGHT_TIMEOUT, EnumC3104i.NO_TIME_TO_LOAD_AD_CONTENT);
        }
        b(inneractiveInfrastructureError);
        a(inneractiveInfrastructureError);
    }

    public final void a(InneractiveInfrastructureError inneractiveInfrastructureError) {
        IAlog.a("%s : IAAdContentLoaderImpl : Handle Retry for error: %s", IAlog.a(this), inneractiveInfrastructureError.getErrorCode().toString());
        C3099d c3099d = this.k;
        c3099d.getClass();
        IAlog.a("%s : ContentLoadTimeoutHandler stopping timeout handler", IAlog.a(c3099d));
        Handler handler = c3099d.f1786a;
        if (handler != null) {
            handler.removeCallbacks(c3099d.d);
        }
        com.fyber.inneractive.sdk.network.timeouts.content.a aVar = this.j;
        boolean z = this.i <= (aVar != null ? aVar.f1932a : 0);
        IAlog.a("%s : IAAdContentLoaderImpl : should retry: %s", IAlog.a(this), Boolean.valueOf(z));
        if (z) {
            x xVar = this.c;
            if (xVar != null) {
                xVar.a();
                this.c = null;
            }
            com.fyber.inneractive.sdk.network.timeouts.content.a aVar2 = this.j;
            int i = aVar2 != null ? aVar2.e : 0;
            IAlog.a("%s : IAAdContentLoaderImpl : retryLoad : post load ad content retry task with delay: %d", IAlog.a(this), Integer.valueOf(i));
            com.fyber.inneractive.sdk.util.r.b.postDelayed(this.l, i);
            return;
        }
        com.fyber.inneractive.sdk.interfaces.a aVar3 = this.d;
        if (aVar3 != null) {
            aVar3.a(inneractiveInfrastructureError);
        }
        cancel();
        InneractiveAdRequest inneractiveAdRequest = this.f1803a;
        com.fyber.inneractive.sdk.response.e eVar = this.b;
        com.fyber.inneractive.sdk.config.global.r rVar = this.g;
        AbstractC3096a.a(inneractiveAdRequest, inneractiveInfrastructureError, this.c, eVar, rVar != null ? rVar.b() : null);
    }
}
