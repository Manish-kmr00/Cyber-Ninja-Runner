package com.fyber.inneractive.sdk.flow.storepromo.loader.network.callbacks;

import com.fyber.inneractive.sdk.flow.storepromo.loader.g;
import com.fyber.inneractive.sdk.network.E;
import com.fyber.inneractive.sdk.util.IAlog;

/* JADX INFO: loaded from: classes11.dex */
public final class c implements E {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f1824a;
    public boolean b = false;
    public final String c;

    public c(g gVar, String str) {
        this.f1824a = gVar;
        this.c = str;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0078  */
    @Override // com.fyber.inneractive.sdk.network.E
    public final void a(Object obj, Exception exc, boolean z) {
        String message;
        boolean z2;
        String str = (String) obj;
        if (this.b) {
            IAlog.a("StorePromoTemplateCallback: onNetworkResult: the cached response was applied and this one being cached", new Object[0]);
            return;
        }
        IAlog.a("StorePromoTemplateCallback: onNetworkResult: fromCache: " + z, new Object[0]);
        this.b = true;
        if (str != null && exc == null) {
            g gVar = this.f1824a;
            gVar.getClass();
            IAlog.a("StorePromoResourcesLoader: onTemplateDownloaded", new Object[0]);
            gVar.d.c = str;
            gVar.a(null, false, null, null);
            return;
        }
        if (exc != null) {
            message = exc.getMessage() != null ? exc.getMessage() : exc.toString();
        } else {
            message = "";
        }
        String str2 = "Unable download store promo template, error: " + message;
        g gVar2 = this.f1824a;
        com.fyber.inneractive.sdk.flow.storepromo.events.a aVar = com.fyber.inneractive.sdk.flow.storepromo.events.a.DOWNLOAD_RESOURCE_ERROR;
        String str3 = this.c;
        if (com.fyber.inneractive.sdk.flow.storepromo.loader.network.b.TEMPLATE_FAILURE == com.fyber.inneractive.sdk.flow.storepromo.loader.network.b.SCREENSHOT_FAILURE) {
            int i = gVar2.f;
            int i2 = gVar2.g + 1;
            gVar2.g = i2;
            z2 = i - i2 < 2;
        }
        gVar2.a(aVar, z2, str2, str3);
    }
}
