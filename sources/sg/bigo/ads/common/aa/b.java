package sg.bigo.ads.common.aa;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.hardware.display.DisplayManager;
import android.os.PowerManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.webkit.WebSettings;
import com.unity3d.services.ads.gmascar.utils.ScarConstants;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import sg.bigo.ads.common.d.e;
import sg.bigo.ads.common.utils.q;

/* JADX INFO: loaded from: classes8.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f13125a;
    private static final List<a> b = new CopyOnWriteArrayList();
    private static boolean c = false;
    private static String d = "-1";
    private static String e = "-1";
    private static int f = 0;
    private static final AtomicBoolean g = new AtomicBoolean(false);

    public interface a {
        void a(int i);
    }

    public static int a(Activity activity) {
        int rotation = activity.getWindowManager().getDefaultDisplay().getRotation();
        int i = activity.getResources().getConfiguration().orientation;
        if (1 == i) {
            return (rotation == 1 || rotation == 2) ? 9 : 1;
        }
        if (2 == i) {
            return (rotation == 2 || rotation == 3) ? 8 : 0;
        }
        sg.bigo.ads.common.t.a.a(0, "DeviceUtil", "Unknown orientation. return portrait by default");
        return 9;
    }

    public static void a() {
        d = "-1";
        e = "-1";
    }

    public static synchronized void a(Context context, a aVar) {
        if (context != null) {
            List<a> list = b;
            if (!list.contains(aVar)) {
                list.add(aVar);
            }
            if (!c) {
                c = true;
                sg.bigo.ads.common.t.a.a(0, 3, "DeviceUtil", "registerScreenListener");
                sg.bigo.ads.common.d.a.a().a(context, new e() { // from class: sg.bigo.ads.common.aa.b.1
                    /* JADX WARN: Code duplicated, block: B:15:0x0041  */
                    /* JADX WARN: Code duplicated, block: B:18:0x004f A[LOOP:0: B:16:0x0049->B:18:0x004f, LOOP_END] */
                    /* JADX WARN: Code duplicated, block: B:19:0x005d A[ORIG_RETURN, RETURN] */
                    @Override // sg.bigo.ads.common.d.b
                    public final void a(Context context2, Intent intent) {
                        Iterator it;
                        int i;
                        String action = intent.getAction();
                        if (q.a((CharSequence) action)) {
                            return;
                        }
                        int i2 = b.f13125a;
                        sg.bigo.ads.common.t.a.a(0, 3, "DeviceUtil", "action = ".concat(String.valueOf(action)));
                        action.hashCode();
                        if (!action.equals("android.intent.action.SCREEN_OFF")) {
                            i = action.equals("android.intent.action.USER_PRESENT") ? 1 : 2;
                            if (i2 != b.f13125a) {
                                it = b.b.iterator();
                                while (it.hasNext()) {
                                    ((a) it.next()).a(b.f13125a);
                                }
                            }
                        }
                        int unused = b.f13125a = i;
                        if (i2 != b.f13125a) {
                            it = b.b.iterator();
                            while (it.hasNext()) {
                                ((a) it.next()).a(b.f13125a);
                            }
                        }
                    }
                });
            }
        }
    }

    public static boolean a(Context context) {
        PowerManager powerManager;
        if (context == null) {
            return false;
        }
        if (f13125a == 0) {
            f13125a = (context == null || !((powerManager = (PowerManager) context.getSystemService("power")) == null || powerManager.isScreenOn())) ? 2 : 1;
        }
        return f13125a == 1;
    }

    public static String b(Context context) {
        Resources resources;
        Locale locale;
        if (context == null || (resources = context.getResources()) == null || (locale = resources.getConfiguration().locale) == null) {
            return Locale.US.getLanguage();
        }
        String language = locale.getLanguage();
        if (language.equals("iw")) {
            return "he";
        }
        if (language.equals(ScarConstants.IN_SIGNAL_KEY)) {
            return "id";
        }
        return language.equals("ji") ? "yi" : language;
    }

    public static boolean b() {
        return f() && f == 1;
    }

    public static String c(Context context) {
        Resources resources;
        Locale locale;
        return (context == null || (resources = context.getResources()) == null || (locale = resources.getConfiguration().locale) == null) ? "zz" : locale.getCountry();
    }

    public static String d(Context context) {
        if (context == null) {
            return "";
        }
        if ("-1".equals(d)) {
            d = "";
            if (!sg.bigo.ads.common.utils.c.a(context, "android.permission.READ_PHONE_STATE")) {
                return d;
            }
            try {
                d = ((TelephonyManager) context.getSystemService("phone")).getSimOperatorName();
            } catch (Exception unused) {
            }
        }
        return d;
    }

    public static String e(Context context) {
        if (context == null) {
            return "";
        }
        if ("-1".equals(e)) {
            e = "";
            if (!sg.bigo.ads.common.utils.c.a(context, "android.permission.READ_PHONE_STATE")) {
                return e;
            }
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                String networkCountryIso = telephonyManager.getNetworkCountryIso();
                e = networkCountryIso;
                if (TextUtils.isEmpty(networkCountryIso)) {
                    e = telephonyManager.getSimCountryIso();
                }
            } catch (Exception unused) {
            }
        }
        return e;
    }

    public static String f(Context context) {
        String str;
        try {
            str = context.getPackageManager().getPackageInfo("com.google.android.webview", 0).versionName;
        } catch (Exception unused) {
            str = "";
        }
        try {
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
            String defaultUserAgent = WebSettings.getDefaultUserAgent(context);
            return !TextUtils.isEmpty(defaultUserAgent) ? defaultUserAgent.substring(defaultUserAgent.indexOf("Chrome/") + 7, defaultUserAgent.indexOf("Mobile")).trim() : defaultUserAgent;
        } catch (Exception unused2) {
            return str;
        }
    }

    private static boolean f() {
        return true;
    }

    public static void g(Context context) {
        if (g.getAndSet(true) || context == null || !f()) {
            return;
        }
        sg.bigo.ads.common.t.a.a(0, 3, "DeviceUtil", "Register display listener");
        final DisplayManager displayManager = (DisplayManager) context.getSystemService("display");
        displayManager.registerDisplayListener(new DisplayManager.DisplayListener() { // from class: sg.bigo.ads.common.aa.b.2
            @Override // android.hardware.display.DisplayManager.DisplayListener
            public final void onDisplayAdded(int i) {
            }

            @Override // android.hardware.display.DisplayManager.DisplayListener
            public final void onDisplayChanged(int i) {
                if (i == 0) {
                    try {
                        int unused = b.f = displayManager.getDisplay(i).getState();
                    } catch (Throwable unused2) {
                    }
                }
                sg.bigo.ads.common.t.a.a(0, 3, "DeviceUtil", "onDisplayChanged: " + i + ", sDefaultDisplayState: " + b.f);
            }

            @Override // android.hardware.display.DisplayManager.DisplayListener
            public final void onDisplayRemoved(int i) {
            }
        }, null);
    }

    public static sg.bigo.ads.common.b h(Context context) {
        Intent intentRegisterReceiver;
        if (context != null) {
            try {
                intentRegisterReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            } catch (Exception e2) {
                sg.bigo.ads.common.t.a.a(0, 3, "DeviceUtil", "getBatteryLevel exception: " + e2.getMessage());
            }
        } else {
            intentRegisterReceiver = null;
        }
        if (intentRegisterReceiver != null) {
            return new sg.bigo.ads.common.b(intentRegisterReceiver.getIntExtra("level", -1), intentRegisterReceiver.getIntExtra("scale", -1), intentRegisterReceiver.getIntExtra("status", -1));
        }
        return null;
    }
}
