package com.fyber.inneractive.sdk.flow.storepromo.controller;

import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.network.C3146w;
import com.fyber.inneractive.sdk.network.EnumC3144u;
import com.fyber.inneractive.sdk.response.e;
import com.fyber.inneractive.sdk.util.IAlog;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class b implements com.fyber.inneractive.sdk.flow.storepromo.loader.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InneractiveAdRequest f1809a;
    public final e b;
    public c c;
    public com.fyber.inneractive.sdk.flow.storepromo.ui.c d;
    public com.fyber.inneractive.sdk.flow.storepromo.loader.b e;
    public com.fyber.inneractive.sdk.flow.storepromo.b f;
    public boolean g = false;
    public com.fyber.inneractive.sdk.flow.storepromo.controller.listener.a h;

    public b(com.fyber.inneractive.sdk.flow.storepromo.model.c cVar, com.fyber.inneractive.sdk.flow.storepromo.b bVar, com.fyber.inneractive.sdk.flow.storepromo.loader.b bVar2, com.fyber.inneractive.sdk.flow.storepromo.controller.listener.a aVar, e eVar, InneractiveAdRequest inneractiveAdRequest) {
        this.h = aVar;
        this.c = new c(cVar, this, this);
        this.f = bVar;
        this.f1809a = inneractiveAdRequest;
        this.b = eVar;
        this.e = bVar2;
    }

    @Override // com.fyber.inneractive.sdk.flow.storepromo.loader.a
    public final void a(com.fyber.inneractive.sdk.flow.storepromo.controller.webview.a aVar, com.fyber.inneractive.sdk.flow.storepromo.model.c cVar) {
        this.d = new com.fyber.inneractive.sdk.flow.storepromo.ui.c(IAConfigManager.O.v.a(), aVar, this.f);
        EnumC3144u enumC3144u = EnumC3144u.VAST_EVENT_SP_LOADED;
        InneractiveAdRequest inneractiveAdRequest = this.f1809a;
        e eVar = this.b;
        String str = cVar.h;
        C3146w c3146w = new C3146w(enumC3144u, inneractiveAdRequest, eVar);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("templateURL", str);
        } catch (Exception unused) {
            IAlog.f("Got exception adding param to json object: %s, %s", "templateURL", str);
        }
        c3146w.f.put(jSONObject);
        c3146w.a((String) null);
        IAlog.a("StorePromoController: onContentLoadedSuccess", new Object[0]);
    }

    @Override // com.fyber.inneractive.sdk.flow.storepromo.controller.listener.a
    public final void a(com.fyber.inneractive.sdk.network.events.b bVar, String str, String str2) {
        this.g = true;
        com.fyber.inneractive.sdk.flow.storepromo.ui.c cVar = this.d;
        if (cVar != null) {
            cVar.a();
        }
        com.fyber.inneractive.sdk.flow.storepromo.controller.listener.a aVar = this.h;
        if (aVar != null) {
            aVar.a(bVar, str, str2);
        }
    }
}
