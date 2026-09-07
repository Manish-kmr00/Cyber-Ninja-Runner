package com.yandex.mobile.ads.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import android.telephony.TelephonyCallback;
import android.telephony.TelephonyDisplayInfo;
import android.telephony.TelephonyManager;
import java.lang.ref.WeakReference;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class ad1 {
    private static ad1 e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Handler f8392a = new Handler(Looper.getMainLooper());
    private final CopyOnWriteArrayList<WeakReference<b>> b = new CopyOnWriteArrayList<>();
    private final Object c = new Object();
    private int d = 0;

    public interface b {
        void a(int i);
    }

    private ad1(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        context.registerReceiver(new c(), intentFilter);
    }

    public final int a() {
        int i;
        synchronized (this.c) {
            i = this.d;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return 0;
        }
        try {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                return 1;
            }
            int type = activeNetworkInfo.getType();
            if (type != 0) {
                if (type == 1) {
                    return 2;
                }
                if (type == 9) {
                    return 7;
                }
                if (type != 4 && type != 5) {
                    return type != 6 ? 8 : 5;
                }
            }
            switch (activeNetworkInfo.getSubtype()) {
                case 1:
                case 2:
                    return 3;
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                case 14:
                case 15:
                case 17:
                    return 4;
                case 13:
                    return 5;
                case 16:
                case 19:
                default:
                    return 6;
                case 18:
                    return 2;
                case 20:
                    return x82.f10629a >= 29 ? 9 : 0;
            }
        } catch (SecurityException unused) {
            return 0;
        }
    }

    public final void b(final b bVar) {
        for (WeakReference<b> weakReference : this.b) {
            if (weakReference.get() == null) {
                this.b.remove(weakReference);
            }
        }
        this.b.add(new WeakReference<>(bVar));
        this.f8392a.post(new Runnable() { // from class: com.yandex.mobile.ads.impl.ad1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(bVar);
            }
        });
    }

    private final class c extends BroadcastReceiver {
        private c() {
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            int iB = ad1.b(context);
            if (x82.f10629a >= 31 && iB == 5) {
                a.a(context, ad1.this);
            } else {
                ad1.this.a(iB);
            }
        }
    }

    private static final class a {
        public static void a(Context context, ad1 ad1Var) {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                telephonyManager.getClass();
                C0735a c0735a = new C0735a(ad1Var);
                telephonyManager.registerTelephonyCallback(context.getMainExecutor(), c0735a);
                telephonyManager.unregisterTelephonyCallback(c0735a);
            } catch (RuntimeException unused) {
                ad1Var.a(5);
            }
        }

        /* JADX INFO: renamed from: com.yandex.mobile.ads.impl.ad1$a$a, reason: collision with other inner class name */
        private static final class C0735a extends TelephonyCallback implements TelephonyCallback.DisplayInfoListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final ad1 f8393a;

            public C0735a(ad1 ad1Var) {
                this.f8393a = ad1Var;
            }

            @Override // android.telephony.TelephonyCallback.DisplayInfoListener
            public final void onDisplayInfoChanged(TelephonyDisplayInfo telephonyDisplayInfo) {
                int overrideNetworkType = telephonyDisplayInfo.getOverrideNetworkType();
                this.f8393a.a(overrideNetworkType == 3 || overrideNetworkType == 4 || overrideNetworkType == 5 ? 10 : 5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(b bVar) {
        bVar.a(a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        synchronized (this.c) {
            if (this.d == i) {
                return;
            }
            this.d = i;
            for (WeakReference<b> weakReference : this.b) {
                b bVar = weakReference.get();
                if (bVar != null) {
                    bVar.a(i);
                } else {
                    this.b.remove(weakReference);
                }
            }
        }
    }

    public static synchronized ad1 a(Context context) {
        if (e == null) {
            e = new ad1(context);
        }
        return e;
    }
}
