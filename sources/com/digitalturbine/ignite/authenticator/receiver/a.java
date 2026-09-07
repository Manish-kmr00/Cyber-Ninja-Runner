package com.digitalturbine.ignite.authenticator.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.digitalturbine.ignite.authenticator.c;
import com.digitalturbine.ignite.authenticator.decorator.h;
import com.digitalturbine.ignite.authenticator.events.d;
import com.digitalturbine.ignite.authenticator.listeners.internal.b;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: loaded from: classes13.dex */
public final class a extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f1236a;
    public boolean b = false;

    public a(b bVar) {
        this.f1236a = bVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        b bVar;
        if ("com.dt.ignite.service.action.PROPERTY_CHANGED".equals(intent.getAction())) {
            com.digitalturbine.ignite.authenticator.logger.a.a("%s : broadcast received", "PropertyChangeReceiver");
            String stringExtra = intent.getStringExtra("PROPERTIES_CHANGED");
            if (stringExtra == null || (bVar = this.f1236a) == null) {
                return;
            }
            c cVar = (c) bVar;
            try {
                JSONArray jSONArray = new JSONArray(stringExtra);
                for (int i = 0; i < jSONArray.length(); i++) {
                    if ("DTID".equalsIgnoreCase(jSONArray.getString(i))) {
                        com.digitalturbine.ignite.authenticator.logger.a.a("%s : onPropertiesChanged", "OneDTPropertyWatchdog");
                        if (!cVar.c.c()) {
                            h hVar = cVar.d;
                            if (hVar != null) {
                                hVar.m();
                                return;
                            }
                            return;
                        }
                        com.digitalturbine.ignite.authenticator.logger.a.a("%s : onPropertiesChanged: will reconnect", "OneDTPropertyWatchdog");
                        h hVar2 = cVar.d;
                        if (hVar2 != null) {
                            com.digitalturbine.ignite.authenticator.logger.a.a("%s : one dt refresh required", "OneDTAuthenticator");
                            hVar2.k.set(true);
                        }
                        cVar.c.l();
                        return;
                    }
                }
            } catch (JSONException e) {
                com.digitalturbine.ignite.authenticator.events.b.a(d.ONE_DT_BROADCAST_ERROR, e);
            }
        }
    }
}
