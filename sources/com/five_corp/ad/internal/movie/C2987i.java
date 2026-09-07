package com.five_corp.ad.internal.movie;

import com.five_corp.ad.internal.movie.partialcache.C2994b;
import com.five_corp.ad.internal.movie.partialcache.u1;

/* JADX INFO: renamed from: com.five_corp.ad.internal.movie.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes5.dex */
public final class C2987i implements u1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ x f1451a;

    public C2987i(x xVar) {
        this.f1451a = xVar;
    }

    @Override // com.five_corp.ad.internal.movie.partialcache.u1
    public final void a(Object obj) {
        C2994b c2994b = (C2994b) obj;
        x xVar = this.f1451a;
        if (xVar.o == 13) {
            return;
        }
        x.a(xVar, c2994b);
    }
}
