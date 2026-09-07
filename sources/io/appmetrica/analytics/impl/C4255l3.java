package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.billinginterface.internal.BillingType;
import io.appmetrica.analytics.billinginterface.internal.monitor.BillingMonitor;
import io.appmetrica.analytics.billinginterface.internal.storage.BillingInfoSender;
import io.appmetrica.analytics.billinginterface.internal.storage.BillingInfoStorage;
import io.appmetrica.analytics.billingv6.internal.BillingLibraryMonitor;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.applicationstate.ApplicationState;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.applicationstate.ApplicationStateProvider;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
import java.util.concurrent.Executor;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.l3, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C4255l3 implements Ml {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BillingMonitor f11642a;
    public final Context b;
    public final Executor c;
    public final Executor d;
    public final BillingType e;
    public final BillingInfoStorage f;
    public final BillingInfoSender g;
    public final ApplicationStateProvider h;
    public final C4205j3 i;

    public C4255l3(Context context, Executor executor, Executor executor2, BillingType billingType, BillingInfoStorage billingInfoStorage, BillingInfoSender billingInfoSender) {
        this(context, executor, executor2, billingType, billingInfoStorage, billingInfoSender, C4486ua.j().d(), new C4205j3());
    }

    public final void a(Hl hl, Boolean bool) {
        BillingMonitor c3986a8;
        if (((Boolean) WrapUtils.getOrDefault(bool, Boolean.TRUE)).booleanValue()) {
            synchronized (this) {
                C4205j3 c4205j3 = this.i;
                Context context = this.b;
                Executor executor = this.c;
                Executor executor2 = this.d;
                BillingType billingType = this.e;
                BillingInfoStorage billingInfoStorage = this.f;
                BillingInfoSender billingInfoSender = this.g;
                c4205j3.getClass();
                if (AbstractC4181i3.f11594a[billingType.ordinal()] == 1) {
                    c3986a8 = new BillingLibraryMonitor(context, executor, executor2, billingInfoStorage, billingInfoSender, null, null, 96, null);
                } else {
                    c3986a8 = new C3986a8();
                }
                this.f11642a = c3986a8;
            }
            c3986a8.onBillingConfigChanged(hl.x);
            if (this.h.registerStickyObserver(new C4230k3(this)) == ApplicationState.VISIBLE) {
                try {
                    BillingMonitor billingMonitor = this.f11642a;
                    if (billingMonitor != null) {
                        billingMonitor.onSessionResumed();
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public C4255l3(Context context, Executor executor, Executor executor2, BillingType billingType, BillingInfoStorage billingInfoStorage, BillingInfoSender billingInfoSender, ApplicationStateProvider applicationStateProvider, C4205j3 c4205j3) {
        this.b = context;
        this.c = executor;
        this.d = executor2;
        this.e = billingType;
        this.f = billingInfoStorage;
        this.g = billingInfoSender;
        this.h = applicationStateProvider;
        this.i = c4205j3;
    }

    @Override // io.appmetrica.analytics.impl.Ml
    public final synchronized void a(Hl hl) {
        BillingMonitor billingMonitor;
        synchronized (this) {
            billingMonitor = this.f11642a;
        }
        if (billingMonitor != null) {
            billingMonitor.onBillingConfigChanged(hl.x);
        }
    }
}
