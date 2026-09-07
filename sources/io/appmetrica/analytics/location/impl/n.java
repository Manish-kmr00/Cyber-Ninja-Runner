package io.appmetrica.analytics.location.impl;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import java.util.Iterator;

/* JADX INFO: loaded from: classes13.dex */
public final class n implements LocationListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p f11901a;

    public n(p pVar) {
        this.f11901a = pVar;
    }

    @Override // android.location.LocationListener
    public final void onLocationChanged(Location location) {
        if (location != null) {
            p pVar = this.f11901a;
            pVar.getClass();
            String provider = location.getProvider();
            t tVar = (t) pVar.e.get(provider);
            if (tVar == null) {
                t tVar2 = new t(pVar.f11903a.f11896a);
                tVar2.c.add(pVar.c);
                Iterator it = pVar.d.iterator();
                while (it.hasNext()) {
                    tVar2.c.add((Consumer) it.next());
                }
                pVar.e.put(provider, tVar2);
                tVar = tVar2;
            } else {
                tVar.f11905a = pVar.f11903a.f11896a;
            }
            if (tVar.d != null) {
                boolean zDidTimePassMillis = tVar.b.didTimePassMillis(tVar.e, tVar.f11905a.getUpdateTimeInterval(), "isSavedLocationOutdated");
                boolean z = true;
                boolean z2 = location.distanceTo(tVar.d) > tVar.f11905a.getUpdateDistanceInterval();
                if (tVar.d != null && location.getTime() - tVar.d.getTime() < 0) {
                    z = false;
                }
                if ((!zDidTimePassMillis && !z2) || !z) {
                    return;
                }
            }
            tVar.d = location;
            tVar.e = System.currentTimeMillis();
            Iterator it2 = tVar.c.iterator();
            while (it2.hasNext()) {
                ((Consumer) it2.next()).consume(location);
            }
        }
    }

    @Override // android.location.LocationListener
    public final void onProviderDisabled(String str) {
    }

    @Override // android.location.LocationListener
    public final void onProviderEnabled(String str) {
    }

    @Override // android.location.LocationListener
    public final void onStatusChanged(String str, int i, Bundle bundle) {
    }
}
