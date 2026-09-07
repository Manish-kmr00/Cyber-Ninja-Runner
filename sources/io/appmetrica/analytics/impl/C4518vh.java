package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.services.PackageManagerUtils;
import io.appmetrica.analytics.coreutils.internal.time.TimePassedChecker;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.vh, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes8.dex */
public final class C4518vh extends C4282m5 {
    public final String v;
    public final L6 w;

    public C4518vh(Context context, C4108f5 c4108f5, F4 f4, L6 l6, Hl hl, AbstractC4232k5 abstractC4232k5, InterfaceC4585y9 interfaceC4585y9) {
        this(context, c4108f5, new C4078e0(), new TimePassedChecker(), new C4406r5(context, c4108f5, f4, abstractC4232k5, hl, new C4394qh(l6), C4486ua.j().w().d(), PackageManagerUtils.getAppVersionCodeInt(context), C4486ua.j().k(), interfaceC4585y9), l6, f4);
    }

    @Override // io.appmetrica.analytics.impl.C4282m5, io.appmetrica.analytics.impl.Wa, io.appmetrica.analytics.impl.La
    public final synchronized void a(F4 f4) {
        super.a(f4);
        this.w.a(this.v, f4.i);
    }

    public C4518vh(Context context, C4108f5 c4108f5, C4078e0 c4078e0, TimePassedChecker timePassedChecker, C4406r5 c4406r5, L6 l6, F4 f4) {
        super(context, c4108f5, c4078e0, timePassedChecker, c4406r5, f4);
        this.v = c4108f5.b();
        this.w = l6;
    }
}
