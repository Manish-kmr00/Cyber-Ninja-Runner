package com.apm.insight.g;

import android.os.Looper;
import android.os.SystemClock;
import com.apm.insight.CrashType;
import com.apm.insight.ICrashCallback;
import com.apm.insight.ICrashFilter;
import com.apm.insight.IOOMCallback;
import com.apm.insight.e;
import com.apm.insight.k.h;
import com.apm.insight.l.f;
import com.apm.insight.l.j;
import com.apm.insight.l.m;
import com.apm.insight.nativecrash.NativeImpl;
import com.apm.insight.runtime.k;
import com.apm.insight.runtime.n;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;

/* JADX INFO: compiled from: CrashCatchDispatcher.java */
/* JADX INFO: loaded from: classes8.dex */
public final class a implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static a f206a;
    private static volatile boolean i;
    private static volatile ThreadLocal<Boolean> j = new ThreadLocal<>();
    private static ArrayList<b> l = new ArrayList<>();
    private Thread.UncaughtExceptionHandler b;
    private c c;
    private c d;
    private volatile int e = 0;
    private volatile int f = 0;
    private ConcurrentHashMap<String, Object> g = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, Object> h = new ConcurrentHashMap<>();
    private JSONArray k;

    private a() {
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler != this) {
            this.b = defaultUncaughtExceptionHandler;
            Thread.setDefaultUncaughtExceptionHandler(this);
        }
    }

    public static a a() {
        if (f206a == null) {
            f206a = new a();
        }
        return f206a;
    }

    public final void a(c cVar) {
        this.c = cVar;
    }

    public final void b(c cVar) {
        this.d = cVar;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        do {
            th = a(thread, th);
        } while (th != null);
    }

    /* JADX WARN: Code duplicated, block: B:107:0x01d7 A[Catch: all -> 0x0204, TRY_LEAVE, TryCatch #2 {all -> 0x0204, blocks: (B:105:0x01d1, B:107:0x01d7), top: B:147:0x01d1 }] */
    /* JADX WARN: Code duplicated, block: B:109:0x01dc  */
    /* JADX WARN: Code duplicated, block: B:110:0x01de A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:116:0x01f0  */
    /* JADX WARN: Code duplicated, block: B:143:0x01f1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:164:0x01ac A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:24:0x0067  */
    /* JADX WARN: Code duplicated, block: B:83:0x0192  */
    /* JADX WARN: Code duplicated, block: B:90:0x01ab  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v18, types: [int] */
    /* JADX WARN: Type inference failed for: r0v20, types: [int] */
    /* JADX WARN: Type inference failed for: r0v24, types: [int] */
    /* JADX WARN: Type inference failed for: r0v26, types: [int] */
    /* JADX WARN: Type inference failed for: r0v41, types: [int] */
    /* JADX WARN: Type inference failed for: r0v43, types: [int] */
    /* JADX WARN: Type inference failed for: r20v0, types: [com.apm.insight.g.a] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v20, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v35 */
    /* JADX WARN: Type inference failed for: r2v36 */
    /* JADX WARN: Type inference failed for: r2v37 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [int] */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v19 */
    /* JADX WARN: Type inference failed for: r4v20 */
    /* JADX WARN: Type inference failed for: r4v21, types: [int] */
    /* JADX WARN: Type inference failed for: r4v23 */
    /* JADX WARN: Type inference failed for: r4v24 */
    /* JADX WARN: Type inference failed for: r4v25, types: [boolean] */
    /* JADX WARN: Type inference failed for: r4v29 */
    /* JADX WARN: Type inference failed for: r4v30 */
    /* JADX WARN: Type inference failed for: r4v31 */
    /* JADX WARN: Type inference failed for: r4v32 */
    /* JADX WARN: Type inference failed for: r4v33 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1, types: [long] */
    /* JADX WARN: Type inference failed for: r5v10, types: [long] */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v13, types: [long] */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v16 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9, types: [long] */
    /* JADX WARN: Type inference failed for: r8v0, types: [com.apm.insight.g.c] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private Throwable a(Thread thread, Throwable th) {
        boolean zC;
        boolean z;
        CrashType crashType;
        ?? r2;
        ?? r5;
        ?? r4;
        boolean z2;
        ?? ValueOf;
        ?? r6;
        String strA;
        c cVar;
        boolean z3;
        if (this.e >= 3) {
            return null;
        }
        this.e++;
        this.f++;
        if (i) {
            j.set(Boolean.TRUE);
        }
        i = true;
        long jCurrentTimeMillis = System.currentTimeMillis();
        boolean z4 = false;
        boolean z5 = (com.apm.insight.runtime.a.b.c() == -1 || jCurrentTimeMillis - com.apm.insight.runtime.a.b.c() <= e.i().getLaunchCrashInterval()) && !(e.n() && e.q() == 0);
        try {
            zC = m.c(th);
            if (zC) {
                try {
                    if (m.d(th)) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                } catch (Throwable unused) {
                    z = false;
                }
            } else {
                z3 = false;
            }
            z = z3;
        } catch (Throwable unused2) {
            zC = false;
        }
        try {
            if (z5) {
                try {
                    crashType = CrashType.LAUNCH;
                } catch (Throwable th2) {
                    th = th2;
                    z2 = false;
                    r2 = z;
                    r5 = jCurrentTimeMillis;
                    r4 = 1;
                    try {
                        if (!m.c(th)) {
                            com.apm.insight.a.a(th);
                        }
                        if (z4) {
                            synchronized (this) {
                                this.f -= r4;
                                this.e -= r4;
                                return g();
                            }
                        }
                        if (r2 != 0) {
                            a(thread, th, z5, r5);
                        }
                        e();
                        d();
                        c(thread, th);
                        return null;
                    } catch (Throwable th3) {
                        if (z4) {
                            synchronized (this) {
                                this.f -= r4;
                                this.e -= r4;
                                return g();
                            }
                        }
                        if (r2 != 0 && !z2) {
                            try {
                                a(thread, th, z5, r5);
                            } catch (Throwable unused3) {
                                throw th3;
                            }
                        }
                        e();
                        d();
                        c(thread, th);
                        throw th3;
                    }
                }
            } else {
                try {
                    crashType = CrashType.JAVA;
                } catch (Throwable th4) {
                    th = th4;
                    r2 = z;
                    r5 = jCurrentTimeMillis;
                    r4 = 1;
                    z2 = false;
                    if (!m.c(th)) {
                        com.apm.insight.a.a(th);
                    }
                    if (z4) {
                        synchronized (this) {
                            this.f -= r4;
                            this.e -= r4;
                        }
                        return g();
                    }
                    if (r2 != 0 && !z2) {
                        a(thread, th, z5, r5);
                    }
                    e();
                    d();
                    c(thread, th);
                    return null;
                }
            }
            String strA2 = e.a(jCurrentTimeMillis, crashType, zC, false);
            File file = new File(j.a(e.g()), strA2);
            ?? r7 = "logEventStack";
            String strA3 = a(new File(file, "logEventStack"), th, thread, z);
            boolean z6 = (f() & 1) != 0 || (strA3 != null && e.i().isCrashIgnored(strA3));
            try {
                JSONArray jSONArrayA = com.apm.insight.entity.b.a(th, thread, file);
                this.k = jSONArrayA;
                if (jSONArrayA == null || z6) {
                    try {
                        strA = e.a(jCurrentTimeMillis, z5 ? CrashType.LAUNCH : CrashType.JAVA, zC, true);
                        File file2 = new File(j.a(e.g()), strA);
                        file.renameTo(file2);
                        new File(file2, "logEventStack");
                        r6 = "logEventStack";
                    } catch (Throwable th5) {
                        th = th5;
                        z2 = false;
                        ValueOf = z;
                        r7 = jCurrentTimeMillis;
                        r6 = 1;
                        z4 = z6;
                        r2 = ValueOf;
                        r4 = r6;
                        r5 = r7;
                        if (!m.c(th)) {
                            com.apm.insight.a.a(th);
                        }
                        if (z4) {
                            synchronized (this) {
                                this.f -= r4;
                                this.e -= r4;
                                return g();
                            }
                        }
                        if (r2 != 0) {
                            a(thread, th, z5, r5);
                        }
                        e();
                        d();
                        c(thread, th);
                        return null;
                    }
                } else {
                    strA = strA2;
                    r6 = jSONArrayA;
                }
                com.apm.insight.a.d();
                com.apm.insight.k.b.a().b();
                z2 = com.apm.insight.runtime.a.a("exception_modules", "oom_callback") == 1;
                if (z && z2) {
                    r6 = z5;
                    r7 = jCurrentTimeMillis;
                    try {
                        a(thread, th, r6, r7);
                    } catch (Throwable th6) {
                        th = th6;
                        ValueOf = z;
                        r7 = jCurrentTimeMillis;
                        r6 = 1;
                        z4 = z6;
                        r2 = ValueOf;
                        r4 = r6;
                        r5 = r7;
                        if (!m.c(th)) {
                            com.apm.insight.a.a(th);
                        }
                        if (z4) {
                            synchronized (this) {
                                this.f -= r4;
                                this.e -= r4;
                                return g();
                            }
                        }
                        if (r2 != 0) {
                            a(thread, th, z5, r5);
                        }
                        e();
                        d();
                        c(thread, th);
                        return null;
                    }
                }
                if (z5) {
                    CrashType crashType2 = CrashType.LAUNCH;
                } else {
                    CrashType crashType3 = CrashType.JAVA;
                }
                ValueOf = String.valueOf(z5);
                com.apm.insight.a.a((Object) "[uncaughtException] isLaunchCrash=".concat(ValueOf));
                com.apm.insight.a.a.a();
                boolean zB = b(thread, th);
                try {
                    if (!zB || (cVar = this.c) == null || !z5) {
                        ValueOf = z;
                        r7 = jCurrentTimeMillis;
                        r6 = 1;
                        if (zB) {
                            ?? r8 = this.d;
                            if (r8 != 0) {
                                ValueOf = ValueOf;
                                r6 = r6;
                                r7 = r7;
                                r8.a(r7, thread, th, strA, strA3, z6);
                                com.apm.insight.a.a((Object) ("[uncaughtException] mLaunchCrashDisposer " + th.toString()));
                                ValueOf = ValueOf;
                                r6 = r6;
                                r7 = r7;
                            }
                        }
                        if (!z6) {
                            synchronized (this) {
                                this.f -= r6;
                                this.e -= r6;
                            }
                            return g();
                        }
                        if (ValueOf != 0 && !z2) {
                            a(thread, th, z5, r7);
                        }
                        e();
                        d();
                        c(thread, th);
                        return null;
                    }
                    ValueOf = z;
                    r7 = jCurrentTimeMillis;
                    r6 = 1;
                    cVar.a(jCurrentTimeMillis, thread, th, strA, strA3, z6);
                    com.apm.insight.a.a((Object) ("[uncaughtException] mLaunchCrashDisposer " + th.toString()));
                    ValueOf = ValueOf;
                    r6 = r6;
                    r7 = r7;
                    if (!z6) {
                        synchronized (this) {
                            this.f -= r6;
                            this.e -= r6;
                            return g();
                        }
                    }
                    if (ValueOf != 0) {
                        a(thread, th, z5, r7);
                    }
                    e();
                    d();
                    c(thread, th);
                    return null;
                } catch (Throwable th7) {
                    th = th7;
                    z4 = z6;
                    r2 = ValueOf;
                    r4 = r6;
                    r5 = r7;
                    if (!m.c(th)) {
                        com.apm.insight.a.a(th);
                    }
                    if (z4) {
                        synchronized (this) {
                            this.f -= r4;
                            this.e -= r4;
                            return g();
                        }
                    }
                    if (r2 != 0) {
                        a(thread, th, z5, r5);
                    }
                    e();
                }
            } catch (Throwable th8) {
                th = th8;
                ValueOf = z;
                r7 = jCurrentTimeMillis;
                r6 = 1;
                z2 = false;
            }
        } catch (Throwable unused4) {
        }
    }

    private void d() {
        synchronized (this) {
            this.f--;
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        while (this.f != 0 && SystemClock.uptimeMillis() - jUptimeMillis < 10000) {
            SystemClock.sleep(50L);
        }
    }

    private static void e() {
        File fileA = j.a(e.g());
        File fileA2 = j.a();
        if (f.b(fileA) && f.b(fileA2)) {
            return;
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        while (!h.a() && SystemClock.uptimeMillis() - jUptimeMillis < 10000) {
            try {
                SystemClock.sleep(500L);
            } catch (Throwable unused) {
            }
        }
    }

    private String a(File file, Throwable th, Thread thread, boolean z) {
        String absolutePath = file.getAbsolutePath();
        this.h.put(file.getName(), file);
        try {
            file.getParentFile().mkdirs();
            file.createNewFile();
            NativeImpl.c(absolutePath);
        } catch (Throwable unused) {
        }
        String strA = null;
        if (z) {
            int iH = NativeImpl.h(absolutePath);
            if (iH > 0) {
                try {
                    NativeImpl.a(iH, com.apm.insight.l.a.d(e.g()));
                    NativeImpl.a(iH, "\n");
                    NativeImpl.a(iH, th.getMessage());
                    NativeImpl.a(iH, "\n");
                    NativeImpl.a(iH, th.getClass().getName());
                    if (th.getMessage() != null) {
                        NativeImpl.a(iH, ": ");
                        NativeImpl.a(iH, th.getMessage());
                    }
                    NativeImpl.a(iH, "\n");
                    NativeImpl.a(iH, thread.getName());
                    NativeImpl.a(iH, "\n");
                } catch (Throwable unused2) {
                }
                try {
                    NativeImpl.a(iH, "stack:");
                    NativeImpl.a(iH, "\n");
                } catch (Throwable unused3) {
                }
                m.a(th, iH);
                NativeImpl.b(iH);
            }
        } else {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file, true);
                try {
                    fileOutputStream.write((com.apm.insight.l.a.d(e.g()) + "\n").getBytes());
                    fileOutputStream.write((th.getMessage() + "\n").getBytes());
                    fileOutputStream.write((th + "\n").getBytes());
                    fileOutputStream.write((thread.getName() + "\n").getBytes());
                } catch (Throwable unused4) {
                }
                try {
                    fileOutputStream.write("stack:\n".getBytes());
                } catch (Throwable unused5) {
                }
                try {
                    strA = m.a(th, new PrintStream(fileOutputStream), Looper.getMainLooper() == Looper.myLooper() ? new com.apm.insight.l.e.a() { // from class: com.apm.insight.g.a.1

                        /* JADX INFO: renamed from: a, reason: collision with root package name */
                        private boolean f207a = false;

                        @Override // com.apm.insight.l.e.a
                        public final boolean a(String str) {
                            if (!this.f207a && str.contains("android.os.Looper.loop")) {
                                this.f207a = true;
                            }
                            return !this.f207a;
                        }
                    } : new com.apm.insight.l.e.a());
                    com.apm.insight.a.a((Closeable) fileOutputStream);
                } catch (Throwable th2) {
                    try {
                        th.printStackTrace(new PrintStream(fileOutputStream));
                    } catch (Throwable th3) {
                        try {
                            fileOutputStream.write("err:\n".getBytes());
                            fileOutputStream.write((th2 + "\n").getBytes());
                            fileOutputStream.write((th3 + "\n").getBytes());
                        } catch (Throwable unused6) {
                        }
                    }
                }
                com.apm.insight.a.a((Closeable) fileOutputStream);
            } catch (Throwable unused7) {
            }
        }
        return strA;
    }

    private static boolean b(Thread thread, Throwable th) {
        ICrashFilter iCrashFilterB = e.b().b();
        if (iCrashFilterB != null) {
            try {
                if (!iCrashFilterB.onJavaCrashFilter(th, thread)) {
                    return false;
                }
            } catch (Throwable unused) {
            }
        }
        return true;
    }

    public final void a(Thread thread, Throwable th, boolean z, com.apm.insight.entity.a aVar) {
        List<ICrashCallback> listC;
        CrashType crashType;
        if (z) {
            listC = com.apm.insight.runtime.m.a().b();
            crashType = CrashType.LAUNCH;
        } else {
            listC = com.apm.insight.runtime.m.a().c();
            crashType = CrashType.JAVA;
        }
        for (ICrashCallback iCrashCallback : listC) {
            long jUptimeMillis = SystemClock.uptimeMillis();
            try {
                if (iCrashCallback instanceof com.apm.insight.b) {
                    ((com.apm.insight.b) iCrashCallback).a(crashType, m.a(th), thread, this.k);
                } else {
                    iCrashCallback.onCrash(crashType, m.a(th), thread);
                }
                aVar.b("callback_cost_" + iCrashCallback.getClass().getName(), String.valueOf(SystemClock.uptimeMillis() - jUptimeMillis));
            } catch (Throwable th2) {
                com.apm.insight.a.b(th2);
                aVar.b("callback_err_" + iCrashCallback.getClass().getName(), String.valueOf(SystemClock.uptimeMillis() - jUptimeMillis));
            }
        }
    }

    private void a(Thread thread, Throwable th, boolean z, long j2) {
        List<IOOMCallback> listA = com.apm.insight.runtime.m.a().a();
        CrashType crashType = z ? CrashType.LAUNCH : CrashType.JAVA;
        for (IOOMCallback iOOMCallback : listA) {
            try {
                if (iOOMCallback instanceof com.apm.insight.b) {
                    ((com.apm.insight.b) iOOMCallback).a(crashType, th, thread, j2, this.k);
                } else {
                    iOOMCallback.onCrash(crashType, th, thread, j2);
                }
            } catch (Throwable th2) {
                com.apm.insight.a.b(th2);
            }
        }
    }

    private void c(Thread thread, Throwable th) {
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.b;
        if (uncaughtExceptionHandler == null || uncaughtExceptionHandler == this) {
            return;
        }
        uncaughtExceptionHandler.uncaughtException(thread, th);
    }

    public final void a(String str) {
        this.g.put(str, new Object());
    }

    public final boolean b(String str) {
        return this.g.containsKey(str);
    }

    public static void a(final Throwable th) {
        if (th == null) {
            return;
        }
        try {
            n.a().a(new Runnable() { // from class: com.apm.insight.g.a.2
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        com.apm.insight.entity.a aVarA = com.apm.insight.entity.a.a(System.currentTimeMillis(), e.g(), th);
                        aVarA.a("userdefine", (Object) 1);
                        com.apm.insight.entity.a aVarA2 = com.apm.insight.runtime.a.f.a().a(CrashType.CUSTOM_JAVA, aVarA);
                        if (aVarA2 != null) {
                            com.apm.insight.k.d.a().c(aVarA2.c());
                        }
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    public static void c(final String str) {
        if (str == null) {
            return;
        }
        try {
            n.a().a(new Runnable() { // from class: com.apm.insight.g.a.3
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        com.apm.insight.entity.a aVar = new com.apm.insight.entity.a();
                        aVar.a("data", (Object) str);
                        aVar.a("userdefine", (Object) 1);
                        com.apm.insight.entity.a aVarA = com.apm.insight.runtime.a.f.a().a(CrashType.CUSTOM_JAVA, aVar);
                        if (aVarA != null) {
                            com.apm.insight.k.d.a().c(aVarA.c());
                        }
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    public static boolean b() {
        return i;
    }

    public static boolean c() {
        Boolean bool = j.get();
        return bool != null && bool.booleanValue();
    }

    private static int f() {
        int iA = 0;
        for (int i2 = 0; i2 < l.size(); i2++) {
            try {
                try {
                    iA |= l.get(i2).a();
                } catch (Throwable th) {
                    com.apm.insight.c.a();
                    k.a(th, "NPTH_CATCH");
                }
            } catch (Throwable unused) {
            }
        }
        return iA;
    }

    private static Throwable g() {
        for (int i2 = 0; i2 < l.size(); i2++) {
            try {
                l.get(i2);
            } catch (Throwable unused) {
            }
        }
        if (Looper.getMainLooper() != Looper.myLooper()) {
            return null;
        }
        try {
            Looper.loop();
            return null;
        } catch (Throwable th) {
            return th;
        }
    }
}
