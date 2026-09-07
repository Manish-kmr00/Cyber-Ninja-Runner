package com.pgl.ssdk;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.text.TextUtils;
import android.view.Display;
import io.appmetrica.analytics.coreutils.internal.StringUtils;

/* JADX INFO: loaded from: classes11.dex */
public class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile DisplayManager.DisplayListener f7541a;
    private static volatile boolean b;
    private static String c;
    private static String d;
    private static String e;
    private static DisplayManager f;

    static class a implements DisplayManager.DisplayListener {
        a() {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayAdded(int i) {
            y.b(i, 1);
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayChanged(int i) {
            y.b(i, 3);
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayRemoved(int i) {
            y.b(i, 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(int i, int i2) {
        if (i == 0) {
            return;
        }
        try {
            String strA = a(i);
            if (i2 == 1) {
                if (strA.equals(c)) {
                    return;
                }
                c = strA;
            } else if (i2 == 2) {
                if (strA.equals(d)) {
                    return;
                }
                d = strA;
            } else {
                if (i2 != 3 || strA.equals(e)) {
                    return;
                }
                e = strA;
            }
        } catch (Throwable unused) {
        }
    }

    public static void c(Context context) {
        Handler handlerB;
        if (b) {
            return;
        }
        b = true;
        if (f7541a == null) {
            f7541a = new a();
        }
        if (f == null) {
            f = (DisplayManager) context.getSystemService("display");
        }
        if (f == null || (handlerB = o0.b()) == null) {
            return;
        }
        try {
            f.registerDisplayListener(f7541a, handlerB);
        } catch (Exception unused) {
        }
    }

    private static String a(Display display) {
        String name = display.getName();
        boolean z = false;
        Object objA = s0.a(display, display.getClass(), "getType", new Class[0], new Object[0]);
        Object objA2 = s0.a(display, display.getClass(), "getOwnerPackageName", new Class[0], new Object[0]);
        Object objA3 = s0.a(null, display.getClass(), "TYPE_VIRTUAL", null);
        if (objA != null && objA3 != null && ((Integer) objA).intValue() == ((Integer) objA3).intValue()) {
            z = true;
        }
        return String.format("%s#%s#%b", objA2, name, Boolean.valueOf(z));
    }

    private static String a(int i) {
        Display display = f.getDisplay(i);
        return display != null ? a(display) : "pd";
    }

    public static String a(Context context) {
        Display[] displays;
        if (f == null) {
            f = (DisplayManager) context.getSystemService("display");
        }
        DisplayManager displayManager = f;
        if (displayManager == null || (displays = displayManager.getDisplays()) == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < displays.length; i++) {
            Display display = displays[i];
            if (display != null && display.getDisplayId() != 0) {
                stringBuffer.append(a(displays[i]));
                if (i != displays.length - 1) {
                    stringBuffer.append(StringUtils.COMMA);
                }
            }
        }
        return stringBuffer.toString();
    }

    public static boolean b(Context context) {
        if (c == null && d == null && e == null) {
            return (context == null || TextUtils.isEmpty(a(context))) ? false : true;
        }
        return true;
    }
}
