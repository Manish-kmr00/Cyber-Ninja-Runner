package com.apm.insight;

import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.apm.insight.entity.Header;
import com.apm.insight.l.j;
import com.apm.insight.nativecrash.NativeImpl;
import com.apm.insight.runtime.k;
import com.facebook.internal.FacebookRequestErrorClassification;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipFile;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: AppDataCenter.java */
/* JADX INFO: loaded from: classes14.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<CrashType, List<AttachUserData>> f163a = new HashMap();
    private Map<CrashType, List<AttachUserData>> b = new HashMap();
    private Map<String, String> c = new HashMap();
    private ICrashFilter d = null;

    final void a(AttachUserData attachUserData, CrashType crashType) {
        if (crashType == CrashType.ALL) {
            c(CrashType.LAUNCH, attachUserData);
            c(CrashType.JAVA, attachUserData);
            c(CrashType.CUSTOM_JAVA, attachUserData);
            c(CrashType.NATIVE, attachUserData);
            c(CrashType.ANR, attachUserData);
            c(CrashType.DART, attachUserData);
            return;
        }
        c(crashType, attachUserData);
    }

    final void b(AttachUserData attachUserData, CrashType crashType) {
        if (crashType == CrashType.ALL) {
            d(CrashType.LAUNCH, attachUserData);
            d(CrashType.JAVA, attachUserData);
            d(CrashType.CUSTOM_JAVA, attachUserData);
            d(CrashType.NATIVE, attachUserData);
            d(CrashType.ANR, attachUserData);
            d(CrashType.DART, attachUserData);
            return;
        }
        d(crashType, attachUserData);
    }

    final void a(CrashType crashType, AttachUserData attachUserData) {
        if (crashType == CrashType.ALL) {
            e(CrashType.LAUNCH, attachUserData);
            e(CrashType.JAVA, attachUserData);
            e(CrashType.CUSTOM_JAVA, attachUserData);
            e(CrashType.NATIVE, attachUserData);
            e(CrashType.ANR, attachUserData);
            e(CrashType.DART, attachUserData);
            return;
        }
        e(crashType, attachUserData);
    }

    final void b(CrashType crashType, AttachUserData attachUserData) {
        if (crashType == CrashType.ALL) {
            f(CrashType.LAUNCH, attachUserData);
            f(CrashType.JAVA, attachUserData);
            f(CrashType.CUSTOM_JAVA, attachUserData);
            f(CrashType.NATIVE, attachUserData);
            f(CrashType.ANR, attachUserData);
            f(CrashType.DART, attachUserData);
            return;
        }
        f(crashType, attachUserData);
    }

    private void c(CrashType crashType, AttachUserData attachUserData) {
        List<AttachUserData> arrayList;
        if (this.f163a.get(crashType) == null) {
            arrayList = new ArrayList<>();
            this.f163a.put(crashType, arrayList);
        } else {
            arrayList = this.f163a.get(crashType);
        }
        arrayList.add(attachUserData);
    }

    private void d(CrashType crashType, AttachUserData attachUserData) {
        List<AttachUserData> arrayList;
        if (this.b.get(crashType) == null) {
            arrayList = new ArrayList<>();
            this.b.put(crashType, arrayList);
        } else {
            arrayList = this.b.get(crashType);
        }
        arrayList.add(attachUserData);
    }

    private void e(CrashType crashType, AttachUserData attachUserData) {
        List<AttachUserData> list = this.f163a.get(crashType);
        if (list != null) {
            list.remove(attachUserData);
        }
    }

    private void f(CrashType crashType, AttachUserData attachUserData) {
        List<AttachUserData> list = this.b.get(crashType);
        if (list != null) {
            list.remove(attachUserData);
        }
    }

    public final List<AttachUserData> a(CrashType crashType) {
        return this.f163a.get(crashType);
    }

    public final List<AttachUserData> b(CrashType crashType) {
        return this.b.get(crashType);
    }

    final void a(Map<? extends String, ? extends String> map) {
        this.c.putAll(map);
    }

    public final Map<String, String> a() {
        return this.c;
    }

    final void a(ICrashFilter iCrashFilter) {
        this.d = iCrashFilter;
    }

    public final ICrashFilter b() {
        return this.d;
    }

    public static void c() {
        File[] fileArrListFiles;
        File file = new File(e.g().getFilesDir(), "apminsight/crashCommand");
        if (file.exists() && (fileArrListFiles = file.listFiles()) != null) {
            for (File file2 : fileArrListFiles) {
                try {
                    file2.getName().split("_")[0].equals("0");
                    file2.delete();
                } catch (Throwable th) {
                    c.a();
                    k.a(th, "NPTH_CATCH");
                    try {
                        file2.delete();
                    } catch (Throwable unused) {
                    }
                }
            }
        }
    }

    public static void d() {
        try {
            a(e.f(), e.i().getLogcatDumpCount(), e.i().getLogcatLevel());
            if (e.v()) {
                g();
                i();
                h();
                j();
            }
        } catch (Throwable unused) {
        }
    }

    private static File g() {
        File file = new File(j.e(e.g()), "maps.txt");
        if (file.exists()) {
            return file;
        }
        file.getParentFile().mkdirs();
        try {
            file.createNewFile();
        } catch (IOException unused) {
        }
        NativeImpl.f(file.getAbsolutePath());
        return file;
    }

    public static File a(String str, int i, int i2) {
        File file = new File(j.a(e.g(), str), "logcat.txt");
        if (file.exists() && file.length() > 0) {
            return file;
        }
        file.getParentFile().mkdirs();
        try {
            file.createNewFile();
        } catch (IOException unused) {
        }
        NativeImpl.a(file.getAbsolutePath(), String.valueOf(i), String.valueOf(i2));
        return file;
    }

    private static File h() {
        File file = new File(j.e(e.g()), "meminfo.txt");
        if (file.exists()) {
            return file;
        }
        file.getParentFile().mkdirs();
        try {
            file.createNewFile();
        } catch (IOException unused) {
        }
        NativeImpl.d(file.getAbsolutePath());
        return file;
    }

    private static File i() {
        File file = new File(j.e(e.g()), "fds.txt");
        if (file.exists()) {
            return file;
        }
        file.getParentFile().mkdirs();
        try {
            file.createNewFile();
        } catch (IOException unused) {
        }
        NativeImpl.e(file.getAbsolutePath());
        return file;
    }

    private static File j() {
        File file = new File(j.e(e.g()), "threads.txt");
        if (file.exists()) {
            return file;
        }
        file.getParentFile().mkdirs();
        try {
            file.createNewFile();
        } catch (IOException unused) {
        }
        NativeImpl.g(file.getAbsolutePath());
        return file;
    }

    public static File e() throws Throwable {
        BufferedWriter bufferedWriter;
        File file = new File(j.e(e.g()), "anr_trace.txt");
        if (file.exists() || !com.apm.insight.runtime.a.e()) {
            return file;
        }
        File file2 = new File("/data/anr/traces.txt");
        if (!file2.exists()) {
            return file;
        }
        BufferedReader bufferedReader = null;
        try {
            file.getParentFile().mkdirs();
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file2));
            try {
                bufferedWriter = new BufferedWriter(new FileWriter(file));
                int length = 0;
                do {
                    try {
                        String line = bufferedReader2.readLine();
                        if (line == null) {
                            break;
                        }
                        bufferedWriter.write(line);
                        bufferedWriter.write(10);
                        length += line.length();
                    } catch (IOException unused) {
                        bufferedReader = bufferedReader2;
                        a((Closeable) bufferedReader);
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader2;
                        a((Closeable) bufferedReader);
                        a((Closeable) bufferedWriter);
                        throw th;
                    }
                } while (length < 1048576);
                a((Closeable) bufferedReader2);
            } catch (IOException unused2) {
                bufferedWriter = null;
            } catch (Throwable th2) {
                th = th2;
                bufferedWriter = null;
            }
        } catch (IOException unused3) {
            bufferedWriter = null;
        } catch (Throwable th3) {
            th = th3;
            bufferedWriter = null;
        }
        a((Closeable) bufferedWriter);
        return file;
    }

    public static int f() {
        try {
            return new File("/proc/" + Process.myPid() + "/fd").listFiles().length;
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(ZipFile zipFile) {
        if (zipFile == null) {
            return;
        }
        try {
            zipFile.close();
        } catch (IOException unused) {
        }
    }

    public static void a(String str) {
        com.apm.insight.h.a.a("android.os.FileUtils", "setPermissions", str, Integer.valueOf(FacebookRequestErrorClassification.ESC_APP_INACTIVE), -1, -1);
    }

    public static boolean a(JSONObject jSONObject) {
        return jSONObject == null || jSONObject.length() == 0;
    }

    public static boolean a(JSONArray jSONArray) {
        return jSONArray == null || jSONArray.length() == 0;
    }

    public static JSONArray b(JSONArray jSONArray) {
        int i;
        if (jSONArray.length() <= 384) {
            return jSONArray;
        }
        JSONArray jSONArray2 = new JSONArray();
        int i2 = 0;
        while (true) {
            if (i2 >= 256) {
                break;
            }
            jSONArray2.put(jSONArray.opt(i2));
            i2++;
        }
        for (i = 256; i < 384; i++) {
            jSONArray2.put(jSONArray.opt(jSONArray.length() - (384 - i)));
        }
        return jSONArray2;
    }

    public static String a(JSONObject jSONObject, String... strArr) {
        JSONObject jSONObjectB = b(jSONObject, strArr);
        if (jSONObjectB == null) {
            return null;
        }
        String strOptString = jSONObjectB.optString(strArr[1]);
        a("ApmConfig", "normal get configArray: " + strArr[1] + " : " + strOptString);
        return strOptString;
    }

    public static JSONObject b(JSONObject jSONObject, String... strArr) {
        if (jSONObject == null) {
            a("JSONUtil", "err get JsonFromParent: null json", new RuntimeException());
            return null;
        }
        for (int i = 0; i < strArr.length - 1; i++) {
            jSONObject = jSONObject.optJSONObject(strArr[i]);
            if (jSONObject == null) {
                a("JSONUtil", "err get json: not found node:" + strArr[i]);
                return null;
            }
        }
        return jSONObject;
    }

    public static int a(JSONObject jSONObject, int i, String... strArr) {
        JSONObject jSONObjectB = b(jSONObject, strArr);
        if (jSONObjectB == null) {
            return i;
        }
        int iOptInt = jSONObjectB.optInt(strArr[strArr.length - 1], i);
        a("JSONUtil", "normal get jsonInt: " + strArr[strArr.length - 1] + " : " + iOptInt);
        return iOptInt;
    }

    public static boolean a(JSONObject jSONObject, String str) {
        return a(jSONObject) || a(jSONObject.optJSONArray(str));
    }

    public static void a(JSONObject jSONObject, JSONObject jSONObject2) {
        Iterator<String> itKeys = jSONObject2.keys();
        while (itKeys.hasNext()) {
            try {
                String next = itKeys.next();
                if (!jSONObject.has(next)) {
                    jSONObject.put(next, jSONObject2.opt(next));
                }
            } catch (Throwable unused) {
                return;
            }
        }
    }

    public static JSONArray a(String[] strArr) {
        if (strArr == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (String str : strArr) {
            jSONArray.put(str);
        }
        return jSONArray;
    }

    public static void a(Object obj) {
        if (e.i().isDebugMode()) {
            Log.i("npth", String.valueOf(obj));
        }
    }

    public static void b(Object obj) {
        if (e.i().isDebugMode()) {
            Log.d("npth", String.valueOf(obj));
        }
    }

    public static void a(Throwable th) {
        if (e.i().isDebugMode()) {
            Log.e("npth", "NPTH Catch Error", th);
        }
    }

    private static void a(String str, Object obj, Throwable th) {
        if (e.i().isDebugMode()) {
            Log.e("npth", str + " " + obj, th);
        }
    }

    public static void a(String str, Object obj) {
        if (e.i().isDebugMode()) {
            Log.i("npth", str + " " + obj);
        }
    }

    public static void b(Throwable th) {
        if (e.i().isDebugMode()) {
            Log.w("npth", "NPTH Catch Error", th);
        }
    }

    public static void a(com.apm.insight.entity.a aVar, Header header, CrashType crashType) {
        JSONObject jSONObjectC;
        if (aVar == null || (jSONObjectC = aVar.c()) == null || crashType == null) {
            return;
        }
        long jOptLong = jSONObjectC.optLong("crash_time");
        String strA = e.c().a();
        if (jOptLong <= 0 || TextUtils.isEmpty(crashType.getName())) {
            return;
        }
        try {
            String str = "android__" + strA + "_" + jOptLong + "_" + crashType;
            if (header != null) {
                JSONObject jSONObjectF = header.f();
                if (jSONObjectF != null) {
                    jSONObjectF.put("unique_key", str);
                    return;
                }
                return;
            }
            jSONObjectC.put("unique_key", str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static boolean b(String str) {
        try {
            System.loadLibrary(str);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }
}
