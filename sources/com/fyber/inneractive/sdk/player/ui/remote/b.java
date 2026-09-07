package com.fyber.inneractive.sdk.player.ui.remote;

import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.r;
import com.safedk.android.internal.partials.DTExchangeNetworkBridge;

/* JADX INFO: loaded from: classes13.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f2241a;

    public b(d dVar) {
        this.f2241a = dVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        IAlog.a("%s : remote UI load timeout task executed", "RemoteUIWebviewController");
        d dVar = this.f2241a;
        DTExchangeNetworkBridge.webviewLoadData(dVar.b, "", null, null);
        dVar.g = true;
        IAlog.a("%s : UI load timed out", "RemoteUIWebviewController");
        r.b.post(dVar.l);
    }
}
