package com.yandex.mobile.ads.impl;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes13.dex */
final class tg2 extends Lambda implements Function1<fy.c.a, Unit> {
    public static final tg2 b = new tg2();

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f10298a;

        static {
            int[] iArr = new int[fy.c.a.values().length];
            try {
                fy.c.a aVar = fy.c.a.TEST_MODE;
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f10298a = iArr;
        }
    }

    tg2() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(fy.c.a aVar) {
        fy.c.a actionType = aVar;
        Intrinsics.checkNotNullParameter(actionType, "actionType");
        int i = a.f10298a[actionType.ordinal()];
        return Unit.INSTANCE;
    }
}
