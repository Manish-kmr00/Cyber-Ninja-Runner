package com.fyber.inneractive.sdk.flow.endcard;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.network.C3131g;
import com.fyber.inneractive.sdk.network.E;

/* JADX INFO: loaded from: classes.dex */
public final class m implements E {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o f1796a;
    public final /* synthetic */ n b;

    public m(n nVar, o oVar) {
        this.b = nVar;
        this.f1796a = oVar;
    }

    @Override // com.fyber.inneractive.sdk.network.E
    public final void a(Object obj, Exception exc, boolean z) {
        String str = (String) obj;
        if (str == null || exc != null) {
            if (exc == null || (exc instanceof C3131g) || z) {
                return;
            }
            this.b.a((Throwable) exc, false);
            return;
        }
        String strConcat = str.concat("<style>body {margin: 0px; background-color: rgba(0, 0, 0, 0.0);}</style>");
        o oVar = this.f1796a;
        oVar.e = strConcat;
        oVar.k = z;
        this.b.getClass();
        if (TextUtils.isEmpty(oVar.e) || TextUtils.isEmpty(oVar.j) || oVar.f) {
            return;
        }
        oVar.e();
    }
}
