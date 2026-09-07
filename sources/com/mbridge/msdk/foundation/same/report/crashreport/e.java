package com.mbridge.msdk.foundation.same.report.crashreport;

import android.content.Context;
import android.os.Environment;
import android.os.Process;
import android.text.TextUtils;
import android.text.format.Formatter;
import com.mbridge.msdk.foundation.tools.o0;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: MBridgeUncaughtExceptionHandler.java */
/* JADX INFO: loaded from: classes3.dex */
public class e implements Thread.UncaughtExceptionHandler {
    private static volatile e d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f5011a = "CrashHandlerUtil";
    private Thread.UncaughtExceptionHandler b;
    private final WeakReference<Context> c;

    private e(Context context) {
        this.c = new WeakReference<>(context);
    }

    public static e a(Context context) {
        if (d == null) {
            synchronized (e.class) {
                if (d == null) {
                    d = new e(context);
                }
            }
        }
        return d;
    }

    private void b(Thread thread, Throwable th) {
        try {
            List<String> listA = b.a();
            StackTraceElement[] stackTrace = th.getStackTrace();
            StringBuilder sb = new StringBuilder();
            String str = th.getClass() + ": " + th.getMessage();
            sb.append(str).append("\n");
            boolean zA = a(listA, str);
            int i = 0;
            for (int i2 = 0; i2 < stackTrace.length; i2++) {
                String string = stackTrace[i2].toString();
                if (a(listA, string)) {
                    zA = true;
                    if (i2 == 0) {
                        i = 1;
                    }
                }
                sb.append(string).append("\n");
            }
            if (zA && sb.length() >= 1) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("key", "2000052");
                jSONObject.put("crash_first_index_from_mtg", i);
                JSONObject jSONObjectA = a(String.valueOf(System.currentTimeMillis()));
                jSONObjectA.put("crashinfo", sb.toString());
                jSONObject.put("exception", jSONObjectA);
                if (jSONObject.length() > 0) {
                    com.mbridge.msdk.foundation.same.report.metrics.d.b().a(jSONObject);
                }
                try {
                    Thread.sleep(500L);
                    return;
                } catch (InterruptedException e) {
                    o0.b("CrashHandlerUtil", e.getMessage());
                    return;
                }
            }
            a(thread, th);
        } catch (Throwable th2) {
            a(thread, th);
            o0.b("CrashHandlerUtil", th2.getMessage());
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        if (th != null) {
            try {
                b(thread, th);
            } catch (Throwable th2) {
                o0.b("CrashHandlerUtil", th2.getMessage());
            }
        }
        a(thread, th);
    }

    public void a() {
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        this.b = defaultUncaughtExceptionHandler;
        if (defaultUncaughtExceptionHandler instanceof e) {
            return;
        }
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    public JSONObject a(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            Context context = this.c.get();
            if (context == null) {
                return jSONObject;
            }
            float fMaxMemory = (float) ((Runtime.getRuntime().maxMemory() * 1.0d) / 1048576.0d);
            float f = (float) ((Runtime.getRuntime().totalMemory() * 1.0d) / 1048576.0d);
            float fFreeMemory = (float) ((Runtime.getRuntime().freeMemory() * 1.0d) / 1048576.0d);
            File externalStorageDirectory = Environment.getExternalStorageDirectory();
            long usableSpace = externalStorageDirectory.getUsableSpace();
            long totalSpace = externalStorageDirectory.getTotalSpace();
            String fileSize = Formatter.formatFileSize(context, usableSpace);
            String fileSize2 = Formatter.formatFileSize(context, totalSpace);
            jSONObject.put("max_memory", String.valueOf(fMaxMemory));
            jSONObject.put("memoryby_app", String.valueOf(f));
            jSONObject.put("remaining_memory", fFreeMemory);
            jSONObject.put("sdcard_remainder", fileSize);
            jSONObject.put("totalspacestr", fileSize2);
            jSONObject.put("crashtime", str);
            return jSONObject;
        } catch (Throwable th) {
            o0.b("CrashHandlerUtil", th.getMessage());
            return jSONObject;
        }
    }

    private boolean a(List<String> list, String str) {
        if (list != null && !list.isEmpty() && !TextUtils.isEmpty(str)) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                if (str.contains(it.next())) {
                    return true;
                }
            }
        }
        return false;
    }

    private void a(Thread thread, Throwable th) {
        try {
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.b;
            if (uncaughtExceptionHandler != null) {
                if (!(uncaughtExceptionHandler instanceof e)) {
                    uncaughtExceptionHandler.uncaughtException(thread, th);
                }
            } else {
                Process.killProcess(Process.myPid());
                System.exit(1);
            }
        } catch (Throwable th2) {
            o0.b("CrashHandlerUtil", th2.getMessage());
        }
    }
}
