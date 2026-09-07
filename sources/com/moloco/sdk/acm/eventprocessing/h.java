package com.moloco.sdk.acm.eventprocessing;

import com.moloco.sdk.acm.CountEvent;
import com.moloco.sdk.acm.TimerEvent;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes10.dex */
public interface h {
    Object a(CountEvent countEvent, Continuation<? super Unit> continuation);

    Object a(TimerEvent timerEvent, Continuation<? super Unit> continuation);
}
