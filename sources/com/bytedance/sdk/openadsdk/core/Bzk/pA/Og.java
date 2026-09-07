package com.bytedance.sdk.openadsdk.core.Bzk.pA;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Process;
import android.util.ArrayMap;
import androidx.core.app.NotificationCompat;
import com.json.b9;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public class Og {
    private static volatile Og pA;
    private final ArrayList<String> Og = new ArrayList<>();
    private final AtomicBoolean KZx = new AtomicBoolean(false);
    private long ZZv = System.currentTimeMillis();
    private long ML = 0;
    private long JG = 0;
    private String SD = "";
    private String omh = "";
    private String Bzk = "";
    private boolean SGo = false;
    private boolean BSW = false;

    public static Og pA(Application application) {
        if (pA == null) {
            synchronized (Og.class) {
                if (pA == null) {
                    Og og = new Og();
                    pA = og;
                    og.SGo = pA((Context) application);
                    pA.BSW = pA(application.getApplicationContext(), "android.permission.SYSTEM_ALERT_WINDOW") == 0;
                    pA.pA();
                }
            }
        }
        return pA;
    }

    private static int pA(Context context, String str) {
        try {
            return context.checkPermission(str, Process.myPid(), Process.myUid());
        } catch (Throwable unused) {
            return -1;
        }
    }

    private static boolean pA(Context context) {
        ApplicationInfo applicationInfo;
        return (context == null || (applicationInfo = context.getApplicationInfo()) == null || (applicationInfo.flags & 1) <= 0) ? false : true;
    }

    public void pA(Activity activity) {
        String localClassName = activity.getLocalClassName();
        if (this.Og.size() == 0) {
            this.SD = localClassName;
            this.ML = System.currentTimeMillis();
            this.JG = System.currentTimeMillis() - this.ZZv;
            this.KZx.set(false);
        }
        if (!this.Og.contains(localClassName)) {
            this.Og.add(localClassName);
        }
        if (localClassName.contains("com.bytedance.sdk.openadsdk.activity.TTFullScreenExpressVideoActivity") || localClassName.contains("com.bytedance.sdk.openadsdk.activity.TTRewardExpressVideoActivity")) {
            return;
        }
        this.Bzk = localClassName;
    }

    public void Og(Activity activity) {
        String localClassName = activity.getLocalClassName();
        if (this.Og.contains(localClassName)) {
            this.Og.remove(localClassName);
        }
        if (this.Og.size() == 0) {
            this.ZZv = System.currentTimeMillis();
            this.KZx.set(true);
            this.omh = localClassName;
        }
    }

    private void pA() {
        int size;
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Method declaredMethod = cls.getDeclaredMethod("currentActivityThread", new Class[0]);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(null, new Object[0]);
            Field declaredField = cls.getDeclaredField("mActivities");
            declaredField.setAccessible(true);
            ArrayMap arrayMap = (ArrayMap) declaredField.get(objInvoke);
            if (arrayMap != null && (size = arrayMap.size()) > 0) {
                Class<?> cls2 = Class.forName("android.app.ActivityThread$ActivityClientRecord");
                Field declaredField2 = cls2.getDeclaredField(b9.h.h0);
                declaredField2.setAccessible(true);
                Field declaredField3 = cls2.getDeclaredField("activity");
                declaredField3.setAccessible(true);
                for (int i = 0; i < size; i++) {
                    Object objValueAt = arrayMap.valueAt(i);
                    if (!((Boolean) declaredField2.get(objValueAt)).booleanValue()) {
                        String localClassName = ((Activity) declaredField3.get(objValueAt)).getLocalClassName();
                        if (!this.Og.contains(localClassName)) {
                            this.Og.add(localClassName);
                        }
                    }
                }
                this.KZx.set(this.Og.size() <= 0);
            }
        } catch (Throwable unused) {
        }
    }

    public String pA(String str, long j, int i) {
        String string;
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j2 = jCurrentTimeMillis - this.ML;
        long j3 = jCurrentTimeMillis - j;
        int i2 = j3 < 500 ? 1 : 0;
        if (this.KZx.get() && this.BSW) {
            i2 |= 2;
        }
        if (!this.KZx.get() && this.JG >= 5000 && j2 < 1000) {
            i2 = this.omh.equals(this.Bzk) ? i2 | 4 : i2 | 8;
        }
        try {
            string = new JSONObject().put("rst", i2).put("adtag", str).put("bakdur", this.JG).put("rit", i).put("poptime", j2).put("unlocktime", j3).put("bakground", this.KZx).put("alert", this.BSW).put(NotificationCompat.CATEGORY_SYSTEM, this.SGo).put("actsize", this.Og.size()).put("mutiproc", com.bytedance.sdk.openadsdk.multipro.Og.KZx()).toString();
        } catch (JSONException unused) {
            string = "";
        }
        this.SD = "";
        this.JG = 0L;
        this.ML = 0L;
        this.ZZv = System.currentTimeMillis();
        return string;
    }
}
