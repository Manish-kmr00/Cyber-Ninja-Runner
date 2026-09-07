package com.chartboost.sdk.impl;

import com.chartboost.sdk.internal.Model.CBError;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public class g4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f1026a;
    public final g2 b;
    public final h2 c;
    public final AtomicReference<o9> d;
    public final ba e;
    public final f5 f;
    public int g = 1;
    public i1 h = null;
    public final PriorityQueue<h1> i = new PriorityQueue<>();
    public final l4 j;

    public g4(Executor executor, f5 f5Var, g2 g2Var, h2 h2Var, AtomicReference<o9> atomicReference, ba baVar, l4 l4Var) {
        this.f1026a = executor;
        this.f = f5Var;
        this.b = g2Var;
        this.c = h2Var;
        this.d = atomicReference;
        this.e = baVar;
        this.j = l4Var;
    }

    public synchronized void a(AtomicInteger atomicInteger) {
        atomicInteger.set(-10000);
        if (this.g == 2) {
            i1 i1Var = this.h;
            if (i1Var.m.g == atomicInteger && i1Var.b()) {
                this.h = null;
                d();
            }
        }
    }

    public synchronized void c() {
        int i = this.g;
        if (i == 3) {
            b7.a("Change state to DOWNLOADING", null);
            this.g = 2;
        } else if (i == 4) {
            b7.a("Change state to IDLE", null);
            this.g = 1;
            d();
        }
    }

    public synchronized void a(k8 k8Var, Map<String, c1> map, AtomicInteger atomicInteger, d1 d1Var, String str) {
        AtomicInteger atomicInteger2 = new AtomicInteger();
        AtomicReference atomicReference = new AtomicReference(d1Var);
        for (c1 c1Var : map.values()) {
            this.i.add(new h1(k8Var, c1Var.b, c1Var.c, c1Var.f983a, atomicInteger, atomicReference, atomicInteger2, str));
        }
        int i = this.g;
        if (i == 1 || i == 2) {
            d();
        }
    }

    public final void d() {
        h1 h1VarPoll;
        h1 h1VarPeek;
        if (this.h != null && (h1VarPeek = this.i.peek()) != null && this.h.m.b.getValue() > h1VarPeek.b.getValue() && this.h.b()) {
            this.i.add(this.h.m);
            this.h = null;
        }
        while (this.h == null && (h1VarPoll = this.i.poll()) != null) {
            if (h1VarPoll.g.get() > 0) {
                File file = new File(this.f.a().f1027a, h1VarPoll.e);
                if (!file.exists() && !file.mkdirs() && !file.isDirectory()) {
                    b7.b("Unable to create directory " + file.getPath(), null);
                    h1VarPoll.a(this.f1026a, false);
                } else {
                    File file2 = new File(file, h1VarPoll.c);
                    if (file2.exists()) {
                        this.f.d(file2);
                        h1VarPoll.a(this.f1026a, true);
                    } else {
                        i1 i1Var = new i1(this, this.c, h1VarPoll, file2, this.b.getAppId());
                        this.h = i1Var;
                        this.b.a(i1Var);
                    }
                }
            }
        }
        if (this.h != null) {
            if (this.g != 2) {
                b7.a("Change state to DOWNLOADING", null);
                this.g = 2;
                return;
            }
            return;
        }
        if (this.g != 1) {
            b7.a("Change state to IDLE", null);
            this.g = 1;
        }
    }

    /* JADX WARN: Code duplicated, block: B:60:0x0147 A[PHI: r9
  0x0147: PHI (r9v6 long) = (r9v3 long), (r9v2 long) binds: [B:64:0x016f, B:58:0x0144] A[DONT_GENERATE, DONT_INLINE]] */
    public synchronized void b() {
        if (this.g != 1) {
            return;
        }
        try {
            b7.a("########### Trimming the disk cache", null);
            File file = this.f.a().f1027a;
            ArrayList arrayList = new ArrayList();
            String[] list = file.list();
            if (list != null && list.length > 0) {
                for (String str : list) {
                    if (!str.equalsIgnoreCase("requests") && !str.equalsIgnoreCase("track") && !str.equalsIgnoreCase("session") && !str.equalsIgnoreCase("videoCompletionEvents") && !str.equalsIgnoreCase("precache") && !str.contains(".")) {
                        arrayList.addAll(n2.a(new File(file, str), true));
                    }
                }
            }
            int size = arrayList.size();
            File[] fileArr = new File[size];
            arrayList.toArray(fileArr);
            if (size > 1) {
                Arrays.sort(fileArr, new Comparator() { // from class: com.chartboost.sdk.impl.g4$$ExternalSyntheticLambda0
                    @Override // java.util.Comparator
                    public final int compare(Object obj, Object obj2) {
                        return Long.valueOf(((File) obj).lastModified()).compareTo(Long.valueOf(((File) obj2).lastModified()));
                    }
                });
            }
            if (size > 0) {
                o9 o9Var = this.d.get();
                long j = o9Var.m;
                f5 f5Var = this.f;
                long jB = f5Var.b(f5Var.a().g);
                long jA = this.e.a();
                List<String> list2 = o9Var.d;
                b7.a("Total local file count:" + size, null);
                b7.a("Video Folder Size in bytes :" + jB, null);
                b7.a("Max Bytes allowed:" + j, null);
                int i = 0;
                while (i < size) {
                    File file2 = fileArr[i];
                    long j2 = j;
                    o9 o9Var2 = o9Var;
                    boolean z = TimeUnit.MILLISECONDS.toDays(jA - file2.lastModified()) >= ((long) o9Var.o);
                    boolean zEndsWith = file2.getName().endsWith(".tmp");
                    File parentFile = file2.getParentFile();
                    String absolutePath = parentFile != null ? parentFile.getAbsolutePath() : null;
                    boolean zContains = absolutePath != null ? absolutePath.contains("/videos") : false;
                    boolean z2 = jB > j2 && zContains;
                    if (file2.length() == 0 || zEndsWith || z || list2.contains(parentFile.getName()) || z2) {
                        if (zContains) {
                            jB -= file2.length();
                        }
                        b7.a("Deleting file at path:" + file2.getPath(), null);
                        if (!file2.delete()) {
                            b7.b("Unable to delete " + file2.getPath(), null);
                        }
                    }
                    i++;
                    o9Var = o9Var2;
                    j = j2;
                }
            }
        } catch (Exception e) {
            b7.b("reduceCacheSize", e);
        }
    }

    public synchronized void a(i1 i1Var, CBError cBError, f2 f2Var) {
        int i = this.g;
        if (i == 2 || i == 3) {
            if (i1Var != this.h) {
                return;
            }
            this.h = null;
            long millis = TimeUnit.NANOSECONDS.toMillis(i1Var.processingNs);
            h1 h1Var = i1Var.m;
            h1Var.i.addAndGet((int) millis);
            h1Var.a(this.f1026a, cBError == null);
            if (cBError == null) {
                b7.a("Downloaded " + h1Var.d, null);
            } else {
                String str = i1Var.m.f;
                String errorDesc = cBError.getErrorDesc();
                b7.a("Failed to download " + h1Var.d + (f2Var != null ? " Status code=" + f2Var.getStatusCode() : "") + " Error message=" + errorDesc, null);
                this.j.mo4741track(new j4(ma.a.ASSET_DOWNLOAD_ERROR, "Name: " + h1Var.c + " Url: " + h1Var.d + " Error: " + errorDesc, str, "", null));
            }
            if (this.g == 3) {
                b7.a("Change state to PAUSED", null);
                this.g = 4;
            } else {
                d();
            }
        }
    }

    public synchronized void a() {
        int i = this.g;
        if (i == 1) {
            b7.a("Change state to PAUSED", null);
            this.g = 4;
        } else if (i == 2) {
            if (this.h.b()) {
                this.i.add(this.h.m);
                this.h = null;
                b7.a("Change state to PAUSED", null);
                this.g = 4;
            } else {
                b7.a("Change state to PAUSING", null);
                this.g = 3;
            }
        }
    }
}
