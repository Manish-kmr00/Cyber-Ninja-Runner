package com.fyber.inneractive.sdk.flow;

import android.content.Context;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes10.dex */
public final class V {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f1783a;
    public final S b;
    public final InneractiveAdRequest c;
    public final com.fyber.inneractive.sdk.response.g d;
    public final com.fyber.inneractive.sdk.model.vast.b e;
    public final JSONArray f;
    public final com.fyber.inneractive.sdk.config.global.features.w g;
    public final com.fyber.inneractive.sdk.config.global.features.i h;

    public V(Context context, S s) {
        com.fyber.inneractive.sdk.config.global.features.w wVar;
        JSONArray jSONArrayB;
        com.fyber.inneractive.sdk.config.global.features.i iVar;
        com.fyber.inneractive.sdk.config.global.r rVar = s.c;
        InneractiveAdRequest inneractiveAdRequest = s.f1840a;
        com.fyber.inneractive.sdk.response.g gVar = (com.fyber.inneractive.sdk.response.g) s.b;
        com.fyber.inneractive.sdk.model.vast.b bVar = gVar.N;
        if (rVar != null) {
            wVar = (com.fyber.inneractive.sdk.config.global.features.w) rVar.a(com.fyber.inneractive.sdk.config.global.features.w.class);
            iVar = (com.fyber.inneractive.sdk.config.global.features.i) rVar.a(com.fyber.inneractive.sdk.config.global.features.i.class);
            jSONArrayB = rVar.b();
        } else {
            wVar = null;
            jSONArrayB = null;
            iVar = null;
        }
        this.f1783a = context;
        this.b = s;
        this.c = inneractiveAdRequest;
        this.d = gVar;
        this.e = bVar;
        this.g = wVar;
        this.h = iVar;
        this.f = jSONArrayB;
    }
}
