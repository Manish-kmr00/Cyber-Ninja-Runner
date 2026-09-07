package com.apm.insight.nativecrash;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.apm.insight.ICommonParams;
import com.apm.insight.l.j;
import com.apm.insight.l.m;
import com.apm.insight.runtime.k;
import com.json.yk;
import com.safedk.android.analytics.brandsafety.creatives.discoveries.t;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

/* JADX INFO: compiled from: NativeFileParser.java */
/* JADX INFO: loaded from: classes7.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f265a;
    private ICommonParams b;
    private ICommonParams c;

    /* JADX INFO: compiled from: NativeFileParser.java */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected File f266a;
        protected String b;
        protected String c;
        protected int d;

        public c(File file) {
            this.f266a = file;
        }

        public final int a() {
            int i;
            Throwable th;
            if (!this.f266a.exists() || !this.f266a.isFile()) {
                return -1;
            }
            BufferedReader bufferedReader = null;
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new FileReader(this.f266a));
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

    /* JADX INFO: renamed from: com.apm.insight.nativecrash.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: NativeFileParser.java */
    public static class C0124b extends c {
        C0124b(File file) {
            super(file);
            this.b = "VmSize:";
            this.c = "\\s+";
            this.d = -1;
        }
    }

    /* JADX INFO: compiled from: NativeFileParser.java */
    public static class f extends c {
        f(File file) {
            super(file);
            this.b = "Total Threads Count:";
            this.c = ":";
            this.d = -2;
        }
    }

    /* JADX INFO: compiled from: NativeFileParser.java */
    public static class a extends c {
        a(File file) {
            super(file);
            this.b = "Total FD Count:";
            this.c = ":";
            this.d = -2;
        }
    }

    /* JADX INFO: compiled from: NativeFileParser.java */
    public static class d extends c {
        d(File file) {
            super(file);
        }

        public final HashMap<String, List<String>> b() {
            String strSubstring;
            HashMap<String, List<String>> map = new HashMap<>();
            try {
                JSONArray jSONArrayA = com.apm.insight.l.f.a(this.f266a.getAbsolutePath());
                if (jSONArrayA == null) {
                    return map;
                }
                for (int i = 0; i < jSONArrayA.length(); i++) {
                    String strOptString = jSONArrayA.optString(i);
                    if (!TextUtils.isEmpty(strOptString) && strOptString.startsWith("[tid:0") && strOptString.endsWith("sigstack:0x0]")) {
                        int iIndexOf = strOptString.indexOf("[routine:0x");
                        int i2 = iIndexOf + 11;
                        int iIndexOf2 = strOptString.indexOf(93, i2);
                        if (iIndexOf > 0) {
                            strSubstring = strOptString.substring(i2, iIndexOf2);
                        } else {
                            strSubstring = "unknown addr";
                        }
                        List<String> arrayList = map.get(strSubstring);
                        if (arrayList == null) {
                            arrayList = new ArrayList<>();
                            map.put(strSubstring, arrayList);
                        }
                        arrayList.add(strOptString);
                    }
                }
            } catch (IOException unused) {
            } catch (Throwable th) {
                com.apm.insight.c.a();
                k.a(th, "NPTH_CATCH");
            }
            return map;
        }
    }

    /* JADX INFO: compiled from: NativeFileParser.java */
    public static class e extends c {
        e(File file) {
            super(file);
        }

        public final JSONArray a(HashMap<String, List<String>> map) {
            int iIndexOf;
            List<String> list;
            JSONArray jSONArray = new JSONArray();
            if (map.isEmpty()) {
                return jSONArray;
            }
            try {
                JSONArray jSONArrayA = com.apm.insight.l.f.a(this.f266a.getAbsolutePath());
                if (jSONArrayA == null) {
                    return jSONArray;
                }
                for (int i = 0; i < jSONArrayA.length(); i++) {
                    String strOptString = jSONArrayA.optString(i);
                    if (!TextUtils.isEmpty(strOptString) && (iIndexOf = strOptString.indexOf(":")) > 2) {
                        String strSubstring = strOptString.substring(2, iIndexOf);
                        if (map.containsKey(strSubstring) && (list = map.get(strSubstring)) != null) {
                            Iterator<String> it = list.iterator();
                            while (it.hasNext()) {
                                jSONArray.put(it.next() + " " + strOptString);
                            }
                            map.remove(strSubstring);
                        }
                    }
                }
                Iterator<List<String>> it2 = map.values().iterator();
                while (it2.hasNext()) {
                    Iterator<String> it3 = it2.next().iterator();
                    while (it3.hasNext()) {
                        jSONArray.put(it3.next() + "  0x000000:unknown");
                    }
                }
            } catch (IOException unused) {
            } catch (Throwable th) {
                com.apm.insight.c.a();
                k.a(th, "NPTH_CATCH");
            }
            return jSONArray;
        }
    }

    public static JSONArray a(File file, File file2) {
        return new e(file2).a(new d(file).b());
    }

    public static int a(String str) {
        return new a(j.b(str)).a();
    }

    public static int b(String str) {
        return new f(j.c(str)).a();
    }

    public static int c(String str) {
        return new C0124b(j.d(str)).a();
    }

    public b(Context context, ICommonParams iCommonParams) {
        this(context, iCommonParams, null);
    }

    public b(Context context, ICommonParams iCommonParams, b bVar) {
        this.f265a = context;
        this.b = iCommonParams;
        this.c = bVar == null ? null : bVar.b;
    }

    public final Map<String, Object> a() {
        Object obj;
        Map<String, Object> mapB = b();
        if (((mapB == null || (obj = mapB.get(yk.SESSION_HISTORY_KEY_AD_ID)) == null) ? null : String.valueOf(obj)) == null) {
            mapB.put(yk.SESSION_HISTORY_KEY_AD_ID, 4444);
        }
        return mapB;
    }

    public final Map<String, Object> b() {
        Map<String, Object> map;
        Throwable th;
        Map<String, Object> map2;
        try {
            ICommonParams iCommonParams = this.c;
            if (iCommonParams != null) {
                map2 = iCommonParams.getCommonParams();
            } else {
                map2 = new HashMap<>();
            }
            try {
                map2.putAll(this.b.getCommonParams());
                th = null;
            } catch (Throwable th2) {
                map = map2;
                th = th2;
                Map<String, Object> map3 = map;
                th = th;
                map2 = map3;
            }
        } catch (Throwable th3) {
            th = th3;
            map = null;
        }
        if (map2 == null) {
            map2 = new HashMap<>(4);
            if (th != null) {
                try {
                    map2.put("err_info", m.a(th));
                } catch (Throwable unused) {
                }
            }
        }
        if (a(map2)) {
            try {
                PackageInfo packageInfo = this.f265a.getPackageManager().getPackageInfo(this.f265a.getPackageName(), 128);
                map2.put("version_name", packageInfo.versionName);
                map2.put("version_code", Integer.valueOf(packageInfo.versionCode));
                if (map2.get("update_version_code") == null) {
                    Object obj = packageInfo.applicationInfo.metaData != null ? packageInfo.applicationInfo.metaData.get("UPDATE_VERSION_CODE") : null;
                    if (obj == null) {
                        obj = map2.get("version_code");
                    }
                    map2.put("update_version_code", obj);
                }
            } catch (Throwable unused2) {
                map2.put("version_name", com.apm.insight.l.a.e(this.f265a));
                map2.put("version_code", Integer.valueOf(com.apm.insight.l.a.f(this.f265a)));
                if (map2.get("update_version_code") == null) {
                    map2.put("update_version_code", map2.get("version_code"));
                }
            }
        } else {
            try {
                String str = this.f265a.getPackageManager().getPackageInfo(this.f265a.getPackageName(), 128).versionName;
                String str2 = (String) Class.forName(this.f265a.getPackageName() + ".BuildConfig").getDeclaredField(t.e).get(null);
                if (str != null && !str.equals(str2)) {
                    map2.put("manifest_version", str);
                }
            } catch (Throwable unused3) {
            }
        }
        return map2;
    }

    public static boolean a(Map<String, Object> map) {
        if (map == null || map.isEmpty()) {
            return true;
        }
        return ((map.containsKey("app_version") || map.containsKey("version_name")) && map.containsKey("version_code") && map.containsKey("update_version_code")) ? false : true;
    }

    public final ICommonParams c() {
        return this.b;
    }

    public final String d() {
        try {
            return this.b.getDeviceId();
        } catch (Throwable unused) {
            return "";
        }
    }

    public final String e() {
        try {
            return String.valueOf(this.b.getCommonParams().get(yk.SESSION_HISTORY_KEY_AD_ID));
        } catch (Throwable unused) {
            return "4444";
        }
    }

    public final long f() {
        try {
            return this.b.getUserId();
        } catch (Throwable unused) {
            return 0L;
        }
    }
}
