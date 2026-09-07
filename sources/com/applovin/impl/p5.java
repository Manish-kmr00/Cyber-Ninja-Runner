package com.applovin.impl;

import com.applovin.impl.sdk.AppLovinError;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.adapter.MaxAdapterError;
import io.ktor.http.ContentDisposition;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class p5 extends g5 {
    protected final u g;
    private final String h;

    public p5(u uVar, String str, com.applovin.impl.sdk.k kVar) {
        super(str, kVar);
        this.g = uVar;
        this.h = kVar.b();
    }

    private Map g() {
        HashMap map = new HashMap(3);
        map.put("AppLovin-Zone-Id", this.g.e());
        if (this.g.f() != null) {
            map.put("AppLovin-Ad-Size", this.g.f().getLabel());
        }
        if (this.g.g() != null) {
            map.put("AppLovin-Ad-Type", this.g.g().getLabel());
        }
        return map;
    }

    protected abstract g5 a(JSONObject jSONObject);

    protected void a(int i, String str) {
        if (com.applovin.impl.sdk.o.a()) {
            this.c.b(this.b, "Unable to fetch " + this.g + " ad: server returned " + i);
        }
        this.f424a.g().a(c2.m, this.g, new AppLovinError(i, str));
    }

    protected void b(JSONObject jSONObject) {
        r0.c(jSONObject, this.f424a);
        r0.b(jSONObject, this.f424a);
        r0.a(jSONObject, this.f424a);
        u.a(jSONObject);
        this.f424a.r0().a(a(jSONObject));
    }

    protected abstract String e();

    protected abstract String f();

    protected Map h() {
        HashMap map = new HashMap(4);
        map.put("zone_id", this.g.e());
        if (this.g.f() != null) {
            map.put(ContentDisposition.Parameters.Size, this.g.f().getLabel());
        }
        if (this.g.g() != null) {
            map.put("require", this.g.g().getLabel());
        }
        return map;
    }

    @Override // java.lang.Runnable
    public void run() {
        s4.a aVarA;
        Map map;
        if (com.applovin.impl.sdk.o.a()) {
            this.c.a(this.b, "Fetching next ad of zone: " + this.g);
        }
        if (((Boolean) this.f424a.a(v4.Q3)).booleanValue() && k7.j() && com.applovin.impl.sdk.o.a()) {
            this.c.a(this.b, "User is connected to a VPN");
        }
        k7.a(this.f424a, this.b);
        this.f424a.g().a(c2.k, this.g, (AppLovinError) null);
        try {
            JSONObject andResetCustomPostBody = this.f424a.k().getAndResetCustomPostBody();
            String str = "POST";
            if (((Boolean) this.f424a.a(v4.f3)).booleanValue()) {
                aVarA = s4.a.a(((Integer) this.f424a.a(v4.i5)).intValue());
                JSONObject jSONObject = new JSONObject(this.f424a.B().a(h(), false, true));
                map = new HashMap();
                if (!((Boolean) this.f424a.a(v4.s5)).booleanValue() && !((Boolean) this.f424a.a(v4.o5)).booleanValue()) {
                    map.put(com.safedk.android.analytics.brandsafety.l.x, UUID.randomUUID().toString());
                }
                if (!((Boolean) this.f424a.a(v4.a5)).booleanValue()) {
                    map.put("sdk_key", this.f424a.j0());
                }
                JsonUtils.putAll(jSONObject, andResetCustomPostBody);
                andResetCustomPostBody = jSONObject;
            } else {
                s4.a aVarA2 = s4.a.a(((Integer) this.f424a.a(v4.j5)).intValue());
                Map mapA = k7.a(this.f424a.B().a(h(), false, false));
                if (!((Boolean) this.f424a.a(v4.A6)).booleanValue()) {
                    mapA.remove("video_decoders");
                }
                if (andResetCustomPostBody == null) {
                    str = "GET";
                    andResetCustomPostBody = null;
                }
                aVarA = aVarA2;
                map = mapA;
            }
            if (k7.h(a()) || k7.j(a())) {
                map.putAll(this.f424a.k().getAndResetCustomQueryParams());
            }
            if (StringUtils.isValidString(this.h)) {
                map.put("sts", this.h);
            }
            com.applovin.impl.sdk.network.a.C0143a c0143aF = com.applovin.impl.sdk.network.a.a(this.f424a).b(f()).a(e()).b(map).c(str).a(g()).a((Object) new JSONObject()).a(((Integer) this.f424a.a(v4.U2)).intValue()).c(((Boolean) this.f424a.a(v4.V2)).booleanValue()).d(((Boolean) this.f424a.a(v4.W2)).booleanValue()).c(((Integer) this.f424a.a(v4.T2)).intValue()).a(aVarA).f(true);
            if (andResetCustomPostBody != null) {
                c0143aF.a(andResetCustomPostBody);
                c0143aF.b(((Boolean) this.f424a.a(v4.C5)).booleanValue());
            }
            a aVar = new a(c0143aF.a(), this.f424a);
            aVar.c(v4.o0);
            aVar.b(v4.p0);
            this.f424a.r0().a(aVar);
        } catch (Throwable th) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.a(this.b, "Unable to fetch ad for zone id: " + this.g, th);
            }
            a(0, th.getMessage());
        }
    }

    class a extends j6 {
        a(com.applovin.impl.sdk.network.a aVar, com.applovin.impl.sdk.k kVar) {
            super(aVar, kVar);
        }

        @Override // com.applovin.impl.j6, com.applovin.impl.q0.e
        public void a(String str, JSONObject jSONObject, int i) {
            if (i == 200) {
                JsonUtils.putLong(jSONObject, "ad_fetch_latency_millis", this.l.a());
                JsonUtils.putLong(jSONObject, "ad_fetch_response_size", this.l.b());
                HashMap map = new HashMap(5);
                CollectionUtils.putStringIfValid("url", StringUtils.getHost(str), map);
                CollectionUtils.putStringIfValid("code", String.valueOf(i), map);
                CollectionUtils.putStringIfValid("ad_zone_id", p5.this.g.e(), map);
                CollectionUtils.putStringIfValid("latency_ms", String.valueOf(this.l.a()), map);
                CollectionUtils.putStringIfValid("response_size", String.valueOf(this.l.b()), map);
                this.f424a.g().d(c2.l, map);
                p5.this.b(jSONObject);
                return;
            }
            p5.this.a(i, MaxAdapterError.NO_FILL.getErrorMessage());
        }

        @Override // com.applovin.impl.j6, com.applovin.impl.q0.e
        public void a(String str, int i, String str2, JSONObject jSONObject) {
            p5.this.a(i, str2);
            this.f424a.E().a("fetchAd", str, i, str2);
        }
    }
}
