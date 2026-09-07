package com.inmobi.media;

import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes7.dex */
public final class T5 extends Lambda implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ U5 f3201a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public T5(U5 u5) {
        super(2);
        this.f3201a = u5;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        String trackerName = (String) obj;
        Map macros = (Map) obj2;
        Intrinsics.checkNotNullParameter(trackerName, "trackerName");
        Intrinsics.checkNotNullParameter(macros, "macros");
        C3614wa c3614wa = this.f3201a.d;
        if (c3614wa != null) {
            Intrinsics.checkNotNullParameter(trackerName, "trackerName");
            Intrinsics.checkNotNullParameter(macros, "macros");
            Ba ba = c3614wa.f3467a;
            if (!ba.e) {
                ba.a(trackerName, macros);
            }
        }
        return Unit.INSTANCE;
    }
}
