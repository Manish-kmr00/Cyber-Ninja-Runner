package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.billinginterface.internal.config.BillingConfig;
import io.appmetrica.analytics.networktasks.internal.RetryPolicyConfig;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public final class Hl {
    public final C4125fm A;
    public final Map B;
    public final I9 C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11181a;
    public final String b;
    public final Ll c;
    public final String d;
    public final List e;
    public final List f;
    public final List g;
    public final Map h;
    public final String i;
    public final String j;
    public final String k;
    public final String l;
    public final String m;
    public final C4 n;
    public final long o;
    public final boolean p;
    public final boolean q;
    public final String r;
    public final C4291me s;
    public final RetryPolicyConfig t;
    public final long u;
    public final long v;
    public final boolean w;
    public final BillingConfig x;
    public final C4554x3 y;
    public final C4354p2 z;

    public Hl(String str, String str2, Ll ll) {
        this.f11181a = str;
        this.b = str2;
        this.c = ll;
        this.d = ll.f11248a;
        this.e = ll.b;
        this.f = ll.f;
        this.g = ll.g;
        List list = ll.h;
        this.h = ll.i;
        this.i = ll.c;
        this.j = ll.d;
        String str3 = ll.e;
        this.k = ll.j;
        this.l = ll.k;
        this.m = ll.l;
        this.n = ll.m;
        this.o = ll.n;
        this.p = ll.o;
        this.q = ll.p;
        this.r = ll.q;
        C4224jm c4224jm = ll.r;
        this.s = ll.s;
        this.t = ll.t;
        this.u = ll.u;
        this.v = ll.v;
        this.w = ll.w;
        this.x = ll.x;
        this.y = ll.y;
        this.z = ll.z;
        this.A = ll.A;
        this.B = ll.B;
        this.C = ll.C;
    }

    public final String a() {
        return this.f11181a;
    }

    public final String b() {
        return this.b;
    }

    public final long c() {
        return this.v;
    }

    public final long d() {
        return this.u;
    }

    public final String e() {
        return this.d;
    }

    public final String toString() {
        return "StartupState(deviceId=" + this.f11181a + ", deviceIdHash=" + this.b + ", startupStateModel=" + this.c + ')';
    }
}
