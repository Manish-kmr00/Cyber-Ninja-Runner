package com.mbridge.msdk.foundation.tools;

import com.mbridge.msdk.MBridgeConstans;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: LimitExecutor.java */
/* JADX INFO: loaded from: classes9.dex */
public class c0 implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Runnable f5050a;
    private Runnable b;

    /* JADX INFO: compiled from: LimitExecutor.java */
    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Runnable f5051a;

        a(Runnable runnable) {
            this.f5051a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f5051a.run();
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    o0.b("LimitExecutor", e.getMessage());
                }
            } finally {
                c0.this.a();
            }
        }
    }

    @Override // java.util.concurrent.Executor
    public synchronized void execute(Runnable runnable) {
        if (this.f5050a == null) {
            this.f5050a = a(runnable);
            a0.a().execute(this.f5050a);
        } else if (this.b == null) {
            this.b = a(runnable);
        }
    }

    private Runnable a(Runnable runnable) {
        return new a(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a() {
        Runnable runnable = this.b;
        this.f5050a = runnable;
        this.b = null;
        if (runnable != null) {
            a0.a().execute(this.f5050a);
        }
    }
}
