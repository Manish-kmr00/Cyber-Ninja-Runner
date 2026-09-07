package com.inmobi.media;

import java.util.Map;
import java.util.concurrent.Callable;

/* JADX INFO: renamed from: com.inmobi.media.l3, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class CallableC3451l3 implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C3536r3 f3365a;

    public CallableC3451l3(C3536r3 c3536r3) {
        this.f3365a = c3536r3;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        synchronized (this.f3365a) {
            C3536r3 c3536r3 = this.f3365a;
            if (c3536r3.j == null) {
                return null;
            }
            while (c3536r3.i > c3536r3.f) {
                c3536r3.d((String) ((Map.Entry) c3536r3.k.entrySet().iterator().next()).getKey());
            }
            if (this.f3365a.a()) {
                this.f3365a.d();
                this.f3365a.l = 0;
            }
            return null;
        }
    }
}
