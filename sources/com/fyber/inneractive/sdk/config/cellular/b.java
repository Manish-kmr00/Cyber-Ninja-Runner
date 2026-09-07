package com.fyber.inneractive.sdk.config.cellular;

import android.telephony.TelephonyCallback;
import android.telephony.TelephonyDisplayInfo;
import android.telephony.TelephonyManager;
import com.fyber.inneractive.sdk.util.a0;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes11.dex */
public final class b extends TelephonyCallback implements TelephonyCallback.DisplayInfoListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ExecutorService f1688a = Executors.newSingleThreadExecutor();
    public h b;
    public final TelephonyManager c;

    public b(TelephonyManager telephonyManager, h hVar) {
        this.c = telephonyManager;
        this.b = hVar;
    }

    public final void a() {
        this.b = null;
        TelephonyManager telephonyManager = this.c;
        if (telephonyManager != null) {
            telephonyManager.unregisterTelephonyCallback(this);
        }
        this.f1688a.shutdownNow();
    }

    public final void b() {
        TelephonyManager telephonyManager = this.c;
        if (telephonyManager != null) {
            telephonyManager.registerTelephonyCallback(this.f1688a, this);
        }
    }

    public final void c() {
        TelephonyManager telephonyManager = this.c;
        if (telephonyManager != null) {
            telephonyManager.unregisterTelephonyCallback(this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0034  */
    @Override // android.telephony.TelephonyCallback.DisplayInfoListener
    public final void onDisplayInfoChanged(TelephonyDisplayInfo telephonyDisplayInfo) {
        a0 a0Var;
        int networkType = telephonyDisplayInfo.getNetworkType();
        int overrideNetworkType = telephonyDisplayInfo.getOverrideNetworkType();
        if (overrideNetworkType == 2 || overrideNetworkType == 3 || overrideNetworkType == 5) {
            a0Var = a0.MOBILE_5G;
        } else if (networkType == 0) {
            a0Var = a0.UNKNOWN;
        } else if (networkType == 3) {
            a0Var = a0.MOBILE_3G;
        } else if (networkType == 18) {
            a0Var = a0.WIFI;
        } else if (networkType == 20) {
            a0Var = a0.MOBILE_5G;
        } else if (networkType != 5 && networkType != 6) {
            switch (networkType) {
                default:
                    switch (networkType) {
                        case 12:
                        case 14:
                        case 15:
                            break;
                        case 13:
                            a0Var = a0.MOBILE_4G;
                            break;
                        default:
                            a0Var = a0.CELLULAR;
                            break;
                    }
                case 8:
                case 9:
                case 10:
                    a0Var = a0.MOBILE_3G;
                    break;
            }
        } else {
            a0Var = a0.MOBILE_3G;
        }
        h hVar = this.b;
        if (hVar != null) {
            hVar.a(a0Var);
        }
    }
}
