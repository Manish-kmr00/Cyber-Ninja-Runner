package com.fyber.inneractive.sdk.flow.storepromo.loader;

import com.pubmatic.sdk.common.POBCommonConstants;
import com.safedk.android.internal.partials.DTExchangeNetworkBridge;

/* JADX INFO: loaded from: classes9.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f1813a;
    public final /* synthetic */ d b;

    public c(d dVar, String str) {
        this.b = dVar;
        this.f1813a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        f fVar = this.b.f1814a;
        String str = this.f1813a;
        com.fyber.inneractive.sdk.flow.storepromo.controller.webview.a aVar = fVar.f1816a;
        if (aVar != null) {
            DTExchangeNetworkBridge.webviewLoadDataWithBaseURL(aVar, null, str, POBCommonConstants.CONTENT_TYPE_HTML, "UTF-8", null);
        }
    }
}
