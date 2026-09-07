package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.os.Handler;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes14.dex */
public final class i00 implements uo1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f9158a;
    private final c00 b = new c00();
    private kv0 c = kv0.f9452a;

    @Override // com.yandex.mobile.ads.impl.uo1
    public final ro1[] a(Handler handler, nf2 nf2Var, uh uhVar, n42 n42Var, k01 k01Var) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new rv0(this.f9158a, this.b, this.c, handler, nf2Var));
        ez ezVarA = new ez.e().a(qh.a(this.f9158a)).c().b().d().a();
        arrayList.add(new dv0(this.f9158a, this.b, this.c, handler, uhVar, ezVarA));
        arrayList.add(new o42(n42Var, handler.getLooper()));
        arrayList.add(new l01(k01Var, handler.getLooper()));
        arrayList.add(new wn());
        return (ro1[]) arrayList.toArray(new ro1[0]);
    }

    public i00(Context context) {
        this.f9158a = context;
    }
}
