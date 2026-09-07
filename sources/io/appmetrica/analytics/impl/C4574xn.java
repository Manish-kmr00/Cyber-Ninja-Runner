package io.appmetrica.analytics.impl;

import android.text.TextUtils;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.xn, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C4574xn extends Gg {
    public C4574xn(C4282m5 c4282m5) {
        super(c4282m5);
    }

    @Override // io.appmetrica.analytics.impl.Gg
    public final boolean a(C3984a6 c3984a6) {
        String strI = this.f11164a.c.i();
        String str = c3984a6.h;
        this.f11164a.c.j(str).b();
        if (TextUtils.equals(strI, str)) {
            return false;
        }
        this.f11164a.a(C4082e4.o());
        return false;
    }
}
