package com.inmobi.media;

import android.os.Handler;
import android.os.Looper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class Fa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Ba f3072a;
    public final long b;

    public Fa(Ba view, long j) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.f3072a = view;
        this.b = j;
    }

    public final void a() {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.inmobi.media.Fa$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                Fa.a(this.f$0);
            }
        }, this.b);
    }

    public static final void a(Fa this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Ba ba = this$0.f3072a;
        if (ba != null) {
            L4 l4 = ba.i;
            if (l4 != null) {
                String str = Ba.O0;
                ((M4) l4).a(str, AbstractC3474ma.a(ba, str, "TAG", "deferredDestroy "));
            }
            ba.destroy();
        }
        this$0.f3072a = null;
    }
}
