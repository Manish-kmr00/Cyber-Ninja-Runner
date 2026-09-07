package com.yandex.mobile.ads.impl;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes11.dex */
public final class yl1 implements y30 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Executor f10750a;
    private final uv b;
    private final vm c;
    private final gn d;
    private y30.a e;
    private volatile ts1<Void, IOException> f;
    private volatile boolean g;

    final class a extends ts1<Void, IOException> {
        @Override // com.yandex.mobile.ads.impl.ts1
        protected final void c() throws Exception {
            yl1.this.d.a();
        }

        a() {
        }

        @Override // com.yandex.mobile.ads.impl.ts1
        protected final void b() {
            yl1.this.d.b();
        }
    }

    public yl1(fw0 fw0Var, vm.a aVar, Executor executor) {
        this.f10750a = (Executor) hg.a(executor);
        hg.a(fw0Var.c);
        uv uvVarA = new uv.a().a(fw0Var.c.f8935a).a(fw0Var.c.e).a(4).a();
        this.b = uvVarA;
        vm vmVarB = aVar.b();
        this.c = vmVarB;
        this.d = new gn(vmVarB, uvVarA, new gn.a() { // from class: com.yandex.mobile.ads.impl.yl1$$ExternalSyntheticLambda0
            @Override // com.yandex.mobile.ads.impl.gn.a
            public final void a(long j, long j2, long j3) {
                this.f$0.a(j, j2, j3);
            }
        });
    }

    @Override // com.yandex.mobile.ads.impl.y30
    public final void a(y30.a aVar) throws InterruptedException, IOException {
        this.e = aVar;
        this.f = new a();
        boolean z = false;
        while (!z) {
            try {
                if (this.g) {
                    break;
                }
                this.f10750a.execute(this.f);
                try {
                    this.f.get();
                    z = true;
                } catch (ExecutionException e) {
                    Throwable cause = e.getCause();
                    cause.getClass();
                    if (!(cause instanceof zk1)) {
                        if (cause instanceof IOException) {
                            throw ((IOException) cause);
                        }
                        int i = x82.f10629a;
                        throw cause;
                    }
                }
            } catch (Throwable th) {
                this.f.a();
                throw th;
            }
        }
        this.f.a();
    }

    @Override // com.yandex.mobile.ads.impl.y30
    public final void cancel() {
        this.g = true;
        ts1<Void, IOException> ts1Var = this.f;
        if (ts1Var != null) {
            ts1Var.cancel(true);
        }
    }

    @Override // com.yandex.mobile.ads.impl.y30
    public final void remove() {
        this.c.f().a(this.c.g().a(this.b));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, long j2, long j3) {
        y30.a aVar = this.e;
        if (aVar == null) {
            return;
        }
        ((v30.d) aVar).a(j, j2, (j == -1 || j == 0) ? -1.0f : (j2 * 100.0f) / j);
    }
}
