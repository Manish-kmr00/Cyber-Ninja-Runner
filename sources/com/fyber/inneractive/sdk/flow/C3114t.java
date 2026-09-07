package com.fyber.inneractive.sdk.flow;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.network.C3131g;
import com.fyber.inneractive.sdk.util.IAlog;
import com.pubmatic.sdk.common.POBCommonConstants;
import com.safedk.android.internal.partials.DTExchangeNetworkBridge;

/* JADX INFO: renamed from: com.fyber.inneractive.sdk.flow.t, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C3114t implements com.fyber.inneractive.sdk.network.E {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C3115u f1832a;

    public C3114t(C3115u c3115u) {
        this.f1832a = c3115u;
    }

    @Override // com.fyber.inneractive.sdk.network.E
    public final void a(Object obj, Exception exc, boolean z) {
        com.fyber.inneractive.sdk.player.ui.remote.g gVar;
        com.fyber.inneractive.sdk.player.a aVar;
        String str = (String) obj;
        IAlog.a("IAVideoContentLoader : Remote ui template callback onNetworkResult from cache: %s", Boolean.valueOf(z));
        if (exc instanceof C3131g) {
            return;
        }
        C3115u c3115u = this.f1832a;
        c3115u.getClass();
        if (TextUtils.isEmpty(str) && z) {
            c3115u.a(exc, "Fetched cached template is ".concat(str == null ? "null" : "empty"), true);
            return;
        }
        com.fyber.inneractive.sdk.player.t tVar = c3115u.m;
        if (tVar == null || (aVar = tVar.f) == null || (gVar = ((com.fyber.inneractive.sdk.player.n) aVar).u) == null) {
            gVar = null;
        }
        if (gVar == null) {
            c3115u.a(null, "Flow Manager is null", z);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            boolean z2 = gVar.f2246a.i;
            c3115u.a(exc, "Unknown error while receiving template: templateContent is: " + (TextUtils.isEmpty(str) ? "null or empty" : "not null and not empty") + " isFromCache: " + z2, z2);
            return;
        }
        com.fyber.inneractive.sdk.player.ui.remote.d dVar = gVar.f2246a;
        dVar.i = z;
        IAlog.a("%s : schedule UI load timeout task with delay: %d", "RemoteUIWebviewController", 10000);
        com.fyber.inneractive.sdk.util.r.b.postDelayed(dVar.k, 10000);
        DTExchangeNetworkBridge.webviewLoadData(dVar.b, str, POBCommonConstants.CONTENT_TYPE_HTML, "UTF-8");
    }
}
