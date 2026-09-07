package com.fyber.inneractive.sdk.config;

import android.os.Handler;
import android.os.Message;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.v0;
import com.fyber.inneractive.sdk.util.x0;

/* JADX INFO: renamed from: com.fyber.inneractive.sdk.config.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes13.dex */
public final class C3072b implements Handler.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C3075e f1685a;

    public C3072b(C3075e c3075e) {
        this.f1685a = c3075e;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        if (message.what != 123) {
            return false;
        }
        C3075e c3075e = this.f1685a;
        if (c3075e.f1692a.compareAndSet(false, true)) {
            if (c3075e.f1692a.get() && c3075e.c != null) {
                IAlog.a("startCounting", new Object[0]);
                x0 x0Var = c3075e.c;
                x0Var.getClass();
                v0 v0Var = new v0(x0Var);
                x0Var.c = v0Var;
                x0Var.d = false;
                v0Var.sendEmptyMessage(1932593528);
            }
            IAlog.a("Pause signal", new Object[0]);
        }
        return true;
    }
}
