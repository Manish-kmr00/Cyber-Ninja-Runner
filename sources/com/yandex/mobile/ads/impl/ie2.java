package com.yandex.mobile.ads.impl;

import android.os.Handler;
import android.os.Looper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class ie2 implements ne2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Handler f9208a = new Handler(Looper.getMainLooper());
    private iu b;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(ie2 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        iu iuVar = this$0.b;
        if (iuVar != null) {
            iuVar.onVideoComplete();
        }
    }

    @Override // com.yandex.mobile.ads.impl.ne2
    public final void onVideoComplete() {
        this.f9208a.post(new Runnable() { // from class: com.yandex.mobile.ads.impl.ie2$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                ie2.a(this.f$0);
            }
        });
    }

    public final void a(jn2 jn2Var) {
        this.b = jn2Var;
    }
}
