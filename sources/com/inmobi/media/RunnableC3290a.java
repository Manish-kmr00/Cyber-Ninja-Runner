package com.inmobi.media;

import android.os.Debug;
import com.json.mediationsdk.utils.IronSourceConstants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.inmobi.media.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes7.dex */
public final class RunnableC3290a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C3305b f3260a;

    public RunnableC3290a(C3305b c3305b) {
        this.f3260a = c3305b;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f3260a.d.get()) {
            if (this.f3260a.f.hasMessages(IronSourceConstants.IS_INSTANCE_COLLECT_TOKEN_TIMED_OUT)) {
                this.f3260a.f.removeMessages(IronSourceConstants.IS_INSTANCE_COLLECT_TOKEN_TIMED_OUT);
                this.f3260a.getClass();
                if (!Debug.isDebuggerConnected() && !Debug.waitingForDebugger() && this.f3260a.e.get()) {
                    StackTraceElement[] stackTraceElementArrA = C3305b.a(this.f3260a);
                    C3379g3 c3379g3 = this.f3260a.f3309a;
                    Intrinsics.checkNotNull(stackTraceElementArrA);
                    c3379g3.a(new gd(stackTraceElementArrA));
                }
            }
            this.f3260a.e.getAndSet(true);
            this.f3260a.f.sendEmptyMessage(IronSourceConstants.IS_INSTANCE_COLLECT_TOKEN_TIMED_OUT);
        }
    }
}
