package com.ogury.ad.internal;

import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes3.dex */
public final class g4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SharedPreferences f7305a;
    public final Object b;
    public final ArrayList c;

    public g4(SharedPreferences sharedPrefs) {
        ArrayList arrayList;
        e4 monitoringEventParser = new e4();
        Intrinsics.checkNotNullParameter(sharedPrefs, "sharedPrefs");
        Intrinsics.checkNotNullParameter(monitoringEventParser, "monitoringEventParser");
        this.f7305a = sharedPrefs;
        Object obj = new Object();
        this.b = obj;
        this.c = new ArrayList();
        synchronized (obj) {
            int i = sharedPrefs.getInt("monitoring_version", 0);
            if (1 > i || i >= 2) {
                a();
            } else {
                try {
                    arrayList = e4.a(sharedPrefs.getString("monitoring", "[]"));
                } catch (Exception unused) {
                    arrayList = new ArrayList();
                }
                this.c = arrayList;
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void a() {
        synchronized (this.b) {
            this.c.clear();
            this.f7305a.edit().clear().apply();
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void a(final ArrayList events) {
        Intrinsics.checkNotNullParameter(events, "events");
        Function0 callable = new Function0() { // from class: com.ogury.ad.internal.g4$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return g4.a(this.f$0, events);
            }
        };
        Intrinsics.checkNotNullParameter(callable, "callable");
        v8 v8Var = new v8(callable, 0);
        Function1<? super d9, Unit> consumer = new Function1() { // from class: com.ogury.ad.internal.g4$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return g4.a((d9) obj);
            }
        };
        Intrinsics.checkNotNullParameter(consumer, "consumer");
        v8Var.c = consumer;
        v8Var.b(new Function1() { // from class: com.ogury.ad.internal.g4$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return g4.a(this.f$0, (JSONArray) obj);
            }
        });
    }

    public static final JSONArray a(g4 g4Var, List list) {
        List events;
        synchronized (g4Var.b) {
            events = CollectionsKt.toList(list);
        }
        Intrinsics.checkNotNullParameter(events, "events");
        JSONArray jSONArray = new JSONArray();
        Iterator it = events.iterator();
        while (it.hasNext()) {
            try {
                jSONArray.put(f3.a((b4) it.next()));
            } catch (Exception unused) {
                u3.f7411a.getClass();
            }
        }
        return jSONArray;
    }

    public static final Unit a(d9 throwable) {
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        u3.f7411a.getClass();
        return Unit.INSTANCE;
    }

    public static final Unit a(g4 g4Var, JSONArray jsonEvents) {
        Intrinsics.checkNotNullParameter(jsonEvents, "jsonEvents");
        g4Var.f7305a.edit().putInt("monitoring_version", 1).putString("monitoring", jsonEvents.toString()).apply();
        return Unit.INSTANCE;
    }
}
