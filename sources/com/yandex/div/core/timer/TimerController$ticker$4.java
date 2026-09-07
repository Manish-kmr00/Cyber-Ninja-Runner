package com.yandex.div.core.timer;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: compiled from: TimerController.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
/* synthetic */ class TimerController$ticker$4 extends FunctionReferenceImpl implements Function1<Long, Unit> {
    TimerController$ticker$4(Object obj) {
        super(1, obj, TimerController.class, "onTick", "onTick(J)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Long l) {
        invoke(l.longValue());
        return Unit.INSTANCE;
    }

    public final void invoke(long j) {
        ((TimerController) this.receiver).onTick(j);
    }
}
