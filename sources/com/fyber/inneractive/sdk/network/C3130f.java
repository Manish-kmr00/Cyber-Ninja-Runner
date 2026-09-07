package com.fyber.inneractive.sdk.network;

import android.app.Application;
import android.os.HandlerThread;
import java.util.concurrent.LinkedBlockingQueue;
import org.json.JSONArray;

/* JADX INFO: renamed from: com.fyber.inneractive.sdk.network.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
public final class C3130f implements com.fyber.inneractive.sdk.util.f0 {
    public com.fyber.inneractive.sdk.util.e0 d;
    public int e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedBlockingQueue f1921a = new LinkedBlockingQueue();
    public JSONArray b = new JSONArray();
    public boolean f = false;
    public boolean g = false;
    public final HandlerThread c = new HandlerThread("EventCollectorHandlerThread", 0);

    public final void a(Application application) {
        if (!this.g) {
            this.g = true;
            this.c.start();
            com.fyber.inneractive.sdk.util.e0 e0Var = new com.fyber.inneractive.sdk.util.e0(this.c.getLooper(), this);
            this.d = e0Var;
            this.f = true;
            this.e = 30;
            if (e0Var.hasMessages(12312329)) {
                this.d.removeMessages(12312329);
            }
            long j = this.e * 1000;
            com.fyber.inneractive.sdk.util.e0 e0Var2 = this.d;
            if (e0Var2 != null) {
                e0Var2.post(new RunnableC3127c(this, 12312329, j));
            }
        }
        application.registerActivityLifecycleCallbacks(new C3128d(this));
    }
}
