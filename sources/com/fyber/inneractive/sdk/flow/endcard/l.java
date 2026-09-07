package com.fyber.inneractive.sdk.flow.endcard;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.network.E;

/* JADX INFO: loaded from: classes.dex */
public final class l implements E {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o f1795a;
    public final /* synthetic */ n b;

    public l(n nVar, o oVar) {
        this.b = nVar;
        this.f1795a = oVar;
    }

    @Override // com.fyber.inneractive.sdk.network.E
    public final void a(Object obj, Exception exc, boolean z) {
        String str = (String) obj;
        if (str == null || exc != null) {
            n nVar = this.b;
            o oVar = this.f1795a;
            nVar.getClass();
            if (TextUtils.isEmpty(oVar.j)) {
                nVar.a(exc, z);
                return;
            }
            return;
        }
        n nVar2 = this.b;
        if (nVar2.g != null) {
            for (String str2 : nVar2.h) {
                nVar2.g.getClass();
            }
        }
        nVar2.h.clear();
        o oVar2 = this.f1795a;
        oVar2.j = str;
        this.b.getClass();
        if (TextUtils.isEmpty(oVar2.e) || TextUtils.isEmpty(oVar2.j) || oVar2.f) {
            return;
        }
        oVar2.e();
    }
}
