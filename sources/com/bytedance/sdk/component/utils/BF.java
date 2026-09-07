package com.bytedance.sdk.component.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes5.dex */
public class BF {
    private static final Object pA = new Object();
    private static final Map<pA, Object> Og = new ConcurrentHashMap();
    private static AtomicBoolean KZx = new AtomicBoolean(false);
    private static volatile int ZZv = -1;
    private static volatile long ML = 0;
    private static volatile int JG = 60000;
    private static oX SD = null;
    private static final AtomicBoolean omh = new AtomicBoolean(false);

    public interface pA {
        void pA(Context context, Intent intent, boolean z, int i);
    }

    public static int pA(Context context, long j) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (ML + j <= jElapsedRealtime) {
            return Og(context);
        }
        if (ZZv == -1) {
            return Og(context);
        }
        if (jElapsedRealtime - ML >= JG) {
            Og(context, (Intent) null, false, false);
        }
        return ZZv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void Og(final Context context, final Intent intent, final boolean z, final boolean z2) {
        if (!z && z2) {
            ZZv = 0;
        } else if (omh.compareAndSet(false, true)) {
            com.bytedance.sdk.component.omh.JG.Og(new com.bytedance.sdk.component.omh.omh("getNetworkType") { // from class: com.bytedance.sdk.component.utils.BF.1
                @Override // java.lang.Runnable
                public void run() {
                    int unused = BF.ZZv = z2 ? 0 : BF.Og(context);
                    BF.omh.set(false);
                    if (z) {
                        BF.Og(context, intent, BF.ZZv, z2);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void Og(Context context, Intent intent, int i, boolean z) {
        Map<pA, Object> map = Og;
        if (map == null || map.size() <= 0) {
            return;
        }
        for (pA pAVar : map.keySet()) {
            if (pAVar != null) {
                pAVar.pA(context, intent, !z, i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int Og(Context context) {
        ZZv = KZx(context);
        ML = SystemClock.elapsedRealtime();
        return ZZv;
    }

    private static int KZx(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                int type = activeNetworkInfo.getType();
                if (type != 0) {
                    return type != 1 ? 1 : 4;
                }
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                switch (activeNetworkInfo.getSubtype()) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                    case 16:
                        return 2;
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 14:
                    case 15:
                    case 17:
                        return 3;
                    case 13:
                    case 18:
                    case 19:
                        oX oXVar = SD;
                        return (oXVar == null || !oXVar.pA(context, telephonyManager)) ? 5 : 6;
                    case 20:
                        return 6;
                    default:
                        String subtypeName = activeNetworkInfo.getSubtypeName();
                        return (TextUtils.isEmpty(subtypeName) || !(subtypeName.equalsIgnoreCase("TD-SCDMA") || subtypeName.equalsIgnoreCase("WCDMA") || subtypeName.equalsIgnoreCase("CDMA2000"))) ? 1 : 3;
                }
            }
            return 0;
        } catch (Throwable unused) {
            return 1;
        }
    }

    public static void pA(pA pAVar, Context context) {
        if (pAVar == null) {
            return;
        }
        if (!KZx.get()) {
            try {
                context.registerReceiver(new Og(), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                KZx.set(true);
            } catch (Throwable unused) {
            }
        }
        Og.put(pAVar, pA);
    }

    public static void pA(pA pAVar) {
        if (pAVar == null) {
            return;
        }
        Og.remove(pAVar);
    }

    private static class Og extends BroadcastReceiver {
        private Og() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            boolean z = false;
            boolean booleanExtra = intent.getBooleanExtra("noConnectivity", false);
            if (BF.Og != null && BF.Og.size() > 0) {
                z = true;
            }
            BF.Og(context, intent, z, booleanExtra);
        }
    }
}
