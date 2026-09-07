package com.applovin.impl;

import android.content.Context;
import android.text.SpannedString;
import android.text.TextUtils;
import androidx.core.view.ViewCompat;
import com.applovin.impl.sdk.utils.StringUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
class m extends p2 {
    private final n e;
    private final o f;
    private final f8 g;
    private final String h;
    private final List i;
    private final List j;
    private final List k;

    enum a {
        INFO,
        BIDDERS,
        WATERFALL,
        COUNT
    }

    class b extends w3 {
        private final f8 p;

        b(f8 f8Var, String str, boolean z) {
            super(f8Var.b().d(), m.this.f577a);
            this.p = f8Var;
            this.c = StringUtils.createSpannedString(f8Var.b().a(), ViewCompat.MEASURED_STATE_MASK, 18, 1);
            this.d = !TextUtils.isEmpty(str) ? new SpannedString(str) : null;
            this.b = z;
        }

        @Override // com.applovin.impl.o2
        public int g() {
            return -12303292;
        }

        @Override // com.applovin.impl.w3, com.applovin.impl.o2
        public boolean o() {
            return this.b;
        }

        public f8 v() {
            return this.p;
        }
    }

    m(n nVar, o oVar, f8 f8Var, Context context) {
        super(context);
        this.e = nVar;
        this.g = f8Var;
        this.f = oVar != null ? oVar : nVar.f();
        this.h = oVar != null ? oVar.c() : nVar.d();
        this.i = h();
        this.j = e();
        this.k = l();
        notifyDataSetChanged();
    }

    private o2 f() {
        return o2.a().d("AB Test Experiment Name").c(j().b()).a();
    }

    private o2 g() {
        return o2.a().d("ID").c(this.e.c()).a();
    }

    private List h() {
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(g());
        arrayList.add(d());
        if (this.f.b() != null) {
            arrayList.add(f());
        }
        if (this.g != null) {
            arrayList.add(i());
        }
        return arrayList;
    }

    private o2 i() {
        return o2.a().d("Selected Network").c(this.g.b().a()).a();
    }

    private List l() {
        f8 f8Var = this.g;
        if (f8Var != null && f8Var.d()) {
            return new ArrayList();
        }
        List<f8> listE = this.f.e();
        ArrayList arrayList = new ArrayList(listE.size());
        for (f8 f8Var2 : listE) {
            f8 f8Var3 = this.g;
            if (f8Var3 == null || f8Var3.b().c().equals(f8Var2.b().c())) {
                arrayList.add(new b(f8Var2, null, this.g == null));
                for (x3 x3Var : f8Var2.c()) {
                    arrayList.add(o2.a().d(x3Var.a()).c(x3Var.b()).b(true).a());
                }
            }
        }
        return arrayList;
    }

    @Override // com.applovin.impl.p2
    protected int b() {
        return a.COUNT.ordinal();
    }

    @Override // com.applovin.impl.p2
    protected List c(int i) {
        if (i == a.INFO.ordinal()) {
            return this.i;
        }
        return i == a.BIDDERS.ordinal() ? this.j : this.k;
    }

    @Override // com.applovin.impl.p2
    protected int d(int i) {
        if (i == a.INFO.ordinal()) {
            return this.i.size();
        }
        return i == a.BIDDERS.ordinal() ? this.j.size() : this.k.size();
    }

    @Override // com.applovin.impl.p2
    protected o2 e(int i) {
        if (i == a.INFO.ordinal()) {
            return new t4("INFO");
        }
        return i == a.BIDDERS.ordinal() ? new t4("BIDDERS") : new t4("WATERFALL");
    }

    public o j() {
        return this.f;
    }

    public String k() {
        return this.h;
    }

    private o2 d() {
        return o2.a().d("Ad Format").c(this.e.b()).a();
    }

    private List e() {
        f8 f8Var = this.g;
        if (f8Var != null && !f8Var.d()) {
            return new ArrayList();
        }
        List<f8> listA = this.f.a();
        ArrayList arrayList = new ArrayList(listA.size());
        for (f8 f8Var2 : listA) {
            f8 f8Var3 = this.g;
            if (f8Var3 == null || f8Var3.b().c().equals(f8Var2.b().c())) {
                arrayList.add(new b(f8Var2, f8Var2.a() != null ? f8Var2.a().a() : "", this.g == null));
            }
        }
        return arrayList;
    }
}
