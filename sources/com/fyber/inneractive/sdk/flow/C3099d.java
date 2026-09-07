package com.fyber.inneractive.sdk.flow;

import android.os.Handler;
import com.fyber.inneractive.sdk.util.IAlog;

/* JADX INFO: renamed from: com.fyber.inneractive.sdk.flow.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C3099d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Handler f1786a;
    public final com.fyber.inneractive.sdk.interfaces.b b;
    public final RunnableC3097b c = new RunnableC3097b(this);
    public final RunnableC3098c d = new RunnableC3098c(this);

    public C3099d(com.fyber.inneractive.sdk.interfaces.b bVar) {
        this.b = bVar;
    }

    public final void a() {
        IAlog.a("%s : ContentLoadTimeoutHandler destroying timeout handler", IAlog.a(this));
        if (this.f1786a != null) {
            IAlog.a("%s : ContentLoadTimeoutHandler stopping timeout handler", IAlog.a(this));
            Handler handler = this.f1786a;
            if (handler != null) {
                handler.removeCallbacks(this.d);
            }
            this.f1786a.getLooper().quitSafely();
            this.f1786a = null;
        }
    }
}
