package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.control.Toggle;
import io.appmetrica.analytics.coreapi.internal.control.ToggleObserver;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.locationapi.internal.LocationControllerObserver;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class Xb implements Ub, ToggleObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f11416a = new ArrayList();
    public final IHandlerExecutor b = C4486ua.j().w().c();
    public C4176hn c;
    public boolean d;

    public final void a(Toggle toggle) {
        C4176hn c4176hn = new C4176hn(toggle);
        this.c = c4176hn;
        c4176hn.c.registerObserver(this, true);
    }

    public final void b(Object obj) {
        C4176hn c4176hn = this.c;
        if (c4176hn == null) {
            Intrinsics.throwUninitializedPropertyAccessException("togglesHolder");
            c4176hn = null;
        }
        c4176hn.b.b(obj);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.control.ToggleObserver
    public final void onStateChanged(final boolean z) {
        this.b.execute(new Runnable() { // from class: io.appmetrica.analytics.impl.Xb$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                Xb.a(this.f$0, z);
            }
        });
    }

    public final void a(final LocationControllerObserver locationControllerObserver, final boolean z) {
        this.b.execute(new Runnable() { // from class: io.appmetrica.analytics.impl.Xb$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                Xb.a(this.f$0, locationControllerObserver, z);
            }
        });
    }

    public static final void a(Xb xb, LocationControllerObserver locationControllerObserver, boolean z) {
        xb.f11416a.add(locationControllerObserver);
        if (z) {
            if (xb.d) {
                locationControllerObserver.startLocationTracking();
            } else {
                locationControllerObserver.stopLocationTracking();
            }
        }
    }

    public static final void a(Xb xb, boolean z) {
        if (xb.d != z) {
            xb.d = z;
            Function1 function1 = z ? Vb.f11391a : Wb.f11404a;
            Iterator it = xb.f11416a.iterator();
            while (it.hasNext()) {
                function1.invoke((LocationControllerObserver) it.next());
            }
        }
    }

    public final void a(Object obj) {
        C4176hn c4176hn = this.c;
        if (c4176hn == null) {
            Intrinsics.throwUninitializedPropertyAccessException("togglesHolder");
            c4176hn = null;
        }
        c4176hn.b.a(obj);
    }

    public final void a(boolean z) {
        C4176hn c4176hn = this.c;
        if (c4176hn == null) {
            Intrinsics.throwUninitializedPropertyAccessException("togglesHolder");
            c4176hn = null;
        }
        c4176hn.f11590a.a(z);
    }
}
