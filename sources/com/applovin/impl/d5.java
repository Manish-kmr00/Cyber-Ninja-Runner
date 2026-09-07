package com.applovin.impl;

import android.content.IntentFilter;
import com.applovin.communicator.AppLovinCommunicatorSubscriber;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.utils.StringUtils;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes7.dex */
public class d5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set f396a = new HashSet(32);
    private final Object b = new Object();

    public boolean a(String str) {
        synchronized (this.b) {
            Iterator it = this.f396a.iterator();
            while (it.hasNext()) {
                if (str.equals(((e5) it.next()).b())) {
                    return true;
                }
            }
            return false;
        }
    }

    public void b(AppLovinCommunicatorSubscriber appLovinCommunicatorSubscriber, String str) {
        e5 e5VarA;
        if (StringUtils.isValidString(str)) {
            synchronized (this.b) {
                e5VarA = a(str, appLovinCommunicatorSubscriber);
            }
            if (e5VarA != null) {
                e5VarA.a(false);
                AppLovinBroadcastManager.unregisterReceiver(e5VarA);
            }
        }
    }

    public boolean a(AppLovinCommunicatorSubscriber appLovinCommunicatorSubscriber, String str) {
        if (appLovinCommunicatorSubscriber != null && StringUtils.isValidString(str)) {
            synchronized (this.b) {
                e5 e5VarA = a(str, appLovinCommunicatorSubscriber);
                if (e5VarA != null) {
                    com.applovin.impl.sdk.o.h("AppLovinCommunicator", "Attempting to re-subscribe subscriber (" + appLovinCommunicatorSubscriber + ") to topic (" + str + ")");
                    if (!e5VarA.c()) {
                        e5VarA.a(true);
                        AppLovinBroadcastManager.registerReceiver(e5VarA, new IntentFilter(str));
                    }
                    return true;
                }
                e5 e5Var = new e5(str, appLovinCommunicatorSubscriber);
                this.f396a.add(e5Var);
                AppLovinBroadcastManager.registerReceiver(e5Var, new IntentFilter(str));
                return true;
            }
        }
        com.applovin.impl.sdk.o.h("AppLovinCommunicator", "Unable to subscribe - invalid subscriber (" + appLovinCommunicatorSubscriber + ") or topic (" + str + ")");
        return false;
    }

    private e5 a(String str, AppLovinCommunicatorSubscriber appLovinCommunicatorSubscriber) {
        for (e5 e5Var : this.f396a) {
            if (str.equals(e5Var.b()) && appLovinCommunicatorSubscriber.equals(e5Var.a())) {
                return e5Var;
            }
        }
        return null;
    }
}
