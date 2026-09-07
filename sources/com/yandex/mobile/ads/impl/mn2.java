package com.yandex.mobile.ads.impl;

import android.view.View;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.UUID;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public final class mn2 extends b9 {
    private static final Pattern k = Pattern.compile("^[a-zA-Z0-9 ]+$");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d9 f9658a;
    private final c9 b;
    private qn2 d;
    private g9 e;
    private boolean i;
    private boolean j;
    private final ArrayList c = new ArrayList();
    private boolean f = false;
    private boolean g = false;
    private final String h = UUID.randomUUID().toString();

    mn2(c9 c9Var, d9 d9Var) {
        g9 rn2Var;
        this.b = c9Var;
        this.f9658a = d9Var;
        d();
        if (d9Var.a() == e9.c || d9Var.a() == e9.e) {
            rn2Var = new rn2(d9Var.h());
        } else {
            rn2Var = new vn2(d9Var.e(), d9Var.d());
        }
        this.e = rn2Var;
        this.e.a();
        nn2.a().a(this);
        this.e.a(c9Var);
    }

    @Override // com.yandex.mobile.ads.impl.b9
    public final void b() {
        if (this.f) {
            return;
        }
        this.f = true;
        nn2.a().b(this);
        this.e.a(to2.a().d());
        this.e.a(this, this.f9658a);
    }

    public final View f() {
        return this.d.get();
    }

    public final boolean g() {
        return this.f && !this.g;
    }

    public final boolean h() {
        return this.f;
    }

    public final String i() {
        return this.h;
    }

    public final g9 j() {
        return this.e;
    }

    public final boolean k() {
        return this.g;
    }

    public final boolean l() {
        return this.b.b();
    }

    public final boolean m() {
        return this.b.c();
    }

    private void d() {
        this.d = new qn2(null);
    }

    final void a(JSONObject jSONObject) {
        if (this.j) {
            throw new IllegalStateException("Loaded event can only be sent once");
        }
        this.e.a(jSONObject);
        this.j = true;
    }

    public final ArrayList c() {
        return this.c;
    }

    final void e() {
        if (this.i) {
            throw new IllegalStateException("Impression event can only be sent once");
        }
        this.e.f();
        this.i = true;
    }

    @Override // com.yandex.mobile.ads.impl.b9
    public final void a(View view, rc0 rc0Var, String str) {
        eo2 eo2Var;
        if (this.g) {
            return;
        }
        if (str != null) {
            if (str.length() > 50) {
                throw new IllegalArgumentException("FriendlyObstruction has detailed reason over 50 characters in length");
            }
            if (!k.matcher(str).matches()) {
                throw new IllegalArgumentException("FriendlyObstruction has detailed reason that contains characters not in [a-z][A-Z][0-9] or space");
            }
        }
        Iterator it = this.c.iterator();
        do {
            if (!it.hasNext()) {
                eo2Var = null;
                break;
            }
            eo2Var = (eo2) it.next();
        } while (eo2Var.a().get() != view);
        if (eo2Var == null) {
            this.c.add(new eo2(view, rc0Var, str));
        }
    }

    @Override // com.yandex.mobile.ads.impl.b9
    public final void a() {
        if (this.g) {
            return;
        }
        this.d.clear();
        if (!this.g) {
            this.c.clear();
        }
        this.g = true;
        this.e.e();
        nn2.a().c(this);
        this.e.b();
        this.e = null;
    }

    @Override // com.yandex.mobile.ads.impl.b9
    public final void a(View view) {
        if (this.g || this.d.get() == view) {
            return;
        }
        this.d = new qn2(view);
        this.e.g();
        Collection<mn2> collectionB = nn2.a().b();
        if (collectionB == null || collectionB.isEmpty()) {
            return;
        }
        for (mn2 mn2Var : collectionB) {
            if (mn2Var != this && mn2Var.d.get() == view) {
                mn2Var.d.clear();
            }
        }
    }
}
