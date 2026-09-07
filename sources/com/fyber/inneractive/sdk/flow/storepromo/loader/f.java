package com.fyber.inneractive.sdk.flow.storepromo.loader;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.h0;
import java.util.HashMap;

/* JADX INFO: loaded from: classes9.dex */
public final class f implements com.fyber.inneractive.sdk.flow.storepromo.controller.webview.handler.a, com.fyber.inneractive.sdk.flow.storepromo.controller.webview.bridge.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.fyber.inneractive.sdk.flow.storepromo.controller.webview.a f1816a;
    public com.fyber.inneractive.sdk.flow.storepromo.model.c b;
    public com.fyber.inneractive.sdk.flow.storepromo.controller.webview.b c;
    public a e;
    public com.fyber.inneractive.sdk.flow.storepromo.controller.webview.handler.b d = new com.fyber.inneractive.sdk.flow.storepromo.controller.webview.handler.b(this);
    public i f = new i();

    public f(com.fyber.inneractive.sdk.flow.storepromo.model.c cVar, a aVar) {
        this.e = aVar;
        this.c = new com.fyber.inneractive.sdk.flow.storepromo.controller.webview.b(this, this.e);
        try {
            this.f1816a = new com.fyber.inneractive.sdk.flow.storepromo.controller.webview.a(this.c);
        } catch (Throwable th) {
            IAlog.a("failed to create a promo webview", new Object[0]);
            this.e.a(com.fyber.inneractive.sdk.network.events.b.NO_WEBVIEW_INSTALLED, th.getLocalizedMessage(), null);
        }
        this.b = cVar;
    }

    @Override // com.fyber.inneractive.sdk.flow.storepromo.controller.webview.bridge.a
    public final void a() {
        com.fyber.inneractive.sdk.flow.storepromo.model.c cVar;
        a aVar;
        com.fyber.inneractive.sdk.flow.storepromo.controller.webview.a aVar2 = this.f1816a;
        if (aVar2 == null || (cVar = this.b) == null || (aVar = this.e) == null) {
            return;
        }
        aVar.a(aVar2, cVar);
    }

    @Override // com.fyber.inneractive.sdk.flow.storepromo.controller.webview.bridge.a
    public final void a(int i, h0 h0Var) {
    }

    @Override // com.fyber.inneractive.sdk.flow.storepromo.controller.webview.bridge.a
    public final void b() {
        com.fyber.inneractive.sdk.flow.storepromo.controller.webview.a aVar = this.f1816a;
        if (aVar != null) {
            aVar.a("DTStorePromoBridge.nativeCallComplete()");
        }
    }

    @Override // com.fyber.inneractive.sdk.flow.storepromo.controller.webview.bridge.a
    public final void a(HashMap map) {
        String str = (String) map.get("error");
        if (TextUtils.isEmpty(str)) {
            str = "Unknown error occurred on Store Promo side";
        }
        a aVar = this.e;
        if (aVar != null) {
            aVar.a(com.fyber.inneractive.sdk.network.events.b.TEMPLATE_ERROR, str, null);
        }
    }

    @Override // com.fyber.inneractive.sdk.flow.storepromo.controller.webview.handler.a
    public final void a(String str, HashMap map) {
        com.fyber.inneractive.sdk.flow.storepromo.controller.webview.a aVar = this.f1816a;
        if (aVar == null) {
            IAlog.b("StorePromoContentLoader: onCommandReceived: command: %s the webview is null", str);
            return;
        }
        com.fyber.inneractive.sdk.flow.storepromo.controller.webview.handler.b bVar = this.d;
        if (bVar != null) {
            bVar.a(str, map, aVar.getLastClickedLocation());
        }
    }
}
