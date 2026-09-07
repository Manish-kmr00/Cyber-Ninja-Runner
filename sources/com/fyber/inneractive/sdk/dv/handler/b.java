package com.fyber.inneractive.sdk.dv.handler;

import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.network.C3146w;
import com.fyber.inneractive.sdk.network.C3147x;
import com.fyber.inneractive.sdk.network.EnumC3143t;
import com.fyber.inneractive.sdk.util.IAlog;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.query.QueryInfo;
import com.google.android.gms.ads.query.QueryInfoGenerationCallback;
import com.json.mediationsdk.impressionData.ImpressionData;

/* JADX INFO: loaded from: classes13.dex */
public final class b extends QueryInfoGenerationCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f1735a;

    public b(c cVar) {
        this.f1735a = cVar;
    }

    @Override // com.google.android.gms.ads.query.QueryInfoGenerationCallback
    public final void onFailure(String str) {
        c cVar = this.f1735a;
        e eVar = cVar.b;
        if (eVar.b) {
            return;
        }
        AdFormat adFormat = cVar.f1736a;
        eVar.getClass();
        IAlog.a("Firing Event 1000 - Fetch error DV - msg  " + str, new Object[0]);
        C3146w c3146w = new C3146w(EnumC3143t.FETCH_TOKEN_DV_ERROR, (InneractiveAdRequest) null, (com.fyber.inneractive.sdk.response.e) null);
        c3146w.f.put(new C3147x().a(str, "message").a(e.b(), "version").a(adFormat.name(), ImpressionData.IMPRESSION_DATA_KEY_AD_FORMAT).a(Integer.valueOf(eVar.d), "success_count").f1935a);
        c3146w.a((String) null);
        this.f1735a.b.b = true;
    }

    @Override // com.google.android.gms.ads.query.QueryInfoGenerationCallback
    public final void onSuccess(QueryInfo queryInfo) {
        IAlog.a("DVHanlder - %s - put query: %s", this.f1735a.f1736a.toString(), queryInfo.getQuery());
        synchronized (this.f1735a.b.c) {
            c cVar = this.f1735a;
            e eVar = cVar.b;
            eVar.d++;
            eVar.f1738a.put(cVar.f1736a, queryInfo);
        }
    }
}
