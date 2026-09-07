package com.apm.insight.k;

import android.content.Context;
import android.text.TextUtils;
import com.apm.insight.CrashType;
import com.apm.insight.Npth;
import com.apm.insight.entity.Header;
import com.apm.insight.nativecrash.NativeImpl;
import com.apm.insight.runtime.n;
import com.apm.insight.runtime.o;
import com.apm.insight.runtime.q;
import com.json.b9;
import com.json.yk;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: CrashFileCollector.java */
/* JADX INFO: loaded from: classes3.dex */
public final class b {
    private static volatile b b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f223a;
    private C0122b f;
    private HashMap<String, C0122b> g;
    private List<File> c = new ArrayList();
    private List<File> d = new ArrayList();
    private int e = -1;
    private volatile boolean h = false;
    private Runnable i = new Runnable() { // from class: com.apm.insight.k.b.1
        @Override // java.lang.Runnable
        public final void run() throws Throwable {
            b.this.f();
        }
    };
    private Runnable j = new Runnable() { // from class: com.apm.insight.k.b.2
        @Override // java.lang.Runnable
        public final void run() throws Throwable {
            b.this.d();
        }
    };

    private b(Context context) {
        this.f223a = context;
    }

    public static b a() {
        if (b == null) {
            synchronized (b.class) {
                if (b == null) {
                    b = new b(com.apm.insight.e.g());
                }
            }
        }
        return b;
    }

    /* JADX INFO: renamed from: com.apm.insight.k.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CrashFileCollector.java */
    static class C0122b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f229a;
        a d;
        a e;
        List<a> b = new ArrayList();
        List<a> c = new ArrayList();
        boolean f = false;
        int g = 0;

        C0122b(String str) {
            this.f229a = str;
        }
    }

    /* JADX INFO: compiled from: CrashFileCollector.java */
    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        File f228a;
        long b;
        long c;
        CrashType d;
        String e;

        a(File file, CrashType crashType) {
            this.b = -1L;
            this.c = -1L;
            this.f228a = file;
            this.d = crashType;
            this.e = file.getName();
        }

        a(File file, long j, CrashType crashType) {
            this.c = -1L;
            this.f228a = file;
            this.b = j;
            this.d = crashType;
            this.e = file.getName();
        }
    }

    public final void a(boolean z) throws Throwable {
        if (!Npth.isStopUpload() && z) {
            if (this.f == null) {
                this.f = new C0122b("old_uuid");
                HashMap<String, C0122b> map = new HashMap<>();
                this.g = map;
                a(map);
                a(this.g, this.f);
                com.apm.insight.l.f.a(com.apm.insight.l.j.b(this.f223a));
                b(this.g);
                b(this.f, true, null);
                a(this.f, true, null);
                this.f = null;
                if (this.g.isEmpty()) {
                    e();
                } else {
                    f();
                }
            }
            g();
            com.apm.insight.a.c();
        }
    }

    public final void b() {
        try {
            if (!this.h && com.apm.insight.l.a.c(com.apm.insight.e.g())) {
                n.a().a(this.j);
            }
        } catch (Throwable unused) {
        }
    }

    public final boolean c() {
        return this.h;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() throws Throwable {
        if (this.h || this.g == null) {
            return;
        }
        if (!com.apm.insight.l.k.b(this.f223a)) {
            e();
        }
        if (this.e == -1) {
            if (com.apm.insight.runtime.a.a() && com.apm.insight.runtime.a.f()) {
                this.e = 1;
            } else {
                this.e = 0;
            }
        }
        boolean z = this.e == 1;
        com.apm.insight.runtime.g gVar = new com.apm.insight.runtime.g(this.f223a);
        Iterator<C0122b> it = this.g.values().iterator();
        while (it.hasNext()) {
            b(it.next(), z, gVar);
        }
        Iterator<C0122b> it2 = this.g.values().iterator();
        while (it2.hasNext()) {
            a(it2.next(), z, gVar);
        }
        Iterator<C0122b> it3 = this.g.values().iterator();
        while (it3.hasNext()) {
            com.apm.insight.l.f.a(com.apm.insight.l.j.a(this.f223a, it3.next().f229a));
        }
        gVar.a();
        com.apm.insight.runtime.b.a();
        e();
    }

    private void e() {
        this.h = true;
        this.g = null;
        NativeImpl.j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() throws Throwable {
        if (this.h) {
            return;
        }
        if (com.apm.insight.l.k.b(this.f223a) && (System.currentTimeMillis() - com.apm.insight.e.j() > 5000 || !com.apm.insight.e.i().isApmExists() || Npth.hasCrash())) {
            d();
        } else {
            n.a().a(this.i, 5000L);
        }
    }

    private void a(HashMap<String, C0122b> map) {
        File[] fileArrListFiles = com.apm.insight.l.j.f(this.f223a).listFiles();
        if (fileArrListFiles == null || fileArrListFiles.length == 0) {
            return;
        }
        for (int i = 0; i < fileArrListFiles.length && i < 5; i++) {
            File file = fileArrListFiles[i];
            try {
                if (!file.isDirectory()) {
                    com.apm.insight.l.f.a(file);
                } else if (file.getName().endsWith("G")) {
                    String name = file.getName();
                    C0122b c0122b = map.get(name);
                    if (c0122b == null) {
                        c0122b = new C0122b(name);
                        map.put(name, c0122b);
                    }
                    JSONArray jSONArrayA = com.apm.insight.nativecrash.b.a(com.apm.insight.l.j.l(file), com.apm.insight.l.j.m(file));
                    c0122b.g = jSONArrayA.length();
                    if (c0122b.g > 0) {
                        try {
                            com.apm.insight.l.f.a(com.apm.insight.l.j.n(file), jSONArrayA);
                        } catch (Throwable unused) {
                        }
                    }
                } else {
                    com.apm.insight.l.f.a(file);
                }
            } catch (Throwable th) {
                com.apm.insight.c.a();
                com.apm.insight.runtime.k.a(th, "NPTH_CATCH");
                com.apm.insight.l.f.a(file);
            }
        }
    }

    private void b(HashMap<String, C0122b> map) {
        File[] fileArrListFiles = com.apm.insight.l.j.d(this.f223a).listFiles();
        if (fileArrListFiles == null || fileArrListFiles.length == 0) {
            return;
        }
        for (int i = 0; i < fileArrListFiles.length && i < 5; i++) {
            File file = fileArrListFiles[i];
            try {
                if (!file.isDirectory()) {
                    com.apm.insight.l.f.a(file);
                } else if (file.getName().endsWith("G")) {
                    String name = file.getName();
                    C0122b c0122b = map.get(name);
                    if (c0122b == null) {
                        c0122b = new C0122b(name);
                        map.put(name, c0122b);
                    }
                    c0122b.c.add(new a(file, CrashType.NATIVE));
                } else {
                    com.apm.insight.l.f.a(file);
                }
            } catch (Throwable th) {
                com.apm.insight.c.a();
                com.apm.insight.runtime.k.a(th, "NPTH_CATCH");
                com.apm.insight.l.f.a(file);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:45:0x00c1  */
    private void a(HashMap<String, C0122b> map, C0122b c0122b) {
        byte b2;
        CrashType crashType;
        File[] fileArrListFiles = com.apm.insight.l.j.a(this.f223a).listFiles();
        if (fileArrListFiles == null) {
            return;
        }
        Arrays.sort(fileArrListFiles, Collections.reverseOrder());
        char c = 0;
        int i = 0;
        while (i < fileArrListFiles.length) {
            File file = fileArrListFiles[i];
            try {
                if (com.apm.insight.e.a.a().a(file.getAbsolutePath())) {
                    com.apm.insight.l.f.a(file);
                } else if (!com.apm.insight.l.f.e(file) && !com.apm.insight.g.a.a().b(file.getName())) {
                    if (file.isFile()) {
                        com.apm.insight.l.f.a(file);
                    } else {
                        String name = file.getName();
                        if (name.endsWith("G")) {
                            String[] strArrSplit = name.split("_");
                            if (strArrSplit.length < 5) {
                                c0122b.b.add(new a(file, null));
                            } else {
                                try {
                                    long j = Long.parseLong(strArrSplit[c]);
                                    long j2 = Long.parseLong(strArrSplit[4]);
                                    String str = strArrSplit[2];
                                    String str2 = strArrSplit[1];
                                    int iHashCode = str2.hashCode();
                                    if (iHashCode != -1109843021) {
                                        if (iHashCode != 96741) {
                                            if (iHashCode == 3254818 && str2.equals("java")) {
                                                b2 = 1;
                                            } else {
                                                b2 = -1;
                                            }
                                        } else if (str2.equals("anr")) {
                                            b2 = 2;
                                        } else {
                                            b2 = -1;
                                        }
                                    } else if (str2.equals("launch")) {
                                        b2 = 0;
                                    } else {
                                        b2 = -1;
                                    }
                                    if (b2 == 0) {
                                        crashType = CrashType.LAUNCH;
                                    } else if (b2 == 1) {
                                        crashType = CrashType.JAVA;
                                    } else {
                                        crashType = b2 != 2 ? null : CrashType.ANR;
                                    }
                                    C0122b c0122b2 = map.get(str);
                                    if (c0122b2 == null) {
                                        c0122b2 = new C0122b(str);
                                        map.put(str, c0122b2);
                                    }
                                    a aVar = new a(file, j, crashType);
                                    aVar.c = j2;
                                    if ((c0122b2.d == null || c0122b2.d.b > aVar.b) && crashType != null && crashType != CrashType.ANR && !name.contains("ignore")) {
                                        c0122b2.d = aVar;
                                    }
                                    c0122b2.b.add(aVar);
                                } catch (Throwable unused) {
                                    c0122b.b.add(new a(file, null));
                                    com.apm.insight.c.a();
                                    com.apm.insight.runtime.k.a(new RuntimeException("err format crashTime:".concat(String.valueOf(name))), "NPTH_CATCH");
                                }
                            }
                        } else {
                            com.apm.insight.l.f.a(file);
                        }
                    }
                }
            } catch (Throwable th) {
                com.apm.insight.c.a();
                com.apm.insight.runtime.k.a(th, "NPTH_CATCH");
            }
            i++;
            c = 0;
        }
    }

    private static JSONObject a(com.apm.insight.nativecrash.a aVar) {
        JSONObject jSONObjectB = aVar.b();
        if (jSONObjectB != null && jSONObjectB.length() != 0) {
            return jSONObjectB;
        }
        if (com.apm.insight.e.d()) {
            aVar.j();
        }
        if (!aVar.a()) {
            aVar.i();
            return null;
        }
        if (!aVar.d()) {
            aVar.i();
            return null;
        }
        if (aVar.e()) {
            aVar.i();
            return null;
        }
        aVar.c();
        return aVar.h();
    }

    private void a(final C0122b c0122b, boolean z, com.apm.insight.runtime.g gVar) {
        Iterator<a> it;
        final File file;
        CrashType crashType;
        if (c0122b.b.isEmpty()) {
            return;
        }
        if (c0122b.e == null) {
            c0122b.e = c0122b.d;
        }
        for (Iterator<a> it2 = c0122b.b.iterator(); it2.hasNext(); it2 = it) {
            a next = it2.next();
            try {
                File file2 = next.f228a;
                CrashType crashType2 = next.d;
                it = it2;
                try {
                    final com.apm.insight.f.b bVarA = a(file2, crashType2, c0122b.f229a, next.b, next.c);
                    if (bVarA == null) {
                        com.apm.insight.l.f.a(file2);
                    } else {
                        JSONObject jSONObjectB = bVarA.b();
                        if (jSONObjectB == null) {
                            com.apm.insight.l.f.a(file2);
                        } else {
                            JSONObject jSONObjectOptJSONObject = jSONObjectB.optJSONObject("header");
                            if (jSONObjectOptJSONObject == null) {
                                com.apm.insight.l.f.a(file2);
                            } else {
                                if (crashType2 == null) {
                                    file = file2;
                                    if (new File(file, file2.getName()).exists() || file.getName().split("_").length < 5) {
                                        if (e.b(bVarA.a(), jSONObjectB.toString()).a()) {
                                            com.apm.insight.l.f.a(file);
                                        }
                                    }
                                } else {
                                    file = file2;
                                }
                                File fileA = com.apm.insight.entity.b.a(file);
                                if (!fileA.exists()) {
                                    com.apm.insight.l.f.a(file);
                                } else {
                                    try {
                                        JSONArray jSONArray = new JSONArray(com.apm.insight.l.f.a(fileA, "\n"));
                                        JSONObject jSONObjectOptJSONObject2 = crashType2 == CrashType.LAUNCH ? ((JSONArray) jSONObjectB.opt("data")).optJSONObject(0) : jSONObjectB;
                                        if ((!z && c0122b.e != next) || next.e.contains("ignore")) {
                                            try {
                                                com.apm.insight.entity.a.a(jSONObjectOptJSONObject2, "filters", yk.SESSION_HISTORY_KEY_AD_ID, String.valueOf(String.valueOf(jSONObjectOptJSONObject.opt(yk.SESSION_HISTORY_KEY_AD_ID))));
                                                crashType = crashType2;
                                                try {
                                                    com.apm.insight.entity.a.a(jSONObjectOptJSONObject2, "filters", "has_ignore", String.valueOf(next.e.contains("ignore")));
                                                    jSONObjectOptJSONObject.put(yk.SESSION_HISTORY_KEY_AD_ID, 2010);
                                                } catch (Throwable th) {
                                                    th = th;
                                                    com.apm.insight.c.a();
                                                    com.apm.insight.runtime.k.a(th, "NPTH_CATCH");
                                                }
                                            } catch (Throwable th2) {
                                                th = th2;
                                                crashType = crashType2;
                                            }
                                        } else {
                                            crashType = crashType2;
                                            if (gVar != null && !gVar.a(jSONObjectOptJSONObject2.optString("crash_md5", "default"))) {
                                                com.apm.insight.l.f.a(next.f228a);
                                            }
                                        }
                                        com.apm.insight.entity.a.a(jSONObjectOptJSONObject2, "filters", "start_uuid", c0122b.f229a);
                                        com.apm.insight.entity.a.a(jSONObjectOptJSONObject2, "filters", "leak_threads_count", String.valueOf(c0122b.g));
                                        com.apm.insight.entity.a.a(jSONObjectOptJSONObject2, "filters", "crash_thread_name", jSONObjectOptJSONObject2.optString("crash_thread_name", "unknown"));
                                        try {
                                            com.apm.insight.entity.b.a(jSONObjectB, jSONArray, new com.apm.insight.entity.b.a() { // from class: com.apm.insight.k.b.3
                                                @Override // com.apm.insight.entity.b.a
                                                public final void a(JSONObject jSONObject) {
                                                    e.a(bVarA.a(), jSONObject.toString(), new File(file, "logZip"), com.apm.insight.l.j.a(b.this.f223a, c0122b.f229a));
                                                }
                                            });
                                            if (!com.apm.insight.l.f.a(file)) {
                                                com.apm.insight.e.a.a().a(com.apm.insight.d.a.b(file.getAbsolutePath()));
                                            }
                                            c.a(crashType, jSONObjectB);
                                        } catch (Throwable th3) {
                                            th = th3;
                                            com.apm.insight.c.a();
                                            com.apm.insight.runtime.k.a(th, "NPTH_CATCH");
                                            com.apm.insight.l.f.a(next.f228a);
                                        }
                                    } catch (Throwable unused) {
                                    }
                                }
                            }
                        }
                    }
                } catch (Throwable th4) {
                    th = th4;
                    com.apm.insight.c.a();
                    com.apm.insight.runtime.k.a(th, "NPTH_CATCH");
                    com.apm.insight.l.f.a(next.f228a);
                }
            } catch (Throwable th5) {
                th = th5;
                it = it2;
            }
        }
    }

    private void b(final C0122b c0122b, boolean z, com.apm.insight.runtime.g gVar) {
        boolean z2;
        if (c0122b.c.size() <= 1 && c0122b.c.isEmpty()) {
            c0122b.e = c0122b.d;
            return;
        }
        boolean zB = com.apm.insight.l.k.b(this.f223a);
        c0122b.e = c0122b.d;
        com.apm.insight.nativecrash.a aVar = new com.apm.insight.nativecrash.a(this.f223a);
        for (a aVar2 : c0122b.c) {
            final File file = aVar2.f228a;
            try {
                aVar.a(file);
                JSONObject jSONObjectA = a(aVar);
                if (jSONObjectA == null || jSONObjectA.length() == 0) {
                    z2 = zB;
                    aVar.i();
                } else if (jSONObjectA.length() != 0) {
                    try {
                        if (!z) {
                            long jOptLong = jSONObjectA.optLong("crash_time");
                            try {
                                if (c0122b.e == null) {
                                    c0122b.e = aVar2;
                                    c0122b.f = true;
                                    if (gVar == null || gVar.a("default")) {
                                        z2 = zB;
                                    } else {
                                        aVar.i();
                                    }
                                } else {
                                    if (c0122b.f) {
                                        z2 = zB;
                                    } else {
                                        z2 = zB;
                                        try {
                                            if (jOptLong < c0122b.e.b) {
                                                c0122b.e = aVar2;
                                                if (gVar != null && !gVar.a("default")) {
                                                    aVar.i();
                                                    zB = z2;
                                                } else {
                                                    a(file);
                                                    c0122b.f = true;
                                                }
                                            }
                                        } catch (Throwable th) {
                                            th = th;
                                            com.apm.insight.c.a();
                                            com.apm.insight.runtime.k.a(th, "NPTH_CATCH");
                                            com.apm.insight.l.f.a(file);
                                            zB = z2;
                                        }
                                    }
                                    com.apm.insight.entity.a.a(jSONObjectA, "filters", yk.SESSION_HISTORY_KEY_AD_ID, String.valueOf(jSONObjectA.optJSONObject("header").opt(yk.SESSION_HISTORY_KEY_AD_ID)));
                                    jSONObjectA.optJSONObject("header").put(yk.SESSION_HISTORY_KEY_AD_ID, 2010);
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                z2 = zB;
                            }
                        } else {
                            z2 = zB;
                            if (gVar != null && !gVar.a("default")) {
                                aVar.i();
                            }
                        }
                        com.apm.insight.entity.a.a(jSONObjectA, "filters", "start_uuid", c0122b.f229a);
                        com.apm.insight.entity.a.a(jSONObjectA, "filters", "crash_thread_name", jSONObjectA.optString("crash_thread_name", "unknown"));
                        if (z2) {
                            c.a aVar3 = new c.a(jSONObjectA, CrashType.NATIVE);
                            com.apm.insight.entity.b.a(jSONObjectA, com.apm.insight.entity.b.a(aVar3.c(), aVar3.a(), q.a().b(aVar3.b() == -1 ? System.currentTimeMillis() : aVar3.b())), new com.apm.insight.entity.b.a() { // from class: com.apm.insight.k.b.4
                                @Override // com.apm.insight.entity.b.a
                                public final void a(JSONObject jSONObject) {
                                    d.a();
                                    d.a(jSONObject, file, com.apm.insight.l.j.a(b.this.f223a, c0122b.f229a));
                                }
                            });
                            if (!aVar.i()) {
                                aVar.f();
                            }
                        }
                        c.a(CrashType.NATIVE, jSONObjectA);
                    } catch (Throwable th3) {
                        th = th3;
                        com.apm.insight.c.a();
                        com.apm.insight.runtime.k.a(th, "NPTH_CATCH");
                        com.apm.insight.l.f.a(file);
                    }
                } else {
                    z2 = zB;
                }
            } catch (Throwable th4) {
                th = th4;
                z2 = zB;
            }
            zB = z2;
        }
    }

    private static boolean a(File file) {
        String[] list = file.list();
        if (list == null) {
            return false;
        }
        for (String str : list) {
            if (!TextUtils.isEmpty(str) && str.endsWith("")) {
                return true;
            }
        }
        return false;
    }

    private com.apm.insight.f.b a(File file, CrashType crashType, String str, long j, long j2) {
        com.apm.insight.f.b bVar;
        try {
            try {
                if (file.isFile()) {
                    com.apm.insight.l.f.a(file);
                    return null;
                }
                boolean z = crashType == CrashType.LAUNCH;
                if (crashType == null) {
                    try {
                        return com.apm.insight.l.f.b(new File(file, file.getName()).getAbsolutePath());
                    } catch (Throwable th) {
                        th = th;
                        bVar = null;
                        com.apm.insight.l.f.a(file);
                        com.apm.insight.c.a();
                        com.apm.insight.runtime.k.a(th, "NPTH_CATCH");
                        return bVar;
                    }
                }
                com.apm.insight.f.b bVarA = com.apm.insight.l.f.a(file, crashType);
                try {
                    JSONObject jSONObjectB = bVarA.b();
                    if (bVarA.b() != null) {
                        if (crashType == CrashType.ANR) {
                            return bVarA;
                        }
                        jSONObjectB.put("crash_time", j);
                        jSONObjectB.put("app_start_time", j2);
                        JSONObject jSONObjectOptJSONObject = jSONObjectB.optJSONObject("header");
                        if (jSONObjectOptJSONObject == null) {
                            jSONObjectOptJSONObject = Header.a(j).f();
                        } else if (z) {
                            jSONObjectB.remove("header");
                        }
                        String strOptString = jSONObjectOptJSONObject.optString("sdk_version_name", null);
                        if (strOptString == null) {
                            strOptString = "1.3.8.nourl-rc.1";
                        }
                        com.apm.insight.entity.a.a(jSONObjectB, "filters", "sdk_version", strOptString);
                        JSONArray jSONArrayOptJSONArray = jSONObjectB.optJSONArray("logcat");
                        if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() == 0) {
                            jSONObjectB.put("logcat", com.apm.insight.runtime.i.a(str));
                        }
                        com.apm.insight.entity.a.a(jSONObjectB, "filters", "has_dump", "true");
                        com.apm.insight.entity.a.a(jSONObjectB, "filters", "has_logcat", String.valueOf(!com.apm.insight.a.a(jSONObjectB, "logcat")));
                        com.apm.insight.entity.a.a(jSONObjectB, "filters", "memory_leak", String.valueOf(com.apm.insight.entity.a.a(str)));
                        com.apm.insight.entity.a.a(jSONObjectB, "filters", "fd_leak", String.valueOf(com.apm.insight.entity.a.b(str)));
                        com.apm.insight.entity.a.a(jSONObjectB, "filters", "threads_leak", String.valueOf(com.apm.insight.entity.a.c(str)));
                        com.apm.insight.entity.a.a(jSONObjectB, "filters", "is_64_devices", String.valueOf(Header.a()));
                        com.apm.insight.entity.a.a(jSONObjectB, "filters", "is_64_runtime", String.valueOf(NativeImpl.f()));
                        com.apm.insight.entity.a.a(jSONObjectB, "filters", "is_x86_devices", String.valueOf(Header.b()));
                        com.apm.insight.entity.a.a(jSONObjectB, "filters", "has_meminfo_file", String.valueOf(com.apm.insight.l.j.d(str).exists()));
                        com.apm.insight.entity.a.a(jSONObjectB, "filters", "is_root", String.valueOf(com.apm.insight.nativecrash.a.k()));
                        jSONObjectB.put("launch_did", com.apm.insight.i.a.a(this.f223a));
                        jSONObjectB.put("crash_uuid", file.getName());
                        jSONObjectB.put("jiffy", o.a.a());
                        try {
                            long j3 = Long.parseLong(com.apm.insight.runtime.b.a(j, str));
                            com.apm.insight.entity.a.a(jSONObjectB, "filters", "lastAliveTime", Math.abs(j3 - j) < 60000 ? "< 60s" : "> 60s");
                            jSONObjectB.put("lastAliveTime", String.valueOf(j3));
                        } catch (Throwable unused) {
                            jSONObjectB.put("lastAliveTime", "unknown");
                            com.apm.insight.entity.a.a(jSONObjectB, "filters", "lastAliveTime", "unknown");
                        }
                        jSONObjectB.put("has_dump", "true");
                        if (jSONObjectB.opt(b9.a.k) == null) {
                            com.apm.insight.e.g();
                            com.apm.insight.entity.a.a(jSONObjectB, com.apm.insight.l.n.a());
                        }
                        if (Header.b(jSONObjectOptJSONObject)) {
                            com.apm.insight.entity.a.a(jSONObjectB, "filters", "unauthentic_version", "unauthentic_version");
                        }
                        com.apm.insight.entity.d.b(jSONObjectB);
                        bVarA.b().put("upload_scene", "launch_scan");
                        if (z) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObjectB.put("event_type", "start_crash");
                            jSONObjectB.put("stack", jSONObjectB.remove("data"));
                            jSONObject.put("data", new JSONArray().put(jSONObjectB));
                            jSONObject.put("header", jSONObjectOptJSONObject);
                            bVarA.a(jSONObject);
                        } else {
                            jSONObjectB.put("isJava", 1);
                        }
                    } else {
                        com.apm.insight.l.f.a(file);
                    }
                    return bVarA;
                } catch (Throwable th2) {
                    th = th2;
                    bVar = bVarA;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
            bVar = null;
        }
        com.apm.insight.l.f.a(file);
        com.apm.insight.c.a();
        com.apm.insight.runtime.k.a(th, "NPTH_CATCH");
        return bVar;
    }

    private void g() {
        File[] fileArrListFiles = com.apm.insight.l.j.i(this.f223a).listFiles();
        if (fileArrListFiles == null) {
            return;
        }
        for (int i = 0; i < fileArrListFiles.length && i < 5; i++) {
            File file = fileArrListFiles[i];
            if (file.getName().endsWith(".atmp")) {
                com.apm.insight.a.a.a();
                file.getAbsolutePath();
            } else {
                try {
                    com.apm.insight.f.b bVarC = com.apm.insight.l.f.c(file.getAbsolutePath());
                    if (bVarC != null) {
                        if (bVarC.b() != null) {
                            bVarC.b().put("upload_scene", "launch_scan");
                        }
                        if (e.a(e.d(), bVarC.e(), bVarC.d(), bVarC.f(), bVarC.g())) {
                            com.apm.insight.l.f.a(file);
                            String strC = bVarC.c();
                            if (!TextUtils.isEmpty(strC)) {
                                com.apm.insight.l.f.a(new File(strC));
                            }
                        }
                    } else {
                        com.apm.insight.l.f.a(file);
                    }
                } catch (Throwable th) {
                    com.apm.insight.c.a();
                    com.apm.insight.runtime.k.a(th, "NPTH_CATCH");
                }
            }
        }
    }
}
