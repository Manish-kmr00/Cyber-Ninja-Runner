package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.HashMap;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.jl, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C4223jl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C4536wa f11622a = new C4536wa();
    public final HashMap b = new HashMap();
    public Hl c = null;
    public final C4174hl d = new C4174hl(this);

    public static final C4223jl a() {
        return AbstractC4198il.f11607a;
    }

    public final C4075dm a(Context context, C4108f5 c4108f5, Bl bl) {
        C4075dm c4075dm = (C4075dm) this.b.get(c4108f5.f11544a);
        boolean z = true;
        if (c4075dm == null) {
            synchronized (this.b) {
                c4075dm = (C4075dm) this.b.get(c4108f5.f11544a);
                if (c4075dm == null) {
                    c4075dm = new C4075dm(new C4100em(context, c4108f5.f11544a, bl, this.d));
                    c4075dm.f();
                    this.b.put(c4108f5.f11544a, c4075dm);
                    z = false;
                }
            }
        }
        if (z) {
            c4075dm.a(bl);
        }
        return c4075dm;
    }

    public final void a(C4108f5 c4108f5, InterfaceC4447sl interfaceC4447sl) {
        synchronized (this.b) {
            this.f11622a.a(c4108f5.f11544a, interfaceC4447sl);
            Hl hl = this.c;
            if (hl != null) {
                interfaceC4447sl.a(hl);
            }
        }
    }
}
