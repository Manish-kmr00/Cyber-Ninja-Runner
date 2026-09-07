package com.fyber.inneractive.sdk.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes4.dex */
public final class v0 extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference f2380a;

    public v0(x0 x0Var) {
        super(Looper.getMainLooper());
        this.f2380a = new WeakReference(x0Var);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        super.handleMessage(message);
        x0 x0Var = (x0) this.f2380a.get();
        if (x0Var == null || message.what != 1932593528 || x0Var.d) {
            return;
        }
        x0Var.a(message.getWhen());
    }
}
