package io.appmetrica.analytics.impl;

import java.util.HashMap;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.sm, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes8.dex */
public final class C4448sm {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f11769a;

    public C4448sm() {
        HashMap map = new HashMap();
        this.f11769a = map;
        C4299mm c4299mm = new C4299mm();
        C4324nm c4324nm = new C4324nm();
        C4349om c4349om = new C4349om();
        C4374pm c4374pm = new C4374pm();
        C4399qm c4399qm = new C4399qm();
        map.put(Ll.class, c4299mm);
        map.put(X1.class, c4324nm);
        map.put(Se.class, c4349om);
        map.put(C4478u2.class, c4374pm);
        map.put(M3.class, c4399qm);
    }

    public static AbstractC4473tm a(Class cls) {
        return (AbstractC4473tm) AbstractC4423rm.f11755a.f11769a.get(cls);
    }
}
