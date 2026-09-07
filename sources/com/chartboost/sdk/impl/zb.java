package com.chartboost.sdk.impl;

import android.view.View;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public class zb extends p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r f1210a;
    public final q b;
    public final kd c;
    public hc d;
    public t e;
    public boolean f;
    public boolean g;
    public final String h;
    public boolean i;
    public boolean j;

    public zb(q qVar, r rVar) {
        this(qVar, rVar, UUID.randomUUID().toString());
    }

    public void a(List<hc> list) {
        if (i()) {
            ArrayList arrayList = new ArrayList();
            Iterator<hc> it = list.iterator();
            while (it.hasNext()) {
                View view = it.next().get();
                if (view != null) {
                    arrayList.add(view);
                }
            }
            throw null;
        }
    }

    public final void b(View view) {
        Collection<zb> collectionB = tc.c().b();
        if (collectionB == null || collectionB.isEmpty()) {
            return;
        }
        for (zb zbVar : collectionB) {
            if (zbVar != this && zbVar.g() == view) {
                zbVar.d.clear();
            }
        }
    }

    public final void c() {
        if (this.i) {
            throw new IllegalStateException("Impression event can only be sent once");
        }
    }

    public final void d() {
        if (this.j) {
            throw new IllegalStateException("Loaded event can only be sent once");
        }
    }

    public String e() {
        return this.h;
    }

    public t f() {
        return this.e;
    }

    public View g() {
        return this.d.get();
    }

    public List<fd> h() {
        return this.c.a();
    }

    public boolean i() {
        return false;
    }

    public boolean j() {
        return this.f && !this.g;
    }

    public boolean k() {
        return this.g;
    }

    public boolean l() {
        return this.b.a();
    }

    public boolean m() {
        return this.b.b();
    }

    public boolean n() {
        return this.f;
    }

    public void o() {
        c();
        f().g();
        this.i = true;
    }

    public void p() {
        d();
        f().i();
        this.j = true;
    }

    public void q() {
        if (this.g) {
            return;
        }
        this.c.b();
    }

    public zb(q qVar, r rVar, String str) {
        this.c = new kd();
        this.f = false;
        this.g = false;
        this.b = qVar;
        this.f1210a = rVar;
        this.h = str;
        c(null);
        this.e = (rVar.a() == s.HTML || rVar.a() == s.JAVASCRIPT) ? new dc(str, rVar.h()) : new jc(str, rVar.d(), rVar.e());
        this.e.j();
        tc.c().a(this);
        this.e.a(qVar);
    }

    public void a(JSONObject jSONObject) {
        d();
        f().a(jSONObject);
        this.j = true;
    }

    @Override // com.chartboost.sdk.impl.p
    public void b() {
        if (this.f || this.e == null) {
            return;
        }
        this.f = true;
        tc.c().c(this);
        this.e.a(pd.c().b());
        this.e.a(bc.a().b());
        this.e.a(this, this.f1210a);
    }

    public final void c(View view) {
        this.d = new hc(view);
    }

    @Override // com.chartboost.sdk.impl.p
    public void a(View view, h5 h5Var, String str) {
        if (this.g) {
            return;
        }
        this.c.a(view, h5Var, str);
    }

    @Override // com.chartboost.sdk.impl.p
    public void a() {
        if (this.g) {
            return;
        }
        this.d.clear();
        q();
        this.g = true;
        f().f();
        tc.c().b(this);
        f().b();
        this.e = null;
    }

    @Override // com.chartboost.sdk.impl.p
    public void a(View view) {
        if (this.g || g() == view) {
            return;
        }
        c(view);
        f().a();
        b(view);
    }
}
