package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.billinginterface.internal.BillingType;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.coreutils.internal.reflection.ReflectionUtils;
import java.lang.reflect.Field;
import java.util.Objects;
import java.util.concurrent.Executor;
import kotlin.text.StringsKt;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.xc, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C4563xc extends C4406r5 {
    public final Uj n;

    public C4563xc(Context context, C4108f5 c4108f5, F4 f4, AbstractC4232k5 abstractC4232k5, Hl hl, Zg zg, ICommonExecutor iCommonExecutor, int i, Uj uj, Kb kb, InterfaceC4585y9 interfaceC4585y9) {
        super(context, c4108f5, f4, abstractC4232k5, hl, zg, iCommonExecutor, i, kb, interfaceC4585y9);
        this.n = uj;
    }

    public final C4255l3 a(C4513vc c4513vc) {
        String str;
        BillingType billingType;
        Field field;
        Context context = this.c;
        IHandlerExecutor iHandlerExecutorA = this.n.a();
        Executor executorF = this.n.f();
        try {
            Class<?> clsFindClass = ReflectionUtils.findClass("com.android.billingclient.BuildConfig");
            str = (String) ((clsFindClass == null || (field = clsFindClass.getField(com.safedk.android.analytics.brandsafety.creatives.discoveries.t.e)) == null) ? null : field.get(null));
        } catch (Throwable unused) {
            str = null;
        }
        if (str == null || StringsKt.isBlank(str) || StringsKt.startsWith$default(str, "2.", false, 2, (Object) null) || StringsKt.startsWith$default(str, "3.", false, 2, (Object) null) || StringsKt.startsWith$default(str, "4.", false, 2, (Object) null)) {
            billingType = BillingType.NONE;
        } else {
            billingType = (!StringsKt.startsWith$default(str, "5.", false, 2, (Object) null) && StringsKt.startsWith$default(str, "6.", false, 2, (Object) null)) ? BillingType.LIBRARY_V6 : BillingType.LIBRARY_V6;
        }
        return new C4255l3(context, iHandlerExecutorA, executorF, billingType, new C4156h3(C4448sm.a(C4478u2.class).a(this.c)), new C4131g3(c4513vc, C4486ua.j().w().e()));
    }

    public final C4094eg b(C4513vc c4513vc) {
        C4042ce c4042ce = new C4042ce(c4513vc);
        Objects.requireNonNull(c4513vc);
        return new C4094eg(c4042ce, new C4488uc(c4513vc), c4513vc);
    }

    @Override // io.appmetrica.analytics.impl.C4406r5
    public final InterfaceC4535w9 a(B9 b9, S6 s6, Fg fg, F4 f4, C4108f5 c4108f5, Le le) {
        return this.l.a(b9, s6, fg, f4, c4108f5, le).a();
    }
}
