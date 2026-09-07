package io.appmetrica.analytics.impl;

import androidx.fragment.app.FragmentTransaction;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.uc, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes8.dex */
public final class C4488uc implements Zf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C4513vc f11799a;

    public C4488uc(C4513vc c4513vc) {
        this.f11799a = c4513vc;
    }

    @Override // io.appmetrica.analytics.impl.Zf
    public final void a(C4044cg c4044cg) {
        if (c4044cg == null) {
            return;
        }
        C3984a6 c3984a6 = new C3984a6("", "", 0);
        c3984a6.setValueBytes(c4044cg.a());
        EnumC4164hb enumC4164hb = EnumC4164hb.EVENT_TYPE_UNDEFINED;
        c3984a6.d = FragmentTransaction.TRANSIT_FRAGMENT_OPEN;
        this.f11799a.a(c3984a6);
    }
}
