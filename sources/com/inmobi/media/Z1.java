package com.inmobi.media;

import android.os.Handler;
import android.os.Looper;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class Z1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC3308b2 f3251a;
    public final L4 b;

    public Z1(InterfaceC3308b2 mEventHandler, L4 l4) {
        Intrinsics.checkNotNullParameter(mEventHandler, "mEventHandler");
        this.f3251a = mEventHandler;
        this.b = l4;
    }

    public final void a(final T1 click) {
        Intrinsics.checkNotNullParameter(click, "click");
        click.i.set(false);
        final Handler handler = new Handler(Looper.getMainLooper());
        handler.post(new Runnable() { // from class: com.inmobi.media.Z1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                Z1.a(click, this, handler);
            }
        });
    }

    public static final void a(T1 click, Z1 this$0, Handler handler) {
        Intrinsics.checkNotNullParameter(click, "$click");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(handler, "$handler");
        S8 s8 = new S8(click.b, this$0.b);
        s8.x = false;
        s8.t = false;
        s8.u = false;
        HashMap mapA = C3364f2.a(C3364f2.f3308a, click);
        if (!mapA.isEmpty()) {
            s8.i.putAll(mapA);
        }
        new od(s8, new Y1(click, this$0, handler)).a();
    }
}
