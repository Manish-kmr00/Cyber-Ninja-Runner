package com.iab.omid.library.odeeoio;

import android.content.Context;
import com.iab.omid.library.odeeoio.b.d;
import com.iab.omid.library.odeeoio.b.f;
import com.iab.omid.library.odeeoio.d.e;

/* JADX INFO: loaded from: classes11.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f2768a;

    private void b(Context context) {
        e.a(context, "Application Context cannot be null");
    }

    String a() {
        return "1.3.26-Odeeoio";
    }

    void a(Context context) {
        b(context);
        if (b()) {
            return;
        }
        a(true);
        f.a().a(context);
        com.iab.omid.library.odeeoio.b.b.a().a(context);
        com.iab.omid.library.odeeoio.d.b.a(context);
        d.a().a(context);
    }

    void a(boolean z) {
        this.f2768a = z;
    }

    boolean b() {
        return this.f2768a;
    }
}
