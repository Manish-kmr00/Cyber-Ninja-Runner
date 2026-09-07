package com.applovin.impl.sdk;

import android.content.Intent;
import android.content.IntentFilter;
import com.amazon.aps.shared.util.APSSharedUtil;
import com.applovin.impl.s1;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes4.dex */
public class a implements AppLovinBroadcastManager.Receiver {
    private static final long e = TimeUnit.SECONDS.toMillis(2);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final k f634a;
    private final o b;
    private final HashSet c = new HashSet();
    private final Object d = new Object();

    /* JADX INFO: renamed from: com.applovin.impl.sdk.a$a, reason: collision with other inner class name */
    public interface InterfaceC0139a {
        void onAdExpired(s1 s1Var);
    }

    public a(k kVar) {
        this.f634a = kVar;
        this.b = kVar.O();
    }

    private b b(s1 s1Var) {
        synchronized (this.d) {
            try {
                if (s1Var == null) {
                    return null;
                }
                for (b bVar : this.c) {
                    if (s1Var == bVar.b()) {
                        return bVar;
                    }
                }
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean a(s1 s1Var, InterfaceC0139a interfaceC0139a) {
        synchronized (this.d) {
            if (b(s1Var) != null) {
                if (o.a()) {
                    this.b.a("AdExpirationManager", "Ad expiration already scheduled for ad: " + s1Var);
                }
                return true;
            }
            if (s1Var.getTimeToLiveMillis() <= e) {
                if (o.a()) {
                    this.b.a("AdExpirationManager", "Ad has already expired: " + s1Var);
                }
                s1Var.setExpired();
                return false;
            }
            if (o.a()) {
                this.b.a("AdExpirationManager", "Scheduling ad expiration " + TimeUnit.MILLISECONDS.toSeconds(s1Var.getTimeToLiveMillis()) + " seconds from now for " + s1Var + APSSharedUtil.TRUNCATE_SEPARATOR);
            }
            if (this.c.isEmpty()) {
                AppLovinBroadcastManager.registerReceiver(this, new IntentFilter(SessionTracker.ACTION_APPLICATION_PAUSED));
                AppLovinBroadcastManager.registerReceiver(this, new IntentFilter(SessionTracker.ACTION_APPLICATION_RESUMED));
            }
            this.c.add(b.a(s1Var, interfaceC0139a, this.f634a));
            return true;
        }
    }

    @Override // com.applovin.impl.sdk.AppLovinBroadcastManager.Receiver
    public void onReceive(Intent intent, Map map) {
        String action = intent.getAction();
        if (SessionTracker.ACTION_APPLICATION_PAUSED.equals(action)) {
            a();
        } else if (SessionTracker.ACTION_APPLICATION_RESUMED.equals(action)) {
            b();
        }
    }

    private void b() {
        HashSet<b> hashSet = new HashSet();
        synchronized (this.d) {
            for (b bVar : this.c) {
                s1 s1VarB = bVar.b();
                if (s1VarB == null) {
                    hashSet.add(bVar);
                } else {
                    long timeToLiveMillis = s1VarB.getTimeToLiveMillis();
                    if (timeToLiveMillis <= 0) {
                        if (o.a()) {
                            this.b.a("AdExpirationManager", "Ad expired while app was paused. Preparing to notify listener for ad: " + s1VarB);
                        }
                        hashSet.add(bVar);
                    } else {
                        if (o.a()) {
                            this.b.a("AdExpirationManager", "Rescheduling expiration with remaining " + TimeUnit.MILLISECONDS.toSeconds(timeToLiveMillis) + " seconds for ad: " + s1VarB);
                        }
                        bVar.a(timeToLiveMillis);
                    }
                }
            }
        }
        for (b bVar2 : hashSet) {
            a(bVar2);
            bVar2.d();
        }
    }

    public void a(s1 s1Var) {
        synchronized (this.d) {
            b bVarB = b(s1Var);
            if (bVarB != null) {
                if (o.a()) {
                    this.b.a("AdExpirationManager", "Cancelling expiration timer for ad: " + s1Var);
                }
                bVarB.a();
                a(bVarB);
            }
        }
    }

    public void a(b bVar) {
        synchronized (this.d) {
            this.c.remove(bVar);
            if (this.c.isEmpty()) {
                AppLovinBroadcastManager.unregisterReceiver(this);
            }
        }
    }

    private void a() {
        synchronized (this.d) {
            Iterator it = this.c.iterator();
            while (it.hasNext()) {
                ((b) it.next()).a();
            }
        }
    }
}
