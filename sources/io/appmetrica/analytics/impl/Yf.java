package io.appmetrica.analytics.impl;

import android.os.Bundle;
import android.os.Handler;
import io.appmetrica.analytics.DeferredDeeplinkListener;
import io.appmetrica.analytics.DeferredDeeplinkParametersListener;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.util.Set;

/* JADX INFO: loaded from: classes7.dex */
public final class Yf implements Sf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f11437a;
    public final C4320ni b;
    public final Ke c;
    public final R7 d;
    public final C4144gg e;
    public final Handler f;

    public Yf(C4320ni c4320ni, Ke ke, Handler handler) {
        this(c4320ni, ke, handler, ke.s());
    }

    public final void a() {
        if (this.f11437a) {
            return;
        }
        C4320ni c4320ni = this.b;
        ResultReceiverC4193ig resultReceiverC4193ig = new ResultReceiverC4193ig(this.f, this);
        c4320ni.getClass();
        Bundle bundle = new Bundle();
        bundle.putParcelable("io.appmetrica.analytics.impl.referrer.common.ReferrerResultReceiver", resultReceiverC4193ig);
        PublicLogger anonymousInstance = PublicLogger.getAnonymousInstance();
        Set set = C9.f11086a;
        EnumC4164hb enumC4164hb = EnumC4164hb.EVENT_TYPE_UNDEFINED;
        C4082e4 c4082e4 = new C4082e4("", "", 4098, 0, anonymousInstance);
        c4082e4.m = bundle;
        W4 w4 = c4320ni.f11687a;
        c4320ni.a(C4320ni.a(c4082e4, w4), w4, 1, null);
    }

    public Yf(C4320ni c4320ni, Ke ke, Handler handler, boolean z) {
        this(c4320ni, ke, handler, z, new R7(z), new C4144gg());
    }

    public Yf(C4320ni c4320ni, Ke ke, Handler handler, boolean z, R7 r7, C4144gg c4144gg) {
        this.b = c4320ni;
        this.c = ke;
        this.f11437a = z;
        this.d = r7;
        this.e = c4144gg;
        this.f = handler;
    }

    @Override // io.appmetrica.analytics.impl.Sf
    public final void a(C4044cg c4044cg) {
        String str = c4044cg == null ? null : c4044cg.f11496a;
        if (this.f11437a) {
            return;
        }
        synchronized (this) {
            R7 r7 = this.d;
            this.e.getClass();
            r7.d = C4144gg.a(str);
            r7.a();
        }
    }

    public final synchronized void a(DeferredDeeplinkParametersListener deferredDeeplinkParametersListener) {
        try {
            R7 r7 = this.d;
            r7.c = deferredDeeplinkParametersListener;
            if (r7.f11325a) {
                r7.a(1);
            } else {
                r7.a();
            }
            this.c.u();
        } catch (Throwable th) {
            this.c.u();
            throw th;
        }
    }

    public final synchronized void a(DeferredDeeplinkListener deferredDeeplinkListener) {
        try {
            R7 r7 = this.d;
            r7.b = deferredDeeplinkListener;
            if (r7.f11325a) {
                r7.a(1);
            } else {
                r7.a();
            }
            this.c.u();
        } catch (Throwable th) {
            this.c.u();
            throw th;
        }
    }
}
