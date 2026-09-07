package io.appmetrica.analytics.impl;

import android.content.Context;
import android.os.ResultReceiver;

/* JADX INFO: loaded from: classes5.dex */
public final class L4 implements InterfaceC4530w4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f11237a;
    public final O4 b;
    public final ResultReceiver c;

    public L4(Context context, O4 o4, G4 g4) {
        this.f11237a = context;
        this.b = o4;
        this.c = g4.c;
        o4.a(this);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC4530w4
    public final void a(C3984a6 c3984a6, G4 g4) {
        this.b.a(g4.b);
        this.b.a(c3984a6, this);
    }

    public final O4 b() {
        return this.b;
    }

    public final Context c() {
        return this.f11237a;
    }

    public final ResultReceiver d() {
        return this.c;
    }

    public final void a(C4231k4 c4231k4) {
        I6.a(this.c, c4231k4);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC4530w4
    public final void a() {
        this.b.b(this);
    }
}
