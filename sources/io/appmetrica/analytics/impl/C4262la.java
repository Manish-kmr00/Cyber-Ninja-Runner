package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.ServiceComponentsInitializer;
import io.appmetrica.analytics.coreutils.internal.reflection.ReflectionUtils;
import io.appmetrica.analytics.modulesapi.internal.service.ModuleServiceEntryPoint;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.la, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C4262la {
    public static final C4262la d = new C4262la();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C4439sd f11649a = new C4439sd();
    public final ServiceComponentsInitializer b = Mj.a();
    public boolean c = false;

    public final void a(Context context) {
        C4486ua.a(context);
        this.b.onCreate(context);
        this.f11649a.getClass();
        for (String str : C4486ua.E.s.a()) {
            ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
            Object objLoadAndInstantiateClassWithDefaultConstructor = ReflectionUtils.loadAndInstantiateClassWithDefaultConstructor(str, ModuleServiceEntryPoint.class);
            if (objLoadAndInstantiateClassWithDefaultConstructor != null) {
                C4486ua.E.o().a((ModuleServiceEntryPoint<Object>) objLoadAndInstantiateClassWithDefaultConstructor);
            }
        }
        new Xj(C4486ua.j().B().b()).a(context);
        C4486ua.E.p().a();
    }

    public final void b(Context context) {
        if (this.c) {
            return;
        }
        synchronized (this) {
            if (!this.c) {
                a(context);
                this.c = true;
            }
        }
    }
}
