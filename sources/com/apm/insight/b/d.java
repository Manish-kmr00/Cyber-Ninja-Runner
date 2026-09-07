package com.apm.insight.b;

import android.app.ActivityManager;
import android.content.Context;
import android.os.FileObserver;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.apm.insight.l.m;
import com.apm.insight.runtime.k;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: ANRUtils.java */
/* JADX INFO: loaded from: classes8.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f172a = null;
    private static long b = -1;
    private static boolean c;
    private static FileObserver d;
    private static ActivityManager.ProcessErrorStateInfo e;

    public static void a(final String str, final h.a aVar) {
        FileObserver fileObserver = d;
        if (fileObserver != null) {
            fileObserver.stopWatching();
        }
        FileObserver fileObserver2 = new FileObserver(str) { // from class: com.apm.insight.b.d.1
            @Override // android.os.FileObserver
            public final void onEvent(int i, String str2) {
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                try {
                    String unused = d.f172a = aVar.a();
                } catch (Throwable th) {
                    com.apm.insight.c.a();
                    k.a(th, "NPTH_CATCH");
                }
            }
        };
        d = fileObserver2;
        fileObserver2.startWatching();
    }

    public static JSONObject a() throws JSONException {
        try {
            StackTraceElement[] stackTrace = Looper.getMainLooper().getThread().getStackTrace();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("thread_number", 1);
            jSONObject.put("mainStackFromTrace", m.a(stackTrace));
            return jSONObject;
        } catch (Throwable th) {
            com.apm.insight.c.a();
            k.a(th, "NPTH_CATCH");
            return null;
        }
    }

    static String a(Context context) {
        if (SystemClock.uptimeMillis() - b < 5000) {
            return null;
        }
        try {
            ActivityManager.ProcessErrorStateInfo processErrorStateInfoB = com.apm.insight.l.a.b(context);
            if (processErrorStateInfoB != null && Process.myPid() == processErrorStateInfoB.pid) {
                ActivityManager.ProcessErrorStateInfo processErrorStateInfo = e;
                if (processErrorStateInfo != null && String.valueOf(processErrorStateInfo.condition).equals(String.valueOf(processErrorStateInfoB.condition)) && String.valueOf(processErrorStateInfo.processName).equals(String.valueOf(processErrorStateInfoB.processName)) && String.valueOf(processErrorStateInfo.pid).equals(String.valueOf(processErrorStateInfoB.pid)) && String.valueOf(processErrorStateInfo.uid).equals(String.valueOf(processErrorStateInfoB.uid)) && String.valueOf(processErrorStateInfo.tag).equals(String.valueOf(processErrorStateInfoB.tag)) && String.valueOf(processErrorStateInfo.shortMsg).equals(String.valueOf(processErrorStateInfoB.shortMsg)) && String.valueOf(processErrorStateInfo.longMsg).equals(String.valueOf(processErrorStateInfoB.longMsg))) {
                    return null;
                }
                e = processErrorStateInfoB;
                f172a = null;
                b = SystemClock.uptimeMillis();
                c = false;
                if (!com.apm.insight.e.t()) {
                    return "|------------- processErrorStateInfo--------------|\ndisable anr info\n\"-----------------------end----------------------------\"";
                }
                StringBuilder sb = new StringBuilder("|------------- processErrorStateInfo--------------|\n");
                sb.append("condition: " + processErrorStateInfoB.condition + "\n");
                sb.append("processName: " + processErrorStateInfoB.processName + "\n");
                sb.append("pid: " + processErrorStateInfoB.pid + "\n");
                sb.append("uid: " + processErrorStateInfoB.uid + "\n");
                sb.append("tag: " + processErrorStateInfoB.tag + "\n");
                sb.append("shortMsg : " + processErrorStateInfoB.shortMsg + "\n");
                sb.append("longMsg : " + processErrorStateInfoB.longMsg + "\n");
                sb.append("-----------------------end----------------------------");
                return sb.toString();
            }
        } catch (Throwable unused) {
        }
        String str = f172a;
        if (str == null) {
            return null;
        }
        c = true;
        f172a = null;
        b = SystemClock.uptimeMillis();
        return str;
    }

    public static boolean b() {
        return c;
    }

    public static void c() {
        e = null;
    }
}
