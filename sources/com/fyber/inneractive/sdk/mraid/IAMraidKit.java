package com.fyber.inneractive.sdk.mraid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import com.fyber.inneractive.sdk.flow.O;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.InterfaceC3258w;

/* JADX INFO: loaded from: classes3.dex */
public class IAMraidKit extends BroadcastReceiver {
    private static final InterfaceC3258w sProvider = new C3118a();

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isMRaidSpotContent(InneractiveAdSpot inneractiveAdSpot) {
        return inneractiveAdSpot.getAdContent() != null && (inneractiveAdSpot.getAdContent() instanceof O);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        IAlog.a("IAMraidKit: onReceive in package: %s", context.getApplicationContext().getPackageName());
        InterfaceC3258w interfaceC3258w = sProvider;
        IAConfigManager.O.J.put(interfaceC3258w.getType(), interfaceC3258w);
        C3119b c3119b = new C3119b();
        com.fyber.inneractive.sdk.factories.f fVar = com.fyber.inneractive.sdk.factories.d.f1768a;
        fVar.a(com.fyber.inneractive.sdk.response.a.RETURNED_ADTYPE_HTML, c3119b);
        fVar.a(com.fyber.inneractive.sdk.response.a.RETURNED_ADTYPE_MRAID, c3119b);
        com.fyber.inneractive.sdk.factories.i iVar = com.fyber.inneractive.sdk.factories.h.f1770a;
        iVar.f1771a.add(new C3120c(this));
        com.fyber.inneractive.sdk.factories.c cVar = com.fyber.inneractive.sdk.factories.b.f1766a;
        cVar.f1767a.add(new C3121d(this));
    }
}
