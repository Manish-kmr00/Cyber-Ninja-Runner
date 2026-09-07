package com.bytedance.sdk.openadsdk.core;

import android.app.Application;
import android.content.Context;
import android.view.ViewConfiguration;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes3.dex */
public class aBv {
    private static int KZx = -1;
    private static volatile yFO<com.bytedance.sdk.openadsdk.ZZv.pA> Og;
    private static volatile Context pA;

    public static Context pA() {
        if (pA == null) {
            Og(null);
        }
        return pA;
    }

    public static Context pA(Context context) {
        if (context == null) {
            context = pA();
        }
        if (context instanceof Application) {
            return context;
        }
        if (context != null) {
            return context.getApplicationContext();
        }
        return null;
    }

    public static void Og(Context context) {
        if (pA == null) {
            synchronized (aBv.class) {
                if (pA == null) {
                    if (context != null) {
                        pA = context;
                        Context applicationContext = context.getApplicationContext();
                        if (applicationContext != null) {
                            pA = applicationContext;
                        }
                        return;
                    }
                    try {
                        Application applicationPA = pA.pA();
                        if (applicationPA != null) {
                            pA = applicationPA;
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
        }
    }

    public static int Og() {
        Context contextPA;
        if (KZx < 0 && (contextPA = pA()) != null) {
            KZx = ViewConfiguration.get(contextPA).getScaledTouchSlop();
        }
        return KZx;
    }

    public static yFO<com.bytedance.sdk.openadsdk.ZZv.pA> KZx() {
        if (Og == null) {
            synchronized (aBv.class) {
                if (Og == null) {
                    Og = new vZF(pA);
                }
            }
        }
        return Og;
    }

    public static com.bytedance.sdk.openadsdk.core.settings.JG ZZv() {
        return com.bytedance.sdk.openadsdk.core.settings.oX.vkV();
    }

    public static com.bytedance.sdk.openadsdk.Sn.KZx.Og ML() {
        if (!com.bytedance.sdk.openadsdk.core.settings.WV.pA()) {
            return com.bytedance.sdk.openadsdk.Sn.KZx.KZx.pA();
        }
        return com.bytedance.sdk.openadsdk.ZZv.pA.ZZv.pA();
    }

    private static class pA {
        private static volatile Application pA;

        public static Application pA() {
            return pA;
        }

        static {
            try {
                Object objOg = Og();
                pA = (Application) objOg.getClass().getMethod("getApplication", new Class[0]).invoke(objOg, new Object[0]);
                com.bytedance.sdk.component.utils.WV.pA("MyApplication", "application get success");
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.WV.pA("MyApplication", "application get failed", th);
            }
        }

        private static Object Og() {
            try {
                Method method = Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", new Class[0]);
                method.setAccessible(true);
                return method.invoke(null, new Object[0]);
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.WV.pA("MyApplication", "ActivityThread get error, maybe api level <= 4.2.2", th);
                return null;
            }
        }
    }
}
