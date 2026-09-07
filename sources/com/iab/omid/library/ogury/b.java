package com.iab.omid.library.ogury;

import android.content.Context;
import com.iab.omid.library.ogury.internal.f;
import com.iab.omid.library.ogury.internal.h;
import com.iab.omid.library.ogury.utils.e;
import com.iab.omid.library.ogury.utils.g;

/* JADX INFO: loaded from: classes9.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f2798a;

    private void b(Context context) {
        g.a(context, "Application Context cannot be null");
    }

    String a() {
        return "1.4.7-Ogury";
    }

    void a(Context context) {
        b(context);
        if (b()) {
            return;
        }
        a(true);
        h.c().a(context);
        com.iab.omid.library.ogury.internal.b.g().a(context);
        com.iab.omid.library.ogury.utils.a.a(context);
        com.iab.omid.library.ogury.utils.c.a(context);
        e.a(context);
        f.b().a(context);
        com.iab.omid.library.ogury.internal.a.a().a(context);
    }

    void a(boolean z) {
        this.f2798a = z;
    }

    boolean b() {
        return this.f2798a;
    }

    void c() {
        g.a();
        com.iab.omid.library.ogury.internal.a.a().d();
    }
}
