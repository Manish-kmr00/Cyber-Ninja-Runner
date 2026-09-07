package io.appmetrica.analytics.impl;

import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class P1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C4536wa f11289a = new C4536wa();
    public final LinkedHashMap b = new LinkedHashMap();
    public final LinkedHashMap c = new LinkedHashMap();

    public final void a() {
    }

    public final void a(Intent intent, int i) {
    }

    public final void a(Intent intent, int i, int i2) {
    }

    public final void a(Configuration configuration) {
    }

    public final void b() {
    }

    public final void c(Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            if (!TextUtils.isEmpty(action)) {
                this.f11289a.a(action, Integer.valueOf(a(intent)));
            }
            for (Map.Entry entry : this.b.entrySet()) {
                O1 o1 = (O1) entry.getKey();
                if (((N1) entry.getValue()).a(intent)) {
                    o1.a(intent);
                }
            }
        }
    }

    public final void d(Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            if (!TextUtils.isEmpty(action)) {
                C4536wa c4536wa = this.f11289a;
                Integer numValueOf = Integer.valueOf(a(intent));
                Collection collection = (Collection) c4536wa.f11830a.get(action);
                if (collection != null && collection.remove(numValueOf)) {
                    if (collection.isEmpty() && c4536wa.b) {
                        c4536wa.f11830a.remove(action);
                    }
                    new ArrayList(collection);
                }
            }
            for (Map.Entry entry : this.c.entrySet()) {
                O1 o1 = (O1) entry.getKey();
                if (((N1) entry.getValue()).a(intent)) {
                    o1.a(intent);
                }
            }
        }
    }

    public final void b(Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            if (!TextUtils.isEmpty(action)) {
                this.f11289a.a(action, Integer.valueOf(a(intent)));
            }
            for (Map.Entry entry : this.b.entrySet()) {
                O1 o1 = (O1) entry.getKey();
                if (((N1) entry.getValue()).a(intent)) {
                    o1.a(intent);
                }
            }
        }
    }

    public final void a(O1 o1) {
        this.c.put(o1, new N1() { // from class: io.appmetrica.analytics.impl.P1$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.impl.N1
            public final boolean a(Intent intent) {
                return P1.a(this.f$0, intent);
            }
        });
    }

    public static final boolean a(P1 p1, Intent intent) {
        Collection collection;
        p1.getClass();
        return Intrinsics.areEqual("io.appmetrica.analytics.IAppMetricaService", intent.getAction()) && ((collection = (Collection) p1.f11289a.f11830a.get("io.appmetrica.analytics.IAppMetricaService")) == null || collection.size() == 0);
    }

    public static int a(Intent intent) {
        Uri data = intent.getData();
        if (data != null && Intrinsics.areEqual(data.getPath(), "/client")) {
            try {
                String queryParameter = data.getQueryParameter("pid");
                Intrinsics.checkNotNull(queryParameter);
                return Integer.parseInt(queryParameter);
            } catch (Throwable unused) {
            }
        }
        return -1;
    }

    public final void c(O1 o1) {
        this.b.put(o1, new N1() { // from class: io.appmetrica.analytics.impl.P1$$ExternalSyntheticLambda2
            @Override // io.appmetrica.analytics.impl.N1
            public final boolean a(Intent intent) {
                return P1.c(this.f$0, intent);
            }
        });
    }

    public static final boolean c(P1 p1, Intent intent) {
        p1.getClass();
        return Intrinsics.areEqual("io.appmetrica.analytics.IAppMetricaService", intent.getAction());
    }

    public final void b(O1 o1) {
        this.b.put(o1, new N1() { // from class: io.appmetrica.analytics.impl.P1$$ExternalSyntheticLambda1
            @Override // io.appmetrica.analytics.impl.N1
            public final boolean a(Intent intent) {
                return P1.b(this.f$0, intent);
            }
        });
    }

    public static final boolean b(P1 p1, Intent intent) {
        Collection collection;
        p1.getClass();
        return Intrinsics.areEqual("io.appmetrica.analytics.IAppMetricaService", intent.getAction()) && (collection = (Collection) p1.f11289a.f11830a.get("io.appmetrica.analytics.IAppMetricaService")) != null && collection.size() == 1;
    }
}
