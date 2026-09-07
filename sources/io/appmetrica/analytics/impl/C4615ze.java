package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.servicecomponents.ActivationBarrierCallback;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.ze, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C4615ze implements Ac {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C4613zc f11876a;
    public final C4613zc b;

    public C4615ze(final InterfaceC4560x9 interfaceC4560x9, Fg fg, F4 f4, Le le) {
        C4613zc c4613zc = new C4613zc(fg, f4, le);
        this.f11876a = c4613zc;
        this.b = c4613zc;
        if (c4613zc.b()) {
            return;
        }
        C4486ua.j().a().subscribe(TimeUnit.SECONDS.toMillis(O7.f11280a.longValue()), C4486ua.j().w().a(), new ActivationBarrierCallback() { // from class: io.appmetrica.analytics.impl.ze$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.coreapi.internal.servicecomponents.ActivationBarrierCallback
            public final void onWaitFinished() {
                C4615ze.a(this.f$0, interfaceC4560x9);
            }
        });
    }

    @Override // io.appmetrica.analytics.impl.Ac
    public final J8 a() {
        return this.b;
    }

    public static final void a(C4615ze c4615ze, InterfaceC4560x9 interfaceC4560x9) {
        c4615ze.f11876a.a();
        ((C4556x5) interfaceC4560x9.a()).d();
    }
}
