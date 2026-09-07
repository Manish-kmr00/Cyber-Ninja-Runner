package com.fyber.inneractive.sdk.bidder;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.config.AbstractC3081k;
import com.fyber.inneractive.sdk.config.AbstractC3090u;
import com.fyber.inneractive.sdk.config.C3091v;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.external.InneractiveAdManager;
import com.fyber.inneractive.sdk.external.InneractiveUserConfig;
import com.fyber.inneractive.sdk.util.AbstractC3247k;
import com.fyber.inneractive.sdk.util.AbstractC3251o;
import com.fyber.inneractive.sdk.util.AbstractC3255t;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.a0;
import com.unity3d.services.core.properties.MadeWithUnityDetector;
import java.util.ArrayList;

/* JADX INFO: renamed from: com.fyber.inneractive.sdk.bidder.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C3056d {
    public String A;
    public Boolean B;
    public String C;
    public int D;
    public InneractiveUserConfig.Gender E;
    public boolean F;
    public String G;
    public String H;
    public String I;
    public String J;
    public final boolean K;
    public Boolean L;
    public ArrayList M = new ArrayList();
    public ArrayList N = new ArrayList();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.fyber.inneractive.sdk.serverapi.c f1630a;
    public String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public Long l;
    public int m;
    public int n;
    public final EnumC3069q o;
    public String p;
    public String q;
    public final D r;
    public Boolean s;
    public Boolean t;
    public Boolean u;
    public boolean v;
    public Boolean w;
    public Boolean x;
    public Boolean y;
    public int z;

    public C3056d(com.fyber.inneractive.sdk.serverapi.c cVar) {
        String str;
        this.f1630a = cVar;
        if (TextUtils.isEmpty(this.b)) {
            com.fyber.inneractive.sdk.util.r.f2374a.execute(new RunnableC3055c(this));
        }
        StringBuilder sb = new StringBuilder("2.2.0-Android-8.3.6");
        if (!TextUtils.isEmpty(InneractiveAdManager.getDevPlatform())) {
            sb.append('-').append(InneractiveAdManager.getDevPlatform());
        }
        this.c = sb.toString();
        this.d = AbstractC3251o.f2370a.getPackageName();
        this.e = AbstractC3247k.k();
        this.f = AbstractC3247k.m();
        this.m = AbstractC3251o.b(AbstractC3251o.f());
        this.n = AbstractC3251o.b(AbstractC3251o.e());
        com.fyber.inneractive.sdk.serverapi.a aVar = com.fyber.inneractive.sdk.serverapi.b.f2324a;
        try {
            Class.forName(MadeWithUnityDetector.UNITY_PLAYER_CLASS_NAME);
            str = "unity3d";
        } catch (Throwable unused) {
            str = "native";
        }
        this.o = !str.equals("native") ? !str.equals("unity3d") ? EnumC3069q.UNRECOGNIZED : EnumC3069q.UNITY3D : EnumC3069q.NATIVE;
        this.r = (!AbstractC3255t.a() || IAConfigManager.O.q) ? D.SECURE : D.UNSECURE;
        IAConfigManager iAConfigManager = IAConfigManager.O;
        if (TextUtils.isEmpty(iAConfigManager.n)) {
            this.H = iAConfigManager.l;
        } else {
            this.H = iAConfigManager.l + "_" + iAConfigManager.n;
        }
        this.K = InneractiveAdManager.isCurrentUserAChild();
        a();
        this.t = com.fyber.inneractive.sdk.serverapi.b.g();
        this.B = com.fyber.inneractive.sdk.serverapi.b.i();
        this.w = com.fyber.inneractive.sdk.serverapi.b.f();
        this.x = com.fyber.inneractive.sdk.serverapi.b.l();
        this.y = com.fyber.inneractive.sdk.serverapi.b.k();
    }

    public final void a() {
        this.f1630a.getClass();
        IAConfigManager iAConfigManager = IAConfigManager.O;
        this.g = iAConfigManager.o;
        if (!InneractiveAdManager.isCurrentUserAChild()) {
            this.f1630a.getClass();
            this.h = AbstractC3247k.j();
            this.i = this.f1630a.a();
            String str = this.f1630a.b;
            this.j = str == null ? "" : str.substring(0, Math.min(3, str.length()));
            String str2 = this.f1630a.b;
            this.k = str2 != null ? str2.substring(Math.min(3, str2.length())) : "";
            this.f1630a.getClass();
            a0 a0VarA = a0.a();
            IAlog.a("ExchangeRequestParamsProvider: getNetwork : type: %s value: %s", a0VarA, a0VarA.b());
            this.q = a0VarA.b();
            int i = AbstractC3081k.f1710a;
            String property = System.getProperty("ia.testEnvironmentConfiguration.device");
            if (TextUtils.isEmpty(property)) {
                C3091v c3091v = AbstractC3090u.f1727a.b;
                property = c3091v != null ? c3091v.f1728a : null;
            }
            this.A = property;
            this.G = iAConfigManager.j.getZipCode();
        }
        this.E = iAConfigManager.j.getGender();
        this.D = iAConfigManager.j.getAge();
        this.l = com.fyber.inneractive.sdk.serverapi.b.e();
        this.f1630a.getClass();
        ArrayList arrayList = iAConfigManager.p;
        if (arrayList != null && !arrayList.isEmpty()) {
            this.p = AbstractC3251o.a(arrayList);
        }
        this.C = com.fyber.inneractive.sdk.serverapi.b.b();
        this.v = com.fyber.inneractive.sdk.serverapi.b.h().booleanValue();
        this.z = com.fyber.inneractive.sdk.serverapi.b.c().intValue();
        this.F = iAConfigManager.k;
        this.s = com.fyber.inneractive.sdk.serverapi.b.m();
        if (TextUtils.isEmpty(iAConfigManager.n)) {
            this.H = iAConfigManager.l;
        } else {
            this.H = iAConfigManager.l + "_" + iAConfigManager.n;
        }
        this.u = com.fyber.inneractive.sdk.serverapi.b.n();
        iAConfigManager.E.n();
        com.fyber.inneractive.sdk.ignite.l lVar = iAConfigManager.E.p;
        this.I = lVar != null ? lVar.f1221a.i() : null;
        com.fyber.inneractive.sdk.ignite.l lVar2 = iAConfigManager.E.p;
        this.J = lVar2 != null ? lVar2.f1221a.d() : null;
        this.f1630a.getClass();
        this.m = AbstractC3251o.b(AbstractC3251o.f());
        this.f1630a.getClass();
        this.n = AbstractC3251o.b(AbstractC3251o.e());
        this.L = com.fyber.inneractive.sdk.serverapi.b.j();
        com.fyber.inneractive.sdk.topics.b bVar = iAConfigManager.F;
        if (bVar != null && IAConfigManager.f()) {
            this.N = bVar.f;
            this.M = bVar.e;
        }
    }
}
