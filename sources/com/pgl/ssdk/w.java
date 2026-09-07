package com.pgl.ssdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.hardware.input.InputManager;
import android.os.Build;
import android.view.InputDevice;
import android.view.MotionEvent;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f7536a;
    private static int b;
    private static int c;
    private static int d;
    private static int e;
    private static int f;
    private static boolean g;
    private static InputManager h;

    static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f7537a;
        final /* synthetic */ int b;

        a(Context context, int i) {
            this.f7537a = context;
            this.b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            InputManager inputManagerB = w.b(this.f7537a);
            if (inputManagerB == null) {
                return;
            }
            InputDevice inputDevice = inputManagerB.getInputDevice(this.b);
            w.h();
            if (inputDevice == null) {
                w.b();
                w.c();
                w.c("nihc");
            } else if (inputDevice.isVirtual()) {
                w.d();
                w.e();
                w.c("vihc");
            } else {
                if (Build.VERSION.SDK_INT < 29 || !inputDevice.isExternal()) {
                    return;
                }
                w.f();
                w.g();
                w.c("eihc");
            }
        }
    }

    static /* synthetic */ int b() {
        int i = c;
        c = i + 1;
        return i;
    }

    static /* synthetic */ int c() {
        int i = f;
        f = i + 1;
        return i;
    }

    static /* synthetic */ int d() {
        int i = f7536a;
        f7536a = i + 1;
        return i;
    }

    static /* synthetic */ int e() {
        int i = d;
        d = i + 1;
        return i;
    }

    static /* synthetic */ int f() {
        int i = b;
        b = i + 1;
        return i;
    }

    static /* synthetic */ int g() {
        int i = e;
        e = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void h() {
        if (g) {
            return;
        }
        try {
            SharedPreferences sharedPreferencesA = u0.a(x.b());
            if (sharedPreferencesA != null) {
                f = sharedPreferencesA.getInt("nihc", 0);
                e = sharedPreferencesA.getInt("eihc", 0);
                d = sharedPreferencesA.getInt("vihc", 0);
                g = true;
            }
        } catch (Throwable unused) {
        }
    }

    public static int b(String str) {
        h();
        str.hashCode();
        str.hashCode();
        switch (str) {
            case "eic":
                return b;
            case "nic":
                return c;
            case "vic":
                return f7536a;
            case "eihc":
                return e;
            case "nihc":
                return f;
            case "vihc":
                return d;
            default:
                return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(String str) {
        try {
            SharedPreferences sharedPreferencesA = u0.a(x.b());
            if (sharedPreferencesA != null) {
                sharedPreferencesA.edit().putInt(str, sharedPreferencesA.getInt(str, 0) + 1).apply();
            }
        } catch (Throwable unused) {
        }
    }

    public static void a(MotionEvent motionEvent, Context context) {
        if (motionEvent == null || context == null) {
            return;
        }
        if (motionEvent.getRawX() > 0.0f || motionEvent.getRawY() > 0.0f) {
            o0.b(new a(context, motionEvent.getDeviceId()));
        }
    }

    public static void a(JSONObject jSONObject) {
        h();
        try {
            jSONObject.put("vihc", d);
            jSONObject.put("eihc", e);
            jSONObject.put("nihc", f);
            jSONObject.put("vic", f7536a);
            jSONObject.put("nic", c);
            jSONObject.put("eic", b);
        } catch (JSONException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static InputManager b(Context context) {
        if (h == null) {
            h = (InputManager) context.getSystemService("input");
        }
        return h;
    }
}
