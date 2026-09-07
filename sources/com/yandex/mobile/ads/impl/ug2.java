package com.yandex.mobile.ads.impl;

import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes11.dex */
final class ug2 extends Lambda implements Function2<fy.h.a, Boolean, Unit> {
    final /* synthetic */ zg2 b;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f10384a;

        static {
            int[] iArr = new int[fy.h.a.values().length];
            try {
                fy.h.a aVar = fy.h.a.DEBUG_ERROR_INDICATOR;
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f10384a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ug2(zg2 zg2Var) {
        super(2);
        this.b = zg2Var;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Unit invoke(fy.h.a aVar, Boolean bool) {
        fy.h.a switchType = aVar;
        boolean zBooleanValue = bool.booleanValue();
        Intrinsics.checkNotNullParameter(switchType, "switchType");
        if (a.f10384a[switchType.ordinal()] == 1) {
            this.b.f10816a.invoke(new zx.e(zBooleanValue));
        }
        return Unit.INSTANCE;
    }
}
