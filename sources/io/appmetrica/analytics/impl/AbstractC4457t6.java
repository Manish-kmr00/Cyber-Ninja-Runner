package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ICrashTransformer;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.t6, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes8.dex */
public abstract class AbstractC4457t6 implements Ma {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC4432s6 f11775a;
    public final ICrashTransformer b;
    public final T9 c;

    public AbstractC4457t6(InterfaceC4432s6 interfaceC4432s6, ICrashTransformer iCrashTransformer, T9 t9) {
        this.f11775a = interfaceC4432s6;
        this.b = iCrashTransformer;
        this.c = t9;
    }

    @Override // io.appmetrica.analytics.impl.Ma
    public final void a(Throwable th, S s) {
        if (this.f11775a.a(th)) {
            ICrashTransformer iCrashTransformer = this.b;
            if (iCrashTransformer == null || th == null || (th = iCrashTransformer.process(th)) != null) {
                C4325nn c4325nnA = AbstractC4400qn.a(th, s, null, (String) this.c.b.a(), (Boolean) this.c.c.a());
                C4239kc c4239kc = (C4239kc) ((C4468th) this).d;
                c4239kc.f11787a.a().b(c4239kc.b).a(c4325nnA);
            }
        }
    }

    public final InterfaceC4432s6 b() {
        return this.f11775a;
    }

    public final ICrashTransformer a() {
        return this.b;
    }
}
