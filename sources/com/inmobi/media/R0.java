package com.inmobi.media;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class R0 extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f3178a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public R0(Looper looper) {
        super(looper);
        Intrinsics.checkNotNullParameter(looper, "looper");
        this.f3178a = true;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (U0.c) {
            return;
        }
        int i = msg.what;
        if (i == 1001 && this.f3178a) {
            this.f3178a = false;
            U0.a(U0.f3208a, false);
            Intrinsics.checkNotNullExpressionValue(U0.b(), "access$getTAG$p(...)");
        } else {
            if (i != 1002 || this.f3178a) {
                return;
            }
            this.f3178a = true;
            U0.a(U0.f3208a, true);
            Intrinsics.checkNotNullExpressionValue(U0.b(), "access$getTAG$p(...)");
        }
    }
}
