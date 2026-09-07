package io.appmetrica.analytics.impl;

import android.content.Context;
import android.content.Intent;
import com.mbridge.msdk.out.reveue.MBridgeRevenueParamsEntity;
import kotlin.Unit;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.n6, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C4308n6 extends Eg {
    public final Context f;
    public final C4319nh g;
    public final C4264lc h;
    public final C4532w6 i;

    public C4308n6(Context context, C4178i0 c4178i0, Ck ck, C4319nh c4319nh) {
        super(c4178i0, ck, c4319nh);
        this.f = context;
        this.g = c4319nh;
        this.h = C4455t4.i().j();
        this.i = new C4532w6(context);
    }

    public final void a(C4319nh c4319nh) {
        if (c4319nh.f11686a.g != 0) {
            this.i.a(c4319nh);
            return;
        }
        Intent intentA = AbstractC4073dk.a(this.f);
        C3984a6 c3984a6 = c4319nh.f11686a;
        EnumC4164hb enumC4164hb = EnumC4164hb.EVENT_TYPE_UNDEFINED;
        c3984a6.d = 5890;
        intentA.putExtras(c3984a6.d(c4319nh.e.c()));
        try {
            this.f.startService(intentA);
        } catch (Throwable unused) {
            this.i.a(c4319nh);
        }
    }

    @Override // io.appmetrica.analytics.impl.AbstractCallableC4369ph
    public final boolean c() {
        a(this.g);
        return false;
    }

    @Override // io.appmetrica.analytics.impl.AbstractCallableC4369ph, java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() {
        a();
        return Unit.INSTANCE;
    }

    @Override // io.appmetrica.analytics.impl.AbstractCallableC4369ph
    public final synchronized void a() {
        if (this.c) {
            return;
        }
        this.c = true;
        if (this.h.a(MBridgeRevenueParamsEntity.ATTRIBUTION_PLATFORM_APP_METRICA)) {
            this.i.a(this.g);
        } else {
            this.f11724a.c();
            this.c = false;
            super.a();
        }
    }
}
