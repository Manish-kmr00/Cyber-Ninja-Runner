package com.fyber.inneractive.sdk.metrics;

import java.util.HashMap;

/* JADX INFO: loaded from: classes13.dex */
public final class e implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Long f1870a = null;
    public Long b = null;
    public Long c = null;
    public Long d = null;
    public Long e = null;
    public Long f = null;
    public Long g = null;
    public Long h = null;

    @Override // com.fyber.inneractive.sdk.metrics.g
    public final boolean a() {
        return true;
    }

    @Override // com.fyber.inneractive.sdk.metrics.g
    public final Long b() {
        Long lValueOf = Long.valueOf(System.currentTimeMillis());
        this.g = lValueOf;
        return lValueOf;
    }

    @Override // com.fyber.inneractive.sdk.metrics.g
    public final Long c() {
        Long lValueOf = Long.valueOf(System.currentTimeMillis());
        this.f1870a = lValueOf;
        return lValueOf;
    }

    @Override // com.fyber.inneractive.sdk.metrics.g
    public final Long d() {
        Long lValueOf = Long.valueOf(System.currentTimeMillis());
        this.d = lValueOf;
        return lValueOf;
    }

    @Override // com.fyber.inneractive.sdk.metrics.g
    public final Long e() {
        Long lValueOf = Long.valueOf(System.currentTimeMillis());
        this.f = lValueOf;
        return lValueOf;
    }

    @Override // com.fyber.inneractive.sdk.metrics.g
    public final Long f() {
        Long lValueOf = Long.valueOf(System.currentTimeMillis());
        this.b = lValueOf;
        return lValueOf;
    }

    @Override // com.fyber.inneractive.sdk.metrics.g
    public final Long g() {
        Long lValueOf = Long.valueOf(System.currentTimeMillis());
        this.c = lValueOf;
        return lValueOf;
    }

    @Override // com.fyber.inneractive.sdk.metrics.g
    public final Long h() {
        Long lValueOf = Long.valueOf(System.currentTimeMillis());
        this.h = lValueOf;
        return lValueOf;
    }

    @Override // com.fyber.inneractive.sdk.metrics.g
    public final Long i() {
        Long lValueOf = Long.valueOf(System.currentTimeMillis());
        this.e = lValueOf;
        return lValueOf;
    }

    @Override // com.fyber.inneractive.sdk.metrics.g
    public final HashMap j() {
        HashMap map = new HashMap();
        Long l = this.b;
        if (l != null && this.f1870a != null) {
            map.put("sdk_init_network_req", Long.valueOf(l.longValue() - this.f1870a.longValue()));
        }
        Long l2 = this.h;
        if (l2 != null && this.b != null) {
            map.put("sdk_got_response_from_markup_url", Long.valueOf(l2.longValue() - this.b.longValue()));
        }
        Long l3 = this.d;
        if (l3 != null && this.h != null) {
            map.put("sdk_parsed_res", Long.valueOf(l3.longValue() - this.h.longValue()));
        }
        Long l4 = this.c;
        if (l4 != null && this.b != null) {
            map.put("sdk_got_server_res", Long.valueOf(l4.longValue() - this.b.longValue()));
        }
        Long l5 = this.d;
        if (l5 != null && this.c != null) {
            map.put("sdk_parsed_res", Long.valueOf(l5.longValue() - this.c.longValue()));
        }
        Long l6 = this.e;
        if (l6 != null && this.d != null) {
            map.put("ad_loaded_result", Long.valueOf(l6.longValue() - this.d.longValue()));
        }
        Long l7 = this.f;
        if (l7 != null && this.e != null) {
            map.put("publisher_notified", Long.valueOf(l7.longValue() - this.e.longValue()));
        }
        Long l8 = this.g;
        if (l8 != null && this.f1870a != null) {
            map.put("roundtrip", Long.valueOf(l8.longValue() - this.f1870a.longValue()));
        }
        return map;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("MetricsCollectorData{");
        if (this.f1870a != null && this.b != null) {
            sb.append(" sdk_init_network_req=").append(this.b.longValue() - this.f1870a.longValue());
        }
        if (this.h != null && this.b != null) {
            sb.append(", sdk_got_response_from_markup_url=").append(this.h.longValue() - this.b.longValue());
        }
        if (this.c != null && this.b != null) {
            sb.append(", sdk_got_server_res=").append(this.c.longValue() - this.b.longValue());
        }
        if (this.d != null && this.c != null) {
            sb.append(", sdk_parsed_res=").append(this.d.longValue() - this.c.longValue());
        }
        if (this.e != null && this.d != null) {
            sb.append(", ad_loaded_result=").append(this.e.longValue() - this.d.longValue());
        }
        if (this.f != null && this.e != null) {
            sb.append(", publisher_notified=").append(this.f.longValue() - this.e.longValue());
        }
        if (this.g != null && this.f1870a != null) {
            sb.append(", roundtrip=").append(this.g.longValue() - this.f1870a.longValue());
        }
        sb.append(" }");
        return sb.toString();
    }
}
