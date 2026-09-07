package com.fyber.inneractive.sdk.network;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.bidder.adm.AdmParametersOuterClass$AdmParameters;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.util.AbstractC3256u;
import com.fyber.inneractive.sdk.util.IAlog;
import java.io.InputStream;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes13.dex */
public final class f0 extends U {
    public final String p;
    public final com.fyber.inneractive.sdk.bidder.adm.y q;
    public int r;
    public final com.fyber.inneractive.sdk.response.e s;
    public final com.fyber.inneractive.sdk.config.global.r t;
    public final com.fyber.inneractive.sdk.network.timeouts.request.a u;

    public f0(com.fyber.inneractive.sdk.bidder.adm.v vVar, String str, com.fyber.inneractive.sdk.bidder.adm.y yVar, com.fyber.inneractive.sdk.config.global.r rVar, com.fyber.inneractive.sdk.response.e eVar) {
        UnitDisplayType unitDisplayType;
        super(vVar, G.c.a(), rVar);
        this.r = 0;
        this.o = true;
        this.p = str;
        this.q = yVar;
        this.s = eVar;
        this.t = rVar;
        UnitDisplayType unitDisplayType2 = UnitDisplayType.BANNER;
        String strName = unitDisplayType2.name();
        Locale locale = Locale.US;
        String lowerCase = strName.toLowerCase(locale);
        if (eVar == null || (unitDisplayType = eVar.p) == null) {
            AdmParametersOuterClass$AdmParameters admParametersOuterClass$AdmParameters = yVar.f1627a;
            if (admParametersOuterClass$AdmParameters != null) {
                lowerCase = com.fyber.inneractive.sdk.util.o0.a(String.valueOf(admParametersOuterClass$AdmParameters.getSpotId()));
            }
        } else {
            lowerCase = (unitDisplayType == UnitDisplayType.INTERSTITIAL || unitDisplayType == UnitDisplayType.REWARDED) ? unitDisplayType.name().toLowerCase(locale) : unitDisplayType2.name().toLowerCase(locale);
        }
        String str2 = IAConfigManager.O.l;
        com.fyber.inneractive.sdk.config.global.features.k kVar = (com.fyber.inneractive.sdk.config.global.features.k) rVar.a(com.fyber.inneractive.sdk.config.global.features.k.class);
        this.u = TextUtils.isEmpty(str2) ? new com.fyber.inneractive.sdk.network.timeouts.request.b(kVar, lowerCase) : new com.fyber.inneractive.sdk.network.timeouts.request.c(lowerCase, kVar, str2);
    }

    @Override // com.fyber.inneractive.sdk.network.U
    public final O a(C3136l c3136l, Map map, int i) throws N, t0 {
        O o = new O();
        try {
            InputStream inputStream = c3136l.c;
            if (inputStream != null) {
                d(System.currentTimeMillis());
                StringBuffer stringBufferA = AbstractC3256u.a(inputStream);
                b(System.currentTimeMillis());
                String string = stringBufferA.toString();
                AdmParametersOuterClass$AdmParameters admParametersOuterClass$AdmParameters = this.q.f1627a;
                int iA = admParametersOuterClass$AdmParameters != null ? admParametersOuterClass$AdmParameters.getAdType().a() : com.fyber.inneractive.sdk.bidder.adm.c.OTHER.a();
                com.fyber.inneractive.sdk.bidder.adm.y yVar = this.q;
                yVar.c = string;
                com.fyber.inneractive.sdk.response.e eVarA = a(iA, null, yVar, null);
                eVarA.h = string;
                o.f1911a = eVarA;
            }
            return o;
        } catch (C3126b e) {
            e = e;
            IAlog.a("failed parse adm network request but will re-try", e, new Object[0]);
            b(System.currentTimeMillis());
            throw new t0(e);
        } catch (SocketTimeoutException e2) {
            e = e2;
            IAlog.a("failed parse adm network request but will re-try", e, new Object[0]);
            b(System.currentTimeMillis());
            throw new t0(e);
        } catch (UnknownHostException e3) {
            e = e3;
            IAlog.a("failed parse adm network request but will re-try", e, new Object[0]);
            b(System.currentTimeMillis());
            throw new t0(e);
        } catch (Exception e4) {
            b(System.currentTimeMillis());
            IAlog.a("failed parse adm network request", e4, new Object[0]);
            throw new N(e4);
        }
    }

    @Override // com.fyber.inneractive.sdk.network.U
    public final void b(long j) {
        super.b(j);
        IAlog.a("%s : NetworkRequestMarkup : set end read timestamp, total execution time: %d", IAlog.a(this), Integer.valueOf(super.o()));
    }

    @Override // com.fyber.inneractive.sdk.network.U
    public final void c() {
        super.c();
        IAlog.a("%s : NetworkRequestMarkup cancel by timeout at retry: %d", IAlog.a(this), Integer.valueOf(this.r));
        L l = IAConfigManager.O.s;
        this.f1914a = true;
        f0 f0Var = new f0(this);
        if ((l instanceof L) && l.d(f0Var)) {
            return;
        }
        IAlog.a("%s : NetworkRequestMarkup won't retry - resolve request with `Bidding ad request passed allowed time` at retry: %d", IAlog.a(this), Integer.valueOf(this.r));
        a((Object) null, new Exception("Bidding ad request passed allowed time"), false);
    }

    @Override // com.fyber.inneractive.sdk.network.U
    public final void d(long j) {
        super.d(j);
        IAlog.a("%s : NetworkRequestMarkup : set start read timestamp", IAlog.a(this));
    }

    @Override // com.fyber.inneractive.sdk.network.U
    public final int e() {
        return this.u.c();
    }

    @Override // com.fyber.inneractive.sdk.network.U
    public final int h() {
        int iO = super.o();
        com.fyber.inneractive.sdk.network.timeouts.request.a aVar = this.u;
        return ((aVar.c() + aVar.f) * this.r) + iO;
    }

    @Override // com.fyber.inneractive.sdk.network.U
    public final com.fyber.inneractive.sdk.config.global.r i() {
        return this.t;
    }

    @Override // com.fyber.inneractive.sdk.network.U
    public final M k() {
        return M.GET;
    }

    @Override // com.fyber.inneractive.sdk.network.U
    public final g0 m() {
        return g0.HIGH;
    }

    @Override // com.fyber.inneractive.sdk.network.U
    public final l0 n() {
        com.fyber.inneractive.sdk.network.timeouts.request.a aVar = this.u;
        return new l0(aVar.i, aVar.h);
    }

    @Override // com.fyber.inneractive.sdk.network.U
    public final int o() {
        throw null;
    }

    @Override // com.fyber.inneractive.sdk.network.U
    public final String p() {
        return this.p;
    }

    @Override // com.fyber.inneractive.sdk.network.U
    public final int q() {
        return this.u.f;
    }

    @Override // com.fyber.inneractive.sdk.network.U
    public final boolean s() {
        if (this.f1914a) {
            return false;
        }
        int i = this.r + 1;
        this.r = i;
        if (i > this.u.b()) {
            IAlog.a("%s : NetworkRequestMarkup Should enable retry - FALSE, current retry: %d total retries: %d, request id: %s", IAlog.a(this), Integer.valueOf(this.r - 1), Integer.valueOf(this.u.b()), this.g);
            return false;
        }
        IAlog.a("%s : NetworkRequestMarkup Should enable retry - TRUE, current retry: %d total retries: %d, request id: %s", IAlog.a(this), Integer.valueOf(this.r - 1), Integer.valueOf(this.u.b()), this.g);
        this.u.a(this.r);
        return true;
    }

    @Override // com.fyber.inneractive.sdk.network.U
    public final void c(long j) {
        super.c(j);
        IAlog.a("%s : NetworkRequestMarkup : set start connection timestamp", IAlog.a(this));
    }

    @Override // com.fyber.inneractive.sdk.network.U
    public final C3136l a(String str) {
        IAlog.a("%s : NetworkRequestMarkup Ad request execution started, retry number: %d, timeouts(connection: %d read: %d)", IAlog.a(this), Integer.valueOf(this.r), Integer.valueOf(n().f1925a), Integer.valueOf(n().b));
        return super.a(str);
    }

    @Override // com.fyber.inneractive.sdk.network.U
    public final void a(long j) {
        super.a(j);
        IAlog.a("%s : NetworkRequestMarkup : set end connection timestamp, total execution time: %d", IAlog.a(this), Integer.valueOf(super.o()));
    }

    public f0(f0 f0Var) {
        super(f0Var);
        this.r = 0;
        this.o = true;
        this.p = f0Var.p;
        this.q = f0Var.q;
        this.s = f0Var.s;
        this.t = f0Var.t;
        this.u = f0Var.u;
        this.r = f0Var.r;
    }
}
