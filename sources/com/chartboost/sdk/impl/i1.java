package com.chartboost.sdk.impl;

import com.chartboost.sdk.internal.Model.CBError;
import java.io.File;
import java.util.HashMap;

/* JADX INFO: loaded from: classes5.dex */
public class i1 extends c2<Void> {
    public final g4 k;
    public final h2 l;
    public final h1 m;
    public final String n;

    public i1(g4 g4Var, h2 h2Var, h1 h1Var, File file, String str) {
        super(c2.c.GET, h1Var.d, k8.NORMAL, file);
        this.dispatch = c2.b.ASYNC;
        this.k = g4Var;
        this.l = h2Var;
        this.m = h1Var;
        this.n = str;
    }

    @Override // com.chartboost.sdk.impl.c2
    public void a(CBError cBError, f2 f2Var) {
        this.k.a(this, cBError, f2Var);
    }

    @Override // com.chartboost.sdk.impl.c2
    public void a(Void r1, f2 f2Var) {
        this.k.a(this, null, null);
    }

    @Override // com.chartboost.sdk.impl.c2
    public d2 a() {
        HashMap map = new HashMap();
        map.put("X-Chartboost-App", this.n);
        map.put("X-Chartboost-Client", n2.b());
        map.put("X-Chartboost-Reachability", Integer.toString(this.l.c().getValue()));
        return new d2(map, null, null);
    }
}
