package io.appmetrica.analytics.impl;

import android.content.Context;
import android.text.TextUtils;
import io.appmetrica.analytics.StartupParamsCallback;
import io.appmetrica.analytics.coreapi.internal.identifiers.IdentifierStatus;
import io.appmetrica.analytics.internal.IdentifiersResult;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.yl, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C4597yl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashSet f11865a;
    public final HashMap b;
    public final C4522vl c;
    public List d;
    public HashMap e;
    public long f;
    public boolean g;
    public long h;
    public final Ke i;
    public final M j;
    public final W3 k;
    public final E6 l;
    public final C3988aa m;
    public final Z9 n;
    public final Mn o;

    public C4597yl(Context context, Ke ke) {
        this(ke, new M(), new W3(), C4455t4.i().a(context), new E6(), new C3988aa(), new Z9(), new Mn());
    }

    public final synchronized boolean a(List list) {
        boolean z;
        boolean z2;
        boolean zA = a(CollectionsKt.intersect(list, El.f11127a));
        Iterator it = list.iterator();
        while (true) {
            z = true;
            if (!it.hasNext()) {
                z2 = false;
                break;
            }
            if (this.f11865a.contains((String) it.next())) {
                z2 = true;
                break;
            }
        }
        boolean z3 = El.b.currentTimeSeconds() > this.h;
        if (zA && !z2 && !z3 && !this.g) {
            z = false;
        }
        return z;
    }

    public final void b(IdentifiersResult identifiersResult) {
        if (a(identifiersResult)) {
            return;
        }
        this.b.put("appmetrica_clids", identifiersResult);
    }

    public final void c(IdentifiersResult identifiersResult) {
        if (identifiersResult != null) {
            Mn mn = this.o;
            String str = identifiersResult.id;
            mn.getClass();
            if (Mn.a(str)) {
                this.b.put(StartupParamsCallback.APPMETRICA_UUID, identifiersResult);
            }
        }
    }

    public final synchronized boolean b() {
        return a(Arrays.asList("appmetrica_clids", StartupParamsCallback.APPMETRICA_DEVICE_ID_HASH, StartupParamsCallback.APPMETRICA_DEVICE_ID, "appmetrica_get_ad_url", "appmetrica_report_ad_url", StartupParamsCallback.APPMETRICA_UUID));
    }

    public final void c() {
        C4038ca c4038ca;
        Ke keD = this.i.i((IdentifiersResult) this.b.get(StartupParamsCallback.APPMETRICA_UUID)).e((IdentifiersResult) this.b.get(StartupParamsCallback.APPMETRICA_DEVICE_ID)).d((IdentifiersResult) this.b.get(StartupParamsCallback.APPMETRICA_DEVICE_ID_HASH)).a((IdentifiersResult) this.b.get("appmetrica_get_ad_url")).b((IdentifiersResult) this.b.get("appmetrica_report_ad_url")).e(this.f).h((IdentifiersResult) this.b.get("appmetrica_clids")).j(AbstractC4199im.a((Map) this.e)).f((IdentifiersResult) this.b.get("appmetrica_google_adv_id")).g((IdentifiersResult) this.b.get("appmetrica_huawei_oaid")).j((IdentifiersResult) this.b.get("appmetrica_yandex_adv_id")).b(this.g).c(this.l.d).d(this.h);
        C3988aa c3988aa = this.m;
        synchronized (c3988aa) {
            c4038ca = c3988aa.b;
        }
        keD.a(c4038ca).b();
    }

    public C4597yl(Ke ke, M m, W3 w3, C4489ud c4489ud, E6 e6, C3988aa c3988aa, Z9 z9, Mn mn) {
        HashSet hashSet = new HashSet();
        this.f11865a = hashSet;
        this.b = new HashMap();
        this.c = new C4522vl();
        hashSet.add("appmetrica_google_adv_id");
        hashSet.add("appmetrica_huawei_oaid");
        hashSet.add("appmetrica_yandex_adv_id");
        this.i = ke;
        this.j = m;
        this.k = w3;
        this.l = e6;
        this.m = c3988aa;
        this.n = z9;
        this.o = mn;
        c(c4489ud.a());
        a(StartupParamsCallback.APPMETRICA_DEVICE_ID, ke.j());
        a(StartupParamsCallback.APPMETRICA_DEVICE_ID_HASH, ke.i());
        a("appmetrica_get_ad_url", ke.d());
        a("appmetrica_report_ad_url", ke.e());
        b(ke.o());
        a("appmetrica_google_adv_id", ke.l());
        a("appmetrica_huawei_oaid", ke.m());
        a("appmetrica_yandex_adv_id", ke.r());
        e6.a(ke.h());
        c3988aa.a(ke.k());
        this.d = ke.g();
        String strI = ke.i((String) null);
        this.e = strI != null ? AbstractC4199im.a(strI) : null;
        this.g = ke.a(true);
        this.f = ke.b(0L);
        this.h = ke.n();
        c();
    }

    public final boolean a() {
        IdentifiersResult identifiersResult = (IdentifiersResult) this.b.get("appmetrica_clids");
        if (!a(identifiersResult) && identifiersResult.id.isEmpty()) {
            return In.a((Map) this.e);
        }
        return true;
    }

    public static boolean a(IdentifiersResult identifiersResult) {
        return identifiersResult == null || identifiersResult.id == null;
    }

    public final void a(String str, IdentifiersResult identifiersResult) {
        if (identifiersResult == null || TextUtils.isEmpty(identifiersResult.id)) {
            return;
        }
        this.b.put(str, identifiersResult);
    }

    public final synchronized boolean a(Collection collection) {
        Boolean bool;
        String str;
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            String str2 = (String) it.next();
            IdentifiersResult identifiersResult = (IdentifiersResult) this.b.get(str2);
            if (identifiersResult == null) {
                identifiersResult = (IdentifiersResult) this.l.c.get(str2);
            }
            if (identifiersResult == null) {
                C4038ca c4038ca = this.m.b;
                if (!Intrinsics.areEqual(str2, "appmetrica_lib_ssl_enabled") || (bool = c4038ca.f11492a) == null) {
                    identifiersResult = null;
                } else {
                    boolean zBooleanValue = bool.booleanValue();
                    IdentifierStatus identifierStatus = c4038ca.b;
                    String str3 = c4038ca.c;
                    if (zBooleanValue) {
                        str = "true";
                    } else if (!zBooleanValue) {
                        str = "false";
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                    identifiersResult = new IdentifiersResult(str, identifierStatus, str3);
                }
            }
            if ("appmetrica_clids".equals(str2)) {
                if (this.g || a(identifiersResult) || (identifiersResult.id.isEmpty() && !In.a((Map) this.e))) {
                    return false;
                }
            } else if ("appmetrica_lib_ssl_enabled".equals(str2)) {
                if (identifiersResult == null) {
                    return false;
                }
            } else if (identifiersResult == null || TextUtils.isEmpty(identifiersResult.id)) {
                return false;
            }
        }
        return true;
    }
}
