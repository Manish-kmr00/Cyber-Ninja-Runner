package com.inmobi.media;

import android.os.HandlerThread;
import android.os.Looper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.inmobi.media.l4, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C3452l4 {
    public static final /* synthetic */ int b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HandlerC3436k4 f3366a;

    public C3452l4() {
        HandlerThread handlerThread = new HandlerThread("DataCollectionHandler");
        U3.a(handlerThread, "DataCollectionHandler");
        Looper looper = handlerThread.getLooper();
        Intrinsics.checkNotNullExpressionValue(looper, "getLooper(...)");
        this.f3366a = new HandlerC3436k4(looper);
    }

    public final synchronized void a() {
        if (sd.b()) {
            HandlerC3436k4 handlerC3436k4 = this.f3366a;
            handlerC3436k4.f3356a = false;
            if (handlerC3436k4.hasMessages(3)) {
                Intrinsics.checkNotNullExpressionValue("l4", "TAG");
            } else {
                this.f3366a.removeMessages(2);
                this.f3366a.sendEmptyMessage(1);
            }
        }
    }
}
