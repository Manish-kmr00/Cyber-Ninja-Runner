package com.pgl.ssdk;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.pgl.ssdk.ces.out.DungeonFlag;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Context f7540a;

    static class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            y.c(x.b());
            com.pgl.ssdk.ces.a.meta(226, x.b(), null);
        }
    }

    @DungeonFlag
    private static String a(Throwable th) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("status", 3);
            jSONObject.put("exception", th.toString());
            jSONObject.put("stacktrace", Arrays.toString(th.getStackTrace()));
            jSONObject.put("cause", String.valueOf(th.getCause()));
            return Base64.encodeToString(jSONObject.toString().getBytes("UTF-8"), 0);
        } catch (Throwable unused) {
            return "eyJzdGF0dXMiOjN9";
        }
    }

    public static Context b() {
        return f7540a;
    }

    public static void c(Context context) {
        f7540a = context;
    }

    @DungeonFlag
    public static String b(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("status", 0);
            jSONObject.put("envcode", ((Long) com.pgl.ssdk.ces.a.meta(154, context, null)).longValue());
            jSONObject.put("bootcount", u.a(context));
            jSONObject.put("usb_debug", u.d(context));
            JSONArray[] jSONArrayArrC = u.c(context);
            if (jSONArrayArrC != null) {
                jSONObject.put("sdata", jSONArrayArrC[0]);
                jSONObject.put("sdmta", jSONArrayArrC[1]);
                jSONObject.put("curtime", System.currentTimeMillis() / 1000);
            }
            jSONObject.put("camera_count", v.a());
            jSONObject.put("sim", v.c(context));
            jSONObject.put("virtual_display", y.b(context));
            jSONObject.put("acbs", s.b(context));
            jSONObject.put("bl_unlock", u.b(context));
            w.a(jSONObject);
            String strE = t.e();
            jSONObject.put("romtype", u.c());
            jSONObject.put("root", u.e());
            if (!TextUtils.isEmpty(strE)) {
                jSONObject.put("sign", strE);
            }
            return (String) com.pgl.ssdk.ces.a.meta(227, context, jSONObject.toString());
        } catch (Throwable th) {
            return a(th);
        }
    }

    public static String c() {
        String strB = b(b());
        a();
        return strB;
    }

    public static long a(Context context) {
        try {
            return ((Long) com.pgl.ssdk.ces.a.meta(154, context, null)).longValue();
        } catch (Throwable unused) {
            return 0L;
        }
    }

    @DungeonFlag
    public static void a() {
        o0.b(new a());
    }
}
