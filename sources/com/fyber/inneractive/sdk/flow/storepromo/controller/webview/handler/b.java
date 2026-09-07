package com.fyber.inneractive.sdk.flow.storepromo.controller.webview.handler;

import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.h0;
import java.util.HashMap;

/* JADX INFO: loaded from: classes10.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.fyber.inneractive.sdk.flow.storepromo.controller.webview.bridge.a f1812a;

    public b(com.fyber.inneractive.sdk.flow.storepromo.controller.webview.bridge.a aVar) {
        this.f1812a = aVar;
    }

    public final void a(String str, HashMap map, h0 h0Var) {
        str.getClass();
        str.hashCode();
        switch (str) {
            case "onClick":
                String str2 = (String) map.get("clickAction");
                if (str2 != null && !str2.isEmpty()) {
                    try {
                        this.f1812a.a(Integer.parseInt(str2), h0Var);
                    } catch (NumberFormatException e) {
                        IAlog.b("WebviewCommandHandlerBase: handleClick: exception: %s" + e, new Object[0]);
                    }
                    break;
                } else {
                    IAlog.a("WebviewCommandHandlerBase: handleClick: no click action in params for click cmd", new Object[0]);
                    break;
                }
                break;
            case "onError":
                this.f1812a.a(map);
                break;
            case "DOMLoaded":
                this.f1812a.a();
                break;
            default:
                IAlog.f("Sent unknown command: %s", str);
                break;
        }
        this.f1812a.b();
    }
}
