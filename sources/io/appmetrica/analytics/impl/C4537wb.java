package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.executors.InterruptionSafeThread;
import java.util.HashMap;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.wb, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes8.dex */
public final class C4537wb extends InterruptionSafeThread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C4562xb f11831a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C4537wb(C4562xb c4562xb, String str) {
        super(str);
        this.f11831a = c4562xb;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        HashMap map;
        synchronized (this.f11831a.f11843a) {
            C4562xb.a(this.f11831a);
            this.f11831a.e = true;
            this.f11831a.f11843a.notifyAll();
        }
        while (isRunning()) {
            synchronized (this) {
                if (this.f11831a.b.size() == 0) {
                    try {
                        wait();
                    } catch (InterruptedException unused) {
                    }
                }
                map = new HashMap(this.f11831a.b);
                this.f11831a.b.clear();
            }
            if (map.size() > 0) {
                C4562xb.a(this.f11831a, map);
                map.clear();
            }
        }
    }
}
