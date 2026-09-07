package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.WrapUtils;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import io.appmetrica.analytics.coreutils.internal.time.TimeProvider;
import org.json.JSONObject;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.eh, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
public final class C4095eh extends Gg {
    public final Cif b;
    public final Un c;
    public final SafePackageManager d;
    public final TimeProvider e;

    public C4095eh(C4282m5 c4282m5) {
        this(c4282m5, c4282m5.t(), C4486ua.j().s(), new SafePackageManager(), new SystemTimeProvider());
    }

    @Override // io.appmetrica.analytics.impl.Gg
    public final boolean a(C3984a6 c3984a6) {
        C4282m5 c4282m5 = this.f11164a;
        if (this.c.d()) {
            return false;
        }
        C3984a6 c3984a6A = ((C4045ch) c4282m5.k.a()).e ? C3984a6.a(c3984a6, EnumC4164hb.EVENT_TYPE_APP_UPDATE) : C3984a6.a(c3984a6, EnumC4164hb.EVENT_TYPE_INIT);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appInstaller", (String) WrapUtils.getOrDefault(this.d.getInstallerPackageName(c4282m5.f11664a, c4282m5.b.f11544a), ""));
            Cif cif = this.b;
            cif.h.a(cif.f11375a);
            jSONObject.put("preloadInfo", ((C4118ff) cif.c()).b());
        } catch (Throwable unused) {
        }
        c3984a6A.setValue(jSONObject.toString());
        C4386q9 c4386q9 = c4282m5.n;
        c4386q9.a(c3984a6A, C4521vk.a(c4386q9.c.b(c3984a6A), c3984a6A.i));
        Un un = this.c;
        synchronized (un) {
            Vn vn = un.f11384a;
            vn.a(vn.a().put("init_event_done", true));
        }
        this.c.a(this.e.currentTimeMillis());
        return false;
    }

    public C4095eh(C4282m5 c4282m5, Un un, Cif cif, SafePackageManager safePackageManager, SystemTimeProvider systemTimeProvider) {
        super(c4282m5);
        this.c = un;
        this.b = cif;
        this.d = safePackageManager;
        this.e = systemTimeProvider;
    }
}
