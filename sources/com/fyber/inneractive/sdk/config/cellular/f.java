package com.fyber.inneractive.sdk.config.cellular;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import com.fyber.inneractive.sdk.util.AbstractC3247k;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.a0;

/* JADX INFO: loaded from: classes11.dex */
public final class f extends ConnectivityManager.NetworkCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public h f1690a;
    public final ConnectivityManager b;

    public f(ConnectivityManager connectivityManager, h hVar) {
        this.f1690a = hVar;
        this.b = connectivityManager;
    }

    public final void a() {
        this.f1690a = null;
        ConnectivityManager connectivityManager = this.b;
        if (connectivityManager != null) {
            try {
                connectivityManager.unregisterNetworkCallback(this);
            } catch (Throwable th) {
                IAlog.a("failed to unregister network callback", th, new Object[0]);
            }
        }
    }

    public final void b() {
        ConnectivityManager connectivityManager = this.b;
        if (connectivityManager != null) {
            try {
                connectivityManager.registerDefaultNetworkCallback(this);
            } catch (Throwable th) {
                IAlog.a("failed to register network callback", th, new Object[0]);
            }
        }
    }

    public final void c() {
        ConnectivityManager connectivityManager = this.b;
        if (connectivityManager != null) {
            try {
                connectivityManager.unregisterNetworkCallback(this);
            } catch (Throwable th) {
                IAlog.a("failed to unregister network callback", th, new Object[0]);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:24:0x003b  */
    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
        a0 a0Var = a0.UNKNOWN;
        if (networkCapabilities.hasTransport(3)) {
            a0Var = a0.ETHERNET;
        } else if (networkCapabilities.hasTransport(0)) {
            int iL = AbstractC3247k.l();
            if (iL != 0) {
                if (iL == 3) {
                    a0Var = a0.MOBILE_3G;
                } else if (iL == 18) {
                    a0Var = a0.WIFI;
                } else if (iL == 20) {
                    a0Var = a0.MOBILE_5G;
                } else if (iL != 5 && iL != 6) {
                    switch (iL) {
                        default:
                            switch (iL) {
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
            }
        } else if (networkCapabilities.hasTransport(1)) {
            a0Var = a0.WIFI;
        }
        h hVar = this.f1690a;
        if (hVar != null) {
            hVar.a(a0Var);
        }
    }
}
