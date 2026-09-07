package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.AppMetricaConfig;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.qb, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes8.dex */
public final class C4388qb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C4204j2 f11735a = new C4204j2();
    public final C4482u6 b = new C4482u6();
    public Wm c;
    public boolean d;
    public boolean e;

    public final synchronized void a(Context context, AppMetricaConfig appMetricaConfig, InterfaceC3989ab interfaceC3989ab) {
        if (this.e) {
            return;
        }
        CollectionsKt.addAll(this.b.f11793a, new Ma[]{this.f11735a.a(context, appMetricaConfig, interfaceC3989ab)});
        this.e = true;
    }

    public final synchronized void b() {
        if (this.d) {
            return;
        }
        C4482u6 c4482u6 = this.b;
        ArrayList arrayList = C4455t4.i().i.f11231a;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        if (it.hasNext()) {
            it.next().getClass();
            throw new ClassCastException();
        }
        c4482u6.f11793a.addAll(arrayList2);
        this.d = true;
    }

    public final synchronized void c() {
        if (this.c != null) {
            return;
        }
        S1 s1 = new S1(this.b);
        this.c = new Wm(s1);
        Vm vm = new Vm();
        vm.f11396a.add(s1);
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler != null) {
            vm.f11396a.add(defaultUncaughtExceptionHandler);
        }
        Thread.setDefaultUncaughtExceptionHandler(vm);
    }

    public final synchronized void a() {
        this.b.f11793a.clear();
        this.d = false;
        this.e = false;
    }
}
