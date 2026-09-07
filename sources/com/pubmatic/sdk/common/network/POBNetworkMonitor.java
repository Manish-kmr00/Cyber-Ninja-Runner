package com.pubmatic.sdk.common.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyCallback;
import android.telephony.TelephonyDisplayInfo;
import android.telephony.TelephonyManager;
import com.pubmatic.sdk.common.log.POBLog;
import com.pubmatic.sdk.common.taskhandler.POBTaskHandler;
import com.pubmatic.sdk.common.utility.POBUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes6.dex */
public class POBNetworkMonitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f7605a;
    private final ConnectivityManager c;
    protected List<POBConnectivityListener> connectivityListeners;
    private ConnectionType b = ConnectionType.UNKNOWN;
    private e d = null;
    private boolean e = false;

    public enum ConnectionType {
        UNKNOWN(0),
        ETHERNET(1),
        WIFI(2),
        CELLULAR_NETWORK_UN(3),
        CELLULAR_NETWORK_2G(4),
        CELLULAR_NETWORK_3G(5),
        CELLULAR_NETWORK_4G(6),
        CELLULAR_NETWORK_5G(7);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f7606a;

        ConnectionType(int i) {
            this.f7606a = i;
        }

        public int getValue() {
            return this.f7606a;
        }
    }

    public interface POBConnectivityListener {
        void onNetworkConnectionChanged(boolean z);

        void onNetworkRegistrationFailed();
    }

    class a implements e.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ TelephonyManager f7607a;

        a(TelephonyManager telephonyManager) {
            this.f7607a = telephonyManager;
        }

        @Override // com.pubmatic.sdk.common.network.POBNetworkMonitor.e.a
        public void a(TelephonyDisplayInfo telephonyDisplayInfo) {
            POBNetworkMonitor pOBNetworkMonitor = POBNetworkMonitor.this;
            pOBNetworkMonitor.b = pOBNetworkMonitor.a(telephonyDisplayInfo);
            if (POBNetworkMonitor.this.d != null) {
                this.f7607a.unregisterTelephonyCallback(POBNetworkMonitor.this.d);
            }
        }
    }

    class b extends PhoneStateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ TelephonyManager f7608a;

        b(TelephonyManager telephonyManager) {
            this.f7608a = telephonyManager;
        }

        @Override // android.telephony.PhoneStateListener
        public void onDisplayInfoChanged(TelephonyDisplayInfo telephonyDisplayInfo) {
            super.onDisplayInfoChanged(telephonyDisplayInfo);
            POBNetworkMonitor pOBNetworkMonitor = POBNetworkMonitor.this;
            pOBNetworkMonitor.b = pOBNetworkMonitor.a(telephonyDisplayInfo);
            this.f7608a.listen(this, 0);
        }
    }

    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            POBNetworkMonitor.this.b();
        }
    }

    private class d extends ConnectivityManager.NetworkCallback {
        private d() {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            POBNetworkMonitor.this.a();
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            POBNetworkMonitor.this.a();
        }

        /* synthetic */ d(POBNetworkMonitor pOBNetworkMonitor, a aVar) {
            this();
        }
    }

    private static class e extends TelephonyCallback implements TelephonyCallback.DisplayInfoListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final a f7611a;

        interface a {
            void a(TelephonyDisplayInfo telephonyDisplayInfo);
        }

        public e(a aVar) {
            this.f7611a = aVar;
        }

        @Override // android.telephony.TelephonyCallback.DisplayInfoListener
        public void onDisplayInfoChanged(TelephonyDisplayInfo telephonyDisplayInfo) {
            this.f7611a.a(telephonyDisplayInfo);
        }
    }

    public POBNetworkMonitor(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f7605a = applicationContext;
        this.c = (ConnectivityManager) applicationContext.getSystemService("connectivity");
        c();
        updateConnectionType();
    }

    private void d() {
        int networkType;
        TelephonyManager telephonyManager = (TelephonyManager) this.f7605a.getSystemService("phone");
        if (telephonyManager == null) {
            this.b = ConnectionType.CELLULAR_NETWORK_UN;
            return;
        }
        if (Build.VERSION.SDK_INT >= 30) {
            a(telephonyManager);
            return;
        }
        try {
            networkType = telephonyManager.getNetworkType();
        } catch (Exception e2) {
            POBLog.error("POBNetworkMonitor", "Failed to get telephony manager :" + e2.getMessage(), new Object[0]);
            networkType = 0;
        }
        this.b = a(networkType);
    }

    public boolean isNetworkAvailable() {
        return isNetworkAvailable(this.f7605a);
    }

    public void registerConnectivityListener(POBConnectivityListener pOBConnectivityListener) {
        if (this.e) {
            pOBConnectivityListener.onNetworkRegistrationFailed();
            return;
        }
        if (this.connectivityListeners == null) {
            this.connectivityListeners = new ArrayList(1);
        }
        this.connectivityListeners.add(pOBConnectivityListener);
    }

    public void resetConnectivityListener() {
        List<POBConnectivityListener> list = this.connectivityListeners;
        if (list != null) {
            list.clear();
            this.connectivityListeners = null;
        }
    }

    public void unregisterConnectivityListener(POBConnectivityListener pOBConnectivityListener) {
        List<POBConnectivityListener> list;
        if (pOBConnectivityListener == null || (list = this.connectivityListeners) == null || !list.contains(pOBConnectivityListener)) {
            return;
        }
        this.connectivityListeners.remove(pOBConnectivityListener);
        if (this.connectivityListeners.isEmpty()) {
            this.connectivityListeners = null;
        }
    }

    public void updateConnectionType() {
        NetworkInfo activeNetworkInfo;
        if (this.c == null || !POBUtils.hasPermission(this.f7605a, "android.permission.ACCESS_NETWORK_STATE")) {
            this.b = ConnectionType.UNKNOWN;
            return;
        }
        try {
            activeNetworkInfo = this.c.getActiveNetworkInfo();
        } catch (Exception e2) {
            POBLog.warn("POBNetworkMonitor", "Failed to get active network info :" + e2.getMessage(), new Object[0]);
            activeNetworkInfo = null;
        }
        if (activeNetworkInfo == null) {
            this.b = ConnectionType.UNKNOWN;
            return;
        }
        int type = activeNetworkInfo.getType();
        if (type == 0) {
            d();
        } else if (type == 1) {
            this.b = ConnectionType.WIFI;
        } else {
            if (type != 9) {
                return;
            }
            this.b = ConnectionType.ETHERNET;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        updateConnectionType();
        if (this.connectivityListeners != null) {
            for (int i = 0; i < this.connectivityListeners.size(); i++) {
                POBConnectivityListener pOBConnectivityListener = this.connectivityListeners.get(i);
                if (pOBConnectivityListener != null) {
                    pOBConnectivityListener.onNetworkConnectionChanged(isNetworkAvailable(this.f7605a));
                }
            }
        }
    }

    private void c() {
        ConnectivityManager connectivityManager = this.c;
        if (connectivityManager != null) {
            try {
                connectivityManager.registerDefaultNetworkCallback(new d(this, null));
                this.e = false;
            } catch (RuntimeException e2) {
                this.e = true;
                POBLog.warn("POBNetworkMonitor", "Failed to register network callback :" + e2.getMessage(), new Object[0]);
            }
        }
    }

    public static boolean isNetworkAvailable(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            return connectivityManager != null && POBUtils.hasPermission(context, "android.permission.ACCESS_NETWORK_STATE") && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isConnectedOrConnecting();
        } catch (Exception e2) {
            POBLog.warn("POBNetworkMonitor", "Failed to check network availability :" + e2.getMessage(), new Object[0]);
        }
        return false;
    }

    private void a(TelephonyManager telephonyManager) {
        if (POBUtils.hasPermission(this.f7605a, "android.permission.READ_PHONE_STATE")) {
            try {
                if (Build.VERSION.SDK_INT >= 31) {
                    Executor executorNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
                    e eVar = new e(new a(telephonyManager));
                    this.d = eVar;
                    telephonyManager.registerTelephonyCallback(executorNewSingleThreadExecutor, eVar);
                } else {
                    telephonyManager.listen(new b(telephonyManager), 1048576);
                }
                return;
            } catch (Exception e2) {
                this.b = ConnectionType.CELLULAR_NETWORK_UN;
                POBLog.warn("POBNetworkMonitor", "Not able fetch connection type due to " + e2.getMessage(), new Object[0]);
                return;
            }
        }
        this.b = ConnectionType.CELLULAR_NETWORK_UN;
        POBLog.warn("POBNetworkMonitor", "Not able fetch connection type due to android.permission.READ_PHONE_STATE permission is not available for the app!", new Object[0]);
    }

    public ConnectionType getConnectionType() {
        return this.b;
    }

    public boolean isWiFiConnected() {
        return this.b == ConnectionType.WIFI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ConnectionType a(TelephonyDisplayInfo telephonyDisplayInfo) {
        if (telephonyDisplayInfo.getOverrideNetworkType() != 2 && telephonyDisplayInfo.getOverrideNetworkType() != 3 && telephonyDisplayInfo.getOverrideNetworkType() != 5) {
            return a(telephonyDisplayInfo.getNetworkType());
        }
        return ConnectionType.CELLULAR_NETWORK_5G;
    }

    private ConnectionType a(int i) {
        if (i != 20) {
            switch (i) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                    return ConnectionType.CELLULAR_NETWORK_2G;
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                    return ConnectionType.CELLULAR_NETWORK_3G;
                case 13:
                    return ConnectionType.CELLULAR_NETWORK_4G;
                default:
                    return ConnectionType.CELLULAR_NETWORK_UN;
            }
        }
        return ConnectionType.CELLULAR_NETWORK_5G;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        POBTaskHandler.getInstance().runOnMainThread(new c());
    }
}
