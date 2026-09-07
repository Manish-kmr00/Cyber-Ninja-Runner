package io.appmetrica.analytics.impl;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes5.dex */
public final class Li extends Gg {
    public Li(C4282m5 c4282m5) {
        super(c4282m5);
    }

    @Override // io.appmetrica.analytics.impl.Gg
    public final boolean a(C3984a6 c3984a6) {
        String str = c3984a6.h;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        this.f11164a.c.j(str).b();
        return false;
    }
}
