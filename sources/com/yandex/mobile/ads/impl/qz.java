package com.yandex.mobile.ads.impl;

import android.net.Uri;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public final class qz implements g40 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f10058a = new Object();
    private fw0.d b;
    private pz c;

    private static pz a(fw0.d dVar) {
        vz.a aVarB = new vz.a().b();
        Uri uri = dVar.b;
        wh0 wh0Var = new wh0(uri == null ? null : uri.toString(), dVar.f, aVarB);
        b82<Map.Entry<String, String>> it = dVar.c.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> next = it.next();
            wh0Var.a(next.getKey(), next.getValue());
        }
        pz pzVarA = new pz.a().a(dVar.f8932a, pc0.e).a(dVar.d).b(dVar.e).a(dq0.a(dVar.g)).a(wh0Var);
        pzVarA.a(dVar.a());
        return pzVarA;
    }

    @Override // com.yandex.mobile.ads.impl.g40
    public final f40 a(fw0 fw0Var) {
        pz pzVar;
        fw0Var.c.getClass();
        fw0.d dVar = fw0Var.c.c;
        if (dVar != null && x82.f10629a >= 18) {
            synchronized (this.f10058a) {
                if (!x82.a(dVar, this.b)) {
                    this.b = dVar;
                    this.c = a(dVar);
                }
                pzVar = this.c;
                pzVar.getClass();
            }
            return pzVar;
        }
        return f40.f8865a;
    }
}
