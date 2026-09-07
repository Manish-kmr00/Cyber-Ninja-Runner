package com.apm.insight.nativecrash;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.apm.insight.CrashType;
import com.apm.insight.ICrashFilter;
import com.apm.insight.entity.Header;
import com.apm.insight.l.h;
import com.apm.insight.l.j;
import com.apm.insight.l.m;
import com.apm.insight.l.n;
import com.apm.insight.runtime.k;
import com.apm.insight.runtime.o;
import com.apm.insight.runtime.q;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.json.b9;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: NativeCrashFileManager.java */
/* JADX INFO: loaded from: classes8.dex */
public final class a {
    private static Boolean d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f262a;
    private JSONObject b = null;
    private b c;

    public a(Context context) {
        this.f262a = context;
    }

    public final void a(File file) {
        this.c = new b(file);
    }

    /* JADX INFO: compiled from: NativeCrashFileManager.java */
    class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.apm.insight.nativecrash.c f263a;
        private final com.apm.insight.h.b b;
        private final File c;
        private final File d;

        public b(File file) {
            this.c = file;
            this.d = j.a(com.apm.insight.e.g(), file.getName());
            com.apm.insight.h.b bVar = new com.apm.insight.h.b(file);
            this.b = bVar;
            com.apm.insight.nativecrash.c cVar = new com.apm.insight.nativecrash.c(file);
            this.f263a = cVar;
            if (bVar.d() && cVar.a() == null) {
                cVar.a(file);
            }
        }

        /* JADX WARN: Code duplicated, block: B:11:0x001d A[Catch: all -> 0x0018, TRY_LEAVE, TryCatch #0 {all -> 0x0018, blocks: (B:4:0x0008, B:6:0x000e, B:11:0x001d), top: B:16:0x0008 }] */
        /* JADX WARN: Code duplicated, block: B:9:0x001a  */
        public final long a() {
            String str;
            Map<String, String> mapF = this.b.f();
            if (mapF != null) {
                try {
                    if (mapF.isEmpty()) {
                        str = null;
                    } else {
                        str = mapF.get("start_time");
                    }
                    if (str != null) {
                        return Long.parseLong(str);
                    }
                } catch (Throwable th) {
                    com.apm.insight.c.a();
                    k.a(th, "NPTH_CATCH");
                }
            } else {
                str = null;
                if (str != null) {
                    return Long.parseLong(str);
                }
            }
            return System.currentTimeMillis();
        }

        public final File b() {
            return this.c;
        }

        public final boolean c() {
            return this.b.d();
        }
    }

    private String l() {
        b bVar = this.c;
        if (bVar == null) {
            return null;
        }
        String strC = bVar.f263a.c();
        return (strC == null || strC.isEmpty()) ? this.c.b.e() : strC;
    }

    public final boolean a() {
        b bVar = this.c;
        if (bVar != null) {
            return bVar.c();
        }
        return false;
    }

    public final JSONObject b() {
        File fileF = j.f(this.c.b());
        if (!fileF.exists()) {
            return null;
        }
        try {
            String strA = com.apm.insight.l.f.a(fileF.getAbsolutePath(), "\n");
            if (strA != null && !strA.isEmpty()) {
                return new JSONObject(strA);
            }
        } catch (Throwable th) {
            com.apm.insight.c.a();
            k.a(th, "NPTH_CATCH");
        }
        return null;
    }

    public final void c() {
        BufferedWriter bufferedWriter;
        Throwable th;
        try {
            File fileE = j.e(this.c.b());
            File file = new File(fileE.getAbsolutePath() + ".tmp'");
            if (file.exists()) {
                file.delete();
            }
            int i = 0;
            if (fileE.exists()) {
                while (i < NativeCrashCollector.a()) {
                    File file2 = new File(fileE.getAbsolutePath() + '.' + i);
                    if (file2.exists()) {
                        file2.delete();
                    }
                    i++;
                }
                return;
            }
            com.apm.insight.entity.a aVar = new com.apm.insight.entity.a();
            for (int i2 = 0; i2 < NativeCrashCollector.a(); i2++) {
                File file3 = new File(fileE.getAbsolutePath() + '.' + i2);
                if (file3.exists()) {
                    try {
                        String strA = com.apm.insight.l.f.a(file3.getAbsolutePath(), "\n");
                        if (!TextUtils.isEmpty(strA)) {
                            JSONObject jSONObject = new JSONObject(strA);
                            if (jSONObject.length() > 0) {
                                aVar.c(jSONObject);
                            }
                        }
                    } catch (JSONException e2) {
                        com.apm.insight.c.a();
                        k.a(e2, "NPTH_CATCH");
                    }
                }
            }
            JSONObject jSONObjectC = aVar.c();
            try {
                if (jSONObjectC.length() != 0 && jSONObjectC.opt(b9.a.k) == null) {
                    com.apm.insight.e.g();
                    com.apm.insight.entity.a.a(jSONObjectC, n.a());
                }
            } catch (Throwable unused) {
            }
            if (jSONObjectC.length() != 0) {
                this.b = jSONObjectC;
                if (jSONObjectC != null) {
                    file.getParentFile().mkdirs();
                    try {
                        bufferedWriter = new BufferedWriter(new FileWriter(file));
                        try {
                            h.a(jSONObjectC, bufferedWriter);
                        } catch (Throwable th2) {
                            th = th2;
                            try {
                                try {
                                    jSONObjectC.put("err_write", th.toString());
                                    com.apm.insight.entity.a.a(jSONObjectC, "filters", "err_write", th.getLocalizedMessage());
                                } catch (JSONException unused2) {
                                }
                                com.apm.insight.c.a();
                                k.a(th, "NPTH_CATCH");
                            } catch (Throwable th3) {
                                com.apm.insight.a.a((Closeable) bufferedWriter);
                                throw th3;
                            }
                        }
                    } catch (Throwable th4) {
                        bufferedWriter = null;
                        th = th4;
                    }
                    com.apm.insight.a.a((Closeable) bufferedWriter);
                }
                if (file.renameTo(fileE)) {
                    while (i < NativeCrashCollector.a()) {
                        File file4 = new File(fileE.getAbsolutePath() + '.' + i);
                        if (file4.exists()) {
                            file4.delete();
                        }
                        i++;
                    }
                }
            }
        } catch (IOException e3) {
            com.apm.insight.c.a();
            k.a(e3, "NPTH_CATCH");
        }
    }

    public final boolean d() {
        ICrashFilter iCrashFilterB = com.apm.insight.e.b().b();
        if (iCrashFilterB == null) {
            return true;
        }
        try {
            return iCrashFilterB.onNativeCrashFilter(l(), "");
        } catch (Throwable th) {
            com.apm.insight.c.a();
            k.a(th, "NPTH_CATCH");
            return true;
        }
    }

    public final boolean e() {
        return com.apm.insight.e.a.a().a(j.f(this.c.b()).getAbsolutePath());
    }

    public final void f() {
        com.apm.insight.e.a.a().a(com.apm.insight.d.a.b(j.f(this.c.b()).getAbsolutePath()));
    }

    public static long g() {
        if (NativeImpl.f()) {
            return Long.MAX_VALUE;
        }
        return Header.a() ? 3891200L : 2867200L;
    }

    /* JADX INFO: renamed from: com.apm.insight.nativecrash.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: NativeCrashFileManager.java */
    static class C0123a {
        /* JADX INFO: Access modifiers changed from: private */
        public static String b(File file) {
            BufferedReader bufferedReader = null;
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
                try {
                    String line = bufferedReader2.readLine();
                    if (line != null) {
                        if (line.startsWith("[FATAL:jni_android.cc") && line.contains("Please include Java exception stack in crash report ttwebview:")) {
                            StringBuilder sb = new StringBuilder();
                            int iIndexOf = line.indexOf(" ttwebview:");
                            sb.append("Caused by: ");
                            sb.append("Please include Java exception stack in crash report");
                            sb.append("\n");
                            sb.append(line.substring(iIndexOf + 11));
                            sb.append("\n");
                            while (true) {
                                String line2 = bufferedReader2.readLine();
                                if (line2 != null) {
                                    sb.append(line2);
                                    sb.append("\n");
                                } else {
                                    String string = sb.toString();
                                    com.apm.insight.a.a((Closeable) bufferedReader2);
                                    return string;
                                }
                            }
                        } else {
                            com.apm.insight.a.a((Closeable) bufferedReader2);
                        }
                    } else {
                        com.apm.insight.a.a((Closeable) bufferedReader2);
                        return "";
                    }
                } catch (Throwable th) {
                    th = th;
                    bufferedReader = bufferedReader2;
                    try {
                        com.apm.insight.c.a();
                        k.a(th, "NPTH_CATCH");
                    } finally {
                        com.apm.insight.a.a((Closeable) bufferedReader);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
            return "";
        }
    }

    private void a(com.apm.insight.entity.a aVar) {
        File fileA = j.a(this.c.b());
        if (fileA.exists()) {
            try {
                String strA = com.apm.insight.l.f.a(fileA.getAbsolutePath(), "\n");
                JSONArray jSONArray = new JSONArray();
                if (strA != null) {
                    for (String str : strA.split("\n")) {
                        jSONArray.put(str);
                    }
                }
                aVar.a("native_log", (Object) jSONArray);
            } catch (Throwable th) {
                com.apm.insight.c.a();
                k.a(th, "NPTH_CATCH");
            }
        }
    }

    private void b(com.apm.insight.entity.a aVar) {
        BufferedReader bufferedReader;
        File fileH = j.h(this.c.b());
        if (!fileH.exists()) {
            NativeImpl.a(fileH.getAbsolutePath(), String.valueOf(com.apm.insight.e.i().getLogcatDumpCount()), String.valueOf(com.apm.insight.e.i().getLogcatLevel()));
        }
        JSONArray jSONArray = new JSONArray();
        String str = " " + this.c.b.f().get("pid") + " ";
        try {
            bufferedReader = new BufferedReader(new FileReader(fileH));
            try {
                if (fileH.length() > 512000) {
                    bufferedReader.skip(fileH.length() - 512000);
                }
                while (true) {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    if ((line.length() > 32 ? line.substring(0, 31) : line).contains(str)) {
                        jSONArray.put(line);
                    }
                }
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            bufferedReader = null;
        }
        com.apm.insight.a.a((Closeable) bufferedReader);
        aVar.a("logcat", (Object) jSONArray);
    }

    public final JSONObject h() {
        try {
            com.apm.insight.entity.a aVar = new com.apm.insight.entity.a();
            Header header = new Header(this.f262a);
            JSONObject jSONObjectA = q.a().a(this.c.a());
            if (jSONObjectA != null) {
                header.a(jSONObjectA);
                header.d();
                header.e();
            }
            Header.b(header);
            aVar.a(header);
            boolean z = true;
            aVar.a("is_native_crash", (Object) 1);
            aVar.a("repack_time", Long.valueOf(System.currentTimeMillis()));
            aVar.a("crash_uuid", this.c.b().getName());
            aVar.a("jiffy", Long.valueOf(o.a.a()));
            b bVar = this.c;
            Map<String, String> mapF = bVar != null ? bVar.b.f() : null;
            if (mapF != null) {
                Object obj = (String) mapF.get("process_name");
                if (obj != null) {
                    aVar.a("process_name", obj);
                }
                String str = mapF.get("start_time");
                if (str != null) {
                    try {
                        aVar.a(Long.decode(str).longValue());
                    } catch (Throwable th) {
                        com.apm.insight.c.a();
                        k.a(th, "NPTH_CATCH");
                    }
                }
                String str2 = mapF.get("pid");
                if (str2 != null) {
                    try {
                        aVar.a("pid", Long.decode(str2));
                    } catch (Throwable th2) {
                        com.apm.insight.c.a();
                        k.a(th2, "NPTH_CATCH");
                    }
                }
                Object obj2 = (String) mapF.get("crash_thread_name");
                if (obj2 != null) {
                    aVar.a("crash_thread_name", obj2);
                }
                String str3 = mapF.get("crash_time");
                if (str3 != null) {
                    try {
                        aVar.a("crash_time", Long.decode(str3));
                    } catch (Throwable th3) {
                        com.apm.insight.c.a();
                        k.a(th3, "NPTH_CATCH");
                    }
                }
                aVar.a("data", l());
            }
            Map<String, String> mapB = this.c.f263a.b();
            if (!mapB.isEmpty()) {
                JSONArray jSONArray = new JSONArray();
                for (String str4 : mapB.keySet()) {
                    String strA = a(mapB.get(str4));
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("lib_name", str4);
                        jSONObject.put("lib_uuid", strA);
                        jSONArray.put(jSONObject);
                    } catch (JSONException e2) {
                        com.apm.insight.c.a();
                        k.a(e2, "NPTH_CATCH");
                    }
                }
                aVar.a("crash_lib_uuid", (Object) jSONArray);
            }
            File fileE = j.e(this.c.b());
            if (!fileE.exists() && this.b == null) {
                com.apm.insight.e.g();
                aVar.b(n.a());
                aVar.a("has_callback", "false");
            } else {
                try {
                    JSONObject jSONObject2 = this.b;
                    if (jSONObject2 == null) {
                        jSONObject2 = new JSONObject(com.apm.insight.l.f.a(fileE.getAbsolutePath(), "\n"));
                    }
                    aVar.c(jSONObject2);
                    aVar.a("has_callback", "true");
                    if (aVar.c().opt(b9.a.k) == null) {
                        com.apm.insight.e.g();
                        aVar.b(n.a());
                    }
                    com.apm.insight.a.a(aVar, aVar.d(), CrashType.NATIVE);
                } catch (Throwable th4) {
                    com.apm.insight.c.a();
                    k.a(th4, "NPTH_CATCH");
                }
                long j = -1;
                long jOptLong = aVar.c().optLong("crash_time", -1L);
                long jOptLong2 = aVar.c().optLong("java_end", -1L);
                if (jOptLong2 != -1 && jOptLong != -1) {
                    j = jOptLong2 - jOptLong;
                }
                try {
                    aVar.b("total_cost", String.valueOf(j));
                    aVar.a("total_cost", String.valueOf(j / 1000));
                } catch (Throwable unused) {
                }
            }
            File fileG = j.g(this.c.b());
            String strA2 = "";
            if (fileG.exists()) {
                try {
                    strA2 = m.a(fileG.getAbsolutePath());
                } catch (Throwable th5) {
                    com.apm.insight.c.a();
                    k.a(th5, "NPTH_CATCH");
                }
            }
            File fileO = j.o(this.c.b());
            if (fileO.exists()) {
                String strB = C0123a.b(fileO);
                strA2 = !strA2.isEmpty() ? strA2 + "\n" + strB : strB;
            }
            try {
                if (!strA2.isEmpty()) {
                    aVar.a("java_data", (Object) strA2);
                }
            } catch (Throwable th6) {
                com.apm.insight.c.a();
                k.a(th6, "NPTH_CATCH");
            }
            b(aVar);
            a(aVar);
            com.apm.insight.entity.d.b(aVar.c());
            Map<? extends String, ? extends String> map = new HashMap<>();
            if (k()) {
                map.put("is_root", "true");
                aVar.a("is_root", "true");
            } else {
                map.put("is_root", "false");
                aVar.a("is_root", "false");
            }
            map.put("has_fds_file", j.i(this.c.b()).exists() ? "true" : "false");
            File fileH = j.h(this.c.b());
            map.put("has_logcat_file", (!fileH.exists() || fileH.length() <= 128) ? "false" : "true");
            map.put("has_maps_file", j.d(this.c.b()).exists() ? "true" : "false");
            map.put("has_tombstone_file", j.b(this.c.b()).exists() ? "true" : "false");
            map.put("has_meminfo_file", j.k(this.c.b()).exists() ? "true" : "false");
            map.put("has_threads_file", j.j(this.c.b()).exists() ? "true" : "false");
            int iA = new c().a();
            if (iA > 0) {
                if (iA > 960) {
                    map.put("fd_leak", "true");
                } else {
                    map.put("fd_leak", "false");
                }
                aVar.a("fd_count", Integer.valueOf(iA));
            }
            int iA2 = new f().a();
            if (iA2 > 0) {
                if (iA2 > 350) {
                    map.put("threads_leak", "true");
                } else {
                    map.put("threads_leak", "false");
                }
                aVar.a("threads_count", Integer.valueOf(iA2));
            }
            int iA3 = new d().a();
            if (iA3 > 0) {
                if (iA3 > g()) {
                    map.put("memory_leak", "true");
                } else {
                    map.put("memory_leak", "false");
                }
                aVar.a("memory_size", Integer.valueOf(iA3));
            }
            map.put("sdk_version", "1.3.8.nourl-rc.1");
            if (aVar.c().opt("java_data") == null) {
                z = false;
            }
            map.put("has_java_stack", String.valueOf(z));
            JSONArray jSONArrayA = com.apm.insight.nativecrash.b.a(j.l(this.c.c), j.m(this.c.c));
            map.put("leak_threads_count", String.valueOf(jSONArrayA.length()));
            if (jSONArrayA.length() > 0) {
                try {
                    com.apm.insight.l.f.a(j.n(this.c.c), jSONArrayA);
                } catch (Throwable unused2) {
                }
            }
            aVar.b();
            aVar.a("is_64_devices", String.valueOf(Header.a()));
            aVar.a("is_64_runtime", String.valueOf(NativeImpl.f()));
            aVar.a("is_x86_devices", String.valueOf(Header.b()));
            aVar.c(map);
            File fileF = j.f(this.c.b());
            JSONObject jSONObjectC = aVar.c();
            com.apm.insight.l.f.a(fileF, jSONObjectC);
            return jSONObjectC;
        } catch (Throwable th7) {
            com.apm.insight.c.a();
            k.a(th7, "NPTH_CATCH");
            return null;
        }
    }

    private static String a(String str) {
        StringBuilder sb = new StringBuilder();
        try {
            if (str.length() < 16) {
                sb.append(str);
            } else {
                sb.append(str.charAt(6));
                sb.append(str.charAt(7));
                sb.append(str.charAt(4));
                sb.append(str.charAt(5));
                sb.append(str.charAt(2));
                sb.append(str.charAt(3));
                sb.append(str.charAt(0));
                sb.append(str.charAt(1));
                sb.append(str.charAt(10));
                sb.append(str.charAt(11));
                sb.append(str.charAt(8));
                sb.append(str.charAt(9));
                sb.append(str.charAt(14));
                sb.append(str.charAt(15));
                sb.append(str.charAt(12));
                sb.append(str.charAt(13));
                if (str.length() >= 32) {
                    sb.append((CharSequence) str, 16, 32);
                    sb.append('0');
                }
            }
        } catch (Throwable th) {
            com.apm.insight.c.a();
            k.a(th, "NPTH_CATCH");
        }
        return sb.toString().toUpperCase();
    }

    public final boolean i() {
        return com.apm.insight.l.f.a(this.c.b());
    }

    public final void j() {
        try {
            com.apm.insight.l.f.b(this.c.b().getAbsolutePath(), Environment.getExternalStorageDirectory().getAbsolutePath() + "/localDebug/" + com.apm.insight.e.g().getPackageName() + RemoteSettings.FORWARD_SLASH_STRING + this.c.b().getName() + ".zip");
        } catch (Throwable th) {
            com.apm.insight.c.a();
            k.a(th, "NPTH_CATCH");
        }
    }

    public static boolean k() {
        Boolean bool = d;
        if (bool != null) {
            return bool.booleanValue();
        }
        int i = 11;
        String[] strArr = {"/data/local/su", "/data/local/bin/su", "/data/local/xbin/su", "/system/xbin/su", "/system/bin/su", "/system/bin/.ext/su", "/system/bin/failsafe/su", "/system/sd/xbin/su", "/system/usr/we-need-root/su", "/sbin/su", "/su/bin/su"};
        for (int i2 = 0; i2 < i; i2++) {
            try {
                if (new File(strArr[i2]).exists()) {
                    Boolean bool2 = Boolean.TRUE;
                    d = bool2;
                    return bool2.booleanValue();
                }
                continue;
            } catch (Throwable th) {
                com.apm.insight.c.a();
                k.a(th, "NPTH_CATCH");
            }
        }
        Boolean bool3 = Boolean.FALSE;
        d = bool3;
        return bool3.booleanValue();
    }

    /* JADX INFO: compiled from: NativeCrashFileManager.java */
    public class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected File f264a;
        protected String b;
        protected String c;
        protected int d;

        public e() {
        }

        public final int a() {
            int i;
            Throwable th;
            if (!this.f264a.exists() || !this.f264a.isFile()) {
                return -1;
            }
            BufferedReader bufferedReader = null;
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new FileReader(this.f264a));
                int iA = -1;
                do {
                    try {
                        String line = bufferedReader2.readLine();
                        if (line == null) {
                            break;
                        }
                        iA = a(line);
                    } catch (Throwable th2) {
                        th = th2;
                        i = iA;
                        bufferedReader = bufferedReader2;
                        try {
                            com.apm.insight.c.a();
                            k.a(th, "NPTH_CATCH");
                            return i;
                        } finally {
                            if (bufferedReader != null) {
                                com.apm.insight.a.a((Closeable) bufferedReader);
                            }
                        }
                    }
                } while (iA == -1);
                com.apm.insight.a.a((Closeable) bufferedReader2);
                return iA;
            } catch (Throwable th3) {
                i = -1;
                th = th3;
            }
        }

        private int a(String str) {
            int i = this.d;
            if (!str.startsWith(this.b)) {
                return i;
            }
            try {
                i = Integer.parseInt(str.split(this.c)[1].trim());
            } catch (NumberFormatException e) {
                com.apm.insight.c.a();
                k.a(e, "NPTH_CATCH");
            }
            if (i < 0) {
                return -2;
            }
            return i;
        }
    }

    /* JADX INFO: compiled from: NativeCrashFileManager.java */
    public class d extends e {
        d() {
            super();
            this.b = "VmSize:";
            this.f264a = j.k(a.this.c.b());
            this.c = "\\s+";
            this.d = -1;
        }
    }

    /* JADX INFO: compiled from: NativeCrashFileManager.java */
    public class f extends e {
        f() {
            super();
            this.b = "Total Threads Count:";
            this.f264a = j.j(a.this.c.b());
            this.c = ":";
            this.d = -2;
        }
    }

    /* JADX INFO: compiled from: NativeCrashFileManager.java */
    public class c extends e {
        c() {
            super();
            this.b = "Total FD Count:";
            this.f264a = j.i(a.this.c.b());
            this.c = ":";
            this.d = -2;
        }
    }
}
