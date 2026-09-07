package com.yandex.mobile.ads.impl;

import android.os.ConditionVariable;
import java.io.File;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes13.dex */
public final class fy1 implements rm {
    private static final HashSet<File> j = new HashSet<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final File f8952a;
    private final ym b;
    private final jn c;
    private final an d;
    private final HashMap<String, ArrayList<rm.b>> e;
    private final Random f;
    private final boolean g;
    private long h;
    private rm.a i;

    fy1(File file, kr0 kr0Var, jn jnVar, an anVar) {
        if (!c(file)) {
            throw new IllegalStateException("Another SimpleCache instance uses the folder: " + file);
        }
        this.f8952a = file;
        this.b = kr0Var;
        this.c = jnVar;
        this.d = anVar;
        this.e = new HashMap<>();
        this.f = new Random();
        this.g = true;
        this.h = -1L;
        ConditionVariable conditionVariable = new ConditionVariable();
        new ey1(this, conditionVariable).start();
        conditionVariable.block();
    }

    public final synchronized TreeSet c(String str) {
        in inVarA;
        inVarA = this.c.a(str);
        return (inVarA == null || inVarA.c()) ? new TreeSet() : new TreeSet((Collection) inVarA.b());
    }

    public fy1(File file, kr0 kr0Var, h60 h60Var) {
        this(file, kr0Var, new jn(h60Var, file), new an(h60Var));
    }

    @Override // com.yandex.mobile.ads.impl.rm
    public final synchronized en e(String str, long j2, long j3) throws InterruptedException, rm.a {
        en enVarC;
        a();
        while (true) {
            enVarC = c(str, j2, j3);
            if (enVarC == null) {
                wait();
            }
        }
        return enVarC;
    }

    @Override // com.yandex.mobile.ads.impl.rm
    public final synchronized long d(String str, long j2, long j3) {
        in inVarA;
        if (j3 == -1) {
            j3 = Long.MAX_VALUE;
        }
        inVarA = this.c.a(str);
        return inVarA != null ? inVarA.a(j2, j3) : -j3;
    }

    @Override // com.yandex.mobile.ads.impl.rm
    public final synchronized long b(String str, long j2, long j3) {
        long j4;
        long j5 = j3 == -1 ? Long.MAX_VALUE : j2 + j3;
        long j6 = j5 < 0 ? Long.MAX_VALUE : j5;
        long j7 = j2;
        j4 = 0;
        while (j7 < j6) {
            long jD = d(str, j7, j6 - j7);
            if (jD > 0) {
                j4 += jD;
            } else {
                jD = -jD;
            }
            j7 += jD;
        }
        return j4;
    }

    @Override // com.yandex.mobile.ads.impl.rm
    public final synchronized kz b(String str) {
        return this.c.b(str);
    }

    private void a(hy1 hy1Var) {
        this.c.c(hy1Var.b).a(hy1Var);
        ArrayList<rm.b> arrayList = this.e.get(hy1Var.b);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                arrayList.get(size).a(this, hy1Var);
            }
        }
        this.b.a(this, hy1Var);
    }

    private void c(en enVar) {
        in inVarA = this.c.a(enVar.b);
        if (inVarA == null || !inVarA.a(enVar)) {
            return;
        }
        if (this.d != null) {
            String name = enVar.f.getName();
            try {
                this.d.a(name);
            } catch (IOException unused) {
                nv0.a("Failed to remove file index entry for: ", name, "SimpleCache");
            }
        }
        this.c.d(inVarA.b);
        ArrayList<rm.b> arrayList = this.e.get(enVar.b);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                arrayList.get(size).a(enVar);
            }
        }
        this.b.a(enVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        long j2;
        if (!this.f8952a.exists()) {
            try {
                a(this.f8952a);
            } catch (rm.a e) {
                this.i = e;
                return;
            }
        }
        File[] fileArrListFiles = this.f8952a.listFiles();
        if (fileArrListFiles == null) {
            String str = "Failed to list cache directory files: " + this.f8952a;
            at0.b("SimpleCache", str);
            this.i = new rm.a(str);
            return;
        }
        int length = fileArrListFiles.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                j2 = -1;
                break;
            }
            File file = fileArrListFiles[i];
            String name = file.getName();
            if (name.endsWith(".uid")) {
                try {
                    j2 = Long.parseLong(name.substring(0, name.indexOf(46)), 16);
                    break;
                } catch (NumberFormatException unused) {
                    at0.b("SimpleCache", "Malformed UID file: " + file);
                    file.delete();
                }
            }
            i++;
        }
        this.h = j2;
        if (j2 == -1) {
            try {
                this.h = b(this.f8952a);
            } catch (IOException e2) {
                String str2 = "Failed to create cache UID: " + this.f8952a;
                at0.a("SimpleCache", str2, e2);
                this.i = new rm.a(str2, e2);
                return;
            }
        }
        try {
            this.c.a(this.h);
            an anVar = this.d;
            if (anVar != null) {
                anVar.a(this.h);
                HashMap mapA = this.d.a();
                a(this.f8952a, true, fileArrListFiles, mapA);
                this.d.a(mapA.keySet());
            } else {
                a(this.f8952a, true, fileArrListFiles, null);
            }
            this.c.b();
            try {
                this.c.c();
            } catch (Throwable th) {
                at0.a("SimpleCache", "Storing index file failed", th);
            }
        } catch (Throwable th2) {
            String str3 = "Failed to initialize cache indices: " + this.f8952a;
            at0.a("SimpleCache", str3, th2);
            this.i = new rm.a(str3, th2);
        }
    }

    @Override // com.yandex.mobile.ads.impl.rm
    public final synchronized void a(String str, bs bsVar) throws rm.a {
        a();
        this.c.a(str, bsVar);
        try {
            this.c.c();
        } catch (Throwable th) {
            throw new rm.a(th);
        }
    }

    public final synchronized void a() throws rm.a {
        rm.a aVar = this.i;
        if (aVar != null) {
            throw aVar;
        }
    }

    @Override // com.yandex.mobile.ads.impl.rm
    public final synchronized void b(en enVar) {
        in inVarA = this.c.a(enVar.b);
        inVarA.getClass();
        inVarA.a(enVar.c);
        this.c.d(inVarA.b);
        notifyAll();
    }

    private static long b(File file) throws IOException {
        long jNextLong = new SecureRandom().nextLong();
        long jAbs = jNextLong == Long.MIN_VALUE ? 0L : Math.abs(jNextLong);
        File file2 = new File(file, Long.toString(jAbs, 16) + ".uid");
        if (file2.createNewFile()) {
            return jAbs;
        }
        throw new IOException("Failed to create UID file: " + file2);
    }

    @Override // com.yandex.mobile.ads.impl.rm
    public final synchronized void a(File file, long j2) throws rm.a {
        if (file.exists()) {
            if (j2 == 0) {
                file.delete();
                return;
            }
            hy1 hy1VarA = hy1.a(file, j2, -9223372036854775807L, this.c);
            hy1VarA.getClass();
            in inVarA = this.c.a(hy1VarA.b);
            inVarA.getClass();
            if (inVarA.c(hy1VarA.c, hy1VarA.d)) {
                long jB = inVarA.a().b();
                if (jB != -1 && hy1VarA.c + hy1VarA.d > jB) {
                    throw new IllegalStateException();
                }
                if (this.d != null) {
                    try {
                        this.d.a(file.getName(), hy1VarA.d, hy1VarA.g);
                        a(hy1VarA);
                        try {
                            this.c.c();
                            notifyAll();
                            return;
                        } catch (Throwable th) {
                            throw new rm.a(th);
                        }
                    } catch (IOException e) {
                        throw new rm.a(e);
                    }
                }
                a(hy1VarA);
                this.c.c();
                notifyAll();
                return;
                throw th;
            }
            throw new IllegalStateException();
        }
    }

    private void c() {
        ArrayList arrayList = new ArrayList();
        Iterator<in> it = this.c.a().iterator();
        while (it.hasNext()) {
            for (hy1 hy1Var : it.next().b()) {
                if (hy1Var.f.length() != hy1Var.d) {
                    arrayList.add(hy1Var);
                }
            }
        }
        for (int i = 0; i < arrayList.size(); i++) {
            c((en) arrayList.get(i));
        }
    }

    @Override // com.yandex.mobile.ads.impl.rm
    public final synchronized en c(String str, long j2, long j3) throws rm.a {
        hy1 hy1VarB;
        hy1 hy1VarA;
        boolean z;
        try {
            a();
            in inVarA = this.c.a(str);
            if (inVarA == null) {
                hy1VarA = hy1.a(str, j2, j3);
            } else {
                while (true) {
                    hy1VarB = inVarA.b(j2, j3);
                    if (!hy1VarB.e || hy1VarB.f.length() == hy1VarB.d) {
                        break;
                    }
                    c();
                }
                hy1VarA = hy1VarB;
            }
            if (hy1VarA.e) {
                if (this.g) {
                    File file = hy1VarA.f;
                    file.getClass();
                    String name = file.getName();
                    long j4 = hy1VarA.d;
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    an anVar = this.d;
                    if (anVar != null) {
                        try {
                            anVar.a(name, j4, jCurrentTimeMillis);
                        } catch (IOException unused) {
                            at0.d("SimpleCache", "Failed to update index with new touch timestamp.");
                        }
                        z = false;
                    } else {
                        z = true;
                    }
                    hy1 hy1VarA2 = this.c.a(str).a(hy1VarA, jCurrentTimeMillis, z);
                    ArrayList<rm.b> arrayList = this.e.get(hy1VarA.b);
                    if (arrayList != null) {
                        for (int size = arrayList.size() - 1; size >= 0; size--) {
                            arrayList.get(size).a(this, hy1VarA, hy1VarA2);
                        }
                    }
                    this.b.a(this, hy1VarA, hy1VarA2);
                    hy1VarA = hy1VarA2;
                }
                return hy1VarA;
            }
            if (this.c.c(str).d(j2, hy1VarA.d)) {
                return hy1VarA;
            }
            return null;
        } catch (Throwable th) {
            throw th;
        }
    }

    private static synchronized boolean c(File file) {
        return j.add(file.getAbsoluteFile());
    }

    private static void a(File file) throws rm.a {
        if (file.mkdirs() || file.isDirectory()) {
            return;
        }
        String str = "Failed to create cache directory: " + file;
        at0.b("SimpleCache", str);
        throw new rm.a(str);
    }

    private void a(File file, boolean z, File[] fileArr, HashMap map) {
        long j2;
        long j3;
        if (fileArr == null || fileArr.length == 0) {
            if (z) {
                return;
            }
            file.delete();
            return;
        }
        for (File file2 : fileArr) {
            String name = file2.getName();
            if (z && name.indexOf(46) == -1) {
                a(file2, false, file2.listFiles(), map);
            } else if (!z || (!name.startsWith("monetization_cached_content_index.exi") && !name.endsWith(".uid"))) {
                zm zmVar = map != null ? (zm) map.remove(name) : null;
                if (zmVar != null) {
                    j3 = zmVar.f10827a;
                    j2 = zmVar.b;
                } else {
                    j2 = -9223372036854775807L;
                    j3 = -1;
                }
                hy1 hy1VarA = hy1.a(file2, j3, j2, this.c);
                if (hy1VarA != null) {
                    a(hy1VarA);
                } else {
                    file2.delete();
                }
            }
        }
    }

    @Override // com.yandex.mobile.ads.impl.rm
    public final synchronized void a(String str) {
        Iterator it = c(str).iterator();
        while (it.hasNext()) {
            c((en) it.next());
        }
    }

    @Override // com.yandex.mobile.ads.impl.rm
    public final synchronized void a(en enVar) {
        c(enVar);
    }

    @Override // com.yandex.mobile.ads.impl.rm
    public final synchronized File a(String str, long j2, long j3) throws rm.a {
        File file;
        long jCurrentTimeMillis;
        int i;
        a();
        in inVarA = this.c.a(str);
        inVarA.getClass();
        if (inVarA.c(j2, j3)) {
            if (!this.f8952a.exists()) {
                a(this.f8952a);
                c();
            }
            this.b.a(this, j3);
            file = new File(this.f8952a, Integer.toString(this.f.nextInt(10)));
            if (!file.exists()) {
                a(file);
            }
            jCurrentTimeMillis = System.currentTimeMillis();
            i = inVarA.f9245a;
            int i2 = hy1.k;
        } else {
            throw new IllegalStateException();
        }
        return new File(file, i + "." + j2 + "." + jCurrentTimeMillis + ".v3.exo");
    }
}
