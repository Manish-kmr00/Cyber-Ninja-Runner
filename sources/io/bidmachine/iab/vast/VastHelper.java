package io.bidmachine.iab.vast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import android.view.View;
import java.util.Iterator;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class VastHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final WeakHashMap f12255a = new WeakHashMap();
    private static final BroadcastReceiver b = new a();
    private static final IntentFilter c;
    private static boolean d;
    private static boolean e;

    public interface OnScreenStateChangeListener {
        void onScreenStateChange(boolean isScreenOn);
    }

    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            synchronized (VastHelper.class) {
                boolean unused = VastHelper.e = "android.intent.action.SCREEN_ON".equals(intent.getAction());
            }
            WeakHashMap weakHashMap = VastHelper.f12255a;
            synchronized (weakHashMap) {
                Iterator it = weakHashMap.values().iterator();
                while (it.hasNext()) {
                    ((OnScreenStateChangeListener) it.next()).onScreenStateChange(VastHelper.e);
                }
            }
        }
    }

    static {
        IntentFilter intentFilter = new IntentFilter();
        c = intentFilter;
        d = false;
        e = false;
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
    }

    public static void addScreenStateChangeListener(View view, OnScreenStateChangeListener listener) {
        a(view.getContext());
        WeakHashMap weakHashMap = f12255a;
        synchronized (weakHashMap) {
            weakHashMap.put(view, listener);
        }
    }

    public static boolean isScreenOn(Context context) {
        a(context);
        return e;
    }

    public static void removeScreenStateChangeListener(View view) {
        if (d) {
            WeakHashMap weakHashMap = f12255a;
            synchronized (weakHashMap) {
                weakHashMap.remove(view);
            }
        }
    }

    private static synchronized void a(Context context) {
        if (!d) {
            synchronized (VastHelper.class) {
                if (!d) {
                    e = ((PowerManager) context.getSystemService("power")).isScreenOn();
                    context.getApplicationContext().registerReceiver(b, c);
                    d = true;
                }
            }
        }
    }
}
