package com.fyber.inneractive.sdk.flow.storepromo.loader.network.callbacks;

import com.fyber.inneractive.sdk.flow.storepromo.loader.g;
import com.fyber.inneractive.sdk.network.E;
import com.fyber.inneractive.sdk.util.IAlog;

/* JADX INFO: loaded from: classes11.dex */
public final class b implements E {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f1823a;
    public final com.fyber.inneractive.sdk.flow.storepromo.model.b b;
    public final String c;
    public final int d;

    public b(com.fyber.inneractive.sdk.flow.storepromo.model.b bVar, String str, g gVar) {
        this.b = bVar;
        this.c = str;
        this.f1823a = gVar;
        this.d = -1;
    }

    /* JADX WARN: Code duplicated, block: B:36:0x00a3  */
    @Override // com.fyber.inneractive.sdk.network.E
    public final void a(Object obj, Exception exc, boolean z) {
        String message;
        com.fyber.inneractive.sdk.flow.storepromo.loader.network.b bVar;
        boolean z2;
        String str = (String) obj;
        if (str != null && exc == null) {
            g gVar = this.f1823a;
            com.fyber.inneractive.sdk.flow.storepromo.model.b bVar2 = this.b;
            int i = this.d;
            gVar.getClass();
            IAlog.a("StorePromoResourcesLoader: onAssetDownloaded: type: %s, sortIndex: %s", bVar2, Integer.valueOf(i));
            com.fyber.inneractive.sdk.flow.storepromo.model.c cVar = gVar.d;
            cVar.f1826a.add(new com.fyber.inneractive.sdk.flow.storepromo.model.a(str, bVar2, i));
            if (bVar2 == com.fyber.inneractive.sdk.flow.storepromo.model.b.SCREENSHOT) {
                cVar.i++;
            }
            gVar.a(null, false, null, null);
            return;
        }
        com.fyber.inneractive.sdk.flow.storepromo.events.a aVar = exc instanceof com.fyber.inneractive.sdk.flow.storepromo.loader.network.exception.a ? com.fyber.inneractive.sdk.flow.storepromo.events.a.FILE_SIZE_EXCEEDS_LIMIT : com.fyber.inneractive.sdk.flow.storepromo.events.a.DOWNLOAD_RESOURCE_ERROR;
        com.fyber.inneractive.sdk.flow.storepromo.model.b bVar3 = this.b;
        if (exc != null) {
            message = exc.getMessage() != null ? exc.getMessage() : exc.toString();
        } else {
            message = "";
        }
        String str2 = "Unable download store promo asset type: " + bVar3 + ", error: " + message;
        g gVar2 = this.f1823a;
        String str3 = this.c;
        int i2 = a.f1822a[this.b.ordinal()];
        if (i2 == 1) {
            bVar = com.fyber.inneractive.sdk.flow.storepromo.loader.network.b.APP_ICON_FAILURE;
        } else if (i2 == 2) {
            bVar = com.fyber.inneractive.sdk.flow.storepromo.loader.network.b.SCREENSHOT_FAILURE;
        } else if (i2 != 3) {
            bVar = i2 != 4 ? com.fyber.inneractive.sdk.flow.storepromo.loader.network.b.UNKNOWN_FAILURE : com.fyber.inneractive.sdk.flow.storepromo.loader.network.b.RATING_ICON_FAILURE;
        } else {
            bVar = com.fyber.inneractive.sdk.flow.storepromo.loader.network.b.VIDEO_FAILURE;
        }
        if (bVar == com.fyber.inneractive.sdk.flow.storepromo.loader.network.b.SCREENSHOT_FAILURE) {
            int i3 = gVar2.f;
            int i4 = gVar2.g + 1;
            gVar2.g = i4;
            z2 = i3 - i4 < 2;
        }
        gVar2.a(aVar, z2, str2, str3);
    }

    public b(com.fyber.inneractive.sdk.flow.storepromo.model.b bVar, String str, g gVar, int i) {
        this.b = bVar;
        this.c = str;
        this.f1823a = gVar;
        this.d = i;
    }
}
