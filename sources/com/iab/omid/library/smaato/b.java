package com.iab.omid.library.smaato;

import android.content.Context;
import com.iab.omid.library.smaato.internal.i;
import com.iab.omid.library.smaato.internal.j;
import com.iab.omid.library.smaato.utils.e;
import com.iab.omid.library.smaato.utils.g;

/* JADX INFO: loaded from: classes8.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f2906a;

    private void b(Context context) {
        g.a(context, "Application Context cannot be null");
    }

    String a() {
        return "1.5.0-Smaato";
    }

    void a(Context context) {
        b(context);
        if (b()) {
            return;
        }
        a(true);
        i.c().a(context);
        com.iab.omid.library.smaato.internal.b.g().a(context);
        com.iab.omid.library.smaato.utils.a.a(context);
        com.iab.omid.library.smaato.utils.c.a(context);
        e.a(context);
        com.iab.omid.library.smaato.internal.g.b().a(context);
        com.iab.omid.library.smaato.internal.a.a().a(context);
        j.b().a(context);
    }

    void a(boolean z) {
        this.f2906a = z;
    }

    boolean b() {
        return this.f2906a;
    }

    void c() {
        g.a();
        com.iab.omid.library.smaato.internal.a.a().d();
    }
}
