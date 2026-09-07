package com.yandex.div.core.timer;

import android.os.Handler;
import android.os.Looper;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FixedRateScheduler.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006J$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/yandex/div/core/timer/FixedRateScheduler;", "", "()V", "handler", "Landroid/os/Handler;", TimerController.CANCEL_COMMAND, "", "scheduleAtFixedRate", "initialDelay", "", TypedValues.CycleType.S_WAVE_PERIOD, "onTick", "Lkotlin/Function0;", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class FixedRateScheduler {
    private final Handler handler = new Handler(Looper.getMainLooper());

    public final void scheduleAtFixedRate(long initialDelay, final long period, final Function0<Unit> onTick) {
        Intrinsics.checkNotNullParameter(onTick, "onTick");
        this.handler.postDelayed(new Runnable() { // from class: com.yandex.div.core.timer.FixedRateScheduler.scheduleAtFixedRate.1
            @Override // java.lang.Runnable
            public void run() {
                FixedRateScheduler.this.handler.postDelayed(this, period);
                onTick.invoke();
            }
        }, initialDelay);
    }

    public final void cancel() {
        this.handler.removeCallbacksAndMessages(null);
    }
}
