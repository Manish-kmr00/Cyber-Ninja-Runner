package com.fyber.inneractive.sdk.flow.storepromo.controller;

import com.fyber.inneractive.sdk.flow.storepromo.loader.f;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.h0;
import java.util.HashMap;

/* JADX INFO: loaded from: classes12.dex */
public final class c implements com.fyber.inneractive.sdk.flow.storepromo.loader.a, com.fyber.inneractive.sdk.flow.storepromo.controller.webview.handler.a, com.fyber.inneractive.sdk.flow.storepromo.controller.webview.bridge.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.fyber.inneractive.sdk.flow.storepromo.controller.webview.b f1810a;
    public com.fyber.inneractive.sdk.flow.storepromo.controller.webview.a b;
    public f d;
    public com.fyber.inneractive.sdk.flow.storepromo.loader.a f;
    public b g;
    public boolean e = false;
    public com.fyber.inneractive.sdk.flow.storepromo.controller.webview.handler.b c = new com.fyber.inneractive.sdk.flow.storepromo.controller.webview.handler.b(this);

    public c(com.fyber.inneractive.sdk.flow.storepromo.model.c cVar, com.fyber.inneractive.sdk.flow.storepromo.loader.a aVar, b bVar) {
        this.f = aVar;
        this.g = bVar;
        this.f1810a = new com.fyber.inneractive.sdk.flow.storepromo.controller.webview.b(this, aVar);
        this.d = new f(cVar, this);
    }

    @Override // com.fyber.inneractive.sdk.flow.storepromo.controller.webview.bridge.a
    public final void a() {
    }

    @Override // com.fyber.inneractive.sdk.flow.storepromo.controller.webview.bridge.a
    public final void a(HashMap map) {
    }

    @Override // com.fyber.inneractive.sdk.flow.storepromo.controller.webview.bridge.a
    public final void b() {
        com.fyber.inneractive.sdk.flow.storepromo.controller.webview.a aVar = this.b;
        if (aVar != null) {
            aVar.a("DTStorePromoBridge.nativeCallComplete()");
        }
    }

    @Override // com.fyber.inneractive.sdk.flow.storepromo.controller.webview.handler.a
    public final void a(String str, HashMap map) {
        com.fyber.inneractive.sdk.flow.storepromo.controller.webview.a aVar = this.b;
        if (aVar == null) {
            IAlog.b("StorePromoWebViewController: onCommandReceived: command: %s the webview is null", str);
            return;
        }
        h0 lastClickedLocation = aVar.getLastClickedLocation();
        com.fyber.inneractive.sdk.flow.storepromo.controller.webview.handler.b bVar = this.c;
        if (bVar != null) {
            bVar.a(str, map, lastClickedLocation);
        }
    }

    @Override // com.fyber.inneractive.sdk.flow.storepromo.controller.webview.bridge.a
    public final void a(int i, h0 h0Var) {
        if (i != 0) {
            b bVar = this.g;
            if (bVar != null) {
                a aVar = a.INSTALL;
                IAlog.a("StorePromoView: onClick: type: " + aVar, new Object[0]);
                if (aVar == a.CLOSE) {
                    com.fyber.inneractive.sdk.flow.storepromo.ui.c cVar = bVar.d;
                    if (cVar != null) {
                        cVar.a();
                        return;
                    }
                    return;
                }
                com.fyber.inneractive.sdk.flow.storepromo.loader.b bVar2 = bVar.e;
                if (bVar2 != null) {
                    bVar2.a(h0Var);
                    return;
                }
                return;
            }
            return;
        }
        b bVar3 = this.g;
        if (bVar3 != null) {
            IAlog.a("StorePromoView: onClick: type: " + a.CLOSE, new Object[0]);
            com.fyber.inneractive.sdk.flow.storepromo.ui.c cVar2 = bVar3.d;
            if (cVar2 != null) {
                cVar2.a();
            }
        }
    }

    @Override // com.fyber.inneractive.sdk.flow.storepromo.loader.a
    public final void a(com.fyber.inneractive.sdk.flow.storepromo.controller.webview.a aVar, com.fyber.inneractive.sdk.flow.storepromo.model.c cVar) {
        IAlog.a("StorePromoWebViewController: onContentLoadedSuccess: content is loaded successfully", new Object[0]);
        this.e = true;
        this.b = aVar;
        aVar.setWebViewClient(this.f1810a);
        com.fyber.inneractive.sdk.flow.storepromo.loader.a aVar2 = this.f;
        if (aVar2 != null) {
            aVar2.a(this.b, cVar);
            this.f = null;
        }
    }

    @Override // com.fyber.inneractive.sdk.flow.storepromo.controller.listener.a
    public final void a(com.fyber.inneractive.sdk.network.events.b bVar, String str, String str2) {
        this.e = false;
        com.fyber.inneractive.sdk.flow.storepromo.loader.a aVar = this.f;
        if (aVar != null) {
            aVar.a(bVar, str, str2);
            this.f = null;
        }
    }
}
