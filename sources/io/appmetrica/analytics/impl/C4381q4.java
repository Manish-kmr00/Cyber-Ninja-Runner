package io.appmetrica.analytics.impl;

import android.os.Bundle;
import io.appmetrica.analytics.coreapi.internal.identifiers.SdkIdentifiers;
import io.appmetrica.analytics.modulesapi.internal.client.ModuleClientEntryPoint;
import io.appmetrica.analytics.modulesapi.internal.client.ServiceConfigExtensionConfiguration;
import io.appmetrica.analytics.modulesapi.internal.client.ServiceConfigUpdateListener;
import io.appmetrica.analytics.modulesapi.internal.client.adrevenue.ModuleAdRevenueProcessor;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.ExceptionsKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.q4, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes8.dex */
public final class C4381q4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C4356p4 f11730a = new C4356p4();
    public final CopyOnWriteArrayList b = new CopyOnWriteArrayList();
    public S5 c;

    public static void a(String str, String str2, Throwable th) {
        Fj fj = AbstractC4097ej.f11536a;
        Map mapMapOf = MapsKt.mapOf(TuplesKt.to(str, MapsKt.mapOf(TuplesKt.to(str2, ExceptionsKt.stackTraceToString(th)))));
        fj.getClass();
        fj.a(new Ej("client_module_errors", mapMapOf));
    }

    public final void b() {
        for (ModuleClientEntryPoint moduleClientEntryPoint : this.b) {
            try {
                moduleClientEntryPoint.onActivated();
            } catch (Throwable th) {
                a(moduleClientEntryPoint.getIdentifier(), "onActivated", th);
            }
        }
    }

    public final void a(ModuleClientEntryPoint<Object> moduleClientEntryPoint) {
        this.b.add(moduleClientEntryPoint);
    }

    public final void a(S5 s5) {
        this.c = s5;
        HashSet hashSet = new HashSet();
        for (ModuleClientEntryPoint moduleClientEntryPoint : this.b) {
            try {
                moduleClientEntryPoint.initClientSide(s5);
            } catch (Throwable th) {
                a(moduleClientEntryPoint.getIdentifier(), "initClientSide", th);
                hashSet.add(moduleClientEntryPoint);
            }
        }
        this.b.removeAll(hashSet);
    }

    public final ModuleAdRevenueProcessor a() {
        V5 v5;
        S5 s5 = this.c;
        if (s5 == null || (v5 = ((C4032c4) s5).b) == null) {
            return null;
        }
        return v5.b;
    }

    public final void a(Bundle bundle, SdkIdentifiers sdkIdentifiers) {
        if (bundle == null) {
            return;
        }
        for (ModuleClientEntryPoint moduleClientEntryPoint : this.b) {
            try {
                ServiceConfigExtensionConfiguration serviceConfigExtensionConfiguration = moduleClientEntryPoint.getServiceConfigExtensionConfiguration();
                if (serviceConfigExtensionConfiguration != null) {
                    ServiceConfigUpdateListener serviceConfigUpdateListener = serviceConfigExtensionConfiguration.getServiceConfigUpdateListener();
                    C4356p4 c4356p4 = this.f11730a;
                    String identifier = moduleClientEntryPoint.getIdentifier();
                    c4356p4.getClass();
                    Bundle bundle2 = bundle.getBundle(identifier);
                    C4331o4 c4331o4 = bundle2 != null ? new C4331o4(sdkIdentifiers, serviceConfigExtensionConfiguration.getBundleConverter().fromBundle(bundle2)) : null;
                    if (c4331o4 != null) {
                        serviceConfigUpdateListener.onServiceConfigUpdated(c4331o4);
                    }
                }
            } catch (Throwable th) {
                a(moduleClientEntryPoint.getIdentifier(), "notifyModulesWithConfig", th);
            }
        }
    }
}
