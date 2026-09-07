package com.apm.insight.h;

import android.text.TextUtils;
import android.util.Log;
import com.apm.insight.e;
import com.apm.insight.l.f;
import com.apm.insight.l.j;
import com.apm.insight.nativecrash.NativeImpl;
import com.apm.insight.runtime.k;
import com.apm.insight.runtime.n;
import com.apm.insight.runtime.p;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.unity3d.services.ads.gmascar.utils.ScarConstants;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: NpthSoData.java */
/* JADX INFO: loaded from: classes9.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static HashMap<String, String> f214a;
    private Map<String, String> b;

    public static String a(String str) {
        return e.g().getFilesDir() + "/apminsight/selflib/lib" + str + ".so";
    }

    public static String a() {
        return e.g().getFilesDir() + "/apminsight/selflib/";
    }

    public static void b(final String str) {
        n.a().a(new Runnable() { // from class: com.apm.insight.h.b.1

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private boolean f215a = false;

            @Override // java.lang.Runnable
            public final void run() {
                String strA;
                b.b();
                if (b.c(str)) {
                    return;
                }
                p.a("updateSo", str);
                File file = new File(b.a(str));
                file.getParentFile().mkdirs();
                if (file.exists()) {
                    file.delete();
                }
                String str2 = "doUnpackLibrary: " + str;
                if (e.i().isDebugMode()) {
                    Log.w("npth", str2);
                }
                try {
                    strA = c.a(e.g(), str, file);
                } catch (Throwable th) {
                    p.a("updateSoError", str);
                    com.apm.insight.c.a();
                    k.a(th, "NPTH_CATCH");
                    strA = null;
                }
                if (strA == null) {
                    b.f214a.put(file.getName(), "1.3.8.nourl-rc.1");
                    try {
                        f.a(new File(e.g().getFilesDir() + "/apminsight/selflib/" + str + ".ver"), "1.3.8.nourl-rc.1", false);
                    } catch (Throwable unused) {
                    }
                    p.a("updateSoSuccess", str);
                    return;
                }
                if (!this.f215a) {
                    this.f215a = true;
                    p.a("updateSoPostRetry", str);
                    n.a().a(this, 3000L);
                    return;
                }
                p.a("updateSoFailed", str);
            }
        });
    }

    static /* synthetic */ void b() {
        if (f214a == null) {
            f214a = new HashMap<>();
            File file = new File(e.g().getFilesDir(), "/apminsight/selflib/");
            String[] list = file.list();
            if (list != null) {
                for (String str : list) {
                    if (str.endsWith(".ver")) {
                        try {
                            f214a.put(str.substring(0, str.length() - 4), f.a(file.getAbsolutePath() + RemoteSettings.FORWARD_SLASH_STRING + str, "\n"));
                        } catch (Throwable th) {
                            com.apm.insight.c.a();
                            k.a(th, "NPTH_CATCH");
                        }
                    } else if (!str.endsWith(".so")) {
                        f.a(new File(file, str));
                    }
                }
            }
        }
    }

    static /* synthetic */ boolean c(String str) {
        return "1.3.8.nourl-rc.1".equals(f214a.get(str)) && new File(a(str)).exists();
    }

    public b(File file) {
        String strA;
        File fileC = j.c(file);
        if (!fileC.exists() || fileC.length() == 0 || (strA = NativeImpl.a(fileC.getAbsolutePath())) == null) {
            return;
        }
        String[] strArrSplit = strA.split("\n");
        this.b = new HashMap();
        for (String str : strArrSplit) {
            String[] strArrSplit2 = str.split("=");
            if (strArrSplit2.length == 2) {
                this.b.put(strArrSplit2[0], strArrSplit2[1]);
            }
        }
    }

    public final boolean d() {
        Map<String, String> map = this.b;
        return (map == null || map.isEmpty() || TextUtils.isEmpty(this.b.get("process_name")) || TextUtils.isEmpty(this.b.get("crash_thread_name")) || TextUtils.isEmpty(this.b.get("pid")) || TextUtils.isEmpty(this.b.get(ScarConstants.TOKEN_ID_KEY)) || TextUtils.isEmpty(this.b.get("start_time")) || TextUtils.isEmpty(this.b.get("crash_time")) || TextUtils.isEmpty(this.b.get("signal_line"))) ? false : true;
    }

    public final String e() {
        return this.b.get("signal_line");
    }

    public final Map<String, String> f() {
        return this.b;
    }
}
