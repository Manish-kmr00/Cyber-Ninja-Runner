package com.iab.omid.library.amazon;

import android.content.Context;
import com.iab.omid.library.amazon.internal.i;
import com.iab.omid.library.amazon.utils.e;
import com.iab.omid.library.amazon.utils.g;

/* JADX INFO: loaded from: classes10.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f2444a;

    private void b(Context context) {
        g.a(context, "Application Context cannot be null");
    }

    String a() {
        return "1.4.10-Amazon";
    }

    void a(Context context) {
        b(context);
        if (b()) {
            return;
        }
        a(true);
        i.c().a(context);
        com.iab.omid.library.amazon.internal.b.g().a(context);
        com.iab.omid.library.amazon.utils.a.a(context);
        com.iab.omid.library.amazon.utils.c.a(context);
        e.a(context);
        com.iab.omid.library.amazon.internal.g.b().a(context);
        com.iab.omid.library.amazon.internal.a.a().a(context);
    }

    void a(boolean z) {
        this.f2444a = z;
    }

    boolean b() {
        return this.f2444a;
    }

    void c() {
        g.a();
        com.iab.omid.library.amazon.internal.a.a().d();
    }
}
