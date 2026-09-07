package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes7.dex */
public final class Xn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f11424a;
    public final LinkedHashMap b = new LinkedHashMap();
    public final Tn c;
    public final Tn d;

    public Xn(Context context) {
        this.f11424a = context;
        C4188ia c4188ia = new C4188ia(context, "appmetrica_vital.dat");
        this.c = new Tn(C4486ua.j().x(), c4188ia);
        this.d = new Tn(new Oe(C4135g7.a(context).d()), c4188ia);
    }

    public final Tn a() {
        return this.c;
    }

    public final Tn b() {
        return this.d;
    }
}
