package com.json;

import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.text.TextUtils;
import android.util.Log;
import com.json.environment.ContextProvider;
import com.json.mediationsdk.logger.IronLog;
import com.safedk.android.internal.partials.IronSourceNetworkBridge;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class o9 {
    private static final String k = "1.0.6";
    public static String l = "";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final nf f4109a;
    private String b;
    private String c;
    private String d;
    private String e;
    private ContextProvider f;
    public Thread.UncaughtExceptionHandler g;
    public String h;
    private String i;
    private boolean j;

    class a implements com.json.b {
        a() {
        }

        @Override // com.json.b
        public void a() {
            Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
            StringBuilder sb = new StringBuilder(128);
            for (Thread thread : allStackTraces.keySet()) {
                StackTraceElement[] stackTrace = thread.getStackTrace();
                if (stackTrace != null && stackTrace.length > 0) {
                    sb.append("*** Thread Name ").append(thread.getName()).append(" Thread ID ").append(thread.getId()).append(" (").append(thread.getState().toString()).append(") ***\n");
                    for (StackTraceElement stackTraceElement : stackTrace) {
                        sb.append(stackTraceElement.toString()).append(" ").append(thread.getState().toString()).append("\n");
                    }
                }
            }
            o9.l = sb.toString();
        }

        @Override // com.json.b
        public void b() {
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f4111a;
        final /* synthetic */ String b;

        b(Context context, String str) {
            this.f4111a = context;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                String strP = o9.this.f4109a.p(this.f4111a);
                if (!TextUtils.isEmpty(strP)) {
                    o9.this.c = strP;
                }
                String strA = o9.this.f4109a.a(this.f4111a);
                if (!TextUtils.isEmpty(strA)) {
                    o9.this.e = strA;
                }
                SharedPreferences.Editor editorEdit = this.f4111a.getSharedPreferences("CRep", 0).edit();
                editorEdit.putString("String1", o9.this.c);
                editorEdit.putString("sId", this.b);
                editorEdit.apply();
            } catch (Exception e) {
                IronLog.INTERNAL.error(e.toString());
            }
        }
    }

    class c extends p9 {
        c(JSONObject jSONObject) {
            super(jSONObject);
        }
    }

    private static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static volatile o9 f4112a = new o9(null);

        private d() {
        }
    }

    private o9() {
        this.j = false;
        this.f4109a = mm.S().f();
        this.f = ContextProvider.getInstance();
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        this.g = defaultUncaughtExceptionHandler;
        this.i = " ";
        this.h = "https://o-crash.mediation.unity3d.com/reporter";
        Thread.setDefaultUncaughtExceptionHandler(new m9(defaultUncaughtExceptionHandler));
    }

    /* synthetic */ o9(a aVar) {
        this();
    }

    private String a(Context context) {
        ConnectivityManager connectivityManager;
        if (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null) {
            return "none";
        }
        try {
            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
            if (networkCapabilities == null) {
                return "none";
            }
            if (networkCapabilities.hasTransport(1)) {
                return x8.b;
            }
            return networkCapabilities.hasTransport(0) ? x8.g : "none";
        } catch (Exception e) {
            IronLog.INTERNAL.error(e.toString());
            return "none";
        }
    }

    private void a(Context context, HashSet<String> hashSet) throws Throwable {
        String strA = a(a());
        if (strA.equals("none")) {
            return;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("CRep", 0);
        String string = sharedPreferences.getString("String1", this.c);
        String string2 = sharedPreferences.getString("sId", this.d);
        List<lc> listB = fa.b();
        IronLog.INTERNAL.verbose("reportList size " + listB.size());
        for (lc lcVar : listB) {
            JSONObject jSONObjectJsonObjectInit = IronSourceNetworkBridge.jsonObjectInit();
            String strB = lcVar.b();
            String strE = lcVar.e();
            String strD = lcVar.d();
            String packageName = context.getPackageName();
            JSONObject jSONObjectJsonObjectInit2 = IronSourceNetworkBridge.jsonObjectInit();
            try {
                ActivityManager.MemoryInfo memoryInfoZ = this.f4109a.z(context);
                if (memoryInfoZ != null) {
                    jSONObjectJsonObjectInit2.put("availRam", this.f4109a.c(memoryInfoZ));
                    jSONObjectJsonObjectInit2.put(fe.x, this.f4109a.b(memoryInfoZ));
                    jSONObjectJsonObjectInit2.put(fe.y, this.f4109a.a(memoryInfoZ));
                }
                String strI = this.f4109a.i();
                if (strI != null) {
                    jSONObjectJsonObjectInit2.put(fe.z, strI);
                }
                jSONObjectJsonObjectInit2.put("crashDate", strB);
                jSONObjectJsonObjectInit2.put("stacktraceCrash", strE);
                jSONObjectJsonObjectInit2.put("crashType", strD);
                jSONObjectJsonObjectInit2.put("CrashReporterVersion", k);
                jSONObjectJsonObjectInit2.put(b9.i.q, "8.7.0");
                jSONObjectJsonObjectInit2.put(b9.i.x, this.f4109a.b(context));
                jSONObjectJsonObjectInit2.put("appVersion", c4.b(context, packageName));
                jSONObjectJsonObjectInit2.put(b9.i.n, this.f4109a.p());
                jSONObjectJsonObjectInit2.put("network", strA);
                jSONObjectJsonObjectInit2.put(b9.i.p, this.f4109a.l());
                jSONObjectJsonObjectInit2.put(b9.i.l, this.f4109a.e());
                jSONObjectJsonObjectInit2.put("totalRam", this.f4109a.h(context));
                jSONObjectJsonObjectInit2.put("deviceOS", this.f4109a.m());
                jSONObjectJsonObjectInit2.put("advertisingId", string);
                jSONObjectJsonObjectInit2.put(b9.i.k, this.f4109a.g());
                jSONObjectJsonObjectInit2.put("systemProperties", System.getProperties());
                jSONObjectJsonObjectInit2.put("bundleId", packageName);
                jSONObjectJsonObjectInit2.put("sId", string2);
                if (!TextUtils.isEmpty(this.e)) {
                    jSONObjectJsonObjectInit2.put(b9.i.M, Boolean.parseBoolean(this.e));
                }
                if (hashSet == null || hashSet.isEmpty()) {
                    jSONObjectJsonObjectInit = jSONObjectJsonObjectInit2;
                } else {
                    for (String str : hashSet) {
                        try {
                            if (jSONObjectJsonObjectInit2.has(str)) {
                                jSONObjectJsonObjectInit.put(str, jSONObjectJsonObjectInit2.opt(str));
                            }
                        } catch (Exception e) {
                            IronLog.INTERNAL.error(e.toString());
                        }
                    }
                }
            } catch (Exception unused) {
            }
            if (jSONObjectJsonObjectInit.length() == 0) {
                Log.d("ISCrashReport", " Is Empty");
            } else {
                new Thread(new c(jSONObjectJsonObjectInit)).start();
            }
        }
        fa.a();
    }

    static List<lc> c() {
        return null;
    }

    public static o9 d() {
        return d.f4112a;
    }

    Context a() {
        return this.f.getApplicationContext();
    }

    public void a(Throwable th) {
        IronLog.INTERNAL.verbose("isInitialized=" + this.j);
        if (!this.j || th == null) {
            return;
        }
        new lc(new n9(th).getStackTrace(), "" + System.currentTimeMillis(), "Caught_IS_Crash").a();
    }

    public void a(HashSet<String> hashSet, String str, String str2, boolean z, String str3, int i, boolean z2) throws Throwable {
        Context applicationContext = this.f.getApplicationContext();
        if (applicationContext != null) {
            Log.d("automation_log", "init ISCrashReporter");
            if (!TextUtils.isEmpty(str2)) {
                this.i = str2;
            }
            if (!TextUtils.isEmpty(str)) {
                this.h = str;
            }
            this.d = str3;
            if (z) {
                new com.json.a(i).a(z2).b(true).a(new a()).start();
            }
            a(applicationContext, hashSet);
            new Thread(new b(applicationContext, str3)).start();
        }
        this.j = true;
        IronLog.INTERNAL.verbose("initialized");
    }

    public String b() {
        return k;
    }

    String e() {
        return this.i;
    }
}
