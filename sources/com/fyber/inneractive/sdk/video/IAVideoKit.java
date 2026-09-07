package com.fyber.inneractive.sdk.video;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.factories.h;
import com.fyber.inneractive.sdk.factories.i;
import com.fyber.inneractive.sdk.player.cache.m;
import com.fyber.inneractive.sdk.util.AbstractC3255t;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.InterfaceC3258w;

/* JADX INFO: loaded from: classes8.dex */
public class IAVideoKit extends BroadcastReceiver {
    private static final InterfaceC3258w sProvider = new a();

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        InterfaceC3258w interfaceC3258w = sProvider;
        IAConfigManager.O.J.put(interfaceC3258w.getType(), interfaceC3258w);
        m mVar = m.f;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext == null) {
            mVar.getClass();
            IAlog.f("context is null, would not start the video cache.", new Object[0]);
        } else if (!mVar.c || !AbstractC3255t.a()) {
            mVar.f1948a = applicationContext;
            new Thread(mVar.e, "VideoCache").start();
        }
        IAlog.a("IAVideoKit: onReceive in package: %s", context.getApplicationContext().getPackageName());
        com.fyber.inneractive.sdk.factories.d.f1768a.a(com.fyber.inneractive.sdk.response.a.RETURNED_ADTYPE_VAST, new b());
        i iVar = h.f1770a;
        iVar.f1771a.add(new c());
        com.fyber.inneractive.sdk.factories.c cVar = com.fyber.inneractive.sdk.factories.b.f1766a;
        cVar.f1767a.add(new d());
    }
}
