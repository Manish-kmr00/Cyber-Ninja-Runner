package com.inmobi.media;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.PowerManager;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class Ib {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap f3099a = new ConcurrentHashMap();
    public static Hb b;
    public static boolean c;

    public static void a(String str) {
        Context contextD = C3517pb.d();
        if (contextD != null) {
            if (!C3435k3.f3355a.x() || !Intrinsics.areEqual("SYSTEM_CONNECTIVITY_CHANGE", str)) {
                ConcurrentHashMap concurrentHashMap = f3099a;
                if (concurrentHashMap.get(str) == null) {
                    Fb fb = new Fb();
                    concurrentHashMap.put(str, fb);
                    AbstractC3420j2.a(contextD, fb, new IntentFilter(str));
                    return;
                }
                return;
            }
            Object systemService = contextD.getSystemService("connectivity");
            ConnectivityManager connectivityManager = systemService instanceof ConnectivityManager ? (ConnectivityManager) systemService : null;
            if (connectivityManager != null) {
                Hb hb = new Hb();
                b = hb;
                connectivityManager.registerDefaultNetworkCallback(hb);
            }
        }
    }

    public static void b() {
        Intrinsics.checkNotNullExpressionValue("Ib", "TAG");
        a("android.intent.action.ACTION_SHUTDOWN");
        a("android.intent.action.REBOOT");
        C3435k3 c3435k3 = C3435k3.f3355a;
        if (c3435k3.H()) {
            a("android.os.action.DEVICE_IDLE_MODE_CHANGED");
        }
        a("android.intent.action.USER_PRESENT");
        if (c3435k3.x()) {
            a("SYSTEM_CONNECTIVITY_CHANGE");
        } else {
            a("android.net.conn.CONNECTIVITY_CHANGE");
        }
        C3517pb.f().a(new int[]{0}, Gb.f3083a);
    }

    public static void b(String action) {
        Intrinsics.checkNotNullParameter(action, "action");
        Context contextD = C3517pb.d();
        if (contextD != null) {
            if (C3435k3.f3355a.x() && Intrinsics.areEqual("SYSTEM_CONNECTIVITY_CHANGE", action) && b != null) {
                Object systemService = contextD.getSystemService("connectivity");
                ConnectivityManager connectivityManager = systemService instanceof ConnectivityManager ? (ConnectivityManager) systemService : null;
                if (connectivityManager != null) {
                    Hb hb = b;
                    Intrinsics.checkNotNull(hb);
                    connectivityManager.unregisterNetworkCallback(hb);
                    b = null;
                    return;
                }
                return;
            }
            ConcurrentHashMap concurrentHashMap = f3099a;
            if (concurrentHashMap.get(action) != null) {
                contextD.unregisterReceiver((BroadcastReceiver) concurrentHashMap.get(action));
                concurrentHashMap.remove(action);
            }
        }
    }

    public static void a() {
        Intrinsics.checkNotNullExpressionValue("Ib", "TAG");
        b("android.intent.action.ACTION_SHUTDOWN");
        b("android.intent.action.REBOOT");
        C3435k3 c3435k3 = C3435k3.f3355a;
        if (c3435k3.H()) {
            b("android.os.action.DEVICE_IDLE_MODE_CHANGED");
        }
        b("android.intent.action.USER_PRESENT");
        if (c3435k3.x()) {
            b("SYSTEM_CONNECTIVITY_CHANGE");
        } else {
            b("android.net.conn.CONNECTIVITY_CHANGE");
        }
        f3099a.clear();
    }

    public static final boolean a(Context context) {
        Object systemService = context.getSystemService("power");
        PowerManager powerManager = systemService instanceof PowerManager ? (PowerManager) systemService : null;
        if (powerManager == null || !C3435k3.f3355a.H()) {
            return false;
        }
        return powerManager.isDeviceIdleMode();
    }
}
