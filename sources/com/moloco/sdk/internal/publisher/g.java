package com.moloco.sdk.internal.publisher;

import com.moloco.sdk.acm.TimerEvent;
import com.moloco.sdk.publisher.AdFormatType;
import com.moloco.sdk.publisher.AdLoad;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class g {
    public static final x a(AdLoad.Listener listener, TimerEvent acmLoadTimerEvent, AdFormatType adFormatType) {
        Intrinsics.checkNotNullParameter(acmLoadTimerEvent, "acmLoadTimerEvent");
        Intrinsics.checkNotNullParameter(adFormatType, "adFormatType");
        return new f(listener, com.moloco.sdk.internal.y.a(), acmLoadTimerEvent, adFormatType);
    }
}
