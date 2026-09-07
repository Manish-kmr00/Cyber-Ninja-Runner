package com.fyber.inneractive.sdk.util;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.json.x8;

/* JADX INFO: loaded from: classes7.dex */
public enum a0 {
    UNKNOWN(""),
    ETHERNET(x8.f4583a),
    WIFI(x8.b),
    MOBILE_3G(x8.f4583a),
    MOBILE_4G("4g"),
    MOBILE_5G("5g"),
    CELLULAR("Cellular");

    final String key;

    a0(String str) {
        this.key = str;
    }

    /* JADX WARN: Code duplicated, block: B:46:0x006e  */
    public static a0 a() {
        int type;
        a0 a0Var;
        NetworkInfo activeNetworkInfo;
        try {
            type = (!AbstractC3251o.a("android.permission.ACCESS_NETWORK_STATE") || (activeNetworkInfo = ((ConnectivityManager) AbstractC3251o.f2370a.getSystemService("connectivity")).getActiveNetworkInfo()) == null) ? 8 : activeNetworkInfo.getType();
        } catch (Exception unused) {
        }
        if (type == 9) {
            return ETHERNET;
        }
        if (type != 0) {
            if (type == 1) {
                return WIFI;
            }
            if (type != 2 && type != 3 && type != 4 && type != 5) {
                return UNKNOWN;
            }
        }
        com.fyber.inneractive.sdk.config.cellular.a aVar = IAConfigManager.O.N;
        if (aVar == null || aVar.f1687a == null) {
            int iL = AbstractC3247k.l();
            if (iL == 0) {
                a0Var = UNKNOWN;
            } else if (iL == 3) {
                a0Var = MOBILE_3G;
            } else if (iL == 18) {
                a0Var = WIFI;
            } else if (iL == 20) {
                a0Var = MOBILE_5G;
            } else if (iL != 5 && iL != 6) {
                switch (iL) {
                    default:
                        switch (iL) {
                            case 12:
                            case 14:
                            case 15:
                                break;
                            case 13:
                                a0Var = MOBILE_4G;
                                break;
                            default:
                                a0Var = CELLULAR;
                                break;
                        }
                    case 8:
                    case 9:
                    case 10:
                        a0Var = MOBILE_3G;
                        break;
                }
            } else {
                a0Var = MOBILE_3G;
            }
        } else {
            a0Var = aVar.b;
        }
        if (a0Var == UNKNOWN) {
            return AbstractC3247k.l() == 13 ? MOBILE_4G : MOBILE_3G;
        }
        return a0Var;
    }

    public final String b() {
        return this.key;
    }
}
