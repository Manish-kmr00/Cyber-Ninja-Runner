package com.five_corp.ad.internal.cache;

import com.five_corp.ad.internal.C2974a;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes13.dex */
public final class u implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.five_corp.ad.internal.media_config.a f1352a;

    public u(w wVar, com.five_corp.ad.internal.media_config.a aVar) {
        this.f1352a = aVar;
    }

    @Override // com.five_corp.ad.internal.cache.r
    public final x a(x xVar) {
        return new x(new C2974a(new ArrayList(xVar.f1355a.f1265a)), this.f1352a, System.currentTimeMillis());
    }
}
