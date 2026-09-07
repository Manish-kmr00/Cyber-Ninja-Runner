package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.billinginterface.internal.config.BillingConfig;
import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import io.appmetrica.analytics.networktasks.internal.RetryPolicyConfig;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes5.dex */
public final class Ll {
    public final C4125fm A;
    public final Map B;
    public final I9 C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11248a;
    public final List b;
    public final String c;
    public final String d;
    public final String e;
    public final List f;
    public final List g;
    public final List h;
    public final Map i;
    public final String j;
    public final String k;
    public final String l;
    public final C4 m;
    public final long n;
    public final boolean o;
    public final boolean p;
    public final String q;
    public final C4224jm r;
    public final C4291me s;
    public final RetryPolicyConfig t;
    public final long u;
    public final long v;
    public final boolean w;
    public final BillingConfig x;
    public final C4554x3 y;
    public final C4354p2 z;

    public Ll(Kl kl) {
        this.f11248a = kl.f11230a;
        List list = kl.b;
        this.b = list == null ? null : CollectionUtils.unmodifiableListCopy(list);
        this.c = kl.c;
        this.d = kl.d;
        this.e = kl.e;
        List list2 = kl.f;
        this.f = list2 == null ? null : CollectionUtils.unmodifiableListCopy(list2);
        List list3 = kl.g;
        this.g = list3 == null ? null : CollectionUtils.unmodifiableListCopy(list3);
        List list4 = kl.h;
        this.h = list4 == null ? null : CollectionUtils.unmodifiableListCopy(list4);
        Map map = kl.i;
        this.i = map != null ? CollectionUtils.unmodifiableMapCopy(map) : null;
        this.j = kl.j;
        this.k = kl.k;
        this.m = kl.m;
        this.s = kl.n;
        this.n = kl.o;
        this.o = kl.p;
        this.l = kl.l;
        this.p = kl.q;
        this.q = kl.r;
        this.r = kl.s;
        this.u = kl.t;
        this.v = kl.u;
        this.w = kl.v;
        RetryPolicyConfig retryPolicyConfig = kl.w;
        if (retryPolicyConfig == null) {
            Zl zl = new Zl();
            this.t = new RetryPolicyConfig(zl.w, zl.x);
        } else {
            this.t = retryPolicyConfig;
        }
        this.x = kl.x;
        this.y = kl.y;
        this.z = kl.z;
        this.A = kl.A == null ? new C4125fm(O7.b.f11423a) : kl.A;
        this.B = kl.B == null ? Collections.emptyMap() : kl.B;
        this.C = kl.C;
    }

    public final Kl a(C4 c4) {
        Kl kl = new Kl(c4);
        kl.f11230a = this.f11248a;
        kl.f = this.f;
        kl.g = this.g;
        kl.j = this.j;
        kl.b = this.b;
        kl.c = this.c;
        kl.d = this.d;
        kl.e = this.e;
        kl.h = this.h;
        kl.i = this.i;
        kl.k = this.k;
        kl.l = this.l;
        kl.q = this.p;
        kl.o = this.n;
        kl.p = this.o;
        kl.r = this.q;
        kl.n = this.s;
        kl.t = this.u;
        kl.u = this.v;
        kl.s = this.r;
        kl.v = this.w;
        kl.w = this.t;
        kl.y = this.y;
        kl.x = this.x;
        kl.z = this.z;
        kl.A = this.A;
        kl.B = this.B;
        kl.C = this.C;
        return kl;
    }

    public final String toString() {
        return "StartupStateModel{uuid='" + this.f11248a + "', reportUrls=" + this.b + ", getAdUrl='" + this.c + "', reportAdUrl='" + this.d + "', certificateUrl='" + this.e + "', hostUrlsFromStartup=" + this.f + ", hostUrlsFromClient=" + this.g + ", diagnosticUrls=" + this.h + ", customSdkHosts=" + this.i + ", encodedClidsFromResponse='" + this.j + "', lastClientClidsForStartupRequest='" + this.k + "', lastChosenForRequestClids='" + this.l + "', collectingFlags=" + this.m + ", obtainTime=" + this.n + ", hadFirstStartup=" + this.o + ", startupDidNotOverrideClids=" + this.p + ", countryInit='" + this.q + "', statSending=" + this.r + ", permissionsCollectingConfig=" + this.s + ", retryPolicyConfig=" + this.t + ", obtainServerTime=" + this.u + ", firstStartupServerTime=" + this.v + ", outdated=" + this.w + ", autoInappCollectingConfig=" + this.x + ", cacheControl=" + this.y + ", attributionConfig=" + this.z + ", startupUpdateConfig=" + this.A + ", modulesRemoteConfigs=" + this.B + ", externalAttributionConfig=" + this.C + AbstractJsonLexerKt.END_OBJ;
    }
}
